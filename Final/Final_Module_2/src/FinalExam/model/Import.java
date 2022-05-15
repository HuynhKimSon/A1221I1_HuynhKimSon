package FinalExam.model;

public class Import extends Product {
    private double priceImport;
    private String countryImport;
    private double rateImport;

    public Import() {
    }

    public Import(int id, int code, String name, double price, int quality, String manufacturer, double priceImport, String countryImport, double rateImport) {
        super(id, code, name, price, quality, manufacturer);
        this.priceImport = priceImport;
        this.countryImport = countryImport;
        this.rateImport = rateImport;
    }

    public double getPriceImport() {
        return priceImport;
    }

    public void setPriceImport(double priceImport) {
        this.priceImport = priceImport;
    }

    public String getCountryImport() {
        return countryImport;
    }

    public void setCountryImport(String countryImport) {
        this.countryImport = countryImport;
    }

    public double getRateImport() {
        return rateImport;
    }

    public void setRateImport(double rateImport) {
        this.rateImport = rateImport;
    }

    @Override
    public String toString() {
        return super.toString() + priceImport + "," + countryImport + "," + rateImport;
    }
}
