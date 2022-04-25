package FuramaResort.services;

import java.util.List;

public interface BaseService<T> {
    List<T> getAll();

    void save(T t, String type);
}
