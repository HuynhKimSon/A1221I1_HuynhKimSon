package _12_java_collection_framework.exercice.e1;

import java.util.Map;
import java.util.Scanner;

public class Product {

    private static Scanner scanner = new Scanner(System.in);
    private static int choice;
    private static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        displayProductMenu();
    }

    public static void displayProductMenu() {
        System.out.println("--Chức năng của hệ thống quản lý sản phẩm--");
        System.out.println("1. Danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3. Sửa sản phẩm");
        System.out.println("4. Xoá sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm");
        System.out.println("6. Thoát");
        do {
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Danh sách sản phẩm: ");
                    System.out.printf(
                            "%-30s%-30s%s",
                            "Mã sản phẩm",
                            "Tên sản phẩm",
                            "Giá sản phẩm\n"
                    );
                    displayProduct();
                    displayProductMenu();
                    break;
                case 2:
                    System.out.println("--Thêm mới sản phẩm-- ");
                    addProduct();
                    displayProductMenu();
                    break;
                case 3:
                    System.out.println("--Sửa sản phẩm-- ");
                    editProduct();
                    displayProductMenu();
                    break;
                case 4:
                    System.out.println("--Xoá sản phẩm-- ");
                    removeProduct();
                    displayProductMenu();
                    break;
                case 5:
                    System.out.println("--Tìm kiếm sản phẩm-- ");
                    searchProduct();
                    displayProductMenu();
                    break;
                case 6:
                    System.exit(6);
                    break;
                default:
                    System.out.println("Vui lòng chọn đúng chức năng!");
            }
        } while (choice < 1 || choice > 5);
    }

    public static void displayProduct() {
        Map<Integer, ProductManager> productList = productManager.getMapItem();
        productList.forEach((key, value) -> System.out.printf("%-30s%-30s%s\n", key, value.getNameProduct(), value.getPrice()));
    }

    public static void addProduct() {
        System.out.print("Mã sản phẩm : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Tên sản phẩm : ");
        String nameProduct = scanner.nextLine();
        System.out.print("Giá sản phẩm : ");
        double price = Double.parseDouble(scanner.nextLine());
        ProductManager item = new ProductManager(nameProduct, price);
        Boolean result = productManager.push(id, item);
        if (result){
            System.out.println("Thêm mới thành công !");
        } else {
            System.out.println("Thêm mới thất bại. Mã sản phẩm đã tồn tại !");
        }
    }

    public static void editProduct() {
        System.out.print("Mã sản phẩm : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Tên sản phẩm : ");
        String nameProduct = scanner.nextLine();
        System.out.print("Giá sản phẩm : ");
        double price = Double.parseDouble(scanner.nextLine());
        ProductManager item = new ProductManager(nameProduct, price);
        Boolean result = productManager.edit(id, item);
        if (result){
            System.out.println("Chỉnh sửa thành công !");
        } else {
            System.out.println("Chỉnh sửa bại. Mã sản phẩm không tồn tại !");
        }
    }

    public static void removeProduct() {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        Boolean result = productManager.remove(id);
        if (result){
            System.out.println("Xóa thành công !");
        } else {
            System.out.println("Xóa thất bại. Mã sản phẩm không tồn tại !");
        }
    }

    public static void searchProduct() {
        System.out.print("Nhập mã sản phẩm cần tìm kiếm : ");
        int id = Integer.parseInt(scanner.nextLine());
        ProductManager productList = productManager.searchProduct(id);
        if (productList == null) {
            System.out.println("Không tìm thấy sản phẩm !");
        } else {
            System.out.printf(
                    "%-30s%-30s%s",
                    "Mã sản phẩm",
                    "Tên sản phẩm",
                    "Giá sản phẩm\n"
            );
            System.out.printf("%-30s%-30s%s\n", id, productList.getNameProduct(), productList.getPrice());
        }
    }
}
