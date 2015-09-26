package practice.example.com.recyclerview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import practice.example.com.recyclerview.Adapter.ItemAdapter;
import practice.example.com.recyclerview.Model.Item;


public class MainActivity extends Activity {
    public static final String TAG = "Recycler Test";

    private List<Item> items;

    //Bind view using ButterKnife
    @Bind(R.id.rv_default) RecyclerView rv_default;
    @Bind(R.id.radioGroup) RadioGroup radioGroup;
    @Bind(R.id.rb_linear) RadioButton rb_linear;
    @Bind(R.id.rb_grid) RadioButton rb_grid;
    @Bind(R.id.rb_staggered) RadioButton rb_staggered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initItemData();
        setupView();
    }

    private void initItemData() {
        items = new ArrayList<Item>();
        items.add(new Item("Car",           Color.RED));
        items.add(new Item("Awesome Book",  Color.parseColor("#661199")));
        items.add(new Item("Travel",        Color.GREEN));
        items.add(new Item("Hotel",         Color.YELLOW));
        items.add(new Item("Food",          Color.CYAN));
        items.add(new Item("Food II",       Color.CYAN));
        items.add(new Item("Vacation",      Color.BLUE));
        items.add(new Item("Vacation II",   Color.BLUE));
        items.add(new Item("Holiday",       Color.parseColor("#00FF45")));
        items.add(new Item("Rent",          Color.parseColor("#22DDAA")));
        items.add(new Item("Game",          Color.parseColor("#4477DD")));
    }

    private void setupView() {
        ButterKnife.bind(this);

        //setup Recycler View
        if(rv_default==null) {
            Log.e(TAG,"setupView: rv_default NULL POINTER");
            return;
        }

        //only call this if your data is fixed size
        rv_default.setHasFixedSize(true);

        //init LayoutManager: LinearLayoutManager; and set it to RecyclerView
        setLinearLayoutManager(rv_default);

        //init adapter and set it to RecyclerView
        ItemAdapter adapter = new ItemAdapter(items);
        rv_default.setAdapter(adapter);
    }

    private void setLinearLayoutManager(RecyclerView rv) {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }

    private void setGridLayoutManager(RecyclerView rv) {
        //GridLayoutManager (Context context, int spanCount, int orientation, boolean reverseLayout)
        GridLayoutManager llm = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
    }

    private void setStaggeredGridLayoutManager(RecyclerView rv) {
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3, 1);
        rv.setLayoutManager(sglm);
    }

    public void onRadioButtonClicked(View view) {
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rb_linear:
                setLinearLayoutManager(rv_default);
                Log.i(TAG,"onRadioButtonClicked: rb_linear");
                break;
            case R.id.rb_grid:
                setGridLayoutManager(rv_default);
                Log.i(TAG,"onRadioButtonClicked: rb_grid");
                break;
            case R.id.rb_staggered:
                setStaggeredGridLayoutManager(rv_default);
                Log.i(TAG,"onRadioButtonClicked: rb_staggered");
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
