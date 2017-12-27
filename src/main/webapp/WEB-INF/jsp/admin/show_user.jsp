<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
	
	<c:forEach var="user" items="${users}">
		用户id:${user.id} <br/>
		用户名:${user.username} <br/>
		密&nbsp;码:${user.password} <br/>
		性&nbsp;别:${user.gender} <br/>
		邮&nbsp;箱:${user.email} <br/>
		<hr/>
	</c:forEach>
	
</body>
</html>