package FuramaResort.views;

import java.util.Scanner;

public class PromotionView {
    private static final String[] promotionMenuList = {"1. Display list customers use service", "2. Display list customers get voucher", "3. Return main menu"};
    private static int choice;
    static Scanner input = new Scanner(System.in);

    public static void displayPromotionMenu() {
        System.out.println("--Menu Promotion Management--");
        for (String item : promotionMenuList) {
            System.out.println(item);
        }
        do {
            System.out.print("Enter your choice customer Menu : ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("1. Display list customers use service");
                case 2:
                    System.out.print("2. Display list customers get voucher");
                case 3:
                    FuramaView.displayMainMenu();
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 3);
    }
}
