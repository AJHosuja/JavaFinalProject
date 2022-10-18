package com.example.javabackend.dataModels;

public class CoursesAndStudents {
    private int userNumber;
    private int courseIDnumber;
    private int id;

    private static int fieldCount = 0;

    
    
    public CoursesAndStudents(int userNumber, int courseIDnumber) {
        this.userNumber = userNumber;
        this.courseIDnumber = courseIDnumber;
        this.id=fieldCount++;
    }   
    public CoursesAndStudents() {
        this(0,0);
    }
    
    public int getUserNumber() { return this.userNumber;}

    public void setUserNumber(int userNumber) { this.userNumber = userNumber;}

    public int getCourseIDnumber() { return this.courseIDnumber;}

    public void setCourseIDnumber(int courseIDnumber) {this.courseIDnumber = courseIDnumber;}

    public int getId() { return this.id; }

    public void setId(int id) {this.id = id;}

}
