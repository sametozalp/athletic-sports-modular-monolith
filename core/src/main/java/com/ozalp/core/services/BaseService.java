package com.ozalp.core.services;

import com.ozalp.core.models.entites.BaseEntity;

public interface BaseService<T extends BaseEntity> {

    T findById(int id);

    T add(T t);

    void delete(int id);
}
