<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@include file="./header.jsp"%>
	<h1>欢迎光临</h1>
    <!-- 显示分页数据：不分类 -->
    <table>
    	<tr>
    		<c:forEach items="${page.records}" var="b">
	    		<td>
	    			<table>
	    				<tr>
	    					<td>
	    						<img src="${pageContext.request.contextPath}/files/${b.image}"/>
	    					</td>
	    				</tr>
	    				<tr>
	    					<td>
	    						书名:${b.name}<br/>
	    						作者：${b.author}<br/>
	    						原价：<strike>888.00</strike><br/>
	    						震撼价:${b.price}
	    					</td>
	    				</tr>
	    				<tr>
	    					<td>
	    						<a href="javascript:void(0);">加入购物车</a>
	    					</td>
	    				</tr>
	    			</table>
	    		</td>
    		</c:forEach>
    	</tr>
    	<tr>
    		<td>
    			<%@include file="../common/page.jsp"%>
    		</td>
    	</tr>
    </table>
  </body>
</html>
