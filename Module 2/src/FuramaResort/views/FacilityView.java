package FuramaResort.views;

import FuramaResort.controllers.FacilityController;
import FuramaResort.models.facility.Facility;
import FuramaResort.models.facility.House;
import FuramaResort.models.facility.Room;
import FuramaResort.models.facility.Villa;
import FuramaResort.utils.CommonUtil;
import FuramaResort.utils.Validate;

import java.util.List;

public class FacilityView {
    private static final String[] facilityMenuList = {"1. Display list facility", "2. Add new facility", "3. Display list facility maintenance", "4. Return main menu"};
    private static final String[] facilityServiceList = {"1. Add New Villa", "2. Add New House", "3. Add New Room", "4. Back to menu"};
    private static int choice;
    private static boolean isAdd;

    private static FacilityController facilityController = new FacilityController();

    public static void displayFacilityMenu() {
        System.out.println("--Menu Facility Management--");
        for (String item : facilityMenuList) {
            System.out.println(item);
        }
        do {
            System.out.print("Enter your choice customer Menu : ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Danh sách thông tin cơ sở Khu nghỉ dưỡng Furama: ");
                    System.out.printf(
                            "%-30s%-30s%-30s%-30s%-30s%-30s%-30s%-30s%-30s%s",
                            "Mã dịch vụ",
                            "Tên dịch vụ",
                            "Diện tích sử dụng",
                            "Chi phí thuê",
                            "Số người tối đa",
                            "Kiểu thuê",
                            "Tiêu chuẩn phòng",
                            "Diện tích hồ bơi",
                            "Số tầng",
                            "Dịch vụ miễn phí đi kèm\n"
                    );
                    displayFacility();
                    System.out.println("-----------------------------");
                    displayFacilityMenu();
                case 2:
                    selectService();
                    displayFacilityMenu();
                case 3:
                    System.out.print("3. Display list facility maintenance");
                    displayFacilityMenu();
                case 4:
                    FuramaView.displayMainMenu();
                default:
                    System.out.println("---> Please just input number from 1 to 4: ");
            }
        } while (choice < 1 || choice > 4);
    }

    public static void selectService() {
        for (String item : facilityServiceList) {
            System.out.println(item);
        }
        do {
            System.out.print("Chọn loại cơ sở Khu nghỉ dưỡng Furama cần thêm mới: ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    System.out.println("Mời bạn nhập thông tin Villa cần thêm mới: ");
                    isAdd = true;
                    while (isAdd) {
                        Villa addVilla = inputInformationOfVilla();
                        if (!Validate.isExistsFacility(addVilla.getIdService())) {
                            facilityController.save(addVilla, "INSERT");
                            isAdd = false;
                            System.out.println("=> Thêm mới Villa thành công! <=");
                        } else {
                            System.out.println("=> Mã dịch vụ đã tồn tại! Vui lòng nhập lại <=");
                        }
                    }
                    displayFacilityMenu();
                case 2:
                    System.out.println("Mời bạn nhập thông tin House cần thêm mới: ");
                    isAdd = true;
                    while (isAdd) {
                        House addHouse = inputInformationHouse();
                        if (!Validate.isExistsFacility(addHouse.getIdService())) {
                            facilityController.save(addHouse, "INSERT");
                            isAdd = false;
                            System.out.println("=> Thêm mới House thành công! <=");
                        } else {
                            System.out.println("=> Mã dịch vụ đã tồn tại! Vui lòng nhập lại <=");
                        }
                    }
                    displayFacilityMenu();
                case 3:
                    System.out.println("Mời bạn nhập thông tin Room cần thêm mới: ");
                    isAdd = true;
                    while (isAdd) {
                        Room addRoom = inputInformationRoom();
                        if (!Validate.isExistsFacility(addRoom.getIdService())) {
                            facilityController.save(addRoom, "INSERT");
                            isAdd = false;
                            System.out.println("=> Thêm mới Room thành công! <=");
                        } else {
                            System.out.println("=> Mã dịch vụ đã tồn tại! Vui lòng nhập lại <=");
                        }
                    }
                    displayFacilityMenu();
                case 4:
                    displayFacilityMenu();
                default:
                    System.out.println("---> Please just input number from 1 to 4: ");
            }
        } while (choice < 1 || choice > 4);
    }

    public static void displayFacility() {
        List<Facility> facilityList = facilityController.display();
        for (int i = 0; i < facilityList.size(); i++) {
            String roomStandard = "-";
            Double poolArea = 0.0;
            int numberOfFloors = 0;
            String freeService = "-";
            if (facilityList.get(i) instanceof Villa) {
                Villa villa = (Villa) facilityList.get(i);
                roomStandard = villa.getRoomStandard();
                poolArea = villa.getPoolArea();
                numberOfFloors = villa.getNumberOfFloors();
            }
            if (facilityList.get(i) instanceof House) {
                House house = (House) facilityList.get(i);
                roomStandard = house.getRoomStandard();
                numberOfFloors = house.getNumberOfFloors();
            }
            if (facilityList.get(i) instanceof Room) {
                Room room = (Room) facilityList.get(i);
                freeService = room.getFreeService();
            }
            System.out.printf("%-30s%-30s%-30s%-30s%-30s%-30s%-30s%-30s%-30s%s",
                    facilityList.get(i).getIdService(),
                    facilityList.get(i).getNameService(),
                    facilityList.get(i).getUsableArea(),
                    facilityList.get(i).getCost(),
                    facilityList.get(i).getMaximumPeople(),
                    facilityList.get(i).getRentalType(),
                    roomStandard,
                    poolArea,
                    numberOfFloors,
                    freeService + "\n");
        }
    }

    public static Villa inputInformationOfVilla() {
        System.out.println("-----------------------------");
        int size = facilityController.getSize("V");
        String idService = "V" + (size + 1);
        System.out.print("Tên dịch vụ: ");
        String nameService = CommonUtil.getScanner();
        System.out.print("Diện tích sử dụng: ");
        double usableArea = Double.parseDouble(CommonUtil.getScanner());
        System.out.print("Chi phí thuê: ");
        double cost = Double.parseDouble(CommonUtil.getScanner());
        System.out.print("Số người tối đa: ");
        int maximumPeople = Integer.parseInt(CommonUtil.getScanner());
        System.out.print("Kiểu thuê: ");
        String rentalType = CommonUtil.getScanner();
        System.out.print("Tiêu chuẩn phòng: ");
        String roomStandard = CommonUtil.getScanner();
        System.out.print("Diện tích hồ bơi: ");
        double poolArea = Double.parseDouble(CommonUtil.getScanner());
        System.out.print("Số tầng: ");
        int numberOfFloors = Integer.parseInt(CommonUtil.getScanner());
        Villa villa = new Villa(idService, nameService, usableArea, cost, maximumPeople, rentalType, roomStandard, poolArea, numberOfFloors);
        return villa;
    }

    public static House inputInformationHouse() {
        System.out.println("-----------------------------");
        int size = facilityController.getSize("V");
        String idService = "H" + (size + 1);
        System.out.print("Tên dịch vụ: ");
        String nameService = CommonUtil.getScanner();
        System.out.print("Diện tích sử dụng: ");
        double usableArea = Double.parseDouble(CommonUtil.getScanner());
        System.out.print("Chi phí thuê: ");
        double cost = Double.parseDouble(CommonUtil.getScanner());
        System.out.print("Số người tối đa: ");
        int maximumPeople = Integer.parseInt(CommonUtil.getScanner());
        System.out.print("Kiểu thuê: ");
        String rentalType = CommonUtil.getScanner();
        System.out.print("Tiêu chuẩn phòng: ");
        String roomStandard = CommonUtil.getScanner();
        System.out.print("Số tầng: ");
        int numberOfFloors = Integer.parseInt(CommonUtil.getScanner());
        House house = new House(idService, nameService, usableArea, cost, maximumPeople, rentalType, roomStandard, numberOfFloors);
        return house;
    }

    public static Room inputInformationRoom() {
        System.out.println("-----------------------------");
        int size = facilityController.getSize("R");
        String idService = "R" + (size + 1);
        System.out.print("Tên dịch vụ: ");
        String nameService = CommonUtil.getScanner();
        System.out.print("Diện tích sử dụng: ");
        double usableArea = Double.parseDouble(CommonUtil.getScanner());
        System.out.print("Chi phí thuê: ");
        double cost = Double.parseDouble(CommonUtil.getScanner());
        System.out.print("Số người tối đa: ");
        int maximumPeople = Integer.parseInt(CommonUtil.getScanner());
        System.out.print("Kiểu thuê: ");
        String rentalType = CommonUtil.getScanner();
        System.out.print("Dịch vụ miễn phí đi kèm: ");
        String freeService = CommonUtil.getScanner();

        Room room = new Room(idService, nameService, usableArea, cost, maximumPeople, rentalType, freeService);
        return room;
    }
}
