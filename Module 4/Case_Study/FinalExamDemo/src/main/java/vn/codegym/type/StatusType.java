package vn.codegym.type;

public enum StatusType {
    FAIL(0), SUCCESS(200);

    private final Integer value;

    StatusType(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return this.value;
    }
}
