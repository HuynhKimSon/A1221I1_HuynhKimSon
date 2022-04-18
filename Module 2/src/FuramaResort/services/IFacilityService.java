package FuramaResort.services;

import FuramaResort.models.facility.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> display();

    void add(Facility facility, String type);
}
