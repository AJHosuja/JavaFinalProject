# Final project for Java course
This github repository was made for the last project of the java course.
This github repository has a frontend and a backend.

## Backend
Backend is Java Spring boot application.
It runs on localhost:8080/ by default.

### How to run?
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.


## Frontend
Frontend is made with React.js, Bootstarp and TailwindCSS

### How to run?
Cloning and Running the Application in local
Clone the project into local

Install all the npm packages. Go into the project folder and type the following command to install all npm packages
````
npm install
````
In order to run the application Type the following command
````
npm start
````
The Application Runs on localhost:3000


## Endpoints
List of all endpoints.

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
| DELETE  | /coursesandstudents/course/{studentnumber}/{courseId}        | Delete student {studentnumber} from course {courseID}  ||



