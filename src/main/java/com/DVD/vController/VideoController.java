package com.DVD.vController;

import com.DVD.vDAO.VideoDAO;
import com.DVD.vDAO.VideoDAOException;
import com.DVD.vDTO.Video;
import com.DVD.vUI.VideoView;

import java.util.List;

public class VideoController {
    private final VideoDAO dao;
    private final VideoView view;

    public VideoController(VideoDAO dao, VideoView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() throws VideoDAOException {
        boolean keepGoing = true;
        int menuSelection;
        try {
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
        } catch (VideoDAOException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();}

    // function for adding videos ----------------------------------------------------------------------------
    private void addVideo() throws VideoDAOException {
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
    private void removeVideo() throws VideoDAOException {
        view.displayRemoveVideo();
        String  VideoId = view.getVideoIdChoice();
        Video removedVideo = dao.removeVideo(VideoId);
        view.displayRemoveResult(removedVideo);
    }

    // function for editing videos ---------------------------------------------------------------------------
    private void editVideo() throws VideoDAOException{
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

    private void listVideos() throws VideoDAOException{
        view.displayListAllVideos();
        List<Video> videoList = dao.getAllVideos();
        view.displayVideoList(videoList);
    }

    private void viewVideoID() throws VideoDAOException{
        view.displayViewVideo();
        String videoId = view.getVideoIdChoice();
        Video video = dao.getVideoId(videoId);
        view.displayVideo(video);
    }

    private void viewVideoName() throws VideoDAOException{
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
