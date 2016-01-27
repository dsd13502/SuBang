#开源中国Android 源码分析
##目录
1. ####工作过程
  1. **[启动界面 app_start](#启动界面)**
  
1. #### 各包内容

  1. **[adapter](#启动界面)**  
  2. **[api](#api)**
  3. **[base](#base)**
  4. **[bean](#bean)**
  5. **[cache](#cache)**
  6. **[emoji](#emoji)**
  7. **[db](#db)**
  8. **[cache](#cache)**
  9. **[fragment](#fragment)**
  10. **[interf](#interf)**
  10. **[ui](#ui)**
  11. **[viewpagefragment](##viewpagefragment)**
  12. **[widget](##widget)**
  13.  **[wxapi](##wxapi)**    

1.  #### 源码地址


##启动界面
　　－－＞AppStart.java

> 1. 利用了动画中的View的渐变动画效果，从半透明到完全不透明，动画持续时间为800ms,动画结束后，完成日志的上传和界面的跳转。
> 2. 日志上传利用服务在后台完成的，无论上传成功还是失败，最后要记得关掉服务。成功后，将旧的日志文件删除，因为我们要进行新的一轮操作，至于在什么地方会保存日志，后面随着逐步分分析应该会找到它的。此处用到了第三方包https://github.com/loopj/android-async-http. 
> 3. 在onResume函数中做了以下处理：主要是考虑APP版本升级后，当前的版本大于之前的版本，那么就将之前缓存的图片给清理掉，升级后缓存的图片很有可能没有用处了：此处引用了第三方包 http://kjframe.github.io/  。 （此包确实强大，可惜的是API文档中没有对启动界面引用的preference的API的详细解释，因此本条分析完全是自己揣摩的。至于图片缓存是App中哪一模块用到的，后面随着逐步分分析应该会找到它的。） 

 [原文地址](http://my.oschina.net/jixin/blog/416284)

## 启动博客过程
   1.初始数据的载入
   2.BlogFragment 博客列表
     1.item点击通过 UIHelper 启动 [DetailActivity](3.DetailActivity)
   3.DetailActivity 详情activity（包括：资讯、博客、软件、问答、动弹）
## XmlUtils 
--> xml解析工具类,猜测数据应该是以xml文件格式传送的
网站个的数据原型是什么？？htmel？ 
　
　　


## adapter 
将控件绑定在里面，用于将数据注入控件中，起到数据与空间之间交互的桥梁

1.ActiveAdapter
2.BlogAdapter 
## api 
--> 网络通信接口

## base 
--> 基础库
## bean 
--> 应用程序素材的角色
## cache
 --> 缓存
## emoji
 -->表情
## db
 --> 数据库
## fragment
## interf 
-->interface
## ui 
 -->
* NavigationDrawerFragment --> 侧滑侧滑菜单界面
       |___ UIHelper :界面帮助类（位于：/util/ 详细见 /util/README_FOR_UTIL）
            |___

## viewpagefragment 目录 --> 存放与导航栏相对应的fragment或者##

## widget -- >自定义的控件
##wxapi
　　微信回调




*

2016.1.16 0:42

从 选择侧滑菜单项 到 相对应的界面启动 的过程

NavigationDraweFragment(侧滑菜单项)
    ###选择一个菜单
       -->通过所选择的菜单 id 在 NavigationDraweFragment 中找到对应的 case ，
       --> 在 SimpleBackePage 中找到对的页面数据
       -->借助 UIHelper.showSimpleBack 启动 SimpleBackActivity.class,并传递该 Fragment 对应的编号。
       -->SimpleBackActivity 根据传递过来的编号，载入对应的Fragment 以及相关数据

20161.22 23:33
