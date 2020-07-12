# BuyTrend

### 介绍

通过趋势投资来进去对指数的的分析投资，达到收益的效果。

所用到的技术栈有如下：

**后端框架：**

- SpringCloud
- SpringBoot
- SpringMvc

**前台框架：**

- Jquery
- Bootstarp
- vue
- charjs

**开发工具：**

- Intellij IDEA 
- Maven

**中间件：**

- zipkin
- redis
- rabbitMQ

结构图如下：图中没点亮的是还没有进行开发的服务

![](https://upload-images.jianshu.io/upload_images/22691891-85fdc5d5c099587b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

关于服务模块的介绍： 

#### eureka-server

主要用于做服务注册的注册中心

#### third-part-index-data-project

用于获取第三方的数据，这里用的是因为爬下来的数据。因为关于这些数据很多网站都是收费的，这里是是一段过去的相关指数的代码和数据。

#### index-gather-store-service

用于通过数据提供模块来采集指数代码和数据进行Redis的持久化，便于数据的保存。

#### index-codes-service

用于从redis中提取指数代码来封装成接口给其他微服务模块使用。

#### index-data-service

用于从redis中提取指数数据来封装成接口给其他微服务模块使用。

#### trend-trading-backtest-service

用于将所有获取的数据进行一系列的二次处理，如果将指数代码和指数数据进行模拟回测，提供了更多分析后的数据，给出我们的趋势投资后的数据。关于具体如何趋势投资，后续会再这里继续补充一下。

#### trend-trading-backtest-view

用于将我们所有打包的数据进行图表显示，下面会给上相关截图。

### 相关截图

（这里我们以选取一只指数来展示具体的图表分析展示）

![](https://upload-images.jianshu.io/upload_images/22691891-83cb121b8d6507ae.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![](https://upload-images.jianshu.io/upload_images/22691891-0b4d8bb08cd036b0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![](https://upload-images.jianshu.io/upload_images/22691891-fa004027370e5405.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![](https://upload-images.jianshu.io/upload_images/22691891-66566a3058b24b8d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![](https://upload-images.jianshu.io/upload_images/22691891-597938ebf0a42b1d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![](https://upload-images.jianshu.io/upload_images/22691891-522925ed03ab57fe.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

(....交易明细截图一部分展示)