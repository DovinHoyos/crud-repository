package com.dovindev.repository;

import com.dovindev.models.Client;

import java.util.List;

public interface OrdenableRepository {

    List<Client> getAll(String campo, Direction dir);
}
