package com.midterm.hblx_02.Model;


public class Custom_Row_Navigation {
    private String title;
    private boolean color;

    public Custom_Row_Navigation(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
}

