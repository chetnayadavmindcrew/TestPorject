package com.testproject.firsttask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.testproject.R;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {

    Context context;
    List<GridDataModel> gridDataModelList;
    CallBackClick callBackClick;

    public GridAdapter(Context context, List<GridDataModel> gridDataModelList, CallBackClick callBackClick) {
        this.context = context;
        this.gridDataModelList = gridDataModelList;
        this.callBackClick = callBackClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GridDataModel gridDataModel = gridDataModelList.get(position);
        holder.button.setBackgroundColor(gridDataModel.getColor());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return gridDataModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.color_button);
        }
    }
}
