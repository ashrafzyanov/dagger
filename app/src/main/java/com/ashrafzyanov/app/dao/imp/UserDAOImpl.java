package com.ashrafzyanov.app.dao.imp;

import com.ashrafzyanov.app.dao.AbstractDAO;
import com.ashrafzyanov.app.dao.UserDAO;
import com.ashrafzyanov.app.model.User;
import com.ashrafzyanov.app.storage.Storage;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public final class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

    private final Storage storage;

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
