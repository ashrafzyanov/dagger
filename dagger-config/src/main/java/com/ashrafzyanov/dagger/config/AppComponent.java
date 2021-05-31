package com.ashrafzyanov.dagger.config;

import com.ashrafzyanov.app.MainApp;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    MainApp getApp();
}
