# **base**
将系统提供的类进行【重写并扩充】，形成以后重复使用的【基本类】
## BaseFragment --> extends Fragment
## BaseListFragment --> extends BaseFragment
####实现以下功能
* 上拉刷新列表功能，将刷新的数据缓存起来，
* 有几个刷新几个
* 上滑不刷新
* 下拉从缓存中读取
* 回馈操作状态  

####继承他的类所需的数据，还要继承类自行实现加载
## BaseViewPagerFragment --> extends BaseFragment

## listBaseAdapter --> extends BaseAdapter
　　 **实现下拉刷新功能**

* notifyDataSetChanged();在修改适配器绑定的数组后，不用重新刷新Activity，通知Activity更新ListView
