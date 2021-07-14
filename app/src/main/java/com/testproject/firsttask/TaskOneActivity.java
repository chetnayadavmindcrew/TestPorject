package com.testproject.firsttask;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.testproject.R;
import com.testproject.databinding.ActivityTaskOneBinding;

import java.util.ArrayList;
import java.util.List;

public class TaskOneActivity extends AppCompatActivity implements CallBackClick {

    static RecyclerView recyclerView;
    static GridAdapter gridAdapter;
    static Context context;
    static CallBackClick callBackClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_one);
        recyclerView = findViewById(R.id.recycler_view);
        ActivityTaskOneBinding activityTaskOneBinding = DataBindingUtil.setContentView(this, R.layout.activity_task_one);
        activityTaskOneBinding.setTaskOneViewModel(new TaskOneViewModel());
        context = this;
        callBackClick = this;

        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        List<GridDataModel> gridDataModelList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            gridDataModelList.add(new GridDataModel(Color.WHITE));
        }
        gridAdapter = new GridAdapter(context, gridDataModelList, callBackClick);
        recyclerView.setAdapter(gridAdapter);
    }

    @BindingAdapter({"gridNumber"})
    public static void setData(View view, int numberofColum) {
        if (numberofColum > 0) {
            recyclerView.setLayoutManager(new GridLayoutManager(context, numberofColum));
            List<GridDataModel> gridDataModelList = new ArrayList<>();
            for (int i = 0; i < numberofColum; i++) {
                gridDataModelList.add(new GridDataModel(Color.WHITE));
            }
            gridAdapter = new GridAdapter(context, gridDataModelList, callBackClick);
            recyclerView.setAdapter(gridAdapter);
        }
    }

    @Override
    public void buttonClick(GridDataModel gridDataModel) {

        //gridAdapter = new GridAdapter(this, gridDataModelList, this);
        recyclerView.setAdapter(gridAdapter);
    }
}