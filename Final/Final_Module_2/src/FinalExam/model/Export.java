package FinalExam.model;

public class Export extends Product {
    private double priceExport;
    private String countryImportProduct;

    public Export() {
    }

    public Export(int id, int code, String name, double price, int quality, String manufacturer, double priceExport, String countryImportProduct) {
        super(id, code, name, price, quality, manufacturer);
        this.priceExport = priceExport;
        this.countryImportProduct = countryImportProduct;
    }

    public double getPriceExport() {
        return priceExport;
    }

    public void setPriceExport(double priceExport) {
        this.priceExport = priceExport;
    }

    public String getCountryImportProduct() {
        return countryImportProduct;
    }

    public void setCountryImportProduct(String countryImportProduct) {
        this.countryImportProduct = countryImportProduct;
    }

    public String toString() {
        return super.toString() + priceExport + "," + countryImportProduct;
    }
}
