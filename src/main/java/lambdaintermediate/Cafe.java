package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> orders = new ArrayList<>();

    public Cafe() {
    }

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public void addOrder(CoffeeOrder order) {
        orders.add(order);
    }

    public BigDecimal getTotalIncome() {
        return orders.stream()
                .flatMap(co -> co.getCoffeeList().stream())
                .map(c -> c.getPrice())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b), (a, b) -> a.add(b))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        return orders.stream()
                .filter(d -> d.getDateTime().toLocalDate().equals(date))
                .flatMap(co -> co.getCoffeeList().stream())
                .map(c -> c.getPrice())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b), (a, b) -> a.add(b))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return orders.stream()
                .flatMap(co -> co.getCoffeeList().stream())
                .map(c -> c.getType())
                .filter(ct -> ct.equals(type))
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return orders.stream()
                .filter(d -> d.getDateTime().isAfter(from))
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return orders.stream()
                .filter(d -> d.getDateTime().toLocalDate().equals(date))
                .sorted((d1, d2) -> d1.getDateTime().compareTo(d2.getDateTime()))
                .limit(5)
                .collect(Collectors.toList());
    }
}
