package com.DVD.Video.Controller;

import com.DVD.Video.DAO.VideoDAO;
import com.DVD.Video.DAO.VideoDAOFileImpl;
import com.DVD.Video.DTO.Video;
import com.DVD.Video.UI.VideoView;

import java.util.List;

public class VideoController {
    private VideoDAO dao = new VideoDAOFileImpl();
    private VideoView view = new VideoView();
    public void run() {
        boolean keepGoing = true;
        int menuSelection;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    addVideo();
                    break;
                case 2:
                    removeVideo();
                    break;
                case 3:
                    editVideo();
                    break;
                case 4:
                    listVideos();
                    break;
                case 5:
                    viewVideoID();
                    break;
                case 6:
                    viewVideoName();
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();}

    // function for adding videos ----------------------------------------------------------------------------
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
    // function for removing videos --------------------------------------------------------------------------
    private void removeVideo() {
        view.displayRemoveVideo();
        String  VideoId = view.getVideoIdChoice();
        Video removedVideo = dao.removeVideo(VideoId);
        view.displayRemoveResult(removedVideo);
    }

    // function for editing videos ---------------------------------------------------------------------------
    private void editVideo(){
        view.displayEditVideo();
        String videoId = view.getVideoIdChoice();
        Video video = dao.getVideoId(videoId);
        if (video != null) {
            view.displayID(video);
            video = view.getEditVideoInfo(videoId);
            dao.editVideo(video.getVideoId(), video);
            view.displayEditSuccess();
        } else {
            view.displayNoID();
        }

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