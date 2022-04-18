package FuramaResort.libs.impl;

import FuramaResort.libs.IFacilityRepository;
import FuramaResort.models.facility.Facility;

import java.util.ArrayList;
import java.util.List;

public class FacilityRepositoryImpl implements IFacilityRepository {
    private static final List<Facility> facilityList = new ArrayList<>();

    @Override
    public List<Facility> display() {
        return facilityList;
    }

    @Override
    public void save(Facility facility, String type) {
        facilityList.add(facility);
    }
}
