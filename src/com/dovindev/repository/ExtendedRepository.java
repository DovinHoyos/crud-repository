package com.dovindev.repository;

public interface ExtendedRepository<T> extends CrudRepository<T>, PaginableRepository<T>, OrdenableRepository<T>, ContableRepository{
}
