import com.dovindev.models.Client;
import com.dovindev.models.Product;
import com.dovindev.repository.*;
import com.dovindev.repository.lists.ClientListRepository;
import com.dovindev.repository.lists.ProductListRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*ExtendedRepository<Client> repository = new ClientListRepository();
        repository.save(new Client("Dovin", "Hoyos"));
        repository.save(new Client("Gisel", "Manquillo"));
        repository.save(new Client("Felipe", "Arboleda"));
        repository.save(new Client("Santiago", "Hoyos"));
        repository.save(new Client("Enelia", "Velazco"));
        repository.save(new Client("Nixon", "Bermudez"));
        repository.save(new Client("Tatiana", "Ijaji"));
        repository.save(new Client("Sharit", "Ijaji"));

        List<Client> clients = repository.getAll();
        clients.forEach(System.out::println);

        repository.delete(1);

        System.out.println("------ORDENAR------");
        List<Client> ordenar = repository.getAll("lastname", Direction.ASC);
        ordenar.forEach(System.out::println);

        System.out.println("------PAGINAR------");
        List<Client> paginar = repository.getAll(1,4);
        paginar.forEach(System.out::println);


        System.out.println("------CONTAR------");
        System.out.println(repository.count());

        System.out.println("------EDITAR------");
        Client clientUpdate = new Client("Gisel", "Victoria");
        clientUpdate.setId(2);
        repository.update(clientUpdate);

        repository.getAll().forEach(System.out::println);*/

        System.out.println("------------Products------------");
        ExtendedRepository<Product> repoProducts = new ProductListRepository();
        repoProducts.save(new Product("Pc Gamer", 1200));
        repoProducts.save(new Product("Screen Asus 90Hz", 650));
        repoProducts.save(new   Product("Logitech mechanical keyboard", 85));
        repoProducts.save(new Product("Logitech mouse 8000Dpi", 55));

        List<Product> products = repoProducts.getAll(0, 3);
        products.forEach(System.out::println);

        System.out.println("Productos registrados: " + repoProducts.count());

        Product productUpdated = new Product("Pc Gamer intel i9 11900k", 2000);
        productUpdated.setId(1);
        repoProducts.update(productUpdated);
        repoProducts.getAll().forEach(System.out::println);
    }
}