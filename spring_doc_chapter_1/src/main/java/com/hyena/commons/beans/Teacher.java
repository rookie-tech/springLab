package com.hyena.commons.beans;

public class Teacher {

    // 老师有把刀
    private Knife knife;

    private String name ;
    private int age;

    public Teacher(Knife knife, String name, int age) {
        this.knife = knife;
        this.name = name;
        this.age = age;
    }

    public Teacher(Knife knife) {
        this.knife = knife;
    }

    public Teacher(String name, int age) {
        this.name = name ;
        this.age = age ;
    }

}
