package com.wyc.servlet;

import com.wyc.bean.Applicant;
import com.wyc.dao.VideoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/remarkServlet")
public class remarkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        VideoDAO videoDAO=new VideoDAO();
        String remarkcontent=request.getParameter("content");
        Date date=new Date();

        Applicant applicant=(Applicant) request.getSession().getAttribute("User");
        String remarktime=(date.getYear()+"-"+date.getMonth()+"-"+date.getDay());
        int videoId=(int)request.getSession().getAttribute("videoID");
        try {
            if(applicant!=null){
                videoDAO.saveRemark(remarkcontent,remarktime,applicant.getApplicantEmail(),videoId);
                response.sendRedirect("/myWeb_war_exploded/VideoServlet?videoID="+videoId);
            }else{
                PrintWriter writer=response.getWriter();
                writer.println("<script type='text/javascript'>");
                writer.println("alert('未登录');");
                writer.print("window.location='index.jsp';");
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
