package com.example.javabackend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.javabackend.dataModels.Students;

@Service
public class StudentService extends FileWriteAndReadService implements StudentsServiceInterface {
    
    private List<Students> studentList = new ArrayList<>();
    
    
    public StudentService() throws FileNotFoundException {
        this.studentList = FileWriteAndReadService.getAllStudents();
    } 

    @Override
    public List<Students> getAll() {
        return new ArrayList<>(this.studentList);
    }
    
    @Override
     public List<Students> deleteObj(int id) {
         
         this.studentList.removeIf(n -> n.getUserID() == id);
         try {
            FileWriteAndReadService.writeStudents(this.studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(this.studentList);
        }

    @Override
    public List<Students> addObj(String name, String age, String avg, String usernumber) {
        this.studentList.add(new Students(name, Integer.parseInt(age), Double.parseDouble(avg), Integer.parseInt(usernumber)));
            
        try {
            FileWriteAndReadService.writeStudents(this.studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(this.studentList);
    }
        
}
