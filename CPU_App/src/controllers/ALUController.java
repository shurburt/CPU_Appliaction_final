package controllers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import application.PageFinder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import database.*;


public class ALUController implements Initializable {
	@FXML Line line11;@FXML Line line12;@FXML Line line21;@FXML Line line22;@FXML Line line31;@FXML Line line41;
	@FXML Line line51;@FXML Line line52;@FXML Line line61;@FXML Line line71;@FXML Line line81;@FXML Line line91;
	@FXML Line line92;@FXML Line line93;@FXML Line line94;@FXML Line line95;@FXML Line line101;@FXML Line line111;
	@FXML Line line112;@FXML Line line121;@FXML Line line122;@FXML Line line123;@FXML Line line124;@FXML Line line131;
	@FXML Line line141;@FXML Line line142;@FXML Line line143;@FXML Line line144;@FXML Line line145;@FXML Line line151;
	@FXML Line line152;@FXML Line line161;@FXML Line line171;@FXML Line line172;@FXML Line line173;@FXML Line line174;
	@FXML Line line175;@FXML Line line42;

	String user="";
	int instCount = 12;


	@FXML MenuItem currentUser;
	@FXML Label feedback;
	@FXML Label InstCount;
	@FXML MenuBar menu;
	Circle checkButton = null;
	Circle btn =null;
	Boolean canChange = false;
	Boolean changed =false;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		setInstCount();
		File f = new File("src/Files/user.txt");

		try {
			Scanner scanner = new Scanner(f);
			if(scanner.hasNext())
				user = scanner.next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!user.equals("")){
			boolean[] dpload = UserDatabase.getUserData(user).getDPBRANCH();
			int count = UserDatabase.getCount(UserDatabase.getUserData(user).getDPBRANCH());
			for(int i=0;i<count;i++)
				if(dpload[i] == true)
					initializeLines(i);

		}
		currentUser.setText(user);

	}

	private double placeX = 0, placeY = 0, startX = 0, startY = 0;

	   @FXML
	   private TextField text;

	    @FXML
	    private void setDragStart(MouseEvent e) {
	        if(e.getSource() instanceof StackPane) {
	        	StackPane drag = (StackPane) e.getSource();
	            startX = drag.getLayoutX();
	            startY = drag.getLayoutY();
	            Dragboard db = drag.startDragAndDrop(TransferMode.ANY);
	            ClipboardContent content = new ClipboardContent();
	            content.putString(drag.getId());
	            db.setContent(content);
	            db.setDragView(drag.snapshot(null, null), e.getX(), e.getY());
	            System.out.println("dragging");
	        }
	        e.consume();
	    }

	    @FXML
	    private void setDragMove(DragEvent e) {
	        if((e.getGestureSource() instanceof StackPane)
	                && e.getDragboard().hasString()) {
	            e.acceptTransferModes(TransferMode.MOVE);
	        }
	        e.consume();
	    }
	    @FXML
	    private void setDragEnter(DragEvent e) {
	       if(e.getSource() instanceof StackPane) {
	           StackPane drop = (StackPane) e.getSource();
	           if((e.getGestureSource() instanceof StackPane)
	                   && e.getDragboard().hasString()) {
	               //drop.setStroke(Color.WHEAT);
	               //drop.setStrokeWidth(3);
	           }
	       }
	       e.consume();
	    }

	    @FXML
	    private void setDragExit(DragEvent e) {
	       if(e.getSource() instanceof StackPane) {
	           StackPane drop = (StackPane) e.getSource();
	           //drop.setStroke(Color.BLACK);
	           //drop.setStrokeWidth(1);
	       }
	       e.consume();
	   }
	   @FXML
	    private void setDragDropped(DragEvent e) {
	       if(e.getSource() instanceof StackPane) {
	            StackPane drop = (StackPane) e.getSource();
	            Dragboard db = e.getDragboard();
	            if(db.hasString() && db.getString().equals(drop.getId())) {
	                placeX = drop.getLayoutX();
	                placeY = drop.getLayoutY();
	            } else {
	                placeX = startX;
	                placeY = startY;
	            }
	            e.setDropCompleted(true);
	       }
	       e.consume();
	   }
	    @FXML
	    private void setDragDone(DragEvent e) {
	        if(e.getTransferMode() == TransferMode.MOVE
	                && e.getSource() instanceof StackPane) {
	        	StackPane drag = (StackPane) e.getSource();
	            drag.setLayoutX(placeX);
	            drag.setLayoutY(placeY);
	            drag.setCursor(Cursor.DEFAULT);
	        }
	        e.consume();
	    }

	    @FXML
	    private void showMySpot(MouseEvent e) {
	        text.setText("x: " + e.getX() + "y: " + e.getY());
	    }

	public void mouseEntered(MouseEvent event){
		System.out.print("Mouse Enter");
		canChange = true;
	}
	public void mouseExit(MouseEvent event){
		System.out.print("Mouse exit");
		canChange =false;
	}
	public void mouseReleased(MouseEvent event){
		Circle cir = (Circle)event.getSource();
		if(canChange && !changed && cir.getFill().equals((Color.GREEN))){
			changed =true;
			cir.setFill(Color.RED);
		}
		if(canChange && !changed && cir.getFill().equals((Color.RED))){
			changed =true;
			cir.setFill(Color.GREEN);
		}
	}
	public void mouseClicked(MouseEvent event){
		btn = (Circle) event.getSource();

		if(checkButton != null){
			System.out.println("Check Button: " + checkButton.getId());
		}

		System.out.println("Pressed Button: " + btn.getId());

		if(checkButton == null){
			checkButton = btn;
			changed=false;
		}
		else if(checkButton.getId().equals(btn.getId())){
			checkButton = null;
			changed=false;
		}
		else if(checkButton !=null && !checkButton.getId().equals(btn.getId())){
			setLines();
		}
	}

	public void setLines(){

		if( (checkButton.getId().equals("tb1") && btn.getId().equals("tb2")) ||
				( btn.getId().equals("tb1")) && checkButton.getId().equals("tb2")) {

			line11.setVisible(true);line12.setVisible(true);
			btn.setFill(Color.GREEN);
			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(1);
		}
		else if(( checkButton.getId().equals("tb1") && btn.getId().equals("tb3") ) ||
				( btn.getId().equals("tb1")) && checkButton.getId().equals("tb3") ){

			line21.setVisible(true);line22.setVisible(true);
			btn.setFill(Color.GREEN);
			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(2);
		}
		else if(( checkButton.getId().equals("tb1") && btn.getId().equals("tb5")  ) ||
				( btn.getId().equals("tb1")) && checkButton.getId().equals("tb5")){

			line41.setVisible(true);line42.setVisible(true);
			btn.setFill(Color.GREEN);
			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(4);
		}
		else if(( checkButton.getId().equals("tb1") && btn.getId().equals("tb6") ) ||
				( btn.getId().equals("tb1")) && checkButton.getId().equals("tb6") ){

			line51.setVisible(true);line52.setVisible(true);
			btn.setFill(Color.GREEN);
			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(5);
		}
		else if(( checkButton.getId().equals("tb7") && btn.getId().equals("tb8")) ||
				( btn.getId().equals("tb7")) && checkButton.getId().equals("tb8")  ){

			line61.setVisible(true);
			btn.setFill(Color.GREEN);
			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(6);
		}
		else if(( checkButton.getId().equals("tb9") && btn.getId().equals("tb10")  ) ||
				( btn.getId().equals("tb9")) && checkButton.getId().equals("tb10")){

			line71.setVisible(true);
			btn.setFill(Color.GREEN);
			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(7);
		}
		else if(( checkButton.getId().equals("tb9") && btn.getId().equals("tb12")  ) ||
				( btn.getId().equals("tb9")) && checkButton.getId().equals("tb12")){
			line91.setVisible(true);line92.setVisible(true);line93.setVisible(true);
			line94.setVisible(true);line95.setVisible(true);
			btn.setFill(Color.GREEN);
			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(9);
		}
		else if(( checkButton.getId().equals("tb13") && btn.getId().equals("tb14")  ) ||
				( btn.getId().equals("tb13")) && checkButton.getId().equals("tb14")){
			line101.setVisible(true);line111.setVisible(true);line112.setVisible(true);

			btn.setFill(Color.GREEN);

			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(11);
		}
		//mux
		else if(( checkButton.getId().equals("tb13") && btn.getId().equals("tb17")) ||
				( btn.getId().equals("tb13")) && checkButton.getId().equals("tb17")  ){

			line101.setVisible(true);line121.setVisible(true);line122.setVisible(true);
			line123.setVisible(true);line124.setVisible(true);

			btn.setFill(Color.GREEN);
			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(12);
		}
		else if(( checkButton.getId().equals("tb18") && btn.getId().equals("tb19")) ||
				( btn.getId().equals("tb18")) && checkButton.getId().equals("tb19")  ){

			line141.setVisible(true);line142.setVisible(true);line143.setVisible(true);
			line144.setVisible(true);line145.setVisible(true);
			btn.setFill(Color.GREEN);
			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(14);
		}
		else if(( checkButton.getId().equals("tb20") && btn.getId().equals("tb21")) ||
				( btn.getId().equals("tb20")) && checkButton.getId().equals("tb21")  ){

			line151.setVisible(true);line152.setVisible(true);
			btn.setFill(Color.GREEN);
			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(15);
		}
		else if(( checkButton.getId().equals("tb24") && btn.getId().equals("tb25")) ||
				( btn.getId().equals("tb24")) && checkButton.getId().equals("tb25")  ){

			line171.setVisible(true);line172.setVisible(true);line173.setVisible(true);
			line174.setVisible(true);line175.setVisible(true);
			btn.setFill(Color.GREEN);
			checkButton.setFill(Color.GREEN);
			checkButton=null;btn=null;changed=false;
			changeFeedback(true);changeInstCount();
			if(!user.equals(""))
			UserDatabase.getUserData(user).setDPALU(17);
		}
		else{
			btn.setFill(Color.GREEN);checkButton.setFill(Color.GREEN);
			checkButton=null;changed=false;btn=null;changeFeedback(false);
		}
	}





	private void changeFeedback(Boolean b){
		if(b){
			feedback.setText("Correct");
			feedback.setTextFill(Color.GREEN);
		}
		else{
			feedback.setText("In Correct");
			feedback.setTextFill(Color.RED);
		}
	}
	private void changeInstCount(){
		instCount = instCount -1;
		InstCount.setText(String.valueOf(instCount) + "\nInstructions Left\n");
	}
	private void setInstCount(){
		InstCount.setText(String.valueOf(instCount) + "\nInstructions Left\n");
	}


	public void initializeLines(int i){

		if(i==1) {
			line11.setVisible(true);line12.setVisible(true);
			changeInstCount();
		}
		else if(i==2){
			line21.setVisible(true);line22.setVisible(true);
			changeInstCount();
		}
		else if(i==4){
			line41.setVisible(true);line42.setVisible(true);
			changeInstCount();
		}
		else if(i==5){
			line51.setVisible(true);line52.setVisible(true);
			changeInstCount();
		}
		else if(i==6){
			line61.setVisible(true);
			changeInstCount();
		}
		else if(i==7){
			line71.setVisible(true);
			changeInstCount();
		}
		else if(i==9){
			line91.setVisible(true);line92.setVisible(true);line93.setVisible(true);
			line94.setVisible(true);line95.setVisible(true);
			changeInstCount();
		}
		else if(i==11){
			line101.setVisible(true);line111.setVisible(true);line112.setVisible(true);
			changeInstCount();
		}
		//mux
		else if(i==12){

			line101.setVisible(true);line121.setVisible(true);line122.setVisible(true);
			line123.setVisible(true);line124.setVisible(true);
			changeInstCount();
		}
		else if(i==14){

			line141.setVisible(true);line142.setVisible(true);line143.setVisible(true);
			line144.setVisible(true);line145.setVisible(true);
			changeInstCount();
		}
		else if(i==15){
			line151.setVisible(true);line152.setVisible(true);
			changeInstCount();
		}
		else if(i==17){
			line171.setVisible(true);line172.setVisible(true);line173.setVisible(true);
			line174.setVisible(true);line175.setVisible(true);
			changeInstCount();
		}

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
