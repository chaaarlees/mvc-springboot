package com.charles.mvc_springboot.models.dto;

import com.charles.mvc_springboot.models.User;

public class UserDto {

    private String title; 
    private User user;
    private String fullName;
    private String wellcomeMessage;


    public String getTitle() {
        return title;
    }

    public String getWellcomeMessage() {
        return wellcomeMessage;
    }
    public void setWellcomeMessage(String wellcomeMessage) {
        this.wellcomeMessage = wellcomeMessage;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public User getUser() {
        return user;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setUser(User user) {
        this.user = user;
    }  

    
}
