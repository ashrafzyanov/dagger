package com.ashrafzyanov.app.storage;

import com.ashrafzyanov.app.model.BaseModel;

import java.util.List;

public interface Storage {

    void add(BaseModel obj);
    void delete(BaseModel obj);
    void update(BaseModel obj);
    <T> T get(Long id, Class<T> clazz);
    <T> List<T> getAll(Class<T> clazz);

}
