package FuramaResort.utils;

import FuramaResort.services.IFacilityService;
import FuramaResort.services.impl.FacilityServiceImpl;

public class Validate {
    private static IFacilityService facilityService = new FacilityServiceImpl();

    public static boolean isExistsFacility(String id) {
        return facilityService.getAll().stream().anyMatch(e -> e.getIdService().equals(id));
    }
}
