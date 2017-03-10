package zjhl.wxf.openeyes.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.trello.rxlifecycle.FragmentEvent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import zjhl.wxf.openeyes.R;
import zjhl.wxf.openeyes.adapter.DataHolder;
import zjhl.wxf.openeyes.adapter.LayoutWrapper;
import zjhl.wxf.openeyes.adapter.SuperAdapter;
import zjhl.wxf.openeyes.adapter.SuperViewHolder;
import zjhl.wxf.openeyes.api.RetrofitUtil;
import zjhl.wxf.openeyes.base.BaseFragment;
import zjhl.wxf.openeyes.bean.ChoicenessBannerBean;
import zjhl.wxf.openeyes.bean.ChoicenessSquareCardBean;
import zjhl.wxf.openeyes.bean.ChoicenessTextFooterBean;
import zjhl.wxf.openeyes.bean.ChoicenessTextHeaderBean;
import zjhl.wxf.openeyes.bean.ChoicenessVideoBean;
import zjhl.wxf.openeyes.bean.ChoicenessVideoCollectionOfAuthorBean;
import zjhl.wxf.openeyes.bean.ChoicenessVideoCollectionOfFollowBean;
import zjhl.wxf.openeyes.bean.ChoicenessVideoCollectionWithCoverBean;
import zjhl.wxf.openeyes.utils.DateUtil;
import zjhl.wxf.openeyes.utils.GsonUtil;
import zjhl.wxf.openeyes.utils.ImageUtil;
import zjhl.wxf.openeyes.utils.TextViewUtil;

import static zjhl.wxf.openeyes.utils.GsonUtil.fromJson;

/**
 * Create by Weixf
 * Date on 2017/3/3
 * Decribe 精选界面的fragment
 */
public class ChoicenessFragment extends BaseFragment {
    //    @BindView(R.id.fragment_choiceness_search)
//    ImageView search;
    @BindView(R.id.fragment_choiceness_recycleView)
    RecyclerView recycleView;
    private static final String TAG = "ChoicenessFragment";
    private Handler handler = new Handler();
    private boolean isLoadind;
    private int pag = 0;//页码
    private long datenum;//时间戳
    private int number;//数量
    private String url = "";
    private List<LayoutWrapper> data = new ArrayList<>();
    private SuperAdapter adapter;
    private DataHolder<ChoicenessVideoBean> videoBean;
    private DataHolder<ChoicenessTextFooterBean> footBean;
    private DataHolder<ChoicenessVideoCollectionWithCoverBean> collecBean;
    private DataHolder<ChoicenessTextHeaderBean> headBean;
    private DataHolder<ChoicenessVideoCollectionOfFollowBean> followBean;
    private DataHolder<ChoicenessBannerBean> bannerBean;
    private DataHolder<ChoicenessSquareCardBean> squareBean;
    private DataHolder<ChoicenessVideoCollectionOfAuthorBean> authorBean;

    public ChoicenessFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choiceness, container, false);
        ButterKnife.bind(this, view);
        final int[] layoutId = {R.layout.item_choiceness_video,
                R.layout.item_choiceness_textfoot,
                R.layout.item_choiceness_video_collection,
                R.layout.item_choiceness_video_texthead,
                R.layout.item_choiceness_video_author,
                R.layout.item_choiceness_banner,
                R.layout.item_choiceness_square,
                R.layout.item_choiceness_video_collection_of_author};
        adapter = new SuperAdapter(getContext(), layoutId);
        initRecycleView();
        initDataHolder();
        initData(DateUtil.getTimeNum(), 2, pag);//请求数据
        return view;
    }

    /**
     * retrofit请求数据
     */
    private void initData(final long date, final int num, int page) {
        RetrofitUtil.getApiServer().getChoicenessData(date, num, page)
                .compose(this.<JsonObject>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<JsonObject, JSONArray>() {
                    @Override
                    public JSONArray call(JsonObject bean) {
                        JSONArray itemList = null;
                        try {
                            JSONObject json = new JSONObject(bean.toString());
                            itemList = json.getJSONArray("itemList");
                            url = json.optString("nextPageUrl");
                            Log.e(TAG, "call: " + url);
                            //不得不服  这个参数竟然设成"null"  好大的坑
                            if (!url.equals("null")) {
                                datenum = Long.parseLong(url.substring(54, 67));
                                number = Integer.parseInt(url.substring(72, 73));
                                pag = Integer.parseInt(url.substring(79, 80));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return itemList;
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<JSONArray>() {
                    @Override
                    public void call(JSONArray jsonArray) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                switch (jsonObject.getString("type")) {
                                    case "video":
                                        ChoicenessVideoBean item1 = fromJson(jsonObject.toString(), new TypeToken<ChoicenessVideoBean>() {
                                        }.getType());
                                        data.add(new LayoutWrapper(R.layout.item_choiceness_video, item1, videoBean));
                                        break;
                                    case "textFooter":
                                        ChoicenessTextFooterBean item2 = fromJson(jsonObject.toString(), new TypeToken<ChoicenessTextFooterBean>() {
                                        }.getType());
                                        data.add(new LayoutWrapper(R.layout.item_choiceness_textfoot, item2, footBean));
                                        break;
                                    case "videoCollectionWithCover":
                                        ChoicenessVideoCollectionWithCoverBean item3 = GsonUtil.fromJson(jsonObject.toString(), new TypeToken<ChoicenessVideoCollectionWithCoverBean>() {
                                        }.getType());
                                        data.add(new LayoutWrapper(R.layout.item_choiceness_video_collection, item3, collecBean));
                                        break;
                                    case "textHeader":
                                        ChoicenessTextHeaderBean item4 = GsonUtil.fromJson(jsonObject.toString(), new TypeToken<ChoicenessTextHeaderBean>() {
                                        }.getType());
                                        data.add(new LayoutWrapper(R.layout.item_choiceness_video_texthead, item4, headBean));
                                        break;
                                    case "videoCollectionOfFollow":
                                        ChoicenessVideoCollectionOfFollowBean item5 = GsonUtil.fromJson(jsonObject.toString(), new TypeToken<ChoicenessVideoCollectionOfFollowBean>() {
                                        }.getType());
                                        data.add(new LayoutWrapper(R.layout.item_choiceness_video_author, item5, followBean));
                                        break;
                                    case "banner2":
                                        ChoicenessBannerBean item6 = GsonUtil.fromJson(jsonObject.toString(), new TypeToken<ChoicenessBannerBean>() {
                                        }.getType());
                                        data.add(new LayoutWrapper(R.layout.item_choiceness_banner, item6, bannerBean));
                                        break;
                                    case "squareCardCollection":
                                        ChoicenessSquareCardBean item7 = GsonUtil.fromJson(jsonObject.toString(), new TypeToken<ChoicenessSquareCardBean>() {
                                        }.getType());
                                        data.add(new LayoutWrapper(R.layout.item_choiceness_square, item7, squareBean));
                                        break;
                                    case "videoCollectionOfAuthorWithCover":
                                        ChoicenessVideoCollectionOfAuthorBean item8 = GsonUtil.fromJson(jsonObject.toString(), new TypeToken<ChoicenessVideoCollectionOfAuthorBean>() {
                                        }.getType());
                                        data.add(new LayoutWrapper(R.layout.item_choiceness_video_collection_of_author,item8,authorBean));
                                        break;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.setData(data);
                    }
                });
    }

    /**
     * ItemData和ViewHolder进行绑定，并设置监听
     */
    private void initDataHolder() {
        /**
         * type为Video的item
         */
        videoBean = new DataHolder<ChoicenessVideoBean>() {
            @Override
            public void bind(Context context, SuperViewHolder holder, ChoicenessVideoBean item, int position) {
                ImageView image = holder.getView(R.id.choiceness_video_background);
                TextView type = holder.getView(R.id.choiceness_video_type);
                TextView title = holder.getView(R.id.choiceness_video_title);
                TextView duration = holder.getView(R.id.choiceness_video_duration);
                type.setText("#" + item.getData().getCategory());
                title.setText(item.getData().getTitle());
                duration.setText(DateUtil.secondToMinute(item.getData().getDuration()));
                Glide.with(getContext()).load(item.getData().getCover().getFeed())
                        .into(image);
            }
        };
        /**
         * Type为textFoot的item
         */
        footBean = new DataHolder<ChoicenessTextFooterBean>() {
            @Override
            public void bind(Context context, SuperViewHolder holder, ChoicenessTextFooterBean item, int position) {
                TextView text = holder.getView(R.id.choiceness_textfoot_title);
                text.setText(item.getData().getText());
            }
        };
        /**
         * Type为videoCollectionWithCover的item
         */
        collecBean = new DataHolder<ChoicenessVideoCollectionWithCoverBean>() {
            @Override
            public void bind(Context context, SuperViewHolder holder, ChoicenessVideoCollectionWithCoverBean item, int position) {
                ImageView headImage = holder.getView(R.id.choiceness_video_collection_headimage);
                List<ImageView> images = new ArrayList<>();
                List<TextView> types = new ArrayList<>();
                ImageView image1 = holder.getView(R.id.choiceness_video_collection_item_image1);
                ImageView image2 = holder.getView(R.id.choiceness_video_collection_item_image2);
                ImageView image3 = holder.getView(R.id.choiceness_video_collection_item_image3);
                ImageView image4 = holder.getView(R.id.choiceness_video_collection_item_image4);
                ImageView image5 = holder.getView(R.id.choiceness_video_collection_item_image5);
                TextView type1 = holder.getView(R.id.choiceness_video_collection_item_type1);
                TextView type2 = holder.getView(R.id.choiceness_video_collection_item_type2);
                TextView type3 = holder.getView(R.id.choiceness_video_collection_item_type3);
                TextView type4 = holder.getView(R.id.choiceness_video_collection_item_type4);
                TextView type5 = holder.getView(R.id.choiceness_video_collection_item_type5);
                TextView duration1 = holder.getView(R.id.choiceness_video_collection_item_duration1);
                TextView duration2 = holder.getView(R.id.choiceness_video_collection_item_duration2);
                TextView duration3 = holder.getView(R.id.choiceness_video_collection_item_duration3);
                TextView duration4 = holder.getView(R.id.choiceness_video_collection_item_duration4);
                TextView duration5 = holder.getView(R.id.choiceness_video_collection_item_duration5);
                TextView title1 = holder.getView(R.id.choiceness_video_collection_item_title1);
                TextView title2 = holder.getView(R.id.choiceness_video_collection_item_title2);
                TextView title3 = holder.getView(R.id.choiceness_video_collection_item_title3);
                TextView title4 = holder.getView(R.id.choiceness_video_collection_item_title4);
                TextView title5 = holder.getView(R.id.choiceness_video_collection_item_title5);
                images.add(image1);
                images.add(image2);
                images.add(image3);
                images.add(image4);
                images.add(image5);
                types.add(type1);
                types.add(type2);
                types.add(type3);
                types.add(type4);
                types.add(type5);
                types.add(duration1);
                types.add(duration2);
                types.add(duration3);
                types.add(duration4);
                types.add(duration5);
                types.add(title1);
                types.add(title2);
                types.add(title3);
                types.add(title4);
                types.add(title5);
                ImageUtil.loadImage(getContext(), item.getData().getHeader().getCover(), headImage);
                for (int i = 0; i < 5; i++) {
                    types.get(i).setText(item.getData().getItemList().get(i).getData().getCategory());
                }
                for (int i = 5; i < 10; i++) {
                    types.get(i).setText(DateUtil.secondToMinute(item.getData().getItemList().get(i - 5).getData().getDuration()));
                }
                for (int i = 10; i < 15; i++) {
                    types.get(i).setText(item.getData().getItemList().get(i - 10).getData().getTitle());
                }
                for (int i = 0; i < 5; i++) {
                    ImageUtil.loadImage(getContext(), item.getData().getItemList().get(i).getData().getCover().getFeed(), images.get(i));
                }
            }
        };
        /**
         * Type 为textHeader的item
         */
        headBean = new DataHolder<ChoicenessTextHeaderBean>() {
            @Override
            public void bind(Context context, SuperViewHolder holder, ChoicenessTextHeaderBean item, int position) {
                TextView head = holder.getView(R.id.choiceness_texthead_title);
                head.setText(item.getData().getText());
                TextViewUtil.setTypeFace(getContext(), head);
            }
        };
        /**
         * Type为videoCollectionOfFollow的item
         */


        followBean = new DataHolder<ChoicenessVideoCollectionOfFollowBean>() {
            @Override
            public void bind(Context context, SuperViewHolder holder, ChoicenessVideoCollectionOfFollowBean item, int position) {
                List<ImageView> images = new ArrayList<>();
                List<TextView> types = new ArrayList<>();
                //先加载head背景
                ImageView headImage = holder.getView(R.id.choiceness_video_follow_headimage);
                //head背景上的三个小图标
                ImageView headImageItem1 = holder.getView(R.id.choiceness_video_follow_headimage_item1);
                ImageView headImageItem2 = holder.getView(R.id.choiceness_video_follow_headimage_item2);
                ImageView headImageItem3 = holder.getView(R.id.choiceness_video_follow_headimage_item3);
                //head上面的文字
                TextView headTitle1 = holder.getView(R.id.choiceness_video_follow_headtext_item1);
                TextView headTitle2 = holder.getView(R.id.choiceness_video_follow_headtext_item2);
                //item 的图
                ImageView image1 = holder.getView(R.id.choiceness_video_follow_item_image1);
                ImageView image2 = holder.getView(R.id.choiceness_video_follow_item_image2);
                ImageView image3 = holder.getView(R.id.choiceness_video_follow_item_image3);
                ImageView image4 = holder.getView(R.id.choiceness_video_follow_item_image4);
                ImageView image5 = holder.getView(R.id.choiceness_video_follow_item_image5);
                //item 的类型
                TextView type1 = holder.getView(R.id.choiceness_video_follow_item_type1);
                TextView type2 = holder.getView(R.id.choiceness_video_follow_item_type2);
                TextView type3 = holder.getView(R.id.choiceness_video_follow_item_type3);
                TextView type4 = holder.getView(R.id.choiceness_video_follow_item_type4);
                TextView type5 = holder.getView(R.id.choiceness_video_follow_item_type5);
                //item 的时间
                TextView duration1 = holder.getView(R.id.choiceness_video_follow_item_duration1);
                TextView duration2 = holder.getView(R.id.choiceness_video_follow_item_duration2);
                TextView duration3 = holder.getView(R.id.choiceness_video_follow_item_duration3);
                TextView duration4 = holder.getView(R.id.choiceness_video_follow_item_duration4);
                TextView duration5 = holder.getView(R.id.choiceness_video_follow_item_duration5);
                //item 的标题
                TextView title1 = holder.getView(R.id.choiceness_video_follow_item_title1);
                TextView title2 = holder.getView(R.id.choiceness_video_follow_item_title2);
                TextView title3 = holder.getView(R.id.choiceness_video_follow_item_title3);
                TextView title4 = holder.getView(R.id.choiceness_video_follow_item_title4);
                TextView title5 = holder.getView(R.id.choiceness_video_follow_item_title5);
                images.add(headImageItem1);
                images.add(headImageItem2);
                images.add(headImageItem3);
                images.add(image1);
                images.add(image2);
                images.add(image3);
                images.add(image4);
                images.add(image5);
                types.add(type1);
                types.add(type2);
                types.add(type3);
                types.add(type4);
                types.add(type5);
                types.add(duration1);
                types.add(duration2);
                types.add(duration3);
                types.add(duration4);
                types.add(duration5);
                types.add(title1);
                types.add(title2);
                types.add(title3);
                types.add(title4);
                types.add(title5);
                //先加载head背景
                ImageUtil.loadImage(getContext(), item.getData().getHeader().getCover(), headImage);
                //head背景上的三个小图标
                for (int i = 0; i < 3; i++) {
                    ImageUtil.loadCircleImage(getContext(), item.getData().getHeader().getIconList().get(i), images.get(i));
                }
                //head上面的文字
                headTitle1.setText(item.getData().getHeader().getTitle());
                headTitle2.setText(item.getData().getHeader().getDescription());
                //item 的图
                for (int i = 3; i < 8; i++) {
                    ImageUtil.loadImage(getContext(), item.getData().getItemList().get(i - 3).getData().getCover().getFeed(), images.get(i));
                }
                //item 的类型
                for (int i = 0; i < 5; i++) {
                    types.get(i).setText("#" + item.getData().getItemList().get(i).getData().getCategory());
                }
                //item 的时间
                for (int i = 5; i < 10; i++) {
                    types.get(i).setText(DateUtil.secondToMinute(item.getData().getItemList().get(i - 5).getData().getDuration()));
                }
                //item 的标题
                for (int i = 10; i < 15; i++) {
                    types.get(i).setText(item.getData().getItemList().get(i - 10).getData().getTitle());
                }

            }
        };
        /**
         * Type 为banner的
         */
        bannerBean = new DataHolder<ChoicenessBannerBean>() {
            @Override
            public void bind(Context context, SuperViewHolder holder, ChoicenessBannerBean item, int position) {
                ImageView image = holder.getView(R.id.choiceness_banner);
                ImageUtil.loadImage(getContext(), item.getData().getImage(), image);
            }
        };
        /**
         * Type为 squareCardCollection
         *
         */
        squareBean = new DataHolder<ChoicenessSquareCardBean>() {
            @Override
            public void bind(Context context, SuperViewHolder holder, ChoicenessSquareCardBean item, int position) {
                ImageView image1 = holder.getView(R.id.choiceness_square_image1);
                ImageView image2 = holder.getView(R.id.choiceness_square_image2);
                ImageView image3 = holder.getView(R.id.choiceness_square_image3);
                ImageView image4 = holder.getView(R.id.choiceness_square_image4);
                ImageView image5 = holder.getView(R.id.choiceness_square_image5);
                TextView title = holder.getView(R.id.choiceness_square_title);
                TextView type1 = holder.getView(R.id.choiceness_square_type1);
                TextView type2 = holder.getView(R.id.choiceness_square_type2);
                TextView type3 = holder.getView(R.id.choiceness_square_type3);
                TextView type4 = holder.getView(R.id.choiceness_square_type4);
                TextView type5 = holder.getView(R.id.choiceness_square_type5);
                title.setText(item.getData().getHeader().getTitle());
                type1.setText(item.getData().getItemList().get(0).getData().getTitle());
                type2.setText(item.getData().getItemList().get(1).getData().getTitle());
                type3.setText(item.getData().getItemList().get(2).getData().getTitle());
                type4.setText(item.getData().getItemList().get(3).getData().getTitle());
                type5.setText(item.getData().getItemList().get(4).getData().getTitle());
                ImageUtil.loadImage(getContext(), item.getData().getItemList().get(0).getData().getImage(), image1);
                ImageUtil.loadImage(getContext(), item.getData().getItemList().get(1).getData().getImage(), image2);
                ImageUtil.loadImage(getContext(), item.getData().getItemList().get(2).getData().getImage(), image3);
                ImageUtil.loadImage(getContext(), item.getData().getItemList().get(3).getData().getImage(), image4);
                ImageUtil.loadImage(getContext(), item.getData().getItemList().get(4).getData().getImage(), image5);
            }
        };
        /**
         * Type为videoCollectionOfAuthorWithCover的item
         */
        authorBean=new DataHolder<ChoicenessVideoCollectionOfAuthorBean>() {
            @Override
            public void bind(Context context, SuperViewHolder holder, ChoicenessVideoCollectionOfAuthorBean item, int position) {
                ImageView headImage = holder.getView(R.id.choiceness_video_collection_of_author_headimage);
                ImageView headIcon=holder.getView(R.id.choiceness_video_collection_of_author_head_icon);
                TextView headTitle=holder.getView(R.id.choiceness_video_collection_of_author_title);
                TextView headDescribe=holder.getView(R.id.choiceness_video_collection_of_author_describe);
                ImageUtil.loadImage(getContext(), item.getData().getHeader().getCover(), headImage);
                ImageUtil.loadCircleImage(getContext(),item.getData().getHeader().getIcon(),headIcon);
                headTitle.setText(item.getData().getHeader().getTitle());
                headDescribe.setText(item.getData().getHeader().getDescription());
                List<ImageView> images = new ArrayList<>();
                List<TextView> types = new ArrayList<>();
                ImageView image1 = holder.getView(R.id.choiceness_video_collection_of_author_item_image1);
                ImageView image2 = holder.getView(R.id.choiceness_video_collection_of_author_item_image2);
                ImageView image3 = holder.getView(R.id.choiceness_video_collection_of_author_item_image3);
                ImageView image4 = holder.getView(R.id.choiceness_video_collection_of_author_item_image4);
                ImageView image5 = holder.getView(R.id.choiceness_video_collection_of_author_item_image5);
                TextView type1 = holder.getView(R.id.choiceness_video_collection_of_author_item_type1);
                TextView type2 = holder.getView(R.id.choiceness_video_collection_of_author_item_type2);
                TextView type3 = holder.getView(R.id.choiceness_video_collection_of_author_item_type3);
                TextView type4 = holder.getView(R.id.choiceness_video_collection_of_author_item_type4);
                TextView type5 = holder.getView(R.id.choiceness_video_collection_of_author_item_type5);
                TextView duration1 = holder.getView(R.id.choiceness_video_collection_of_author_item_duration1);
                TextView duration2 = holder.getView(R.id.choiceness_video_collection_of_author_item_duration2);
                TextView duration3 = holder.getView(R.id.choiceness_video_collection_of_author_item_duration3);
                TextView duration4 = holder.getView(R.id.choiceness_video_collection_of_author_item_duration4);
                TextView duration5 = holder.getView(R.id.choiceness_video_collection_of_author_item_duration5);
                TextView title1 = holder.getView(R.id.choiceness_video_collection_of_author_item_title1);
                TextView title2 = holder.getView(R.id.choiceness_video_collection_of_author_item_title2);
                TextView title3 = holder.getView(R.id.choiceness_video_collection_of_author_item_title3);
                TextView title4 = holder.getView(R.id.choiceness_video_collection_of_author_item_title4);
                TextView title5 = holder.getView(R.id.choiceness_video_collection_of_author_item_title5);
                images.add(image1);
                images.add(image2);
                images.add(image3);
                images.add(image4);
                images.add(image5);
                types.add(type1);
                types.add(type2);
                types.add(type3);
                types.add(type4);
                types.add(type5);
                types.add(duration1);
                types.add(duration2);
                types.add(duration3);
                types.add(duration4);
                types.add(duration5);
                types.add(title1);
                types.add(title2);
                types.add(title3);
                types.add(title4);
                types.add(title5);
                for (int i = 0; i < 5; i++) {
                    types.get(i).setText(item.getData().getItemList().get(i).getData().getCategory());
                }
                for (int i = 5; i < 10; i++) {
                    types.get(i).setText(DateUtil.secondToMinute(item.getData().getItemList().get(i - 5).getData().getDuration()));
                }
                for (int i = 10; i < 15; i++) {
                    types.get(i).setText(item.getData().getItemList().get(i - 10).getData().getTitle());
                }
                for (int i = 0; i < 5; i++) {
                    ImageUtil.loadImage(getContext(), item.getData().getItemList().get(i).getData().getCover().getFeed(), images.get(i));
                }
            }
        };

    }

    /**
     * 对recycleView 进行操作
     */
    private void initRecycleView() {
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(adapter);
        /**
         * recycleView设置滑动监听
         */
        recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItemPosition = manager.findLastVisibleItemPosition();
                int visibleItemCount = manager.getChildCount();
                int totalItemCount = manager.getItemCount();
                if (url != "null" && visibleItemCount < totalItemCount && visibleItemCount > 0 && lastVisibleItemPosition == totalItemCount - 1 && newState == recyclerView.SCROLL_STATE_IDLE) {
                    if (!isLoadind) {
                        isLoadind = true;
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                initData(datenum, number, pag);
                                isLoadind = false;
                            }
                        });
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                Log.e(TAG, "onScrolled: "+dx+"  "+dy );
            }
        });
    }

//    @OnClick(R.id.fragment_choiceness_search)
//    public void onClick() {
//        Toast.makeText(getContext(), "搜索", Toast.LENGTH_SHORT).show();
//    }

}
