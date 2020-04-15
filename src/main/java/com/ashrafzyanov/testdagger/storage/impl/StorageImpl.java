package com.ashrafzyanov.testdagger.storage.impl;

import com.ashrafzyanov.testdagger.model.BaseModel;
import com.ashrafzyanov.testdagger.storage.Storage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class StorageImpl implements Storage {

    private List<BaseModel> data = new ArrayList<>();
    private AtomicLong atomicLong = new AtomicLong(0);

    public void add(BaseModel obj) {
        obj.setId(atomicLong.incrementAndGet());
        data.add(obj);
    }

    public void delete(BaseModel obj) {
        data.remove(obj);
    }

    public void update(BaseModel obj) {
        if (obj.getId() == null) {
            add(obj);
            return;
        }
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
