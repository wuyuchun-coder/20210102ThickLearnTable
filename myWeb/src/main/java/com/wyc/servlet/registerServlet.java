package com.wyc.servlet;

import com.wyc.bean.Applicant;
import com.wyc.dao.ApplicantDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String email=(String) request.getParameter("email");
        String password=(String)request.getParameter("password");
        Applicant applicant=new Applicant(email,password);
        ApplicantDAO applicantDAO=new ApplicantDAO();
        Integer count=null;

        try {
            count=applicantDAO.selectIdNum(applicant);
            if(count>0){
                PrintWriter writer=response.getWriter();
                writer.write("<script>");
                writer.write("alert('申请注册的email已经被占用！');");
                writer.write("window.location.href='register.jsp'");
                writer.write("</script>");
            }
            else {
                boolean flag=applicantDAO.saveApplicant(applicant);
                if(flag){
                    Applicant applicant1=applicantDAO.selectUserByEmailAndPassword(applicant.getApplicantEmail(),applicant.getApplicantPwd());
                    request.getSession().setAttribute("APPLICANT_EMAIL",applicant1.getApplicantEmail());
                    request.getSession().setAttribute("User",applicant1);
                    response.sendRedirect("userInfoAdd.jsp");
                }else{
                    PrintWriter writer=response.getWriter();
                    writer.write("<script>");
                    writer.write("alert('注册失败！请重新注册');");
                    writer.write("window.location.href='register.jsp'");
                    writer.write("</script>");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
                    dispatcher.forward(request,response);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
