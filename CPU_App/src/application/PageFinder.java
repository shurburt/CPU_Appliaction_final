package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class PageFinder {
	public static String findPage(String str) throws Exception{
		String root ="";
		if(str.equals("DPALU")){
			root = "/FXML/menuALU.fxml";
		}
		else if(str.equals("DPSTORE")){
			root = "/FXML/menuStore.fxml";
		}
		else if(str.equals("DPBRANCH")){
			root = "/FXML/menuBranch.fxml";
		}
		else if(str.equals("DPLOAD")){
			root = "/FXML/menuLoad.fxml";
		}
		else if(str.equals("switch")){
			root = "/FXML/menuUser.fxml";
		}
		else if(str.equals("CPALU")){
			root = "/FXML/menuCUALU.fxml";
		}
		else if(str.equals("CPSTORE")){
			root = "/FXML/menuCUStore.fxml";
		}
		else if(str.equals("CPLOAD")){
			root = "/FXML/menuCULoad.fxml";
		}
		else if(str.equals("CPBRANCH")){
			root = "/FXML/menuCUBranch.fxml";
		}
		else if(str.equals("drag")){
			root = "/FXML/Drag.fxml";
		}
		else if(str.equals("aluAN")){
			root = "/FXML/ALUanim.fxml";
		}
		else if(str.equals("loadAN")){
			root = "/FXML/LoadAnim.fxml";
		}
		else if(str.equals("storeAN")){
			root = "/FXML/StoreAnim.fxml";
		}
		return root;
	}
}
