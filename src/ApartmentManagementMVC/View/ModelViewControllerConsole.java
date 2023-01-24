/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Controller.Controller;
import ApartmentManagementMVC.Model.*;
import ApartmentManagementMVC.Utilities.DatabaseUtilities;
import java.util.*;

/**
 *
 * @author ozkan
 */
public class ModelViewControllerConsole {

    public static void main(String[] args) throws Exception {
        connectToDatabase();

        // Model View Controller (MVC)
        // Router knows all the controllers
        Map<String, Controller> router = new HashMap<>();
        router.put("MainMenu", new Controller(new MainMenuView(), new NopModel()));
        router.put("Department", new Controller(new DepartmentView(), new DepartmentModel()));
        router.put("Person", new Controller(new PersonView(),new PersonModel()));
        router.put("Role", new Controller(new RoleView(),new RoleModel()));

        ViewData viewData = new ViewData("MainMenu", "");
        do {
            // Model, View, and Controller
            Controller controller = router.get(viewData.functionName);
            ModelData modelData = controller.executeModel(viewData);
            controller.getMainMenuView();

            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
        } while (viewData.functionName != null);

        System.out.println();
        System.out.println();
        System.out.println("Program is ended...");

        // Disconnect from database
        disconnectFromDatabase();
    }

    public static void connectToDatabase() {
        DatabaseUtilities.host = "localhost:7176";
        DatabaseUtilities.databaseName = "ApartmentManagementDB";

        try {
            DatabaseUtilities.getConnection();
        } catch (Exception e) {
            System.out.println("Exception occured : " + e);
            return;
        }
    }

    public static void disconnectFromDatabase() {
        try {
            DatabaseUtilities.disconnect();
        } catch (Exception e) {
            System.out.println("Error disconnecting from database : " + e);
            return;
        }
    }
}
