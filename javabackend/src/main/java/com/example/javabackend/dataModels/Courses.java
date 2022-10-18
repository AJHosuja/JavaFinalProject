package com.example.javabackend.dataModels;

public class Courses {
    private String courseName;
    private String teacher;
    private String classRoom;
    private int courseIDnumber;
    private int arrayID;

    private static int courseIDcount = 0;


    public Courses(String courseName, String teacher, String classRoom, int courseIDnumber) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.classRoom = classRoom;
        this.courseIDnumber = courseIDnumber;
        this.arrayID = courseIDcount++;
    }

    public Courses() {
        this("", "", "", 0);
    }
    

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getCourseIDnumber() {
        return this.courseIDnumber;
    }

    public void setCourseIDnumber(int courseIDnumber) {
        this.courseIDnumber = courseIDnumber;
    }

    public int getArrayID() {
        return this.arrayID;
    }

    public void setArrayID(int arrayID) {
        this.arrayID = arrayID;
    }


}
