package com.example.javabackend.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.javabackend.dataModels.Courses;

@Service
public class CourseService extends FileWriteAndReadService implements CourseServiceInterFace{

    private List<Courses> courseList = new ArrayList<>();
    
    public CourseService() throws IOException {
        this.courseList = FileWriteAndReadService.getAllCourses();
    }
    
    @Override
    public List<Courses> getAll() {
        return courseList;
    }

    @Override
    public List<Courses> deleteObj(int Id) {
        this.courseList.removeIf(n -> n.getArrayID() == Id);
        try {
            FileWriteAndReadService.writeCourses(this.courseList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(this.courseList);
    }

    @Override
    public List<Courses> addObj(String name, String Teacher, String classRoom, String courseID) {
        this.courseList.add(new Courses(name, Teacher, classRoom, Integer.parseInt(courseID)));

        try {
            FileWriteAndReadService.writeCourses(this.courseList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.courseList;
    }

}
