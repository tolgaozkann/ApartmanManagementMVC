/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Entity.Apartment;
import ApartmentManagementMVC.Model.ModelData;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author emreo
 */
public class ApartmentView implements ViewInterface{
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
                int apartmentNo = resultSet.getInt("ApartmentNo");
                String address = resultSet.getString("Address");
                //int managerId = resultSet.getInt("ManagerId");
                

                // Display values
                System.out.print(apartmentNo + "\t");
                System.out.print(address + "\t");
                //System.out.println(managerId + "\t");
                
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
        Integer apartmentNo = getInteger("ApartmentNo : ", true);
        String address = getString("Address : ", true);
        Integer managerId = getInteger("ManagerId : ", false);
        

        Map<String, Object> whereParameters = new HashMap<>();
        if (apartmentNo != null) {
            whereParameters.put("ApartmentNo", apartmentNo);
        }
        if (address != null) {
            whereParameters.put("Address", address);
        }
        if (managerId != null) {
            whereParameters.put("ManagerId", managerId);
        }
        

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Apartment", "select", parameters);
    }

    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "Name, GroupName");

        List<Object> rows = new ArrayList<>();

        String address;
        Integer apartmentNo;
        
        do {
            System.out.println("Fields to insert:");
            apartmentNo = getInteger("ApartmentNo : ", false);
            address = getString("Address : ", true);
            System.out.println();
            //managerId = getInteger("ManagerId : ", false);
            System.out.println();

        

            if (apartmentNo != null && address != null  ) {
                rows.add(new Apartment(apartmentNo, address));
            }
        } while (apartmentNo != null && address != null );

        parameters.put("rows", rows);

        return new ViewData("Apartment", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        Integer apartmentNo = getInteger("ApartmentNo : ", true);
        String address = getString("Address : ", true);
        Integer managerId = getInteger("ManagerId :", true);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (apartmentNo != null) {
            updateParameters.put("ApartmentNo", apartmentNo);
        }
        if (address != null) {
            updateParameters.put("Address", address);
        }
        if (managerId!= null) {
            updateParameters.put("ManagerId", managerId);
        }
        

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Apartment", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Apartment", "delete", parameters);
    }

    @Override
    public String toString() {
        return "Apartment View";
    }

}
