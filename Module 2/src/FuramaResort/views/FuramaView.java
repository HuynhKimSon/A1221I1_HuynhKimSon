package FuramaResort.views;

import FuramaResort.utils.CommonUtil;

public class FuramaView {
    private static final String[] mainMenuList = {"1. Employee Management", "2. Customer Management", "3. Facility Management", "4. Booking Management", "5. Promotion Management", "6. Exit"};
    private static int choice;

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        do {
            System.out.println("--Menu Main--");
            for (String item : mainMenuList) {
                System.out.println(item);
            }
            System.out.print("Enter your choice main Menu : ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    EmployeeView.displayEmployeeMenu();
                case 2:
                    CustomerView.displayCustomerMenu();
                case 3:
                    FacilityView.displayFacilityMenu();
                case 4:
                    BookingView.displayBookingMenu();
                case 5:
                    PromotionView.displayPromotionMenu();
                case 6:
                    System.exit(6);
                default:
                    System.out.println("---> Please just input number from 1 to 6: ");
            }
        } while (choice < 1 || choice > 6);
    }
}
