package com.dovindev.repository;


import com.dovindev.repository.exceptions.DataAccessException;

import java.util.List;

public interface CrudRepository<T> {

    List<T> getAll();
    T getById(Integer id ) throws DataAccessException;
    void save(T t) throws DataAccessException;
    void update(T t) throws DataAccessException;
    void delete(Integer id) throws DataAccessException;
}
