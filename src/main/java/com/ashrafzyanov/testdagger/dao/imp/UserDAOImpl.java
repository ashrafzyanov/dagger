package com.ashrafzyanov.testdagger.dao.imp;

import com.ashrafzyanov.testdagger.dao.AbstractDAO;
import com.ashrafzyanov.testdagger.dao.UserDAO;
import com.ashrafzyanov.testdagger.model.User;
import com.ashrafzyanov.testdagger.storage.Storage;

import javax.inject.Inject;
import java.util.List;

public final class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

    private Storage storage;

    @Inject
    public UserDAOImpl(Storage storage) {
        this.storage = storage;
    }

    public User findById(long id) {
        return (User)storage.get(id, getClazz());
    }

    public List<User> findAll() {
        return storage.getAll(getClazz());
    }

    public void addNew(User entity) {
        storage.add(entity);
    }

    public void update(User entity) {
        storage.update(entity);
    }

    public void deleteById(User entity) {
        storage.delete(entity);
    }

}
