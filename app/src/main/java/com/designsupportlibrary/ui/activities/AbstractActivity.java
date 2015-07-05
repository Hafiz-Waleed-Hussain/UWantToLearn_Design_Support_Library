package com.designsupportlibrary.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.designsupportlibrary.R;

/**
 * Created by Hafiz Waleed Hussain on 7/4/2015.
 */
public abstract class AbstractActivity extends AppCompatActivity{

    private Toolbar mToolbar;
    protected abstract int getLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        setUpToolbar();
    }

    private void setUpToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if(mToolbar!=null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setTitle(R.string.design_support_library);
        }
    }
}
