<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<c:if test="${!baseResult.state}">
    没有分类，请先添加
</c:if>
<c:if test="${baseResult.state}">
    <div class="container" style="width: 77%">
        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <h2>分类列表</h2>
            </div>
            <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th>分类名称</th>
                        <th>描述</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${baseResult.data}" var="c">
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>${c.name}</td>
                            <td>${c.description}</td>
                            <td>
                                <a href="#" class="btn btn-primary btn-lg active btn-sm" role="button">修改</a>
                                <a href="#" class="btn btn-default btn-lg active btn-sm" role="button">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</c:if>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</html>
