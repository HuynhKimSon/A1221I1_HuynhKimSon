package FuramaResort.services.impl;

import FuramaResort.libs.impl.FacilityRepositoryImpl;
import FuramaResort.models.facility.Facility;
import FuramaResort.services.IFacilityService;

import java.util.List;

public class FacilityServiceImpl implements IFacilityService {

    private static FacilityRepositoryImpl facilityRepository = new FacilityRepositoryImpl();

    @Override
    public List<Facility> display() {
        return facilityRepository.display();
    }

    @Override
    public void add(Facility facility, String type) {
        facilityRepository.save(facility, type);
    }
}