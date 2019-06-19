<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html >
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>更改商品信息</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<script>
			function editProduct(){
				alert("商品信息更改成功！");
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
						<c:if test="${empty managername}">					
						<li><a href="${pageContext.request.contextPath}/login">登录</a></li>
						<li><a href="${pageContext.request.contextPath}/register">注册</a></li>
					  </c:if>
						
					  	<c:if test="${not empty managername}">
						<li>欢迎!<a href="${pageContext.request.contextPath}/editUser">${managername}</a></li>
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
		<font>商品修改</font>PRODUCT EDIT
		<form class="form-horizontal" style="margin-top:5px;" action="doEditProduct?id=${product.id}&pimage=${product.pimage}" method="post" enctype="multipart/form-data">
			 <div class="form-group" >
			    <label for="username" class="col-sm-2 control-label">商品名称</label>
			    <div class="col-sm-6">
			      <input type="text" name="pname" class="form-control" id="pname" value="${product.pname}"><span id="span01"></span>
			    </div>
			    
			  </div>
			   <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">商品类别</label>
			    <div class="col-sm-6">
			      <select name="ptype">
						<c:forEach items="${productType}" var="pro">
						<option value="${pro.typename}" 
							<c:if test="${pro.typename==product.ptype}">
								selected="selected"
							</c:if>
						>${pro.typename}</option>
						</c:forEach>
					</select>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="confirmpwd" class="col-sm-2 control-label">商品价格</label>
			    <div class="col-sm-6">
			      <input type="text" name="price" class="form-control"  value="${product.price}">
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">商品图片</label>
			    <div class="col-sm-6">
			    	<img src="${pageContext.request.contextPath}/imgs/${product.pimage}" width="100px" height="100px">
			      <input name="pimg" type="file" id="pimage">  
			    </div>
			  </div>
			  <br>
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="提交更改" name="submit" onclick="editProduct()">
			    </div>
			  </div>
			  <%-- <input type="hidden" value="${product.id}" name="id"> --%>
			</form>
	</div>
	
	<div class="col-md-2"></div>
  
</div>
</div>


</body></html>



