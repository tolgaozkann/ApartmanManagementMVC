/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Entity.BankAccount;
import ApartmentManagementMVC.Model.ModelData;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author emreo
 */
public class BankAccountView implements ViewInterface{
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
                double accountNo = resultSet.getInt("AccountNo");
                BigDecimal balance = resultSet.getBigDecimal("Balance");
                int apartmentId = resultSet.getInt("ApartmentId");


                // Display values
                System.out.print(accountNo + "\t");
                System.out.print(balance + "\t");
                System.out.println(apartmentId + "\t");

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
        Double accountNo = getDouble("AccountNo : ", true);
        Double balance = getDouble("Balance : ", true);
        Integer apartmentId = getInteger("ApartmentId : ", true);


        Map<String, Object> whereParameters = new HashMap<>();
        if (accountNo != null) {
            whereParameters.put("AccountNo", accountNo);
        }
        if (balance != null) {
            whereParameters.put("Balance", balance);
        }
        if (apartmentId != null) {
            whereParameters.put("ApartmentId", apartmentId);
        }


        return whereParameters;
    }


    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("BankAccount", "select", parameters);
    }


    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "Name, GroupName");

        List<Object> rows = new ArrayList<>();

        Integer apartmentId;
        Double accountNoDouble,balanceDouble;
        do {
            System.out.println("Fields to insert:");
            accountNoDouble = getDouble("AccountNo : ", false);
            balanceDouble = getDouble("Balance : ", false);
            System.out.println();
            apartmentId = getInteger("ApartmentId", false);
            System.out.println();



            BigDecimal accountNo = new BigDecimal(accountNoDouble);
            BigDecimal balance = new BigDecimal(balanceDouble);

            if (accountNo != null && balance != null && apartmentId != null ) {
                rows.add(new BankAccount(accountNo, balance, apartmentId));
            }
        } while (accountNoDouble != null && balanceDouble != null && apartmentId != null );

        parameters.put("rows", rows);

        return new ViewData("BankAccount", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        Double accountNoDouble = getDouble("AccountNo : ", true);
        Double balanceDouble = getDouble("Balance : ", true);
        Integer apartmentId = getInteger("ApartmentId :", true);
        BigDecimal accountNo = new BigDecimal(accountNoDouble);
        BigDecimal balance = new BigDecimal(balanceDouble);


        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (accountNo != null) {
            updateParameters.put("AccountNo", accountNo);
        }
        if (balance != null) {
            updateParameters.put("Balance", balance);
        }
        if (apartmentId != null) {
            updateParameters.put("ApartmentId", apartmentId);
        }


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("BankAccount", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("BankAccount", "delete", parameters);
    }

    @Override
    public String toString() {
        return "BankAccount View";
    }
}
