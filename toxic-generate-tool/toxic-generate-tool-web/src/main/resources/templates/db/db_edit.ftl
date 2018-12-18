
<div>

    <form class="layui-form" action="${request.contextPath}/admin/autodbinfo/edit" id="db_edit_form">

        <div class="layui-form-item" style="display: block">
            <label class="layui-form-label">keyid</label>
            <div class="layui-input-block">
                <input type="text" name="keyId" required  lay-verify="required" placeholder="请输入用户id" autocomplete="off" class="layui-input" value="${db.keyId}">
            </div>
        </div>

        <div class="layui-form-item" style="display: none">
            <label class="layui-form-label">数据库名称</label>
            <div class="layui-input-block">
                <input type="text" name="dbName" required  lay-verify="required" placeholder="请输入用户id" autocomplete="off" class="layui-input" value="${db.dbName}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">数据库地址</label>
            <div class="layui-input-block">
                <input type="text" name="dbUrl" required  lay-verify="required" placeholder="请输入用户名称" autocomplete="off" class="layui-input" value="${db.dbUrl}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">db_driver</label>
            <div class="layui-input-inline">
                <input  name="dbDriver" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" value="${db.dbDriver}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">数据库用户名</label>
            <div class="layui-input-block">
                <input type="text" name="dbUserName" required  lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input" value="${db.dbUserName}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">数据库密码</label>
            <div class="layui-input-inline">
                <input name="dbPassWord" required lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input" value="${db.dbPassWord}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">数据库schemo</label>
            <div class="layui-input-inline">
                <input name="dbSchema" required lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input" value="${db.dbSchema}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <a class="layui-btn"  onclick="toDbEdit('${request.contextPath}/initcode/init')">立即提交</a>
                <button type="reset" class="layui-btn layui-btn-primary" onclick="dbEditReset()">重置</button>
            </div>
        </div>

    </form>

    <#--<a onclick="toUserEdit('${request.contextPath}/user/queryList')">test-->
    <#--</a>-->
</div>
<script src="${request.contextPath}/js/db/db_edit.js"></script>
<script>
    //Demo
    // layui.use('form', function(){
    //     var form = layui.form;

        //监听提交
        // form.on('submit(formDemo)', function(data){
        //     layer.msg(JSON.stringify(data.field));
        //     return false;
        // });
    // });
</script>