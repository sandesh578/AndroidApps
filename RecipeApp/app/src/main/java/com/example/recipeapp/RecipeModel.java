package com.example.recipeapp;

public class RecipeModel {
    private String text;
    private int pic;
    public RecipeModel(int pic,String text)
    {
        this.pic=pic;
        this.text=text;
    }
    public void setText(String text)
    {
        this.text=text;
    }
    public void setPic(int pic)
    {
        this.pic=pic;
    }
    public int getPic()
    {
        return pic;
    }
    public  String getText()
    {
        return text;
    }
}
