package VehicleManagement.controllers;

import VehicleManagement.models.Vehicle;
import VehicleManagement.services.impl.VehicleServiceImpl;

import java.util.List;

public class VehicleController {
    private VehicleServiceImpl iVehicleServiceImpl = new VehicleServiceImpl();

    public List<Vehicle> display() {
        return iVehicleServiceImpl.getAll();
    }

    public boolean save(Vehicle vehicle) {
        return iVehicleServiceImpl.save(vehicle);
    }

    public boolean remove(Integer numberVehicle) {
        return iVehicleServiceImpl.remove(numberVehicle);
    }
}
