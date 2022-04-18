package FuramaResort.libs;

import FuramaResort.models.facility.Facility;

import java.util.List;

public interface IFacilityRepository {
    List<Facility> display();

    void save(Facility facility, String type);
}