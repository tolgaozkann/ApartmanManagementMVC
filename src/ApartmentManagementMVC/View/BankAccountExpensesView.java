/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Entity.BankAccountExpenses;
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
public class BankAccountExpensesView implements ViewInterface {
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
                
                BigDecimal bankAccountId = resultSet.getBigDecimal("BankAccountId");
                int expenseId = resultSet.getInt("ExpenseId");
                Date date = resultSet.getDate("Date");
                String bill = resultSet.getString("Bill");
                
                // Display values
                System.out.print(bankAccountId + "\t");
                System.out.print(expenseId + "\t");
                System.out.println(date + "\t");
                System.out.println(bill + "\t");
                
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
        Double bankAccountIdDouble = getDouble("BankAccountId : ", true);
        BigDecimal bankAccountId = new BigDecimal(bankAccountIdDouble);
        Integer expenseId = getInteger("ExpenseId : ", true);
        Date date = getDate("Date : ", true);
        String bill = getString("Bill :", true);
        
        Map<String, Object> whereParameters = new HashMap<>();
        if (bankAccountId != null) {
            whereParameters.put("BankAccountId", bankAccountId);
        }
        if (expenseId != null) {
            whereParameters.put("ExpenseId", expenseId);
        }
        if (date != null) {
            whereParameters.put("Date", date);
        }
        if (bill != null) {
            whereParameters.put("Bill", bill);
        }
        

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("BankAccountExpenses", "select", parameters);
    }

    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "Name, GroupName");

        List<Object> rows = new ArrayList<>();

        Double bankAccountIdDouble;
        Integer expenseId;
        Date date;
        String bill;
        
        do {
            System.out.println("Fields to insert:");
            bankAccountIdDouble = getDouble("BankAccountId : ", false);
            expenseId = getInteger("ExpenseId : ", false);
            System.out.println();
            date = getDate("Date : ", false);
            System.out.println();
            bill = getString("Bill : ", false);
            System.out.println();
            
            BigDecimal bankAccountId = new BigDecimal(bankAccountIdDouble);

            if (expenseId != null && date != null && bill != null) {
                rows.add(new BankAccountExpenses(bankAccountId, expenseId, date, bill));
            }
        } while (bankAccountIdDouble != null && expenseId != null && date != null && bill != null);

        parameters.put("rows", rows);

        return new ViewData("BankAccountExpenses", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        Double bankAccountIdDouble = getDouble("BankAccountId : ", true);
        BigDecimal bankAccountId = new BigDecimal(bankAccountIdDouble);
        Integer expenseId = getInteger("ExpenseId : ", true);
        Date date = getDate("Date :", true);
        String bill = getString("Bill", true);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (bankAccountId != null) {
            updateParameters.put("BankAccountId", bankAccountId);
        }
        if (expenseId != null) {
            updateParameters.put("ExpenseId", expenseId);
        }
        if (date != null) {
            updateParameters.put("Date", date);
        }
        if (bill != null) {
            updateParameters.put("Bill", bill);
        }
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("BankAccountExpenses", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("BankAccountExpenses", "delete", parameters);
    }

    @Override
    public String toString() {
        return "BankAccountExpenses View";
    }
}
