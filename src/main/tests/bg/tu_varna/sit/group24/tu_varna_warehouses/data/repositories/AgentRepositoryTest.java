package bg.tu_varna.sit.group24.tu_varna_warehouses.data.repositories;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgentRepositoryTest {



    @Test
    void loginINAgent() {
        int result =AgentRepository.loginINAgent(5);

        int expected=2;

        assertTrue(result==expected);

        ////////

        result =AgentRepository.loginINAgent(7);

        expected=3;

        assertTrue(result==expected);

        ////////

        result =AgentRepository.loginINAgent(12);

        expected=-1;

        assertTrue(result==expected);
    }


    @Test
    void get_deal_profit() {



        int expected;
    }


    @Test
    void update_commission() {



        int Agent_ID=2;

        int commission=AgentRepository.get_commission(Agent_ID);

        int expected=10;

        assertTrue(commission==expected);

        expected=15;
        assertFalse(commission==expected);


        AgentRepository.update_commission(expected,Agent_ID);

        commission=AgentRepository.get_commission(Agent_ID);

        assertTrue(commission==expected);

        expected=10;
        assertFalse(commission==expected);


        //Returning to the commission value

        AgentRepository.update_commission(10,Agent_ID);
    }
}