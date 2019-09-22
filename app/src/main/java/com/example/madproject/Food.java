package com.example.madproject;

public class Food {
    private int id;
    private String calories;
    private String date;

    public Food(int id, String calories, String date) {
        this.id = id;
        this.calories = calories;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
