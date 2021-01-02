package com.wyc.servlet;

import com.wyc.dao.VideoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/VideoNameServlet")
public class VideoNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String videoName=request.getParameter("VideoName");
            String videoType=request.getParameter("type");
        VideoDAO videoDAO=new VideoDAO();
        try {
            if(videoName!=null&&videoType!=null){
                request.getSession().setAttribute("VideoName",videoName);
                request.getSession().setAttribute("type",videoType);
                response.sendRedirect("CoueseInfoAdd.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }
}
