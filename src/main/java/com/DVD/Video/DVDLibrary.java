package com.DVD.Video;

import com.DVD.Video.Controller.VideoController;
import com.DVD.Video.DAO.VideoDAO;
import com.DVD.Video.DAO.VideoDAOFileImpl;
import com.DVD.Video.UI.UserIO;
import com.DVD.Video.UI.UserIOConsoleImpl;
import com.DVD.Video.UI.VideoView;

public class DVDLibrary {
    public static void main(String[] args) {
        UserIO myIo =  new UserIOConsoleImpl();
        VideoView myView = new VideoView(myIo);
        VideoDAO myDOA = new VideoDAOFileImpl();
        VideoController controller = new VideoController(myDOA,myView);
        controller.run();
    }

}
