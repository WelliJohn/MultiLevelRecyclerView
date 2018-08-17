package wellijohn.org.multilevelrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class DemoActivity extends AppCompatActivity {

    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mRv.setLayoutManager(new LinearLayoutManager(this));
        DemoRVAdapter demoRVAdapter = new DemoRVAdapter();
        mRv.setAdapter(demoRVAdapter);
        demoRVAdapter.setDatas(TestData.getTestData());

    }

    private void initView() {
        mRv = findViewById(R.id.rv);
    }
}
