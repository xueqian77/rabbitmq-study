# rabbitmq-study

#### 项目介绍
用来学习rabbitmq的demo（springboot），带有direct\fanout\topic三种交换机的使用方法。

#### 开发环境

| 工具    | 版本或描述                |
| ----- | -------------------- |
| OS    | Windows 10           |
| JDK   | 1.8+                 |
| IDE   | IntelliJ IDEA 2021.1 |
| Maven | 3.5.4                |
| RabbitMq | 3.7.18                |


#### MQ安装

1.网上教程很多，这里就不复述了，跟据自己的环境去搜索安装吧。

#### 目录结构
``` lua
rabbitmq-study
├── cn.x.study
├──── config -- 配置
├──────── consumer   -- 消费者全局配置
├──────── producer   -- 生产者全局配置
├──── direct -- 直连交换机代码
├──────── config     -- 交换机队列绑定配置
├──────── consumer   -- 监听器
├──────── controller -- 控制层
├──────── service    -- 业务处理层
├──── fanout -- 扇形交换机代码
├──────── config     -- 交换机队列绑定配置
├──────── consumer   -- 监听器
├──────── controller -- 控制层
├──────── service    -- 业务处理层
├──── topic  -- 主题交换机代码
├──────── config     -- 交换机队列绑定配置
├──────── consumer   -- 监听器
├──────── controller -- 控制层
├──────── service    -- 业务处理层
├── RabbitmqStudyApplication -- 启动类
```


#### 使用说明

1. 按照(`resources/application.yml_template`)增加(`resources/application.yml`)配置文件
    1. 修改数据库链接
2. 运行项目
    1. springboot启动类启动

#### 开源协议
[MIT](https://github.com/xueqian77/rabbitmq-study/blob/main/LICENSE)
