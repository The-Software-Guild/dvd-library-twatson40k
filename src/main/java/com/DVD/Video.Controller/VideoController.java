package com.DVD.Video.Controller;


import com.DVD.Video.DAO.VideoDAO;
import com.DVD.Video.DAO.VideoDAOFileImpl;
import com.DVD.Video.DTO.Video;
import com.DVD.Video.UI.UserIO;
import com.DVD.Video.UI.UserIOConsoleImpl;
import com.DVD.Video.UI.VideoView;

import java.util.List;

public class VideoController {
    private VideoDAO dao = new VideoDAOFileImpl();
    private UserIO io = new UserIOConsoleImpl();
    private VideoView view = new VideoView();
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            io.print("Main Menu");
            io.print("1. Add New DVD");
            io.print("2. Remove DVD");
            io.print("3. Edit DVD");
            io.print("4. List DVD");
            io.print("5. View DVD");
            io.print("6. Search for DVD");
            io.print("7. Exit");

            menuSelection = io.readInt("Please select from the"
                    + " above choices.", 1, 7);

            switch (menuSelection) {
                case 1:
                    createVideo();
                    //io.print("DVD Added");
                    break;
                case 2:
                    removeVideo();
                    //io.print("DVD Removed");
                    break;
                case 3:
                    io.print("DVD Edited");
                    break;
                case 4:
                    listVideos();
                    //io.print("DVDs Listed");
                    break;
                case 5:
                    viewVideo();
                    //io.print("DVD Details");
                    break;
                case 6:
                    io.print("DVD Details");
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();}

    private void createVideo() {
        view.displayAddVideo();
        Video newVideo = view.getNewVideoInfo();
        dao.addVideo(newVideo.getVideoId(), newVideo);
        view.displayAddSuccess();
    }

    private void removeVideo() {
        view.displayRemoveVideo();
        String  VideoId = view.getVideoIdChoice();
        Video removedVideo = dao.removeVideo(VideoId);
        view.displayRemoveResult(removedVideo);
    }

    private void listVideos() {
        view.displayListAllVideos();
        List<Video> videoList = dao.getAllVideos();
        view.displayVideoList(videoList);
    }

    private void viewVideo() {
        view.displayViewVideo();
        String videoId = view.getVideoIdChoice();
        //String videoName = view.getVideoNameChoice();
        Video video = dao.getVideo(videoId);  //dao.getVideoName(videoName);
        view.displayVideo(video);
    }
}