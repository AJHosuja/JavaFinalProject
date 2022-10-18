package com.example.javabackend.service;

import java.util.List;

import com.example.javabackend.dataModels.Students;

public interface StudentsServiceInterface {
    public List<Students> getAll();

    public List<Students> deleteObj(int id);

    public List<Students> addObj(String name, String age, String avg, String usernumber);
    
}
