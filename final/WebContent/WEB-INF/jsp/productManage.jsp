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
		<title>商品信息管理</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<script type="text/javascript">
	function doDelete(id) {
		var flag=confirm("是否确定删除？");
		if(flag){
			//在当前标签页打开超链接
			alert("删除成功！");
			window.location.href="deleteProduct?id="+id;
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
				<!-- 显示商品分页数据 -->
				<form action="${pageContext.request.contextPath}/productManage" method="post">
				<table class="table table-bordered table-striped">
						<tr >
						  	<td colspan="10"> 
						  	按商品名称查询：<input type="text" name="productName">	
						  	按商品类型查找：<select	name="productType">
									<option value="">--请选择--</option>
									<c:forEach items="${productType}" var="product">
										<option value="${product.typename}">${product.typename}</option>
									</c:forEach>
								</select>
						  	按价格区间查询：<select name="productPrice">
										<option value="" selected>--请选择--
										<option value="0-500">500以下
										<option value="500-1000">500-1000
										<option value="1000-2000">1000-2000
										<option value="2000以上">2000以上
									</select>
							&nbsp;&nbsp;&nbsp;
							<input type="submit" value="查询">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath}/addProduct" >添加商品</a>
						  	</td>
		
			  			</tr>
					<!-- <thead> -->
						<tr>
							<th>商品图片</th>
							<th>商品名称</th>
							<th>商品类型</th>
							<th>商品价格</th>
							<th></th>
						</tr>
					<!-- </thead> -->
					<!-- <tbody> -->
						<c:forEach items="${productList}" var="list">
							<tr>
								<td align="center"><img src="${pageContext.request.contextPath}/imgs/${list.pimage}" width="100" height="100"></td>
								<td>${list.pname}</td>
								<td>${list.ptype}</td>
								<td>${list.price}</td>
								<td>
									<a href="${pageContext.request.contextPath}/editProduct?id=${list.id}">编辑</a>
									<a href="#"  onclick="doDelete(${list.id})">删除</a>
								</td>
							</tr>
						</c:forEach>
					<!-- </tbody> -->
					<tr>
					  	<td colspan="8">
					  		第${QueryVo.page}/${QueryVo.totalPage}&nbsp
					  		每页显示${QueryVo.size}条 &nbsp &nbsp &nbsp
					  		总的记录数${QueryVo.count}&nbsp &nbsp
					  		<c:if test="${QueryVo.page!=1}">
					  			<a href="${pageContext.request.contextPath}/productManage?page=1">首页</a>|
					  			<a href="${pageContext.request.contextPath}/productManage?page=${QueryVo.page-1}">上一页</a>
					  		</c:if>
					  		<c:forEach begin="1" end="${QueryVo.totalPage}" var="i">
					  			<c:if test="${QueryVo.page==i }">
					  				${i}
					  			</c:if>
					  			<c:if test="${QueryVo.page!=i }">
					  				<a href="${pageContext.request.contextPath}/productManage?page=${i}">${i}</a>
					  			</c:if>
					  		</c:forEach>
					  		<c:if test="${QueryVo.page!=QueryVo.totalPage}">
					  			<a href="${pageContext.request.contextPath}/productManage?page=${QueryVo.page+1}">下一页</a>|
					  			<a href="${pageContext.request.contextPath}/productManage?page=${QueryVo.totalPage}">尾页</a>
					  		</c:if>
					  	</td>
					  	
		  		</tr>
				</table>
				</form>
			</div>
		</div>
	</body>

</html>