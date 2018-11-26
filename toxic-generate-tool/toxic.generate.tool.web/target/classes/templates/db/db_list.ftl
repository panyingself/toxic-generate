<#assign ctx = request.contextPath/>
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>序号</th>
        <th>数据库名称</th>
        <th>数据库连接</th>
        <th>类型</th>
        <th>操作</th>
        <th>选中</th>
    </tr>
    </thead>
    <tbody>
        <#if (dbConfigList)?? >
            <#list dbConfigList as dbConfig >
            <tr>
                <td>${dbConfig_index+1}</td>
                <td>${dbConfig.dbName!}</td>
                <td><a href="#"><#if (dbConfig.url)??>${dbConfig.url}</#if></a></td>
                <td>${dbConfig.driver!}</td>
                <td>
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <a class="am-btn am-btn-default am-btn-xs am-hide-sm-only" href="${ctx}/admin/code/edit?dbName=${dbConfig.dbName}&url=${dbConfig.url!}&driver=${dbConfig.driver!}&username=${dbConfig.username!}&password=${dbConfig.password!}&schema=${dbConfig.schema!}"><span class="am-icon-pencil-square-o"></span>编辑</a>
                            <a class="am-btn am-btn-default am-btn-xs am-hide-sm-only" href="${ctx}/admin/code/delete?dbName=${dbConfig.dbName}&url=${dbConfig.url!}&driver=${dbConfig.driver!}&username=${dbConfig.username!}&password=${dbConfig.password!}&schema=${dbConfig.schema!}"><span class="am-icon-trash-o"></span>删除</a>
                        </div>
                    </div>
                </td>
                <td>
                    <a class="am-btn am-btn-default am-btn-xs am-hide-sm-only" href="jacascript::void(0)" onclick="toTableList('${ctx}/initcode?dbName=${dbConfig.dbName}&url=${dbConfig.url!}&driver=${dbConfig.driver!}&username=${dbConfig.username!}&password=${dbConfig.password!}&schema=${dbConfig.schema!}')"><span class="am-icon-trash-o"></span>选定</a>
                    <#--<a class="am-btn-sm am-btn-danger am-radius" href="${ctx}/initcode?dbName=${dbConfig.dbName}&url=${dbConfig.url!}&driver=${dbConfig.driver!}&username=${dbConfig.username!}&password=${dbConfig.password!}&schema=${dbConfig.schema!}">选定</a>-->
                </td>
            </tr>
            </#list>
        </#if>
    </tbody>
</table>

<script>
    function toTableList(url){
        $("#api-main").load(url);
    }
</script>
