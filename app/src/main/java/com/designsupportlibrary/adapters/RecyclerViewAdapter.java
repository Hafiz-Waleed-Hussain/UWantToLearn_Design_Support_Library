package com.designsupportlibrary.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.designsupportlibrary.R;
import com.designsupportlibrary.ui.activities.CollapsingToolbarLayoutActivity;
import com.designsupportlibrary.ui.activities.CoordinateLayoutWithFloatingActionButtonActivity;
import com.designsupportlibrary.ui.activities.CoordinatorLayoutWithAppBar;
import com.designsupportlibrary.ui.activities.FloatingActionButtonActivity;
import com.designsupportlibrary.ui.activities.MainActivity;
import com.designsupportlibrary.ui.activities.MaterialDesignTabActivity;
import com.designsupportlibrary.ui.activities.NavigationViewActivity;
import com.designsupportlibrary.ui.activities.TextInputLayoutActivity;

import java.util.List;

/**
 * Created by Hafiz Waleed Hussain on 7/4/2015.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    private List<String> mData;

    public RecyclerViewAdapter(List<String> data) {
        mData = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.
                from(viewGroup.getContext()).inflate(R.layout.row_recycler_view,viewGroup,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, final int i) {

        recyclerViewHolder.mTextView.setText(mData.get(i));
        recyclerViewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                final Context context = v.getContext();
                switch (i){
                    case 0:
                        intent.setClass(context, TextInputLayoutActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent.setClass(context, FloatingActionButtonActivity.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent.setClass(context, MainActivity.class);
                        intent.putExtra("showSnackBar",true);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent.setClass(context, MaterialDesignTabActivity.class);
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent.setClass(context, NavigationViewActivity.class);
                        context.startActivity(intent);
                        break;
                    case 5:
                        intent.setClass(context, CoordinateLayoutWithFloatingActionButtonActivity.class);
                        context.startActivity(intent);
                        break;
                    case 6:
                        intent.setClass(context, CoordinatorLayoutWithAppBar.class);
                        context.startActivity(intent);
                        break;
                    case 7:
                        intent.setClass(context, CollapsingToolbarLayoutActivity.class);
                        context.startActivity(intent);
                        break;

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
