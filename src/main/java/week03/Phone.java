package week03;

public class Phone {

    private String areaNumber;
    private String number;

    public Phone(String areaNumber, String number) {
        this.areaNumber = areaNumber;
        this.number = number;
    }

    public String getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(String areaNumber) {
        this.areaNumber = areaNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "+36 " + '\'' + areaNumber + '\'' + number;
    }
}
