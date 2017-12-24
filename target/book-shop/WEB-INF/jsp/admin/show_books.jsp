

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>显示所有商品 - bookstore</title>
	<%@ include file="../common/admin_head.jsp" %>
</head>
<body>


	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>图书列表</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
					<tr>
						<th>书名</th>
						<th>作者</th>
						<th>描述</th>
						<th>所属分类</th>
						<th>图片</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="book" items="${books}">
						<tr>
							<td>${book.name}</td>
							<td>${book.author}</td>
							<td>
									${book.description}
							</td>
							<td>
									${book.category_id}
							</td>
							<td>
									${book.image}
							</td>
							<td>
								<a class="btn btn-info" href="${basePath}seckill/${sk.seckillId}/detail" target="_blank">下架</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>


<script  src="${pageContext.request.contextPath}/js/jquery.min.js"/>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"/>

</html>