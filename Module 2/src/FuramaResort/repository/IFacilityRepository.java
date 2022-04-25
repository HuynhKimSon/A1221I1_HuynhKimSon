package FuramaResort.repository;

import FuramaResort.models.facility.Facility;

import java.util.List;

public interface IFacilityRepository extends BaseRepository<Facility> {

    @Override
    List<Facility> getAll();

    @Override
    void save(Facility facility, String type);
}