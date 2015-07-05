package com.designsupportlibrary.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.designsupportlibrary.R;

public class FloatingActionButtonActivity extends AbstractActivity {

    private FloatingActionButton mNormalFloatingActionButton;
    private FloatingActionButton mMiniFloatingActionButton;

    @Override
    protected int getLayout() {
        return R.layout.activity_floating_action_button;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpNormalFloatingActionButton();
        setUpMiniFloatingActionButton();
    }

    private void setUpNormalFloatingActionButton() {
        mNormalFloatingActionButton = (FloatingActionButton)findViewById(R.id.normalFloatingActionButton);
        mNormalFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.
                        loadAnimation(FloatingActionButtonActivity.this, R.anim.roate_around_axis);
                mNormalFloatingActionButton.startAnimation(animation);
            }
        });
    }

    private void setUpMiniFloatingActionButton() {

        mMiniFloatingActionButton = (FloatingActionButton)findViewById(R.id.miniFloatingActionButton);
        mMiniFloatingActionButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.
                        loadAnimation(FloatingActionButtonActivity.this, R.anim.rotate_to_axis);
                mMiniFloatingActionButton.startAnimation(animation);
            }
        });
    }
}
