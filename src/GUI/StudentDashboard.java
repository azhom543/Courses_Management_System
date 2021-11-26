package GUI;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentDashboard{
	Stage studentwindow;
	
	
	
	public void start(Stage primaryStage) throws Exception {
		studentwindow = primaryStage;
		studentwindow.setTitle("Student Dashboard");
		//OBJECTS
		AdminDashBoard BK = new AdminDashBoard();
		AddStudent ad = new AddStudent();
		UpdateStudent sr = new UpdateStudent();
		ViewStudent Vs = new ViewStudent();
		
		
		
		GridPane studentgrid = new GridPane();
		studentgrid.setAlignment(Pos.CENTER);
		studentgrid.setVgap(40);
		studentgrid.setHgap(10);
		studentgrid.setPadding(new Insets(10));
		
		
		Button btn1 = new Button("Add Student");
		btn1.setOnAction(e->{
			try {
				ad.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		studentgrid.add(btn1, 0, 0);
		Button btn2 = new Button("View Student");
		btn2.setOnAction(e->{
			try {
			Vs.start(primaryStage);
			}
			catch(Exception e3) {
				e3.printStackTrace();
			}
		});
		studentgrid.add(btn2, 0, 1);
		Button btn3 = new Button("Manage Student");
		btn3.setOnAction(e->{
			try {
				sr.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		studentgrid.add(btn3, 0, 2);
		//Back Button
		Button backbtn = new Button("<BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		studentgrid.add(backbtn, 0, 4);
		
		
		Scene stdscene = new Scene(studentgrid,600,600);
		studentwindow.setScene(stdscene);
		studentwindow.show();
		
	}

    public static void main(String[] args) {
        launch(args);
    }

}
