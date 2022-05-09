package ProductManagement.view;

import ProductManagement.utils.CommonUtil;

public class ManagementView {
    private static final String[] mainMenuList = {
            "1. Thêm mới phương tiện.",
            "2. Hiển thị phương tiện",
            "3. Xóa phương tiện",
            "4. Tìm kiếm phương tiện",
            "5. Thoát"
    };
    private static int choice;

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG--");
            for (String item : mainMenuList) {
                System.out.println(item);
            }
            System.out.print("Chọn chức năng: ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    ProductView.choiceVehicleTypeAdd();
                case 2:
                    ProductView.choiceVehicleTypeDisplay();
                case 3:
                    ProductView.removeVehicle();
                    displayMainMenu();
                case 4:
                    ProductView.searchVehicle();
                    displayMainMenu();
                case 5:
                    System.exit(4);
                default:
                    System.out.println("---> Vui lòng chọn từ 1 đến 5: ");
            }
        } while (choice < 1 || choice > 5);
    }

}
