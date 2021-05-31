package com.ashrafzyanov.launch;

import com.ashrafzyanov.app.MainApp;
import com.ashrafzyanov.dagger.config.DaggerAppComponent;

public class App {

    public static void main( String[] args ) {
        MainApp app = DaggerAppComponent.create().getApp();
        app.startApp(args);
    }

}
