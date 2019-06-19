<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html >
<html>
	<style>
		.div1{
			margin-left: 150px;
			width: 20%;
    		height: 300px; 
			float: left;
		}
		.div2{
			width: 60%;
    		height: 600px; 
			float: left;
		}
	</style>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商品类别编辑</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>

	</head>

	<body>
		<div class="container-fluid">

			<!--
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
				<h2>管理员界面</h2>
				</div>
				<div class="col-md-5">
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
						<c:if test="${empty managername}">					
						<li><a href="${pageContext.request.contextPath}/login">登录</a></li>
						<li><a href="${pageContext.request.contextPath}/register">注册</a></li>
					  </c:if>
						
					  <c:if test="${not empty managername}">
						<li>欢迎!<a href="#">${managername}</a></li>
						<li><a href="${pageContext.request.contextPath}/logOut">退出</a></li>
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

						
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
			<div class="div1">
				<h2><a  href="${pageContext.request.contextPath}/productManage">商品管理</a></h2>
				<br>
				<h2><a  href="${pageContext.request.contextPath}/orderManage">订单管理</a></h2>
				<br>
				<h2><a  href="${pageContext.request.contextPath}/productTypeManage">商品类别管理</a></h2>

			</div>
			<div class="div2">
			<form action="${pageContext.request.contextPath}/doEditProductType?id=${productType.id}" method="post">
				<table class="table table-bordered table-striped">
					<tr>
						<td align="center">${productType.id}</td>
						<td align="center"><input type="text" value="${productType.typename}" name="typename"></td>
						<td align="center"><input type="submit" value="确定"></td>
					</tr>
				</table>
				<input type="hidden" value="${productType.typename}" name="oldName">
			</form>
	<h2>${editmsg}</h2>
			</div>
		</div>
	</body>

</html>