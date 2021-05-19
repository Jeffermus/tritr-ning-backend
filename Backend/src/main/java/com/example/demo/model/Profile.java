package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profileId;
    private String profileAbout;
    private String profileImg;

    public Profile() {
    }

    public Profile(String profileAbout) {
        this.profileAbout = profileAbout;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getProfileAbout() {
        return profileAbout;
    }

    public void setProfileAbout(String profileAbout) {
        this.profileAbout = profileAbout;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId=" + profileId +
                ", profileAbout='" + profileAbout + '\'' +
                ", profileImg='" + profileImg + '\'' +
                '}';
    }
}
