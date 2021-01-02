package com.wyc.bean;

public class remarkInfo {
    public String content;
    public String remarktime;
    public String posterEmail;
    public int remarkVideoID;
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemarktime() {
        return remarktime;
    }

    public void setRemarktime(String remarktime) {
        this.remarktime = remarktime;
    }

    public String getPosterEmail() {
        return posterEmail;
    }

    public void setPosterEmail(String posterEmail) {
        this.posterEmail = posterEmail;
    }

    public int getRemarkVideoID() {
        return remarkVideoID;
    }

    public void setRemarkVideoID(int remarkVideoID) {
        this.remarkVideoID = remarkVideoID;
    }


    public remarkInfo(String content, String remarktime, String posterEmail,int remarkVideoID) {
        this.content = content;
        this.remarktime = remarktime;
        this.posterEmail = posterEmail;
        this.remarkVideoID = remarkVideoID;
    }




}
