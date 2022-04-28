package FuramaResort.views;

import FuramaResort.utils.CommonUtil;

public class BookingView {
    private static final String[] bookingMenuList = {"1. Add new booking", "2. Display list booking", "3. Create new contracts", "4. Display list contracts", "5. Edit contracts", "6. Return main menu"};
    private static int choice;

    public static void displayBookingMenu() {
        System.out.println("--Menu Booking Management--");
        for (String item : bookingMenuList) {
            System.out.println(item);
        }
        do {
            System.out.print("Enter your choice employees Menu : ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    System.out.print("1. Add new booking");
                case 2:
                    System.out.print("2. Display list booking");
                case 3:
                    System.out.print("3. Create new contracts");
                case 4:
                    System.out.print("4. Display list contracts");
                case 5:
                    System.out.print("5. Edit contracts");
                case 6:
                    FuramaView.displayMainMenu();
                default:
                    System.out.println("---> Please just input number from 1 to 6: ");
            }
        } while (choice < 1 || choice > 6);
    }
}
