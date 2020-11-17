package algorithmssum.sales;

import java.util.List;

public class Salesperson {

    private String name;
    private int amount;

    public Salesperson(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Salesperson() {
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int sumSalesAmount(List<Salesperson> salespersons) {
        int sum = 0;
        for (Salesperson item: salespersons) {
            sum += item.getAmount();
        }
        return sum;

    }
}
