package com.designsupportlibrary.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.designsupportlibrary.R;
import com.designsupportlibrary.adapters.RecyclerViewAdapter;

import java.util.Arrays;

public class MainActivity extends AbstractActivity {


    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private View rootView;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpRecyclerView();
        rootView = findViewById(android.R.id.content);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(intent.getBooleanExtra("showSnackBar",false)){
            showSnackBar();
        }
    }

    private void setUpRecyclerView() {

        String[] data = getResources().getStringArray(R.array.recylerViewData);

        mRecyclerViewAdapter = new RecyclerViewAdapter(Arrays.asList(data));

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }


    private void showSnackBar(){

        Snackbar.
                make(rootView, getString(R.string.wow_so_simple), Snackbar.LENGTH_LONG)
                .setAction(R.string.undo, mSnackBarAction)
                .setActionTextColor(R.color.blue)
                .show();

    }

    private View.OnClickListener mSnackBarAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, R.string.undo_action, Toast.LENGTH_SHORT).show();
        }
    };
}
