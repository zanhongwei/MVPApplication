package contant.zhw.zxzq.com.mvpapplication.login;

import android.os.AsyncTask;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

/**
 * Created by Administrator on 2017/2/14 0014.
 */

public class LoginPresenter extends MvpNullObjectBasePresenter<LoginView> {

    public void login(){
        getView().showProgressBar();
        new MyAsynTask().execute();
    }

    class MyAsynTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            getView().showMessage("Login success !!");
            getView().hideProgressBar();
        }
    }
}
