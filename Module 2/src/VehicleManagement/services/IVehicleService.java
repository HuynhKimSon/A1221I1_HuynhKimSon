package VehicleManagement.services;

import VehicleManagement.models.Vehicle;

import java.util.List;

public interface IVehicleService extends BasicService<Vehicle> {
    List<Vehicle> getVehicles(String type);

    List<Vehicle> getAll();

    String save(Vehicle vehicle);

    boolean remove(String numberVehicle);
}
