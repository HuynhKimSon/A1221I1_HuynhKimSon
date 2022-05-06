package VehicleManagement.services;

import VehicleManagement.models.Vehicle;

import java.util.List;

public interface IVehicleService extends BasicService<Vehicle> {
    List<Vehicle> getAll(String type);

    String save(Vehicle vehicle);

    String remove(Integer numberVehicle);
}
