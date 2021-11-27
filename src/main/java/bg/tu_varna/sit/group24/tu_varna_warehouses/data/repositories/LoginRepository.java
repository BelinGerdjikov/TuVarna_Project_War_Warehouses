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
            log.info("Login saved successfully");
        }catch (Exception ex){
            log.error("Login saved error"+ex.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void update(Login obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Login updated successfully");
        }catch (Exception ex){
            log.error("Login updated error"+ex.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }


    }

    @Override
    public void delete(Login obj) {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(obj);
            log.info("Login deleted successfully");
        }catch (Exception ex){
            log.error("Login deleted error"+ex.getMessage());
        }finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Optional<Login> getByID(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Login> getAll() {
        Session session = Connection.openSession();
        Transaction transaction = session.beginTransaction();
        List<Login> logins= new LinkedList<>();

        try{
           //String jpql="SELECT * FROM login";!!!!!!!
            //logins.addAll(session.createQuery(jpql,Login.class).getResultList());
           // log.info("Get all logins");

        }catch(Exception ex){
           // logins.error("Get login error: "+ex.getMessage());
        }finally{
            transaction.commit();
        }

        return logins;
    }

}
