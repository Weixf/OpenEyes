package zjhl.wxf.openeyes.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zjhl.wxf.openeyes.R;
import zjhl.wxf.openeyes.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttentionFragment extends BaseFragment {


    public AttentionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attention, container, false);
    }

}
