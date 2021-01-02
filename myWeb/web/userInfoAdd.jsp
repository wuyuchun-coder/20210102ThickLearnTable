<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Option</title>
    <script>
        // 获取日期
        var today = new Date();
        // 获取当前年月日
        var year  = today.getFullYear();
        var month = today.getMonth();
        var data  = today.getDate();

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
	<style type="text/css">
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
	</style>
    <style type="text/css">
    	.takePic{
			border:5px solid black ;
			height: 80px;
			width: 80px;
			border-radius:80px ;

		}
    	 .button {
        width: 200px;  
        padding:8px;  
        background-color: green;  
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
       #smallperson{
        width: 30px;
        height: 30px;
        background-color: red;
        position: absolute;//绝对定位
    }

    </style>
</head>
<body>
	<script>
		function adduserInfo(){
			userInfo.action("");
			userInfo.submit();
		}
	</script>
	
	<div align="center"><font size="6"><strong>个人信息填写</strong></font></div>
	<div>
		 <img id="smallperson" src="img/run.gif" style="width: 50px;height: 50px;"/>


	</div>
	<script>
        function move() {
            var a=document.getElementById("smallperson");
            var id=setInterval(frame,5);//无限循环
            var pos=0;
            function frame() {
                if (pos==1520){ 
                    a.style.left=0;
                    pos=0;//清理无限循环
                } else {
                    pos++;
                    a.style.left=pos+"px";
                }

            }
         
        }
        move();
    </script>
	<div align="center"style="margin-top:150px;margin-right:40px ;">
	<div style="float: left"><img src="img/奔跑小人.png"/></div>
	<div style="margin-left: 300px;float: left;">
		<form action="/myWeb_war_exploded/userInfoServlet"id="picInfo"method="post"enctype="multipart/form-data">
			<label><strong>上传头像</strong></label>
			<div class="takePic" style="margin-bottom: 20px">
				<img src="img/${filename}" style="width:80px;height: 80px;border-radius:50% ;">
			</div>
			<label for="fileinp">
				<input type="button" id="btn" value="点我上传"style="margin-bottom: 20px"><span id="text"></span>
				<input type="file" id="fileinp" name="file" value="上传文件" style="width: 50px">
				<input type="submit"value="保存"style="margin-left: 70px">
			</label>
		</form>
	<form action="/myWeb_war_exploded/userAllInfoServlet" id="userInfo"method="post">

		<div style="margin-bottom: 30px;">
			<font><strong>姓名</strong></font>
			<input type="text"width="200px" style="border: 2px solid green;"name="name"/>
		</div>
		<div style="margin-bottom: 30px;" >
    	<font><strong>年龄</strong></font>
    	<input type="text" style="border: 2px solid green;width: 20px;"align="center"name="age"/>
        </div>
    <div style="margin-bottom: 30px;">
    	<font><strong>性别</strong></font>
    	<input type="radio"value="男"checked="" name="sex"/>
    	<input type="radio"value="女" name="sex"/>
    </div>
		<div style="margin-bottom: 30px;">
			<font><strong>出生日期</strong></font>
    <select id="year" onchange="doChange()"name="year"></select>
    <select id="month" onchange="doChange()"name="month"></select>
    <select id="date"name="day"></select>
    </div>
   
    
    <div style="margin-bottom: 30px;">
    	<font><strong>电话号码</strong></font>
    	<input type="text"width="200px" style="border: 2px solid green;"name="telephone"/>
    </div>
    <div>
    	<input type="submit" class="button"value="提交">
    </div>
    
	</form>
	</div>
	<div style="float: left;margin-left:250px;">
		<img src="img/小人.png"/>
	</div>
	</div>
</body>
</html>