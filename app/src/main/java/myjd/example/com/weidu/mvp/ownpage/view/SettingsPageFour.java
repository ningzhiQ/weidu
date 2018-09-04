package myjd.example.com.weidu.mvp.ownpage.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import myjd.example.com.weidu.R;
import myjd.example.com.weidu.activity.AboutActivityFour;
import myjd.example.com.weidu.activity.SuggestionActivityFour;
import myjd.example.com.weidu.activity.UpgradeActivityFour;
import myjd.example.com.weidu.base.BaseFragment;
import myjd.example.com.weidu.base.BasePresenter;
import utils.ImageFileCache;

public class SettingsPageFour extends BaseFragment implements View.OnClickListener{

    private RelativeLayout personal;
    private RelativeLayout pwd;
    private RelativeLayout login;
    private RelativeLayout clear;
    private RelativeLayout upgrade;
    private RelativeLayout suggestion;
    private RelativeLayout about;
    private RelativeLayout tel;
    private AlertDialog dialog;
    private UpgradeActivityFour mUpdateManager;

    @Override
    protected BasePresenter presenterProvider() {
        return null;
    }

    @Override
    protected int layoutProvider() {
        return R.layout.fragment_settings;
    }

    @Override
    protected void initListener() {
        personal.setOnClickListener(this);
        pwd.setOnClickListener(this);
        login.setOnClickListener(this);
        clear.setOnClickListener(this);
        upgrade.setOnClickListener(this);
        suggestion.setOnClickListener(this);
        about.setOnClickListener(this);
        tel.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }



    @Override
    protected void initViews(View view) {
        personal = view.findViewById(R.id.relative_personal);
        pwd = view.findViewById(R.id.relative_pwd);
        login = view.findViewById(R.id.relative_login);
        clear = view.findViewById(R.id.relative_clear);
        upgrade = view.findViewById(R.id.relative_upgrade);
        suggestion = view.findViewById(R.id.relative_suggestion);
        about = view.findViewById(R.id.relative_about);
        tel = view.findViewById(R.id.relative_tel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.relative_personal:

                break;
            case R.id.relative_pwd:

                break;
            case R.id.relative_login:

                break;
            case R.id.relative_clear:
                //清除缓存弹框
                dialog();
                break;
            case R.id.relative_upgrade:
                //这里来检测版本是否需要更新
                mUpdateManager = new UpgradeActivityFour(getActivity());
                mUpdateManager.checkUpdateInfo();
                break;
            case R.id.relative_suggestion:
                startActivity(new Intent(getActivity(),SuggestionActivityFour.class));
                break;
            case R.id.relative_about:
                startActivity(new Intent(getActivity(),AboutActivityFour.class));
                break;
            case R.id.relative_tel:

                break;
        }
    }



    //弹框
    private void dialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
         dialog = builder.create();
        dialog.setTitle("清楚缓存");
        dialog.setMessage("清楚缓存会导致下载的内容删除，是否确定?");
        View inflate = View.inflate(getActivity(), R.layout.setting_layout_item, null);
        dialog.setView(inflate);
        TextView text_qd = inflate.findViewById(R.id.text_qd);
        TextView text_qx = inflate.findViewById(R.id.text_qx);
        //设置按钮
        //确定
        text_qd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //清楚缓存方法
                ImageFileCache.ClearCache() ;
                Toast.makeText(getActivity(),ImageFileCache.ClearCache().toString(),Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        //取消
       text_qx.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.dismiss();
           }
       });
        dialog.show();
    }
}
