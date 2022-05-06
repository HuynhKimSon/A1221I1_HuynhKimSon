package VehicleManagement.view;

import VehicleManagement.controllers.VehicleController;
import VehicleManagement.models.Car;
import VehicleManagement.models.MotorCycle;
import VehicleManagement.models.Truck;
import VehicleManagement.models.Vehicle;
import VehicleManagement.utils.CommonUtil;

import java.util.List;

public class VehicleView {
    private static final String[] mainMenuList = {
            "1. Thêm xe tải.",
            "2. Thêm ô tô",
            "3. Thêm xe máy",
            "4. Quay lại"
    };
    private static int choice;
    private static boolean isAdd;

    private static VehicleController vehicleController = new VehicleController();

    public static void choiceVehicleTypeAdd() {
        do {
            for (String item : mainMenuList) {
                System.out.println(item);
            }
            System.out.print("Chọn loại xe: ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    isAdd = true;
                    while (isAdd) {
                        Truck truckAdd = inputVehicleTruck();
                        String resTruck = vehicleController.save(truckAdd);
                        if (resTruck != "") {
                            System.out.println("Thêm mới thành công phương tiện có BKS " + resTruck);
                            isAdd = false;
                        } else {
                            System.out.println("Thêm mới thất bại. Biển số xe đã tồn tại !");
                        }
                    }
                    choiceVehicleTypeAdd();
                case 2:
                    isAdd = true;
                    while (isAdd) {
                        Car carAdd = inputVehicleCar();
                        String resCar = vehicleController.save(carAdd);
                        if (resCar != "") {
                            System.out.println("Thêm mới thành công phương tiện có BKS " + resCar);
                            isAdd = false;
                        } else {
                            System.out.println("Thêm mới thất bại. Biển số xe đã tồn tại !");
                        }
                    }
                    choiceVehicleTypeAdd();
                case 3:
                    isAdd = true;
                    while (isAdd) {
                        MotorCycle motorCycleAdd = inputVehicleMotorCycle();
                        String resMotorCycle = vehicleController.save(motorCycleAdd);
                        if (resMotorCycle != "") {
                            System.out.println("Thêm mới thành công phương tiện có BKS " + resMotorCycle);
                        } else {
                            System.out.println("Thêm mới thất bại. Biển số xe đã tồn tại !");
                        }
                    }
                    choiceVehicleTypeAdd();
                case 4:
                    ManagementView.displayMainMenu();
                default:
                    System.out.println("---> Vui lòng chọn từ 1 đến 4: ");
            }
        } while (choice < 1 || choice > 6);
    }

    public static Truck inputVehicleTruck() {
        System.out.println("-----------------------------");
        System.out.print("Biển số xe: ");
        String numberVehicle = CommonUtil.getScanner();
        System.out.print("Hãng sản xuất: ");
        String manufacturer = CommonUtil.getScanner();
        System.out.print("Năm sản xuất: ");
        int yearManufacturer = Integer.parseInt(CommonUtil.getScanner());
        System.out.print("Chủ sở hữu: ");
        String owner = CommonUtil.getScanner();
        System.out.print("Trọng tải: ");
        int weight = Integer.parseInt(CommonUtil.getScanner());
        Truck truck = new Truck(numberVehicle, manufacturer, yearManufacturer, owner, weight);
        return truck;
    }

    public static Car inputVehicleCar() {
        System.out.println("-----------------------------");
        System.out.print("Biển số xe: ");
        String numberVehicle = CommonUtil.getScanner();
        System.out.print("Hãng sản xuất: ");
        String manufacturer = CommonUtil.getScanner();
        System.out.print("Năm sản xuất: ");
        int yearManufacturer = Integer.parseInt(CommonUtil.getScanner());
        System.out.print("Chủ sở hữu: ");
        String owner = CommonUtil.getScanner();
        System.out.print("Số chỗ ngồi: ");
        int numberOfSeats = Integer.parseInt(CommonUtil.getScanner());
        System.out.print("Kiểu xe: ");
        String typeVehicle = CommonUtil.getScanner();
        Car car = new Car(numberVehicle, manufacturer, yearManufacturer, owner, numberOfSeats, typeVehicle);
        return car;
    }

    public static MotorCycle inputVehicleMotorCycle() {
        System.out.println("-----------------------------");
        System.out.print("Biển số xe: ");
        String numberVehicle = CommonUtil.getScanner();
        System.out.print("Hãng sản xuất: ");
        String manufacturer = CommonUtil.getScanner();
        System.out.print("Năm sản xuất: ");
        int yearManufacturer = Integer.parseInt(CommonUtil.getScanner());
        System.out.print("Chủ sở hữu: ");
        String owner = CommonUtil.getScanner();
        System.out.print("Công suất: ");
        int wattage = Integer.parseInt(CommonUtil.getScanner());
        MotorCycle motorCycle = new MotorCycle(numberVehicle, manufacturer, yearManufacturer, owner, wattage);
        return motorCycle;
    }

    public static void choiceVehicleTypeDisplay() {
        do {
            for (String item : mainMenuList) {
                System.out.println(item);
            }
            System.out.print("Chọn loại xe: ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("--DANH SÁCH XE TẢI--");
                    displayVehicle("TRUCK");
                    System.out.println("-----------------------------");
                    choiceVehicleTypeDisplay();
                case 2:
                    System.out.println("-----------------------------");
                    System.out.println("--DANH SÁCH XE Ô TÔ--");
                    displayVehicle("CAR");
                    System.out.println("-----------------------------");
                    choiceVehicleTypeDisplay();
                case 3:
                    System.out.println("-----------------------------");
                    System.out.println("--DANH SÁCH XE MÁY--");
                    displayVehicle("MOTORCYCLE");
                    System.out.println("-----------------------------");
                    choiceVehicleTypeDisplay();
                case 4:
                    ManagementView.displayMainMenu();
                default:
                    System.out.println("---> Vui lòng chọn từ 1 đến 4: ");
            }
        } while (choice < 1 || choice > 6);
    }

    public static void displayVehicle(String type) {
        List<Vehicle> vehicleList = vehicleController.display(type);
        System.out.printf(
                "%-30s%-30s%-30s%-30s%-30s%-30s%-30s%s",
                "Biển kiểm soát",
                "Hãng sản xuất",
                "Năm sản xuất",
                "Chủ sở hữu",
                "Trọng tải",
                "Kiểu xe",
                "Số chỗ ngồi",
                "Công suất\n"
        );
        for (int i = 0; i < vehicleList.size(); i++) {
            int weight = 0;
            String typeVehicle = "-";
            int numberOfSeats = 0;
            int wattage = 0;
            if (type == "TRUCK") {
                Truck truck = (Truck) vehicleList.get(i);
                weight =
            }
            if (type == "CAR") {
                Car car = (Car) vehicleList.get(i);

            }
            if (type == "MOTORCYCLE") {
                MotorCycle motorCycle = (MotorCycle) vehicleList.get(i);

            }
            System.out.printf(
                    "%-30s%-30s%-30s%-30s%-30s%-30s%-30s%s",
                    vehicleList.get(i).getNumberVehicle(),
                    vehicleList.get(i).getManufacturer(),
                    vehicleList.get(i).getYearManufacturer(),
                    vehicleList.get(i).getOwner(),
                    weight,
                    typeVehicle,
                    numberOfSeats,
                    wattage + "\n"
            );
        }
    }

    public static void removeVehicle() {

    }

}
