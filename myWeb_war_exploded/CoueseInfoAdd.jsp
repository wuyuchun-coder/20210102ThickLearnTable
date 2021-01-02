<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<div align="center"style="background-color: black;">
			<label><strong style="color: white;">欢迎登录！管理员</strong></label>
		</div>
	
	<div align="center">
	<div style="margin-top:200px ;display: block;" id="page4">

			<form action="/myWeb_war_exploded/VideoNameServlet">
				<div>
					<label>

						<label>视频名称 :
							<input type="text"height="40px" name="VideoName">

						</label>


					</label>
				</div>
				<div>
					<label >
						<label>类别:
							<input type="radio"value="动漫"checked="" name="type"/>动漫
							<input type="radio"value="计算机" name="type"/>计算机
							<input type="radio"value="电影" name="type"/>电影
							<input type="radio"value="纪录片" name="type"/>纪录片
						</label>
	<br>
						<input type="submit">
					</label>
				</div>
			</form>
			<form action="/myWeb_war_exploded/videoAddServlet"id="VideoInfo"method="post"enctype="multipart/form-data">
				<label >
					<label>上传视频:</label>
					<input type="file" name="video"id="video"value="上传视频">
					<input type="submit"value="保存"style="margin-left: 30px">
				</label>
			</form>
			<form action="/myWeb_war_exploded/videoAddServlet"id="picVideo" method="post"enctype="multipart/form-data">
				<label >
					<label>上传封面:</label>
					<input type="file" name="videoPic"id="videoPic"value="上传封面">
					<input type="submit"value="保存"style="margin-left: 30px">
				</label>
			</form>
			<div><button type="button"><a href="/myWeb_war_exploded/allVideoInfoAddServlet"style="text-decoration: none">提交</a></button></div>
			<div><button type="button"><a href="adminPage.jsp"style="text-decoration: none">返回</a></button></div>
		</div>
</div>

	</body>
</html>
