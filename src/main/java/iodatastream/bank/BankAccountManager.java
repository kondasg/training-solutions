package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount account, Path path) {
        Path file = path.resolve(account.getAccountNumber() + ".dat");
        try (DataOutputStream dataOutputStream =
                     new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            dataOutputStream.writeUTF(account.getAccountNumber());
            dataOutputStream.writeUTF(account.getOwner());
            dataOutputStream.writeDouble(account.getBalance());
        } catch (IOException e) {
            throw new IllegalStateException("Can't write file", e);
        }
    }

    public BankAccount loadAccount(InputStream is) {
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(is))) {
            return new BankAccount(dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readDouble());
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }
}
