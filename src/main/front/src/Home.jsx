import { useState, useEffect} from 'react'
import BookCard from './BooksCard';
import AppButton from './Button';

import './Home.css'
import DashboardTitle from './DashboardTitle';
import BookFilters from './BookFilters';

export default function Home() {

  const [books, setBooks] = useState([]);

  useEffect(() => {
  fetch('http://localhost:8080/book/list-all')
    .then(response => response.json()) // ✅ Extrai o JSON
    .then(data => {
      setBooks(data); // ✅ Agora sim são os dados de verdade
      console.log(data)
    })
    .catch(error => {
      console.error('Erro ao buscar dados:', error);
    });
}, []);

  return (
    <>
      <div className="dashboard">
      <DashboardTitle />
      <BookFilters />
      <div className='book-grid'>
        {books.map((book, index) => (
          <BookCard  key={index} book={book}/>
        ))}
        
      </div>
      </div>
    </>
  )
}

