package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginRepositoryTest {

    @Test
    void isUsedName() {
        String input="petq123";

        assertTrue(LoginRepository.isUsedName(input));
        input="Nikolai";
        assertTrue(LoginRepository.isUsedName(input));
        input="stoqn123";
        assertTrue(LoginRepository.isUsedName(input));
        input="pavlina123";
        assertTrue(LoginRepository.isUsedName(input));
        input="petyr123";
        assertTrue(LoginRepository.isUsedName(input));
        input="nikolai44";
        assertFalse(LoginRepository.isUsedName(input));
        input="stoqn124";
        assertFalse(LoginRepository.isUsedName(input));
        input="petar123";
        assertFalse(LoginRepository.isUsedName(input));
        input="pavlina555";
        assertFalse(LoginRepository.isUsedName(input));

    }


    @Test
    void login_cheak() {
        String name="Nikolai";
        String pass="Nikolai";
        int expected=5;

        assertTrue(LoginRepository.login_cheak(name,pass)==expected);

        //changing the username
        name="Nikolai1";

        assertFalse(LoginRepository.login_cheak(name,pass)==expected);
    }
}