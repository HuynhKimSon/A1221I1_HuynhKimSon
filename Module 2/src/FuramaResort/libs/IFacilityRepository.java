package FuramaResort.libs;

import FuramaResort.models.facility.Facility;

import java.util.List;

public interface IFacilityRepository {
    List<Facility> display();

    void saveVilla(Facility facility, String type);
}