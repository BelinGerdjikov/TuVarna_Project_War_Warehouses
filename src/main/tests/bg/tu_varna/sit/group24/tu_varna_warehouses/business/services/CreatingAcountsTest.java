package bg.tu_varna.sit.group24.tu_varna_warehouses.business.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CreatingAcountsTest {

    @Test
    void input_validation() {

        String expected="done";


        assertFalse(CreatingAcounts.input_validation("re","dsad","sdad","sdad").equals(expected));


        assertFalse(CreatingAcounts.input_validation("Belin","Belin_G","yiiyi","yiiyi1").equals(expected));


        assertFalse(CreatingAcounts.input_validation("*))(*",")(**%^(","***","***").equals(expected));
    }
}

