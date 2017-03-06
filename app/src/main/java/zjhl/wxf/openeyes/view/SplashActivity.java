package zjhl.wxf.openeyes.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.trello.rxlifecycle.ActivityEvent;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import zjhl.wxf.openeyes.Constant;
import zjhl.wxf.openeyes.R;
import zjhl.wxf.openeyes.base.BaseActivity;
import zjhl.wxf.openeyes.utils.AnimationUtil;
import zjhl.wxf.openeyes.utils.DateUtil;
import zjhl.wxf.openeyes.utils.SharePreferenceUtil;
import zjhl.wxf.openeyes.utils.TextViewUtil;

/**
 * Create by Weixf
 * Date on 2017/2/28
 * Describe 欢迎界面,完全仿照开眼做的
 */
public class SplashActivity extends BaseActivity {
    private static final String TAG = "SplashActivity";
    private final int duration = 2000;
    private final int upDistinct=-400;
    @BindView(R.id.splash_black_out_eyes)
    ImageView splashBlackOutEyes;
    @BindView(R.id.splash_black_in_eyes)
    ImageView splashBlackInEyes;
    @BindView(R.id.splay_for_today)
    TextView splayForToday;
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
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        bind = ButterKnife.bind(this);
        initView();
    }

    /**
     * 判断是否是第一次登录，是的话跳转到GuideActivity界面，否的话跳转到MainActivity
     */
    private void judgeIfFirstIn() {
        if (SharePreferenceUtil.getBooleanSp(this, Constant.loginSpName,Constant.loginSpKey)){
            startActivity(new Intent(SplashActivity.this,GuideActivity.class));
        }else {
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
        }

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
        initAnimation();
    }

    /**
     *控件的动画效果
     */
    private void initAnimation() {
        Observable.timer(2,TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .flatMap(new Func1<Object, Observable<?>>() {
                    @Override
                    public Observable<?> call(Object o) {
                        //图片上升，白色眼图片消失，黑色眼图片显示
                        AnimationUtil.obTranslateY(splashBlackOutEyes,duration,0,upDistinct).start();
                        AnimationUtil.obTranslateY(splashBlackInEyes,duration,0,upDistinct).start();
                        AnimationUtil.obTranslateAndAlpha(splashEyes, duration, 0, upDistinct, 1, 0).start();
                        AnimationUtil.obAlpha(splashBlackOutEyes, duration, 0, 1).start();
                        AnimationUtil.obAlpha(splashBlackInEyes,duration,0,1).start();
                        //英文上升并且变黑
                        AnimationUtil.obTranslateAndChangeColor(splashOpenEyeEnglish, duration, 0, upDistinct, Color.WHITE, Color.BLACK).start();
                        AnimationUtil.obTranslateY(splayForToday,duration,0,upDistinct).start();
                        //中文消失
                        AnimationUtil.obAlpha(splashOpenEyeChinese, duration, 1, 0).start();
                        AnimationUtil.obAlpha(splashTextBottomEnglish, duration, 1, 0).start();
                        AnimationUtil.obAlpha(splashTextBottom, duration, 1, 0).start();
                        //背景消失
                        AnimationUtil.obAlpha(splashBackGround, duration, 1, 0).start();
                        return Observable.timer(2,TimeUnit.SECONDS);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<Object, Observable<?>>() {
                    @Override
                    public Observable<?> call(Object o) {
                        AnimationUtil.obAlpha(splayForToday,duration,0,1).start();
                        //日期和今日精选显示
                        splashTextBottomEnglish.setText("-"+DateUtil.getTimeString(DateUtil.MONTH_DAY)+"-");
                        splashTextBottomEnglish.setTextColor(Color.BLACK);
                        splashTextBottom.setText("今日精彩 >>>");
                        splashTextBottom.setTextColor(Color.BLACK);
                        AnimationUtil.obAlpha(splashTextBottomEnglish,duration,0,1).start();
                        AnimationUtil.obAlpha(splashTextBottom,duration,0,1).start();
                        //眼睛里面的月亮旋转
                        AnimationUtil.obRotate(splashBlackInEyes,duration,0,360).start();
                        return Observable.timer(2,TimeUnit.SECONDS);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//不加这句报错
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        //判断是否是首次登录
                        judgeIfFirstIn();
                        finish();
                    }
                });
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
        TextViewUtil.setTypeFace(this,splashOpenEyeEnglish,"fonts/Lobster-1.4.otf" );
        TextViewUtil.setTypeFace(this,splashTextBottomEnglish,"fonts/Lobster-1.4.otf" );
        TextViewUtil.setTypeFace(this,splayForToday,"fonts/Lobster-1.4.otf" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
