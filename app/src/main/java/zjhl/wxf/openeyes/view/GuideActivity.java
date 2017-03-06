package zjhl.wxf.openeyes.view;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zjhl.wxf.openeyes.Constant;
import zjhl.wxf.openeyes.R;
import zjhl.wxf.openeyes.adapter.MyFragmentPagerAdapter;
import zjhl.wxf.openeyes.base.BaseActivity;
import zjhl.wxf.openeyes.fragment.GuideFragment;
import zjhl.wxf.openeyes.utils.SharePreferenceUtil;
import zjhl.wxf.openeyes.utils.TextViewUtil;

/**
 * Create by Weixf
 * Date on 2017/3/2
 * Desrcibe 欢迎界面后跳转的引导界面
 */
public class GuideActivity extends BaseActivity  {
    private static final String TAG = "GuideActivity";
    @BindView(R.id.guide_up)
    ImageView guideUp;
    private List<Fragment> fragments;
    @BindView(R.id.guide_video)
    VideoView guideVideo;
    @BindView(R.id.activity_guide)
    RelativeLayout activityGuide;
    @BindView(R.id.guide_viewpager)
    ViewPager guideViewpager;
    @BindView(R.id.guide_text)
    TextView guideText;
    private MyFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        //对控件进行一系列操作
        initView();
    }

    private void initView() {
        initVideoView();
        //设置文字显示样式
        TextViewUtil.setTypeFace(this, guideText, "fonts/Lobster-1.4.otf");
        initFragment();
        initViewPager();
        initPic();
        SharePreferenceUtil.editBooleanSp(this, Constant.loginSpName,Constant.loginSpKey,false);
    }

    /**
     * 点击图片跳转
     */
    private void initPic() {
        guideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
            }
        });
    }

    /**
     * 对ViewPager进行一系列的操作
     */
    private void initViewPager() {
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        guideViewpager.setAdapter(adapter);
    }

    /**
     * 对fragment进行一系列的操作
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        GuideFragment fragment1 = GuideFragment.newInstance(getString(R.string.guide_fragment_one));
        GuideFragment fragment2 = GuideFragment.newInstance(getString(R.string.guide_fragment_two));
        GuideFragment fragment3 = GuideFragment.newInstance(getString(R.string.guide_fragment_three));
        GuideFragment fragment4 = GuideFragment.newInstance(getString(R.string.guide_fragment_four));
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);
    }

    /**
     * VideoView播放视频
     */
    private void initVideoView() {
        guideVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.landing));
        guideVideo.start();
        //设置循环播放
        guideVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });
    }
}
