package VehicleManagement.view;

import VehicleManagement.controllers.VehicleController;
import VehicleManagement.utils.CommonUtil;

public class VehicleView {
    private static final String[] mainMenuList = {
            "1. Thêm xe tải.",
            "2. Thêm ô tô",
            "3. Thêm xe máy",
            "4. Quay lại"
    };
    private static int choice;

    private VehicleController vehicleController = new VehicleController();

    public static void choiceVehicleType() {
        do {
            for (String item : mainMenuList) {
                System.out.println(item);
            }
            System.out.print("Chọn loại xe: ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    inputVehicleTruck();
                    choiceVehicleType();
                case 2:
                    displayVehicleCar();
                    choiceVehicleType();
                case 3:
                    displayVehicleMotorCycle();
                    choiceVehicleType();
                case 4:
                    ManagementView.displayMainMenu();
                default:
                    System.out.println("---> Vui lòng chọn từ 1 đến 4: ");
            }
        } while (choice < 1 || choice > 6);
    }

    public static void inputVehicleTruck() {
        System.out.println("Biển số xe: ");
        System.out.println("Hãng sản xuất: ");
        System.out.println("Năm sản xuất: ");
        System.out.println("Chủ sở hữu: ");

    }

    public static void displayVehicleCar() {
        System.out.println("Biển số xe: ");
        System.out.println("Hãng sản xuất: ");
        System.out.println("Năm sản xuất: ");
        System.out.println("Chủ sở hữu: ");

    }

    public static void displayVehicleMotorCycle() {
        System.out.println("Biển số xe: ");
        System.out.println("Hãng sản xuất: ");
        System.out.println("Năm sản xuất: ");
        System.out.println("Chủ sở hữu: ");

    }

    public static void displayVehicle() {

    }

    public static void removeVehicle() {

    }

}
