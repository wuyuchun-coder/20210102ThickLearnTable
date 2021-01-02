package com.wyc.servlet;

import com.wyc.bean.ApplicantInfo;
import com.wyc.dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userAllInfoServlet")
public class userAllInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicantDAO applicantDAO=new ApplicantDAO();
        String applicantEmail=(String) request.getSession().getAttribute("APPLICANT_EMAIL");
        String headshot=(String)request.getSession().getAttribute("filename");
        String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8");
        String age=request.getParameter("age");
        String sex=new String(request.getParameter("sex").getBytes("iso-8859-1"),"UTF-8");
        String year=request.getParameter("year");
        String month=request.getParameter("month");
        String day=request.getParameter("day");

        request.getSession().setAttribute("year",year);
        request.getSession().setAttribute("month",month);
        request.getSession().setAttribute("day",day);
        String birthday=year+"-"+month+"-"+day;
        String telephone=request.getParameter("telephone");
        ApplicantInfo applicantInfo=new ApplicantInfo(applicantEmail,name,age,sex,birthday,telephone,headshot);
        if(applicantInfo!=null){
            try {
                if(applicantDAO.saveApplicantInfo(applicantInfo)){
                    request.getSession().setAttribute("applicantInfo",applicantInfo);
                   response.sendRedirect("index.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
