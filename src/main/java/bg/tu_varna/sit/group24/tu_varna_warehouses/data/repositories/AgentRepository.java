package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities.Agent;


import java.util.List;
import java.util.Optional;

public class AgentRepository implements DAORepository<Agent>{

    @Override
    public void save(Agent obj) {

    }

    @Override
    public void update(Agent obj) {

    }

    @Override
    public void delete(Agent obj) {

    }

    @Override
    public Optional<Agent> getByID(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Agent> getAll() {
        return null;
    }
}
