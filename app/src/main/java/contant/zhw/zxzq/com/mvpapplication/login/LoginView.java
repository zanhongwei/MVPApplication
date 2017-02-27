package contant.zhw.zxzq.com.mvpapplication.login;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public interface LoginView extends MvpView{

    void showProgressBar();
    void hideProgressBar();
    void showMessage(String msg);
}
