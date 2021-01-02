<%@ page import="com.wyc.bean.VideoInfo" %>
<%@ page import="java.util.List" %>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
	List<VideoInfo> searchlist = (List<VideoInfo>) session.getAttribute("searchlist");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<div>
			<form action="searchServlet"method="post">
			<div style="width:100%;height: 40px;background-color: #000000;"align="center" >

				<input type="text"style="border: 4px solid white;margin-top:7px ;width: 400px;"name="search"/>
				<input type="submit"/>
			</div>
			</form>
	
		
		<div>
			<table style="border-spacing: 20px;"border="2px">
				<th width="400px">视频名称
				</th>
				<th width="1120px">内容
				</th >
			<%--<%
      if(searchlist!=null){
    	  for(VideoInfo a:searchlist){
    		  %>
    		  <tr>
    		 	 <td align="center">
    		 	 <a href="/VideoServlet"style="color: #000000;font-size: large;text-decoration: none;">a.getVideoname()</a>
    		 	 	
    		 	 </td>
    		
    		 	 <td align="center"><div><video width="320" height="240" controls poster="img/head1.jpg">
                          <source src="img/视频1.mp4" type="video/mp4">
                          <source src="视频1.mp4" type="video/ogg">
                 </video></div>
    		 	 </td>
    		  </tr>
    		 <tr>
    		 	 <td align="center">
    		 	 <a href="/VideoServlet"style="color: #000000;font-size: large;text-decoration: none;">一拳超人2</a>
    		 	 	
    		 	 </td>
    		
    		 	 <td align="center"><div><video width="320" height="240" controls poster="img/head2.png">
                          <source src="img/素材2.mp4" type="video/mp4">
                          <source src="素材2.mp4" type="video/ogg">
                 </video></div>
    		 	 </td>
    		  </tr>
    		 <%
    	  }
      }
    %>--%>
				<%
					if(searchlist!=null){
						for(VideoInfo a:searchlist){
							request.getSession().setAttribute("a",a);
				%>
				<tr>
					<td align="center">
						<a href="${pageContext.request.contextPath}/VideoServlet?videoID=${a.getVideoid()}&videoAddress=${a.getVideoaddress()}&videoName=${a.getVideoname()}&videoPic=${a.getVideopage()}&videoBoard=${a.getVideoboard()}"style="color: #000000;font-size: large;text-decoration: none;"><%=a.getVideoname()%></a>

					</td>

					<td align="center">
						<div>
							<video width="320" height="240" controls poster="img/<%=a.getVideopage()%>">
							<source src="img/<%=a.getVideoaddress()%>" type="video/mp4">
							<source src="<%=a.getVideoaddress()%>" type="video/ogg">
						</video>
						</div>
					</td>
				</tr>
				<%
						}
					}
				%>

				
			</table>
		</div>
		</div>
	</body>
</html>
