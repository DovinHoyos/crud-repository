package com.dovindev.repository;


import com.dovindev.models.BaseEntity;
import com.dovindev.repository.exceptions.DuplicateRecordDataAccessException;
import com.dovindev.repository.exceptions.ReadDataAccessException;
import com.dovindev.repository.exceptions.WriteDataAccesException;

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


    public T getById(Integer id) throws ReadDataAccessException {

        if (id == null || id <= 0){
            throw new ReadDataAccessException("Id invalido: Debe ser mayor a cero.");
        }

        T result = null;
        for (T c : dataSource){
            if (c.getId() != null && c.getId().equals(id)){
               result = c;
               break;
            }
        }
        if (result == null){
            throw new ReadDataAccessException("Error: No existe registro con el id: " + id);
        }
        return result;
    }

    @Override
    public void save(T t) throws WriteDataAccesException{
        if (t == null){
            throw new WriteDataAccesException("Error al insertar un objeto null.");
        }
        if (dataSource.contains(t)){
            throw new DuplicateRecordDataAccessException("Error: El registro con id: " + t.getId() + " ya existe!");
        }
        this.dataSource.add(t);
    }

    @Override
    public void delete(Integer id) throws ReadDataAccessException {
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