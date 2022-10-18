package com.example.javabackend.service;

import java.util.List;

import com.example.javabackend.dataModels.Courses;

public interface CourseServiceInterFace {
    public List<Courses> getAll();

    public List<Courses> deleteObj(int Id);

    public List<Courses> addObj(String name, String Teacher, String classRoom, String courseID);
}
