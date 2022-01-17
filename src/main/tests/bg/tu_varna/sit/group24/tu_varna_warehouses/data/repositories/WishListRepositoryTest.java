package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WishListRepositoryTest {



    @Test
    void wishList_Test() {
        //adding to wishlist
        WishListRepository.Add_WishList(5,3);
        //testing if is added
        assertTrue(WishListRepository.WishList_already_exist(3,5));

        //removing form wishlist
        WishListRepository.Remove(5,3);

        //testing if is removed
        assertFalse(WishListRepository.WishList_already_exist(3,5));

    }

}