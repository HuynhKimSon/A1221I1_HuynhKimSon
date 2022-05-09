import model.AuthenticProduct;
import model.HandProduct;
import model.Product;
import service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductService productService = new ProductService();

    public static void main(String[] args) {
        while (true){
            System.out.println("--- Product Menu ---");
            System.out.println("1. Create");
            System.out.println("2. Display");
            System.out.println("3. Delete");
            System.out.println("4. Search by Name");
            System.out.println("5. Exit");

            System.out.print("Enter your choice:");

            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    create();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void create() {
        System.out.println("Choice type product to create:");
        System.out.println("1. Authentic");
        System.out.println("2. Hand");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.print("Name:");
        String name= scanner.nextLine();
        System.out.print("Price:");
        Double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Manufacturer:");
        String manufacturer = scanner.nextLine();

        Product product;
        if(choice == 1){
            System.out.print("Grantee by year:");
            int granteeByYear = Integer.parseInt(scanner.nextLine());
            product = new AuthenticProduct(0, name, price, manufacturer, granteeByYear);
        }
        else {
            System.out.print("Country:");
            String country = scanner.nextLine();
            System.out.print("Status:");
            String status = scanner.nextLine();
            product = new HandProduct(0, name, price, manufacturer, country, status);
        }


        productService.create(product);
        System.out.println("Created successfully");
    }

    private static void display() {
        List<Product> products = productService.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void delete() {
        display();
        System.out.print("Enter id to delete:");
        int id = Integer.parseInt(scanner.nextLine());
        productService.delete(id);
        System.out.println("Deleted successfully");
    }

    private static void searchByName() {
        System.out.print("Enter name to search:");
        String name = scanner.nextLine();
        List<Product> products = productService.searchByName(name);

        for (Product p : products){
            System.out.println(p);
        }
    }

}
