package contant.zhw.zxzq.com.mvpapplication;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/13 0013.
 */

public class MainPresenter {

    private List<String> mData;
    private MainActivity mMainActivity;

    public MainPresenter(MainActivity mainActivity){
        mData = new ArrayList<String>();
        this.mMainActivity = mainActivity;
    }

    public void loadData(){
        mMainActivity.showProgressBar();
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
    }

    //新建异步任务，模拟网络加载数据，三秒后加载数据
    //传三个参数：1.启动任务执行的输入参数；2.后台执行任务的进度；3.

    class MyAsyncTask extends AsyncTask<Void,Void,Void>{

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
            for (int i = 0; i <30 ; i++) {
                mData.add("第"+(i+1)+"条数据");
            }
            mMainActivity.setData(mData);
            mMainActivity.hideProgressBar();

            mMainActivity = null;
        }
    }
}
