package ioconvert.products;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class ProductWriter {

    public void saveProduct(OutputStream outputStream, List<Product> products) {
        try (PrintStream printStream = new PrintStream(new BufferedOutputStream(outputStream))) {
            for (Product product : products) {
                printStream.println(product.getName() + ";" + product.getPrice());
            }
        }
    }
}
