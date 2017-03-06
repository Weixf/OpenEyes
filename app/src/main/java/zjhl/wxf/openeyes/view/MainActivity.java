package zjhl.wxf.openeyes.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zjhl.wxf.openeyes.R;
import zjhl.wxf.openeyes.adapter.MyFragmentPagerAdapter;
import zjhl.wxf.openeyes.base.BaseActivity;
import zjhl.wxf.openeyes.fragment.AttentionFragment;
import zjhl.wxf.openeyes.fragment.ChoicenessFragment;
import zjhl.wxf.openeyes.fragment.DiscoverFragment;
import zjhl.wxf.openeyes.fragment.MyFragment;

/**
 * Create by Weixf
 * Date on 2017/3/3
 * Describe MainActivity界面
 */
public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {
    private static final String TAG = "MainActivity";
    private List<Fragment> mList;
    @BindView(R.id.main_viewpager)
    ViewPager mainViewpager;
    @BindView(R.id.main_button_choiceness)
    RadioButton mainButtonChoiceness;
    @BindView(R.id.main_button_discover)
    RadioButton mainButtonDiscover;
    @BindView(R.id.main_button_attention)
    RadioButton mainButtonAttention;
    @BindView(R.id.main_button_my)
    RadioButton mainButtonMy;
    @BindView(R.id.main_radiogroup)
    RadioGroup mainRadiogroup;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }


    /**
     * 对viewpager  radiogroup 和fragment进行一系列操作
     */
    private void initView() {
        initfragment();
        ininViewPager();
        initRadioGroup();
    }

    /**
     * RadioGroup设置与Viewpager联动
     */
    private void initRadioGroup() {
        mainRadiogroup.check(R.id.main_button_choiceness);
        mainRadiogroup.setOnCheckedChangeListener(this);
    }

    /**
     * 对ViewPager进行操作
     */
    private void ininViewPager() {
        //设置适配器
        mainViewpager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), mList));
        //设置默认第一个界面
        mainViewpager.setCurrentItem(0);
        mainViewpager.addOnPageChangeListener(this);
    }

    /**
     * 创建fragment集合
     */
    private void initfragment() {
        mList = new ArrayList<>();
        ChoicenessFragment cFragment = new ChoicenessFragment();
        DiscoverFragment dFragment = new DiscoverFragment();
        AttentionFragment aFragment = new AttentionFragment();
        MyFragment mFragment = new MyFragment();
        mList.add(cFragment);
        mList.add(dFragment);
        mList.add(aFragment);
        mList.add(mFragment);
    }

    /**
     * Viewpager滑动监听
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mainRadiogroup.check(R.id.main_button_choiceness);
                break;
            case 1:
                mainRadiogroup.check(R.id.main_button_discover);
                break;
            case 2:
                mainRadiogroup.check(R.id.main_button_attention);
                break;
            case 3:
                mainRadiogroup.check(R.id.main_button_my);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * RadioGroup 监听
     *
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_button_choiceness:
                mainViewpager.setCurrentItem(0);
                break;
            case R.id.main_button_discover:
                mainViewpager.setCurrentItem(1);
                break;
            case R.id.main_button_attention:
                mainViewpager.setCurrentItem(2);
                break;
            case R.id.main_button_my:
                mainViewpager.setCurrentItem(3);
                break;
        }
    }
}
