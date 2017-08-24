package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import base.BaseFragment;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class MemberManagerFragment extends BaseFragment {

    public static final String TAG = "会员";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vip,container,false);
    }
}
