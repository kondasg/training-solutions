package bill;

public class BillMain {

    public static void main(String[] args) {
        Item item1 = new Item("A", 100, 123.2);
        Item item2 = new Item("B", 143, 13.5);
        Item item3 = new Item("C", 200, 9.35);

        Bill bill = new Bill();
        bill.addItem(item1);
        bill.addItem(item2);
        bill.addItem(item3);

        System.out.println(bill.calculateTotalPrice());
    }
}
