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
    public List<Video> getAllVideos() {
        return new ArrayList<Video>(videos.values());
    }

    @Override
    public Video getVideo(String VideoId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Video removeVideo(String VideoId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private Map<String, Video> videos = new HashMap<>();
}


