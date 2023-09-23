import com.dovindev.models.Client;
import com.dovindev.repository.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ExtendedRepository repository = new ClientListRepository();
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

        repository.getAll().forEach(System.out::println);
    }
}