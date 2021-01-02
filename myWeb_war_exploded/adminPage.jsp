<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<style>
		.colorchange{
			background: black;
			width: 200px;
			height: 50px;
			text-align: center;
			vertical-align: middle;
		}
		.colorchange:hover{
			background: green;
		}
		.colorchange.active{
			display: none;
		}
		#choc1{

		}
		#choc2{

		}
		#choc3{

		}
	</style>

	<style>
		label{

		}
		#fileinp{

			left: 0;
			top: 0;
			opacity: 0;
		}
		#btn{
			margin-right: 5px;
		}
		#text{
			color: red;
		}
		label{

		}
		#fileinp1{

			left: 0;
			top: 0;
			opacity: 0;
		}
		#btn1{
			margin-right: 5px;
		}
		#text1{
			color: red;
		}
		#checkbox{

		}
		#page4{

		}
		#page5{

		}
	</style>
</head>
<body>
<script>
	function hide(){
		document.getElementById('choc1').style.display='none';
		document.getElementById('choc2').style.display='none';
		document.getElementById('choc3').style.display='none';
	}
	function hide(){
		document.getElementById('choc1').style.display='none';
		document.getElementById('choc2').style.display='none';
		document.getElementById('choc3').style.display='none';
		document.getElementById('choc4').style.display='none';

	}
	function hide1(){
		document.getElementById('choc1').style.display='none';
		document.getElementById('choc2').style.display='none';
		document.getElementById('choc3').style.display='none';
		document.getElementById('choc4').style.display='none';
		document.getElementById('page5').style.display='block';
	}
	function hide2(){
		document.getElementById('choc1').style.display='none';
		document.getElementById('choc2').style.display='none';
		document.getElementById('choc3').style.display='none';
		document.getElementById('choc4').style.display='none';
		document.getElementById('page6').style.display='block';
	}
	function change(){
		document.getElementById('choc1').style.display='block';
		document.getElementById('choc2').style.display='block';
		document.getElementById('choc3').style.display='block';
		document.getElementById('choc4').style.display='block';

	}
	function change1(){
		document.getElementById('choc1').style.display='block';
		document.getElementById('choc2').style.display='block';
		document.getElementById('choc3').style.display='block';
		document.getElementById('choc4').style.display='block';
		document.getElementById('page5').style.display='none';
	}
	function change2(){
		document.getElementById('choc1').style.display='block';
		document.getElementById('choc2').style.display='block';
		document.getElementById('choc3').style.display='block';
		document.getElementById('choc4').style.display='block';
		document.getElementById('page6').style.display='none';
	}
	function logoutAdmin() {
		logout.action="/myWeb_war_exploded/loginOutServlet";
		logout.submit();
	}
</script>
<div align="center"style="background-color: black;">
	<label><strong style="color: white;">欢迎登录！管理员</strong></label>

</div>
<div align="center">
	<div align="center"style="margin-top: 100px;display: block;"id="choc1">
		<div class="colorchange"><a style="cursor: pointer;color: white;text-align: center;padding-top: 10px;text-decoration: none;"href="CoueseInfoAdd.jsp">课程发布</a
		></div>
	</div>
	<div align="center"style="margin-top: 100px;display: block;"id="choc2"onclick="hide1()">
		<div class="colorchange"><p style="cursor: pointer;color: white;text-align: center;padding-top: 10px;">课程分类</p
		></div>
	</div>
	<div align="center"style="margin-top: 100px;display: block;"id="choc3"onclick="hide2()">
		<div class="colorchange"><p style="cursor: pointer;color: white;text-align: center;padding-top: 10px;">用户密码修改</p
		></div>

	</div>
	<form id="logout" onclick="logoutAdmin()">
	<div align="center"style="margin-top: 100px;display: block;"id="choc4"onclick="hide2()">
		<div class="colorchange"><p style="cursor: pointer;color: white;text-align: center;padding-top: 10px;">退出</p
		></div>

	</div>
	</form>
	<div>



		<div style="margin-top:200px ;display: none;" id="page5">
			<form action="/myWeb_war_exploded/adminCourseServlet">
				<label>请输入课程名:<input type="text"height="30px"width="200px"name="courseName"></label>
				<br />
				<label>请输入课程类别:<input type="text"height="30px"width="200px"name="courseType"></label>
				<br>
				<br>
				<input type="submit"value="提交">
			</form>
			<br>
			<div><button type="button"onclick="change1()">返回</button></div>
		</div>

		<div style="margin-top:200px ;display: none;" id="page6">
			<form action="/myWeb_war_exploded/adminCodeChangeServlet">
				<label>账号:<input type="text"height="30px"width="200px"name="changeUserId"></label>
				<br />
				<label>密码:<input type="text"height="30px"width="200px"name="changeUserPassword"></label>
				<br>
				<br>
				<input type="submit"value="提交">
			</form>
			<br>
			<div><button type="button"onclick="change2()">返回</button></div>
		</div>
	</div>

</div>
</body>

</html>
