/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;
import ApartmentManagementMVC.Entity.Income;
import ApartmentManagementMVC.Model.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author ozkan
 */
public class IncomeView implements ViewInterface{
    
    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int id = resultSet.getInt("Id");
                Double balance = resultSet.getDouble("Amount");
                String description = resultSet.getString("Description");
                int flatId = resultSet.getInt("FlatId");
                Date date = resultSet.getDate("Date");


                // Display values
                System.out.print(id + "\t");
                System.out.print(balance + "\t");
                System.out.print(description + "\t");
                System.out.print(flatId + "\t");
                System.out.print(date + "\t");

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
        Integer accountNo = getInteger("Id : ", true);
        Double amount = getDouble("Amount : ", true);
        String description = getString("Description : ", true);
        Integer flatId = getInteger("FlatId : ",true);
        java.util.Date date = getDate("Date : ",true);


        Map<String, Object> whereParameters = new HashMap<>();
        if (accountNo != null) {
            whereParameters.put("AccountNo", accountNo);
        }
        if (amount != null) {
            whereParameters.put("Amount", amount);
        }
        if (description != null) {
            whereParameters.put("Description", description);
        }
        if (flatId != null) {
            whereParameters.put("FlatId", flatId);
        }
        if (date != null) {
            whereParameters.put("Date", date);
        }


        return whereParameters;
    }


    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Income", "select", parameters);
    }


    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "Amount, Description, FlatId, Date");

        List<Object> rows = new ArrayList<>();

        Integer flatId;
        Double amount;
        String description;
        java.util.Date date;
        do {
            System.out.println("Fields to insert:");
            amount = getDouble("Amount : ", false);
            System.out.println();
            description = getString("Description",false);
            flatId = getInteger("FlatId", false);
            System.out.println();
            date = getDate("Date",false);



            
            BigDecimal amountDecimal = new BigDecimal(amount);

            if (flatId != null && amountDecimal != null && description != null && date != null ) {
                rows.add(new Income(amountDecimal, description, flatId, date));
            }
        } while (flatId != null && amount != null && description != null && date != null );

        parameters.put("rows", rows);

        return new ViewData("Income", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        Integer id = getInteger("Id : ", true);
        Double amount = getDouble("Amount : ", true);
        String description = getString("Description : ", true);
        Integer flatId = getInteger("FlatId : ",true);
        java.util.Date date = getDate("Date : ",true);
        
        BigDecimal amountDecimal = new BigDecimal(amount);


        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (id != null) {
            updateParameters.put("Id", id);
        }
        if (amountDecimal != null) {
            updateParameters.put("Amount", amountDecimal);
        }
        if (description != null) {
            updateParameters.put("Description", description);
        }
        if (flatId != null) {
            updateParameters.put("FlatId", flatId);
        }
        if (date != null) {
            updateParameters.put("Date", date);
        }


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Income", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Income", "delete", parameters);
    }

    @Override
    public String toString() {
        return "Income View";
    }

    
}
