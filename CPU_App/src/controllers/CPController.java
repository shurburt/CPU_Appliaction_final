package controllers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.PageFinder;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import database.*;


public class CPController implements Initializable {
	@FXML Line line11;@FXML Line line12;@FXML Line line21;@FXML Line line22;@FXML Line line31;@FXML Line line41;
	@FXML Line line51;@FXML Line line52;@FXML Line line61;@FXML Line line71;@FXML Line line81;@FXML Line line91;
	@FXML Line line92;@FXML Line line93;@FXML Line line94;@FXML Line line95;@FXML Line line101;@FXML Line line111;
	@FXML Line line112;@FXML Line line121;@FXML Line line122;@FXML Line line123;@FXML Line line124;@FXML Line line131;
	@FXML Line line141;@FXML Line line142;@FXML Line line143;@FXML Line line144;@FXML Line line145;@FXML Line line151;
	@FXML Line line152;@FXML Line line161;@FXML Line line171;@FXML Line line172;@FXML Line line173;@FXML Line line174;
	@FXML Line line175;@FXML Line line42;

	String user="";
	@FXML MenuItem currentUser;
	@FXML MenuBar menu;

	@FXML
	Button start,RegDst0,RegDst1,MemToReg0,MemToReg1,PCSrc0,PCSrc1,RegWrite0,
		   RegWrite1,ALUSrc0,ALUSrc1,MemWrite0,MemWrite1,MemRead0,MemRead1;
	@FXML
	Label RegDst,MemToReg,PCSrc,RegWrite,ALUSrc,MemWrite,MemRead,
		  RegDstRes,MemToRegRes,PCSrcRes,RegWriteRes,ALUSrcRes,MemWriteRes,MemReadRes;
	@FXML
	Line RD1,RD2,MTR1,MTR2,MR1,MR2,MW1,MW2,AS1,AS2,RW1,RW2,PC1,PC2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		File f = new File("src/Files/user.txt");

		try {
			Scanner scanner = new Scanner(f);
			if(scanner.hasNext())
				user = scanner.next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		currentUser.setText(user);
		//CB1.setItems(FXCollections.observableArrayList("0","1"));;
	}

	public void handleStart(ActionEvent t){
		start.setVisible(false);
		RegDst.setVisible(true);
		RD1.setVisible(true);RD2.setVisible(true);
		RegDst0.setVisible(true);RegDst1.setVisible(true);
	}
	public void handleRD(ActionEvent t){
		RegDstRes.setVisible(true);
		RegDst.setVisible(false);
		RD1.setVisible(false);RD2.setVisible(false);
		RegDst0.setVisible(false);RegDst1.setVisible(false);

		RegWrite.setVisible(true);
		RW1.setVisible(true);RW2.setVisible(true);
		RegWrite0.setVisible(true);RegWrite1.setVisible(true);
	}
	public void handleRW(ActionEvent t){
		RegWriteRes.setVisible(true);
		RegWrite.setVisible(false);
		RW1.setVisible(false);RW2.setVisible(false);
		RegWrite0.setVisible(false);RegWrite1.setVisible(false);

		ALUSrc.setVisible(true);
		AS1.setVisible(true);AS2.setVisible(true);
		ALUSrc0.setVisible(true);ALUSrc1.setVisible(true);
	}
	public void handleAS(ActionEvent t){
		ALUSrcRes.setVisible(true);
		ALUSrc.setVisible(false);
		AS1.setVisible(false);AS2.setVisible(false);
		ALUSrc0.setVisible(false);ALUSrc1.setVisible(false);

		MemWrite.setVisible(true);
		MW1.setVisible(true);MW2.setVisible(true);
		MemWrite0.setVisible(true);MemWrite1.setVisible(true);
	}
	public void handleMW(ActionEvent t){
		MemWriteRes.setVisible(true);
		MemWrite.setVisible(false);
		MW1.setVisible(false);MW2.setVisible(false);
		MemWrite0.setVisible(false);MemWrite1.setVisible(false);

		MemRead.setVisible(true);
		MR1.setVisible(true);MR2.setVisible(true);
		MemRead0.setVisible(true);MemRead1.setVisible(true);
	}
	public void handleMR(ActionEvent t){
		MemReadRes.setVisible(true);
		MemRead.setVisible(false);
		MR1.setVisible(false);MR2.setVisible(false);
		MemRead0.setVisible(false);MemRead1.setVisible(false);

		MemToReg.setVisible(true);
		MTR1.setVisible(true);MTR2.setVisible(true);
		MemToReg0.setVisible(true);MemToReg1.setVisible(true);
	}
	public void handleMTR(ActionEvent t){
		MemToRegRes.setVisible(true);
		MemToReg.setVisible(false);
		MTR1.setVisible(false);MTR2.setVisible(false);
		MemToReg1.setVisible(false);MemToReg0.setVisible(false);

		PCSrc.setVisible(true);
		PC1.setVisible(true);PC2.setVisible(true);
		PCSrc0.setVisible(true);PCSrc1.setVisible(true);
	}
	public void handlePC(ActionEvent t){
		PCSrcRes.setVisible(true);
		PCSrc.setVisible(false);
		PC1.setVisible(false);PC2.setVisible(false);
		PCSrc0.setVisible(false);PCSrc1.setVisible(false);
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
