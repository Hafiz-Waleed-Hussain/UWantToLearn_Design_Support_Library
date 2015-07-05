package com.designsupportlibrary.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.designsupportlibrary.R;
import com.designsupportlibrary.adapters.CoordinatorExampleRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class CollapsingToolbarLayoutActivity extends AbstractActivity{

    private RecyclerView mRecyclerView;
    private CoordinatorExampleRecyclerViewAdapter mAdapter;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_collapsing_toolbar_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpRecyclerView();
        mCollapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);
        mCollapsingToolbarLayout.setTitle(getString(R.string.this_is_title));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_collapsing_toolbar_layout, menu);
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

    private void setUpRecyclerView() {

        mAdapter = new CoordinatorExampleRecyclerViewAdapter(generateData());

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }


    @NonNull
    private List<String> generateData() {
        List<String> data = new ArrayList<>();
        String sentence = getString(R.string.this_is_a_sentence);
        int number = 1;
        for(int i=0; i<10;i++){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j=0;j<100;j++){
                stringBuilder.append(sentence).append(number++).append(". ");
            }
            data.add(stringBuilder.toString());
        }
        return data;
    }
}
