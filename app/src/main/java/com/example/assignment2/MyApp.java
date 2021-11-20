package com.example.assignment2;

import android.app.Application;

public class MyApp extends Application {

    public StoreManager getManager(){
        return manager;
    }
    private StoreManager manager = new StoreManager();

//((MyApp) getApplication()).getManager();
}
