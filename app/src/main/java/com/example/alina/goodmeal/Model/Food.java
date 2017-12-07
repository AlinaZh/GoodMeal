package com.example.alina.goodmeal.Model;

/**
 * Created by Динара on 05.11.2017.
 */

public class Food {
    private String Name, Image, Ingredients, CookingTime, Directions, MenuId;

    public Food() {
    }

    public Food(String name, String image, String ingredients, String cookingTime, String directions, String menuId) {
        Name = name;
        Image = image;
        Ingredients = ingredients;
        CookingTime = cookingTime;
        Directions = directions;
        MenuId = menuId;
    }

     public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }

    public String getCookingTime() {
        return CookingTime;
    }

    public void setCookingTime(String cookingTime) {
        CookingTime = cookingTime;
    }

    public String getDirections() {
        return Directions;
    }

    public void setDirections(String directions) {
        Directions = directions;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }
}
