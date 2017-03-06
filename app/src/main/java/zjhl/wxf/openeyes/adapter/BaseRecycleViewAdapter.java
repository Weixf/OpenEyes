//package zjhl.wxf.openeyes.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Weixf
// * Date on 2017/3/3.
// * Describe 万能的recycleView适配器
// */
//
//public abstract class BaseRecycleViewAdapter<T> extends RecyclerView.Adapter<SuperViewHolder>{
//    protected final List<T> mData;
//    protected final Context mContext;
//    protected LayoutInflater mInflater;
//    private OnItemClickListener mClickListener;
//    private OnItemLongClickListener mLongClickListener;
//
//    public BaseRecycleViewAdapter(Context ctx, List<T> list) {
//        mData = (list != null) ? list : new ArrayList<T>();
//        mContext = ctx;
//        mInflater = LayoutInflater.from(ctx);
//    }
//
//    @Override
//    public SuperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        final SuperViewHolder holder = new SuperViewHolder(mContext, mInflater.inflate(getItemLayoutId(viewType), parent, false));
//        if (mClickListener != null) {
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
//                }
//            });
//        }
//        if (mLongClickListener != null) {
//            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    mLongClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
//                    return true;
//                }
//            });
//        }
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(SuperViewHolder holder, int position) {
//        bindData(holder, position, mData.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mData.size();
//    }
//
//    public void add(int pos, T item) {
//        mData.add(pos, item);
//        notifyItemInserted(pos);
//    }
//
//    public void delete(int pos) {
//        mData.remove(pos);
//        notifyItemRemoved(pos);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        mClickListener = listener;
//    }
//
//    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
//        mLongClickListener = listener;
//    }
//
//    abstract public int getItemLayoutId(int viewType);
//
//    abstract public void bindData(SuperViewHolder holder, int position, T item);
//
//    public interface OnItemClickListener {
//        public void onItemClick(View itemView, int pos);
//    }
//
//    public interface OnItemLongClickListener {
//        public void onItemLongClick(View itemView, int pos);
//    }
//}
