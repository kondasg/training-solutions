package typeconversion.whichtype;

public enum Type {
    BYTE(Byte.MIN_VALUE, Byte.MAX_VALUE),
    SHORT(Short.MIN_VALUE, Short.MAX_VALUE),
    INT(Integer.MIN_VALUE, Integer.MAX_VALUE);

    private final long longMin;
    private final long longMax;

    Type(long longMin, long longMax) {
        this.longMin = longMin;
        this.longMax = longMax;
    }

    public long getLongMin() {
        return longMin;
    }

    public long getLongMax() {
        return longMax;
    }
}
