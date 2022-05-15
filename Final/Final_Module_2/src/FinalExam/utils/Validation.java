package FinalExam.utils;


import FinalExam.service.ProductService;

public class Validation {

    private static ProductService productService = new ProductService();

    public static boolean isExitsProduct(int code) {
        return productService.findAll().stream().anyMatch(e -> e.getCode() == code);
    }
}
