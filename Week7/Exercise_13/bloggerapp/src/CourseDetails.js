import React from 'react';

function CourseDetails(props) {
  return (
    <ul>
      {props.courses.map(course => (
        <li key={course.id}>
          <h3>{course.cname}</h3>
          <h4>{course.date}</h4>
        </li>
      ))}
    </ul>
  );
}

export default CourseDetails;