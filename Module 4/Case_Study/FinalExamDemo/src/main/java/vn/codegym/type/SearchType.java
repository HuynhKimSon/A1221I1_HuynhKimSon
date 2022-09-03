package vn.codegym.type;

public enum SearchType {
    NAME("NAME"), PHONE("PHONE"), TYPE("TYPE"), ID_CARD("ID_CARD"), ADDRESS("ADDRESS");

    private final String value;

    SearchType(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
