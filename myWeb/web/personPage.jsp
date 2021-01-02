<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			.colorchange{
				
				
			}
			.colorchange div:hover{
				background-color: green;
			}
			.pic{
				border:5px solid black ;
				height: 80px;
				width: 80px;
				border-radius:80px ;
				margin-top: 20px;
			}
			.picinstance{
				margin-top: 30px;
			}
			#page1{
				
			}
			#page2{
				
			}
			#page3{
				
			}
			label{
			position: relative;
		}
		#fileinp{
			position: absolute;
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
			.button {  
        width: 200px;  
        padding:8px;  
        background-color: black;  
        border-color: #357ebd;  
        color: #fff;  
        -moz-border-radius: 10px;  
        -webkit-border-radius: 10px;  
        border-radius: 10px; /* future proofing */  
        -khtml-border-radius: 10px; /* for old Konqueror browsers */  
        text-align: center;  
        vertical-align: middle;  
        border: 1px solid transparent;  
        font-weight: 900;  
        font-size:125%  
      }  
		</style>
	</head>
	<body>
	<script>
		// 获取日期
		var today = new Date();
		// 获取当前年月日
		var year  = ${year};
		var month =${month}-1;
		var data  = ${day};

		window.onload = function(){
			// 循环年份并且显示到页面
			for( var i = year ; i >= year-50 ; i--){
				var option = new Option( i , i );
				// 如果年份等于当前年份 就默认选择
				if( i == year ){
					option.selected = true;
				}
				// 添加到id为year的select中
				$('year').add(option);
				console.log($('year').value)
			}
			// 循环月份
			for(var j = 1 ; j <= 12 ;j++){
				var option = new Option( j , j );
				if( ( j - 1 ) == month ) {
					option.selected = true;
				}
				$('month').add(option);
			}

			// 页面加载调用doChange事件
			doChange();
		}
		// 年份和月份改变的时候调用此事件
		function doChange(){
			// 把$('date')中的option长度变为0
			$('date').options.length = 0;
			var length = 31;
			// 获取月份
			var mon = $('month').value;
			// 如果是2月
			if(mon == 2)
			{
				// 平年就是28
				length = 28;
				// 获取年份
				var num = $('year').value;
				// 判断是不是闰年 闰年就是29
				if(( num % 4  == 0 && num % 100 != 0 ) ||  num % 400 == 0 )
				{
					length++;
				}
			}
			// 定义正则判断月份 4 6 9 11 月
			var reg = / [469]|^11$/;
			// 符合条件就是30天
			if(reg.test(mon))
			{
				length = 30;
			}
			// 然后循环 把值塞进去
			for( var k = 1 ; k <= length ; k++ ){
				var option = new Option( k , k );
				$('date').add(option);
			}
		}
		// 封装获取id的简化函数
		function $(id) {
			return document.getElementById(id);
		}
	</script>
		<script>
			function function1(){
				var a=document.getElementById("page1");
				var b=document.getElementById("page2");
				var c=document.getElementById("page3");
			
				a.style.display='block';
				b.style.display='none'
				c.style.display='none'
			}
			function function2(){
				var a=document.getElementById('page1');
				var b=document.getElementById('page2');
				var c=document.getElementById('page3');
				a.style.display='none';
				b.style.display='block'
				c.style.display='none'
			}
			function function3(){
				var a=document.getElementById('page1');
				var b=document.getElementById('page2');
				var c=document.getElementById('page3');
				a.style.display='none';
				c.style.display='block'
				b.style.display='none'
			}
			
		</script>
		<div align="center">
			<div style="background-color: #000000;margin-top: 0px;"><label style="color: white;"><font size="5">个人中心</font></label></div>
		</div>
		<div style="width: 1520px;height: 30px;background-color: #000000;"class="colorchange">
		<div align="center"style="float: left;width: 30%;">
			<font color="white"><a style="text-decoration: none;color: white;cursor: pointer;"onclick="function1()">个人信息</a></font>
		</div>
		<div align="center"style="float: left;width: 40%;">
			<font color="white"><a style="text-decoration: none;color: white;cursor: pointer;"onclick="function2()">个人信息修改</a></font>
		</div>
		<div align="center"style="float: left;width: 30%;">
			<font color="white"><a style="text-decoration: none;color: white;cursor: pointer;"onclick="function3()">密码修改</a></font>
		</div>
		</div>
	
		<div align="center">
			<div style="margin-top:20px ;width: 600px;height: 600px;background-color: grey;position: relative;"align="center">
				<div align="center"style="margin-top: 20px;margin-left:250px;position: absolute;display: block;"id="page1">
					<div class="pic">
				<img src="img/${filename}"style="width: 80px;height: 80px;border-radius:50% ;"/>
					</div>
					<div style="color: white;margin-top:20px ;">
						<span><label>姓名:${applicantInfo.getName()}</label></span>
					</div>
					<div class="picinstance"><label>年龄:${applicantInfo.getAge()}</label></div>
					<div class="picinstance"><label>性别:${applicantInfo.getSex()}</label></div>
					<div class="picinstance"><label>出生日期:${applicantInfo.getBirthday()}</label></div>
					<div class="picinstance"><label>电话号码:${applicantInfo.getTelephone()}</label></div>
				</div>
				<div align="center"style="margin-top: 20px;margin-left:250px;position: absolute;display: none;"id="page2">
					<form method="post"action="/myWeb_war_exploded/ServletPicchange"id="pc1" enctype="multipart/form-data">
					<div class="pic">
				<img src="img/${filename}"style="width: 80px;height: 80px;border-radius:50% ;"/>
					</div>
					<div>
						<label for="fileinp">
				<input type="button" id="btn" value="修改头像"style="margin-bottom: 20px"><span id="text"></span>
				<input type="file" id="fileinp" name="file" value="上传文件" style="width: 50px;cursor: pointer;">
				<input type="submit"value="保存"style="margin-left: 30px;cursor: pointer;">
			</label>
					</div>
					</form>
					<form action="/myWeb_war_exploded/personInfoChangeServlet"method="post">
					<div style="color: white;margin-top:20px ;">
						<span><label>姓名:<input type="text"value="${applicantInfo.getName()}"name="name"></label></span>
					</div>
					<div class="picinstance"><label>年龄:<input type="text"value="${applicantInfo.getAge()}"name="age"></label></div>
					<div class="picinstance"><label>性别:<input type="text"value="${applicantInfo.getSex()}"name="sex"></label></div>
					<div class="picinstance"><label>出生日期:<select id="year" onchange="doChange()"name="year"></select>
						<select id="month" onchange="doChange()"name="month"></select>
						<select id="date"name="day"></select></label></div>
					<div class="picinstance"><label>电话号码:<input type="text" value="${applicantInfo.getTelephone()}"name="telephone"></label></div>
						<div><input type="submit"value="提交"width="100px"style="margin-top: 50px;width: 100px;"></div>
					</form>
				</div>
				<div id="page3"style="display: none;"align="center">
					<form action="/myWeb_war_exploded/codeServlet">
					<div style="margin-bottom: 120px;"><label><strong ><font size="5">密码修改</font></strong></label></div>
					<div style="margin-bottom: 50px;">
						<label>请输入账号:</label>
					<input type="text"style="width: 200px;"name="email"/>
					</div>
					<div style="margin-bottom: 50px;">
						<label>请输入原密码:</label>
					<input type="text"style="width: 200px;"name="password"/>
					</div>
						<div style="margin-bottom: 50px;">
							<label>请输入新密码:</label>
							<input type="text"style="width: 200px;"name="newpassword"/>
						</div>
					<div>
						<input type="submit"class="button"style="cursor: pointer;"/>
					</div>

					</form>
				</div>
				<div id="page4"style="display: none;"align="center">
					<form action="/myWeb_war_exploded/codeChangeServlet">
						<div style="margin-bottom: 120px;"><label><strong ><font size="5">设置新密码</font></strong></label></div>
						<div style="margin-bottom: 50px;">
							<label>请输入账号:</label>
							<input type="text"style="width: 200px;"name="email"/>
						</div>
						<div style="margin-bottom: 50px;">
							<label>请输入新密码:</label>
							<input type="text"style="width: 200px;"name="password"/>
						</div>
						<div>
							<input type="submit"class="button"style="cursor: pointer;"/>
						</div>

					</form>
				</div>
			</div>
		</div>
	</body>
</html>
