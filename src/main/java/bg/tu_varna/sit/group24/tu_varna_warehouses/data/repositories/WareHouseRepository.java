package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities.WareHouse;

import java.util.List;
import java.util.Optional;

public class WareHouseRepository implements DAORepository<WareHouse>{
    @Override
    public void save(WareHouse obj) {

    }

    @Override
    public void update(WareHouse obj) {

    }

    @Override
    public void delete(WareHouse obj) {

    }

    @Override
    public Optional<WareHouse> getByID(Long id) {
        return Optional.empty();
    }

    @Override
    public List<WareHouse> getAll() {
        return null;
    }
}
