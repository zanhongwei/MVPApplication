package contant.zhw.zxzq.com.mvpapplication.register;

import android.os.AsyncTask;

/**
 * Created by Administrator on 2017/2/13 0013.
 */

public class RegisterPresentser {

    private RegisterView mRegisterView;

    public RegisterPresentser(RegisterView registerView){
        this.mRegisterView = registerView;
    }

    public void register(){
        mRegisterView.showProgressBar();
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
            mRegisterView.hideProgressBar();
            mRegisterView.showMessage("Register success ！");
        }
    }
}
