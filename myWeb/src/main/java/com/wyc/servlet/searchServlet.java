package com.wyc.servlet;

import com.wyc.bean.VideoInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String searchcontent=request.getParameter("search");
     List<VideoInfo> list=new ArrayList<>();
     list=(List<VideoInfo>) request.getSession().getAttribute("videoList");
     List<VideoInfo> searchlist=new ArrayList<>();
     for(VideoInfo video:list){
         if(video.getVideoname().contains(searchcontent)){
             searchlist.add(video);
         }
     }
     request.getSession().setAttribute("searchlist",searchlist);
     response.sendRedirect("/myWeb_war_exploded/searchPage.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
