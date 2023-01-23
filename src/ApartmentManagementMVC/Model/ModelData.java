/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.Model;

import java.sql.ResultSet;

/**
 *
 * @author ozkan
 */
public class ModelData {

    public final String modelName;
    public final ResultSet resultSet;
    public final int recordCount;

    ModelData() {
        this.modelName = null;
        this.resultSet = null;
        this.recordCount = 0;
    }

    ModelData(String modelName, ResultSet resultSet) {
        this.modelName = modelName;
        this.resultSet = resultSet;
        this.recordCount = 0;
    }

    ModelData(String modelName, int recordCount) {
        this.modelName = modelName;
        this.resultSet = null;
        this.recordCount = recordCount;
    }

    ModelData(String modelName, ResultSet resultSet, int recordCount) {
        this.modelName = modelName;
        this.resultSet = resultSet;
        this.recordCount = recordCount;
    }

    @Override
    public String toString() {
        return "Model Data (" + modelName + ")";
    }
}
