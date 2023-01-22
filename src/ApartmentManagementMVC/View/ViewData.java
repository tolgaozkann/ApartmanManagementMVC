/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.View;

import java.util.Map;

/**
 *
 * @author ozkan
 */
public class ViewData {

    public final String functionName;
    public final String operationName;
    public final Map<String, Object> viewParameters;

    ViewData(String functionName, String operationName) {
        this.functionName = functionName;
        this.operationName = operationName;
        this.viewParameters = null;
    }

    ViewData(String functionName, String operationName, Map<String, Object> viewParameters) {
        this.functionName = functionName;
        this.operationName = operationName;
        this.viewParameters = viewParameters;
    }

    @Override
    public String toString() {
        return "Function name = " + functionName + " / " + operationName + " : " + viewParameters.toString();
    }
}
