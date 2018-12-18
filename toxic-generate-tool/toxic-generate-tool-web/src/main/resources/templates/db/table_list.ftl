<#assign ctx = request.contextPath/>
<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
    <tr>
        <th>序号</th>
        <th>表名</th>
        <th>注解</th>
        <th>操作</th>
    </tr>
    </tr>
    </thead>
    <tbody>
        <#list tableList as table >
        <tr>
            <td>${table_index+1}</td>
            <td><#if (table.tableName)??>${table.tableName}</#if></td>
            <td><#if (table.comments)??>${table.comments}</#if></td>
            <td>
                <a onclick="toColumnList('${ctx}/initcode/<#if (table.tableName)??>${table.tableName}</#if>?url=<#if (dbConfig.url)??>${dbConfig.url}</#if>&driver=<#if (dbConfig.driver)??>${dbConfig.driver}</#if>&username=<#if (dbConfig.username)??>${dbConfig.username}</#if>&password=<#if (dbConfig.password)??>${dbConfig.password}</#if>&schema=<#if (dbConfig.schema)??>${dbConfig.schema}</#if>')">修改</a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
<script>
    function toColumnList(url){
        $("#api-main").load(url);
    }
</script>
