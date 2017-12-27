<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>添加商品</h2>
        </div>
        <form class="form-horizontal" action="/admin/doAddBook" method="post" enctype="multipart/form-data"
              onsubmit="return validate_add_product();">

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">商品名:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3" name="name" placeholder="name">
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">价&nbsp;格:</label>
                <div class="input-group">
                    <div class="input-group-addon">$</div>
                    <input type="text" class="form-control" id="exampleInputAmount" name="price" placeholder="分为单位">
                    <div class="input-group-addon">.00</div>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">分&nbsp;类:</label>
                <div class="col-sm-10">
                    <select class="form-control" name="categoryId">
                        <%--<option value="" >请选择分类</option>--%>
                        <c:if test="${baseResult.state}">
                            <c:forEach items="${baseResult.data}" var="category">
                                <option value="${category.id}">${category.name}</option>
                            </c:forEach>
                            <%--<option value="2">生活</option>--%>
                            <%--<option value="3">计算机</option>--%>
                            <%--<option value="4">外语</option>--%>
                            <%--<option value="5">经营</option>--%>
                            <%--<option value="6">励志</option>--%>
                            <%--<option value="7">社科</option>--%>
                            <%--<option value="8">学术</option>--%>
                            <%--<option value="9">少儿</option>--%>
                            <%--<option value="10">艺术</option>--%>
                            <%--<option value="11">原版</option>--%>
                            <%--<option value="12">科技</option>--%>
                            <%--<option value="13">考试</option>--%>
                            <%--<option value="14">生活百科</option>--%>
                        </c:if>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">数&nbsp;量:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="num"  name="num" placeholder="name">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">图&nbsp;片:</label>
                <div class="col-sm-10">
                    <input type="file" class="form-control" id="image"  name="image" placeholder="name">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">描&nbsp;述:</label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="3" id="description" name="description"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <p>
                        <button type="submit" class="btn btn-primary">提交</button>
                        <button type="reset" class="btn btn-default">重置</button>
                    </p>
                </div>
            </div>




        </form>
    </div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
    
    function validate_add_product(form) {
        i($("#inputEmail3").val()){
            error("请填写图书名!!");
        }else if($("#exampleInputAmount").val()){
            error("请填写图书价格!!");
        }else if($(".form-control").val()){
            error("请填写图书分类!!");
        }else if($("#num").val()){
            error("请填写图书数量!!");
        }else if($("#image").val()){
            error("请填写图书图片!!");
        }else if($("#description").val()){
            error("请填写图书描述!!");
        }else{
            var formData = new FormData($("form:first")[0]);
            $.ajax({
                url: '/admin/doAddBook' ,
                type: 'POST',
                data: formData,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (returndata) {
                    if(returndata.state){
                        alert(returndata.data);
                        $("form:first")[0].reset();
                    }else{
                        alert(returndata.errorMess);
                    }
                },
                error: function (returndata) {
                    alert("图书添加失败!!!");
                }
            });
        }
        return false;
    }
    
</script>

</body>
</html>