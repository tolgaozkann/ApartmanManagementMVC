/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Entity.BankAccountIncome;
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
public class BankAccountIncomeView implements ViewInterface  {
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
               Integer incomeId = resultSet.getInt("incomeId");
                Date date = resultSet.getDate("Date");
                String receipt = resultSet.getString("Receipt");
                Integer payerPersonId = resultSet.getInt("PayerPersonId");

                // Display values
                System.out.print(bankAccountId + "\t");
                System.out.print(incomeId + "\t");
                System.out.println(date + "\t");
                System.out.println(receipt + "\t");
                System.out.println(payerPersonId + "\t");
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
        
        Double bankAccountIdDouble = getDouble("BankAccountId", true)
                ;
        BigDecimal  bankAccountId = new BigDecimal(bankAccountIdDouble);
        Integer incomeId = getInteger("IncomeId ", true);
        Date date = getDate("Date ", true);
        String receipt = getString("Receipt", true);
        Integer payerPersonId = getInteger("PayerPersonId", true);
     

        Map<String, Object> whereParameters = new HashMap<>();
        if (bankAccountId != null) {
            whereParameters.put("BankAccountId", bankAccountId);
        }
        if (incomeId != null) {
            whereParameters.put("IncomeId", incomeId);
        }
        if (date != null) {
            whereParameters.put("Date", date);
        }
        if (receipt != null) {
            whereParameters.put("Receipt", receipt);
        }
        if (payerPersonId != null) {
            whereParameters.put("PayerPersonId", payerPersonId);
        }

        return whereParameters;
    }
     
      ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("BankAccountIncome", "select", parameters);
    }
      
      ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        //------
        parameters.put("fieldNames", "Name, GroupName");

        List<Object> rows = new ArrayList<>();

        String receipt;
        Date date;
        Integer incomeId,payerPersonId;
        Double bankAccountIdDouble;
        do {
            System.out.println("Fields to insert:");
            receipt = getString("Receipt : ", false);
            date = getDate("Date : ", false);
            System.out.println();
            incomeId = getInteger("IncomeId : ", false);
            System.out.println();
            bankAccountIdDouble = getDouble("BankAccountId : ", false);
            System.out.println();
            payerPersonId = getInteger("PayerPersonId : ", false);
            System.out.println();
            

            BigDecimal bankAccountId = new BigDecimal(bankAccountIdDouble);

            if (receipt != null && date != null && incomeId != null && bankAccountId != null && payerPersonId != null) {
                rows.add(new BankAccountIncome(bankAccountId, incomeId, date, receipt, payerPersonId));
            }
        } while (receipt != null && date != null && incomeId != null && bankAccountIdDouble != null && payerPersonId != null );

        parameters.put("rows", rows);

        return new ViewData("BankAccountIncome", "insert", parameters);
    }
      ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        Double bankAccountIdDouble = getDouble("BankAccountId", true);
        BigDecimal bankAccountId = new BigDecimal(bankAccountIdDouble);
        Integer incomeId = getInteger("IncomeId :", true);
        Date date = getDate("Date ", true);
        String receipt  = getString("Receipt ", true);
        Integer payerPersonId = getInteger("PayerPersonId", true);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (bankAccountId != null) {
            updateParameters.put("BankAccountId", bankAccountId);
        }
        if (incomeId != null) {
            updateParameters.put("IncomeId", incomeId);
        }
        if (date != null) {
            updateParameters.put("Date", date);
        }
        if (receipt != null) {
            updateParameters.put("Receipt", receipt);
        }
        if (payerPersonId != null) {
            updateParameters.put("PayerPersonId", payerPersonId);
        }
        

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("BankAccountIncome", "update", parameters);
    }
          ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("BankAccountIncome", "delete", parameters);
    }

    @Override
    public String toString() {
        return "BankAccountIncome View";
    }


}
