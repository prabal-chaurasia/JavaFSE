import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';
import { books, blogs, courses } from './data'; // Import data
import './App.css';

function App() {
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);
  const [showCourses, setShowCourses] = useState(true);

  // Conditional rendering using element variables
  let bookdet;
  if (showBooks) {
    bookdet = <BookDetails books={books} />;
  } else {
    bookdet = <p>Book details are hidden.</p>;
  }

  // Conditional rendering using logical && operator
  const content = showBlogs && (
    <BlogDetails blogs={blogs} />
  );

  // Conditional rendering using ternary operator
  const coursedet = showCourses ? (
    <CourseDetails courses={courses} />
  ) : (
    <p>Course details are hidden.</p>
  );

  return (
    <div className="App">
      <div className="controls">
        <button onClick={() => setShowBooks(!showBooks)}>
          {showBooks ? 'Hide Books' : 'Show Books'}
        </button>
        <button onClick={() => setShowBlogs(!showBlogs)}>
          {showBlogs ? 'Hide Blogs' : 'Show Blogs'}
        </button>
        <button onClick={() => setShowCourses(!showCourses)}>
          {showCourses ? 'Hide Courses' : 'Show Courses'}
        </button>
      </div>

      <div className="main-content">
        <div className="st2">
          <h1>Book Details</h1>
          {bookdet}
        </div>
        <div className="v1">
          <h1>Blog Details</h1>
          {content}
        </div>
        <div className="mystyle1">
          <h1>Course Details</h1>
          {coursedet}
        </div>
      </div>
    </div>
  );
}

export default App;