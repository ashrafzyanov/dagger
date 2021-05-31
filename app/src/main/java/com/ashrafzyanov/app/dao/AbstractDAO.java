package com.ashrafzyanov.app.dao;

import lombok.Getter;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractDAO<T> implements DAO<T> {

    @Getter
    private Class<T> clazz;

    public AbstractDAO() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }


}
