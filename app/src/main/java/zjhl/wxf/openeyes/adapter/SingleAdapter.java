package zjhl.wxf.openeyes.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weixf
 * Date on 2017/3/3.
 * Describe 单布局万能的Adapter
 */

public abstract class SingleAdapter<T> extends RecyclerView.Adapter<SuperViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<T> mlist = new ArrayList<>();
    private int layoutId;

    public SingleAdapter(Context context, int layoutId) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.layoutId = layoutId;
    }

    @Override
    public SuperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SuperViewHolder(inflater.inflate(layoutId, parent, false));
    }

    @Override
    public void onBindViewHolder(SuperViewHolder holder, int position) {
        bindData(holder, mlist.get(position));
    }

    abstract void bindData(SuperViewHolder holder, T t);


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    /**
     * 提供数据源并刷新适配器
     * @param list
     */
    public void setData(List<T> list) {
        this.mlist = list;
        notifyDataSetChanged();
    }
}
