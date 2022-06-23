package com.DVD.Video.DAO;

import com.DVD.Video.DTO.Video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoDAOFileImpl implements VideoDAO {

    @Override
    public Video addVideo(String VideoId, Video video) {
        return videos.put(VideoId, video);
    }

    @Override
    public Video removeVideo(String VideoId) {
        return videos.remove(VideoId);
    }

    @Override
    public Video editVideo(String VideoID, Video video){
        return videos.put(VideoID, video);
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


