package com.example.javabackend.dataModels;

public class Students {
    
    private String name;
    private int age;
    private double avg;
    private int userNumber;
    private int userID;

    private static int userIDcount = 0;


    
    public Students(String name, int age, double avg, int userNumber) {
        this.name = name;
        this.age = age;
        this.avg = avg;
        this.userNumber = userNumber;
        this.userID = userIDcount++;
    }
    
    public Students() {
        this("",0,0,0);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAvg() {
        return this.avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getUserID() {
        return this.userID;
    }

    public int getUserNumber() {
        return this.userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }



}
