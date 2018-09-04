package myjd.example.com.weidu.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import myjd.example.com.weidu.R;
import myjd.example.com.weidu.base.BaseActivity;
import myjd.example.com.weidu.base.BasePresenter;
import myjd.example.com.weidu.mvp.cinemapage.view.CinemaPageFour;
import myjd.example.com.weidu.mvp.moviepage.view.MoviePageFour;
import myjd.example.com.weidu.mvp.ownpage.view.SettingsPageFour;
import myjd.example.com.weidu.mvp.performancepage.view.MembershipPageFour;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rg_group;
    private Fragment mCurrentFragment;
    private MoviePageFour mMoviePage;
    private CinemaPageFour mCinemaPage;
    private MembershipPageFour mMembershipPage;
    private SettingsPageFour mSettingsPage;
    @Override
    protected void initListener() {
        rg_group.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {
        if (mCurrentFragment == null) {
            mCurrentFragment = new Fragment();
            mMoviePage = new MoviePageFour();
            switchFragment(mMoviePage);
            mCinemaPage = new CinemaPageFour();
            mMembershipPage = new MembershipPageFour();
            mSettingsPage = new SettingsPageFour();
        }
    }

    private void switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            transaction
                    .hide(mCurrentFragment)
                    .add(R.id.framlayout_setfrag, targetFragment)
                    .commit();
        } else {
            transaction
                    .hide(mCurrentFragment)
                    .show(targetFragment)
                    .commit();
        }
        mCurrentFragment = targetFragment;
    }

    @Override
    protected void initViews() {
        rg_group = findViewById(R.id.rg_group);
    }

    @Override
    protected BasePresenter presenterProvider() {
        return null;
    }

    @Override
    protected int layoutProvider() {
        return R.layout.activity_main;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rdbtn_moviepage:
                //点击添加或显示moviepage
                switchFragment(mMoviePage);
                break;
            case R.id.rdbtn_cinemapage:
                //点击添加或显示cinemapage
                switchFragment(mCinemaPage);
                break;
            case R.id.rdbtn_membershippage:
                //点击添加或显示performancepage
                switchFragment(mMembershipPage);
                break;
            case R.id.rdbtn_settingpage:
                //点击添加或显示ownpage
                switchFragment(mSettingsPage);
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCurrentFragment.onDestroyView();
        mSettingsPage.onDestroyView();
        mCinemaPage.onDestroyView();
        mMoviePage.onDestroyView();
        mMoviePage.onDestroyView();
    }
}
