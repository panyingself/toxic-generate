<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first> 
<#assign classNameLowerCase = className?lower_case>
<#assign isFK = 0>
<#list table.columns as column>
<#if (column.remarks)?index_of("#LFK") &gt; 0 >
<#assign isFK = 1>
</#if>
</#list>
	<form action="<@jspEl 'base'/>/${classNameLowerCase}" method="post" name="listForm" id="listForm">
        <div id="search_infor">
            <h2 class="main_h2">列表
            </h2>

			<#if isFK == 1>
			<#noparse><#if (</#noparse>${classNameFirstLower}<#noparse>Query.foreignKey)??>
			<input type="hidden" name="foreignKey" id="foreignKey" value="${</#noparse>${classNameFirstLower}<#noparse>Query.foreignKey}"/>
			</#if></#noparse>
			</#if>

			<div class="list_main">
                <div class="search_hd clearfix">
                    <div id="searchDiv" class="search_area">

                        <div class="search_item">
                            <label>ID:</label>
                            <div class="control">
								<input type="text" id="keyWord" name="keyWord" value="<#noparse>${</#noparse>${classNameFirstLower}Query.keyWord<#noparse>}</#noparse>" maxlength="200" />
							</div>
						</div>

                        <div class="search_btn_area">
                            <input type="button" id="searchBtn" value="搜 索" onclick="searchCondition();"/>
                            <input type="button" value="清 空" onclick="clearquery();"/>
                        </div>

					</div>
				</div>
                <!--/*表格开始*/-->
                <div class="tab_width">
                    <div class="tab_auto">
                        <table class="table_mod table_hover" width="100%">
                            <tr>
                                <th class="check"><input type="checkbox" name="selectAll" id="selectAll" /></th>
                                <th>序号</th>
								<#list table.columns as column>
									<#if (column.remarks)?index_of("#OS") &gt; 0 >
										<th><#if (column.remarks)?index_of("#") &gt; 0 >${(column.remarks)?substring(0,(column.remarks)?index_of("#"))}<#else>${column.remarks}</#if></th>
									</#if>
								</#list>
                                <th>操作选项</th>
                            </tr>
						<#noparse><#if </#noparse>${classNameFirstLower}List<#noparse>?exists></#noparse>
						<#noparse><#list</#noparse> ${classNameFirstLower}<#noparse>List as</#noparse> ${classNameFirstLower} <#noparse>> </#noparse>
                            <tr>
                                <td><#list table.columns as column><#if column.pk><input type="checkbox" id="${column.columnNameLower}s<@jspEl classNameFirstLower+"."+column.columnNameFirstLower/>" name="ids" value="<@jspEl classNameFirstLower+"."+column.columnNameFirstLower/>"/></#if></#list></td>
                                <td><@jspEl classNameFirstLower+"_index+1"/></td>
							<#list table.columns as column>
								<#if (column.remarks)?index_of("#OS") &gt; 0 >
									<#if column.isDateTimeColumn>
                                        <td><#noparse><#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??></#noparse><@jspEl classNameFirstLower+"."+column.columnNameFirstLower+"?datetime"/><#noparse></#if></#noparse></td>
									<#else>
										<#if (column.remarks)?index_of("#LC") &gt; 0 >
                                            <td><#noparse><#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}Name<#noparse>)??></#noparse><@jspEl classNameFirstLower+"."+column.columnNameFirstLower+"Name"/><#noparse></#if></#noparse></td>
										<#elseif (column.remarks)?index_of("#EN") &gt; 0>
											<#assign listPara = (column.remarks)?substring((column.remarks)?index_of("#EN")+5,(column.remarks)?index_of("）"))>
                                            <td>
												<#noparse><#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??></#noparse>
												<#list listPara?split("、") as para>
													<#if para_index==0>
														<#noparse><#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}==<#if column.isStringColumn>"</#if>${para?substring(0,para?index_of("-"))}<#if column.isStringColumn>"</#if>)>${para?substring(para?index_of("-")+1)}
													<#else>
														<#noparse><#elseif (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}==<#if column.isStringColumn>"</#if>${para?substring(0,para?index_of("-"))}<#if column.isStringColumn>"</#if>)>${para?substring(para?index_of("-")+1)}
													</#if>
												</#list>
												<#noparse></#if></#noparse>
												<#noparse></#if></#noparse>
                                            </td>
										<#else>
                                            <td><#noparse><#if (</#noparse>${classNameFirstLower}.${column.columnNameFirstLower}<#noparse>)??></#noparse><@jspEl classNameFirstLower+"."+column.columnNameFirstLower/><#noparse></#if></#noparse></td>
										</#if>
									</#if>
								</#if>
							</#list>
                                <td>
								<#list table.columns as column>
									<#if column.pk>
                                        <a href="<@jspEl 'base'/>/${classNameLowerCase}/<@jspEl classNameFirstLower+"."+column.columnNameFirstLower/><#if isFK == 1><#noparse><#if (</#noparse>${classNameFirstLower}<#noparse>Query.foreignKey)??>?foreignKey=${</#noparse>${classNameFirstLower}<#noparse>Query.foreignKey}</#if></#noparse></#if>">修改</a> |
                                        <a href="javascript:$.deleteRow(<@jspEl classNameFirstLower+"."+column.columnNameFirstLower/>);">删除</a>
									</#if>
								</#list>
                                </td>
                            </tr>
						<#noparse>	</#list>
                        <#else></#noparse>
                            <tr class="main_info">
                                <td colspan="6">没有相关数据</td>
                            </tr>
						<#noparse></#if></#noparse>
				</table>
			</div>
		</div>
		<#noparse><@p.pagination page /></#noparse>
		</div>
	</form>