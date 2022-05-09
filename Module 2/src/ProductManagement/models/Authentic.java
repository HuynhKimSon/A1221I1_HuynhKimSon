package ProductManagement.models;

public class Authentic extends Product {
    private String warrantyPeriod;

    public Authentic() {
    }

    public Authentic(int id, String productName, String price, String producer, String warrantyPeriod) {
        super(id, productName, price, producer);
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return super.toString()
                + warrantyPeriod;
    }
}
