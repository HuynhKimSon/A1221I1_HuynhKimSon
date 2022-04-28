package FuramaResort.repository.impl;

import FuramaResort.models.facility.House;
import FuramaResort.models.facility.Room;
import FuramaResort.models.facility.Villa;
import FuramaResort.repository.IFacilityRepository;
import FuramaResort.models.facility.Facility;
import FuramaResort.utils.ConstantUtil;
import FuramaResort.utils.FileCSVHelper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class FacilityRepositoryImpl implements IFacilityRepository {
    private final FileCSVHelper<Facility> facilityFileCSVHelper = new FileCSVHelper();
    private final List<Facility> facilities = new ArrayList<>();
    private final Map<String, Integer> maintenance = new LinkedHashMap<>();

    @Override
    public List<Facility> getAll() {
        List<Facility> res = new ArrayList<>();
        Facility facility;
        List<String> stringListVilla = facilityFileCSVHelper.read(ConstantUtil.PATH.VILLA);
        List<String> stringListRoom = facilityFileCSVHelper.read(ConstantUtil.PATH.ROOM);
        List<String> stringListHouse = facilityFileCSVHelper.read(ConstantUtil.PATH.HOUSE);
        // Get list data villa
        for (int i = 0; i < stringListVilla.size(); i++) {
            String[] strings = stringListVilla.get(i).split(",");
            String idService = strings[0];
            String nameService = strings[1];
            double usableArea = Double.parseDouble(strings[2]);
            double cost = Double.parseDouble(strings[3]);
            int maximumPeople = Integer.parseInt(strings[4]);
            String rentalType = strings[5];
            String roomStandard = strings[6];
            double poolArea = Double.parseDouble(strings[7]);
            int numberOfFloors = Integer.parseInt(strings[8]);
            facility = new Villa(idService, nameService, usableArea, cost, maximumPeople, rentalType, roomStandard, poolArea, numberOfFloors);
            res.add(facility);
        }
        // Get list data room
        for (int i = 0; i < stringListRoom.size(); i++) {
            String[] strings = stringListRoom.get(i).split(",");
            String idService = strings[0];
            String nameService = strings[1];
            double usableArea = Double.parseDouble(strings[2]);
            double cost = Double.parseDouble(strings[3]);
            int maximumPeople = Integer.parseInt(strings[4]);
            String rentalType = strings[5];
            String freeService = strings[6];
            facility = new Room(idService, nameService, usableArea, cost, maximumPeople, rentalType, freeService);
            res.add(facility);
        }
        // Get list data house
        for (int i = 0; i < stringListHouse.size(); i++) {
            String[] strings = stringListHouse.get(i).split(",");
            String idService = strings[0];
            String nameService = strings[1];
            double usableArea = Double.parseDouble(strings[2]);
            double cost = Double.parseDouble(strings[3]);
            int maximumPeople = Integer.parseInt(strings[4]);
            String rentalType = strings[5];
            String roomStandard = strings[6];
            int numberOfFloors = Integer.parseInt(strings[7]);
            facility = new House(idService, nameService, usableArea, cost, maximumPeople, rentalType, roomStandard, numberOfFloors);
            res.add(facility);
        }
        return res;
    }

    @Override
    public int getSize(String type) {
        List<String> stringList = null;
        if (type.equals("V")) {
            stringList = facilityFileCSVHelper.read(ConstantUtil.PATH.VILLA);
        }
        if (type.equals("R")) {
            stringList = facilityFileCSVHelper.read(ConstantUtil.PATH.ROOM);
        }
        if (type.equals("H")) {
            stringList = facilityFileCSVHelper.read(ConstantUtil.PATH.HOUSE);
        }
        return stringList.size();
    }

    @Override
    public void save(Facility facility, String type) {
        if (type.equals("INSERT")) {
            facilities.add(facility);
            maintenance.put(facility.getIdService(), 0);
            if (facility instanceof Villa) {
                facilityFileCSVHelper.write(facilities, ConstantUtil.PATH.VILLA, true);
            }
            if (facility instanceof Room) {
                facilityFileCSVHelper.write(facilities, ConstantUtil.PATH.ROOM, true);
            }
            if (facility instanceof House) {
                facilityFileCSVHelper.write(facilities, ConstantUtil.PATH.HOUSE, true);
            }
            //facilityFileCSVHelper.write(facilities, ConstantUtil.PATH.FACILITY, true);
            facilityFileCSVHelper.writeMaintenance(maintenance, ConstantUtil.PATH.MAINTENANCE, true);
            maintenance.clear();
            facilities.clear();
        }
    }

//    private List<Facility> convertToFacility() {
//        List<Facility> res = new ArrayList<>();
//        Facility facility = new Facility();
//        List<String> stringList = facilityFileCSVHelper.read(ConstantUtil.PATH.FACILITY);
//        for (int i = 0; i < stringList.size(); i++) {
//            String[] strings = stringList.get(i).split(",");
//            String idService = strings[0];
//            String nameService = strings[1];
//            double usableArea = Double.parseDouble(strings[2]);
//            double cost = Double.parseDouble(strings[3]);
//            int maximumPeople = Integer.parseInt(strings[4]);
//            String rentalType = strings[5];
//            String temp = String.valueOf(idService.charAt(0));
//            if (temp.equals("V")) {
//                String roomStandard = strings[6];
//                double poolArea = Double.parseDouble(strings[7]);
//                int numberOfFloors = Integer.parseInt(strings[8]);
//                facility = new Villa(idService, nameService, usableArea, cost, maximumPeople, rentalType, roomStandard, poolArea, numberOfFloors);
//            }
//            if (temp.equals("R")) {
//                String freeService = strings[6];
//                facility = new Room(idService, nameService, usableArea, cost, maximumPeople, rentalType, freeService);
//            }
//            if (temp.equals("H")) {
//                String roomStandard = strings[6];
//                int numberOfFloors = Integer.parseInt(strings[7]);
//                facility = new House(idService, nameService, usableArea, cost, maximumPeople, rentalType, roomStandard, numberOfFloors);
//            }
//            res.add(facility);
//        }
//        return res;
//    }
}
