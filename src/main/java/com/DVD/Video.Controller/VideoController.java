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
    private final UserIO io = new UserIOConsoleImpl();
    private final VideoView view = new VideoView();
    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    addVideo();
                    //io.print("DVD Added");
                    break;
                case 2:
                    removeVideo();
                    //io.print("DVD Removed");
                    break;
                case 3:
                    editVideo();
                    //io.print("DVD Edited");
                    break;
                case 4:
                    listVideos();
                    //io.print("DVDs Listed");
                    break;
                case 5:
                    viewVideoID();
                    //io.print("DVD Details");
                    break;
                case 6:
                    viewVideoName();
                    //io.print("DVD Details");
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
                    //io.print("UNKNOWN COMMAND");
            }

        }
        exitMessage();
        //io.print("GOOD BYE");
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();}

    private void addVideo() {
        view.displayAddVideo();
        Video newVideo = view.getNewVideoInfo();
        List<Video> videoList = dao.getAllVideos();
        for (Video tVid:videoList) {
            if (tVid.getVideoId().equalsIgnoreCase(newVideo.getVideoId())){
                view.displayAlreadyExists();
                return;
            }
        }
        dao.addVideo(newVideo.getVideoId(), newVideo);
        view.displayAddSuccess();
    }

    private void removeVideo() {
        view.displayRemoveVideo();
        String  VideoId = view.getVideoIdChoice();
        Video removedVideo = dao.removeVideo(VideoId);
        view.displayRemoveResult(removedVideo);
    }

    private void editVideo(){
        view.displayEditVideo();
        String videoId = view.getVideoIdChoice();
        Video video = dao.getVideoId(videoId);
        view.displayID(video);
        video = view.getEditVideoInfo(videoId);
        dao.editVideo(video.getVideoId(), video);
        view.displayEditSuccess();
    }

    private void listVideos() {
        view.displayListAllVideos();
        List<Video> videoList = dao.getAllVideos();
        view.displayVideoList(videoList);
    }

    private void viewVideoID() {
        view.displayViewVideo();
        String videoId = view.getVideoIdChoice();
        Video video = dao.getVideoId(videoId);
        view.displayVideo(video);
    }

    private void viewVideoName() {
        view.displayViewVideo();
        String titleName = view.getVideoNameChoice();
        Video video = dao.getVideoName(titleName);
        if (video.getVideoId() == null){
            view.displayNotFound();
        }else {
        view.displayVideo(video);}
    }

    private void unknownCommand() {
        view.displayUnknownCommand();
    }
    private void exitMessage() {
        view.displayExit();
    }
}