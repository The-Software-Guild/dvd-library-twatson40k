package com.DVD.Video;

import com.DVD.vController.VideoController;
import com.DVD.vDAO.VideoDAO;
import com.DVD.vDAO.VideoDAOFileImpl;
import com.DVD.vUI.UserIO;
import com.DVD.vUI.UserIOConsoleImpl;
import com.DVD.vUI.VideoView;

public class DVDLibrary {
    public static void main(String[] args) {
        UserIO myIo =  new UserIOConsoleImpl();
        VideoView myView = new VideoView(myIo);
        VideoDAO myDOA = new VideoDAOFileImpl();
        VideoController controller = new VideoController(myDOA,myView);
        controller.run();
    }

}
