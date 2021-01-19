package week12d02;

public class FenceStat {

    private final Fence fence;
    private int number;

    public FenceStat(Fence fence, int number) {
        this.fence = fence;
        this.number = number;
    }

    public Fence getFence() {
        return fence;
    }

    public int getNumber() {
        return number;
    }


    public void setNumber() {
        this.number++;
    }

    @Override
    public String toString() {
        return
                "fence=" + fence +
                        ", number=" + number +
                        '}';
    }
}