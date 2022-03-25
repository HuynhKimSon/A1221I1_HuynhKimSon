package FuramaResort.controllers;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        String[] mainMenuList = {"1. Employee Management", "2. Customer Management", "3. Facility Management", "4. Booking Management", "5. Promotion Management", "6. Exit"};
        int choice;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("--Menu Main--");
            for (String item : mainMenuList) {
                System.out.println(item);
            }
            System.out.print("Enter your choice main Menu : ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    displayEmployeeMenu();
                    break;
                case 2:
                    displayCustomerMenu();
                    break;
                case 3:
                    displayFacilityMenu();
                    break;
                case 4:
                    displayBookingMenu();
                    break;
                case 5:
                    displayPromotionMenu();
                    break;
                case 6:
                    System.exit(6);
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 6);
    }

    public static void displayEmployeeMenu() {
        System.out.println("--Menu Employee Management-- ");
        String[] employeeMenuList = {"1. Display list employees", "2. Add new employee", "3. Edit employee", "4. Return main menu"};
        for (String item : employeeMenuList) {
            System.out.println(item);
        }
        int choice;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your choice employees Menu : ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("1. Display list employees");
                    break;
                case 2:
                    System.out.print("2. Add new employee");
                    break;
                case 3:
                    System.out.print("3. Edit employee");
                    break;
                case 4:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 4);
    }

    public static void displayCustomerMenu() {
        System.out.println("--Menu Customer Management--");
        String[] customerMenuList = {"1. Display list customers", "2. Add new customer", "3. Edit customer", "4. Return main menu"};
        for (String item : customerMenuList) {
            System.out.println(item);
        }
        int choice;
        do {
            Scanner input = new Scanner(System.in);
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
                    displayMainMenu();
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 4);
    }

    public static void displayFacilityMenu() {
        System.out.println("--Menu Facility Management--");
        String[] facilityMenuList = {"1. Display list facility", "2. Add new facility", "3. Display list facility maintenance", "4. Return main menu"};
        for (String item : facilityMenuList) {
            System.out.println(item);
        }
        int choice;
        do {
            Scanner input = new Scanner(System.in);
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
                    displayMainMenu();
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 4);
    }

    public static void displayBookingMenu() {
        System.out.println("--Menu Booking Management--");
        String[] bookingMenuList = {"1. Add new booking", "2. Display list booking", "3. Create new contracts", "4. Display list contracts", "5. Edit contracts", "6. Return main menu"};
        for (String item : bookingMenuList) {
            System.out.println(item);
        }
        int choice;
        do {
            Scanner input = new Scanner(System.in);
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
                    displayMainMenu();
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 6);
    }

    public static void displayPromotionMenu() {
        System.out.println("--Menu Promotion Management--");
        String[] promotionMenuList = {"1. Display list customers use service", "2. Display list customers get voucher", "3. Return main menu"};
        for (String item : promotionMenuList) {
            System.out.println(item);
        }
        int choice;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your choice customer Menu : ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("1. Display list customers use service");
                    break;
                case 2:
                    System.out.print("2. Display list customers get voucher");
                    break;
                case 3:
                    displayMainMenu();
                    break;
                default:
                    System.out.println("No choice!");
            }
        } while (choice < 1 || choice > 3);
    }

}
