package com.dovindev.repository;


import java.util.List;

public interface CrudRepository<T> {

    List<T> getAll();
    T getById(Integer id);
    void save(T t);
    void update(T t);
    void delete(Integer id);
}
