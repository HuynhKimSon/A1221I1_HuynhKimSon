package ProductManagement.utils;

import VehicleManagement.services.IVehicleService;
import VehicleManagement.services.impl.VehicleServiceImpl;

public class Validate {
    private static IVehicleService vehicleService = new VehicleServiceImpl();

    public static boolean isExitsVehicle(String numberVehicle) {
        return vehicleService.getAll().stream().anyMatch(e -> e.getNumberVehicle().equals(numberVehicle));
    }
}
