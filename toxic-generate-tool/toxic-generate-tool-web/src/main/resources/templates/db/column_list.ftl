<#assign ctx = request.contextPath/>
<form class="layui-form" action="${ctx}/initcode" method="post" name="listForm" id="listForm"
      xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
    <input type="hidden" name="_method" id="_method" value=""/>
    <input type="hidden" name="url" id="url" value="<#if (dbConfig.url)??>${dbConfig.url}</#if>"/>
    <input type="hidden" name="driver" id="driver" value="<#if (dbConfig.driver)??>${dbConfig.driver}</#if>"/>
    <input type="hidden" name="username" id="tableName" value="<#if (dbConfig.username)??>${dbConfig.username}</#if>"/>
    <input type="hidden" name="password" id="password" value="<#if (dbConfig.password)??>${dbConfig.password}</#if>"/>
    <input type="hidden" name="schema" id="schema" value="<#if (dbConfig.schema)??>${dbConfig.schema}</#if>"/>

    <input type="hidden" name="tableName" id="tableName" value="<#if (tableInfo.tableName)??>${tableInfo.tableName}</#if>"/>
    <div class="layui-form-item">
            <input type="checkbox" name="like[write]" title="写作">

            <a href="javascript:history.back();" id="backButton" class="layui-btn fl">
                <span class="iconSpan upIcon">&nbsp;</span>返回
            </a>

            <a href="javascript:;" id="saveButton" class="layui-btn fl">
                <span class="iconSpan editIcon">&nbsp;</span>保存
            </a>

            <a href="javascript:;" id="generateButton" class="layui-btn fl">
                <span class="iconSpan copyIcon">&nbsp;</span>生成
            </a>
        </br>
        </br>
        模块名称：com.<input type="text" name="comments" id="comments" value="<#if (tableInfo.comments)??><#if (tableInfo.comments)?index_of("#") &gt; -1 >${(tableInfo.comments)?substring((tableInfo.comments)?index_of("#")+1)}<#else>${tableInfo.comments}111</#if></#if>">
    </div>

    <div class="body-box">
        <table id="listTable" class="list layui-table">
            <thead>
            <tr>
                <th>序号</th>
                <th>字段名</th>
                <th>类型</th>
                <th>备注</th>
                <#--<th>是否显示</th>-->
                <#--<th>是否查询</th>-->
                <#--<th>编辑控件</th>-->
                <#--<th>校验</th>-->
                <#--<th>是否外键</th>-->
                <#--<th>代码转换名称</th>-->
            </tr>
            </thead>

            <tbody>
				<#list tableInfo.listColumn as column>
                <input type="hidden" name="remarks" id="remarks_${column_index+1}" value="<#if (column.colName)??>${column.colName}</#if>">
                <input type="hidden" name="itemType" id="itemType_${column_index+1}" value="<#if (column.sqlTypeName)??>${column.sqlTypeName}</#if>">
                <input type="hidden" name="itemSize" id="itemSize_${column_index+1}" value="<#if (column.size)??>${column.size}</#if>">
                <input type="hidden" name="itemDecimalDigits" id="itemDecimalDigits_${column_index+1}" value="<#if (column.decimalDigits)??>${column.decimalDigits}</#if>">
                <tr>
                    <td>${column_index+1}</td>
                    <td><#if (column.colName)??>${column.colName}</#if></td>
                    <td><#if (column.colType)??>${column.colType}</#if></td>
                    <td><input type="text" name="remark" id="remark_${column_index+1}" value="<#if (column.comments)??><#if (column.comments)?index_of("#") &gt; 0 >${(column.comments)?substring(0,(column.comments)?index_of("#"))}<#else>${column.comments}</#if></#if>"></td>
                    <#--<td><input type="checkbox"  id="isShow_${column_index+1}" name="isShow" value="#OS" <#if (column.comments)??><#if (column.comments)?index_of("#OS") &gt; 0 >checked</#if></#if> /></td>-->
                    <#--&lt;#&ndash;<td><input type="checkbox"  id="isSearch_${column_index+1}" name="isSearch" value="#OC" <#if (column.comments)??><#if (column.comments)?index_of("#OC") &gt; 0 >checked</#if></#if> /></td>&ndash;&gt;-->
                    <#--<td><div class="layui-form-item">-->
                        <#--<label class="layui-form-label">复选框</label>-->
                        <#--<div class="layui-input-block">-->
                            <#--<input type="checkbox" name="like[write]" title="写作">-->
                            <#--<input type="checkbox" name="like[read]" title="阅读" checked="">-->
                            <#--<input type="checkbox" name="like[game]" title="游戏">-->
                        <#--</div>-->
                    <#--</div></td>-->
                    <#--<td><select id="editControl_${column_index+1}" name="editControl" >-->
                        <#--<option value="" <#if (column.comments)??><#if (column.comments)?index_of("#E") &lt; 0 >selected</#if></#if>>单行文本框</option>-->

                        <#--<option value="#EPS" <#if (column.comments)??><#if (column.comments)?index_of("#EPS") &gt; 0 >selected</#if></#if>>参数下拉框</option>-->
                        <#--<option value="#EPC" <#if (column.comments)??><#if (column.comments)?index_of("#EPC") &gt; 0 >selected</#if></#if>>参数复选框</option>-->
                        <#--<option value="#EPR" <#if (column.comments)??><#if (column.comments)?index_of("#EPR") &gt; 0 >selected</#if></#if>>参数单选框</option>-->

                        <#--<option value="#ENS" <#if (column.comments)??><#if (column.comments)?index_of("#ENS") &gt; 0 >selected</#if></#if>>普通下拉框</option>-->
                        <#--<option value="#ENC" <#if (column.comments)??><#if (column.comments)?index_of("#ENC") &gt; 0 >selected</#if></#if>>普通复选框</option>-->
                        <#--<option value="#ENR" <#if (column.comments)??><#if (column.comments)?index_of("#ENR") &gt; 0 >selected</#if></#if>>普通单选框</option>-->

                        <#--<option value="#EDS0&" <#if (column.comments)??><#if (column.comments)?index_of("#EDS") &gt; 0 >selected</#if></#if>>部门下拉框</option>-->
                        <#--<option value="#EAS0&" <#if (column.comments)??><#if (column.comments)?index_of("#EAS") &gt; 0 >selected</#if></#if>>区域下拉框</option>-->
                        <#--<option value="#EOR" <#if (column.comments)??><#if (column.comments)?index_of("#EOR") &gt; 0 >selected</#if></#if>>开关单选框</option>-->
                        <#--<option value="#ERT" <#if (column.comments)??><#if (column.comments)?index_of("#ERT") &gt; 0 >selected</#if></#if>>富文本编辑框</option>-->
                    <#--</select>-->
                        <#--<input type="text" name="parameter" class="w60" id="parameter_${column_index+1}" value="<#if (column.comments)??><#if ((column.comments)?index_of("#EP") &gt; 0) || ((column.comments)?index_of("#EN") &gt; 0) >${(column.comments)?substring((column.comments)?index_of("#E")+5,(column.comments)?index_of("）"))}</#if></#if>">-->
                    <#--</td>-->
                    <#--<td>-->
                        <#--<label><input type="checkbox" class="layui-form-checkbox" id="valid_vnn_${column_index+1}" name="valid_vnn_${column_index+1}" value="#VNN" <#if (column.comments)??><#if (column.comments)?index_of("#VNN") &gt; 0 >checked</#if></#if>>非空</label>-->
                        <#--<label><input type="radio" class="layui-form-radio" id="valid_vi_${column_index+1}" name="valid_${column_index+1}" value="#VI" <#if (column.comments)??><#if (column.comments)?index_of("#VI") &gt; 0 >checked</#if></#if>>整数</label>-->
                        <#--<label><input type="radio" class="layui-form-radio" id="valid_vd_${column_index+1}" name="valid_${column_index+1}" value="#VD" <#if (column.comments)??><#if (column.comments)?index_of("#VD") &gt; 0 >checked</#if></#if>>实数</label>-->
                        <#--<label><input type="radio" class="layui-form-radio" id="valid_ve_${column_index+1}" name="valid_${column_index+1}" value="#VE" <#if (column.comments)??><#if (column.comments)?index_of("#VE") &gt; 0 >checked</#if></#if>>Email</label>-->
                        <#--<label><input type="radio" class="layui-form-radio" id="valid_vm_${column_index+1}" name="valid_${column_index+1}" value="#VM" <#if (column.comments)??><#if (column.comments)?index_of("#VM") &gt; 0 >checked</#if></#if>>手机号</label>-->
                        <#--<label><input type="radio" class="layui-form-radio" id="valid_vt_${column_index+1}" name="valid_${column_index+1}" value="#VT" <#if (column.comments)??><#if (column.comments)?index_of("#VT") &gt; 0 >checked</#if></#if>>固话号</label>-->
                        <#--<label><input type="radio" class="layui-form-radio" id="valid_not_${column_index+1}" name="valid_${column_index+1}" value="">无校验</label>-->
                    <#--</td>-->
                    <#--<td><input type="checkbox" class="layui-form-checkbox" id="isFk_${column_index+1}" name="isFk" value="#LFK" <#if (column.comments)??><#if (column.comments)?index_of("#LFK") &gt; 0 >checked</#if></#if> /></td>-->
                    <#--<td><select id="logic_${column_index+1}" name="logic" >-->
                        <#--<option value="" <#if (column.comments)??><#if (column.comments)?index_of("#L") &lt; 0 >selected</#if></#if>>无</option>-->
                        <#--<option value="#LCP" <#if (column.comments)??><#if (column.comments)?index_of("#LCP") &gt; 0 >selected</#if></#if>>参数</option>-->
                        <#--<option value="#LCD" <#if (column.comments)??><#if (column.comments)?index_of("#LCD") &gt; 0 >selected</#if></#if>>部门</option>-->
                        <#--<option value="#LCA" <#if (column.comments)??><#if (column.comments)?index_of("#LCA") &gt; 0 >selected</#if></#if>>区域</option>-->
                    <#--</select>-->
                    <#--</td>-->
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</form>

<script>
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });

    $(function () {
        //提交，最终验证。
        $('#send').click(function(){
            $("form :input").trigger('blur');
            var numError = $('form .onError').length;

            if(numError){
                return false;
            }
            else{
                $('#listForm').submit();
            }
        });
        //保存
        $("#saveButton").click(function(){
            var $this = $(this);
            var i="1";

            for(var j=0;j<${tableInfo.listColumn?size};j++){
                i = j+1;
                var note = $("#remarks_"+i).val();
                note += "@"+$("#itemType_"+i).val();
                note += "@"+$("#remark_"+i).val();
                // if($("#isShow_"+i).is(":checked")){
                //     note += $("#isShow_"+i).val();
                // }
                // if($("#isSearch_"+i).is(":checked")){
                //     note += $("#isSearch_"+i).val();
                // }
                // if($("#isFk_"+i).is(":checked")){
                //     note += $("#isFk_"+i).val();
                // }
                //
                // if($("#valid_vnn_"+i).is(":checked")){
                //     note += $("#valid_vnn_"+i).val();
                // }
                // if($("#valid_vi_"+i).is(":checked")){
                //     note += $("#valid_vi_"+i).val();
                // }
                // if($("#valid_vd_"+i).is(":checked")){
                //     note += $("#valid_vd_"+i).val();
                // }
                // if($("#valid_ve_"+i).is(":checked")){
                //     note += $("#valid_ve_"+i).val();
                // }
                // if($("#valid_vm_"+i).is(":checked")){
                //     note += $("#valid_vm_"+i).val();
                // }
                // if($("#valid_vt_"+i).is(":checked")){
                //     note += $("#valid_vt_"+i).val();
                // }
                // note += $("#editControl_"+i+" option:selected").val();
                // if((note.indexOf("#EP")>=0) || (note.indexOf("#EN")>=0)){
                //     if($("#parameter_"+i).val() != "")
                //         note += "（"+$("#parameter_"+i).val()+"）";
                //     //note += "&";
                // }
                // note += $("#logic_"+i+" option:selected").val();

                $("#remarks_"+i).val(note);
                //alert(note)
            }
            var strAct = "${ctx}/initcode";
            $('#listForm').attr("action",strAct);
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "/initcode" ,//url
                data: $('#listForm').serialize(),
                success: function (result) {
                    if (result == 200) {
                        //配置一个透明的询问框
                        layer.msg('恭喜您，修改参数成功！', {
                            time: 20000, //20s后自动关闭
                            btnAlign: 'c',
                            btn: ['明白了']
                        });
                    }
                    ;
                },
                error : function() {
                    layer.msg('修改参数异常！', {
                        time: 20000, //20s后自动关闭
                        btnAlign: 'c',
                        btn: ['明白了']
                    });
                }
            });
        });

        //生成
        $("#generateButton").click(function(){
            var $this = $(this);
            //alert("ssss");
            var strAct = "${ctx}/generate/code";
            $('#listForm').attr("action",strAct);

            $('#listForm').submit();
        });



    });

</script>