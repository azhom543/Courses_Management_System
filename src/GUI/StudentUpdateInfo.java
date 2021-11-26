package GUI;
import code.*;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class StudentUpdateInfo {
	Stage window;
        private int searchableID;
        private String strFname;
	private String strLname;
	private String strPass;
	private String struserName;
	private int intAge;
	private int intLevel;
        private int intID;
                    
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		Admin manager = new Admin();
		StudentLogin BK = new StudentLogin();
		
                
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
		TextField txtLevel = new TextField();
		txtLevel.setPromptText("Level");
		grid.add(txtLevel, 1, 6);
		
		Label lbllevel = new Label("Level");
		grid.add(lbllevel, 0, 6);
                                       //7
                                        Label lblnewid = new Label("ID");
		grid.add(lblnewid, 0, 7);
                
                                       TextField txtid = new TextField();
		txtid.setPromptText("Student ID");
		grid.add(txtid, 1, 7);
		Button searchbtn = new Button("Set Info");
                searchbtn.setOnAction(e->{

                    try{
                        searchableID = Integer.parseInt(txtoldid.getText());
                        Student st = manager.searchForStudent(searchableID);
                        strFname = st.getFName();
                        strLname = st.getLName();
                        struserName = st.getuserName();
                        strPass = st.getPass();
                        intLevel = st.getLevel();
                        intAge = st.getAge();
                        intID =st.getID();



                        txtfname.setText(strFname);
                        txtlname.setText(strLname);
                        txtusername.setText(struserName);
                        String strAge =""+intAge;
                        txtage.setText(strAge);
                        String strLevel = ""+intLevel;
                        txtLevel.setText(strLevel);
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
                        Student st = new Student();
                               st.setFName(txtfname.getText());
                               st.setLName(txtlname.getText());
                               st.setUserName(txtusername.getText());
                               st.setPass(txtpass.getText());
                               int intLevel = Integer.parseInt(txtLevel.getText());
                               st.setLevel(intLevel);
                               int intAge = Integer.parseInt(txtage.getText());
                               st.setAge(intAge);
                               int intID = Integer.parseInt(txtid.getText());
                               st.setID(intID);
                               manager.updateStudent(searchableID, st);
                    }catch(NumberFormatException ex){
                       // System.out.println(ex);
                    }
                                          
                });
		grid.add(updatebtn, 0, 8);
		Button backbtn = new Button("BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		grid.add(backbtn, 3, 9);
		
		
		Scene searchscene = new Scene(grid,600,600);
		window.setScene(searchscene);
		window.show();
	}
public static void main(String[] args) {
        launch(args);
    }
    
}