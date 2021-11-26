package GUI;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;




	
public class AdminDashBoard {
	Stage adminwindow;
	BorderPane adminlayout;
	public void start(Stage primaryStage) throws Exception {
		
		
		//objects from classes
		StudentDashboard st = new StudentDashboard();
		ProfessorsDashboard pr = new ProfessorsDashboard();
		PersonGUI BK = new PersonGUI();
		Course_Managment cm = new Course_Managment();
		GridPane Professorgrid = new GridPane();
		Professorgrid.setAlignment(Pos.CENTER);
		Professorgrid.setVgap(40);
		Professorgrid.setHgap(10);
		Professorgrid.setPadding(new Insets(10));
		
		adminwindow = primaryStage;
		adminwindow.setTitle("Admin Dashboard");
		adminwindow.setOnCloseRequest(e->{
			e.consume(); //it makes me the boss of my window and close request
			boolean answer = ConfirmBox.display("Confirmation","close the program ?");
			if(answer) {
				adminwindow.close();
			}
			});
		Label admintxt = new Label("Welcome Admin");
		admintxt.setFont(Font.font("Tahoma", FontWeight.LIGHT,40));
		Professorgrid.add(admintxt, 0, 0);
		//file
		Menu filemenu = new Menu("_File");
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(e-> {
			boolean answer = ConfirmBox.display("confirmation","close the program ?");
			if(answer) {
				adminwindow.close();
			}
		});
		filemenu.getItems().addAll(exit);
		
		
		//users
		Menu usersmenu = new Menu("_Users");
		MenuItem students = new MenuItem("Students");
		students.setOnAction(e->{
			try {
				st.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		MenuItem professor = new MenuItem("Professors");
		professor.setOnAction(e->{
			try {
				pr.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		usersmenu.getItems().addAll(students,new SeparatorMenuItem(),professor);
		//course
		Menu coursesmenu = new Menu("_Courses");
		coursesmenu.getItems().add(new MenuItem("Course Managment"));
		coursesmenu.setOnAction(e->{
			try {
				cm.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		
		MenuBar adminmenubar = new MenuBar();
		adminmenubar.getMenus().addAll(filemenu,usersmenu,coursesmenu);
		//Back Button
				Button backbtn = new Button("SIGN OUT");
				backbtn.setOnAction(e->{
					try {
						BK.start(primaryStage);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				});
		Professorgrid.add(backbtn,0,4);
		adminlayout = new BorderPane();
		adminlayout.setTop(adminmenubar);
		adminlayout.setCenter(Professorgrid);
		
		Scene adminscene = new Scene(adminlayout,600,600);
		adminwindow.setScene(adminscene);
		adminwindow.show();
	}
        public static void main(String[] args) {
        launch(args);
    }

    
}

