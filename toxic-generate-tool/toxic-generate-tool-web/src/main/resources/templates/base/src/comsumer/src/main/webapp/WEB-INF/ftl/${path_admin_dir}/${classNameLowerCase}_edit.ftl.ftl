<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
<#assign isFK = 0>
<#assign isRT = 0>
<#list table.columns as column>
    <#if (column.remarks)?index_of("#LFK") &gt; 0 >
        <#assign isFK = 1>
    </#if>
    <#if (column.remarks)?index_of("#ERT") &gt; 0>
        <#assign isRT = 1>
    </#if>
</#list>
<head>
    <title>修改</title>
</head>
<body>
<h2 class="main_h2">
    <a href="<@jspEl 'base'/>/${classNameLowerCase}<#if isFK == 1><#noparse><#if (</#noparse>${classNameFirstLower}<#noparse>.foreignKey)??>?foreignKey=${</#noparse>${classNameFirstLower}<#noparse>.foreignKey}</#if></#noparse></#if>">返回</a> &raquo;
    编辑
</h2>
<#list table.columns as column>
    <#if column.pk>
    <form action="<@jspEl 'base'/>/${classNameLowerCase}<#noparse><#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??>/</#noparse><@jspEl classNameFirstLower+"."+column.columnNameFirstLower/><#noparse></#if></#noparse>"
          name="${classNameFirstLower}Form" id="${classNameFirstLower}Form" method="post">
    </#if>
</#list>
<#if isFK == 1>
    <#noparse>
            <#if (</#noparse>${classNameFirstLower}<#noparse>.foreignKey)??>
        <input type="hidden" name="foreignKey"
               id="foreignKey" value="${</#noparse>${classNameFirstLower}<#noparse>.foreignKey}"/>
</#if></#noparse>
</#if>
    <input type="hidden" name="_method" value="<#noparse><#if (_method)??>${_method}</#if></#noparse>"/>
<#list table.columns as column>
    <#if column.pk>
        <input type="hidden" id="${column.columnNameFirstLower}" name="${column.columnNameFirstLower}"
               value="<#noparse><#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??></#noparse><@jspEl classNameFirstLower+"."+column.columnNameFirstLower/><#noparse></#if></#noparse>"/>
    </#if>
</#list>
        <div id="search_infor">
            <div class="list_main">
            <div class="tab_width tab_width_half">
            <table class="table_mod table_hover" width="100%">
            <#list table.columns as column>
                <#if !column.htmlHidden>
                    <#if column.sqlName != "Create_User_ID" && column.sqlName != "Create_Date_Time" && column.sqlName != "Modify_User_ID" && column.sqlName != "Modify_Date_Time" && column.sqlName != "Delete_Flag">
                    <tr>
                        <th><#if (column.remarks)?index_of("#VNN") &gt; 0 ><span
                                class="red">* </span></#if><#if (column.remarks)?index_of("#") &gt; 0 >${(column.remarks)?substring(0,(column.remarks)?index_of("#"))}<#else>${column.remarks}</#if>
                            ：
                        </th>
                    <td>
                        <#if column.isDateTimeColumn>
                            <input type="text" class="text"
                                   value="<#noparse><#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??></#noparse><@jspEl classNameFirstLower+"."+column.columnNameFirstLower+"?datetime"/><#noparse></#if></#noparse>"
                                   name="${column.columnNameLower}" id="${column.columnNameLower}" class="text Wdate"
                                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" maxlength="${column.size}"/>

                        <#elseif (column.remarks)?index_of("#EPS") &gt; 0>
                            <#noparse><@parameter
                                parentId=</#noparse>${(column.remarks)?substring((column.remarks)?index_of("#EPS")+5,(column.remarks)?index_of("）"))}
                            >
                        <select id="${column.columnNameLower}" name="${column.columnNameLower}" class="">
                            <#noparse>
                            <#list  parameterList as para>
                                <option value="${para.parameterId}"
                                    <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??>
                                <#if (para.parameterId==</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)>
                            selected</#if> </#if>
                            >${para.parameterName}</option>
                        </#list>
                        </select>
                        </@parameter>
                        </#noparse>

                        <#elseif (column.remarks)?index_of("#EPC") &gt; 0>
                            <#noparse><@parameter
                                parentId=</#noparse>${(column.remarks)?substring((column.remarks)?index_of("#EPC")+5,(column.remarks)?index_of("）"))}
                            >
                            <#noparse>
                            <#list  parameterList as para></#noparse>
                        <label class="checkbox-inline"><input type="checkbox" name="${column.columnNameLower}"
                                                              <#noparse>value="${para.parameterId}"
                                                                      <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??>
                                <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)?index_of(para.parameterId) &gt; -1 >
                            checked</#if>
                            <#elseif para_index==0>checked</#if>>${para.parameterName}</label>
                        </#list>
                        </@parameter>
                        </#noparse>

                        <#elseif (column.remarks)?index_of("#EPR") &gt; 0>
                            <#noparse><@parameter
                                parentId=</#noparse>${(column.remarks)?substring((column.remarks)?index_of("#EPR")+5,(column.remarks)?index_of("）"))}
                            >
                            <#noparse>
                            <#list  parameterList as para></#noparse>
                        <label class="redio-inline"><input type="radio" name="${column.columnNameLower}"
                                                           <#noparse>value="${para.parameterId}"
                                                                   <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??>
                                <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)?index_of(para.parameterId) &gt; -1 >
                            checked</#if>
                            <#elseif para_index==0>checked</#if>>${para.parameterName}</label>
                        </#list>
                        </@parameter>
                        </#noparse>

                        <#elseif (column.remarks)?index_of("#ENS") &gt; 0>
                            <#assign listPara = (column.remarks)?substring((column.remarks)?index_of("#ENS")+5,(column.remarks)?index_of("）"))>
                            <select id="${column.columnNameLower}" name="${column.columnNameLower}" class="">
                                <#list listPara?split("、") as para>
                                    <option value="${para?substring(0,para?index_of("-"))}" <#noparse>
                                        <#if (</#noparse>${classNameFirstLower}
                                        .${column.columnNameFirstLower}<#noparse>)??>
                                        <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}==<#if column.isStringColumn>"</#if>${para?substring(0,para?index_of("-"))}<#if column.isStringColumn>"</#if><#noparse>)>
                                    selected</#if></#if></#noparse>>${para?substring(para?index_of("-")+1)}</option>
                                </#list>
                            </select>

                        <#elseif (column.remarks)?index_of("#ENC") &gt; 0>
                            <#assign listPara = (column.remarks)?substring((column.remarks)?index_of("#ENC")+5,(column.remarks)?index_of("）"))>
                            <#list listPara?split("、") as para>
                                <label class="checkbox-inline"><input type="checkbox" name="${column.columnNameLower}"
                                                                      value="${para?substring(0,para?index_of("-"))}" <#noparse>
                                        <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??>
                                        <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower})?index_of("${para?substring(0,para?index_of("-"))}") &gt; -1 >
                                    checked<#noparse></#if></#if></#noparse>>${para?substring(para?index_of("-")+1)}</label>
                            </#list>

                        <#elseif (column.remarks)?index_of("#ENR") &gt; 0>
                            <#assign listPara = (column.remarks)?substring((column.remarks)?index_of("#ENR")+5,(column.remarks)?index_of("）"))>
                            <#list listPara?split("、") as para>
                                <label class="radio-inline"><input type="radio" name="${column.columnNameLower}"
                                                                   value="${para?substring(0,para?index_of("-"))}" <#noparse>
                                        <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??>
                                        <#if </#noparse>${classNameFirstLower}.${column.columnNameFirstLower}==<#if column.isStringColumn>"</#if>${para?substring(0,para?index_of("-"))}<#if column.isStringColumn>"</#if>>
                                    checked<#noparse></#if></#if></#noparse>>${para?substring(para?index_of("-")+1)}</label>
                            </#list>

                        <#elseif (column.remarks)?index_of("#EDS") &gt; 0>
                            <#noparse><@dept
                                parentId=</#noparse>${(column.remarks)?substring((column.remarks)?index_of("#EDS")+4,(column.remarks)?index_of("&"))}
                            >
                        <select id="${column.columnNameLower}" name="${column.columnNameLower}" class="">
                            <#noparse>
                            <#list deptList as dept>
                                <option value="${dept.deptId}"
                                    <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??>
                                <#if (dept.deptId==</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)>
                            selected</#if> </#if>
                            >${dept.deptName}</option>
                        </#list>
                        </select>
                        </@dept>
                        </#noparse>

                        <#elseif (column.remarks)?index_of("#EOR") &gt; 0>
                            <label><input type="radio" name="${column.columnNameLower}" class="radio" value="0" <#noparse>
                                    <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??>
                                    <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>=="0")>
                                checked="checked"</#if></#if></#noparse> />否</label>
                            <label><input type="radio" name="${column.columnNameLower}" class="radio" value="1" <#noparse>
                                    <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??>
                                    <#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>=="1")>
                                checked="checked"</#if></#if></#noparse> />是</label>

                        <#elseif (column.remarks)?index_of("#ERT") &gt; 0>
                            <script type="text/plain" id="editor" name="${column.columnNameLower}">
                        <#noparse><#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>
                                )??></#noparse><@jspEl classNameFirstLower+"."+column.columnNameFirstLower/><#noparse>
                                </#if></#noparse>

                            </script>

                        <#else>
                            <input type="text" class="text"
                                   value="<#noparse><#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??></#noparse><@jspEl classNameFirstLower+"."+column.columnNameFirstLower/><#noparse></#if></#noparse>"
                                   name="${column.columnNameLower}" id="${column.columnNameLower}"
                                   maxlength="${column.size}"/>
                        </#if>
                        </td>
                        </tr>
                    </#if>
                </#if>
            </#list>
                </table>
                <div class="center_btn">
                    <input type="button" value="返回列表"
                           onclick='window.location="<@jspEl 'base'/>/${classNameLowerCase}<#if isFK == 1><#noparse><#if (</#noparse>${classNameFirstLower}<#noparse>.foreignKey)??>?foreignKey=${</#noparse>${classNameFirstLower}<#noparse>.foreignKey}</#if></#noparse></#if>";'
                           class="btn_bule"/> &bnsp;
                    <input type="submit" value="保存" class="btn_bule"/> &nbsp;
                    <input type="reset" value="重置" class="btn_bule"/>
                </div>
            </div>
        </div>
    </div>
</form>
<script type="text/javascript">
    <!--
    $(function () {

        //表单验证
        $("form :input").blur(function () {
            var $parent = $(this).parent();
            $parent.find(".red").remove();

        <#list table.columns as column>
            <#if (column.remarks)?index_of("#V") &gt; 0 >
                //${column.remarks}
                if ($(this).is("#${column.columnNameLower}")) {
                    var errorMsg = "";
                    <#if (column.remarks)?index_of("#VNN")  &gt; 0 >
                    if (!isNotNull(this.value)) {
                        errorMsg = "不能为空";
                    }
                        <#if (column.remarks)?index_of("#VI") &gt; 0 || (column.remarks)?index_of("#VD") &gt; 0 || (column.remarks)?index_of("#VE") &gt; 0 || (column.remarks)?index_of("#VM") &gt; 0 || (column.remarks)?index_of("#VT") &gt; 0  >
                        else {
                            <#if (column.remarks)?index_of("#VI") &gt; 0 >
                                if (!isInteger(this.value)) {
                                    errorMsg = "请输入正确的整数";
                                }
                            </#if>
                            <#if (column.remarks)?index_of("#VD") &gt; 0 >
                                if (!isDecimal(this.value)) {
                                    errorMsg = "请输入正确的数字";
                                }
                            </#if>
                            <#if (column.remarks)?index_of("#VE") &gt; 0 >
                                if (!isEmail(this.value)) {
                                    errorMsg = "请输入正确的邮件地址";
                                }
                            </#if>
                            <#if (column.remarks)?index_of("#VM") &gt; 0 >
                                if (!isMobile(this.value)) {
                                    errorMsg = "请输入正确的手机号码";
                                }
                            </#if>
                            <#if (column.remarks)?index_of("#VT") &gt; 0 >
                                if (!isPhone(this.value)) {
                                    errorMsg = "请输入正确的固话号码";
                                }
                            </#if>
                        }
                        </#if>
                    <#else>
                        if (isNotNull(this.value)) {
                            <#if (column.remarks)?index_of("#VI") &gt;0 >
                                if (!isInteger(this.value)) {
                                    errorMsg = "请输入正确的整数";
                                }
                            </#if>
                            <#if (column.remarks)?index_of("#VD") &gt; 0 >
                                if (!isDecimal(this.value)) {
                                    errorMsg = "请输入正确的数字";
                                }
                            </#if>
                            <#if (column.remarks)?index_of("#VE") &gt; 0 >
                                if (!isEmail(this.value)) {
                                    errorMsg = "请输入正确的邮件地址";
                                }
                            </#if>
                            <#if (column.remarks)?index_of("#VM") &gt; 0 >
                                if (!isMobile(this.value)) {
                                    errorMsg = "请输入正确的手机号码";
                                }
                            </#if>
                            <#if (column.remarks)?index_of("#VT") &gt; 0 >
                                if (!isPhone(this.value)) {
                                    errorMsg = "请输入正确的固话号码";
                                }
                            </#if>
                        }
                    </#if>

                    if (errorMsg != "") {
                        $parent.append('<span class="red onError">' + errorMsg + '</span>');
                    }
                }

            </#if>
        </#list>


        }).keyup(function () {
            $(this).triggerHandler("blur");
        }).focus(function () {
            $(this).triggerHandler("blur");
        });

        //提交，最终验证。
        $('#send').click(function () {
            $("form :input").trigger('blur');
            var numError = $('form .onError').length;

            if (numError) {
                return false;
            }
            else {
                $('#${classNameFirstLower}Form').submit();
            }
        });


        //重置
        $('#reset').click(function () {
            $("form :input").each(function (index) {
                $(".red").remove();
            })
        });


    });

    //-->
</script>
<#if isRT == 1>
<script type="text/javascript">
    //实例化编辑器
    var ue = UE.getEditor('editor');
    var domUtils = UE.dom.domUtils;

    ue.addListener("ready", function () {
        ue.focus(true);
    });
</script>
</#if>
</body>