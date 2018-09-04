package myjd.example.com.weidu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected P presenter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(layoutProvider(), container,false);
        presenter = presenterProvider();
        return view;
    }

    protected abstract P presenterProvider();

    protected abstract int layoutProvider();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews(view);
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initViews(View view);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
      presenter.onDestroy();
        if (presenter != null) {
            presenter = null;
        }
    }
}
