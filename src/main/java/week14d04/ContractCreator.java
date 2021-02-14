package week14d04;

import java.util.ArrayList;
import java.util.List;

public class ContractCreator {

    private final Contract template;

    public ContractCreator(String client, List<Integer> monthlyPrices) {
        this.template = new Contract(client, monthlyPrices);
    }

    public Contract getTemplate() {
        return template;
    }

    public Contract create(String name) {
        return new Contract(name, new ArrayList<>(template.getMonthlyPrices()));
    }

    public static void main(String[] args) {
// UnsupportedOperationException csak a List.of miatt (módosíthattalan lista), tegyük new ArrayList<>()-be

        ContractCreator cc = new ContractCreator("Abc", List.of(11,12,13,14));
        System.out.println(cc.template);

        Contract newCc = cc.create("Joe");
        newCc.getMonthlyPrices().set(1, 20);

        System.out.println(newCc);
        System.out.println(cc.template);
    }
}
