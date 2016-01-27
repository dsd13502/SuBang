package net.oschina.app.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import net.oschina.app.adapter.BlogAdapter;
import net.oschina.app.api.remote.OSChinaApi;
import net.oschina.app.base.BaseListFragment;
import net.oschina.app.bean.Blog;
import net.oschina.app.bean.BlogList;
import net.oschina.app.interf.OnTabReselectListener;
import net.oschina.app.util.UIHelper;
import net.oschina.app.util.XmlUtils;

import java.io.InputStream;
import java.io.Serializable;

/**
 * 博客区中单一模块的展示
 * 
 * @author kymjs(kymjs123@gmail.com)
 */
public class BlogFragment extends BaseListFragment<Blog> implements
        OnTabReselectListener {

    public static final String BUNDLE_BLOG_TYPE = "BUNDLE_BLOG_TYPE";
    //得到类的简写名称
    protected static final String TAG = BlogFragment.class.getSimpleName();
    private static final String CACHE_KEY_PREFIX = "bloglist_";

    private String blogType;

    @Override
    protected BlogAdapter getListAdapter() {
        return new BlogAdapter();
    }

    /**
     * 有Fragment传递 BUNDLE_BLOG_TYPE 这个Argument 过来，但是谁给的呢？
     * 不是在另一个Top中的 自己
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            blogType = args.getString(BUNDLE_BLOG_TYPE);
        }
    }

    /**
     * 获取当前展示页面的缓存数据
     */
    @Override
    protected String getCacheKeyPrefix() {
        return CACHE_KEY_PREFIX + blogType;
    }

    /**
     * im_dsd
     * 刷新博客列表
     * @param is
     * @return
     * @throws Exception
     */
    @Override
    protected BlogList parseList(InputStream is) throws Exception {
        BlogList list = XmlUtils.toBean(BlogList.class, is);
        return list;
    }

    /**
     * im_dsd
     * 返回序列化对象
     */
    @Override
    protected BlogList readList(Serializable seri) {
        return ((BlogList) seri);
    }

    /**
     * im_dsd
     * 发送数据请求，结果存在 mHandler 中
     * blogType：
     * mCurrentPage：
     * mHandler ：
     */
    @Override
    protected void sendRequestData() {
        OSChinaApi.getBlogList(blogType, mCurrentPage, mHandler);
    }

    /**
     * im_dsd
     * 当 itme 被点击时，借助UIhelper跳转到对应的详情Activity
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
        Blog blog = mAdapter.getItem(position);
        if (blog != null) {
            UIHelper.showBlogDetail(getActivity(), blog.getId(),
                    blog.getCommentCount());
            // 保存到已读列表
            saveToReadedList(view, BlogList.PREF_READED_BLOG_LIST, blog.getId()
                    + "");
        }
    }

    /**
     * im_dsd
     * 当Tab被重新选中时需要刷新
     */
    @Override
    public void onTabReselect() {
        onRefresh();
    }


    /**
     * im_dsd
     *自动刷新时间
     */
    @Override
    protected long getAutoRefreshTime() {
        // TODO Auto-generated method stub
        // 最新博客
        if (blogType.equals(BlogList.CATALOG_LATEST)) {
            return 2 * 60 * 60;
        }
        return super.getAutoRefreshTime();
    }
}
