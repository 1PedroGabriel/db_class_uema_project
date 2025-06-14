import React from 'react';
import './BookCard.css';

const BookCard = ({key, book }) => {
  return (
    <div className="styled-book-card" >
      <div className="image-placeholder" />

      <div className="book-card-body">
        <h3 className="book-card-title">{book.title}</h3>
        <div className="book-card-available">
          <p>Available:</p>
          <p className="book-card-quantity">{book.availableQuantity} / {book.quantity}</p>
        </div>
       
        <p className="book-card-author">by {book.authors}</p>
        <p className="book-card-publisher">{book.publisher}, {book.publicationYear}</p>
        <p className="book-card-language">{book.language} • {book.pages} páginas</p>
        <p className="book-card-summary">{book.summary}</p>

        <div className="book-card-buttons">
          <button className="outline-button">Ver detalhes</button>
          <button className="primary-button">Emprestar</button>
        </div>
      </div>
    </div>
  );
};

export default BookCard;
