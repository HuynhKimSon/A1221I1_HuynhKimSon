package FinalExam.view;

import FinalExam.model.Export;
import FinalExam.model.Import;
import FinalExam.model.Product;
import FinalExam.service.ProductService;
import FinalExam.utils.CommonUtil;
import FinalExam.utils.ConstantUtil;
import FinalExam.utils.Validation;

import java.util.List;


public class ProductView {
    private static final ProductService productService = new ProductService();
    private static int choice;

    public static void main(String[] args) {
        while (true) {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ---");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách sản phẩm");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");

            System.out.print("Chọn: ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    List<Product> products = productService.findAll();
                    display(products);
                    break;
                case 4:
                    searchByCode();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("---> Vui lòng chọn từ 1 -> 5");
                    break;
            }
        }
    }

    private static void searchByCode() {
        System.out.println("---TÌM KIẾM SẢN PHẨM---");
        int code = Integer.parseInt(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.CODE));
        List<Product> findList = productService.searchByCode(code);
        if (Validation.isExitsProduct(code)) {
            display(findList);
        } else {
            System.out.println("Không tìm thấy Mã sản phẩm " + code);
        }
    }

    private static void delete() {
        List<Product> products = productService.findAll();
        display(products);
        System.out.println("---XÓA SẢN PHẨM---");
        int code = Integer.parseInt(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.CODE));
        do {
            System.out.println("1. Có");
            System.out.println("2. Không");
            System.out.print("Chọn: ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    boolean isExists;
                    do {
                        try {
                            productService.delete(code);
                            System.out.println("Xóa thành công sản phẩm " + code);
                            isExists = false;
                        } catch (FinalExam.exception.NotFoundException e) {
                            System.out.print(e.getMessage() + " Vui lòng nhập lại: ");
                            code = Integer.parseInt(CommonUtil.getScanner());
                            isExists = true;
                        }
                    } while (isExists);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Vui lòng xác nhận");
                    break;
            }
        } while (choice < 1 || choice > 2);
        display(products);
    }

    private static void create() {
        Product product;
        do {
            System.out.println("---THÊM MỚI SẢN PHẨM---");
            System.out.println("1. Sản phẩm nhập khẩu");
            System.out.println("2. Sản phẩm xuất khẩu");
            System.out.print("Chọn : ");
            choice = CommonUtil.choice();
            int code = 0;
            String name = "";
            double price = 0.0;
            int quality = 0;
            String manufacturer = "";

            if (choice == 1 || choice == 2) {
                code = Integer.parseInt(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.CODE));
                name = CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.NAME);
                price = Double.parseDouble(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.PRICE));
                quality = Integer.parseInt(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.QUALITY));
                manufacturer = CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.MANUFACTURER);
            }
            switch (choice) {
                case 1:
                    double priceImport = Double.parseDouble(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.PRICE_IMPORT));
                    String countryImport = CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.COUNTRY_IMPORT);
                    double rateImport = Double.parseDouble(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.RATE_IMPORT));
                    product = new Import(0, code, name, price, quality, manufacturer, priceImport, countryImport, rateImport);
                    productService.create(product);
                    break;
                case 2:
                    double priceExport = Double.parseDouble(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.PRICE_EXPORT));
                    String countryImportProduct = CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.COUNTRY_IMPORT_PRODUCT);
                    product = new Export(0, code, name, price, quality, manufacturer, priceExport, countryImportProduct);
                    productService.create(product);
                    break;
                default:
                    System.out.println("Vui lòng chọn 1 hoặc 2");
                    break;
            }

        } while (choice < 1 || choice > 2);
        System.out.println("Thêm mới thành công!");
    }

    private static void display(List<Product> products) {
        System.out.println("---DANH SÁCH SẢN PHẨM---");
        if (products.size() > 0) {
            for (Product a : products) {
                if (a instanceof Import) {
                    System.out.printf(
                            "Sản phẩm nhập khẩu: id = %s, " +
                                    "Mã sản phẩm = %s, " +
                                    "Tên sản phẩm = %s,  " +
                                    "Giá bán = %s, " +
                                    "Số lượng = %s, " +
                                    "Nhà sản xuất = %s, " +
                                    "Giá nhập sản phẩm = %s, " +
                                    "Tỉnh thành nhập = %s, " +
                                    "Thuế nhập khẩu = %s\n"
                            , a.getId(), a.getCode(), a.getName(), a.getPrice(), a.getQuality(), a.getManufacturer(),
                            ((Import) a).getPriceImport(), ((Import) a).getCountryImport(),
                            ((Import) a).getRateImport());
                } else {
                    System.out.printf(
                            "Sản phẩm nhập khẩu: id = %s, " +
                                    "Mã sản phẩm = %s, " +
                                    "Tên sản phẩm = %s,  " +
                                    "Giá bán = %s, " +
                                    "Số lượng = %s, " +
                                    "Nhà sản xuất = %s, " +
                                    "Giá xuất khẩu = %s, " +
                                    "Quốc gia nhập sản phẩm = %s\n"
                            , a.getId(), a.getCode(), a.getName(), a.getPrice(), a.getQuality(), a.getManufacturer(),
                            ((Export) a).getPriceExport(), ((Export) a).getCountryImportProduct());
                }
            }
        } else {
            System.out.println("Danh sách trống!");
        }
    }
}
