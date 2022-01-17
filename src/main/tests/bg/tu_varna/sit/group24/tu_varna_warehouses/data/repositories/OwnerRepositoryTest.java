package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerRepositoryTest {



    @Test
    void OwnerIfExists() {
        int owner_id=2;
        int expected=2;

        assertTrue(OwnerRepository.Owner_id_check(owner_id)==expected);

        owner_id=3;
        expected=3;

        assertTrue(OwnerRepository.Owner_id_check(owner_id)==expected);

        owner_id=4;
        expected=4;

        assertTrue(OwnerRepository.Owner_id_check(owner_id)==expected);

        owner_id=5;
        expected=5;

        assertFalse(OwnerRepository.Owner_id_check(owner_id)==expected);

        owner_id=6;
        expected=6;

        assertFalse(OwnerRepository.Owner_id_check(owner_id)==expected);

        owner_id=7;
        expected=7;

        assertFalse(OwnerRepository.Owner_id_check(owner_id)==expected);
    }

    @Test
    void loginINOwner() {
        int result =OwnerRepository.loginINOwner(1);

        int expected=1;

        assertTrue(result==expected);

        ///////

        result =OwnerRepository.loginINOwner(3);
        expected=-1;

        assertTrue(result==expected);
    }


}