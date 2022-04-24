package FuramaResort.repository.impl;

import FuramaResort.models.facility.House;
import FuramaResort.models.facility.Room;
import FuramaResort.models.facility.Villa;
import FuramaResort.repository.IFacilityRepository;
import FuramaResort.models.facility.Facility;
import FuramaResort.utils.ConstantUtil;
import FuramaResort.utils.FileCSVHelper;

import java.util.ArrayList;
import java.util.List;


public class FacilityRepositoryImpl implements IFacilityRepository {
    private FileCSVHelper<Facility> villaFileCSVHelper = new FileCSVHelper();
    private FileCSVHelper<Room> roomFileCSVHelper = new FileCSVHelper<>();
    private FileCSVHelper<House> houseFileCSVHelper = new FileCSVHelper<>();

    private static final List<Facility> facilityList = new ArrayList<>();

    @Override
    public List<Facility> display() {
        return facilityList;
    }

    @Override
    public void save(Facility facility) {
        facilityList.add(facility);
        villaFileCSVHelper.write(facilityList, ConstantUtil.PATH.VILLA, true);
    }
}
