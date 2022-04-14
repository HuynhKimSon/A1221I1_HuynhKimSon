package _12_java_collection_framework.practice.p1;

import java.util.Scanner;
import java.util.TreeMap;

public class Product {

    private static Scanner scanner = new Scanner(System.in);
    private static int choice;
    private static String type;
    private static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        displayProductMenu();
    }

    public static void displayProductMenu() {
        System.out.println("--Chức năng của hệ thống quản lý sản phẩm--");
        System.out.println("1. Danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3. Xoá sản phẩm");
        System.out.println("4. Tìm kiếm sản phẩm");
        System.out.println("5. Thoát");
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
                    System.out.println("Thêm mới sản phẩm : ");
                    addProduct();
                    displayProductMenu();
                    break;
                case 3:
                    System.out.println("Xoá sản phẩm: ");
                    displayProductMenu();
                    break;
                case 4:
                    System.out.println("Tìm kiếm sản phẩm: ");
                    displayProductMenu();
                    break;
                case 5:
                    System.exit(5);
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 4);
    }

    public static void addProduct() {
        System.out.print("Mã sản phẩm : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Tên sản phẩm : ");
        String nameProduct = scanner.nextLine();
        System.out.print("Giá sản phẩm : ");
        double price = Double.parseDouble(scanner.nextLine());
        ProductManager item = new ProductManager(nameProduct, price);
        productManager.push(id, item);
    }

    public static void displayProduct() {
        TreeMap<Integer, ProductManager> productList = productManager.getMapItem();
        productList.forEach((key, value) -> System.out.printf("%-30s%-30s%s\n", key, value.getNameProduct(), value.getPrice()));

    }
}
