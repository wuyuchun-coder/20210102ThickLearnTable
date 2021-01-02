package com.wyc.servlet;

import com.wyc.bean.VideoInfo;
import com.wyc.dao.VideoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/adminCourseServlet")
public class adminCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            String courseName=request.getParameter("courseName");
            String courseType=request.getParameter("courseType");
        VideoDAO videoDAO=new VideoDAO();
        try {
            if(videoDAO.changeVideoType(courseName,courseType)){
                PrintWriter writer=response.getWriter();
                writer.println("<script type='text/javascript'>");
                writer.println("alert('课程修改成功！');");
                writer.print("window.location='adminPage.jsp';");
                writer.print("</script>");
                writer.flush();
                writer.close();
            }
            else{
                PrintWriter writer=response.getWriter();
                writer.println("<script type='text/javascript'>");
                writer.println("alert('课程修改失败！');");
                writer.print("window.location='adminPage.jsp';");
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
