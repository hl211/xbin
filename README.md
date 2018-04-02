## xbin-store
[![License](https://img.shields.io/badge/license-GPL-blue.svg)](LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/xubinux/xbin-store.svg?style=social&label=Stars)](https://github.com/xubinux/xbin-store)[![GitHub forks](https://img.shields.io/github/forks/xubinux/xbin-store.svg?style=social&label=Fork)](https://github.com/xubinux/xbin-store)

模仿国内知名B2C网站,实现的一个分布式B2C商城

使用技术:

* 后台
	* 使用`Spring Boot` 构建整个项目 去除 XML 配置
	* `Maven`构建项目
	* `Jenkins`作为持续集成
	* 采用`Dubbox`作为RPC框架
	* `kryo`序列化
	* 使用 `Apollo` 配置中心
	* 使用`Spring`+`Spring MVC`+`MyBatis`SSM框架
	* 数据库连接池使用`druid`
	* 数据库使用`MySQL`和`Redis`
	* 页面引擎采用 `Beetl`
	* 网页采用`freemarker`生成静态化页面
	* 存储采用`FastDFS`存储图片等文件
	* 采用`Solr`实现搜索服务
	* `Swagger2` 生成 RESTful Apis文档
	* 负载均衡使用`Nginx`、`keepalived`实现高可用
	* 采用`Spring Scheduled`做任务调度
	* 消息中间件采用`RabbitMQ`
	* 在分布式事务上则采用了[TCC](https://github.com/changmingxie/tcc-transaction)解决订单支付方面时效性要求性高的分布式事务,可靠的消息服务则来解决如会计记录等时效性要求低的分布式事务.
* 前台
	* 采用基于[AdminLTE](https://github.com/almasaeed2010/AdminLTE)的[roncoo-adminLTE](https://github.com/roncoo/roncoo-adminLTE)(主要增加了Ajax的布局模式)
	* AdminLTE集成太多Js这里就不一一列举了
	
## xbin-mobile 移动端
http://git.oschina.net/orangehs/xbin-mobile

> 目前由 orange 开发,有兴趣可以联系

## Pull Request
内容可以是优化、新功能、Bug修复等。

期待您的 `Pull Request`

## 运行教程  <----我是教程
[点我查看运行教程(不使用Docker)](https://github.com/xubinux/xbin-store/wiki/Tutorial-(Not-Use-Docker))

[点我查看运行教程(使用Docker 暂无!)](https://github.com/xubinux/xbin-store/wiki/Tutorial-(Not-Use-Docker))

## Tomcat地址(本机)
|名称|IP|完成情况|
|:---------------:|:---------------:|:---------------:|
| Portal  |192.168.125.1:8101 |[完成情况](https://github.com/xubinux/xbin-store/blob/master/xbin-store-web-portal/README.md)|
| Search  |192.168.125.1:8102 |[完成情况](https://github.com/xubinux/xbin-store/blob/master/xbin-store-web-search/README.md)|
| Item    |192.168.125.1:8103 |[完成情况](https://github.com/xubinux/xbin-store/blob/master/xbin-store-web-item/README.md)|
| SSO     |192.168.125.1:8104 |[完成情况](https://github.com/xubinux/xbin-store/blob/master/xbin-store-web-sso/README.md)|
| Admin   |192.168.125.1:8105 |[完成情况](https://github.com/xubinux/xbin-store/tree/master/xbin-store-web-admin/README.md)|
| Cart    |192.168.125.1:8106 |[完成情况](https://github.com/xubinux/xbin-store/tree/master/xbin-store-web-cart/README.md)|
| Order   |192.168.125.1:8107 |[完成情况](https://github.com/xubinux/xbin-store/blob/master/xbin-store-web-order/README.md)|
| Recommended	|192.168.125.1:8109 |\|
| AD    			|192.168.125.1:8110 |\|
| Ranking     	|192.168.125.1:8111 |\|
| Mymoney     	|192.168.125.1:8112 |\|
| Pay     		|192.168.125.1:8113 |\|
| Baitiao     	|192.168.125.1:8114 |\|
| Coupons     	|192.168.125.1:8115 |\|
| Seckill     	|192.168.125.1:8116 |\|
| CS     			|192.168.125.1:8117 |\|
| API    			|192.168.125.1:8118 |\|

## Dubbox服务地址
| 服务名称|Dubbox服务端口  |rest服务端口|
|:---------------:|:---------------:|:---------------:|
| Admin-Service      | 192.168.125.1:20880 |rest:8510 |
| Redis-Service      | 192.168.125.1:20881 |rest:8511 |
| Search-Service     | 192.168.125.1:20882 |rest:8512 |
| Portal-Service     | 192.168.125.1:20883 |rest:8513 |
| Item-Service       | 192.168.125.1:20884 |rest:8514 |
| SSO-Service        | 192.168.125.1:20885 |rest:8515 |
| Notify-Service     | 192.168.125.1:20886 |rest:8516 |
| Cart-Service       | 192.168.125.1:20887 |rest:8517 |
| Order-Service      | 192.168.125.1:20888 |rest:8518 |
| Home	-Service				|192.168.125.1:20889 |rest:8519 |
| Recommended-Service		|192.168.125.1:20890 |rest:8520 |
| AD-Service    			|192.168.125.1:20891 |rest:8521 |
| Ranking-Service     	|192.168.125.1:20892 |rest:8522 |
| Mymoney-Service     	|192.168.125.1:20893 |rest:8523 |
| Pay-Service     			|192.168.125.1:20894 |rest:8524 |
| Baitiao-Service     	|192.168.125.1:20895 |rest:8525 |
| Coupons-Service     	|192.168.125.1:20896 |rest:8526 |
| Seckill-Service     	|192.168.125.1:20897 |rest:8527 |
| CS-Service     			|192.168.125.1:20898 |rest:8528 |




* Zookeeper1    提供服务:Zookeeper
* FastDFS1        提供服务:FastDFS Tracker
* FastDFS2        提供服务:FastDFS Storage
* Redis         提供服务:Redis
* Solr          提供服务:Solr



注意：
1、lombok---用于pojo注解get与set的包，除了maven加依赖后，
还需要在idea安装插件
2、druid 密码需要加密,不加密需更改配置文件 config.decrypt=false
3、#如果需要打开druid监控需要enabled,xbin-store-common-mapper中加入spring boot web
4、springboot dubbo 测试只需要在测试类上
@RunWith(SpringRunner.class)
@SpringBootTest(classes = XbinStoreServiceAdminApplication.class)