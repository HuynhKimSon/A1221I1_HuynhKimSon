package FuramaResort.views;

import FuramaResort.controllers.FacilityController;
import FuramaResort.models.facility.Facility;
import FuramaResort.models.facility.House;
import FuramaResort.models.facility.Room;
import FuramaResort.models.facility.Villa;

import java.util.List;
import java.util.Scanner;

public class FacilityView {
    private static final String[] facilityMenuList = {"1. Display list facility", "2. Add new facility", "3. Display list facility maintenance", "4. Return main menu"};
    private static final String[] facilityServiceList = {"1. Add New Villa", "2. Add New House", "3. Add New Room", "4. Back to menu"};
    private static int choice;
    private static String type;
    static Scanner input = new Scanner(System.in);

    private static FacilityController facilityController = new FacilityController();

    public static void displayFacilityMenu() {
        System.out.println("--Menu Facility Management--");
        for (String item : facilityMenuList) {
            System.out.println(item);
        }
        do {
            System.out.print("Enter your choice customer Menu : ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Danh sách thông tin cơ sở Khu nghỉ dưỡng Furama: ");
                    System.out.printf(
                            "%-30s%-30s%-30s%-30s%-30s%-30s%-30s%-30s%s",
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
                    break;
                case 2:
                    selectService();
                    displayFacilityMenu();
                    break;
                case 3:
                    System.out.print("3. Display list facility maintenance");
                    displayFacilityMenu();
                    break;
                case 4:
                    FuramaView.displayMainMenu();
                    break;
                default:
                    System.out.println("No choice!");
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
            System.out.printf("%-30s%-30s%-30s%-30s%-30s%-30s%-30s%-30s%s",
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

    public static void selectService() {
        for (String item : facilityServiceList) {
            System.out.println(item);
        }
        do {
            System.out.print("Chọn loại cơ sở Khu nghỉ dưỡng Furama cần thêm mới: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Mời bạn nhập thông tin Villa cần thêm mới: ");
                    type = "INSERT";
                    Villa addVilla = inputInformationOfVilla();
                    facilityController.add(addVilla, type);
                    break;
                case 2:
                    System.out.println("Mời bạn nhập thông tin House cần thêm mới: ");
                    House addHouse = inputInformationHouse();
                    type = "INSERT";
                    facilityController.add(addHouse, type);
                    break;
                case 3:
                    System.out.println("Mời bạn nhập thông tin Room cần thêm mới: ");
                    Room addRoom = inputInformationRoom();
                    type = "INSERT";
                    facilityController.add(addRoom, type);
                    break;
                case 4:
                    displayFacilityMenu();
                    break;
            }
        } while (choice < 1 || choice > 4);
    }

    public static Villa inputInformationOfVilla() {
        System.out.println("-----------------------------");
        System.out.print("Tên dịch vụ: ");
        String nameService = input.nextLine();
        System.out.print("Diện tích sử dụng: ");
        double usableArea = Double.parseDouble(input.nextLine());
        System.out.print("Chi phí thuê: ");
        double cost = Double.parseDouble(input.nextLine());
        System.out.print("Số người tối đa: ");
        int maximumPeople = Integer.parseInt(input.nextLine());
        System.out.print("Kiểu thuê: ");
        String rentalType = input.nextLine();
        System.out.print("Tiêu chuẩn phòng: ");
        String roomStandard = input.nextLine();
        System.out.print("Diện tích hồ bơi: ");
        double poolArea = Double.parseDouble(input.nextLine());
        System.out.print("Số tầng: ");
        int numberOfFloors = Integer.parseInt(input.nextLine());
        Villa villa = new Villa(nameService, usableArea, cost, maximumPeople, rentalType, roomStandard, poolArea, numberOfFloors);
        return villa;
    }

    public static House inputInformationHouse() {
        System.out.println("-----------------------------");
        System.out.print("Tên dịch vụ: ");
        String nameService = input.nextLine();
        System.out.print("Diện tích sử dụng: ");
        double usableArea = Double.parseDouble(input.nextLine());
        System.out.print("Chi phí thuê: ");
        double cost = Double.parseDouble(input.nextLine());
        System.out.print("Số người tối đa: ");
        int maximumPeople = Integer.parseInt(input.nextLine());
        System.out.print("Kiểu thuê: ");
        String rentalType = input.nextLine();
        System.out.print("Tiêu chuẩn phòng: ");
        String roomStandard = input.nextLine();
        System.out.print("Số tầng: ");
        int numberOfFloors = Integer.parseInt(input.nextLine());
        House house = new House(nameService, usableArea, cost, maximumPeople, rentalType, roomStandard, numberOfFloors);
        return house;
    }

    public static Room inputInformationRoom() {
        System.out.println("-----------------------------");
        System.out.print("Tên dịch vụ: ");
        String nameService = input.nextLine();
        System.out.print("Diện tích sử dụng: ");
        double usableArea = Double.parseDouble(input.nextLine());
        System.out.print("Chi phí thuê: ");
        double cost = Double.parseDouble(input.nextLine());
        System.out.print("Số người tối đa: ");
        int maximumPeople = Integer.parseInt(input.nextLine());
        System.out.print("Kiểu thuê: ");
        String rentalType = input.nextLine();
        System.out.print("Dịch vụ miễn phí đi kèm: ");
        String freeService = input.nextLine();
        Room room = new Room(nameService, usableArea, cost, maximumPeople, rentalType, freeService);
        return room;
    }

}
