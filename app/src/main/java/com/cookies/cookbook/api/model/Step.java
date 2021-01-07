package com.cookies.cookbook.api.model;

import com.google.gson.annotations.SerializedName;

public class Step {
    @SerializedName("id")
    private int id;

    @SerializedName("stepNumber")
    private int stepNumber;

    @SerializedName("description")
    private String description;

    public Step(int id, int stepNumber, String description) {
        this.id = id;
        this.stepNumber = stepNumber;
        this.description = description;
    }

    public Step() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
