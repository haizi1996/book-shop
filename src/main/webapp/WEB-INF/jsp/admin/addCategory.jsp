<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="./header.jsp" %>
<div class="container" style="width: 77%">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>添加分类</h2>
        </div>
        <form class="form-horizontal" action="/admin/doAddCategory" method="post"
              onsubmit="return validate_form();">
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">分类名称:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputEmail3" name="name" placeholder="name">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">描&nbsp;&nbsp;述:</label>
                <div class="input-group">
                    <div class="col-sm-10">
                        <textarea class="form-control" id="description" name="description" rows="3"></textarea>
                    </div>
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
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function validate_form() {
        if(!$("#inputEmail3").val() || !$("#description").val() ){
            alert("请正确填写表单!!")
            return false;
        }

        $.post("/admin/doAddCategory" , $("form:first").serialize() , function (json) {
            if (json.state){
                alert(json.data);
            }else{
                alert(json.errorMess);
            }
            $(".form-horizontal")[0].reset();
        });
        return false;
    }
    
    
</script>

</html>
