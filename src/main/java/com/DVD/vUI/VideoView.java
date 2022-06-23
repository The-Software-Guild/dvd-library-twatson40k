package com.DVD.vUI;

import com.DVD.vDTO.Video;

import java.util.List;

public class VideoView {
    private final UserIO io;

    public VideoView(UserIO io) {
        this.io = io;
    }
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add New DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD");
        io.print("4. List DVD");
        io.print("5. View DVD by ID");
        io.print("6. View DVD by Title");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }
    //adds video to system -----------------------------------------------------------------------------------
    public Video getNewVideoInfo() {
        String VideoId = io.readString("Please enter Video ID");
        String titleName = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter Release Date");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director's Name");
        String studioName = io.readString("Please enter Studio Name");
        String userRating = io.readString("Please enter User Rating");
        Video currentVideo = new Video(VideoId);
        currentVideo.setVideoId(VideoId);
        currentVideo.setTitleName(titleName);
        currentVideo.setReleaseDate(releaseDate);
        currentVideo.setMPAARating(mpaaRating);
        currentVideo.setDirectorName(directorName);
        currentVideo.setStudioName(studioName);
        currentVideo.setUserRating(userRating);
        return currentVideo;
    }

    public void displayAddVideo() {
        io.print("=== Add Video ===");
    }
    public void displayAddSuccess() {
        io.readString(
                "Video successfully Added.  Please hit enter to continue");
    }
    public void displayAlreadyExists() {
        io.readString(
                "Video Already Exists.  Please hit enter to continue");
    }

    // removes DVD from System --------------------------------------------------------------------------------
    public void displayRemoveVideo () {
        io.print("=== Remove Video ===");
    }
    public void displayRemoveResult(Video videoRecord) {
        if(videoRecord != null){
            io.print("Video successfully removed.");
        }else{
            io.print("No such video exists.");
        }
        io.readString("Please hit enter to continue.");
    }
    //Edits video from ID -------------------------------------------------------------------------------------
    public Video getEditVideoInfo(String videoId) {
        String titleName = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter Release Date");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director's Name");
        String studioName = io.readString("Please enter Studio Name");
        String userRating = io.readString("Please enter User Rating");
        Video currentVideo = new Video(videoId);
        currentVideo.setTitleName(titleName);
        currentVideo.setReleaseDate(releaseDate);
        currentVideo.setMPAARating(mpaaRating);
        currentVideo.setDirectorName(directorName);
        currentVideo.setStudioName(studioName);
        currentVideo.setUserRating(userRating);
        return currentVideo;
    }
    public void displayEditVideo() {
        io.print("=== Edit Video ===");
    }
    public void displayID(Video ignoredVideo){
            io.print("Video ID exist: ");
    }
    public void displayNoID(){
            io.print("No such DVD exists.");
            io.readString("Please hit enter to continue");
        }
    public void displayEditSuccess() {
        io.readString(
                "Video successfully Edited.  Please hit enter to continue");
    }

    // displays all videos in a list --------------------------------------------------------------------------
    public void displayVideoList(List<Video> videoList) {
        for (Video currentVideo : videoList) {
            String videoInfo = String.format("#%s : %s %s ",
                    currentVideo.getVideoId(),
                    currentVideo.getTitleName(),
                    currentVideo.getReleaseDate());
                    //currentVideo.getMPAARating(),
                    //currentVideo.getDirectorName(),
                    //currentVideo.getStudioName(),
                    //currentVideo.getUserRating());
            io.print(videoInfo);
        }

        io.readString("Please hit enter to continue.");
    }
    public void displayListAllVideos() {
        io.print("=== List All Videos ===");
    }

    // View selected video by ID and Name --------------------------------------------------------------------
    public void displayViewVideo () {
        io.print("=== View Video ===");
    }
    public String getVideoIdChoice() {
        return io.readString("Please enter the Video ID.");
    }
    public String getVideoNameChoice(){
        return io.readString("Please enter the Video Name.");
    }
    public void displayNotFound() {
        io.print("Not Found!!!");
        io.readString("Please hit enter to continue.");
    }

    public void displayVideo(Video video) {
        if (video != null) {
            //io.print(video.getVideoId());
            io.print("DVD: " + video.getTitleName() + " :: Year: " + video.getReleaseDate() + " :: Rated: " +
            video.getMPAARating() + " :: ");
            io.print("Director: " + video.getDirectorName() + " :: Studio: " +
            video.getStudioName() + " :: ");
            io.print("Overall Review: " + video.getUserRating() + " :: ");
            io.print("");
        } else {
            io.print("No such DVD exists.");
        }
        io.readString("Please hit enter to continue.");
    }


    // code displays exit and unknown commands messages -------------------------------------------------------
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    public void displayExit() {
        io.print("Good Bye!!!");
    }
    public void displayUnknownCommand() {
        io.print("Unknown Command!!!");
    }

}
