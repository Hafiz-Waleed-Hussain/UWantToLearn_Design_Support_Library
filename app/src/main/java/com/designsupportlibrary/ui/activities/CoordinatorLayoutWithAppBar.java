package com.designsupportlibrary.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.designsupportlibrary.R;
import com.designsupportlibrary.adapters.CoordinatorExampleRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorLayoutWithAppBar extends AbstractActivity {

    private RecyclerView mRecyclerView;
    private CoordinatorExampleRecyclerViewAdapter mAdapter;
    private TabLayout mFixedTabLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_coordinator_layout_with_app_bar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpRecyclerView();
        fixedTabLayoutSetup();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coordinator_layout_with_app_bar, menu);
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

    private void fixedTabLayoutSetup() {
        mFixedTabLayout = (TabLayout) findViewById(R.id.fixedTabLayout);
        if(mFixedTabLayout != null) {
            mFixedTabLayout.addTab(mFixedTabLayout.newTab().setText(getString(R.string.one)));
            mFixedTabLayout.addTab(mFixedTabLayout.newTab().setText(getString(R.string.two)));
            mFixedTabLayout.addTab(mFixedTabLayout.newTab().setText(getString(R.string.three)));
            mFixedTabLayout.addTab(mFixedTabLayout.newTab().setText(getString(R.string.four)));
        }
    }


    @NonNull
    private List<String> generateData() {
        List<String> data = new ArrayList<>();
        String sentence = getString(R.string.this_is_a_sentence_number);
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
