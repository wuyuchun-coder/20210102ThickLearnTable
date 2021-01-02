package com.wyc.servlet;

import com.wyc.dao.VideoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/allVideoInfoAddServlet")
public class allVideoInfoAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String videoName=(String)request.getSession().getAttribute("VideoName");
        String videotype=(String)request.getSession().getAttribute("type");
        String addvideoName=(String)request.getSession().getAttribute("addvideoName");
        String addvideoPic=(String)request.getSession().getAttribute("addvideoPic");
        VideoDAO videoDAO=new VideoDAO();
        try {
           if( videoDAO.setVideoName(videoName,videotype,addvideoName,addvideoPic)){
               PrintWriter writer=response.getWriter();
               writer.println("<script type='text/javascript'>");
               writer.println("alert('添加课程成功！');");
               writer.print("window.location='CoueseInfoAdd.jsp';");
               writer.print("</script>");
               writer.flush();
               writer.close();
           }else{
               PrintWriter writer=response.getWriter();
               writer.println("<script type='text/javascript'>");
               writer.println("alert('添加课程失败');");
               writer.print("window.location='CoueseInfoAdd.jsp';");
               writer.print("</script>");
               writer.flush();
               writer.close();
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }
}
