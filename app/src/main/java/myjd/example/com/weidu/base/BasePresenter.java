package myjd.example.com.weidu.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IView> {
    protected V view;
    protected WeakReference weakReference;
    public BasePresenter(V view) {
        this.view = view;
        initModel();
    }

    protected abstract void initModel();

    public void onDestroy() {
        if (view != null) {
            view = null;
        }
    }
}
