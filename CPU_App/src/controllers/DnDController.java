package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.PageFinder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DnDController implements Initializable{
	private double placeX = 0, placeY = 0, startX = 0, startY = 0;

	   @FXML
	   private MenuBar menu;

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
	    public void initialize(URL arg0, ResourceBundle arg1) {}

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
