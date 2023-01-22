/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.Model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ozkan
 */
public class NopModel implements ModelInterface{
    @Override
	public ResultSet select(Map<String, Object> whereParameters) throws Exception {
		return null;
	}

	@Override
	public int insert(String fieldNames, List<Object> rows) throws Exception {
		return 0;
	}

	@Override
	public int update(Map<String, Object> updateParameters, Map<String, Object> whereParameters) throws Exception {
		return 0;
	}

	@Override
	public int delete(Map<String, Object> whereParameters) throws Exception {
		return 0;
	}

	@Override
	public String toString() {
		return "No Operation Model";
	}
}
