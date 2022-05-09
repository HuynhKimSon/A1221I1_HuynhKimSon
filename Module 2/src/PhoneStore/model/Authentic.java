package PhoneStore.model;

public class Authentic extends Phone {
    private int granteeByYear;
    private String codeWarranty;

    public Authentic() {
    }

    public Authentic(String type, int id, String name, double price, String manufacturer, int granteeByYear, String codeWarranty) {
        super(type, id, name, price, manufacturer);
        this.granteeByYear = granteeByYear;
        this.codeWarranty = codeWarranty;
    }

    public int getGranteeByYear() {
        return granteeByYear;
    }

    public void setGranteeByYear(int granteeByYear) {
        this.granteeByYear = granteeByYear;
    }

    public String getCodeWarranty() {
        return codeWarranty;
    }

    public void setCodeWarranty(String codeWarranty) {
        this.codeWarranty = codeWarranty;
    }

    @Override
    public String toString() {
        return super.toString() + granteeByYear + "," + codeWarranty;
    }
}
