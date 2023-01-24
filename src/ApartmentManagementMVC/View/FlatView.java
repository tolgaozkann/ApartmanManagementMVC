/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import ApartmentManagementMVC.Entity.Flat;

import ApartmentManagementMVC.Model.ModelData;
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
public class FlatView implements ViewInterface {

    @Override
    public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

        switch (operationName) {
            case "select":
                return selectOperation(modelData);
            case "insert":
                return insertOperation(modelData);
            case "update":
                return updateOperation(modelData);
            case "delete":
                return deleteOperation(modelData);
            case "select.gui":
                return selectGUI(modelData);
            case "insert.gui":
                return insertGUI(modelData);
            case "update.gui":
                return updateGUI(modelData);
            case "delete.gui":
                return deleteGUI(modelData);
        }

        return new ViewData("MainMenu", "");
    }

    ViewData selectOperation(ModelData modelData) throws Exception {
        ResultSet resultSet = modelData.resultSet;

        if (resultSet != null) {
            while (resultSet.next()) {
                // Retrieve by column name
                int flatId = resultSet.getInt("FlatId");
                int apartmentNo = resultSet.getInt("ApartmentNo");
                int flatNo = resultSet.getInt("FlatNo");

                // Display values
                System.out.print(flatId + "\t");
                System.out.print(apartmentNo + "\t");
                System.out.print(flatNo + "\t");

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
        Integer FlatId = getInteger("FlatId: ", true);
        Integer ApartmentNo = getInteger("ApartmentNo : ", true);
        Integer FlatNo = getInteger("FlatNo: ", true);

        Map<String, Object> whereParameters = new HashMap<>();
        if (FlatId != null) {
            whereParameters.put("FlatId", FlatId);
        }
        if (ApartmentNo != null) {
            whereParameters.put("ApartmentNo", ApartmentNo);
        }
        if (FlatNo != null) {
            whereParameters.put("FlatNo", FlatNo);
        }

        return whereParameters;
    }

    ViewData selectGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Flat", "select", parameters);
    }

    ViewData insertGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
       
        parameters.put("fieldNames", "ApartmentNo, FlatNo");

        List<Object> rows = new ArrayList<>();

        Integer flatId, apartmentNo, flatNo;
        do {
            System.out.println("Fields to insert:");
           
            apartmentNo = getInteger("ApartmentNo ", false);
            flatNo = getInteger("FlatNo ", false);
            System.out.println();

            if (apartmentNo != null && flatNo != null) {
                rows.add(new Flat( apartmentNo, flatNo));
            }
        } while (apartmentNo != null && flatNo != null);

        parameters.put("rows", rows);

        return new ViewData("Flat", "insert", parameters);
    }

    ViewData updateGUI(ModelData modelData) throws Exception {
        System.out.println("Fields to update:");
        Integer FlatId = getInteger("FlatId: ", true);
        Integer ApartmentNo = getInteger("ApartmentNo : ", true);
        Integer FlatNo = getInteger("FlatNo: ", true);
        System.out.println();

        Map<String, Object> updateParameters = new HashMap<>();
        if (FlatId != null) {
            updateParameters.put("FlatId", FlatId);
        }
        if (ApartmentNo != null) {
            updateParameters.put("ApartmentNo", ApartmentNo);
        }
        if (FlatNo != null) {
            updateParameters.put("FlatNo", FlatNo);
        }

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("updateParameters", updateParameters);
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Flat", "update", parameters);
    }

    ViewData deleteGUI(ModelData modelData) throws Exception {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("whereParameters", getWhereParameters());

        return new ViewData("Flat", "delete", parameters);
    }

    @Override
    public String toString() {
        return "Flat View";
    }

}
