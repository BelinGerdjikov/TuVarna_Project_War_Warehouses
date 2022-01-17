package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WareHouseRepositoryTest {


    @Test
    void warehouse_exist() {

        assertTrue(WareHouseRepository.warehouse_exist(5));
        assertTrue(WareHouseRepository.warehouse_exist(4));
        assertTrue(WareHouseRepository.warehouse_exist(6));

        assertFalse(WareHouseRepository.warehouse_exist(30));
        assertFalse(WareHouseRepository.warehouse_exist(12));
        assertFalse(WareHouseRepository.warehouse_exist(80));
        assertFalse(WareHouseRepository.warehouse_exist(75));
    }

    @Test
    void finding_owner() {

        int warehouse_id=4;

        int expected=2;

        assertTrue(WareHouseRepository.finding_owner(4)==expected);

    }

    @Test
    void finding_price() {

        int id=5;

        double result=WareHouseRepository.finding_price(5);

        double expected =12;


        assertTrue(expected==result);
    }


}