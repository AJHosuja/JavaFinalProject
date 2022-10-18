package com.example.javabackend.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.javabackend.dataModels.Courses;
import com.example.javabackend.dataModels.CoursesAndStudents;
import com.example.javabackend.dataModels.Students;

@Service
public class FileWriteAndReadService {
    
    public static List<Students> getAllStudents() throws FileNotFoundException {
        List<Students> studentsList = new ArrayList<Students>();
        final Scanner fileScanner = new Scanner(new File("students.txt"));
        while(fileScanner.hasNextLine()) {
            String entireRow = fileScanner.nextLine();
            String[] splittedRow = entireRow.split("<");

            if(splittedRow.length > 2) {
                studentsList.add(new Students(splittedRow[0], Integer.parseInt(splittedRow[1]), Double.parseDouble(splittedRow[2]), Integer.parseInt(splittedRow[3])));
            }
        }
        fileScanner.close();
            
        return studentsList;
    }

    public static void writeStudents(List<Students> stud) throws IOException {
        File f = new File("E:\\java 2\\Java\\students.txt");
        FileWriter fw = new FileWriter(f);

        for (Students students : stud) {
            fw.write(students.getName() + "<" + students.getAge() + "<" + students.getAvg() + "<" + students.getUserNumber() + System.lineSeparator());            
        }

        fw.close();
    }

    ///////////////////////////////////////////////////////////////////////
        
    public static List<Courses> getAllCourses() throws IOException {
        List<Courses> coursesList = new ArrayList<Courses>();
        
        final Scanner fileScanner = new Scanner(new File("courses.txt"));
        while(fileScanner.hasNextLine()) {
            String entireRow = fileScanner.nextLine();
            String[] splittedRow = entireRow.split("<");

            if(splittedRow.length > 2) {
                coursesList.add(new Courses(splittedRow[0], splittedRow[1], splittedRow[2], Integer.parseInt(splittedRow[3])));
            }
        }
        fileScanner.close();
        return coursesList;
    }   

    public static void writeCourses(List<Courses> coursesList) throws IOException {
        File f = new File("courses.txt");
        FileWriter fw = new FileWriter(f);

        for (Courses courses : coursesList) {
            fw.write(courses.getCourseName() + "<" + courses.getTeacher() + "<" + courses.getClassRoom() + "<" + courses.getCourseIDnumber() + System.lineSeparator());            
        }
        
        fw.close();
    }   

    //////////////////////////////////////////////////////////////////

    public static List<CoursesAndStudents> getAllCoursesAndStudents() throws FileNotFoundException {
        List<CoursesAndStudents> couAndStudList = new ArrayList<CoursesAndStudents>();
        final Scanner fileScanner = new Scanner(new File("coursesAndStudents.txt"));
        while(fileScanner.hasNextLine()) {
            String entireRow = fileScanner.nextLine();
            String[] splittedRow = entireRow.split("<");
            if(splittedRow.length > 1) {
                couAndStudList.add(new CoursesAndStudents(Integer.parseInt(splittedRow[1]), Integer.parseInt(splittedRow[0])));
            }
        }
        fileScanner.close();
            
        return couAndStudList;
    }

    public static void WriteCoursesAndStudents(List<CoursesAndStudents> couAndStudList) throws IOException {
        File f = new File("coursesAndStudents.txt");
        FileWriter fw = new FileWriter(f);
        for (CoursesAndStudents coursesAndStudents : couAndStudList) {
            fw.write(coursesAndStudents.getCourseIDnumber() + "<" + coursesAndStudents.getUserNumber() + System.lineSeparator());            
        }
        fw.close();
    }
}       


