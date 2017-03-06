package zjhl.wxf.openeyes.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.trello.rxlifecycle.FragmentEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import zjhl.wxf.openeyes.R;
import zjhl.wxf.openeyes.adapter.DataHolder;
import zjhl.wxf.openeyes.adapter.LayoutWrapper;
import zjhl.wxf.openeyes.adapter.SuperAdapter;
import zjhl.wxf.openeyes.adapter.SuperViewHolder;
import zjhl.wxf.openeyes.api.RetrofitUtil;
import zjhl.wxf.openeyes.base.BaseFragment;
import zjhl.wxf.openeyes.bean.ChoicenessBean;
import zjhl.wxf.openeyes.bean.ChoicenessTextFooterBean;
import zjhl.wxf.openeyes.bean.ChoicenessVideoBean;
import zjhl.wxf.openeyes.utils.DateUtil;

/**
 * Create by Weixf
 * Date on 2017/3/3
 * Decribe 精选界面的fragment
 */
public class ChoicenessFragment extends BaseFragment {
    private static final String TAG = "ChoicenessFragment";
    private View view;
    @BindView(R.id.fragment_choiceness_search)
    ImageView search;
    @BindView(R.id.fragment_choiceness_recycleView)
    RecyclerView recycleView;

    public ChoicenessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_choiceness, container, false);
        ButterKnife.bind(this, view);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        int[] layoutId = {R.layout.item_choiceness_video};
        final SuperAdapter adapter = new SuperAdapter(getContext(), layoutId);
        recycleView.setAdapter(adapter);
        final DataHolder<ChoicenessVideoBean> videoBean = new DataHolder<ChoicenessVideoBean>() {
            @Override
            public void bind(Context context, SuperViewHolder holder, ChoicenessVideoBean item, int position) {
//                ImageView image=holder.getView(R.id.choiceness_video_background);
                TextView text = holder.getView(R.id.choiceness_video_type);
                text.setText(item.getType());
            }
        };
        final DataHolder<ChoicenessTextFooterBean> footBean = new DataHolder<ChoicenessTextFooterBean>() {
            @Override
            public void bind(Context context, SuperViewHolder holder, ChoicenessTextFooterBean item, int position) {
//                ImageView image=holder.getView(R.id.choiceness_video_background);
                TextView text = holder.getView(R.id.choiceness_textfoot_title);
                text.setText(item.getType());
            }
        };
//        final MultiAdapter<ChoicenessBean> adapter = new MultiAdapter<ChoicenessBean>(getContext(),layoutId) {
//            @Override
//            public void bindData(Context context, SuperViewHolder holder, ChoicenessBean bean, int layout, int position) {
//                switch (layout){
//                    case R.layout.item_choiceness_textfoot:
//                        break;
//                    case R.layout.item_choiceness_video:
//                        break;
//                }
//            }
//
//            @Override
//            public int bindLayout(ChoicenessBean bean, int position) {
//                if (bean.getItemList().get(position) instanceof ChoicenessVideoBean) {
//                    return R.layout.item_choiceness_video;
//                } else return R.layout.item_choiceness_textfoot;
//            }
//        };
        RetrofitUtil.getApiServer().getChoicenessData(DateUtil.getTimeNum(), 2, 0)
                .compose(this.<ChoicenessBean>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ChoicenessBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(ChoicenessBean baseBean) {
                        List<LayoutWrapper> date = new ArrayList<>();
                        Log.e(TAG, "onNext: " + baseBean.getItemList().size());
                        for (int i = 0; i < baseBean.getItemList().size(); i++) {
                            if (baseBean.getItemList().get(i) instanceof ChoicenessVideoBean) {
//                                date.add(new LayoutWrapper(R.layout.item_choiceness_video, baseBean.getItemList().get(i), videoBean));
                                Log.e(TAG, "onNext: 1");
                            }
//                            } else if (baseBean.getItemList().get(i)) {
//                                Log.e(TAG, "onNext: 2" );
////                                date.add(new LayoutWrapper(R.layout.item_choiceness_video, baseBean.getItemList().get(i), footBean));
//                            }
                        }
                        adapter.setData(date);
                    }
                });
        return view;
    }

    @OnClick(R.id.fragment_choiceness_search)
    public void onClick() {
        Toast.makeText(getContext(), "搜索", Toast.LENGTH_SHORT).show();
    }
}
