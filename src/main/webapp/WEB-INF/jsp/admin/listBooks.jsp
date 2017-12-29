<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
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
                <tr>
                    <td>aasdasd</td>
                    <td>
                        adgdgf
                    </td>
                    <td>
                        fhfhfh
                    </td>
                    <td>
                        <img src="/img/taobao.png" class="img-responsive" alt="Responsive image">
                    </td>
                    <td>
                        <a class="btn btn-info" href="${basePath}seckill/${sk.seckillId}/detail"
                           target="_blank">下架</a>
                    </td>
                </tr>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.name}</td>
                        <td>${book.author}</td>
                        <td>
                                ${book.description}
                        </td>
                        <td>
                                ${book.categoryName}
                        </td>
                        <td>
                            <img src="${book.imageUrl}" class="img-responsive" alt="Responsive image">
                        </td>
                        <td>
                            <a class="btn btn-info" href="${basePath}seckill/${sk.seckillId}/detail"
                               target="_blank">下架</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>


<script src="${pageContext.request.contextPath}/js/jquery.min.js"/>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"/>

</html>