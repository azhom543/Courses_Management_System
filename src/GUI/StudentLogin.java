package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StudentLogin extends Application{
	Stage studentwindow;
        @Override
	public void start(Stage primaryStage) throws Exception {
			studentwindow = primaryStage;
			studentwindow.setTitle("Course Managment System");
                        
                        ShowGrades sg =  new ShowGrades();
                        StudentUpdateInfo SU = new StudentUpdateInfo();
                        StudentAddCourses addStd = new StudentAddCourses();
                        StudentServey ss = new StudentServey();
                        PersonGUI BK = new PersonGUI();
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(30);
			grid.setPadding(new Insets(10));
			
			
			Image image = new Image("file:C:\\Users\\DELL\\Desktop\\download (1).jpg");
			try {
				ImageView iv = new ImageView();
				iv.setImage(image);
				iv.setFitWidth(200);
				iv.setFitHeight(200);
				grid.add(iv, 0, 0);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			Button btn1 = new Button("Update Information");
                        btn1.setOnAction(e->{
                            try {
                                SU.start(primaryStage);
                            } catch (Exception ex) {
                                //System.out.println(ex);
                            }
                        });
			btn1.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
			grid.add(btn1, 0, 1);
			
			Button btn2 = new Button("Show Grades");
                        btn2.setOnAction(e->{
                            try {
                                sg.start(primaryStage);
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        });
			btn2.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
			grid.add(btn2, 0, 2);
			
			Button btn3 = new Button("Manage Courses");
                        btn3.setOnAction(e->{
                            try {
                                addStd.start(primaryStage);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        });
			btn3.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
			grid.add(btn3, 0, 3);
			
			Button btn4 = new Button("Make Servey");
                        btn4.setOnAction(e->{
                            try {
                                ss.start(primaryStage);
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        });
			btn4.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
			grid.add(btn4, 0, 4);
			
                        Button backbtn = new Button("SIGN OUT");
				backbtn.setOnAction(e->{
					try {
						BK.start(primaryStage);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				});
                                grid.add(backbtn, 0, 5);
			Scene scene = new Scene(grid,600,600);
			studentwindow.setScene(scene);
			studentwindow.show();
		
	}

}