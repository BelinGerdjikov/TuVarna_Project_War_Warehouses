package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities.Owner;

import java.util.List;
import java.util.Optional;

public class OwnerRepository implements DAORepository<Owner>{
    @Override
    public void save(Owner obj) {

    }

    @Override
    public void update(Owner obj) {

    }

    @Override
    public void delete(Owner obj) {

    }

    @Override
    public Optional<Owner> getByID(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Owner> getAll() {
        return null;
    }
}
