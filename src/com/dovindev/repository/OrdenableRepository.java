package com.dovindev.repository;


import java.util.List;

public interface OrdenableRepository<T> {

    List<T> getAll(String campo, Direction dir);
}
