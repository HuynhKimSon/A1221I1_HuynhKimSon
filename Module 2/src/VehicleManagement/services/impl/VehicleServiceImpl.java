package VehicleManagement.services.impl;

import VehicleManagement.models.Car;
import VehicleManagement.models.MotorCycle;
import VehicleManagement.models.Truck;
import VehicleManagement.models.Vehicle;
import VehicleManagement.services.IVehicleService;
import VehicleManagement.utils.ConstantUtil;
import VehicleManagement.utils.FileCSVHelper;
import VehicleManagement.utils.Validate;

import java.util.ArrayList;
import java.util.List;

public class VehicleServiceImpl implements IVehicleService {
    private final FileCSVHelper<Vehicle> vehicleFileCSVHelper = new FileCSVHelper<>();
    private final List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public List<Vehicle> getAll() {
        List<Vehicle> res = new ArrayList<>();
        Vehicle resVehicle;
        List<String> listTruck = vehicleFileCSVHelper.read(ConstantUtil.PATH.TRUCK);
        List<String> listCar = vehicleFileCSVHelper.read(ConstantUtil.PATH.CAR);
        List<String> listMotorCycle = vehicleFileCSVHelper.read(ConstantUtil.PATH.MOTORCYCLE);

        // Get list data Truck
        for (int i = 0; i < listTruck.size(); i++) {
            String[] strings = listTruck.get(i).split(",");
            String numberVehicle = strings[0];
            String manufacturer = strings[1];
            int yearManufacturer = Integer.parseInt(strings[2]);
            String owner = strings[3];
            int weight = Integer.parseInt(strings[4]);
            resVehicle = new Truck(numberVehicle, manufacturer, yearManufacturer, owner, weight);
            res.add(resVehicle);
        }
        // Get list data Car
        for (int i = 0; i < listCar.size(); i++) {
            String[] strings = listCar.get(i).split(",");
            String numberVehicle = strings[0];
            String manufacturer = strings[1];
            int yearManufacturer = Integer.parseInt(strings[2]);
            String owner = strings[3];
            int numberOfSeats = Integer.parseInt(strings[4]);
            String typeVehicle = strings[5];
            resVehicle = new Car(numberVehicle, manufacturer, yearManufacturer, owner, numberOfSeats, typeVehicle);
            res.add(resVehicle);
        }
        // Get list data MotorCycle
        for (int i = 0; i < listMotorCycle.size(); i++) {
            String[] strings = listMotorCycle.get(i).split(",");
            String numberVehicle = strings[0];
            String manufacturer = strings[1];
            int yearManufacturer = Integer.parseInt(strings[2]);
            String owner = strings[3];
            int wattage = Integer.parseInt(strings[4]);
            resVehicle = new MotorCycle(numberVehicle, manufacturer, yearManufacturer, owner, wattage);
            res.add(resVehicle);
        }
        return res;
    }

    @Override
    public List<Vehicle> getVehicles(String type) {
        List<Vehicle> res = new ArrayList<>();
        Vehicle resVehicle;
        List<String> listTruck = vehicleFileCSVHelper.read(ConstantUtil.PATH.TRUCK);
        List<String> listCar = vehicleFileCSVHelper.read(ConstantUtil.PATH.CAR);
        List<String> listMotorCycle = vehicleFileCSVHelper.read(ConstantUtil.PATH.MOTORCYCLE);
        // Get list data Truck
        if (type == "TRUCK") {
            for (int i = 0; i < listTruck.size(); i++) {
                String[] strings = listTruck.get(i).split(",");
                String numberVehicle = strings[0];
                String manufacturer = strings[1];
                int yearManufacturer = Integer.parseInt(strings[2]);
                String owner = strings[3];
                int weight = Integer.parseInt(strings[4]);
                resVehicle = new Truck(numberVehicle, manufacturer, yearManufacturer, owner, weight);
                res.add(resVehicle);
            }
        }
        // Get list data Car
        if (type == "CAR") {
            for (int i = 0; i < listCar.size(); i++) {
                String[] strings = listCar.get(i).split(",");
                String numberVehicle = strings[0];
                String manufacturer = strings[1];
                int yearManufacturer = Integer.parseInt(strings[2]);
                String owner = strings[3];
                int numberOfSeats = Integer.parseInt(strings[4]);
                String typeVehicle = strings[5];
                resVehicle = new Car(numberVehicle, manufacturer, yearManufacturer, owner, numberOfSeats, typeVehicle);
                res.add(resVehicle);
            }
        }
        // Get list data MotorCycle
        if (type == "MOTORCYCLE") {
            for (int i = 0; i < listMotorCycle.size(); i++) {
                String[] strings = listMotorCycle.get(i).split(",");
                String numberVehicle = strings[0];
                String manufacturer = strings[1];
                int yearManufacturer = Integer.parseInt(strings[2]);
                String owner = strings[3];
                int wattage = Integer.parseInt(strings[4]);
                resVehicle = new MotorCycle(numberVehicle, manufacturer, yearManufacturer, owner, wattage);
                res.add(resVehicle);
            }
        }
        return res;
    }

    @Override
    public String save(Vehicle vehicle) {
        String numberVehicle = vehicle.getNumberVehicle();
        boolean isAdd = false;
        vehicles.add(vehicle);
        if (!Validate.isExitsVehicle(numberVehicle)) {
            if (vehicle instanceof Truck) {
                vehicleFileCSVHelper.write(vehicles, ConstantUtil.PATH.TRUCK, true);
                isAdd = true;
            }
            if (vehicle instanceof Car) {
                vehicleFileCSVHelper.write(vehicles, ConstantUtil.PATH.CAR, true);
                isAdd = true;
            }
            if (vehicle instanceof MotorCycle) {
                vehicleFileCSVHelper.write(vehicles, ConstantUtil.PATH.MOTORCYCLE, true);
                isAdd = true;
            }
        }
        vehicles.clear();
        // Check add success/ fail
        if (!isAdd) {
            numberVehicle = "";
        }
        return numberVehicle;
    }

    @Override
    public boolean remove(String vehicleNumber) {
        try {
            String keyType = String.valueOf(vehicleNumber.charAt(2));
            if (keyType.equals("C")) {
                vehicleFileCSVHelper.remove(vehicleNumber, ConstantUtil.PATH.TRUCK, false);
            } else if (keyType.equals("A") || keyType.equals("B")) {
                vehicleFileCSVHelper.remove(vehicleNumber, ConstantUtil.PATH.CAR, false);
            } else {
                vehicleFileCSVHelper.remove(vehicleNumber, ConstantUtil.PATH.MOTORCYCLE, false);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
