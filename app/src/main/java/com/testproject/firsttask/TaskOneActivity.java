package com.testproject.firsttask;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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
    static List<GridDataModel> gridDataModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_one);
        ActivityTaskOneBinding activityTaskOneBinding = DataBindingUtil.setContentView(this, R.layout.activity_task_one);
        activityTaskOneBinding.setTaskOneViewModel(new TaskOneViewModel());
        recyclerView = activityTaskOneBinding.recyclerView;
        context = this;
        callBackClick = this;
    }

    @BindingAdapter({"gridNumber"})
    public static void setData(View view, int numberofColum) {
        String number = String.valueOf(Math.sqrt((double) numberofColum));
        int numCol;
        if (number != null && number.contains(".0")) {
            String str = number.replace(".0", "");
            numCol = Integer.parseInt(str);
        } else {
            numCol = 0;
        }
        if (numberofColum > 0 && numCol > 0) {
            recyclerView.setLayoutManager(new GridLayoutManager(context, numCol, LinearLayoutManager.VERTICAL, false));
            gridDataModelList = new ArrayList<>();
            for (int i = 0; i < numberofColum; i++) {
                gridDataModelList.add(new GridDataModel(Color.WHITE));
            }
            gridAdapter = new GridAdapter(context, gridDataModelList, callBackClick);
            recyclerView.setAdapter(gridAdapter);
        } else {
            Toast.makeText(context, "Not an perfect square root", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void buttonClick(GridDataModel gridDataModel) {
        /*gridAdapter = new GridAdapter(context, gridDataModelList, callBackClick);
        recyclerView.setAdapter(gridAdapter);*/
        AlertDialog.Builder alert = new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("You won the game")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        alert.show();
    }
}