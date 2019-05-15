package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.PageFinder;

public class AnimStoreController implements Initializable {

    @FXML
    private Polyline testPath0, testPath1, testPath3, testPath9, testPath13, testPath7;
    @FXML
    private Polyline testPath12, testPath11, testPath14, testPath15;

    @FXML
    private Line testPath2, testPath4, testPath10, testPath5, testPath6, testPath8, testPath16;

    @FXML MenuBar menu;

    @FXML
    private Circle circle0, circle1, circle2, circle3, circle4, circle5, circle6;

    @FXML
    private Circle circle7, circle8, circle9, circle10 ,circle11, circle12, circle13;
    @FXML
    private Circle circle14, circle15, circle16;

    @FXML
    private Button btn;

    @FXML
    private TextField tA;


    private AnimateStoreWord store;
    private ArrayList<Shape> lines;
    private ArrayList<Circle> circles;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lines = new ArrayList<>();
        circles = new ArrayList<>();
        makeArrayLists();


        store = new AnimateStoreWord(circles, lines);


    }
    private void makeArrayLists() {

        lines.add(testPath0);
        lines.add(testPath1);
        lines.add(testPath2);
        lines.add(testPath3);
        lines.add(testPath4);
        lines.add(testPath5);
        lines.add(testPath6);
        lines.add(testPath7);
        lines.add(testPath8);
        lines.add(testPath9);
        lines.add(testPath10);
        lines.add(testPath11);
        lines.add(testPath12);
        lines.add(testPath13);
        lines.add(testPath14);
        lines.add(testPath15);
        lines.add(testPath16);

        circles.add(circle0);
        circles.add(circle1);
        circles.add(circle2);
        circles.add(circle3);
        circles.add(circle4);
        circles.add(circle5);
        circles.add(circle6);
        circles.add(circle7);
        circles.add(circle8);
        circles.add(circle9);
        circles.add(circle10);
        circles.add(circle11);
        circles.add(circle12);
        circles.add(circle13);
        circles.add(circle14);
        circles.add(circle15);
        circles.add(circle16);


    }
    @FXML
    private void button() {
        btn.setOnAction(e -> store.animate());
    }
    @FXML
    private void showMySpot(MouseEvent e) {
        tA.setText("x: " + e.getX() + "y: " + e.getY());
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
