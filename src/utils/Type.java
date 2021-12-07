package utils;

public enum Type implements java.lang.reflect.Type {
    INPUT(1), HIDDEN(2), OUTPUT(3);

    Type(int i) {
    }

    @Override
    public String getTypeName() {
        return java.lang.reflect.Type.super.getTypeName();
    }
}
