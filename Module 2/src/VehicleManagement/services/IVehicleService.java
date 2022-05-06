package VehicleManagement.services;

import VehicleManagement.models.Vehicle;

import java.util.List;

public interface IVehicleService extends BasicService<Vehicle> {
    List<Vehicle> getAll();

    boolean save(Vehicle vehicle);

    boolean remove(Integer numberVehicle);
}
