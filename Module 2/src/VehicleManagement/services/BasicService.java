package VehicleManagement.services;

import java.util.List;

public interface BasicService<T> {
    List<T> getVehicles(String type);

    List<T> getAll();

    String save(T t);

    boolean remove(String numberVehicle);

    List<T> search(String numberVehicle);

}
