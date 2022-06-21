package com.DVD.Video.DAO;

import com.DVD.Video.DTO.Video;

import java.util.List;

public interface VideoDAO {

    /**
     * Adds the given Video to the roster and associates it with the given
     * Video id. If there is already a Video associated with the given
     * Video id it will return that Video object, otherwise it will
     * return null.
     *
     * @param VideoId id with which Video is to be associated
     * @param //Video Video to be added to the roster
     * @return the Video object previously associated with the given  
     * Video id if it exists, null otherwise
     */
    Video addVideo(String VideoId, Video video);

    /**
     * Returns a List of all Videos in the roster.
     *
     * @return List containing all Videos in the roster.
     */
    List<Video> getAllVideos();

    /**
     * Returns the Video object associated with the given Video id.
     * Returns null if no such Video exists
     *
     * @param VideoId ID of the Video to retrieve
     * @return the Video object associated with the given Video id,  
     * null if no such Video exists
     */
    Video getVideo(String VideoId);

    /**
     * Removes from the roster the Video associated with the given id.
     * Returns the Video object that is being removed or null if
     * there is no Video associated with the given id
     *
     * @param VideoId id of Video to be removed
     * @return Video object that was removed or null if no Video
     * was associated with the given Video id
     */
    Video removeVideo(String VideoId);
}
