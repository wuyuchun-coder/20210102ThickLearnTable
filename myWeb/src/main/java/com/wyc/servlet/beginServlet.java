package com.wyc.servlet;

import com.wyc.bean.VideoInfo;
import com.wyc.dao.VideoDAO;
import com.wyc.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@WebServlet("/beginServlet")
public class beginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VideoDAO videoDAO=new VideoDAO();
        List<VideoInfo>videoList=null;
        List<VideoInfo>videoBoardList=null;
        try {
            videoList= videoDAO.selectVideoInfo();
            request.getSession().setAttribute("videoList",videoList);
            videoBoardList=videoDAO.selectVideoInfo();
            videoBoardList.sort(new Comparator<VideoInfo>() {
                @Override
                public int compare(VideoInfo videoInfo, VideoInfo t1) {
                    if(videoInfo.getVideoboard()<t1.getVideoboard()){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            });
            request.getSession().setAttribute("videoBoardList",videoBoardList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);

    }
}
