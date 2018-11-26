<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase = className?lower_case>
package ${basepackage}.service;

import com.alibaba.fastjson.JSON;
import com.reapal.common.page.Page;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ${basepackage}.model.*;
import ${basepackage}.mapper.*;
import ${basepackage}.mapper.impl.*;
import ${basepackage}.repository.*;
import ${basepackage}.repository.impl.*;
import ${basepackage}.model.query.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class ${className}ServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(${className}ServiceTest.class);
	
	@Autowired
	private ${className}Service ${classNameFirstLower}Service;

	@Before
	public void before() throws Exception {
		// TODO: init your parameter here
	}

	@After
	public void after() throws Exception {
		// TODO: destroy your parameter here
	}

	@Test
	@Rollback
	public void testInsert(){
		${className} ${classNameFirstLower} = new${className}();
		Assert.assertEquals(1,${classNameFirstLower}Service.insert(${classNameFirstLower}));
	}

	@Test
	@Rollback
	public void testUpdate(){
		${className} ${classNameFirstLower} = new${className}();
		Assert.assertEquals(1,${classNameFirstLower}Service.insert(${classNameFirstLower}));
		Assert.assertEquals(1,${classNameFirstLower}Service.update(${classNameFirstLower}));
	}
	@Test
	public void testDelete${className}(){
		${className} obj = new${className}();
		${classNameFirstLower}Service.insert${className}(obj);
		${classNameFirstLower}Service.update${className}(obj);
		${classNameFirstLower}Service.delete${className}(obj.get${table.idColumn.columnName}());
		// TODO: Write yourself test code
	}

	@Test
	public void testGetById(){
		${className} ${classNameFirstLower} = ${classNameFirstLower}Service.getById("1011");
		Assert.assertNotNull(${classNameFirstLower});
		logger.debug(JSON.toJSONString(${classNameFirstLower}));
	}

	@Test
	public void testQueryList(){
		${className}Query ${classNameFirstLower}Query = new ${className}Query();
		List<${className}> ${classNameFirstLower}List = ${classNameFirstLower}Service.queryList(${classNameFirstLower}Query);
		Assert.assertNotNull(${classNameFirstLower}List);
		Assert.assertTrue(!${classNameFirstLower}List.isEmpty());
	}

	@Test
	public void testQueryListPage(){
		${className}Query ${classNameFirstLower}Query = new ${className}Query();
		Page<${className}> page = new Page<${className}>(1, 2);

		Page<${className}> ${classNameFirstLower}Page = ${classNameFirstLower}Service.queryListPage(${classNameFirstLower}Query,page);
		Assert.assertNotNull(${classNameFirstLower}Page);
		Assert.assertTrue(!${classNameFirstLower}Page.getRecords().isEmpty());
	}

	/**
	 * 创建对象
	 */
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
