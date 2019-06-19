<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html >
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>购物车</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<script>
        function addCartItem() {
			alert("已加入购物车！");
        }
		function doDelete(pid) {
			var flag=confirm("是否确定删除？");
			if(flag){
				//在当前标签页打开超链接
				window.location.href="deleteCartItem?pid="+pid;
			}
		}
	 	 function doClear() {
			var flag=confirm("是否清空购物车？");
			if(flag){
				//在当前标签页打开超链接
				window.location.href="clearCart";
			}
		}
		</script>

	</head>

	<body>
		<div class="container-fluid">

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

						
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
			<!-- 显示商品分页数据 -->
			<form action="${pageContext.request.contextPath}/pay" method="post">
			<table class="table table-bordered table-striped">
				<!-- <thead> -->
					<tr>
						<th>图片</th>
						<th>名称</th>
						<th>单价</th>
						<th>数量</th>
						<th>小计</th>
						<th></th>
					</tr>
				<!-- </thead> -->
				<!-- <tbody> -->
					<c:forEach items="${cart.list}" var="cartItem" >
						<tr>
							<td align="center"><img src="${pageContext.request.contextPath}/imgs/${cartItem.pimage}" width="100" height="100"></td>
							<td>${cartItem.pname}</td>
							<td>${cartItem.price}</td>
							<td>${cartItem.counts}</td>
							<td>${cartItem.counts*cartItem.price}</td>
							<td>
								<a href="#" onclick="doDelete(${cartItem.pid})">删除</a>
							</td>
						</tr>
					</c:forEach>
				<!-- </tbody> -->
				
				<tr>
				  	<td colspan="8">
				  	<h2>合计：${cart.totalPrice}</h2>
				  		<button type="button" onclick="doClear()" value="清空购物车">清空购物车</button>
						<button type="submit" >提交订单</button>
				  	</td>
	  		</tr>
			</table>
			</form>
		</div>
	</body>

</html>