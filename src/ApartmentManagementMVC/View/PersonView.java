/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Controller.Controller;
import ApartmentManagementMVC.Entity.Person;
import ApartmentManagementMVC.Model.ModelData;
import ApartmentManagementMVC.Model.NopModel;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author ozkan
 */
public class PersonView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        switch (operationName) {
            case "select":
                return selectOperation(modelData);
            case "insert":
                return insertOperation(modelData);
            case "update":
                return updateOperation(modelData);
            case "delete":
                return deleteOperation(modelData);
            case "select.gui":
                return selectGUI(modelData);
            case "insert.gui":
                return insertGUI(modelData);
            case "update.gui":
                return updateGUI(modelData);
            case "delete.gui":
                return deleteGUI(modelData);
        }

        return new ViewData("MainMenu", "");
    }

    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int personId = resultSet.getInt("PersonId");
                String name = resultSet.getString("Name");
                String surname = resultSet.getString("Surname");
                int flatId = resultSet.getInt("FlatId");
                BigDecimal ssn = resultSet.getBigDecimal("SSN");
                String email = resultSet.getString("Email");
                String phoneNumber = resultSet.getString("PhoneNumber");

                // Display values
                System.out.print(personId + "\t");
                System.out.print(name + "\t");
                System.out.println(surname + "\t");
                System.out.println(flatId + "\t");
                System.out.println(ssn + "\t");
                System.out.println(email + "\t");
                System.out.print(phoneNumber + "\t");
            }
            resultSet.close();
        }

        return new ViewData("MainMenu", "");
    }

    ViewData insertOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);
        ViewData viewData = new ViewData("MainMenu", "");
        Controller controller = new Controller(new MainMenuView(), new NopModel());
        controller.getMainMenuView();

        return viewData;
    }

    ViewData updateOperation(ModelData modelData) throws Exception {
        System.out.println("Number of updated rows is " + modelData.recordCount);
ViewData viewData = new ViewData("MainMenu", "");
        Controller controller = new Controller(new MainMenuView(), new NopModel());
        controller.getMainMenuView();

        return viewData;
    }

    ViewData deleteOperation(ModelData modelData) throws Exception {
        System.out.println("Number of deleted rows is " + modelData.recordCount);
        ViewData viewData = new ViewData("MainMenu", "");
        Controller controller = new Controller(new MainMenuView(), new NopModel());
        controller.getMainMenuView();

        return viewData;
    }

    Map<String, Object> getWhereParameters() throws Exception {
        Scanner reader = new Scanner(System.in);
        System.out.println("Filter conditions:");
        Integer personId = getInteger("Person ID : ", true);
        
        reader.nextLine();
        String name = getString("Name : ", true);
        String surName = getString("Surname : ", true);
        Integer flatId = getInteger("FlatId :", true);
        reader.nextLine();
        Double ssnDouble = getDouble("SSN : ", false);
        BigDecimal ssn = new BigDecimal(ssnDouble);
        String email = getString("Email : ", true);
        String phoneNumber = getString("PhoneNumber : ", true);

        Map<String, Object> whereParameters = new HashMap<>();
        if (personId != null) {
            whereParameters.put("PersonId", personId);
        }
        if (name != null) {
            whereParameters.put("Name", name);
        }
        if (surName != null) {
            whereParameters.put("SurName", surName);
        }
        if (flatId != null) {
            whereParameters.put("FlatId", flatId);
        }
        if (ssn != null) {
            whereParameters.put("SSN", ssn);
        }
        if (email != null) {
            whereParameters.put("Email", email);
        }
        if (phoneNumber != null) {
            whereParameters.put("PhoneNumber", phoneNumber);
        }

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Person", "select", parameters);
    }

    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "Name, Surname, SSN, Email, PhoneNumber, FlatId");
        Scanner reader = new Scanner(System.in);
        List<Object> rows = new ArrayList<>();

        String name, surName, email, phoneNumber;
        Integer flatId;
        Double ssnDouble;

        System.out.println("Fields to insert:");
        name = getString("Name : ", true);
        surName = getString("SurName : ", true);
        ssnDouble = getDouble("SSN : ", true);
        email = getString("Email : ", true);
        phoneNumber = getString("PhoneNumber : ", true);
        reader.nextLine();
        flatId = getInteger("FlatId : ", true);

        BigDecimal ssn = new BigDecimal(ssnDouble);

        System.out.println(name);
        System.out.println(surName);
        System.out.println(flatId);
        System.out.println(ssn);
        System.out.println(email);
        System.out.println(phoneNumber);

        if (name != null && surName != null && flatId != null && email != null && phoneNumber != null && ssn != null) {
            System.out.println("buraya girdi");
            rows.add(new Person(name, surName, flatId, ssn, email, phoneNumber));
        }

        parameters.put("rows", rows);

        return new ViewData("Person", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        String name = getString("Name : ", true);
        String surName = getString("Surname : ", true);
        Integer flatId = getInteger("FlatId :", true);
        Double ssnDouble = getDouble("SSN", true);
        BigDecimal ssn = new BigDecimal(ssnDouble);
        String email = getString("Email : ", true);
        String phoneNumber = getString("PhoneNumber : ", true);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (name != null) {
            updateParameters.put("Name", name);
        }
        if (surName != null) {
            updateParameters.put("GroupName", surName);
        }
        if (flatId != null) {
            updateParameters.put("FlatId", flatId);
        }
        if (ssn != null) {
            updateParameters.put("SSN", ssn);
        }
        if (email != null) {
            updateParameters.put("Email", email);
        }
        if (phoneNumber != null) {
            updateParameters.put("PhoneNumber", phoneNumber);
        }

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Person", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Department", "delete", parameters);
    }

    @Override
    public String toString() {
        return "Person View";
    }

}
