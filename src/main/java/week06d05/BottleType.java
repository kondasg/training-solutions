package week06d05;

public enum BottleType {

    GLASS_BOTTLE(300),
    PET_BOTTLE(200);

    private final int maximumAmount;

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}
