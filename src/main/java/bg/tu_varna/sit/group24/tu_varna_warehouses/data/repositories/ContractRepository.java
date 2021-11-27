package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities.Contract;

import java.util.List;
import java.util.Optional;

public class ContractRepository implements DAORepository<Contract>{
    @Override
    public void save(Contract obj) {

    }

    @Override
    public void update(Contract obj) {

    }

    @Override
    public void delete(Contract obj) {

    }

    @Override
    public Optional<Contract> getByID(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Contract> getAll() {
        return null;
    }
}
