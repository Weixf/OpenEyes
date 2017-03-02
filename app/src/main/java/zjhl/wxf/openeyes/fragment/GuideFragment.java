package zjhl.wxf.openeyes.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zjhl.wxf.openeyes.R;
import zjhl.wxf.openeyes.base.BaseFragment;
import zjhl.wxf.openeyes.utils.TextViewUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFragment extends BaseFragment {
    private static final String TAG = "GuideFragment";
    private TextView textView;

    public GuideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_guide, container, false);
        textView = (TextView) inflate.findViewById(R.id.guide_fragment_text);
        TextViewUtil.setTypeFace(getContext(), textView, "fonts/Lobster-1.4.otf");
        if (savedInstanceState != null) {
            textView.setText(getArguments().getString("text"));
            Log.e(TAG, "onCreateView: "+textView.getText().toString() );
        }
        return inflate;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 4      * 静态工厂方法需要一个int型的值来初始化fragment的参数，
     * 5      * 然后返回新的fragment到调用者
     * 6
     */
    public static GuideFragment newInstance(String s) {
        GuideFragment fragment = new GuideFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", s);
        fragment.setArguments(bundle);
        return fragment;
    }

}
