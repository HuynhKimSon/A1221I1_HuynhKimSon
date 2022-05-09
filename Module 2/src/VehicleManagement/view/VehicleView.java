package VehicleManagement.view;

import VehicleManagement.controllers.VehicleController;
import VehicleManagement.models.Car;
import VehicleManagement.models.MotorCycle;
import VehicleManagement.models.Truck;
import VehicleManagement.models.Vehicle;
import VehicleManagement.utils.CommonUtil;
import VehicleManagement.utils.Validate;

import java.util.List;

import static VehicleManagement.view.ManagementView.displayMainMenu;

public class VehicleView {
    private static final String[] mainMenuListAdd = {
            "1. Thêm xe tải.",
            "2. Thêm ô tô",
            "3. Thêm xe máy",
            "4. Quay lại"
    };
    private static final String[] mainMenuListDisplay = {
            "1. Hiển thị xe tải.",
            "2. Hiển thị ô tô",
            "3. Hiển thị xe máy",
            "4. Quay lại"
    };
    private static int choice;
    private static boolean isAdd;

    private static VehicleController vehicleController = new VehicleController();

    public static void choiceVehicleTypeAdd() {
        do {
            for (String item : mainMenuListAdd) {
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
                    displayMainMenu();
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
            for (String item : mainMenuListDisplay) {
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
                    displayMainMenu();
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
            int weight = -1;
            String typeVehicle = "-";
            int numberOfSeats = -1;
            int wattage = -1;
            if (type == "TRUCK") {
                Truck truck = (Truck) vehicleList.get(i);
                weight = truck.getWeight();
            }
            if (type == "CAR") {
                Car car = (Car) vehicleList.get(i);
                numberOfSeats = car.getNumberOfSeats();
                typeVehicle = car.getTypeVehicle();
            }
            if (type == "MOTORCYCLE") {
                MotorCycle motorCycle = (MotorCycle) vehicleList.get(i);
                wattage = motorCycle.getWattage();
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
        System.out.println("-----------------------------");
        System.out.print("Nhập Biển số xe: ");
        String numberVehicle = CommonUtil.getScanner();
        boolean isExitsVehicle = true;
        while (isExitsVehicle) {
            if (Validate.isExitsVehicle(numberVehicle)) {
                System.out.println("Xã nhận xóa phương tiện " + numberVehicle);
                System.out.println("1. Có");
                System.out.println("2. Không");
                choice = CommonUtil.choice();
                switch (choice) {
                    case 1:
                        boolean isRemove = vehicleController.remove(numberVehicle);
                        if (isRemove) {
                            System.out.println("Xóa thành công phương tiện " + numberVehicle);
                        } else {
                            System.out.println("Xóa thất bại phương tiện " + numberVehicle);
                        }
                        isExitsVehicle = false;
                    case 2:
                        displayMainMenu();
                    default:
                        System.out.println("---> Vui lòng chọn từ 1 đến 2: ");
                }

            }
            System.out.print("Nhập lại Biển số xe: ");
            numberVehicle = CommonUtil.getScanner();
        }
    }
}
