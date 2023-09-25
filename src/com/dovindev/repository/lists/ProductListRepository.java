package com.dovindev.repository.lists;

import com.dovindev.models.Product;
import com.dovindev.repository.ListRepository;
import com.dovindev.repository.Direction;
import com.dovindev.repository.exceptions.ReadDataAccessException;

import java.util.ArrayList;
import java.util.List;

public class ProductListRepository extends ListRepository<Product> {

    @Override
    public void update(Product product) throws ReadDataAccessException {
        Product p = getById(product.getId());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
    }

    @Override
    public List<Product> getAll(String campo, Direction dir) {
        List<Product> orderedList = new ArrayList<>(this.dataSource);
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

    public static int toOrder(String campo, Product a, Product b) {
        int result = 0;
        switch (campo){
            case "id" -> result = a.getId().compareTo(b.getId());
            case "description" -> result = a.getDescription().compareTo(b.getDescription());
            case "price" -> result = a.getPrice().compareTo(b.getPrice());
        }
        return result;
    }
}
