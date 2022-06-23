package com.DVD.vDAO;

import com.DVD.vDTO.Video;

import java.util.List;

public interface VideoDAO {

    /**
     * Adds the given Video to the roster and associates it with the given
     * Video id. If there is already a Video associated with the given
     * Video id it will return that Video object, otherwise it will
     * return null.
     *
     * @param VideoId id with which Video is to be associated
     * @param video   //addVideo to be added to the roster
     */
    void addVideo(String VideoId, Video video);

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


    /**
     * edits a Video in the system.
     */
    void editVideo(String VideoId, Video video);

    /**
     * Returns a List of all Videos in the system.
     *
     * @return List containing all Videos in the system.
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
    Video getVideoId(String VideoId);

    /**
     * Returns the Video object associated with the given Video name.
     * Returns null if no such Video exists
     *
     * @param titleName of the Video to retrieve
     * @return the Video object associated with the given Video name,
     * null if no such Video exists
     */
    Video getVideoName(String titleName);


}
