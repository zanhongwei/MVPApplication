package contant.zhw.zxzq.com.mvpapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private ProgressBar mProgressBar;
    private Button mButton;

    private List<String> mData;
    private ArrayAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
    }

    private void initWidget() {
        listView = (ListView) findViewById(R.id.listview);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(this);

        mData = new ArrayList<String>();
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mData);
        listView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        //业务方面的内容
        new MainPresenter(this).loadData();
    }

    public void showProgressBar(){
        listView.setVisibility(View.INVISIBLE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgressBar(){
        mProgressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    public void setData(List<String> datas){
        mAdapter.addAll(datas);
        mAdapter.notifyDataSetChanged();
    }

}
