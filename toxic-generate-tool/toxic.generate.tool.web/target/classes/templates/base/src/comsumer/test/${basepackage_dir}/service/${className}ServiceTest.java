<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.service;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import com.fei.common.page.Page;

import ${basepackage}.model.*;
import ${basepackage}.dao.*;
import ${basepackage}.dao.impl.*;
import ${basepackage}.service.*;
import ${basepackage}.service.impl.*;
import ${basepackage}.model.query.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ApplicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ${className}ServiceTest {

	
	@Autowired
	private ${className}Service ${classNameFirstLower}Service;

	@Before
	public void before() throws Exception {

		}

	@After
	public void after() throws Exception {
	}


//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		${className} obj = new${className}();
		${classNameFirstLower}Service.insert${className}(obj);
		
		${classNameFirstLower}Service.update${className}(obj);
		
	<#if table.compositeId>
		//assertNotNull(${classNameFirstLower}Service.getById(obj.getId()));
		
	<#else>
		//assertNotNull(obj.get${table.idColumn.columnName}());
		
		${classNameFirstLower}Service.delete${className}(obj.get${table.idColumn.columnName}());
	</#if>
	
	}
	
	public static ${className} new${className}() {
		${className} obj = new ${className}();
		
		<#list table.columns as column>
	  		<#if column.isNotIdOrVersionField>
	  			<#if column.isDateTimeColumn>
	  	obj.set${column.columnName}(new ${column.javaType}(System.currentTimeMillis()));
	  			<#else>
	  	obj.set${column.columnName}(new ${column.javaType}("1"));
	  			</#if>
			</#if>
		</#list>
		return obj;
	}
}
