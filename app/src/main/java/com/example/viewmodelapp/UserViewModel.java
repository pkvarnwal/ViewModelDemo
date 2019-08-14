package com.example.viewmodelapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class UserViewModel extends ViewModel {

    private MutableLiveData<ArrayList<String>> names;

    public LiveData<ArrayList<String>> getUsers() {
        if (names == null) {
            names = new MutableLiveData<>();
            loadNames();
        }
        return names;
    }

    private void loadNames() {
        ArrayList<String> defaultNames = new ArrayList<>();
        defaultNames.add("Shree");
        defaultNames.add("ShreeVridhee");
        defaultNames.add("Tanishi");
        defaultNames.add("Akshara");
        defaultNames.add("Ammu");

        names.postValue(defaultNames);
    }

    public void addName(String name){
        names.getValue().add(name);
        names.postValue(names.getValue());
    }
}
