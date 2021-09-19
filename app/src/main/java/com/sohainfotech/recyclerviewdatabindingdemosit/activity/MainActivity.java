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

        dataModelList.add(new DataModel("No codename", "1.0"));
        dataModelList.add(new DataModel("No codename", "1.1"));
        dataModelList.add(new DataModel("Cupcake", "1.5"));
        dataModelList.add(new DataModel("Donut", "1.6"));
        dataModelList.add(new DataModel("Eclair", "2.0 - 2.1"));
        dataModelList.add(new DataModel("Froyo", "2.2 - 2.2.3"));
        dataModelList.add(new DataModel("Gingerbread", "2.3 - 2.3.7"));
        dataModelList.add(new DataModel("Honeycomb", "3.0 - 3.2.6"));
        dataModelList.add(new DataModel("Ice Cream Sandwich", "4.0 - 4.0.4"));
        dataModelList.add(new DataModel("Jelly Bean", "4.1 - 4.3.1"));
        dataModelList.add(new DataModel("KitKat", "4.4 - 4.4.4"));
        dataModelList.add(new DataModel("Lollipop", "5.0 - 5.1.1"));
        dataModelList.add(new DataModel("Marshmallow", "6.0 - 6.0.1"));
        dataModelList.add(new DataModel("Nougat", "7.0 - 7.1.0 - 7.1.2"));
        dataModelList.add(new DataModel("Oreo", "8.0 - 8.1"));

        dataModelList.add(new DataModel("Pie", "9.0"));
        dataModelList.add(new DataModel("Android 10", "10.0"));
        dataModelList.add(new DataModel("Android 11", "11"));
        dataModelList.add(new DataModel("Android 12", "12"));

        binding.recyclerView.setAdapter(new DataAdapter(dataModelList, this));

    }
}