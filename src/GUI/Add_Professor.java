package GUI;
import code.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Add_Professor extends Application{

                    Stage profwindow;
                    private  int intId;
                    private String strFname;
                    private String strLname;
                    private String strUserName;
                    private String strPass;
	private  int intAge;
                @Override
	public void start(Stage primaryStage) throws Exception {
		
		profwindow = primaryStage;
		Admin manager = new Admin();
		ProfessorsDashboard BK = new ProfessorsDashboard();
		
		GridPane profgrid = new GridPane();
		profgrid.setAlignment(Pos.CENTER);
		profgrid.setVgap(30);
		profgrid.setHgap(10);
		profgrid.setPadding(new Insets(10));
		//1
		Label lblid = new Label("ID");
		profgrid.add(lblid, 0, 0);
		
		TextField txtid = new TextField();
		txtid.setPromptText("Professor ID");
		profgrid.add(txtid, 1, 0);
		//2
		Label lblfname = new Label("FName");
		profgrid.add(lblfname, 0, 1);
		
		TextField txtfname = new TextField();
		txtfname.setPromptText("First Name");
		profgrid.add(txtfname, 1, 1);
		//3
		Label lbllname = new Label("LName");
		profgrid.add(lbllname, 0, 2);
	
		TextField txtlname = new TextField();
		txtlname.setPromptText("Last name");
		profgrid.add(txtlname, 1, 2);
		//4
		Label lblage = new Label("Age");
		profgrid.add(lblage, 0, 3);
		
		TextField txtage = new TextField();
		txtage.setPromptText("Age");
		profgrid.add(txtage, 1, 3);
		//5
		Label lblusername = new Label("UserName");
		profgrid.add(lblusername, 0, 4);
		
		TextField txtusername = new TextField();
		txtusername.setPromptText("UserName");
		profgrid.add(txtusername, 1, 4);
		//6
		TextField txtpass = new TextField();
		txtpass.setPromptText("Password");
		profgrid.add(txtpass, 1, 5);
		
		Label lblpass = new Label("Password");
		profgrid.add(lblpass, 0, 5);
		//btnproceed
		Button addbtn = new Button("Proceed");
                                       addbtn.setOnAction(e->{
                                           try{
                                                          intId = Integer.parseInt(txtid.getText());
                                                          strFname = txtfname.getText();
                                                          strLname = txtlname.getText();
                                                          strUserName = txtusername.getText();
                                                          intAge = Integer.parseInt(txtage.getText());
                                                          strPass = txtpass.getText();
                                                }
                                        catch(NumberFormatException ex){
                                                //System.out.println(e);
                                        }
                                           
                                           manager.addNewInstructor(strUserName, strPass, intId, strFname, strLname, intAge);
             
                                       });
		profgrid.add(addbtn, 0, 7);
		
		Button backbtn = new Button("<BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
                            // TODO Auto-generated catch block

			}
		});
		profgrid.add(backbtn, 2, 7);
		
		
		Scene profscene = new Scene(profgrid,600,600);
		profwindow.setTitle("Add instructor");
		profwindow.setScene(profscene);
		profwindow.show();
		
	}
public static void main(String[] args) {
        launch(args);
    }
    

}

