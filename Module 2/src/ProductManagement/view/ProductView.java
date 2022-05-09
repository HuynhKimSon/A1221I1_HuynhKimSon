package VehicleManagement.view;

import VehicleManagement.controllers.VehicleController;
import VehicleManagement.models.Car;
import VehicleManagement.models.MotorCycle;
import VehicleManagement.models.Truck;
import VehicleManagement.models.Vehicle;
import VehicleManagement.utils.CommonUtil;
import VehicleManagement.utils.Validate;

import java.util.List;

public class ProductView {
    private static final String[] mainMenuListAdd = {
            "1. Thêm chính hãng",
            "2. Thêm xách tay",
    };
    private static int choice;
    private static boolean isAdd;

    private static VehicleController vehicleController = new VehicleController();

    public static void choiceVehicleTypeAdd() {
        do {
            for (String item : mainMenuListAdd) {
                System.out.println(item);
            }
            System.out.print("Chọn loại hàng: ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    isAdd = true;
                    while (isAdd) {
                        Truck truckAdd = inputVehicleTruck();
                        String resTruck = vehicleController.save(truckAdd);
                        if (resTruck != "") {
                            System.out.println("Thêm mới thành công hàng chính hãng " + resTruck);
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
                            System.out.println("Thêm mới thành công hàng xách tay " + resCar);
                            isAdd = false;
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

    public static Truck inputProductHandCarry() {
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

    public static MotorCycle inputProductAuthentic() {
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
        System.out.print("Nhập Biển số xe cần xóa: ");
        String numberVehicle = CommonUtil.getScanner();
        if (Validate.isExitsVehicle(numberVehicle)) {
            do {
                System.out.println("Xác nhận xóa phương tiện " + numberVehicle);
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
                    case 2:
                        displayMainMenu();
                    default:
                        System.out.println("---> Vui lòng chọn từ 1 đến 2: ");
                }
            } while (choice < 1 || choice > 2);
        } else {
            System.out.println("Không tìm thấy phương tiện " + numberVehicle);
        }
    }

    public static void searchVehicle() {
        System.out.println("-----------------------------");
        System.out.print("Nhập Biển số xe cần tìm kiếm: ");
        String numberVehicle = CommonUtil.getScanner();
        List<Vehicle> vehicleList = vehicleController.search(numberVehicle);
        if (vehicleList.isEmpty()) {
            System.out.println("Không tìm thấy phương tiện " + numberVehicle);
        } else {
            String keyType = String.valueOf(numberVehicle.charAt(2));
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
                if (keyType.equals("C")) {
                    Truck truck = (Truck) vehicleList.get(i);
                    weight = truck.getWeight();
                } else if (keyType.equals("A") || keyType.equals("B")) {
                    Car car = (Car) vehicleList.get(i);
                    numberOfSeats = car.getNumberOfSeats();
                    typeVehicle = car.getTypeVehicle();
                } else {
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
    }
}
