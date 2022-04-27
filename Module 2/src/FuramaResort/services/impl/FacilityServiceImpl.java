package FuramaResort.services.impl;

import FuramaResort.repository.IFacilityRepository;
import FuramaResort.repository.impl.FacilityRepositoryImpl;
import FuramaResort.models.facility.Facility;
import FuramaResort.services.IFacilityService;

import java.util.List;

public class FacilityServiceImpl implements IFacilityService {

    private IFacilityRepository facilityRepository = new FacilityRepositoryImpl();

    @Override
    public List<Facility> getAll() {
        return facilityRepository.getAll();
    }

    @Override
    public int getSize(String type) {
        return facilityRepository.getSize(type);
    }

    @Override
    public void save(Facility facility, String type) {
        facilityRepository.save(facility, type);
    }

    @Override
    public void remove(String index) {

    }
}