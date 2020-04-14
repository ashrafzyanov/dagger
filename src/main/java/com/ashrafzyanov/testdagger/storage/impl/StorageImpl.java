package com.ashrafzyanov.testdagger.storage.impl;

import com.ashrafzyanov.testdagger.model.BaseModel;
import com.ashrafzyanov.testdagger.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class StorageImpl implements Storage {

    private List<BaseModel> data = new ArrayList<>();

    public void add(BaseModel obj) {
        data.add(obj);
    }

    public void delete(BaseModel obj) {
        data.remove(obj);
    }

    public void update(BaseModel obj) {
        if (data.contains(obj)) {
            data.remove(obj);
            data.add(obj);
        }
    }

    public <T> T get(Long id, Class<T> clazz) {
        return (T)data.stream().filter(e -> e.getId().equals(id)).findFirst().get();
    }

    public <T> List<T> getAll(Class<T> clazz) {
        return (List<T>) data;
    }

}
