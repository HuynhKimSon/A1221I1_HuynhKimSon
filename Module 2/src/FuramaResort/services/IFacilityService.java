package FuramaResort.services;

import FuramaResort.models.facility.Facility;

import java.util.List;

public interface IFacilityService extends BaseService<Facility> {

    @Override
    List<Facility> getAll();

    @Override
    void save(Facility facility, String type);

}
