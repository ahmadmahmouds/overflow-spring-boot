package com.overflow.demo.models;

import javax.validation.constraints.Pattern;

public class GetForm {
    private  String question;
    @Pattern(regexp="^(([a-zA-Z\\s])+$|([a-zA-Z\\s]+,)[a-zA-Z\\s]+){1,2}$",message="Tags must be separated by commas, max 3")
    private String tags;


    public GetForm(){}

    public GetForm(String question, String tags) {
        this.question = question;
        this.tags = tags;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public  String[] tags(){
        return getTags().split(",");
    }
}
