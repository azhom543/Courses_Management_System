package GUI;
import code.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class AddStudent extends Application{
	Stage addstdwindow;
	private  int intId;
        private String strFname;
        private String strLname;
        private String strUserName;
        private String strPass;
	private  int intAge;
        private int intLevel;
                    
        @Override
	public void start(Stage primaryStage) throws Exception {
		addstdwindow = primaryStage;
		addstdwindow.setTitle("Add Student");
		
                                       
		
		StudentDashboard BK = new StudentDashboard();
		Admin manager = new Admin();
		GridPane addstdgrid = new GridPane();
		addstdgrid.setAlignment(Pos.CENTER);
		addstdgrid.setVgap(30);
		addstdgrid.setHgap(10);
		addstdgrid.setPadding(new Insets(10));
		//1
		Label lblid = new Label("ID");
		addstdgrid.add(lblid, 0, 0);
		
		TextField txtid = new TextField();
		txtid.setPromptText("Student ID");
                addstdgrid.add(txtid, 1, 0);
		//2
		Label lblfname = new Label("FName");
		addstdgrid.add(lblfname, 0, 1);
		
		TextField txtfname = new TextField();
		txtfname.setPromptText("First Name");
		addstdgrid.add(txtfname, 1, 1);
		//3
		Label lbllname = new Label("LName");
		addstdgrid.add(lbllname, 0, 2);
	
		TextField txtlname = new TextField();
		txtlname.setPromptText("Last name");
		addstdgrid.add(txtlname, 1, 2);
		//4
		Label lblage = new Label("Age");
		addstdgrid.add(lblage, 0, 3);
		
		TextField txtage = new TextField();
		txtage.setPromptText("Age");
                addstdgrid.add(txtage, 1, 3);
		//5
		Label lblusername = new Label("UserName");
		addstdgrid.add(lblusername, 0, 4);
		
		TextField txtusername = new TextField();
		txtusername.setPromptText("UserName");
		addstdgrid.add(txtusername, 1, 4);
		//6
		TextField txtpass = new TextField();
		txtpass.setPromptText("Password");
		addstdgrid.add(txtpass, 1, 5);
		
		Label lblpass = new Label("Password");
		addstdgrid.add(lblpass, 0, 5);
                                       
                Label lbllevel = new Label("Level");
		addstdgrid.add(lbllevel, 0, 6);
                                      
                TextField txtlevel = new TextField();
		txtlevel.setPromptText("Level");
		addstdgrid.add(txtlevel, 1, 6);
		
		//btnproceed
		Button addbtn = new Button("Proceed");
                    addbtn.setOnAction((ActionEvent e)->{
                    try{
                              intId = Integer.parseInt(txtid.getText());
                              strFname = txtfname.getText();
                              strLname = txtlname.getText();
                              strUserName = txtusername.getText();
                              intAge = Integer.parseInt(txtage.getText());
                              strPass = txtpass.getText();
                              intLevel = Integer.parseInt(txtlevel.getText());
                       }
                     catch(NumberFormatException ex){
                             //System.out.println(e);
                     }
                     manager.addNewStudent(strUserName, strPass, intId, strFname, strLname, intAge, intLevel);
                    });
                    addbtn.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(addbtn, 2, 7);
		
		Button backbtn = new Button("BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
                            // TODO Auto-generated catch block
			}
		});
		addstdgrid.add(backbtn, 0, 7);
		
		
		Scene addstdscene = new Scene(addstdgrid,600,600);
		addstdwindow.setScene(addstdscene);
		addstdwindow.show();
	}
public static void main(String[] args) {
        launch(args);
    }
	
}
