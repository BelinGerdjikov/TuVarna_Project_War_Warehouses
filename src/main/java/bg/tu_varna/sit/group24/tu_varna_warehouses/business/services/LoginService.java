package bg.tu_varna.sit.group24.tu_varna_warehouses.business.services;

import bg.tu_varna.sit.group24.tu_varna_warehouses.data.entities.Login;
import bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories.LoginRepository;

import java.util.List;

public class LoginService {
    private final LoginRepository repository = LoginRepository.getInstance();

    public static LoginService getInstance(){
        return LoginServiceHolder.INSTANCE;
    }

    private static class LoginServiceHolder {
        public static final LoginService INSTANCE = new LoginService();
    }

    public List<Login> getAll(){
        List<Login> login = repository.getAll();

        return login;
    }
}
