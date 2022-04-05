package FuramaResort.views;

import java.util.Scanner;

public class FacilityView {
    private static final String[] facilityMenuList = {"1. Display list facility", "2. Add new facility", "3. Display list facility maintenance", "4. Return main menu"};
    private static int choice;
    static Scanner input = new Scanner(System.in);

    public static void displayFacilityMenu() {
        System.out.println("--Menu Facility Management--");
        for (String item : facilityMenuList) {
            System.out.println(item);
        }
        do {
            System.out.print("Enter your choice customer Menu : ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("1. Display list facility");
                    break;
                case 2:
                    System.out.print("2. Add new facility");
                    break;
                case 3:
                    System.out.print("3. Display list facility maintenance");
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
