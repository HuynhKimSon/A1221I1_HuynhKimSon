package Bank.model;

public abstract class Account {
    private int id;
    private int code;
    private String name;
    private String createDate;

    public Account() {
    }

    public Account(int id, int code, String name, String createDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return id + ","
                + code + ","
                + name + ","
                + createDate + ",";
    }
}
