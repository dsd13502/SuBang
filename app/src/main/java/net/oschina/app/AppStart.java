package net.oschina.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import net.oschina.app.ui.MainActivity;
import net.oschina.app.util.TDevice;

import org.kymjs.kjframe.http.KJAsyncTask;
import org.kymjs.kjframe.utils.FileUtils;
import org.kymjs.kjframe.utils.PreferenceHelper;

import java.io.File;

/**
 * 应用启动界面
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @created 2014年12月22日 上午11:51:56
 * 
 */
public class AppStart extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 防止第三方跳转时出现双实例--->从其他软件中启动本项目时防止双实例。
        Activity aty = AppManager.getActivity(MainActivity.class);//AppManager 
                                             //用来帮忙管理activity的finish和start的栈。
        if (aty != null && !aty.isFinishing()) { 
            finish();//如果MainActivity存在并且还没有结束，就结束他
        }
        // SystemTool.gc(this); //针对性能好的手机使用，加快应用相应速度

        final View view = View.inflate(this, R.layout.app_start, null);
        setContentView(view); 
        // 渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.5f, 1.0f); //AlphaAnimation （阿尔法）淡入淡出动画，就是渐变动画
        aa.setDuration(800);//动画保持时间。。。。
        view.startAnimation(aa);
        aa.setAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationEnd(Animation arg0) {
                redirectTo();//当动画结束
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationStart(Animation animation) {}
        });
    }

    @Override
    protected void onResume() { //从后台调入前台的入口，常常用来刷新数据
        super.onResume();

        int cacheVersion = PreferenceHelper.readInt(this, "first_install", //PreferenceHelper首选项
                "first_install", -1);
        int currentVersion = TDevice.getVersionCode();
        if (cacheVersion < currentVersion) {
            PreferenceHelper.write(this, "first_install", "first_install",
                    currentVersion);
            cleanImageCache();
        }
    }

    /**
    *清处图片缓存
    **/
    private void cleanImageCache() {
        final File folder = FileUtils.getSaveFolder("OSChina/imagecache");
        KJAsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                for (File file : folder.listFiles()) {
                    file.delete();
                }
            }
        });
    }

    /**
     * 跳转到...
     */
    private void redirectTo() {
        Intent uploadLog = new Intent(this, LogUploadService.class);//LogUploadService 载入注册服务
        startService(uploadLog); //启动登陆服务
        Intent intent = new Intent(this, MainActivity.class);//启动主页面
        startActivity(intent);
        finish();
    }
}
