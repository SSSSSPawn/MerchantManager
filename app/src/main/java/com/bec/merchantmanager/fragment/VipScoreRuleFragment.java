package com.bec.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bec.merchantmanager.Presenter.VipScoreRulePresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.AppUtils;
import com.bec.merchantmanager.Utils.Preference;
import com.bec.merchantmanager.activity.ScoreExchangeAddActivity;
import com.bec.merchantmanager.activity.VipScoreRuleDetailActivity;
import com.bec.merchantmanager.activity.VipScoreUpdateActivity;
import com.bec.merchantmanager.adapter.VipScoreRuleAdapter;
import com.bec.merchantmanager.base.ListFragment;
import com.bec.merchantmanager.bean.CodeMessageVO;
import com.bec.merchantmanager.bean.ScoreExchangeQueryVO;
import com.bec.merchantmanager.bean.params.ScoreExchangeDeleteParamsVO;
import com.bec.merchantmanager.constant.CacheKey;
import com.bec.merchantmanager.constant.Intentkey;
import com.bec.merchantmanager.listener.OnDeleteItemClickListener;
import com.bec.merchantmanager.view.CustomDialog;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;

import static com.bec.merchantmanager.R.id.ll_empty;

/**
 * Created by admin on 2017/11/13.
 */

public class VipScoreRuleFragment extends ListFragment implements VipScoreRulePresenter.MvpView {

    @Bind(ll_empty) LinearLayout mLayout;

    @Bind(R.id.fab_add) FloatingActionButton mFloatingActionButton;

    private VipScoreRuleAdapter mAdapter;

    private VipScoreRulePresenter mPresenter = new VipScoreRulePresenter();

    private ArrayList<ScoreExchangeQueryVO.RowsBean> mList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
        mAdapter = new VipScoreRuleAdapter();

        mAdapter.setDeleteOnItemClickListener(new OnDeleteItemClickListener() {
            @Override
            public void onDeleteItemClick(final int position) {
                final CustomDialog dialog = new CustomDialog(getActivity());
                dialog.setOkButton(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        long custID = Preference.getLong(CacheKey.CUST_ID);
                        long rootID = Preference.getLong(CacheKey.ROOT_ID);
                        String uuID = Preference.getString(CacheKey.UU_ID);
                        String mac = Preference.getString(CacheKey.MAC);
                        String uid = mList.get(position).getUid();
                        ScoreExchangeDeleteParamsVO paramsVO = new ScoreExchangeDeleteParamsVO(custID, rootID, uuID, mac, uid);
                        mPresenter.scoreExchangeDelete(paramsVO);
                    }
                });
                dialog.show("提示信息", "确定删除该组数据?");
            }

            @Override
            public void onItemClick(int position) {
                ScoreExchangeQueryVO.RowsBean rowsBean = mList.get(position);
                Intent intent = new Intent(getActivity(), VipScoreRuleDetailActivity.class);
                intent.putExtra(Intentkey.VIP_SCORE_RULE_DETAIL,rowsBean);
                launch(intent);
            }

            @Override
            public void onUpdate(int position) {
                ScoreExchangeQueryVO.RowsBean rowsBean = mList.get(position);
                Intent intent = new Intent(getActivity(), VipScoreUpdateActivity.class);
                intent.putExtra(Intentkey.VIP_SCORE_RULE_DETAIL,rowsBean);
                launch(intent);
            }
        });
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_vip_score_rule;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getVipScoreRuleData(1);
                mSuperRecyclerView.refreshComplete();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getNextData();
                mSuperRecyclerView.loadMoreComplete();
            }
        }, 1000);
    }

    @Override
    public void updateVipScoreRuleList(ArrayList<ScoreExchangeQueryVO.RowsBean> lists) {
        mList = lists;
        if (lists.size() == 0) {
            mSuperRecyclerView.setVisibility(View.GONE);
            mLayout.setVisibility(View.VISIBLE);
        }
        mAdapter.setDataList(lists);
    }

    @Override
    public void stopLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSuperRecyclerView.setNoMore(true);
            }
        }, 1000);
    }

    @Override
    public void emptyData() {
        mSuperRecyclerView.setVisibility(View.GONE);
        mLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMsg(CodeMessageVO msg) {
        if (msg.getRspcod() == 200) {
            mPresenter.getVipScoreRuleData(1);
            AppUtils.showToast(msg.getRspmsg());
        } else {
            AppUtils.showToast(msg.getRspmsg());
        }
    }

    @OnClick(R.id.fab_add)
    public void onViewClicked() {
        launch(ScoreExchangeAddActivity.class);
    }
}
