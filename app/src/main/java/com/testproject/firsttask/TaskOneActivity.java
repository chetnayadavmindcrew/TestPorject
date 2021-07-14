package com.testproject.firsttask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.testproject.R;
import com.testproject.databinding.ActivityTaskOneBinding;

public class TaskOneActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_one);
        recyclerView = findViewById(R.id.recycler_view);
        ActivityTaskOneBinding activityTaskOneBinding = DataBindingUtil.setContentView(this, R.layout.activity_task_one);
        activityTaskOneBinding.setTaskOneViewModel(new TaskOneViewModel());
    }


}