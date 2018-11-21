package touchmenot.com.touchmenot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import touchmenot.com.R;

public class MainActivity extends AppCompatActivity implements TouchInterface {

    @BindView(R.id.rvTouchMeNotRecycler)
    RecyclerView rvTouchMeNoRecycler;

    TouchRecyclerAdapter touchRecyclerAdapter;
    List<TouchBean> touchBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        touchBeanList = new ArrayList<>();
        ButterKnife.bind(this);
        setRecycler();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting:

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setRecycler() {
        touchBeanList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            touchBeanList.add(new TouchBean(i));
        }
        touchRecyclerAdapter = new TouchRecyclerAdapter(this, touchBeanList, this);
        rvTouchMeNoRecycler.setLayoutManager(new GridLayoutManager(this, 4));
        rvTouchMeNoRecycler.setAdapter(touchRecyclerAdapter);
        rvTouchMeNoRecycler.setHasFixedSize(true);

    }

    @Override
    public void onItemTouch(int id) {
        touchBeanList.remove(id);
        touchRecyclerAdapter.notifyDataSetChanged();
    }
}
