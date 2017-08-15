package com.itsdamslife.myrecipes;

/**
 * Created by dshenoy on 8/15/17.
 */

class Recipe {

    private String title, cuisine;
    public Recipe() {

    }

    public Recipe(String title, String cuisine) {
        this.title = title;
        this.cuisine = cuisine;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cui) {
        this.cuisine = cui;
    }
}
