package week11d01;

public class NumCount {

    private final int number;
    private int count;

    public NumCount(int number) {
        this.number = number;
        this.count = 1;
    }

    public int getNumber() {
        return number;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count++;
    }
}
