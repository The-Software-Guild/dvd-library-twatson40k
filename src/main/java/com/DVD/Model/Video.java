package com.DVD.Model;

public class Video {
    private int DVD_id;
    private String title;
    private String releaseDate;
    private String MPAARating;
    private String directorName;
    private String Studio;
    private String userRating;

    public Video(){};

    public Video(int dvd_id, String title, String releaseDate, String mpaaRating, String directorName, String studio, String userRating) {
        DVD_id = dvd_id;
        this.title = title;
        this.releaseDate = releaseDate;
        MPAARating = mpaaRating;
        this.directorName = directorName;
        Studio = studio;
        this.userRating = userRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String studio) {
        Studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public int getDVD_id() {
        return DVD_id;
    }

    public void setDVD_id(int DVD_id) {
        this.DVD_id = DVD_id;
    }

}


