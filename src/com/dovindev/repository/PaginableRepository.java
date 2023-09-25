package com.dovindev.repository;


import java.util.List;

public interface PaginableRepository<T> {

    List<T> getAll(int from, int limit );
}
