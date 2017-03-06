package zjhl.wxf.openeyes.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Weixf
 * Date on 2017/3/3.
 * Describe 多布局的adapter
 */

public abstract class MultiAdapter<T> extends RecyclerView.Adapter<SuperViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<T> mlist = new ArrayList<>();
    private HashMap<Integer, Integer> layoutMap = new HashMap<>();

    public MultiAdapter(Context context, int[] layoutId) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        for (int i = 0; i < layoutId.length; i++) {
            layoutMap.put(i, layoutId[i]);
        }
    }

    @Override
    public SuperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SuperViewHolder(inflater.inflate(layoutMap.get(viewType), parent, false));
    }

    @Override
    public void onBindViewHolder(SuperViewHolder holder, int position) {
        bindData(context, holder, mlist.get(position), bindLayout(mlist.get(position), position), position);
    }

    @Override
    public int getItemViewType(int position) {
        int layoutId = bindLayout(mlist.get(position), position);
        return getViewType(layoutId);
    }

    /**
     * 根据layout获取ViewType
     *
     * @param layoutId
     * @return
     */
    private int getViewType(int layoutId) {
        for (Object o : layoutMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Integer key = (Integer) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (val == layoutId) {
                return key;
            }
        }
        return 0;
    }

    /**
     * 设置数据源  并刷新适配器
     *
     * @param list
     */
    public void setData(List<T> list) {
        this.mlist = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
    //绑定数据源
    public abstract void bindData(Context context, SuperViewHolder holder, T t, int layout, int position);

    //获取每个item的ViewTyoe
    public abstract int bindLayout(T t, int position);
}
