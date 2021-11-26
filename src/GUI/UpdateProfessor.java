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

public class UpdateProfessor extends Application{
	Stage window;
                    private int searchableID;
                   private String strFname;
	private String strLname;
	private String strPass;
	private String struserName;
	private int intAge;
                    private int intID;
	
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Manage instructor");
		Admin manager = new Admin();
		ProfessorsDashboard BK = new ProfessorsDashboard();
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(40);
		grid.setHgap(10);
		grid.setPadding(new Insets(10));
		
		TextField txtoldid = new TextField();
		txtoldid.setPromptText("Student ID");
		grid.add(txtoldid, 0, 0);
	
		
			
		

		//1
		Label lblusername = new Label("UserName");
		grid.add(lblusername, 0, 1);
		
		TextField txtusername = new TextField();
		txtusername.setPromptText("UserName");
		grid.add(txtusername, 1, 1);
		//2
		Label lblfname = new Label("FName");
		grid.add(lblfname, 0, 2);
		
		TextField txtfname = new TextField();
		txtfname.setPromptText("First Name");
		grid.add(txtfname, 1, 2);
		//3
		Label lbllname = new Label("LName");
		grid.add(lbllname, 0, 3);
	
		TextField txtlname = new TextField();
		txtlname.setPromptText("Last name");
		grid.add(txtlname, 1, 3);
		//4
		Label lblage = new Label("Age");
		grid.add(lblage, 0, 4);
		
		TextField txtage = new TextField();
		txtage.setPromptText("Age");
		grid.add(txtage, 1, 4);
		//5
		TextField txtpass = new TextField();
		txtpass.setPromptText("Password");
		grid.add(txtpass, 1, 5);
		
		Label lblpass = new Label("Password");
		grid.add(lblpass, 0, 5);
                
                                        //6
                                      TextField txtid = new TextField();
		txtid.setPromptText("Instructor ID");
		grid.add(txtid, 1, 6);
		
		Label lblid = new Label("Instructor ID");
		grid.add(lblid, 0, 6);
                
                                    //searchbutton
                                    Button searchbtn = new Button("Search");
                                       searchbtn.setOnAction(e->{
                                           try{
                                searchableID = Integer.parseInt(txtoldid.getText());
                                Instructor ins = manager.searchForInstructor(searchableID);
                                strFname = ins.getFName();
                                strLname = ins.getLName();
                                struserName = ins.getuserName();
                                strPass = ins.getPass();
                                intAge = ins.getAge();
                                intID =ins.getID();
                                                    
                                                    
                                                    
                                                    txtfname.setText(strFname);
                                                    txtlname.setText(strLname);
                                                    txtusername.setText(struserName);
                                                    String strAge =""+intAge;
                                                    txtage.setText(strAge);
                                                    txtpass.setText(strPass);
                                                    String strID = ""+intID;
                                                    txtid.setText(strID);
                                                }catch(NumberFormatException ex){
                                                        //System.out.println(ex);
                                                }
                                       });
		grid.add(searchbtn, 1, 0);
                
                
                
		
		Button updatebtn = new Button("Update");
                                        updatebtn.setOnAction(e->{
                                             try {
                                             Instructor ins = new Instructor();
                                                    ins.setFName(txtfname.getText());
                                                    ins.setLName(txtlname.getText());
                                                    ins.setUserName(txtusername.getText());
                                                    ins.setPass(txtpass.getText());
                                                    int intAge = Integer.parseInt(txtage.getText());
                                                    ins.setAge(intAge);
                                                    int intID = Integer.parseInt(txtid.getText());
                                                    ins.setID(intID);
                                                    manager.updateInstructor(searchableID, ins);
                                         }catch(NumberFormatException ex){
                                            // System.out.println(ex);
                                         }
                                             
                                        });
		grid.add(updatebtn, 0, 7);
		
		Button deletebtn = new Button("Delete");
                                       deletebtn.setOnAction(e->{
                                           
                                           manager.deleteInstructor(searchableID);
                                           
                                       });
		grid.add(deletebtn, 2, 7);
		
		Button backbtn = new Button("<BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		grid.add(backbtn, 3, 8);
		
		
		Scene updatescene = new Scene(grid,600,600);
		window.setScene(updatescene);
		window.show();
		
	}

    public static void main(String[] args) {
        launch(args);
    }

}