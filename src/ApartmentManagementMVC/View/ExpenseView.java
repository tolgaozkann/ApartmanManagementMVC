/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Entity.Expense;
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
 * @author emreo
 */
public class ExpenseView implements ViewInterface{
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
                int id = resultSet.getInt("Id");
                BigDecimal amount = resultSet.getBigDecimal("Amount");
                String description = resultSet.getString("Description");
                Date date = resultSet.getDate("Date");
                

                // Display values
                System.out.print(id + "\t");
                System.out.print(amount + "\t");
                System.out.println(description + "\t");
                System.out.println(date + "\t");
                
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
        Integer id = getInteger("Id : ", true);
        Double amountDouble = getDouble("Amount : ", true);
        BigDecimal amount = new BigDecimal(amountDouble);
        String description = getString("Description : ", true);
        Date date = getDate("Date :", true);
        

        Map<String, Object> whereParameters = new HashMap<>();
        if (id != null) {
            whereParameters.put("Id", id);
        }
        if (amount != null) {
            whereParameters.put("Amount", amount);
        }
        if (description != null) {
            whereParameters.put("Description", description);
        }
        if (date != null) {
            whereParameters.put("Date", date);
        }

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Expense", "select", parameters);
    }

    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "Name, GroupName");

        List<Object> rows = new ArrayList<>();

      
        Integer id;
        Double amountdouble;
        String description;
        Date date;
        do {
            System.out.println("Fields to insert:");
            id = getInteger("Id : ", false);
            amountdouble = getDouble("Amount : ", false);
            BigDecimal amount = new BigDecimal(amountdouble);
            System.out.println();
            description = getString("Description : ", false);
            System.out.println();
            date = getDate("Date : ", false);
            System.out.println();
            

            if (id != null && description != null && date != null ) {
                rows.add(new Expense(id, amount, description, date));
            }
        } while (id != null && amountdouble != null && description != null && date != null );

        parameters.put("rows", rows);

        return new ViewData("Expense", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        Integer id = getInteger("Id : ", true);
        Double amountDouble = getDouble("Amount : ", true);
        BigDecimal amount = new BigDecimal(amountDouble);
        String description = getString("Description :", true);
        Date date = getDate("Date :", true);
        
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (id != null) {
            updateParameters.put("Id", id);
        }
        if (amount != null) {
            updateParameters.put("Amount", amount);
        }
        if (description != null) {
            updateParameters.put("Description", description);
        }
        if (date != null) {
            updateParameters.put("Date", date);
        }
        

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Expense", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Expense", "delete", parameters);
    }

    @Override
    public String toString() {
        return "Expense View";
    }
}
