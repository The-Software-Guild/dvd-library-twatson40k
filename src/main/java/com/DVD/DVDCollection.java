package com.DVD;

import com.DVD.Controller.VideoController;
import com.DVD.Model.Video;
import com.DVD.View.VideoView;

public class DVDCollection {
        public static void main(String[] args) {

            //fetch student record based on his roll no from the database
            Video model  = retriveVideoFromDatabase();

            //Create a view : to write student details on console
            VideoView view = new VideoView();

            VideoController controller = new VideoController(model, view);

            controller.updateView();

            //update model data
            controller.setTitle("Logan");

            controller.updateView();
        }

        private static Video retriveVideoFromDatabase(){
            Video video = new Video();
            video.setTitle("Robert");
            video.setReleaseDate("10/01/2017");
            return video;
        }

}
