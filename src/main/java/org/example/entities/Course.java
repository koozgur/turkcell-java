package org.example.entities;

public class Course {
    private int id;
    private String name;
    private int price;
    private String categoryName;
    private int duration;

    public Course(int id, String  name, int price, String categoryName, int duration) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryName = categoryName;
        this.duration = duration;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public int getDuration() {
        return this.duration;
    }
}
