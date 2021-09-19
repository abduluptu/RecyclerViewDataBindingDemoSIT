package com.sohainfotech.recyclerviewdatabindingdemosit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sohainfotech.recyclerviewdatabindingdemosit.BR;
import com.sohainfotech.recyclerviewdatabindingdemosit.R;
import com.sohainfotech.recyclerviewdatabindingdemosit.click_listener.CustomClickListener;
import com.sohainfotech.recyclerviewdatabindingdemosit.databinding.ItemRowBinding;
import com.sohainfotech.recyclerviewdatabindingdemosit.model.DataModel;

import java.util.List;

// step6:
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> implements CustomClickListener {

    private List<DataModel> dataModelsList;
    private Context context;

    public DataAdapter(List<DataModel> dataModelsList, Context context) {
        this.dataModelsList = dataModelsList;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // data binding
        ItemRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_row, parent, false);

        return new DataViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        DataModel dataModel = dataModelsList.get(position);
        // data binding
        holder.itemRowBinding.setModel(dataModel);
        holder.bind(dataModel);
        holder.itemRowBinding.setItemClickListener(this);
    }

    @Override
    public int getItemCount() {
        return dataModelsList.size();
    }

    // click events will be fired here
    @Override
    public void cardClicked(DataModel dataModel) {
        Toast.makeText(context, "You clicked " + dataModel.androidName,
                Toast.LENGTH_LONG).show();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        // data binding
        public ItemRowBinding itemRowBinding;

        // for normal ViewHolder
        /*public DataViewHolder(@NonNull View itemView) {
            super(itemView);
        }*/

        // data binding
        public DataViewHolder(@NonNull ItemRowBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        // user defined method
        // data binding
        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.model, obj);
            itemRowBinding.executePendingBindings();
        }
    }
}
