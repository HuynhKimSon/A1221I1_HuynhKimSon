package FuramaResort.views;

import FuramaResort.controllers.FacilityController;
import FuramaResort.models.customer.Customer;
import FuramaResort.models.facility.Facility;
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
                            "%-30s%-30s%-30s%-30s%s",
                            "Tên dịch vụ",
                            "Diện tích sử dụng",
                            "Chi phí thuê",
                            "Số người tối đa",
                            "Kiểu thuê\n"
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
            System.out.printf("%-30s%-30s%-30s%-30s%s");
            facilityList.get(i).getNameService();
            facilityList.get(i).getUsableArea();
            facilityList.get(i).getCost();
            facilityList.get(i).getMaximumPeople();
            facilityList.get(i).getRentalType();
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
                    facilityController.addVilla(addVilla, type);
                    break;
                case 2:
                    System.out.println("Mời bạn nhập thông tin House cần thêm mới: ");
                    break;
                case 3:
                    System.out.println("Mời bạn nhập thông tin Room cần thêm mới: ");
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

}
