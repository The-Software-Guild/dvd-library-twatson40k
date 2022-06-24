package com.DVD.vDAO;

import com.DVD.vDTO.Video;

import java.io.*;
import java.util.*;


public class VideoDAOFileImpl implements VideoDAO {

    @Override
    public Video addVideo(String VideoId, Video video) throws VideoDAOException {
        loadLibrary();
        Video addVideo = videos.put(VideoId, video);
        writeLibrary();
        return addVideo;
    }

    @Override
    public Video removeVideo(String VideoId) throws VideoDAOException {
        loadLibrary();
        Video removeVideo = videos.remove(VideoId);
        writeLibrary();
        return removeVideo;
    }

    @Override
    public Video editVideo(String VideoID, Video video) throws VideoDAOException{
        loadLibrary();
        Video editVideo = videos.put(VideoID, video);
        writeLibrary();
        return editVideo;
    }

    @Override
    public List<Video> getAllVideos() throws VideoDAOException {
        loadLibrary();
        return new ArrayList<>(videos.values());
    }

    @Override
    public Video getVideoId(String VideoId) throws VideoDAOException{
        loadLibrary();
        return videos.get(VideoId);
    }

    @Override
    public Video getVideoName(String titleName) throws VideoDAOException{
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


    //Data storing code.
    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";
    private Video unmarshallVideo(String videoAsText){
        // videoAsText is expecting a line read in from our file.

        String[] videoTokens = videoAsText.split(DELIMITER);
        int vtLength = videoTokens.length;

        // Given the pattern above, the video Id is in index 0 of the array.
        String videoId = videoTokens[0];

        Video videoFromFile = new Video(videoId);
        
        if (vtLength >= 2) {
            // Index 1 - TitleName
            videoFromFile.setTitleName(videoTokens[1]);}

        if (vtLength >= 3) {
            // Index 2 - ReleaseDate
            videoFromFile.setReleaseDate(videoTokens[2]);}

        if (vtLength >= 4) {
            // Index 3 - MPAARating
            videoFromFile.setMPAARating(videoTokens[3]);}

        if (vtLength >= 5) {
            // Index 4 - DirectorName
            videoFromFile.setDirectorName(videoTokens[4]);}

        if (vtLength >= 6) {
            // Index 5 - StudioName
            videoFromFile.setStudioName(videoTokens[5]);}

        if (vtLength >= 7) {
            // Index 6 - UserRating
            videoFromFile.setUserRating(videoTokens[6]);
    }

        return videoFromFile;
    }

    private void loadLibrary() throws VideoDAOException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new VideoDAOException(
                    "-_- Could not load DVD data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentVideo holds the most recent Video unmarshalled
        Video currentVideo;
        // Go through DVD_FILE line by line, decoding each line into a
        // Video object by calling the unmarshallVideo method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Video
            currentVideo = unmarshallVideo(currentLine);

            // We are going to use the Video id as the map key for our Video object.
            // Put currentVideo into the map using Video id as the key
            videos.put(currentVideo.getVideoId(), currentVideo);
        }
        // close scanner
        scanner.close();
    }

    private String marshallVideo(Video aVideo){

        String videoAsText = aVideo.getVideoId() + DELIMITER;
        // Title
        videoAsText  += aVideo.getTitleName() + DELIMITER;
        // Release date
        videoAsText  += aVideo.getReleaseDate() + DELIMITER;
        // MPAA
        videoAsText  += aVideo.getMPAARating() + DELIMITER;
        // Director
        videoAsText  += aVideo.getDirectorName() + DELIMITER;
        // Studio
        videoAsText  += aVideo.getStudioName() + DELIMITER;

        // User Rating - don't forget to skip the DELIMITER here.
        videoAsText += aVideo.getUserRating();

        // We have now turned a Video to text! Return it!
        return videoAsText;
    }
    private void writeLibrary() throws VideoDAOException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new VideoDAOException(
                    "Could not save Video data.", e);
        }
        
        // we'll reuse it.
        String VideoAsText;
        List<Video> VideoList = this.getAllVideos();
        for (Video currentVideo : VideoList) {
            // turn a Video into a String
            VideoAsText = marshallVideo(currentVideo);
            // write the Video object to the file
            out.println(VideoAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}


