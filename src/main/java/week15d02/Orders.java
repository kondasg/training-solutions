package week15d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Orders {

    private final List<Order> orders = new ArrayList<>();
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");

    private void loadFile(BufferedReader reader) {
        try {
            String line;
            LocalDate date = LocalDate.of(1111, 11, 11);
            while ((line = reader.readLine()) != null) {
                if (line.contains(".") && line.length() == 10) {
                    date = LocalDate.parse(line, formatDate);
                } else {
                    readOrder(reader, line, date);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file", ioe);
        }
    }

    private void readOrder(BufferedReader reader, String line, LocalDate date) throws IOException {
        String line2 = reader.readLine();
        String[] splittedLine2 = line2.split(" ");
        LocalTime time = LocalTime.parse(splittedLine2[3], formatTime);
        orders.add(new Order(date, time, line, splittedLine2[0], splittedLine2[1] + " " + splittedLine2[2]));
    }

    public LocalDate findLeastOrders() {
        Map<LocalDate, Integer> ordersByDate = new HashMap<>();
        for (Order order : orders) {
            if (ordersByDate.containsKey(order.getDate())) {
                ordersByDate.put(order.getDate(), ordersByDate.get(order.getDate()) + 1);
            } else {
                ordersByDate.put(order.getDate(), 1);
            }
        }
        return searchMinDate(ordersByDate);
    }

    private LocalDate searchMinDate(Map<LocalDate, Integer> ordersByDate) {
        LocalDate minDate = LocalDate.MAX;
        Integer min = Integer.MAX_VALUE;
        for (Map.Entry<LocalDate, Integer> entry : ordersByDate.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                minDate = entry.getKey();
            }
        }
        return minDate;
    }

    public String searchOrders(String date, String time) {
        for (Order order : orders) {
            if (order.getDate().equals(LocalDate.parse(date, formatDate))
                    && order.getTime().equals(LocalTime.parse(time, formatTime))) {
                return order.toString();
            }
        }
        return "Nincs ilyen rendelés!";
    }

    public void searchForNumberOfOrdersPerCourier() {
        Map<String, Integer> numberOfOrdersPerCourier = new TreeMap<>();
        for (Order order : orders) {
            if (numberOfOrdersPerCourier.containsKey(order.getCourier())) {
                numberOfOrdersPerCourier.put(order.getCourier(), numberOfOrdersPerCourier.get(order.getCourier()) + 1);
            } else {
                numberOfOrdersPerCourier.put(order.getCourier(), 1);
            }
        }
        printCourierByNumberOfOrders(numberOfOrdersPerCourier);
    }

    private void printCourierByNumberOfOrders(Map<String, Integer> numberOfOrdersPerCourier) {
        for (Map.Entry<String, Integer> entry : numberOfOrdersPerCourier.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public String mostPizza() {
        Map<String, Integer> ordersByAddress = new HashMap<>();
        for (Order order : orders) {
            if (ordersByAddress.containsKey(order.getAddress())) {
                ordersByAddress.put(order.getAddress(), ordersByAddress.get(order.getAddress()) + 1);
            } else {
                ordersByAddress.put(order.getAddress(), 1);
            }
        }
        return searchMaxAddress(ordersByAddress);
    }

    private String searchMaxAddress(Map<String, Integer> ordersByAddress) {
        String maxAddress = "";
        Integer max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : ordersByAddress.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxAddress = entry.getKey();
            }
        }
        return maxAddress;
    }

    public static void main(String[] args) {
        Orders orders = new Orders();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Orders.class.getResourceAsStream("orders.txt")))) {
            orders.loadFile(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }

        System.out.println("1. Melyik napon volt a legkevesebb rendelés?");
        System.out.println(orders.findLeastOrders());
        System.out.println();

        System.out.println("2. Egy metódus várjon paraméterül egy dátumot, pontos időponttal és adjuk vissza a hozzá tartozó rendelést. Ha nincs ilyen akkor dobjunk kivételt. (Vagy Optional)");
        System.out.println(orders.searchOrders("2020.12.02", "10:30"));
        System.out.println();

        System.out.println("3. Készíts statisztikát a futárok szállításiból, futáronként add vissza, hogy mennyi rendelést teljesítettek.");
        orders.searchForNumberOfOrdersPerCourier();
        System.out.println();

        System.out.println("4. Melyik címre szállították a legtöbb pizzát?");
        System.out.println(orders.mostPizza());
    }


}
