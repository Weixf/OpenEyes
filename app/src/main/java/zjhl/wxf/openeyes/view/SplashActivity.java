package zjhl.wxf.openeyes.view;

import android.animation.AnimatorSet;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import zjhl.wxf.openeyes.R;
import zjhl.wxf.openeyes.base.BaseActivity;
import zjhl.wxf.openeyes.utils.AnimationUtil;

/**
 * Create by Weixf
 * Date on 2017/2/28
 * Describe 欢迎界面
 */
public class SplashActivity extends BaseActivity {
    private static final String TAG = "SplashActivity";
    private final int SPLASH_INTENT_TIME = 3000;
    private final int duration = 2000;
    private int x;
    private int y;

    @BindView(R.id.splash_eyes)
    ImageView splashEyes;
    @BindView(R.id.splash_open_eye_english)
    TextView splashOpenEyeEnglish;
    @BindView(R.id.splash_open_eye_chinese)
    TextView splashOpenEyeChinese;
    @BindView(R.id.splash_text_bottom_english)
    TextView splashTextBottomEnglish;
    @BindView(R.id.splash_text_bottom)
    TextView splashTextBottom;
    @BindView(R.id.activity_splash)
    RelativeLayout activitySplash;
    @BindView(R.id.splash_back_ground)
    ImageView splashBackGround;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 对控件进行一系列操作
     */
    private void initView() {
        initText();
        initPic();
        /**
         * 三秒后背景消失，最上边的眼睛和英文上升，所有汉字消失，接着“for day 和日期显示”，最后跳转
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //图片上升而且消失
                AnimationUtil.obTranslateAndAlpha(splashEyes, duration,0,-400,1,0).start();
                //英文上升并且变黑
                AnimationUtil.obTranslateAndChangeColor(splashOpenEyeEnglish,duration,0,-400,Color.WHITE,Color.BLACK).start();
                //中文消失
                AnimationUtil.obAlpha(splashOpenEyeChinese,duration,1,0).start();
                AnimationUtil.obAlpha(splashTextBottomEnglish,duration,1,0).start();
                AnimationUtil.obAlpha(splashTextBottom,duration,1,0).start();
                //背景消失
                AnimationUtil.obAlpha(splashBackGround,duration,1,0).start();
                //
                TextView textView=new TextView(SplashActivity.this);
                textView.setText("fdas");
            }
        }, SPLASH_INTENT_TIME);
    }

    /**
     * 设置图片动画
     */
    private void initPic() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.background_larger);
        splashBackGround.startAnimation(animation);
    }

    /**
     * 设置字体格式
     */
    private void initText() {
        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Lobster-1.4.otf");
        splashOpenEyeEnglish.setTypeface(typeface);
        splashTextBottomEnglish.setTypeface(typeface);
    }
}
