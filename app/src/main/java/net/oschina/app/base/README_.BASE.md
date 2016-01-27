# **base**
将系统提供的类进行【重写并扩充】，形成以后重复使用的【基本类】
## BaseFragment --> extends Fragment
## BaseListFragment --> extends BaseFragment
1.刷新列表功能
## BaseViewPagerFragment --> extends BaseFragment

## listBaseAdapter --> extends BaseAdapter
　　 **实现下拉刷新功能**

* notifyDataSetChanged();在修改适配器绑定的数组后，不用重新刷新Activity，通知Activity更新ListView
