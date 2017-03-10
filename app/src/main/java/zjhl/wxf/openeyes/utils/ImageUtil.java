package zjhl.wxf.openeyes.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import zjhl.wxf.openeyes.widget.CircleTransform;
import zjhl.wxf.openeyes.widget.CornersTransform;

/**
 * Created by Weixf
 * Date on 2017/3/7.
 * Describe 使用glide加载图片
 */

public class ImageUtil {
    public static void loadImage(Context context, String url,ImageView view){
        Glide.with(context).load(url).into(view);
    }
    /**
     * 加载圆形图片
     */
    public static  void loadCircleImage(Context context,String url,ImageView image){
        Glide.with(context).load(url)
                .transform(new CircleTransform(context))
                .crossFade()
                .into(image);
    }
    /**
     * 加载圆形图片
     */
    public static  void loadCornerImage(Context context,String url,ImageView image){
        Glide.with(context).load(url)
                .transform(new CornersTransform(context))
                .crossFade()
                .into(image);
    }
}
