package ProductManagement.models;

public class HandCarry extends Product {
    private String nation;
    private String status;

    public HandCarry() {
    }

    public HandCarry(int id, String productName, String price, String producer, String nation, String status) {
        super(id, productName, price, producer);
        this.nation = nation;
        this.status = status;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString()
                + nation + ","
                + status;
    }
}
