/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApartmentManagementMVC.Controller;

import ApartmentManagementMVC.Model.ModelData;
import ApartmentManagementMVC.Model.ModelInterface;
import ApartmentManagementMVC.View.ViewData;
import ApartmentManagementMVC.View.ViewInterface;
import ApartmentManagementMVC.View.MainMenuView;


/**
 *7
 * /s
 * @author ozkan
 */
public class Controller {
    private ViewInterface view;
	private ModelInterface model;
	
	public Controller(ViewInterface view, ModelInterface model) {
		this.view = view;
		this.model = model;
	}
	
	public ModelData executeModel(ViewData viewData) throws Exception {
		return model.execute(viewData);
	}

	public ViewData getView(ModelData modelData, String functionName, String operationName) throws Exception {
		return view.create(modelData, functionName, operationName);
	}
        
        public void getMainMenuView()throws Exception{
            MainMenuView mainMenu = new MainMenuView();
             mainMenu.begin();
        }
	
	@Override
	public String toString() {
		return "Controller with " + model + " and " + view;
	}	
}
