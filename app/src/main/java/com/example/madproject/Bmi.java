package com.example.madproject;

public class Bmi {

    private int id;
    private String name;
    private String height;
    private String weight;
    private String ans;

    public Bmi(String name, String height, String weight, String ans, int id) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.ans = ans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
