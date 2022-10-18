package com.example.javabackend.restcontrol;
import java.io.FileNotFoundException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.javabackend.dataModels.Courses;
import com.example.javabackend.dataModels.CoursesAndStudents;
import com.example.javabackend.dataModels.Students;
import com.example.javabackend.service.CourseService;
import com.example.javabackend.service.CoursesAndStudentsService;
import com.example.javabackend.service.StudentService;





@RestController
@CrossOrigin(origins = "*")
public class JavaBackendRestController {

    @Autowired
    StudentService studService;
    
    @Autowired 
    CourseService courseService;

    @Autowired
    CoursesAndStudentsService CoursesAndStudentsService;

    
    @GetMapping("/students")
    public List<Students> getStudents(){
            return studService.getAll();         
    }
     
     @DeleteMapping("/delete/{id}")
     public List<Students> deleteStudent(@PathVariable String id) {
         return studService.deleteObj(Integer.parseInt(id));
    }

     @PostMapping("/addstudent")
     @ResponseBody
     public List<Students> addStudent(@RequestParam String name, @RequestParam String age, @RequestParam String avg, @RequestParam String usernumber) {
        return studService.addObj(name, age, avg, usernumber);
    }

    //////////////////////////////////////////////////////////////////////////////

    @GetMapping("/courses")
    public List<Courses> getCourseList(){
            return courseService.getAll();         
    }

    @DeleteMapping("/deletecourse/{id}")
    public List<Courses> deleteCourse(@PathVariable String id) {
        return courseService.deleteObj(Integer.parseInt(id));
    }

    @PostMapping("/createcourse")
    @ResponseBody
    public List<Courses> createCourse(@RequestParam String name, @RequestParam String teacher, @RequestParam String classRoom, @RequestParam String courseID) {
       return courseService.addObj(name, teacher, classRoom, courseID);
   }

   //////////////////////////////////////////////////////////////////////////////

    @GetMapping("/coursesandstudents")
    public List<CoursesAndStudents> getAllCoursesAndStudents() {
        return CoursesAndStudentsService.getAll();
    }
    
    @PostMapping("/coursesandstudents/course/addstudent")
    @ResponseBody
    public List<Students> addStudentToCourse(@RequestParam String studentID, @RequestParam String courseID) throws FileNotFoundException {
        CoursesAndStudentsService.addObj(studentID, courseID);
       return CoursesAndStudentsService.getStudentsInCourse(studService.getAll(), courseID); 
    }
   
    @GetMapping("/coursesandstudents/student/{id}")
    public List<CoursesAndStudents> getAllCoursesAndStudentsByStudentId(@PathVariable String id) {
            List <CoursesAndStudents> filterList = CoursesAndStudentsService.getAll();
            filterList.removeIf(n -> n.getUserNumber() != Integer.parseInt(id));
        return filterList;
    }

    @GetMapping("/coursesandstudents/course/{id}")
    public List<Students> getAllCoursesAndStudentsByCourseId(@PathVariable String id) throws FileNotFoundException {
            return CoursesAndStudentsService.getStudentsInCourse(studService.getAll(), id);
    }

    @GetMapping("/coursesandstudents/course/getstudentsnotincourse/{id}")
    public List<Students> getAllStudentsNotInCourse(@PathVariable String id) {
            return CoursesAndStudentsService.getStudentsNotInCourse(studService.getAll(), CoursesAndStudentsService.getAll(), id);
    }

    @DeleteMapping("/coursesandstudents/course/{studentnumber}/{courseId}")
     public List<Students> deleteStudentsNotInCourse(@PathVariable String studentnumber, @PathVariable String courseId) {
         return CoursesAndStudentsService.deleteObj(Integer.parseInt(studentnumber), Integer.parseInt(courseId));
        }

}
