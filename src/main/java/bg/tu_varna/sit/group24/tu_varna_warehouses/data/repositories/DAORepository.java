package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import java.util.List;
import java.util.Optional;

public interface DAORepository<T> {

    void save(T obj);
    void update(T obj);
    void delete(T obj);
    Optional<T> getByID(Long id);
    List<T> getAll();
}
