package FinalExam.utils;

public interface ConstantUtil {
    interface PATH {
        String PRODUCTS = "src/FinalExam/data/products.csv";
    }

    interface PROPERTIES {
        String CODE = "Mã sản phẩm";
        String NAME = "Tên sản phẩm";
        String PRICE = "Giá bán";
        String QUALITY = "Số lượng";
        String MANUFACTURER = "Nhà sản xuất";

        //Import
        String PRICE_IMPORT = "Giá nhập sản phẩm";
        String COUNTRY_IMPORT = "Tỉnh thành nhập";
        String RATE_IMPORT = "Thuế nhập khẩu";

        // Export
        String PRICE_EXPORT = "Giá xuất khẩu";
        String COUNTRY_IMPORT_PRODUCT = "Quốc gia nhập sản phẩm";
    }

}
