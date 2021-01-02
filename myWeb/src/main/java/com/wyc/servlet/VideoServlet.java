package com.wyc.servlet;

import com.wyc.bean.VideoInfo;
import com.wyc.bean.remarkInfo;
import com.wyc.dao.VideoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/VideoServlet")
public class VideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VideoDAO videoDAO=new VideoDAO();
        String videoID=request.getParameter("videoID");
        if(request.getSession().getAttribute("videoID1")==null)
      request.getSession().setAttribute("videoID1",videoID);
      String videoID1=(String) request.getSession().getAttribute("videoID1");
        if(!videoID.equals(videoID1)){
            request.getSession().removeAttribute("videoBoard1");
        }
        int videoId=Integer.parseInt(videoID);
        String videoAddress=request.getParameter("videoAddress");
        String videoName=request.getParameter("videoName");

        if(request.getParameter("videoBoard")!=null){
            int videoBoard=Integer.parseInt(request.getParameter("videoBoard"));
            if(request.getSession().getAttribute("videoBoard1")==null){
                request.getSession().setAttribute("videoBoard1",videoBoard);
            }else{
                int temp=(Integer) request.getSession().getAttribute("videoBoard1");
                request.getSession().setAttribute("videoBoard1",++temp);
            }
            Integer videoBoard1=(Integer)request.getSession().getAttribute("videoBoard1");
            try {
                videoDAO.changeVideoBoard(++videoBoard1,videoId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        String showVideoPic=request.getParameter("videoPic");
        request.getSession().setAttribute("showVideoPic",showVideoPic);
        if(request.getSession().getAttribute("videoAddress")!=null){
            videoAddress=(String) request.getSession().getAttribute("videoAddress");
        }else{
            request.getSession().setAttribute("videoAddress",videoAddress);
        }

            request.getSession().setAttribute("videoName",videoName);

        List<remarkInfo>list=null;
        try {
           list= videoDAO.selectRemarkInfo(videoId);
           request.getSession().setAttribute("allvideoInfo",list);
           request.getSession().setAttribute("videoID",videoId);
           request.getSession().setAttribute("videoAddress",videoAddress);
           request.getSession().setAttribute("videoName",videoName);
           response.sendRedirect("/myWeb_war_exploded/vedio.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }
}
