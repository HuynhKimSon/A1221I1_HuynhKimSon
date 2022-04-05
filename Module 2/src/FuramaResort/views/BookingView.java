package FuramaResort.views;

import java.util.Scanner;

public class BookingView {
    private static final String[] bookingMenuList = {"1. Add new booking", "2. Display list booking", "3. Create new contracts", "4. Display list contracts", "5. Edit contracts", "6. Return main menu"};
    private static int choice;
    static Scanner input = new Scanner(System.in);

    public static void displayBookingMenu() {
        System.out.println("--Menu Booking Management--");
        for (String item : bookingMenuList) {
            System.out.println(item);
        }
        do {
            System.out.print("Enter your choice employees Menu : ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("1. Add new booking");
                    break;
                case 2:
                    System.out.print("2. Display list booking");
                    break;
                case 3:
                    System.out.print("3. Create new contracts");
                    break;
                case 4:
                    System.out.print("4. Display list contracts");
                    break;
                case 5:
                    System.out.print("5. Edit contracts");
                    break;
                case 6:
                    FuramaView.displayMainMenu();
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 6);
    }
}
