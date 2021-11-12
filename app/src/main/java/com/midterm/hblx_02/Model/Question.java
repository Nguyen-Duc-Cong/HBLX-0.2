package com.midterm.hblx_02.Model;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Question {
    private String id;
    private String description;
    private ArrayList<String> answer;
    private ArrayList<Integer> result;
    private String pathImage;
    private ArrayList<Integer> userResult;

    public Question() {
    }

    public Question(String description, ArrayList<String> answer, ArrayList<Integer> result, String pathImage) {
        this.description = description;
        this.answer = answer;
        this.result = result;
        this.pathImage = pathImage;
        this.userResult =new ArrayList<>();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Integer> getResult() {
        return result;
    }

    public void setResult(ArrayList<Integer> result) {
        this.result = result;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public ArrayList<Integer> getUserResult() {
        return userResult;
    }

    public void setUserResult(ArrayList<Integer> userResult) {
        this.userResult = userResult;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
