package com.designsupportlibrary.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.designsupportlibrary.R;

public class MaterialDesignTabActivity extends AbstractActivity {

    private TabLayout mFixedTabLayout;
    private TabLayout mScrollableTabLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_material_design_tab;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fixedTabLayoutSetup();
        scrollableTabLayoutSetup();
    }

    private void fixedTabLayoutSetup() {
        mFixedTabLayout = (TabLayout) findViewById(R.id.fixedTabLayout);

        mFixedTabLayout.addTab(mFixedTabLayout.newTab().setText(getString(R.string.one)));
        mFixedTabLayout.addTab(mFixedTabLayout.newTab().setText(getString(R.string.two)));
        mFixedTabLayout.addTab(mFixedTabLayout.newTab().setText(getString(R.string.three)));
        mFixedTabLayout.addTab(mFixedTabLayout.newTab().setText(getString(R.string.four)));
    }

    private void scrollableTabLayoutSetup() {
        mScrollableTabLayout = (TabLayout) findViewById(R.id.scrollableTabLayout);
        for(int i=1; i<=100;i++){
            mScrollableTabLayout.addTab(mScrollableTabLayout.newTab().setText("Tab "+i));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_material_design_tab, menu);
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
