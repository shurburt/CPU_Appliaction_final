package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

import application.PageFinder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import database.UserDatabase;
import database.UserData;

public class UserController implements Initializable {

	@FXML MenuBar menu; @FXML Button submit;
	@FXML Label welcome; @FXML Label e; @FXML MenuItem currentUser;
	@FXML TextField userName;
	Hashtable<String,UserData> database;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			UserDatabase.loadDatbase();
			//UserDatabase.clearDatabase();
			database = UserDatabase.getDatabase();
			File f = new File("src/Files/user.txt");
			FileWriter fw = new FileWriter(f);
			fw.write("");
			fw.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void handleSubmit(ActionEvent t) throws FileNotFoundException, IOException, ClassNotFoundException{
		File f = new File("src/Files/user.txt");
		FileWriter fw = new FileWriter(f);
		String s = userName.getText();
		System.out.println(s);
		fw.write(userName.getText());
		fw.close();

		submit.setVisible(false); e.setVisible(false); userName.setVisible(false);

		if(database.containsKey(s)){
			welcome.setVisible(true);welcome.setText("Welcome Back"+ s + "!");
		}
		else{
			welcome.setVisible(true);welcome.setText("Welcome "+ s + "!");
			UserDatabase.setUserData(s,new UserData());
			try {
				UserDatabase.saveDatabase();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		currentUser.setText(s);

	}
	public void handleMenu(ActionEvent t) throws Exception{
		MenuItem menuItem = (MenuItem)t.getSource();
		String str = PageFinder.findPage(menuItem.getId());
		Parent root = FXMLLoader.load(getClass().getResource(str));
		Stage stage = (Stage) menu.getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
