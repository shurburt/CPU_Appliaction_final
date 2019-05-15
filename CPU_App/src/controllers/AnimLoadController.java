package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.PageFinder;

public class AnimLoadController implements Initializable {

    @FXML
    private Polyline testPath0, testPath1, testPath3, testPath6, testPath11, testPath25;
    @FXML
    private Polyline testPath7, testPath14, testPath19, testPath20 , testPath23, testPath22, testPath24;

    @FXML
    private Line testPath2, testPath5, testPath4, testPath13, testPath10, testPath12, testPath21;
    @FXML
    private Line testPath16, testPath15, testPath17, testPath18, testPath8, testPath9, testPath26;


    @FXML
    private Circle circle0, circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9, circle10;

    @FXML
    private Circle circle11, circle12, circle13, circle14, circle15, circle16, circle17, circle18, circle19, circle20, circle21;

    @FXML
    private Circle circle22, circle23, circle24, circle25;
    @FXML
    private Button btn;

    @FXML
    private TextField tA;

    @FXML MenuBar menu;
    private AnimateLoadWord loadWord;
    private ArrayList<Shape> lines;
    private ArrayList<Circle> circles;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lines = new ArrayList<>();
        circles = new ArrayList<>();
         makeArrayLists();


        loadWord = new AnimateLoadWord(circles, lines);


    }
    private void makeArrayLists() {

        lines.add(testPath0);
        lines.add(testPath1);
        lines.add(testPath2);
        lines.add(testPath3);
        lines.add(testPath4);
        //lines.add(testPath5);
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
        lines.add(testPath17);
        lines.add(testPath18);
        lines.add(testPath19);
        lines.add(testPath20);
        lines.add(testPath21);
        lines.add(testPath22);
        lines.add(testPath23);
        lines.add(testPath24);
        lines.add(testPath25);
        lines.add(testPath26);

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
        circles.add(circle17);
        circles.add(circle18);
        circles.add(circle19);
        circles.add(circle20);
        circles.add(circle21);
         circles.add(circle22);
        circles.add(circle23);
        circles.add(circle24);
        circles.add(circle25);


    }
    @FXML
    private void button() {
        btn.setOnAction(e -> loadWord.animate());
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
