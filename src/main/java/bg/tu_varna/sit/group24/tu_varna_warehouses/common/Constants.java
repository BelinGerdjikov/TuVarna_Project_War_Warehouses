package bg.tu_varna.sit.group24.tu_varna_warehouses.common;

public class Constants {
    public static class View{
        public static final String HELLO_VIEW="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/hello-view.fxml";
    }
    public static class LoginWindow{
        public static final String LoginWindowAdmin="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/Adminlogin.fxml";

        public static final String LoginWindowAgent="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/Agentlogin.fxml";

        public static final String LoginWindowOwner="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/Ownerlogin.fxml";
    }

    public static class Reference{

        public static final String Reference="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/Reference.fxml";

        public static final String ReferenceAgent="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/ReferenceAgent.fxml";

        public static final String ReferenceOwner="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/ReferenceOwner.fxml";

    }

    public static class Sorting{
        public static final String sort="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/AgentSorting.fxml";
    }

    public static class Update{

        public static final String Reference="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/UpdateWarehouse.fxml";



        public static final String ReferenceOwner="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/UpdateWarehouseOwner.fxml";
    }

    public static class MenuWindow{
        public static final String MenuWindowAdmin="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/AdminMenu.fxml";

        public static final String MenuWindowAgent="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/AgentMenu.fxml";

        public static final String MenuWindowOwner="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/OwnerMenu.fxml";
    }

    public static class MenuCreate {
        public static final String MenuCreateOwner="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/CreateOwner.fxml";
        public static final String MenuCreateAgent="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/CreateAgent.fxml";
        public static final String MenuCreateWarehouse="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/CreateWarehouse.fxml";
        public static final String MenuCreateContract="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/Contract.fxml";
        public static final String MenuCreateWarehouseAdmin="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/CreateWarehouseAdmin.fxml";
        public static final String Statistic_Agent="/bg/tu_varna/sit/group24/tu_varna_warehouses/presentation.view/AgentSorting.fxml";
    }

    public static class Configurations{
        public static final String LOG4j_PROPERTIES="/bg/tu_varna/sit/group24/tu_varna_warehouses/configuration/log4j.properties";
    }

    public static class Values{
        public static final String Title ="Example App";
    }

    public static class ID_save{
        public static int owner=0;
        public static int agent=9;
    }
}
