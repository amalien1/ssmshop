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
			width: 70%;
    		height: 600px; 
			float: left;
		}
	</style>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>订单管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<script type="text/javascript">
	function doDelete(oid) {
		var flag=confirm("是否确定删除？");
		if(flag){
			//在当前标签页打开超链接
			window.location.href="deleteOrder?oid="+oid;
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
						<!-- 显示订单数据 -->
			
				<table class="table table-bordered table-striped">
					<c:forEach items="${orderList}" var="order">
						<tr >
							<td colspan="3">
								订单号：${order.oid} &nbsp;&nbsp;&nbsp;
								下单者：${order.username}&nbsp;&nbsp;&nbsp;
								收货人：${order.name} &nbsp;&nbsp;&nbsp;
								配送地址：${order.address} &nbsp;&nbsp;&nbsp;
								联系方式：${order.phone}&nbsp;&nbsp;&nbsp;
								实付款：${order.totalprice} &nbsp;&nbsp;&nbsp; <br>
								订单状态：
								<c:if test="${order.state==1}">
									待收货
								</c:if>
								<c:if test="${order.state==2}">
									已收货
								</c:if>
								&nbsp;&nbsp;&nbsp;订单创建时间：${order.stringTime}
								<td>
									<a href="${pageContext.request.contextPath}/changeOrderState?oid=${order.oid}&state=${order.state}">更改订单状态</a>
								</td>
								<td><a href="#" onclick="doDelete(${order.oid})">删除</a></td>
							
						</tr>
						<tr>
							<th>图片</th>
							<th>名称</th>
							<th>单价</th>
							<th>数量</th>
							<th>小计</th>
						</tr>
						<c:forEach items="${order.orderItemList}" var="orderItem">
							<tr>
								<td align="center"><img src="${pageContext.request.contextPath}/imgs/${orderItem.pimage}" width="50" height="50"></td>
								<td>${orderItem.pname}</td>
								<td>${orderItem.price}</td>
								<td>${orderItem.counts}</td>
								<td>${orderItem.counts*orderItem.price}</td>
								
							</tr>
						</c:forEach>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>

</html>