package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.Connection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities.Admin;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class AdminRepository implements DAORepository<Admin>{

    private static final Logger log = Logger.getLogger(AdminRepository.class);

    public static AdminRepository getInstance() {
        return AdminRepository.AdminRepositoryHolder.INSTANCE;
    }


    private static class AdminRepositoryHolder {
        public static final AdminRepository INSTANCE = new AdminRepository();
    }

    @Override
    public void save(Admin obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("Admin saved successfully");
        }catch (Exception ex){
            log.error("Admin saved error"+ex.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }



    @Override
    public void update(Admin obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Admin updated successfully");
        }catch (Exception ex){
            log.error("Admin updated error"+ex.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Admin obj) {

    }

    @Override
    public Optional<Admin> getByID(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Admin> getAll() {
        return null;
    }


}
