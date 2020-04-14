package com.ashrafzyanov.testdagger.dao;

import java.util.List;

public interface DAO<T> {

    T findById(long id);

    List<T> findAll();

    void addNew(T entity);

    void update(T entity);

    void deleteById(T entity);

}
