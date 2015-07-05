package com.designsupportlibrary.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.designsupportlibrary.R;

import java.util.List;

/**
 * Created by Hafiz Waleed Hussain on 7/4/2015.
 */
public class CoordinatorExampleRecyclerViewAdapter extends RecyclerView.Adapter<CoordinatorExampleRecyclerViewAdapter.RecyclerViewHolder>{

    private List<String> mData;

    public CoordinatorExampleRecyclerViewAdapter(List<String> data) {
        mData = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.
                from(viewGroup.getContext()).inflate(R.layout.row_cordinator_view,viewGroup,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, final int i) {
        recyclerViewHolder.mTextView.setText(mData.get(i));
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
