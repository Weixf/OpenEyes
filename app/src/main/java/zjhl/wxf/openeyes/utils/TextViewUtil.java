package zjhl.wxf.openeyes.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by Weixf
 * Date on 2017/3/2.
 * Describe TextView操作工具类
 */

public class TextViewUtil {
    /**
     * 设置文字显示样式
     * "fonts/Lobster-1.4.otf"
     */

    public static void setTypeFace(Context context, TextView v, String s){
        Typeface fromAsset = Typeface.createFromAsset(context.getAssets(), s);
        v.setTypeface(fromAsset);
    }
}
