package enumtype.unit;

public enum LengthUnit {
    MM(false, 1),
    CM(false, 10),
    M(true, 1000),
    YARD(false, 914.4),
    FOOT(false, 304.8),
    INCH(false, 25.4);

    private final boolean si;
    private final double mm;

    LengthUnit(boolean si, double mm) {
        this.si = si;
        this.mm = mm;
    }

    public boolean isSi() {
        return si;
    }

    public double getMm() {
        return mm;
    }
}
