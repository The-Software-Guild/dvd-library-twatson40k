package com.DVD.Video.DTO;

public class Video {
        private String VideoId;
        private String titleName;
        private String releaseDate;
        private String mpaaRating;
        private String directorName;
        private String studioName;
        private String userRating;
        public Video (){}
        public Video(String VideoId) {
            this.VideoId = VideoId;
        }
         public String getVideoId() {
            return VideoId;
        }
        public void setVideoId(String VideoId) {
            this.VideoId = VideoId;
        }


        public String getTitleName() {
            return titleName;
        }
        public void setTitleName(String titleName) {
            this.titleName = titleName;
        }

        public String getReleaseDate() {
            return releaseDate;
        }
        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getMPAARating() {
            return mpaaRating;
        }
        public void setMPAARating(String mpaaRating) {
            this.mpaaRating = mpaaRating;
        }

        public String getDirectorName() {
            return directorName;
        }
        public void setDirectorName(String directorName) {
            this.directorName = directorName;
        }

        public String getStudioName() {
            return studioName;
        }
        public void setStudioName(String studioName) {
            this.studioName = studioName;
        }

        public String getUserRating() {
            return userRating;
        }
        public void setUserRating(String userRating) {
            this.userRating = userRating;
        }
    }



