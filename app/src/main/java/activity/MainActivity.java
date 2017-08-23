package activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import Presenter.MainPresenter;
import base.BaseActivity;
import base.BaseFragment;
import bean.TabMenus;
import butterknife.Bind;
import fragment.FormsMangerFragment;
import fragment.MemberManagerFragment;
import fragment.SHManagerFragment;
import fragment.SWMangerFragment;
import fragment.UserOperateManagerFragment;
import iotek.com.merchantmanager.R;

public class MainActivity extends BaseActivity implements MainPresenter.MvpView, TabLayout.OnTabSelectedListener {

    @Bind(R.id.tab_menu)
    TabLayout mTabMenu;

    private TabMenus[] TAB_MENUS = null;

    private int mCurrentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMenu();

        mTabMenu.setTabMode(TabLayout.MODE_FIXED);

        mTabMenu.setOnTabSelectedListener(this);

        mTabMenu.setSelectedTabIndicatorHeight(0);//隐藏指示条

        for (int i = 0;i<TAB_MENUS.length;i++){
            mTabMenu.addTab(mTabMenu.newTab().setCustomView(getTabView(i)));
        }

        setSelectedTab(mCurrentPosition);
    }

    private void initMenu() {
        TAB_MENUS = new TabMenus[]{
                new TabMenus(UserOperateManagerFragment.TAG, R.mipmap.user_normal, R.mipmap.user_selected, findFragment(UserOperateManagerFragment.class, UserOperateManagerFragment.TAG)),
                new TabMenus(FormsMangerFragment.TAG, R.mipmap.form_normal, R.mipmap.form_selected, findFragment(FormsMangerFragment.class, FormsMangerFragment.TAG)),
                new TabMenus(SHManagerFragment.TAG, R.mipmap.sh_normal, R.mipmap.sh_selected, findFragment(SHManagerFragment.class, SHManagerFragment.TAG)),
                new TabMenus(MemberManagerFragment.TAG, R.mipmap.vip_normal, R.mipmap.vip_selected, findFragment(MemberManagerFragment.class, MemberManagerFragment.TAG)),
                new TabMenus(SWMangerFragment.TAG, R.mipmap.sw_normal, R.mipmap.sw_selected, findFragment(SWMangerFragment.class, SWMangerFragment.TAG))
        };
    }

    private <T extends BaseFragment> T findFragment(Class<T> clazz, String tag) {
        T fragment = (T) getSupportFragmentManager().findFragmentByTag(tag);
        try {
            return fragment == null ? clazz.newInstance() : fragment;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    private View getTabView(int position){
        View view = LayoutInflater.from(this).inflate(R.layout.activity_main_tab, null);
        ((TextView) view.findViewById(R.id.tv_name)).setText(TAB_MENUS[position].name);
        ((ImageView) view.findViewById(R.id.iv_icon)).setImageDrawable(TAB_MENUS[position].icon);
        return view;
    }

    @Override
    public void setSelectedTab(int position) {
        mTabMenu.getTabAt(position).select();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
