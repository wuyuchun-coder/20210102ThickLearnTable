package com.wyc.bean;

public class VideoInfo {
    int videoid;
    String videoname;
    String videotype;
    String videoaddress;
    String videoposter;
    String videoposttime;
    int videoboard;

    String videopage;
    public VideoInfo(int videoid, String videoname,String videotype,String videoaddress, String videopage,int videoboard){
        this.videoid=videoid;
        this.videoname=videoname;
        this.videotype=videotype;
        this.videoaddress=videoaddress;
        this.videopage=videopage;
        this.videoboard=videoboard;
    }
    public String getVideopage() {
        return videopage;
    }

    public void setVideopage(String videopage) {
        this.videopage = videopage;
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }
    public VideoInfo( int videoid, String videoname,String videotype,String videoaddress, String videopage){
        this.videoid=videoid;
        this.videoname=videoname;
        this.videotype=videotype;
        this.videoaddress=videoaddress;
        this.videopage=videopage;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname;
    }

    public String getVideotype() {
        return videotype;
    }

    public void setVideotype(String videotype) {
        this.videotype = videotype;
    }

    public String getVideoaddress() {
        return videoaddress;
    }

    public void setVideoaddress(String videoaddress) {
        this.videoaddress = videoaddress;
    }

    public String getVideoposter() {
        return videoposter;
    }

    public void setVideoposter(String videoposter) {
        this.videoposter = videoposter;
    }

    public String getVideoposttime() {
        return videoposttime;
    }

    public void setVideoposttime(String videoposttime) {
        this.videoposttime = videoposttime;
    }

    public int getVideoboard() {
        return videoboard;
    }

    public void setVideoboard(int videoboard) {
        this.videoboard = videoboard;
    }


    public VideoInfo(String videoname, String videotype, String videoaddress, String videoposter, String videoposttime, int videoboard) {
        this.videoname = videoname;
        this.videotype = videotype;
        this.videoaddress = videoaddress;
        this.videoposter = videoposter;
        this.videoposttime = videoposttime;
        this.videoboard = videoboard;
    }

    public VideoInfo(int videoid,String videoname, String videotype, String videoaddress, String videoposter, String videoposttime, int videoboard) {
        this.videoid=videoid;
        this.videoname = videoname;
        this.videotype = videotype;
        this.videoaddress = videoaddress;
        this.videoposter = videoposter;
        this.videoposttime = videoposttime;
        this.videoboard = videoboard;
    }


}
