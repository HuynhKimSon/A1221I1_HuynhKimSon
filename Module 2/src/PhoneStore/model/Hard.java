package PhoneStore.model;

public class Hard extends Phone {
    private String country;
    private String status;

    public Hard() {
    }

    public Hard(String type, int id, String name, double price, String manufacturer, String country, String status) {
        super(type, id, name, price, manufacturer);
        this.country = country;
        status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        status = status;
    }

    @Override
    public String toString() {
        return super.toString() + country + "," + status;
    }
}
