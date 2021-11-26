package GUI;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProfessorsDashboard {
	Stage Professorwindow;
	
	public void start(Stage primaryStage) throws Exception {
		Professorwindow = primaryStage;
		Professorwindow.setTitle("Professor Dashboard");
		//OBJECTS
		Add_Professor ad = new Add_Professor();
		View_professor Vp = new View_professor();
		UpdateProfessor Up = new UpdateProfessor();
		AdminDashBoard BK = new AdminDashBoard();
		
		
		GridPane Professorgrid = new GridPane();
		Professorgrid.setAlignment(Pos.CENTER);
		Professorgrid.setVgap(40);
		Professorgrid.setHgap(10);
		Professorgrid.setPadding(new Insets(10));
		
		
		Button btn1 = new Button("Add Professor");
		btn1.setOnAction(e->{
			try {
				ad.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Professorgrid.add(btn1, 0, 0);
		Button btn2 = new Button("View Professor");
		btn2.setOnAction(e->{
			try {
				Vp.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Professorgrid.add(btn2, 0, 1);
		Button btn3 = new Button("Manage Professor");
		btn3.setOnAction(e->{
			try {
				Up.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Professorgrid.add(btn3, 0, 2);
		
		Button backbtn = new Button("<BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Professorgrid.add(backbtn, 0, 4);
		
		Scene prfscene = new Scene(Professorgrid,600,600);
		Professorwindow.setScene(prfscene);
		Professorwindow.show();
}

  public static void main(String[] args) {
        launch(args);
    }

}
