import React from 'react';

function BookDetails(props) {
  return (
    <ul>
      {props.books.map(book => (
        <li key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </li>
      ))}
    </ul>
  );
}

export default BookDetails;