package com.DVD.Video.DAO;


import com.DVD.Video.DTO.Video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoDAOFileImpl implements VideoDAO {

    @Override
    public Video addVideo(String VideoId, Video video) {
        Video prevVideo = videos.put(VideoId, video);
        return prevVideo;
    }

    @Override
    public Video removeVideo(String VideoId) {
        Video removedVideo = videos.remove(VideoId);
        return removedVideo;
    }

    @Override
    public Video editVideo(String VideoID, Video video){
        Video editVideo = videos.put(VideoID, video);
        return editVideo;
    }

    @Override
    public List<Video> getAllVideos() {
        return new ArrayList<>(videos.values());
    }

    @Override
    public Video getVideoId(String VideoId) {
        return videos.get(VideoId);
    }

    @Override
    public Video getVideoName(String titleName){
        Video retVid = new Video();
        List<Video> videoList = getAllVideos();
        for (Video tVid:videoList) {
            if (tVid.getTitleName().equalsIgnoreCase(titleName)){
                retVid = tVid;
                break;
            }
        }
        return retVid;
    }


    private final Map<String, Video> videos = new HashMap<>();
}


