/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Entity.PersonRole;
import ApartmentManagementMVC.Model.ModelData;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author ozkan
 */
public class PersonRoleView implements ViewInterface{

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int personId = resultSet.getInt("PersonId");
                int roleId = resultSet.getInt("RoleId");
                Date startingDate = resultSet.getDate("StartingDate");
                Date endingDate = resultSet.getDate("EndingDate");

                // Display values
                System.out.print(personId + "\t");
                System.out.print(roleId + "\t");
                System.out.print(startingDate + "\t");
                System.out.print(endingDate + "\t");
            }
            resultSet.close();
        }

        return new ViewData("MainMenu", "");
    }

    ViewData insertOperation(ModelData modelData) throws Exception {
        System.out.println("Number of inserted rows is " + modelData.recordCount);

        return new ViewData("MainMenu", "");
    }

    ViewData updateOperation(ModelData modelData) throws Exception {
        System.out.println("Number of updated rows is " + modelData.recordCount);

        return new ViewData("MainMenu", "");
    }

    ViewData deleteOperation(ModelData modelData) throws Exception {
        System.out.println("Number of deleted rows is " + modelData.recordCount);

        return new ViewData("MainMenu", "");
    }

    Map<String, Object> getWhereParameters() throws Exception {
        System.out.println("Filter conditions:");
        Integer personId = getInteger("PersonId : ", false);
        Integer roleId = getInteger("RoleId : ", false);
        Date startingDate = getDate("StartingDate", false);
        Date endingDate = getDate("EndingDate",false);

        Map<String, Object> whereParameters = new HashMap<>();
        if (personId != null) {
            whereParameters.put("PersonId", personId);
        }
        if (roleId != null) {
            whereParameters.put("RoleId", roleId);
        }
        if(startingDate != null){
            whereParameters.put("StartingDate", startingDate);
        }
        if(endingDate != null){
            whereParameters.put("EndingDate", endingDate);
        }

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("PersonRole", "select", parameters);
    }

    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "RoleName");

        List<Object> rows = new ArrayList<>();

        Integer personId,roleId;
        Date startingDate, endingDate;
        do {
            System.out.println("Fields to insert:");
            personId = getInteger("RoleId : ", false);
            System.out.println();
            roleId = getInteger("RoleId",false);
            System.out.println();
            startingDate = getDate("StartingDate",false);
            System.out.println();
            endingDate = getDate("EndingDate",true);

            if (personId != null && roleId != null && startingDate != null) {
                rows.add(new PersonRole(personId,roleId,startingDate,endingDate));
            }
        } while (personId != null && roleId != null && startingDate != null);

        parameters.put("rows", rows);

        return new ViewData("PersonRole", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        Integer personId = getInteger("PersonId : ", false);
        Integer roleId = getInteger("RoleId : ", false);
        Date startingDate = getDate("StartingDate", false);
        Date endingDate = getDate("EndingDate",false);;
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (personId != null) {
            updateParameters.put("PersonId", personId);
        }
        if (roleId != null) {
            updateParameters.put("RoleId", roleId);
        }
        if(startingDate != null){
            updateParameters.put("StartingDate", startingDate);
        }
        if(endingDate != null){
            updateParameters .put("EndingDate", endingDate);
        }

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Department", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Role", "delete", parameters);
    }

    @Override
    public String toString() {
        return "PersonRole View";
    }

    
}
