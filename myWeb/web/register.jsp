<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册</title>
		<style name="topLine" type="text/css">
		.topLine{
			margin-left: 160px;
		}
		.imginstance{
			margin-left:270px ;
		}
		.logintext{
			margin-left:500px ;
			margin-top:100px ;
		}
		.logintext .b1:hover{
			color: green;
		}
			#email{

			}
			#password{

			}
		</style>
	</head>
	<body>
	<script>
		function  validate() {
			var email = document.getElementsById("email");
			var password = document.getElementById("password");
			var pattern = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z-Z0-9]+\.([a.zA-Z]{2,4})$/;
			if (email == '') {
				alert("email不能为空");
				return false
			} else if (pattern.test(email)) {
				alert("email格式不正确");
				return false
			}
			//验证password
			if (password == '') {
				alert("password不能为空！");
				return false;
			} else if (password.length < 6 || password.length > 12) {
				alert("密码长度在6-8个字符之间!")
				return false;
			}
			return true;
		}
	</script>
		<div>
			<!--顶部图案-->
			<div>
				<div class="topLine">
				<img src="在线学习管理平台/img/注册图标.png"width="40px"/>
				<img src="在线学习管理平台/img/注册账号.png"width="80px"/>
				<img src="在线学习管理平台/img/学习，从现在开始.png"width="300px"class="imginstance"/>
				<img src="在线学习管理平台/img/笑脸.png" width="80px"style="margin-left: 230px;"/>
				</div>
				
			</div>
			<!--账号-->
			<form action="registerServlet"method="post" onsubmit="return validate()">
			<div class="logintext">
				
				<div style="margin-top: 20px; float: left;"><img src="在线学习管理平台/img/注册账号.png"width="100px"></div>
				<div><input type="text" style="width: 200px;height: 32px;margin-top: 15px;"id="email"name="email"></div>
				<div></div>
				<div><img src="在线学习管理平台/img/密码.png" width="50px"style="margin-left: 50px;float: left;margin-top: 15px;"></div>
				<div><input type="text" style="width: 200px;height: 32px;margin-top:15px;"id="password"name="password"></div>
				<div >
					<input type="submit" name="提交"value="立即注册"class="b1"style="border-color: green;background-color:grey;font-size:large;width: 200px;height: 30px;margin-left: 60px;margin-top:50px ;"/>
				</div>
			</div>
			
			</form>
			
		</div>
	</body>
</html>
