package com.DVD.Video.UI;


import com.DVD.Video.DTO.Video;

import java.util.List;

public class VideoView {
    private UserIO io = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add New DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD");
        io.print("4. List DVD");
        io.print("5. View DVD");
        io.print("6. Search for DVD");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }
    public Video getNewVideoInfo() {
        String VideoId = io.readString("Please enter Video ID");
        String titleName = io.readString("Please enter DVD Title");
        String releaseDate = io.readString("Please enter Release Date");
        String mpaaRating = io.readString("Please enter MPAA Rating");
        String directorName = io.readString("Please enter Director's Name");
        String studioName = io.readString("Please enter Studio Name");
        String userRating = io.readString("Please enter User Rating");
        Video currentVideo = new Video(VideoId);
        currentVideo.setTitleName(titleName);
        currentVideo.setReleaseDate(releaseDate);
        currentVideo.setMPAARating(mpaaRating);
        currentVideo.setDirectorName(directorName);
        currentVideo.setStudioName(studioName);
        currentVideo.setUserRating(userRating);
        return currentVideo;
    }
    public void displayCreateVideoBanner() {
        io.print("=== Create Video ===");
    }
    public void displayCreateSuccessBanner() {
        io.readString(
                "Video successfully created.  Please hit enter to continue");
    }
    public void displayVideoList(List<Video> videoList) {
        for (Video currentVideo : videoList) {
            String videoInfo = String.format("#%s : %s %s %s %s %s %s",
                    currentVideo.getVideoId(),
                    currentVideo.getTitleName(),
                    currentVideo.getReleaseDate(),
                    currentVideo.getMPAARating(),
                    currentVideo.getDirectorName(),
                    currentVideo.getStudioName(),
                    currentVideo.getUserRating());
            io.print(videoInfo);
        }

        io.readString("Please hit enter to continue.");
    }
    public void displayDisplayAllBanner() {
        io.print("=== Display All Videos ===");
    }
}
