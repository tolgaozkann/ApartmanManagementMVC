/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;


import ApartmentManagementMVC.Entity.Subscription;
import ApartmentManagementMVC.Model.ModelData;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author baransonmez
 */
public class SubscriptionView implements ViewInterface {
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
                int subsId = resultSet.getInt("Id");
                String category = resultSet.getString("Category");
                Date dueDate = resultSet.getDate("DueDate");
                int apartmentId = resultSet.getInt("ApartmentId");
                String image = resultSet.getString("Image");

                // Display values
                System.out.print(subsId + "\t");
                System.out.print(category + "\t");
                System.out.println(dueDate + "\t");
                System.out.println(apartmentId + "\t");
                System.out.print(image + "\t");
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
        Integer subsId = getInteger("Subscription ID : ", true);
        String category = getString("Category : ", true);
        Date dueDate = getDate("DueDate : ", true);
        Integer apartmentId = getInteger("Apartment ID :", true);
        String image = getString("Image : ", true);
        

        Map<String, Object> whereParameters = new HashMap<>();
        if (subsId != null) {
            whereParameters.put("Id", subsId);
        }
        if (category != null) {
            whereParameters.put("Category", category);
        }
        if (dueDate != null) {
            whereParameters.put("DueDate", dueDate);
        }
        if (apartmentId != null) {
            whereParameters.put("ApartmentId", apartmentId);
        }
        if (image!= null) {
            whereParameters.put("Image", image);
        }
       
        return whereParameters;
    }
      
       ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Subscription", "select", parameters);
    }
       
     ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "Name, GroupName");

        List<Object> rows = new ArrayList<>();

        String category,image;
        Integer id,apartmentId;
        Date dueDate;
        do {
            System.out.println("Fields to insert:");
            category = getString("Category : ", false);
            image = getString("Image : ", false);
            System.out.println();
            id = getInteger("Id", false);
            System.out.println();
            apartmentId = getInteger("ApartmentID", false);
            System.out.println();
            dueDate = getDate("DueDate", false);
            System.out.println();
     //printleri sor       

//id !=null sor
            if (category != null && image != null && id != null && apartmentId != null && dueDate != null) {
                rows.add(new Subscription(id,category,dueDate,apartmentId,image));
            }
        } while (category != null && image != null && id != null && apartmentId != null && dueDate != null );

        parameters.put("rows", rows);

        return new ViewData("Subscription", "insert", parameters);
    }   

     ViewData updateGUI(ModelData modelData) throws Exception {
        //true'ları sor
        System.out.println("Fields to update:");
        Integer id = getInteger("Id : ", true);
        String category = getString("Category : ", true);
        Date dueDate = getDate("DueDate :", true);
        Integer apartmentId = getInteger("ApartmentId", true);
        String image = getString("Image : ", true);
       
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (id != null) {
            updateParameters.put("Id", id);
        }
        if (category != null) {
            updateParameters.put("Category", category);
        }
        if (dueDate != null) {
            updateParameters.put("DueDate", dueDate);
        }
        if (apartmentId!= null) {
            updateParameters.put("ApartmentId", apartmentId);
        }
        if (image != null) {
            updateParameters.put("Image", image);
        }
        

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Subscription", "update", parameters);
    }
     
     
      ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Subscription", "delete", parameters);
    }
     
      
        @Override
    public String toString() {
        return "Subscription View";
    }
}
