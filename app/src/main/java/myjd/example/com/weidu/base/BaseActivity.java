package myjd.example.com.weidu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutProvider());

        presenter = presenterProvider();

        initViews();

        initData();

        initListener();
    }

    /**
     * 初始化监听
     */
    protected abstract void initListener();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化控件id
     */
    protected abstract void initViews();

    /**
     * 提供P层引用
     *
     * @return P
     */
    protected abstract P presenterProvider();

    /**
     * 提供布局文件
     *
     * @return int
     */
    protected abstract int layoutProvider();

    /**
     *
     * 解决内存泄漏 滞空
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  presenter.onDestroy();
        if (presenter != null) {
            presenter = null;
        }
    }
}
