package com.wyc.servlet;

import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/loginOutServlet")
public class loginOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Enumeration e=request.getSession().getAttributeNames();
        while(e.hasMoreElements()){
            String sessionName=(String)e.nextElement();
         if (sessionName=="filename"||sessionName=="applicantInfo"||sessionName=="User")
           request.getSession().removeAttribute(sessionName);
        }
        response.sendRedirect("/myWeb_war_exploded/index.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
    }
}
