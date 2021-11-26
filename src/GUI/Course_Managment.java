package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Course_Managment extends Application{
	Stage window;
	
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		
		AdminDashBoard BK = new AdminDashBoard();
		AddCourse ac = new AddCourse();
		UpdateCourse Uc = new UpdateCourse();
		ViewCourses Vc = new ViewCourses();
		
		GridPane coursegrid = new GridPane();
		coursegrid.setAlignment(Pos.CENTER);
		coursegrid.setVgap(40);
		coursegrid.setHgap(10);
		coursegrid.setPadding(new Insets(10));
		
		
		Button btn1 = new Button("Add Course");
		btn1.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
		btn1.setOnAction(e->{
			try {
				ac.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		coursegrid.add(btn1, 0, 0);
		Button btn2 = new Button("View Courses");
		btn2.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
		btn2.setOnAction(e->{
			try {
				Vc.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		coursegrid.add(btn2, 0, 1);
		Button btn3 = new Button("Manage Course");
		btn3.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
		btn3.setOnAction(e->{
			try {
				Uc.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		coursegrid.add(btn3, 0, 2);
		
		Button backbtn = new Button("<BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		coursegrid.add(backbtn, 0, 4);
		
		Scene coursescene = new Scene(coursegrid,600,600);
		window.setTitle("Course Managment");
		window.setScene(coursescene);
	}

}
