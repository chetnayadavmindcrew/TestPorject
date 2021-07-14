package com.testproject.firsttask;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.testproject.R;

import java.util.List;
import java.util.Random;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.MyViewHolder> {

    Context context;
    List<GridDataModel> gridDataModelList;
    CallBackClick callBackClick;
    int number;

    public GridAdapter(Context context, List<GridDataModel> gridDataModelList, CallBackClick callBackClick) {
        this.context = context;
        this.gridDataModelList = gridDataModelList;
        this.callBackClick = callBackClick;
        Random random = new Random();
        number = random.nextInt(gridDataModelList.size());
        gridDataModelList.get(number).setColor(Color.RED);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        GridDataModel gridDataModel = gridDataModelList.get(position);
        holder.button.setEnabled(false);
        holder.button.setBackgroundColor(gridDataModel.getColor());
        if (number == position && gridDataModel.getColor() != Color.BLUE) {
            gridDataModel.setColor(Color.RED);
            holder.button.setEnabled(true);
            number = gridDataModelList.size() + 1;
        } else if (gridDataModel.getColor() == Color.BLUE) {
            gridDataModel.setColor(Color.BLUE);
            holder.button.setEnabled(false);
        }
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gridDataModel.getColor() == Color.RED) {
                    gridDataModelList.get(position).setColor(Color.BLUE);
                    for (int i = 0; i < gridDataModelList.size(); i++) {
                        Random random = new Random();
                        number = random.nextInt(gridDataModelList.size());
                        if (gridDataModelList.get(number).getColor() == Color.WHITE) {
                            gridDataModelList.get(number).setColor(Color.RED);
                            break;
                        }
                    }
                }
                notifyDataSetChanged();
                if (gridDataModelList.get(number).getColor() == Color.BLUE)
                    callBackClick.buttonClick(gridDataModel);
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
