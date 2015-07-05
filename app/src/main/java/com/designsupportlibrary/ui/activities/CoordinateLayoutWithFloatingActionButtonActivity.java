package com.designsupportlibrary.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.designsupportlibrary.R;

public class CoordinateLayoutWithFloatingActionButtonActivity extends AbstractActivity {

    private CoordinatorLayout mCoordinatorLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_coordinate_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.container);
    }

    public void onSnackBar(View view){

        Snackbar
                .make(mCoordinatorLayout,getString(R.string.wow_i_am_happy),Snackbar.LENGTH_LONG)
                .show();

    }
}
