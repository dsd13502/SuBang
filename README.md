# 速帮 Android [客户端](http://www.oschina.net/app/)

##写在前面的话
本项目是基与开源中国 Android 客户端搭建的，主要用于自我学习。发现了我在知识上有很多不足之处，还是要好好学习滴。

##项目简述
1. 底部导航  
    * 主界面的底部TAB导航采用
    [FragmentTabHost](http://git.oschina.net/oschina/osc-android-app/blob/master/osc-android-app/src/net/oschina/app/ui/MainTab.java)点击底部按钮时切换Fragment。中间的快捷操作按钮使用的是[自定义dialog](http://git.oschina.net/oschina/osc-android-app/blob/master/osc-android-app/src/net/oschina/app/ui/QuickOptionDialog.java)，通过点击时加入动画效果实现。
2. 一级界面  
    * 包括资讯、动弹两个模块，采用[ViewPagerFragment](http://git.oschina.net/oschina/osc-android-app/blob/master/osc-android-app/src/net/oschina/app/viewpagerfragment/NewsViewPagerFragment.java)根据滑动到不同页面显示不同信息。  
3. 详情界面  
    * 详情界面包括[博客详情](http://git.oschina.net/oschina/osc-android-app/blob/master/osc-android-app/src/net/oschina/app/fragment/BlogDetailFragment.java)，[动弹详情](http://git.oschina.net/oschina/osc-android-app/blob/master/osc-android-app/src/net/oschina/app/fragment/TweetDetailFragment.java)，[新闻详情](http://git.oschina.net/oschina/osc-android-app/blob/master/osc-android-app/src/net/oschina/app/fragment/NewsDetailFragment.java)，[帖子详情](http://git.oschina.net/oschina/osc-android-app/blob/master/osc-android-app/src/net/oschina/app/fragment/PostDetailFragment.java)， [活动详情](http://git.oschina.net/oschina/osc-android-app/blob/master/osc-android-app/src/net/oschina/app/fragment/EventDetailFragment.java)等……是通过在Fragment中的WebView直接loadData()加载一段html数据并显示。  
    * 而详情Fragment的显示则是通过一个外部DetailActivity，来根据传入的参数不同来加载不同的Fragment。  
4. 链接跳转  
    * 整个应用打开链接的规则都定义在UIHelper.openBrowser()方法中，本方法会根据不同的url去解析，如果是www.oschina.net的链接，则会调用相应的界面去展示；如果是git.oschina.net我们目前会使用手机自带的浏览器打开(之后会改为使用[OscGit客户端](http://git.oschina.net/oschina/git-osc-android-project)打开)；如果不是oschina的站内链接，则使用内置浏览器打开。  
5. 侧滑菜单  
    * [侧滑菜单](http://git.oschina.net/oschina/osc-android-app/blob/master/osc-android-app/src/net/oschina/app/ui/NavigationDrawerFragment.java)采用系统的DrawerLayout实现。关于很多朋友好奇的左上角箭头，是采用的开源控件[DrawerArrowDrawable](http://git.oschina.net/oschina/osc-android-app/blob/master/osc-android-app/src/net/oschina/app/widget/DrawerArrowDrawable.java)(准确的说不应该是控件而是一个Drawable)

##依赖包介绍
1. jar包依赖  
  * 网络请求库 **android-async-http** http://loopj.com/android-async-http 
  * 注解绑定控件 **butterknife** http://jakewharton.github.io/butterknife/  
  * 网络图片加载库 **KJFrameForAndroid** http://git.oschina.net/kymjs/KJFrameForAndroid  
  * XML解析库 **xstream** http://xstream.codehaus.org/  
2. 源码依赖  
  * **PhotoView-library** ：用于图片预览界面展示 
  * **UmengShareLib** ：用于分享到第三方平台
  
## 各文件夹介绍


klin Street, Fifth Floor, Boston, MA 02110-1301 USA.