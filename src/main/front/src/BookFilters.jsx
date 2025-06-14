import React, { useEffect, useState } from 'react';
import './BookFilters.css'; // CSS para deixar moderno

export default function BookFilters() {
  const [categorias, setCategorias] = useState([]);
  const [autores, setAutores] = useState([]);
  const [categoriaSelecionada, setCategoriaSelecionada] = useState('');
  const [autorSelecionado, setAutorSelecionado] = useState('');

  const apiUrl =  import.meta.env.VITE_API_URL;

  useEffect(() => {
    // 🔁 Altere essas URLs para sua API
    fetch(`${apiUrl}/category/list-all`)
      .then(res => res.json())
      .then(data => {setCategorias(data)})
      .catch(err => console.error('Erro ao buscar categorias:', err));

    fetch(`${apiUrl}/book/author/list-all`)
      .then(res => res.json())
      .then(data => {setAutores(data) ; console.log(data)} )
      .catch(err => console.error('Erro ao buscar autores:', err));
  }, []);

  const handleCategoriaChange = (e) => {
    setCategoriaSelecionada(e.target.value);
    console.log('Categoria:', e.target.value);
  };

  const handleAutorChange = (e) => {
    setAutorSelecionado(e.target.value);
    console.log('Autor:', e.target.value);
  };

  return (
    <div className="book-filters-container">
      <select value={categoriaSelecionada} onChange={handleCategoriaChange} className="select-modern">
        <option value="">Escolha a categoria</option>
        {categorias.map((cat, idx) => (
          <option key={idx} value={cat.id || cat.name}>{cat.name}</option>
        ))}
      </select>

      <select value={autorSelecionado} onChange={handleAutorChange} className="select-modern">
        <option value="">Escolha o autor</option>
        {autores.map((autor, idx) => (
          <option key={idx} value={autor}>{autor}</option>
        ))}
      </select>
    </div>
  );
}
