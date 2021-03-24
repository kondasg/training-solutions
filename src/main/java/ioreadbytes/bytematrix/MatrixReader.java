package ioreadbytes.bytematrix;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixReader {

    private final List<byte[]> myMatrix = new ArrayList<>();

    public List<byte[]> getMyMatrix() {
        return myMatrix;
    }

    public void readBytesAndCreateMatrix(String dataFile) {
        try (InputStream inputStream = new BufferedInputStream(Files.newInputStream(
                Path.of("src/main/resources/ioreadbytes/" + dataFile)))) {
            byte[] bytes = new byte[1000];
            while ((inputStream.read(bytes)) > 0) {
                myMatrix.add(bytes);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public int numberOfColumnsWhereMoreZeros() {
        int[] numberOfOne = new int[1000];
        for (byte[] matrix : myMatrix) {
            for (int j = 0; j < matrix.length; j++) {
                int x = Integer.parseInt(String.valueOf((char) matrix[j]));
                numberOfOne[j] += x;
            }
        }
        int col = 0;
        for (int item : numberOfOne) {
            if (item < 3) {
                col++;
            }
        }
        return col;
    }
}
