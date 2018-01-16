# Spring-Blog
分模块化开发Spring Boot 博客平台

## Spring Boot Gradle 博客平台

### 技术栈
- Spring Boot
- Mybatis
- Redis
- Kafka
- ELK
- Swagger

### 8102-01-09 项目目录结构搭建

Spring-Blog

- Spring-Blog-api  对外API接口服务
- Spring-Blog-business POJO类处理
- Spring-Blog-common 工具类

基于Gradle 整合SpringBoot，Mybatis，Log


### 8102-01-10 引入Spring Boot 2.0 WebFlux 新特性

Spring-Blog

- Spring-Blog-api  对外API接口服务（后续废弃）
- Spring-Blog-business POJO类处理
- Spring-Blog-common 工具类
- Spring-Blog-webFlux  基于WebFlux 开发的Api 接口服务

拓展技术：
    **Webflux** 是Spring 5 引入的 **Reactive Web** 服务，兼容Spring Mvc 服务
 
 
#### 数据库：
    resource: charles_blog.sql
    
    
### 8102-01-15 配置Mybatis 多数据源以及设置数据库连接池
#### Spring-Blog-api:

- **DataSource**

在 Config 目录下配置DataSource 相关配置，主要做了数据库连接池配置
```
~\Spring-Blog\Spring-Blog-api\src\main\java\com\charles\api\config\dataSource\DruidDataSourceConfig.java
```

配置多数据源主要在以下类进行处理
```
~\Spring-Blog\Spring-Blog-api\src\main\java\com\charles\api\config\dataSource\DataSourceConfig.java
```  



- **Thymeleaf**

接入模板引擎，由于WebFlux 不支持（Thymeleaf 基于javax.servlet），因此将Thymeleaf 放在Api目录下进行开发。


- **Swagger**

接入Swagger Api 文档生成器，配置文件存放地址：
```
~\Spring-Blog\Spring-Blog-api\src\main\java\com\charles\api\config\swagger\SwaggerConfig.java
```


### 8102-01-15 配置Mybatis 主从分离，Redis连接池