package VehicleManagement.services;

import java.util.List;

public interface BasicService<T> {
    List<T> getAll(String type);

    String save(T t);

    String remove(Integer numberVehicle);

}
