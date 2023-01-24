/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Controller.Controller;
import ApartmentManagementMVC.Model.ModelData;
import ApartmentManagementMVC.Model.*;
import java.util.*;

/**
 *
 * @author ozkan
 */
public class MainMenuView implements ViewInterface {

    public MainMenuView() {

    }

    public void begin() throws Exception {

        String operationName;
        Integer choice;
        do {
            System.out.println("1. Person Operations");
            System.out.println("2. Role Operations");
            System.out.println("3. Apartment Operations");
            System.out.println("4. Flat Operations");
            System.out.println("5. Bank Account Operations");
            System.out.println("6. Quit");
            System.out.println();

            choice = getInteger("Enter your choice : ", false);
        } while (choice == null || choice < 1 || choice > 6);

        Map<String, Object> userInput = new HashMap<>();
        userInput.put("mainMenuChoice", choice);

        switch (choice.intValue()) {
            case 1:
                ViewData viewData = userOperations();
                Controller controller = new Controller(new PersonView(),new PersonModel());
                ModelData modelData = controller.executeModel(viewData);
                controller.getView(modelData,viewData.functionName,viewData.operationName);

                System.out.println();
                System.out.println("-------------------------------------------------");
                System.out.println();
                break;
            case 2:
                roleOperations();
                break;
            case 3:
                operationName = "insert.gui";
                break;
            case 4:
                operationName = "update.gui";
                break;
            case 5:
                operationName = "delete.gui";
                break;
            default: //return new ViewData(null, null);
        }

        //return new ViewData("Department", operationName, new HashMap<>());
    }

    @Override
    public String toString() {
        return "Main Menu View";
    }
    public ViewData apartmentOperations() throws Exception{
    Integer choice;
        String operationName = null;
        do {
            System.out.println("1. Show all Apartments");
            System.out.println("2. Show Apartments");
            System.out.println("3. Add a Apartment");
            System.out.println("4. Update a Apartment");
            System.out.println("5. Delete a Apartment");
            System.out.println("6. Quit");
            System.out.println();

            choice = getInteger("Enter your choice : ", false);
        } while (choice == null || choice < 1 || choice > 6);

        Map<String, Object> userInput = new HashMap<>();
        userInput.put("apartmentOperationsChoice", choice);

        switch (choice.intValue()) {
            case 1:
                operationName = "select";
                break;
            case 2:
                operationName = "select.gui";
                break;
            case 3:
                operationName = "insert.gui";
                break;
            case 4:
                operationName = "update.gui";
                break;
            case 5:
                operationName = "delete.gui";
                break;
            //case 6: operationName = "insert.gui"; return new ViewData("PersonRole", operationName, new HashMap<>());//rol atama
            default: //return new ViewData(null, null);
        }

        return new ViewData("Apartment", operationName, new HashMap<>());
}

    public ViewData roleOperations() throws Exception {
        Integer choice;
        String operationName = null;
        do {
            System.out.println("1. Show all Roles");
            System.out.println("2. Show Roles");
            System.out.println("3. Add a Role");
            System.out.println("4. Update a Role");
            System.out.println("5. Delete a Role");
            //System.out.println("6. Give a role to a person");
            System.out.println("6. Quit");
            System.out.println();

            choice = getInteger("Enter your choice : ", false);
        } while (choice == null || choice < 1 || choice > 6);

        Map<String, Object> userInput = new HashMap<>();
        userInput.put("roleOperationsChoice", choice);

        switch (choice.intValue()) {
            case 1:
                operationName = "select";
                break;
            case 2:
                operationName = "select.gui";
                break;
            case 3:
                operationName = "insert.gui";
                break;
            case 4:
                operationName = "update.gui";
                break;
            case 5:
                operationName = "delete.gui";
                break;
            //case 6: operationName = "insert.gui"; return new ViewData("PersonRole", operationName, new HashMap<>());//rol atama
            default: //return new ViewData(null, null);
        }

        return new ViewData("Role", operationName, new HashMap<>());
    }

    public ViewData userOperations() throws Exception {
        Integer choice;
        String operationName = null;
        do {
            System.out.println("1. Show all people");
            System.out.println("2. Show people");
            System.out.println("3. Add a person");
            System.out.println("4. Update a person");
            System.out.println("5. Delete a person");
            System.out.println("6. Give a role to a person");
            System.out.println("7. Update a user's role");
            System.out.println("8. Quit");
            System.out.println();

            choice = getInteger("Enter your choice : ", false);
        } while (choice == null || choice < 1 || choice > 8);

        Map<String, Object> userInput = new HashMap<>();
        userInput.put("personOperationsChoice", choice);

        switch (choice.intValue()) {
            case 1:
                operationName = "select";
                break;
            case 2:
                operationName = "select.gui";
                break;
            case 3:
                operationName = "insert.gui";
                break;
            case 4:
                operationName = "update.gui";
                break;
            case 5:
                operationName = "delete.gui";
                break;
            case 6:
                operationName = "insert.gui";
                return new ViewData("PersonRole", operationName, new HashMap<>());//rol atama
            case 7:
                operationName = "update.gui";
                return new ViewData("PersonRole", operationName, new HashMap<>());//rol güncelleme
            case 8:
                begin();
            default: //return new ViewData(null, null);
        }

        return new ViewData("Person", operationName, new HashMap<>());
    }

    @Override
    //not usable
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
