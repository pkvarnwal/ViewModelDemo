package com.example.viewmodelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<String> mNames;
    private LayoutInflater mLayoutInflater;

    public UserAdapter(Context context, ArrayList<String> names) {
        mContext = context;
        mNames = names;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.row_item_title, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(mNames.get(position));
    }

    @Override
    public int getItemCount() {
        return mNames.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_name)
        TextView textName;

        private MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        private void bindData(String name) {
            textName.setText(name);
        }

        @OnClick(R.id.root)
        void onRootTapped() {

        }
    }
}
