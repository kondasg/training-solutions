package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {

    public void saveTransactions(Path file, List<Transaction> transactions) {
        try (ZipOutputStream zipOutputStream =
                     new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            for (Transaction transaction : transactions) {
                zipOutputStream.putNextEntry(new ZipEntry(transaction.getId() + ""));
                zipOutputStream.write((transaction.getTime() + "\n" +
                        transaction.getAccount() + "\n" + transaction.getAmount()).getBytes());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't write zip file", e);
        }
    }
}
