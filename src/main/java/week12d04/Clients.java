package week12d04;

import java.util.ArrayList;
import java.util.List;

public class Clients {

    List<Client> clients = new ArrayList<>();

    public Clients(List<Client> clients) {
        this.clients = clients;
    }

    public String findByRegNumber(String regNumber) {
        for (Client client: clients) {
            if (client.getRegNumber().equals(regNumber)) {
                return client.getName();
            }
        }
        throw new IllegalArgumentException();
    }

    public List<Client> findByName(String name) {
        List<Client> result = new ArrayList<>();
        for (Client client: clients) {
            if (client.getName().contains(name)) {
                result.add(client);
            }
        }
        return result;
    }


}
