package FuramaResort.repository;

import java.util.List;

public interface BaseRepository<T> {
    List<T> getAll();

    void save(T t, String type);
}
