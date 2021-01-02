package com.wyc.servlet;

import com.wyc.bean.ApplicantInfo;
import com.wyc.dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/personInfoChangeServlet")
public class personInfoChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        ApplicantDAO applicantDAO = new ApplicantDAO();
        ApplicantInfo applicantInfo1=(ApplicantInfo)request.getSession().getAttribute("applicantInfo") ;
        String applicantEmail =applicantInfo1.getapplicantEmail();
        String headshot = (String) request.getSession().getAttribute("filename");
        String name =request.getParameter("name");
        String age = request.getParameter("age");
        String sex =request.getParameter("sex");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        request.getSession().setAttribute("year", year);
        request.getSession().setAttribute("month", month);
        request.getSession().setAttribute("day", day);
        String birthday = year + "-" + month + "-" + day;
        String telephone = request.getParameter("telephone");
        ApplicantInfo applicantInfo = new ApplicantInfo(applicantEmail, name, age, sex, birthday, telephone, headshot);
        if (applicantInfo != null) {
            try {
                if (applicantDAO.updateApplicantInfo(applicantInfo)) {
                    request.getSession().setAttribute("applicantInfo", applicantInfo);
                    response.sendRedirect("personPage.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }
}
