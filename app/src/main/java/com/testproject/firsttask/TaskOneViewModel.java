package com.testproject.firsttask;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.testproject.BR;

public class TaskOneViewModel extends BaseObservable {
    GridDataModel gridDataModel;
    @Bindable
    String searchValue;
    @Bindable
    int gridNumber;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
        notifyPropertyChanged(BR.searchValue);
    }

    public int getGridNumber() {
        return gridNumber;
    }

    public void setGridNumber(int gridNumber) {
        this.gridNumber = gridNumber;
        notifyPropertyChanged(BR.gridNumber);
    }

    public void clickButton() {
        if (searchValue != null && !searchValue.equalsIgnoreCase("")) {
            setGridNumber(Integer.parseInt(searchValue));
        }
    }

    public static void setMyAdapter(GridAdapter gridAdapter) {

    }
}
