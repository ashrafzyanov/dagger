package com.ashrafzyanov.testdagger;

import com.ashrafzyanov.testdagger.command.Command;
import com.ashrafzyanov.testdagger.service.UserManager;
import com.ashrafzyanov.testdagger.storage.Storage;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {AppModule.class})
@Singleton
interface AppComponent {
    App getApp();
}
