package com.example.viewmodelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;

    private UserAdapter adapter;
    private UserViewModel model;
    private ArrayList<String> mNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        model = ViewModelProviders.of(this).get(UserViewModel.class);
        model.getUsers().observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                if (mNames == null) {
                    mNames = new ArrayList<>();
                    mNames.addAll(strings);
                    setAdapter(strings);
                } else {
                    mNames.clear();
                    mNames.addAll(strings);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void setAdapter(ArrayList<String> datas) {
        adapter = new UserAdapter(this, datas);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }
}
