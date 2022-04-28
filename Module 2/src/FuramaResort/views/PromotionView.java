package FuramaResort.views;

import FuramaResort.utils.CommonUtil;

public class PromotionView {
    private static final String[] promotionMenuList = {"1. Display list customers use service", "2. Display list customers get voucher", "3. Return main menu"};
    private static int choice;

    public static void displayPromotionMenu() {
        System.out.println("--Menu Promotion Management--");
        for (String item : promotionMenuList) {
            System.out.println(item);
        }
        do {
            System.out.print("Enter your choice customer Menu : ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    System.out.print("1. Display list customers use service");
                case 2:
                    System.out.print("2. Display list customers get voucher");
                case 3:
                    FuramaView.displayMainMenu();
                default:
                    System.out.println("---> Please just input number from 1 to 3: ");
            }
        } while (choice < 1 || choice > 3);
    }
}
