package VehicleManagement.controllers;

import VehicleManagement.models.Vehicle;
import VehicleManagement.services.impl.VehicleServiceImpl;

import java.util.List;

public class VehicleController {
    private VehicleServiceImpl iVehicleServiceImpl = new VehicleServiceImpl();

    public List<Vehicle> display(String type) {
        return iVehicleServiceImpl.getAll(type);
    }

    public String save(Vehicle vehicle) {
        return iVehicleServiceImpl.save(vehicle);
    }

    public String remove(Integer numberVehicle) {
        return iVehicleServiceImpl.remove(numberVehicle);
    }
}
