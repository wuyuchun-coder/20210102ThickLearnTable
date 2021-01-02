package com.wyc.servlet;

import com.wyc.bean.ApplicantInfo;
import com.wyc.dao.ApplicantDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/videoAddServlet")
public class videoAddServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        response.setContentType("text/html;charset=UTF-8");
        String type=(String) request.getParameter("type");
        ApplicantDAO applicantDAO=new ApplicantDAO();
        //读取请求Body
        byte[] body = readBody(request);
        //取得所有Body内容的字符串表示
        String textBody = new String(body, "utf-8");
        //取得上传的文件名称
        String fileName = getFileName(textBody);


        //取得文件开始与结束位置
        videoAddServlet.Position p =getFilePosition(request, textBody);
        //输出至文件
        writeTo(fileName, body, p);

        if(request.getSession().getAttribute("addvideoName")==null)
        request.getSession().setAttribute("addvideoName",fileName);
        else
        request.getSession().setAttribute("addvideoPic",fileName);

    }
    class Position {

        int begin;
        int end;

        public Position(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
    private videoAddServlet.Position getFilePosition(HttpServletRequest request, String textBody) throws IOException {
        //取得文件区段边界信息
        String contentType = request.getContentType();
        String boundaryText = contentType.substring(contentType.lastIndexOf("=") + 1, contentType.length());
        //取得实际上传文件的气势与结束位置
        int pos = textBody.indexOf("filename=\"");
        pos = textBody.indexOf("\n", pos) + 1;
        pos = textBody.indexOf("\n", pos) + 1;
        pos = textBody.indexOf("\n", pos) + 1;
        int boundaryLoc = textBody.indexOf(boundaryText, pos) - 4;
        int begin = ((textBody.substring(0, pos)).getBytes("ISO-8859-1")).length;
        int end = ((textBody.substring(0, boundaryLoc)).getBytes("ISO-8859-1")).length;

        return new videoAddServlet.Position(begin, end);
    }
    private String getFileName(String requestBody) {
        String fileName = requestBody.substring(requestBody.indexOf("filename=\"") + 10);
        fileName = fileName.substring(0, fileName.indexOf("\n"));
        fileName = fileName.substring(fileName.indexOf("\n") + 1, fileName.indexOf("\""));

        return fileName;
    }
    private void writeTo(String fileName, byte[] body, videoAddServlet.Position p) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:/IDEA/apache-tomcat-9.0.37/webapps/artifacts/myWeb_war_exploded/img/" + fileName);
        fileOutputStream.write(body, p.begin, (p.end - p.begin));
        fileOutputStream.flush();
        fileOutputStream.close();
    }
    private byte[] readBody(HttpServletRequest request) throws IOException {
        //获取请求文本字节长度
        int formDataLength = request.getContentLength();
        //取得ServletInputStream输入流对象
        DataInputStream dataStream = new DataInputStream(request.getInputStream());
        byte body[] = new byte[formDataLength];
        int totalBytes = 0;
        while (totalBytes < formDataLength) {
            int bytes = dataStream.read(body, totalBytes, formDataLength);
            totalBytes += bytes;
        }
        return body;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/myWeb_war_exploded/CoueseInfoAdd.jsp");
       /* if(request.getPart("fileip")!=null){
            Part part=request.getPart("fileinp");
           fileName=part.getSubmittedFileName();
            request.getSession().setAttribute("picfileAddress",fileName);
            response.sendRedirect("userinfoAdd.jsp");
        }*/
        /*String fileName=null;
        if((String) request.getSession().getAttribute("filename")!=null){
            response.sendRedirect("userInfoAdd.jsp");
        }
        fileName=(String) request.getSession().getAttribute("filename");*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
