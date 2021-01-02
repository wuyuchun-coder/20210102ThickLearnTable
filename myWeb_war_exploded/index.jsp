<%@ page import="com.wyc.bean.VideoInfo" %>
<%@ page import="java.util.List" %>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%
	List<VideoInfo> videoInfo = (List<VideoInfo>) session.getAttribute("videoList");
	List<VideoInfo>videoBoardList=(List<VideoInfo>)session.getAttribute("videoBoardList");
%>
<html>
	<head>
		<meta charset="utf-8" />
		<title>在线学习平台</title>
		<style name="backgroud"type="text/css">
			.backgroudcolor{
				background-color: rgba(247,247,247,1);
				position: relative;
				}
		</style>
		<!--导航栏css-->
		<style name="webCss"type="text/css">
			#webContainer{
				width: 100%;
				height: 100%;
				position: absolute;
			}
			.tutor{
				margin-left: 160px;

			}
			.tutor .p1{
				margin-left: 30px;
				margin-top: 25px;
				float:left;

			}
			.tutor .p1 div a:hover{
				color:#00c758;
			}
			.tutor .m1{
				float: left;
			}
			.tutor .m2{
				float: left;
				margin-top: 25px;
				margin-left: 15px;
			}
			.tutor .m1 .mm1{
				float: left;
				margin-top: 15px;
				margin-left:20px ;
			}
			.tutor .m1 .mm2{
				float: left;
				margin-top: 25px;
				margin-left: -50px;
				z-index: 99;
			}
			.tutor .pic{
				border:5px solid black ;
				height: 80px;
				width: 80px;
				border-radius:80px ;
			}
			.tutor .m1 .mm2~.mm3 img{
				display: none;
			}
			.tutor .m1 .mm2:hover~.mm3 img{

				float: left;
				margin-top: -25px;
				margin-left: -50px;
				display: block;
			}

		</style>
		<!--内容区域css-->
		<style name="content"type="text/css">
			body{
				min-width: 1225px;
				}
			#search{

			}
			.clearfloat{
				clear:both;
			}
			.allcontent{
				font-size: 12px;
				color: background:rgba(247,247,247,1);
				margin-top:20px;
			}
			.allbroad{
				margin-left: 160px;
				margin-right:160px;
			}
			.allbroad .broad1{

				background-color: white;
				width: 200px;
				height:320px;
				float: left;
				}
			.allbroad .broad1 .tag{
				margin-top:8px;
				margin-left: 10px;
				font: "微软雅黑";
				font-size: 15px;

				}

			.allbroad .broad1 .tag span a{
				list-style: none;
				text-decoration: none;
				font: "微软雅黑";
				font-size: 10px;
				color: gray;
				}

			.allbroad .broad2{
				width: 800px;
				height: 320px;

				}
			.allbroad .broad2 ul .left{
				position: absolute;
				margin-left:150px ;
				}
			.allbroad .broad2 ul .center{
				position: absolute;
				z-index: 10;
				margin-left:150px ;
				}
				.allbroad .broad2 ul .right{
				position: absolute;
				margin-left:150px ;
				}
				.allbroad .broad2 ul .unset{
				position: absolute;
				margin-left:150px ;
				}
			.allbroad .broad2 ul li img{
				width: 790px;
				height: 320px;
				float: left;

				}
			.allbroad .broad2 ul li{
				list-style: none;
				}
			.allbroad .broad3{

				background-color: white;
				width: 200px;
				height:320px;
				position: relative;
				margin-left:940px ;
				}
			.allbroad .broad3 div{
				margin-top: 50px;
				position: absolute;
				align-content: center;
				}
			.allbroad .broad3 span{
				margin-top: 78px;
				margin-left: -135px;
				position: absolute;
				}
			.allbroad .broad4{
				margin-top: 10px;
				}
			.allbroad .broad4 div{
				float: left;
				margin-left:50px ;
				}
			.allcontent .backgroudcolor .computer{
				margin-left:160px;
				margin-top:20px ;
				}
				.allcontent .backgroudcolor .computer div{
					margin-top: 20px;
					}

			.allcontent .backgroudcolor .computer div span{
				margin-left: 20px;

				}

			.allcontent .backgroudcolor .computer div span font a font:hover{
				color:#00c758;
			}
			.allcontent{
				min-width: 1520px;
				}
			.tutor{
				min-width: 1520px;
				}

		</style>
		<style>
			#winlogin{
			POSITION:absolute; left:55%; top:60%;
            width:400px; height:250px;
            margin-left:-300px;margin-top:-200px; border:1px solid #888;
            background-color: darkseagreen; text-align: center;
            line-height: 60px; z-Index:21;
			}
            .hidebg {
            position:absolute; left:0px; top:0px;
            background-color:#000;
            width:100%;
            filter:alpha(opacity=60);
            opacity:0.6;
            display:none;
            z-Index:20;
        }
    </style>
	</head>

	<body >
	<script>
		function openLogin(){
			document.getElementById("winlogin").style.display="block";
			document.getElementById("hidebg").style.display="block";
			document.getElementById("hidebg").style.height="100%";
		}
		function closeLogin(){
			document.getElementById("winlogin").style.display="none";
			document.getElementById("hidebg").style.display="none";
		}

	</script>
	<div id="winlogin" class="winlogin" style="display:none">
		<form action="loginServlet" method="post">
			<span style="font-size: 20px;"> 欢迎来小站学习！！ </span> <br />
			<label class="label"> 用户名: </label> <input type="text" class="input" id="user" name="email"/> <br />
			<label class="label"> 密码: </label> <input type="password" class="input" id="psw"name="password" /> <br />
			<!--<input type="reset" value="重输" class="input1" />-->
			<input type="button" value="退出" class="input3" onclick="closeLogin();" />
			<input type="submit" value="确定" class="input2" />
		</form>
	</div>
	<div id="hidebg" class="hidebg"></div>
	<div>
		<div id="webContainer">
			<!--顶部导航栏-->

			<div class="tutor">
				<div class="m1"><img src="img/奔跑小人.png" width="70px"height="60px"/></div>
				<div class="m2"><img src="img/奔跑吧！读书人.png" width="200px"/></div>
				<div class="p1">
					<div>
						<a>课程</a>
					</div>

				</div>
				<div class="p1">

					<div>
						<a>学校</a>
					</div>
				</div>
				<div class="p1">
					<div>
						<a>学校云</a>
					</div>
				</div>
				<div class="p1">
					<div>
						<a>小课堂</a>
					</div>
				</div>
				<div class="p1">

					<div>
						<a>下载App</a>
					</div>
				</div>
				<script>
					function subForm(){
						search.action="/myWeb_war_exploded/searchServlet";
						search.submit();
					}
				</script>
				<form action="" method="post" id="search">

					<div class="m1">

						<input type="text"name="search"value="搜索"style="margin-left: -230px;border: none;outline: none;margin-top: 19px;width: 145px;height: 28px;"/>
						<div class="mm1"><img src="img/搜索栏2.png" width="250px" /></div>
						<div class="mm2"><img src="img/放大镜.png" width="35px"/></div>
						<div class="mm3"><img src="img/绿色搜索.png"width="35px" onclick="subForm()"/></div>
					</div>
				</form>

				<div class="m1">
					<div>
						<a class="p1" style="text-decoration: none;color: #000000 ;"onclick="openLogin()";>登录</a>

						<a class="p1" href="register.jsp"style="text-decoration: none;color: #000000 ;">注册</a>

						<div class="pic"style="margin-left: 147px;margin-top: 2px;"align="center">
							<a  onclick="openLogin()"><img src="img/${filename}" style="width: 80px;height: 80px;border-radius:50% ;"/></a>

						</div>
						<span class="clearfloat"></span>



					</div>


				</div>
				<div style="margin-top: 20px;float: left;margin-left:50px">

					<div><div><a style="text-decoration: none;color: #000000;cursor:pointer" href="personPage.jsp"><font size="4">个人中心</font></a></div>

					</div>
					<div><a href="/myWeb_war_exploded/loginOutServlet"style="margin-top: 20px;text-decoration: none;color: #000c17;">退出登录</a></div>
				</div>
			</div>


			<!--内容区域-->

			<div class="clearfloat"></div>
			<script type="text/javascript">

				function change(){
					var left=document.querySelector(".left");
					var center=document.querySelector(".center");
					var right=document.querySelector(".right");
					var unset=document.querySelector(".unset");
					left.className="unset";
					center.className="left";
					right.className="center";
					unset.className="right";
				}
				var timer=setInterval(change,2000);

			</script>
			<div class="allcontent">
				<div class="backgroudcolor">
					<!--轮播区域-->
					<div class="allbroad">

						<div class="broad1" >
							<div class="tag">
								<span >国家精品</span>
							</div>
							<div class="tag">
						<span >
						计算机
						<a>前沿技术/</a>
						<a>软件工程</a>

						</span>
							</div>
							<div class="tag">
					<span>
						外语
						<a>听力/</a>
						<a>口语/</a>
						<a>写作/</a>
						<a>翻译</a>

					</span>
							</div>
							<div class="tag">
						<span>
							理学
						<a href="">数学</a>
						<a href="">物理</a>
						<a href="">化学</a>
						</span>
							</div>
							<div class="tag">
						<span>
							工学
							<a href="">力学</a>
							<a href="">材料</a>
						</span>
							</div>
							<div class="tag">
						<span>
							22考研
							<a href="">数学</a>
							<a href="">名师英语</a>
						</span>
							</div>
							<div class="tag">
						<span>期末不挂科
						<a href="">期末不挂科</a>
						</span>
							</div>
							<div class="tag">
						<span>应试英语
						<a href="">万词班</a>
						<a href="">四六级</a>
						</span>
							</div>
							<div class="tag">
						<span>实用英语
						<a>
							新概念
						</a>
						</span>
							</div>
						</div>

						<div class="broad2">
							<ul>
								<li class="left">
									<img src="http://edu-image.nosdn.127.net/217f9ebff602403288fae018450f18e2.png?imageView&quality=100&thumbnail=776y360" />
								</li>
								<li class="center">
									<img src="http://edu-image.nosdn.127.net/4513ab16473949d4803bace2ace4359f.png?imageView&quality=100&thumbnail=776y360" />
								</li>
								<li class="right">
									<img src="http://edu-image.nosdn.127.net/0fbd0fc524f6490ca4512b8a5a6fbec3.png?imageView&quality=100&thumbnail=776y360" />
								</li>
								<li class="unset">
									<img src="http://edu-image.nosdn.127.net/cf01c31ae5474d3bae9b200859c9593a.png?imageView&quality=100" />
								</li>
								<div class="broad3" align="center">
									<font size="3">欢迎学习学校名师的课程</font>
									<div >
										<img src="img/登录注册.png" width="150px"align="center"/>
									</div>
									<span><font><a onclick="openLogin()">登录  /</a>
											<a href="register.jsp"style="text-decoration: none;color: #000000 ;">  注册</a>
										</font>

										</span>
								</div>

							</ul>
						</div>

						<div class="broad4">
							<div><font size="4"><strong>全部749所合作高校</strong></font></div>
							<div><img src="img/校标1.png"height="30px"/></div>
							<div><img src="img/校标2.png"height="30px"/></div>
							<div><img src="img/校标3.png"height="30px"/></div>
							<div><img src="img/校标4.png"height="30px"/></div>
							<div><img src="img/校标5.png"height="30px"/></div>
						</div>



					</div>


					<div class="clearfloat"></div>
					<div class="computer">
						<font size="5">
							<strong>计算机</strong>

						</font>
						<div>
							<span><font size="3"><a href=""style="text-decoration: none;color: #000000;"><font>最新好课推荐</font></a></font></span>
							<span><font size="3"><a href=""style="text-decoration: none;color: #000000;"><font>计算机基础</font></a></font></span>
							<span><font size="3"><a href=""style="text-decoration: none;color: #000000;"><font>程序设计</font></a></font></span>

						</div>
						<div>
							<div style="float: left;">
								<div><video width="320" height="240" controls poster="img/${videoList.get(0).getVideopage()}">
									<source src="img/素材2.mp4" type="video/mp4">
									<source src="素材2.mp4" type="video/ogg">
									您的浏览器不支持 video 标签。
								</video></div>
								<div align="center"style=""><a href="${pageContext.request.contextPath}/VideoServlet?videoID=${videoList.get(0).getVideoid()}&videoAddress=${videoList.get(0).getVideoaddress()}&videoName=${videoList.get(0).getVideoname()}&videoPic=${videoList.get(0).getVideopage()}&videoBoard=${videoList.get(0).getVideoboard()}${request.getSession().removeAttribute("videoBoard1")}"style="color: #000000;font-size: large;text-decoration: none;">${videoList.get(0).getVideoname()}</a></div>
							</div>
							<div style="float: left;margin-left: 20px;">
								<div><video width="320" height="240" controls poster="img/${videoList.get(1).getVideopage()}">
									<source src="img/${videoList.get(1).getVideoaddress()}" type="video/mp4">
									<source src="img/${videoList.get(1).getVideoaddress()}" type="video/ogg">
									您的浏览器不支持 video 标签。
								</video></div>
								<div align="center"style=""><a href="${pageContext.request.contextPath}/VideoServlet?videoID=${videoList.get(1).getVideoid()}&videoAddress=${videoList.get(1).getVideoaddress()}&videoName=${videoList.get(1).getVideoname()}&videoPic=${videoList.get(1).getVideopage()}&videoBoard=${videoList.get(1).getVideoboard()}${request.getSession().removeAttribute("videoBoard1")}"style="color: #000000;font-size: large;text-decoration: none;">${videoList.get(1).getVideoname()}</a></div>
							</div>
							<div style="float: left;margin-left: 20px;">
								<div><video width="320" height="240" controls poster="img/${videoList.get(2).getVideopage()}">
									<source src="img/${videoList.get(0).getVideoaddress()}" type="video/mp4">
									<source src="img/${videoList.get(0).getVideoaddress()}" type="video/ogg">
									您的浏览器不支持 video 标签。
								</video></div>
								<div align="center"style=""><a href="${pageContext.request.contextPath}/VideoServlet?videoID=${videoList.get(2).getVideoid()}&videoAddress=${videoList.get(2).getVideoaddress()}&videoName=${videoList.get(2).getVideoname()}&videoPic=${videoList.get(2).getVideopage()}&videoBoard=${videoList.get(2).getVideoboard()}${request.getSession().removeAttribute("videoBoard1")}"style="color: #000000;font-size: large;text-decoration: none;">${videoList.get(2).getVideoname()}</a></div>
							</div>
							<div style="clear: left">
							</div>
							<div style="float: left">
								<div><video width="320" height="240" controls poster="img/${videoList.get(3).getVideopage()}">
									<source src="img/${videoList.get(0).getVideoaddress()}" type="video/mp4">
									<source src="img/${videoList.get(0).getVideoaddress()}" type=video/ogg">
									您的浏览器不支持 video 标签。
								</video></div>
								<div align="center"style=""><a href="${pageContext.request.contextPath}/VideoServlet?videoID=${videoList.get(3).getVideoid()}&videoAddress=${videoList.get(3).getVideoaddress()}&videoName=${videoList.get(3).getVideoname()}&videoPic=${videoList.get(3).getVideopage()}&videoBoard=${videoList.get(3).getVideoboard()}${request.getSession().removeAttribute("videoBoard1")}"style="color: #000000;font-size: large;text-decoration: none;">${videoList.get(3).getVideoname()}</a></div>

							</div>
							<div style="margin-left: 30px;float: left;">
								<div><video width="320" height="240" controls poster="img/${videoList.get(4).getVideopage()}">
									<source src="img/${videoList.get(0).getVideoaddress()}" type="video/mp4">
									<source src="img/${videoList.get(0).getVideoaddress()}" type="video/ogg">
									您的浏览器不支持 video 标签。
								</video></div>
								<div align="center"style=""><a href="${pageContext.request.contextPath}/VideoServlet?videoID=${videoList.get(4).getVideoid()}&videoAddress=${videoList.get(4).getVideoaddress()}&videoName=${videoList.get(4).getVideoname()}&videoPic=${videoList.get(4).getVideopage()}&videoBoard=${videoList.get(4).getVideoboard()}${request.getSession().removeAttribute("videoBoard1")}"style="color: #000000;font-size: large;text-decoration: none;">${videoList.get(4).getVideoname()}</a></div>

							</div>
							<div style="margin-left: 30px;float: left;">
								<div><video width="320" height="240" controls poster="img/${videoList.get(5).getVideopage()}">
									<source src="img/${videoList.get(0).getVideoaddress()}" type="video/mp4">
									<source src="img/${videoList.get(0).getVideoaddress()}" type="video/ogg">
									您的浏览器不支持 video 标签。
								</video></div>
								<div align="center"style=""><a href="${pageContext.request.contextPath}/VideoServlet?videoID=${videoList.get(5).getVideoid()}&videoAddress=${videoList.get(5).getVideoaddress()}&videoName=${videoList.get(5).getVideoname()}&videoPic=${videoList.get(5).getVideopage()}&videoBoard=${videoList.get(5).getVideoboard()}${request.getSession().removeAttribute("videoBoard1")}"style="color: #000000;font-size: large;text-decoration: none;">${videoList.get(5).getVideoname()}</a></div>

							</div>

						</div>
					</div>
				</div>

			</div>

		</div>



	</div>

	<div style="margin-top: 1400px;margin-left: 150px;position: absolute" align="center">
		<strong style="font-size: large"><label><strong style="size: 20px">排行榜</strong></label></strong>
		<table style="border-spacing: 20px;"border="2px">
			<th width="400px">视频名称
			</th>
			<th width="800px">内容
			</th >
			<%
				int num=1;
				if(videoInfo!=null){
					for(VideoInfo b:videoBoardList){
						request.getSession().setAttribute("b",b);
						if(num<=3)
						num++;
						else
							break;
			%>
			<tr>
				<td align="center" style="background-color: gray">
					<a href="${pageContext.request.contextPath}/VideoServlet?videoID=${b.getVideoid()}&videoAddress=${b.getVideoaddress()}&videoName=${b.getVideoname()}&videoPic=${b.getVideopage()}"style="color: #000000;font-size: large;text-decoration: none;"><%=b.getVideoname()%></a>

				</td>

				<td align="center">
					<div>
						<video width="320" height="240" controls poster="img/<%=b.getVideopage()%>">
							<source src="img/<%=b.getVideoaddress()%>" type="video/mp4">
							<source src="<%=b.getVideoaddress()%>" type="video/ogg">
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


	</body>


</html>
