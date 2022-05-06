package VehicleManagement.services;

import java.util.List;

public interface BasicService<T> {
    List<T> getAll();

    boolean save(T t);

    boolean remove(Integer numberVehicle);

}
