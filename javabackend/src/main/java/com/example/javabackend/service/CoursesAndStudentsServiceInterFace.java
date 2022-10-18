package com.example.javabackend.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.example.javabackend.dataModels.CoursesAndStudents;
import com.example.javabackend.dataModels.Students;

public interface CoursesAndStudentsServiceInterFace {
    public List<CoursesAndStudents> getAll();
    
    public List<CoursesAndStudents> addObj(String studentID, String courseID);
    
    public List<Students> deleteObj(int studentNumber, int courseID);
    
    public List<Students> getStudentsInCourse(List<Students> studList, String id) throws FileNotFoundException;
    
    public List<Students> getStudentsNotInCourse(List<Students> studList, List<CoursesAndStudents> couAndStudList, String id);
}
