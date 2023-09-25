package com.dovindev.repository;


import com.dovindev.models.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class ListRepository<T extends BaseEntity> implements ExtendedRepository<T>{

    protected List<T> dataSource;

    public ListRepository() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> getAll() {
        return dataSource;
    }


    public T getById(Integer id) {
        T client = null;
        for (T c : dataSource){
            if (c.getId() != null && c.getId().equals(id)){
               client = c;
               break;
            }
        }
        return client;
    }

    @Override
    public void save(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void delete(Integer id) {
        this.dataSource.remove(this.getById(id));
    }

    @Override
    public List<T> getAll(int from, int limit) {
        return dataSource.subList(from, limit);
    }

    @Override
    public Integer count() {
        return this.dataSource.size();
    }
}