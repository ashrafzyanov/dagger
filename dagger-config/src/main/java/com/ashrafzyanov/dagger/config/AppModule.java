package com.ashrafzyanov.dagger.config;

import com.ashrafzyanov.app.MainApp;
import com.ashrafzyanov.app.command.Command;
import com.ashrafzyanov.app.command.imp.AddUser;
import com.ashrafzyanov.app.command.imp.ShowAllUser;
import com.ashrafzyanov.app.dao.UserDAO;
import com.ashrafzyanov.app.dao.imp.UserDAOImpl;
import com.ashrafzyanov.app.mapper.UserMapper;
import com.ashrafzyanov.app.service.UserManager;
import com.ashrafzyanov.app.service.impl.UserMangerImpl;
import com.ashrafzyanov.app.storage.Storage;
import com.ashrafzyanov.app.storage.impl.StorageImpl;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;

@Module
public class AppModule {

    @Provides
    @Singleton
    Storage provideStorage() {
        return new StorageImpl();
    }

    @Provides  @Singleton
    UserMapper provideUserMapper() {
        return UserMapper.INSTANCE;
    }

    @Provides  @Singleton
    UserDAO provideUserDAO(Storage storage) {
        return new UserDAOImpl(storage);
    }

    @Provides @Singleton
    UserManager provideUserManager(UserMapper userMapper, UserDAO userDAO) {
        return new UserMangerImpl(userMapper, userDAO);
    }

    @Provides  @Singleton
    AddUser provideAddUser(UserManager userManager) {
        return new AddUser(userManager);
    }

    @Provides  @Singleton
    ShowAllUser provideShowAllUser(UserManager userManager) {
        return new ShowAllUser(userManager);
    }

    @Provides @Singleton
    List<Command> provideListCommand(AddUser addUser, ShowAllUser showAllUser) {
        return Arrays.asList(addUser, showAllUser);
    }

    @Provides @Singleton
    MainApp provideApp(List<Command> commands) {
        return new MainApp(commands);
    }

}
