package week16d01;

import java.time.LocalDateTime;
import java.util.*;

public class CanoeOffice {

    private final List<CanoeRental> canoes = new ArrayList<>();
    private final static double PRICE_PER_HOUR = 5000;

    public void createRental(CanoeRental canoeRental) {
        canoes.add(canoeRental);
    }

    public CanoeRental findRentalByName(String name) {
        for (CanoeRental canoeRental : canoes) {
            if (name.equals(canoeRental.getName()) && canoeRental.getEndTime() == null) {
                return canoeRental;
            }
        }
        throw new IllegalArgumentException("Nincs ilyen AKTÍV kölcsönzés");
    }

    public CanoeRental closeRentalByName(String name, LocalDateTime endTime) {
        CanoeRental canoeRental = findRentalByName(name);
        canoeRental.setEndTime(endTime);
        return canoeRental;
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        CanoeRental canoeRental = closeRentalByName(name, endTime);
        return PRICE_PER_HOUR * canoeRental.calculateRentalSum() * canoeRental.getCanoeType().getMultiplier();
    }

    public List<CanoeRental> listClosedRentals() {
        List<CanoeRental> result = new ArrayList<>();
        for (CanoeRental canoeRental : canoes) {
            if (canoeRental.getEndTime() != null) {
                result.add(canoeRental);
            }
        }
        result.sort(new Comparator<CanoeRental>() {
            @Override
            public int compare(CanoeRental o1, CanoeRental o2) {
                return o2.getStartTime().compareTo(o1.getStartTime());
            }
        });
        return result;
    }

    public Map<CanoeType, Integer> countRentals() {
        Map<CanoeType, Integer> result = new HashMap<>();
        for (CanoeRental canoeRental : canoes) {
            CanoeType ct = canoeRental.getCanoeType();
            if (result.containsKey(ct)) {
                result.put(ct, result.get(ct) + 1);
            }
            else {
                result.put(ct, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CanoeOffice co =  new CanoeOffice();

        co.createRental(new CanoeRental("1", CanoeType.RED, "1"));
        co.createRental(new CanoeRental("2", CanoeType.BLUE, "2"));
        co.createRental(new CanoeRental("3", CanoeType.RED, "3"));
        co.createRental(new CanoeRental("4", CanoeType.GREEN, "4"));
        co.createRental(new CanoeRental("5", CanoeType.BLUE, "5"));
        co.createRental(new CanoeRental("6", CanoeType.RED, "6"));

        System.out.println();
        System.out.println(co.findRentalByName("1"));

        System.out.println();
        System.out.println(co.closeRentalByName("2", LocalDateTime.now()));

        System.out.println();
        System.out.println(co.getRentalPriceByName("4", LocalDateTime.now()));

        System.out.println();
        System.out.println(co.listClosedRentals());

        System.out.println();
        System.out.println(co.countRentals());
    }
}
