package com.DVD.vDAO;

public class VideoDAOException extends Exception{

    //public VideoDAOException(String message) {super(message);}

    public VideoDAOException(String message, Throwable cause) {
        super(message, cause);
    }

}
