package com.app.salpo.skillzapp.models;

import java.util.List;

/**
 * Created by arunaj on 8/23/17.
 */

public class User {

    private String mUsername;
    private String mDesignation;
    private String mImageUrl;

    private List<Skill> mSkillsList;

    public User(String name, String designation, String imageUrl, List<Skill> mSkillsList) {
        this.mUsername = name;
        this.mDesignation = designation;
        this.mImageUrl = imageUrl;
        this.mSkillsList = mSkillsList;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setName(String username) {
        this.mUsername = username;
    }

    public String getDesignation() {
        return mDesignation;
    }

    public void setDesignation(String designation) {
        this.mDesignation = designation;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.mImageUrl = imageUrl;
    }

    public List<Skill> getSkillsList() {
        return mSkillsList;
    }

    public void setSkillsList(List<Skill> mSkillsList) {
        this.mSkillsList = mSkillsList;
    }
}
