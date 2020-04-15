package com.ashrafzyanov.testdagger;

import com.ashrafzyanov.testdagger.command.Command;
import com.ashrafzyanov.testdagger.command.imp.AddUser;
import com.ashrafzyanov.testdagger.command.imp.ShowAllUser;
import com.ashrafzyanov.testdagger.dao.UserDAO;
import com.ashrafzyanov.testdagger.dao.imp.UserDAOImpl;
import com.ashrafzyanov.testdagger.mapper.UserMapper;
import com.ashrafzyanov.testdagger.service.UserManager;
import com.ashrafzyanov.testdagger.service.impl.UserMangerImpl;
import com.ashrafzyanov.testdagger.storage.Storage;
import com.ashrafzyanov.testdagger.storage.impl.StorageImpl;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;

@Module
public class AppModule {

    @Provides @Singleton Storage provideStorage() {
        return new StorageImpl();
    }

    @Provides  @Singleton UserMapper provideUserMapper() {
        return UserMapper.INSTANCE;
    }

    @Provides  @Singleton UserDAO provideUserDAO(Storage storage) {
        return new UserDAOImpl(storage);
    }

    @Provides @Singleton UserManager provideUserManager(UserMapper userMapper, UserDAO userDAO) {
        return new UserMangerImpl(userMapper, userDAO);
    }

    @Provides  @Singleton AddUser provideAddUser(UserManager userManager) {
        return new AddUser(userManager);
    }

    @Provides  @Singleton ShowAllUser provideShowAllUser(UserManager userManager) {
        return new ShowAllUser(userManager);
    }

    @Provides @Singleton List<Command> provideListCommand(AddUser addUser, ShowAllUser showAllUser) {
        return Arrays.asList(addUser, showAllUser);
    }

}
