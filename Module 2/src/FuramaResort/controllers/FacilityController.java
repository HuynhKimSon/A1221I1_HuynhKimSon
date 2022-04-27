package FuramaResort.controllers;

import FuramaResort.models.facility.Facility;
import FuramaResort.services.IFacilityService;
import FuramaResort.services.impl.FacilityServiceImpl;

import java.util.List;

public class FacilityController {

    private IFacilityService iFacilityServiceImpl = new FacilityServiceImpl();

    public List<Facility> display() {
        return iFacilityServiceImpl.getAll();
    }

    public void save(Facility facility, String type) {
        iFacilityServiceImpl.save(facility, type);
    }

    public int getSize(String type){
        return iFacilityServiceImpl.getSize(type);
    }
}
