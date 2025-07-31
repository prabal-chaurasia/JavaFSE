import React from 'react';

function BlogDetails(props) {
  return (
    <ul>
      {props.blogs.map(blog => (
        <li key={blog.id}>
          <h3>{blog.title}</h3>
          <h4>{blog.author}</h4>
          <p>{blog.content}</p>
        </li>
      ))}
    </ul>
  );
}

export default BlogDetails;