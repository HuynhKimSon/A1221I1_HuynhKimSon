package FuramaResort.views;

import java.util.Scanner;

public class CustomerView {
    private static final String[] customerMenuList = {"1. Display list customers", "2. Add new customer", "3. Edit customer", "4. Return main menu"};
    static Scanner input = new Scanner(System.in);
    private static int choice;

    public static void displayCustomerMenu() {
        System.out.println("--Menu Customer Management--");
        for (String item : customerMenuList) {
            System.out.println(item);
        }
        do {
            System.out.print("Enter your choice customer Menu : ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("1. Display list customers");
                    break;
                case 2:
                    System.out.print("2. Add new customer");
                    break;
                case 3:
                    System.out.print("3. Edit customer");
                    break;
                case 4:
                    FuramaView.displayMainMenu();
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 4);
    }
}
