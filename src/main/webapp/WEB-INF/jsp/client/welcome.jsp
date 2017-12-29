<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="./header.jsp" %>
<script src="/js/jquery.min.js"/>
<script src="/js/bootstrap.min.js"/>

<script lang="java" type="text/javascript">
    function addCart(id){
        $.get("/client/addCart/" + id , function (c) {
            if(v.state){
                alert(c.data);
            }else{
                alert(c.errorMess);
            }
        });
    }

</script>
<!-- 显示分页数据：不分类 -->
<div class="container" style="width: 77%">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>欢迎光临</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>书名</th>
                    <th>作者</th>
                    <th>原价</th>
                    <th>震撼价</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="book" items="${page.records}">
                    <tr>
                        <td>${book.name}</td>
                        <td>${book.author}</td>
                        <td>

                            <strike> ${(book.price + 300) * 0.01}</strike>
                        </td>
                        <td>
                                ${book.price * 0.01}
                        </td>

                        <td>
                            <a class="btn btn-info" href="/client/book/${book.id}/detail"
                               target="_blank">详情</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>


</html>
