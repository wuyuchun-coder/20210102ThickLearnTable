<%@ page import="com.wyc.bean.remarkInfo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<remarkInfo> allvideoInfo = (List<remarkInfo>) session.getAttribute("allvideoInfo");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<div align="center">
			<div style="background-color: #000000;"><label style="color: white;"><font size="4"><strong>${videoName}</strong></font></label></div>
		</div>
		<div align="center">
			<video width="800" height="600" controls poster="img/${showVideoPic}">
			<source src="img/${videoAddress}"type="audio/mp4"></source>
			<source src="img/${videoAddress}" type="video/ogg">
		</video>
		
		</div>
		<!--评论区-->
		<div>
			<form action="${pageContext.request.contextPath}/remarkServlet">
	<div align="center">
	<h1>留言板</h1>
	<div>下方可填写评论</div>

	<textarea id="content" name="content"style="width: 1520px;height:100px"></textarea>
	<span>&nbsp;</span>
	<label>
	<input type="submit" class="button" value="提交"/>
	</label>
			</div>
			</form>
		</div>
		<!--该视频的所有评论-->
		<div>
			<table style="border-spacing: 20px;"border="2px">
				<th width="400px">评论人
				</th>
				<th width="1120px">内容
				</th >
				<%
      if(allvideoInfo!=null){
    	  for(remarkInfo a:allvideoInfo){
    		  %>
    		  <tr>
    		 	 <td align="center"><%=a.getPosterEmail()%></td>
    		
    		 	 <td align="center"><%=a.getContent()%></td>
    		 	</tr>
    		 <%
    	  }
      }
    %>

				
			</table>
		</div>
		
		
	</body>
</html>
