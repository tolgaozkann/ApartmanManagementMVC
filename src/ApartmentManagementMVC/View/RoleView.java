/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Entity.Role;
import ApartmentManagementMVC.Model.ModelData;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author ozkan
 */
public class RoleView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        switch(operationName) {
		case "select": return selectOperation(modelData);	
		case "insert": return insertOperation(modelData);	
		case "update": return updateOperation(modelData);	
		case "delete": return deleteOperation(modelData);	
		case "select.gui": return selectGUI(modelData);
		case "insert.gui": return insertGUI(modelData);
		case "update.gui": return updateGUI(modelData);
		case "delete.gui": return deleteGUI(modelData);
		}
		
		return new ViewData("MainMenu", "");
    }

    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int roleId = resultSet.getInt("Id");
                String roleName = resultSet.getString("RoleName");

                // Display values
                System.out.print(roleId + "\t");
                System.out.print(roleName + "\t");
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
        Integer id = getInteger("ID : ", false);
        String roleName = getString("RoleName : ", false);

        Map<String, Object> whereParameters = new HashMap<>();
        if (id != null) {
            whereParameters.put("Id", id);
        }
        if (roleName != null) {
            whereParameters.put("roleName", roleName);
        }

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Role", "select", parameters);
    }

    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "RoleName");

        List<Object> rows = new ArrayList<>();

        String roleName;
        do {
            System.out.println("Fields to insert:");
            roleName = getString("Name : ", false);
            System.out.println();

            if (roleName != null) {
                rows.add(new Role(roleName));
            }
        } while (roleName != null);

        parameters.put("rows", rows);

        return new ViewData("Role", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        String roleName = getString("RoleName : ", true);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (roleName != null) {
            updateParameters.put("RoleName", roleName);
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
        return "Role View";
    }

}
