package com.sohainfotech.recyclerviewdatabindingdemosit.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.sohainfotech.recyclerviewdatabindingdemosit.R;
import com.sohainfotech.recyclerviewdatabindingdemosit.adapter.DataAdapter;
import com.sohainfotech.recyclerviewdatabindingdemosit.databinding.ActivityMainBinding;
import com.sohainfotech.recyclerviewdatabindingdemosit.model.DataModel;

import java.util.ArrayList;
import java.util.List;

// step7:

public class MainActivity extends AppCompatActivity {

    // data binding
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // bind recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(linearLayoutManager);

        populateData();
    }

    private void populateData() {
        List<DataModel> dataModelList = new ArrayList<>();

        dataModelList.add(new DataModel("Android Oreo", "8.1"));
        dataModelList.add(new DataModel("Android Nougat", "7.0"));
        dataModelList.add(new DataModel("Android Marshmallow", "6.0"));

        binding.recyclerView.setAdapter(new DataAdapter(dataModelList, this));

    }
}