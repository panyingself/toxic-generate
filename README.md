# toxic-generate

Springboot 基于sharding-jdbc的yml模式，动态数据源实现了通用代码生成工具

简要介绍

  使用的插件

  sharding-jdbc --分库分表，读写分离
  
  rapid-framework --代码生成插件
  
  mybatis-plus
  
  page-helper


相关服务说明

parent工程作作为一个整合，提供了公用的文本定义等信息

api工程为provier工程提供了interface以及model、query对象

provier工程提供了具体的interface实现以及mapper实现、mybatis xml文件等

web工程作为api入口，主要对外提供http服务


最终的产物

根据可视化页面选择对应的db下指定的table，生成时可以指定package路径
工具模板对应模板生成的内容大致如下：

对应table的mapper.xml文件
对应table通用curd的dao文件，包含分页查询以及getById
对应table的model、query对象
对应table通用curd的service、serviceImpl文件，包含分页查询以及getById
对应table通用curd的business文件，包含分页查询以及getById
对应table通用curd的controller文件，包含分页查询以及getById
以及对应的test类

