package com.midterm.hblx_02.Model;

import java.util.ArrayList;

public class Question {
    private String id;
    private String description;
    private ArrayList<String> answer;
    private ArrayList<String> result;
    private String pathImage;
    private ArrayList<String> userResult;

    public Question() {
    }

    public Question(String description, ArrayList<String> answer, ArrayList<String> result, String pathImage, ArrayList<String> userResult) {
        this.description = description;
        this.answer = answer;
        this.result = result;
        this.pathImage = pathImage;
        this.userResult = userResult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answer = answer;
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public void setResult(ArrayList<String> result) {
        this.result = result;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public ArrayList<String> getUserResult() {
        return userResult;
    }

    public void setUserResult(ArrayList<String> userResult) {
        this.userResult = userResult;
    }
}
