<h1 align="center">
  OpenAPI-免费的API接口开放平台
</h1>

<p align="center">
  <a href="http://120.55.86.83/"><img src="https://img.shields.io/badge/博客-Java达摩院-brightgreen.svg?style=for-the-badge"></a>
  <a href="#"><img src="https://img.shields.io/badge/公众号-Echo-green.svg?style=for-the-badge"></a>
  <a href="#" target="_blank"><img src="https://img.shields.io/badge/关于我-Echo-critical?style=for-the-badge"></a>
</p>

## 项目简介

一个提供 API 接口供开发者调用的平台。管理员可以接入并发布接口，统计分析各接口调用情况；用户可以注册登录并开通接口调用权限，然后可以浏览接口及在线调试，还能使用客户端 SDK 轻松在代码中调用接口。

### 主页

浏览接口:

![image-20230602162133123](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/image-20230602162133123.png)

在线调试:

![image-20230602163711487](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/image-20230602163711487.png)

### 管理页

接口管理:

![image-20230602163750253](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/image-20230602163750253.png)

接口分析:

![image-20230602164207708](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/image-20230602164207708.png)

## 技术选型

### 前端： 

- React 18

- Ant Design Pro 5.x 脚手架
- Ant Design & Procomponents 组件库
- Umi 4 前端框架
- OpenAPI 前端代码生成

### 后端:

 

- Java Spring Boot
- MySQL 数据库
- MyBatis-Plus 及 MyBatis X 自动生成
- API 签名认证（Http 调用）
- Spring Boot Starter（SDK 开发）
- Dubbo 分布式（RPC、Nacos）
- Swagger + Knife4j 接口文档生成
- Spring Cloud Gateway 微服务网关
- Hutool、Apache Common Utils、Gson 等工具库

## 业务流程

![image-20230602163817491](https://javablog-image.oss-cn-hangzhou.aliyuncs.com/blog/image-20230602163817491.png)

## 功能实现

### 后台

✅ 发布接口

✅ 下线接口

✅ 接口管理（增删改查）

✅ 统计分析

### 前台

✅ 浏览接口

开通接口

### 网关

✅ 调用接口

接口计费

✅ 接口保护

✅ 鉴权认证

✅ 路由

✅ 日志

✅ 跨域

✅ 缓存

✅ 流量染色

✅ 调用次数统计

## 最后

**项目地址:**

github：https://github.com/shenzehui/openapi-platform-web

gitee：https://gitee.com/shenzehui/openapi-platform-web
