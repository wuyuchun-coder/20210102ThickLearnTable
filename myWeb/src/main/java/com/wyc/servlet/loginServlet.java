package com.wyc.servlet;

import com.wyc.bean.Applicant;
import com.wyc.bean.ApplicantInfo;
import com.wyc.bean.remarkInfo;
import com.wyc.dao.ApplicantDAO;
import com.wyc.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email=(String) request.getParameter("email");
        String password=(String)request.getParameter("password");
        ApplicantDAO applicantDAO=new ApplicantDAO();
        Applicant applicant=new Applicant(email,password);
        Applicant applicant1=null;
        ApplicantInfo applicantInfo=new ApplicantInfo();

        try {
            applicant1=applicantDAO.selectUserByEmailAndPassword(applicant.getApplicantEmail(),applicant.getApplicantPwd());

            if(applicant1!=null){
                if(applicant1.getIsAdmin()==1){
                    response.sendRedirect("/myWeb_war_exploded/adminPage.jsp");
                }
                else{
                    applicantInfo=applicantDAO.selectApplicantInfo(applicant1.getApplicantEmail());
                    request.getSession().setAttribute("applicantInfo",applicantInfo);
                    request.getSession().setAttribute("filename",applicantDAO.selectHeadShot(applicant1));
                    request.getSession().setAttribute("User",applicant1);
                    String []date=new String[3];
                    int num=0;
                    for(String data:applicantInfo.getBirthday().split("-")){
                        date[num++]=data;
                    }
                    request.getSession().setAttribute("year",date[0]);
                    request.getSession().setAttribute("month",date[1]);
                    request.getSession().setAttribute("day",date[2]);
              /*  List<remarkInfo>list=new ArrayList<>();
                list.add(new remarkInfo("哈哈哈哈哈","2020/12/29","123456"));
                request.getSession().setAttribute("allvideoInfo",list);*/
                    response.sendRedirect("index.jsp");
                }

            }
            else{
                PrintWriter writer=response.getWriter();
                writer.println("<script type='text/javascript'>");
                writer.println("alert('账号或密码输入错误！');");
                writer.print("window.location='index.jsp';");
                writer.print("</script>");
                writer.flush();
                writer.close();

               /* PrintWriter out=response.getWriter();
                 out.println("<script type='text/javascript'>");
                out.println("alert('password is error');");
                out.println("window.location='userpasschange.jsp'");
                out.println("</script>");*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
