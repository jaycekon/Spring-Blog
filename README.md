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