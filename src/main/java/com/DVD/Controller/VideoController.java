package com.DVD.Controller;

import com.DVD.View.VideoView;
import com.DVD.Model.Video;

public class VideoController {
        private Video model;
        private VideoView view;

        public VideoController(Video model, VideoView view){
            this.model = model;
            this.view = view;
        }

    public String getTitle() {
        return model.getTitle();
    }

    public void setTitle(String title) {
        model.setTitle(title);
    }

    public String getReleaseDate() {
        return model.getReleaseDate();
    }

    public void setReleaseDate(String releaseDate) {
        model.setReleaseDate(releaseDate);
    }
/*
    public String getMPAARating() {
        return model.MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        model.MPAARating = MPAARating;
    }

    public String getDirectorName() {
        return model.directorName;
    }

    public void setDirectorName(String directorName) {
        model.directorName = directorName;
    }

    public String getStudio() {
        return model.Studio;
    }

    public void setStudio(String studio) {
        model.Studio = studio;
    }

    public String getUserRating() {
        return model.userRating;
    }

    public void setUserRating(String userRating) {
        model.userRating = userRating;
    }*/

        public void updateView(){
            view.printVideoDetails(model.getTitle(), model.getReleaseDate());
        }
}
