package com.wyc.servlet;

import com.wyc.dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/adminCodeChangeServlet")
public class adminCodeChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    String changeUserId=request.getParameter("changeUserId");
    String changeUserPassword=request.getParameter("changeUserPassword");
        ApplicantDAO applicantDAO=new ApplicantDAO();
        try {
            if(applicantDAO.changeAppllicantPassword(changeUserId,changeUserPassword)){
                PrintWriter writer=response.getWriter();
                writer.println("<script type='text/javascript'>");
                writer.println("alert('密码修改成功！');");
                writer.print("window.location='adminPage.jsp';");
                writer.print("</script>");
                writer.flush();
                writer.close();
            }
            else{
                PrintWriter writer=response.getWriter();
                writer.println("<script type='text/javascript'>");
                writer.println("alert('密码修改失败！');");
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
