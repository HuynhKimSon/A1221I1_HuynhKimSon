package FuramaResort.controllers;

import FuramaResort.models.facility.Facility;
import FuramaResort.services.impl.FacilityServiceImpl;

import java.util.List;

public class FacilityController {

    private static FacilityServiceImpl iFacilityServiceImpl = new FacilityServiceImpl();

    public List<Facility> display() {
        return iFacilityServiceImpl.display();
    }

    public void add(Facility facility, String type) {
        iFacilityServiceImpl.add(facility, type);
    }
}
