#   【net .oscchina.app 文件说明】 #
## ui 目录 -->
    * NavigationDrawerFragment --> 侧滑侧滑菜单界面
       |___ UIHelper :界面帮助类（位于：/util/ 详细见 /util/README_FOR_UTIL）
            |___

## viewpagefragment 目录 --> 存放与导航栏相对应的fragment或者
    *
## widget 目录 -- >自行定义的控件


2016.1.16 0:42

从 选择侧滑菜单项 到 相对应的界面启动 的过程

NavigationDraweFragment(侧滑菜单项)
    ###选择一个菜单
       -->通过所选择的菜单 id 在 NavigationDraweFragment 中找到对应的 case ，
       --> 在 SimpleBackePage 中找到对的页面数据
       -->借助 UIHelper.showSimpleBack 启动 SimpleBackActivity.class,并传递该 Fragment 对应的编号。
       -->SimpleBackActivity 根据传递过来的编号，载入对应的Fragment 以及相关数据

20161.22 23:33
