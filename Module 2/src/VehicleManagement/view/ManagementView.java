package VehicleManagement.view;


import VehicleManagement.utils.CommonUtil;

public class ManagementView {
    private static final String[] mainMenuList = {
            "1. Thêm mới phương tiện.",
            "2. Hiển thị phương tiện",
            "3. Xóa phương tiện",
            "4. Thoát"
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
                    VehicleView.choiceVehicleTypeAdd();
                case 2:
                    VehicleView.choiceVehicleTypeDisplay();
                case 3:
                    VehicleView.removeVehicle();
                case 4:
                    System.exit(4);
                default:
                    System.out.println("---> Vui lòng chọn từ 1 đến 4: ");
            }
        } while (choice < 1 || choice > 6);
    }
}
