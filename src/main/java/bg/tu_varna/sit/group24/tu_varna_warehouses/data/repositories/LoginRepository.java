package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.access.Connection;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities.Login;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LoginRepository implements DAORepository<Login> {

    private static final Logger log = Logger.getLogger(LoginRepository.class);

    public static LoginRepository getInstance() {
        return LoginRepository.LoginRepositoryHolder.INSTANCE;
    }

    private static class LoginRepositoryHolder {
        public static final LoginRepository INSTANCE = new LoginRepository();
    }

    @Override
    public void save(Login obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(obj);
            log.info("User saved successfully");
        }catch (Exception ex){
            log.error("Login save error"+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Login obj) {

    }

    @Override
    public void delete(Login obj) {

    }

    @Override
    public Optional<Login> getByID(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Login> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Login> task= new LinkedList<>();

        //need work

        return task;
    }






}
