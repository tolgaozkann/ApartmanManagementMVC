/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Entity.MajorityVoting;
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
public class MajorityVotingView implements ViewInterface{
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
                int apartmentId = resultSet.getInt("ApartmentId");
                String topic = resultSet.getString("Topic");
                String description = resultSet.getString("Description");
                Boolean result = resultSet.getBoolean("Result");
                Date date = resultSet.getDate("Date");
                int requiredVotes = resultSet.getInt("RerquiredVotes");

                // Display values
                System.out.print(id + "\t");
                System.out.print(apartmentId + "\t");
                System.out.println(topic + "\t");
                System.out.println(description + "\t");
                System.out.println(result + "\t");
                System.out.println(date + "\t");
                System.out.print(requiredVotes + "\t");
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
        Integer apartmentId = getInteger("ApartmentId : ", true);
        String topic = getString("Topic : ", true);
        String description = getString("Description : ", true);
        Boolean result = getBoolean("Result  : ", true);
        Date date = getDate("Date : ",true);
        Integer requiredVotes = getInteger("RequiredVotes : ", true);

        Map<String, Object> whereParameters = new HashMap<>();
        if (id != null) {
            whereParameters.put("Id", id);
        }
        if (apartmentId != null) {
            whereParameters.put("ApartmentId", apartmentId);
        }
        if (topic != null) {
            whereParameters.put("Topic", topic);
        }
        if (description != null) {
            whereParameters.put("Description", description);
        }
        if (result != null) {
            whereParameters.put("Result", result);
        }
        if (date != null) {
            whereParameters.put("Date", date);
        }
        if (requiredVotes != null) {
            whereParameters.put("RequiredVotes", requiredVotes);
        }

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("MajorityVoting", "select", parameters);
    }

    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fieldNames", "Name, GroupName");

        List<Object> rows = new ArrayList<>();

        String topic, description;
        Integer id,apartmentId,requiredVotes;
        Date date;
        Boolean result;
        do {
            System.out.println("Fields to insert:");
            id = getInteger("Id : ", false);
            apartmentId = getInteger("ApartmentId : ", false);
            System.out.println();
            topic = getString("Topic : ", false);
            System.out.println();
            description = getString("Description : ", false);
            System.out.println();
            result = getBoolean("Result : ", false);
            System.out.println();
            date = getDate("Date : ", false);
            System.out.println();
            requiredVotes = getInteger("RequiredVotes : ", false);
            System.out.println();

           

            if (id != null && apartmentId != null && topic != null && description != null && result != null && date!= null && requiredVotes !=null ) {
                rows.add(new MajorityVoting(id, apartmentId, topic, description, result,date, requiredVotes));
            }
        } while (id != null && apartmentId != null && topic != null && description != null && result != null && date != null && requiredVotes !=null);

        parameters.put("rows", rows);

        return new ViewData("MajorityVoting", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        Integer id = getInteger("Id : ", true);
        Integer apartmentId = getInteger("ApartmentId : ", true);
        String topic = getString("Topic :", true);
        String description = getString("Description", true);
        Boolean result = getBoolean("Result : ", true);
        Date date = getDate("Date : ", true);
        Integer requiredVotes = getInteger("RequiredVotes : ", true);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (id != null) {
            updateParameters.put("Id", id);
        }
        if (apartmentId != null) {
            updateParameters.put("ApartmentId", apartmentId);
        }
        if (topic != null) {
            updateParameters.put("Topic", topic);
        }
        if (description != null) {
            updateParameters.put("Description", description);
        }
        if (result != null) {
            updateParameters.put("Result", result);
        }
        if (date != null) {
            updateParameters.put("Date", date);
        }
        if (requiredVotes != null) {
            updateParameters.put("RequiredVotes", requiredVotes);
        }

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("MajorityVoting", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("MajorityVoting", "delete", parameters);
    }

    @Override
    public String toString() {
        return "MajorityVoting View";
    }
}
