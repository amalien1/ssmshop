<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员注册</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<script type="text/javascript">
	function checkUserName(){
		var name=$("#username").val();
		$.post("checkUser",{name:name},function(data,status){
			
			if(data==1){
				
				$("#span01").html("用户名已存在");
			}else{
				$("#span01").html("用户名可用");
			}
				
		});
	}
</script>
<script >
	function isValidate(form){
		var username=$("#username").val();
		var password=$("#password").val();
		var confirmpwd=$("#confirmpwd").val();
		var birthday=$("#birthday").val();
		var name=$("#name").val();
		var pattern = /^[a-zA-Z0-9]+$/;
		if(isNull(username)){
			alert("用户名不能为空！");
			return false;
		}
		if(/[^0-9A-Za-z]/g.test(username)){
			alert("用户名只能是英文和数字!");
			return false;
		}
		if(isNull(password)){
			alert("密码不能为空！");
			return false;
		}
		if(isNull(confirmpwd)){
			alert("确认密码不能为空！");
			return false;
		}
		if(isNull(name)){
			alert("姓名不能为空！");
			return false;
		}
		if(isNull(birthday)){
			alert("日期不能为空！");
			return false;
		}
		if(password!=confirmpwd){
			alert("密码不相同！");
			return false;
		}
		return true;
	}
	function isNull(str){
		if(str.length==0)
			return true;
		else
			return false;
	}
	</script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #3164af;
    font-size: 18px;
    font-weight: normal;
    padding: 0 10px;
}
 </style>
</head>
<body>




			<!--
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
				</div>
				<div class="col-md-5">
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<c:if test="${empty username}">					
						<li><a href="${pageContext.request.contextPath}/login">登录</a></li>
						<li><a href="${pageContext.request.contextPath}/register">注册</a></li>
					  </c:if>
						
					  	<c:if test="${not empty username}">
						<li>欢迎!<a href="${pageContext.request.contextPath}/editUser">${username}</a></li>
						<li><a href="${pageContext.request.contextPath}/logOut">退出</a></li>
						<li><a href="${pageContext.request.contextPath}/cart">购物车</a></li>
						<li><a href="${pageContext.request.contextPath}/orderlist">我的订单</a></li>
					  </c:if>	
					</ol>
				</div>
			</div>
			<!--
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="${pageContext.request.contextPath}/index">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->

						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>





<div class="container" style="width:100%">
<div class="row"> 

	<div class="col-md-2"></div>
	
	


	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>会员注册</font>USER REGISTER
		<form name="form1" class="form-horizontal" style="margin-top:5px;" action="doRegister" method="post" onsubmit="return isValidate(form1)">
			 <div class="form-group" >
			    <label for="username" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-6">
			      <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名" onblur="checkUserName()"><span id="span01"></span>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" name="confirmpwd" id="confirmpwd" placeholder="请输入确认密码">
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" name="name" class="form-control" id="name" placeholder="请输入姓名">
			    </div>
			  </div>
			  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
			  <div class="col-sm-6">
			    <label class="radio-inline">
			  <input type="radio" name="gender" id="sex" value="男" checked="checked"> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" name="gender" id="sex" value="女"> 女
			</label>
			</div>
			  </div>	
			 <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">所在地</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" name="nativeplace" >		      
			    </div>
			  </div>	
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-6">
			      <input type="date" class="form-control" name="birthday" id="birthday" pattern="yyyy-MM-dd HH:mm:ss">		      
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">电话</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" name="phone" >		      
			    </div>
			  </div>
			 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="注册" name="submit">
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			    	${msg}
			    </div>
			  </div>
			</form>
	</div>
	
	<div class="col-md-2"></div>
  
</div>
</div>


</body></html>




