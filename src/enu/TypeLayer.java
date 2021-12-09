package enu;

public enum TypeLayer {
    INPUT("input"),
    HIDDEN("hidden"),
    OUTPUT("output");

    private String description;

    TypeLayer(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
