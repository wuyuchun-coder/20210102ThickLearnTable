package com.wyc.servlet;

import com.wyc.bean.Applicant;
import com.wyc.dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/codeServlet")
public class codeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
String email=request.getParameter("email");
String password=request.getParameter("password");
String newpassword=request.getParameter("newpassword");
        ApplicantDAO applicantDAO=new ApplicantDAO();
        Applicant checkapplicant=null;
        try {
            checkapplicant=applicantDAO.selectUserByEmailAndPassword(email,password);
            if(checkapplicant!=null)
            {

                boolean flag=applicantDAO.changeAppllicantPassword(email,newpassword);
                if(flag){
                    response.sendRedirect("personPage.jsp");
                }
                else{
                    PrintWriter writer=response.getWriter();
                    writer.println("<script type='text/javascript'>");
                    writer.println("alert('密码修改失败！');");
                    writer.print("window.location='personPage.jsp';");
                    writer.print("</script>");
                    writer.flush();
                    writer.close();
                }

            }

            else{

                PrintWriter writer=response.getWriter();
                writer.println("<script type='text/javascript'>");
                writer.println("alert('密码验证错误！');");
                writer.print("window.location='personPage.jsp';");
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
