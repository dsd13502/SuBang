package net.oschina.app.viewpagerfragment;

import net.oschina.app.R;
import net.oschina.app.adapter.ViewPageFragmentAdapter;
import net.oschina.app.base.BaseListFragment;
import net.oschina.app.base.BaseViewPagerFragment;
import net.oschina.app.bean.Post;
import net.oschina.app.fragment.PostsFragment;
import android.os.Bundle;
import android.view.View;

/**
 * 你问我帮页面（技术提问页面）
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年9月25日 下午2:21:52
 *
 */
public class QuestViewPagerFragment extends BaseViewPagerFragment {

	@Override
	protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
	   //导航标题栏 的文字来自 数组
		String[] title = getResources().getStringArray(R.array.quests_viewpage_arrays);
		//getBundle(Post.CATALOG_ASK) 对应的位置？？
		adapter.addTab(title[0], "quest_ask", PostsFragment.class, getBundle(Post.CATALOG_ASK));
		adapter.addTab(title[1], "quest_share", PostsFragment.class, getBundle(Post.CATALOG_SHARE));
		adapter.addTab(title[2], "quest_multiple", PostsFragment.class, getBundle(Post.CATALOG_OTHER));
		adapter.addTab(title[3], "quest_occupation", PostsFragment.class, getBundle(Post.CATALOG_JOB));
		adapter.addTab(title[4], "quest_station", PostsFragment.class, getBundle(Post.CATALOG_SITE));
	}
	
	private Bundle getBundle(int catalog) {
		Bundle bundle = new Bundle();
		bundle.putInt(BaseListFragment.BUNDLE_KEY_CATALOG, catalog);
		return bundle;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initView(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}
}
