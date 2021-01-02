package com.wyc.dao;

import com.wyc.bean.VideoInfo;
import com.wyc.bean.remarkInfo;
import com.wyc.utils.DBUtils;

import java.util.List;

public class VideoDAO {
    public VideoDAO(){

    }
    public List<remarkInfo> selectRemarkInfo(int  videoId) throws Exception {
        String sql="select REMARK_CONTENT,REMARK_TIME,REMARK_POSTER,REMARK_VIDEO_ID from remarkInfo where REMARK_VIDEO_ID=?";
        return  DBUtils.selectRemarkInfo(sql,videoId);
    }
    public List<VideoInfo> selectVideoInfo() throws Exception {
        String sql="select VIDEO_ID,VIDEO_NAME,VIDEO_TYPE,VIDEO_ADDRESS,VIDEO_PAGESHOW,VIDEO_BOARD from videoinfo";
        return DBUtils.selectVideoInfo(sql);
    }

    public boolean saveRemark(String remarkcontent,String remarktime,String remarkpost,int remarkvideoid) throws Exception {
        String sql="insert into remarkinfo(REMARK_CONTENT,REMARK_TIME,REMARK_POSTER,REMARK_VIDEO_ID)"+"value(?,?,?,?)";
        return DBUtils.saveApplicantInfo(sql,remarkcontent,remarktime,remarkpost,remarkvideoid);
    }
    public boolean changeVideoType(String videoName,String videoType) throws Exception {
        String sql="update videoinfo set VIDEO_TYPE=? where VIDEO_NAME=?";
        return DBUtils.changeVideoType(sql,videoName,videoType);
    }
    public boolean setVideoName(String videoName,String videoType,String addvideoName,String videoPic) throws Exception {
        String sql="insert into videoinfo(VIDEO_NAME,VIDEO_TYPE,VIDEO_ADDRESS,VIDEO_PAGESHOW)"+"values(?,?,?,?)";
        return  DBUtils.setVideoName(sql,videoName,videoType,addvideoName,videoPic);
    }
    public boolean changeVideoBoard(int board,int videoId) throws Exception {
        String sql="update videoinfo set VIDEO_BOARD=? where VIDEO_ID=?";
        return DBUtils.changeVideoBoard(sql,board,videoId);
    }
}
