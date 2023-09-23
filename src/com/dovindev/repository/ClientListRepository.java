package com.dovindev.repository;

import com.dovindev.models.Client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientListRepository implements ExtendedRepository{

    private List<Client> dataSource;

    public ClientListRepository() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<Client> getAll() {
        return dataSource;
    }

    @Override
    public Client getById(Integer id) {

        Client client = null;
        for (Client c : dataSource){
            if (c.getId() != null && c.getId().equals(id)){
               client = c;
               break;
            }
        }
        return client;
    }

    @Override
    public void save(Client client) {
        this.dataSource.add(client);
    }

    @Override
    public void update(Client client) {
        Client c = this.getById(client.getId());
        c.setName(client.getName());
        c.setLastname(client.getLastname());
    }

    @Override
    public void delete(Integer id) {
        this.dataSource.remove(this.getById(id));
    }

    @Override
    public List<Client> getAll(String campo, Direction dir) {
        List<Client> orderedList = new ArrayList<>(this.dataSource);
        orderedList.sort((a, b) -> {
                    int result = 0;
                    if (dir == Direction.ASC){
                        result = ordenar(campo, a, b);
                    } else if (dir == Direction.DESC) {
                        result = ordenar(campo, b, a);
                    }
                    return result;

        });
        return orderedList;
    }

    @Override
    public List<Client> getAll(int from, int limit) {
        return dataSource.subList(from, limit);
    }

    public static int ordenar(String campo, Client a, Client b) {
        int result = 0;
        switch (campo){
            case "id" -> result = a.getId().compareTo(b.getId());
            case "name" -> result = a.getName().compareTo(b.getName());
            case "lastname" -> result = a.getLastname().compareTo(b.getLastname());
        }
        return result;
    }

    @Override
    public Integer count() {
        return this.dataSource.size();
    }
}
