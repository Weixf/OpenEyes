package zjhl.wxf.openeyes.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Weixf
 * Date on 2017/3/2.
 * Describe SharePrefernce的工具
 */

public class SharePreferenceUtil {
    /**
     * 得到布尔类型的Sp 的值
     *
     * @param context
     * @param name
     * @param key
     * @return
     */
    public static boolean getBooleanSp(Context context, String name, String key) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getBoolean(key, true);
//        return  true;
    }

    /**
     * 编辑布尔类型的Sp文件
     * @param context
     * @param name
     * @param key
     * @param value
     */
    public static void editBooleanSp(Context context, String name, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }
}
