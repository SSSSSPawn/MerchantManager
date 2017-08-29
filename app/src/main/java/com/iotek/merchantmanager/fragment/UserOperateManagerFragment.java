package com.iotek.merchantmanager.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.iotek.merchantmanager.Presenter.UserManagerPresenter;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.adapter.UserManagerAdapter;
import com.iotek.merchantmanager.base.SwipListBaseFragment;
import com.iotek.merchantmanager.view.DefineLoadMoreView;
import com.yanzhenjie.recyclerview.swipe.SwipeItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class UserOperateManagerFragment extends SwipListBaseFragment implements UserManagerPresenter.MvpView, SwipeItemClickListener {

    public final static String TAG = "用户";

    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;

    private UserManagerPresenter mPresenter = new UserManagerPresenter();
    private UserManagerAdapter mUserManagerAdapter;

    private List<String> mItemList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
        mUserManagerAdapter = new UserManagerAdapter();
        mUserManagerAdapter.setDataList(getDatas());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SwipeMenuRecyclerView recyclerView = getRecyclerView();
        recyclerView.setSwipeItemClickListener(this);
        recyclerView.setSwipeMenuCreator(swipeMenuCreator);
        recyclerView.setSwipeMenuItemClickListener(mMenuItemClickListener);

        mSwipeRefresh.setOnRefreshListener(mRefreshListener);
        mSwipeRefresh.setColorSchemeResources(R.color.colorAccent, R.color.add_bg_color, R
                .color.colorPrimary, R.color.colorPrimaryDark, R.color.add_selected_color);
        mSwipeRefresh.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));

        // 自定义的核心就是DefineLoadMoreView类。
        DefineLoadMoreView loadMoreView = new DefineLoadMoreView(getContext());
        recyclerView.addFooterView(loadMoreView); // 添加为Footer。
        recyclerView.setLoadMoreView(loadMoreView); // 设置LoadMoreView更新监听。
        recyclerView.setLoadMoreListener(mLoadMoreListener); // 加载更多的监听。
        loadData();
    }

    /**
     * 菜单创建器，在Item要创建菜单的时候调用。
     */
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            int width = getResources().getDimensionPixelSize(R.dimen.dp_80);
            // 1. MATCH_PARENT 自适应高度，保持和Item一样高;
            // 2. 指定具体的高，比如80;
            // 3. WRAP_CONTENT，自身高度，不推荐;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            SwipeMenuItem deleteItem = new SwipeMenuItem(getContext())
                    .setBackground(R.drawable.select_red2nor)
                    .setImage(R.drawable.ic_action_delete)
                    .setText("删除")
                    .setTextColor(Color.WHITE)
                    .setWidth(width)
                    .setHeight(height);
            swipeRightMenu.addMenuItem(deleteItem);// 添加菜单到右侧。

        }
    };

    /**
     * RecyclerView的Item的Menu点击监听。
     */
    private SwipeMenuItemClickListener mMenuItemClickListener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {
            menuBridge.closeMenu();

            int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
            int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView的Item的position。
            if (direction == SwipeMenuRecyclerView.RIGHT_DIRECTION) {
                LogUtil.i("position = " + adapterPosition);
                Toast.makeText(getContext(), "position = " + adapterPosition, Toast.LENGTH_SHORT).show();
            }
        }
    };

    private ArrayList<String> getDatas() {
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            datas.add("" + i);
        }
        return datas;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mUserManagerAdapter;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_user;
    }

    @Override
    public void onItemClick(View itemView, int position) {
        AppUtils.showToast("======>>" + position);
    }

    private SwipeRefreshLayout.OnRefreshListener mRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadData();
                }
            }, 3000);
        }
    };

    private SwipeMenuRecyclerView.LoadMoreListener mLoadMoreListener = new SwipeMenuRecyclerView.LoadMoreListener() {
        @Override
        public void onLoadMore() {
            getRecyclerView().postDelayed(new Runnable() {
                @Override
                public void run() {
                    List<String> strings = getItemList(mUserManagerAdapter.getItemCount());
                    mItemList.addAll(strings);
                    mUserManagerAdapter.notifyItemRangeInserted(mItemList.size() - strings.size(), strings.size());
                    getRecyclerView().loadMoreFinish(false, true);

                    // 如果加载失败调用下面的方法，传入errorCode和errorMessage。
                    // errorCode随便传，你自定义LoadMoreView时可以根据errorCode判断错误类型。
                    // errorMessage是会显示到loadMoreView上的，用户可以看到。
                    // mRecyclerView.loadMoreError(0, "请求网络失败");
                }
            }, 1000);
        }
    };

    private void loadData() {
        mItemList.clear();
        mItemList.addAll(getItemList(0));
        mUserManagerAdapter.notifyDataSetChanged();
        mSwipeRefresh.setRefreshing(false);
        getRecyclerView().loadMoreFinish(false, true);
    }

    protected List<String> getItemList(int start) {
        List<String> data = new ArrayList<>();
        for (int i = start; i < start + 20; i++) {
            data.add("第" + i + "个Item");
        }
        return data;
    }
}
