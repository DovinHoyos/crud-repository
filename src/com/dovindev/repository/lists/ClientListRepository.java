package com.dovindev.repository.lists;

import com.dovindev.models.Client;
import com.dovindev.repository.ListRepository;
import com.dovindev.repository.Direction;

import java.util.ArrayList;
import java.util.List;

public  class ClientListRepository extends ListRepository<Client> {

    @Override
    public void update(Client client) {
        Client c = this.getById(client.getId());
        c.setName(client.getName());
        c.setLastname(client.getLastname());
    }

    @Override
    public List<Client> getAll(String campo, Direction dir) {
        List<Client> orderedList = new ArrayList<>(this.dataSource);
        orderedList.sort((a, b) -> {
                    int result = 0;
                    if (dir == Direction.ASC){
                        result = toOrder(campo, a, b);
                    } else if (dir == Direction.DESC) {
                        result = toOrder(campo, b, a);
                    }
                    return result;

        });
        return orderedList;
    }

    public static int toOrder(String campo, Client a, Client b) {
        int result = 0;
        switch (campo){
            case "id" -> result = a.getId().compareTo(b.getId());
            case "name" -> result = a.getName().compareTo(b.getName());
            case "lastname" -> result = a.getLastname().compareTo(b.getLastname());
        }
        return result;
    }
}
