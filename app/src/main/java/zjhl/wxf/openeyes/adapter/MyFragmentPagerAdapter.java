package zjhl.wxf.openeyes.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;


/**
 * Created by Weixf
 * Date on 2017/3/2.
 * Describe  引导界面的ViewPager使用的fragment
 */

public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mlist;

    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        mlist = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

}
