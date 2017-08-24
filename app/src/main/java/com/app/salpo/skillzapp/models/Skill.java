package com.app.salpo.skillzapp.models;

/**
 * Created by arunaj on 8/23/17.
 */

public class Skill {

    private String mSkillName;
    private String mSkillType;
    private String mUpdatedTime;
    private int    mRate;

    public Skill(String mSkillName, String mSkillType, String mUpdatedTime, int mRate) {
        this.mSkillName   = mSkillName;
        this.mSkillType   = mSkillType;
        this.mUpdatedTime = mUpdatedTime;
        this.mRate        = mRate;
    }

    public String getSkillType() {
        return mSkillType;
    }

    public void setSkillType(String mSkillType) {
        this.mSkillType = mSkillType;
    }

    public String getSkillName() {
        return mSkillName;
    }

    public void setSkillName(String mSkillName) {

        this.mSkillName = mSkillName;
    }

    public String getUpdatedTime() {
        return mUpdatedTime;
    }

    public void setUpdatedTime(String mUpdatedTime) {
        this.mUpdatedTime = mUpdatedTime;
    }

    public String getRate() {
        return Integer.toString(mRate);
    }

    public void setRate(int mRate) {
        this.mRate = mRate;
    }
}
