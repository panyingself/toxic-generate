<#assign ctx = request.contextPath/>

<br><br>

<div>
    <button class="layui-btn" onclick="dbListQuery()">搜索</button>
    <button class="layui-btn" onclick="toDbView('${ctx}/admin/autodbinfo/add')" >新增</button>
</div>

<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>序号</th>
        <th>操作</th>
        <th>数据库名称</th>
        <th>数据库连接</th>
        <th>类型</th>
        <th>选中</th>
    </tr>
    </thead>
    <tbody>
        <#if (dbConfigList)?? >
            <#list dbConfigList as dbConfig >
            <tr>
                <td>${dbConfig_index+1}</td>
                <td>
                    <a class="layui-btn layui-btn-sm layui-bg-green" onclick="toDbView('${ctx}/admin/autodbinfo/edit?id=${dbConfig.keyId}')">编辑</a>
                    <a class="layui-btn layui-btn-sm layui-bg-green" onclick="deleteDb('${ctx}/admin/autodbinfo/delete?id=${dbConfig.keyId}','${ctx}/initcode/init')">删除</a>
                </td>
                <td>${dbConfig.dbName!}</td>
                <td><a href="#"><#if (dbConfig.dbUrl)??>${dbConfig.dbUrl}</#if></a></td>
                <td>${dbConfig.dbDriver!}</td>
                <#--<td>-->
                    <#--<div class="am-btn-toolbar">-->
                        <#--<div class="am-btn-group am-btn-group-xs">-->
                            <#--<a class="am-btn am-btn-default am-btn-xs am-hide-sm-only" href="${ctx}/admin/code/edit?dbName=${dbConfig.dbName}&url=${dbConfig.url!}&driver=${dbConfig.driver!}&username=${dbConfig.username!}&password=${dbConfig.password!}&schema=${dbConfig.schema!}"><span class="am-icon-pencil-square-o"></span>编辑</a>-->
                            <#--<a class="am-btn am-btn-default am-btn-xs am-hide-sm-only" href="${ctx}/admin/code/delete?dbName=${dbConfig.dbName}&url=${dbConfig.url!}&driver=${dbConfig.driver!}&username=${dbConfig.username!}&password=${dbConfig.password!}&schema=${dbConfig.schema!}"><span class="am-icon-trash-o"></span>删除</a>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</td>-->
                <td>
                    <a class="am-btn am-btn-default am-btn-xs am-hide-sm-only" href="jacascript::void(0)" onclick="toTableList('${ctx}/initcode?dbName=${dbConfig.dbName}&url=${dbConfig.dbUrl!}&driver=${dbConfig.dbDriver!}&username=${dbConfig.dbUserName!}&password=${dbConfig.dbPassWord!}&schema=${dbConfig.dbSchema!}')"><span class="am-icon-trash-o"></span>选定</a>
                    <#--<a class="am-btn-sm am-btn-danger am-radius" href="${ctx}/initcode?dbName=${dbConfig.dbName}&url=${dbConfig.url!}&driver=${dbConfig.driver!}&username=${dbConfig.username!}&password=${dbConfig.password!}&schema=${dbConfig.schema!}">选定</a>-->
                </td>
            </tr>
            </#list>
        </#if>
    </tbody>
</table>
<script src="${request.contextPath}/js/db/db_list.js"></script>
<script>
    function toTableList(url){
        $("#api-main").load(url);
    }
</script>
