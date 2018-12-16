
<div>

    <form class="layui-form" action="${request.contextPath}/admin/autodbinfo/add" id="db_add_form">

        <div class="layui-form-item">
            <label class="layui-form-label">数据库名称</label>
            <div class="layui-input-block">
                <input type="text" name="dbName" required  lay-verify="required" placeholder="请输入数据库名称" autocomplete="off" class="layui-input" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">数据库地址</label>
            <div class="layui-input-inline">
                <input  name="dbUrl" required lay-verify="required" placeholder="请输入数据库地址" autocomplete="off" class="layui-input" >
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">db_driver</label>
            <div class="layui-input-block">
                <input type="text" name="dbDriver" required  lay-verify="required" placeholder="请输入db_driver" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">数据库用户名</label>
            <div class="layui-input-inline">
                <input name="dbUserName" required lay-verify="required" placeholder="请输入数据库用户名" autocomplete="off" class="layui-input" >
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">数据库密码</label>
            <div class="layui-input-block">
                <input type="text" name="dbPassWord" required  lay-verify="required" placeholder="请输入数据库密码" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">数据库schemo</label>
            <div class="layui-input-inline">
                <input  name="dbSchema" required lay-verify="required" placeholder="请输入数据库schemo" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <a class="layui-btn"  onclick="toDbAdd()Add('${request.contextPath}/initcode/init')">立即提交</a>
                <button type="reset" class="layui-btn layui-btn-primary" onclick="dbEditReset()">重置</button>
            </div>
        </div>

    </form>

</div>
<script src="${request.contextPath}/js/db/db_add.js"></script>
