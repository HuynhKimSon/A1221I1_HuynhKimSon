package ProductManagement.services;

import java.util.List;

public interface BaseService<T> {
    List<T> getAll();

    void Save(T t);

    boolean remove(String id);

    List<T> search(String id);
}
