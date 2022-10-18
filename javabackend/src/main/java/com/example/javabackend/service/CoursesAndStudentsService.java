package com.example.javabackend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.javabackend.dataModels.CoursesAndStudents;
import com.example.javabackend.dataModels.Students;

@Service
public class CoursesAndStudentsService extends FileWriteAndReadService implements CoursesAndStudentsServiceInterFace {
    
    List<CoursesAndStudents> coursesAndStudensList = new ArrayList<CoursesAndStudents>();
    public CoursesAndStudentsService() throws FileNotFoundException {
        this.coursesAndStudensList = FileWriteAndReadService.getAllCoursesAndStudents();
    }

    public List<CoursesAndStudents> getAll() {
        return this.coursesAndStudensList;
    }
    
    @Override   
    public List<CoursesAndStudents> addObj(String studentID, String courseID) {
        this.coursesAndStudensList.add(new CoursesAndStudents(Integer.parseInt(studentID), Integer.parseInt(courseID)));
        try {
            FileWriteAndReadService.WriteCoursesAndStudents(this.coursesAndStudensList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.coursesAndStudensList;
    }


    @Override
    public List<Students> deleteObj(int studentNumber, int courseID) {
        System.out.println(studentNumber + " " + courseID);
        this.coursesAndStudensList.removeIf(n -> n.getUserNumber() == studentNumber && n.getCourseIDnumber() == courseID);
        try {
            FileWriteAndReadService.WriteCoursesAndStudents(coursesAndStudensList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            return getStudentsInCourse(getAllStudents(), String.valueOf(courseID));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }




    @Override
    public List<Students> getStudentsInCourse(List<Students> studList, String id) throws FileNotFoundException {
        List <CoursesAndStudents> filterList = FileWriteAndReadService.getAllCoursesAndStudents();
        filterList.removeIf(n -> n.getCourseIDnumber() != Integer.parseInt(id));
        List<Students> filteredStudents = new ArrayList<Students>();

        for (Students students : studList) {
            for (CoursesAndStudents couAndStud : filterList) {
                if(couAndStud.getUserNumber() == students.getUserNumber()) {
                    filteredStudents.add(students);
                }
            }
        }
        return filteredStudents;
    }


    public List<Students> getStudentsNotInCourse(List<Students> studList, List<CoursesAndStudents> couAndStudList, String id) {
        List<CoursesAndStudents> duplicateListWithOutRefrence = new ArrayList<CoursesAndStudents>(couAndStudList);
        duplicateListWithOutRefrence.removeIf(n -> n.getCourseIDnumber() != Integer.parseInt(id));
            for (CoursesAndStudents couAndStud : duplicateListWithOutRefrence) {
                studList.removeIf(n-> n.getUserNumber() == couAndStud.getUserNumber());
            }
        
        return studList;
    }

}
