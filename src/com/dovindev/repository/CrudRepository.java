package com.dovindev.repository;

import com.dovindev.models.Client;

import java.util.List;

public interface CrudRepository {

    List<Client> getAll();
    Client getById(Integer id);
    void save(Client client);
    void update(Client client);
    void delete(Integer id);
}
