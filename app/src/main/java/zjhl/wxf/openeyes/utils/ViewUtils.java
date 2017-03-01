package zjhl.wxf.openeyes.utils;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Weixf
 * Date on 2017/2/28.
 * Describe 控件工具类
 */

public class ViewUtils {
    /**
     * 得到控件在屏幕的坐标
     * @param view
     * @return
     */
    public static int []getViewXAndY(View view){
        int []location=new int[2];
        view.getLocationOnScreen(location);
        return location;
    }

    /**
     * 获取屏幕的宽
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context){
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    /**
     * 获取屏幕的高
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context){
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }



}
