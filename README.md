# 📚 Sistema de Biblioteca - MySQL

Este projeto utiliza um banco de dados MySQL para gerenciar livros, cópias, empréstimos, usuários, reservas e multas.

---

## 🔽 Como importar o banco (dump)

1. Baixe o arquivo `backup.sql` 
2. Abra o **MySQL Workbench**.
3. Vá em **Server > Data Import**.
4. Selecione **Import from Self-Contained File** e aponte para o `backup.sql`.
5. Em **Default Target Schema**, selecione ou crie um novo banco de dados.
6. Clique em **Start Import**.

---

## 🗂️ Estrutura das Tabelas (todas com suporte a CRUD via API)

### 📚 `books`
Registra informações dos livros: título, autor, ISBN, idioma, edição, número de páginas e categoria.

### 📄 `book_copies`
Cada linha representa uma cópia física de um livro. Contém código da cópia, localização na estante, status (disponível, emprestado etc.) e data de aquisição.

### 🏷️ `categories`
Lista as categorias dos livros (ex: Literatura, História, Ciência). Cada livro pertence a uma única categoria.

### 📥 `loans`
Controla os empréstimos de livros. Armazena quem pegou qual cópia, quando, e o status da devolução.

### 🕒 `reservations`
Gerencia as reservas de livros feitas pelos usuários, com controle de datas e status da reserva.

### 👩‍💼 `staff`
Armazena os dados dos funcionários da biblioteca, incluindo nome, e-mail, senha e cargo (ex: admin, bibliotecário).

### 👤 `user`
Usuários registrados no sistema. Podem realizar reservas e empréstimos. Contém nome, e-mail, status e demais dados de cadastro.

### 💰 `fines`
Registra as multas associadas a atrasos na devolução de livros. Contém o valor, status (pago ou não) e referência ao empréstimo.

---

## 🧪 Exemplos para testar

```sql
SELECT * FROM books;
SELECT * FROM book_copies WHERE status = 'available';
SELECT * FROM fines WHERE status = 'unpaid';
```

---

## ✍️ Observações

- O arquivo `backup.sql` inclui a **estrutura** e os **dados iniciais**.
- Ideal para ambientes de desenvolvimento e testes.
- Todas as tabelas possuem **endpoints REST** com suporte a **CRUD completo**.
