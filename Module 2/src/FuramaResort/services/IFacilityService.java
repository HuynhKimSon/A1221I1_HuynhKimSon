package FuramaResort.services;

import FuramaResort.models.facility.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> display();

    void addVilla(Facility facility, String type);
}
