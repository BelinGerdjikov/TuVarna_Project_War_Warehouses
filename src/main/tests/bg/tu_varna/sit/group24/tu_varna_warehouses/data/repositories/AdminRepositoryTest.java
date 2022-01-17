package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminRepositoryTest {

    @Test
    void loginINAdmin() {
        int result =AdminRepository.loginINAdmin(1);

        int expected=1;

        assertTrue(result==expected);

        ///////

         result =AdminRepository.loginINAdmin(3);
        expected=-1;

        assertTrue(result==expected);
    }
}