<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="./header.jsp" %>
<!-- 显示分页数据：不分类 -->

<div class="container" style="width: 77%">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>欢迎光临</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <tbody>
                <tr>
                    <th>书名</th>
                    <th>${book.name}</th>
                </tr>
                <tr>
                    <th>作者</th>
                    <th>${book.author}</th>
                </tr>
                <tr>
                    <th>原价</th>
                    <th>${(book.price + 300) * 0.01}</th>
                </tr>
                <tr>
                    <th>震撼价</th>
                    <th>${book.price }</th>
                </tr>
                <tr>
                    <th>震撼价</th>
                    <th>${book.num }</th>
                </tr>
                <tr>
                    <th>图片</th>
                    <th><img src="${book.imageUrl}" class="img-responsive" alt="Responsive image"/></th>
                </tr>
                <tr>
                    <th>详情</th>
                    <th>${book.description}</th>
                </tr>
                </tbody>
            </table>
            <button class="btn btn-primary"  onclick="addCart(${book.id})" role="button">加入购物车</button>

        </div>
    </div>
</div>
</body>


<script type="text/javascript" src="/js/jquery.min.js"/>
<script type="text/javascript" src="/js/bootstrap.min.js"/>

<%--<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>--%>
<%--<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->--%>
<%--<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>

<script type="text/javascript">
function addCart(id) {
    $.get('/client/addCart/' + ${book.id} , function (c) {
        if(c.state){
            alert(c.data);
        }else{
            alert(c.errorMess);
        }
    });
}
</script>


</html>
