package zjhl.wxf.openeyes.adapter;

import android.content.Context;

/**
 * Created by Weixf
 * Date on 2017/3/6.
 * Describe
 * 数据控制器
 * 将ItemData和ViewHolder进行绑定，并设置监听
 */
public interface DataHolder<T> {
    void bind(Context context, SuperViewHolder holder, T item, int position);
}
