# Final project for Java course

<br/>


### endpoints
| Method | URL | Description | Request Body |
| :---         |     :---:      |          ---: |   ---: |
| GET          | /students       | Retrieve all students    |  |
| DELETE     | /delete/{id}       | Delete student by id      | |
| POST     | /addstudent       | Add student      | name, age, avg, usernumber|
| ---         |     ---     |          --- |    |
| GET          | /courses       | Retrieve all courses    |  |
| DELETE     | /deletecourse/{id}       | Delete course by id      | |
| POST     | /createcourse       | Create a new course      | name, teacher, classRoom, courseID|
| ---         |     ---     |          --- |    |
| GET          | /coursesandstudents       | Retrieve all courses and students    |  |
| POST     | /coursesandstudents/course/addstudent       | Add student to course      | studentID, courseID |
| GET     | /coursesandstudents/student/{id}       | Gets all courses where student {id} is enrolled in   ||
| GET     | /coursesandstudents/course/{id}       | Gets all students in {id} course   ||
| GET     | /coursesandstudents/course/getstudentsnotincourse/{id}       | Gets all students that is <Strong>not</Strong> in {id} course   ||
