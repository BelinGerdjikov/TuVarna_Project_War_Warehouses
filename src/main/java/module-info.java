module bg.tu_varna.sit.group24.tu_varna_warehouses {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires log4j;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires mysql.connector.java;



   //exports bg.tu_varna.sit.group24.tu_varna_warehouses;

   //opens bg.tu_varna.sit.group24.tu_varna_warehouses to
   //        javafx.fxml;
   //exports bg.tu_varna.sit.group24.tu_varna_warehouses.application;
   //opens bg.tu_varna.sit.group24.tu_varna_warehouses.application to javafx.fxml;
   //exports bg.tu_varna.sit.group24.tu_varna_warehouses.presentation;
   //opens bg.tu_varna.sit.group24.tu_varna_warehouses.presentation to javafx.fxml;
   //exports bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controller;
   //opens bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controller to javafx.fxml;



    exports bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models;
    opens  bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.models to javafx.fxml;

    exports bg.tu_varna.sit.group24.tu_varna_warehouses.application;
    opens  bg.tu_varna.sit.group24.tu_varna_warehouses.application to javafx.fxml;


    exports bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers;
    opens  bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers to javafx.fxml;
    exports bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Admin;
    opens bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Admin to javafx.fxml;
    exports bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Agent;
    opens bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Agent to javafx.fxml;
    exports bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Owner;
    opens bg.tu_varna.sit.group24.tu_varna_warehouses.presentation.controllers.Owner to javafx.fxml;
}