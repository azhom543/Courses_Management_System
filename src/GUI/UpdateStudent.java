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
public class UpdateStudent {
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
		window.setTitle("Add Student");
		Admin manager = new Admin();
                                        
		StudentDashboard BK = new StudentDashboard();
		
		GridPane searchgrid = new GridPane();
		searchgrid.setAlignment(Pos.CENTER);
		searchgrid.setVgap(40);
		searchgrid.setHgap(10);
		searchgrid.setPadding(new Insets(10));
		
		TextField txtoldid = new TextField();
		txtoldid.setPromptText("Student ID");
		searchgrid.add(txtoldid, 0, 0);
	//1
		Label lblusername = new Label("UserName");
		searchgrid.add(lblusername, 0, 1);
		
		TextField txtusername = new TextField();
		txtusername.setPromptText("UserName");
		searchgrid.add(txtusername, 1, 1);
		//2
		Label lblfname = new Label("FName");
		searchgrid.add(lblfname, 0, 2);
		
		TextField txtfname = new TextField();
		txtfname.setPromptText("First Name");
		searchgrid.add(txtfname, 1, 2);
		//3
		Label lbllname = new Label("LName");
		searchgrid.add(lbllname, 0, 3);
	
		TextField txtlname = new TextField();
		txtlname.setPromptText("Last name");
		searchgrid.add(txtlname, 1, 3);
		//4
		Label lblage = new Label("Age");
		searchgrid.add(lblage, 0, 4);
		
		TextField txtage = new TextField();
		txtage.setPromptText("Age");
		searchgrid.add(txtage, 1, 4);
		//5
		TextField txtpass = new TextField();
		txtpass.setPromptText("Password");
		searchgrid.add(txtpass, 1, 5);
		
		Label lblpass = new Label("Password");
		searchgrid.add(lblpass, 0, 5);
		//6
		TextField txtLevel = new TextField();
		txtLevel.setPromptText("Level");
		searchgrid.add(txtLevel, 1, 6);
		
		Label lbllevel = new Label("Level");
		searchgrid.add(lbllevel, 0, 6);
                                       //7
                                        Label lblnewid = new Label("ID");
		searchgrid.add(lblnewid, 0, 7);
                
                                       TextField txtid = new TextField();
		txtid.setPromptText("Student ID");
		searchgrid.add(txtid, 1, 7);
		Button searchbtn = new Button("Search");
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
                searchgrid.add(searchbtn, 1, 0);





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
		searchgrid.add(updatebtn, 0, 8);
		
		Button deletebtn = new Button("Delete");
                    deletebtn.setOnAction(e->{
                              manager.deleteStudent(searchableID);
                    });
		searchgrid.add(deletebtn, 2, 8);
		
		Button backbtn = new Button("<BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		searchgrid.add(backbtn, 3, 9);
		
		
		Scene searchscene = new Scene(searchgrid,600,600);
		window.setScene(searchscene);
		window.show();
	}
public static void main(String[] args) {
        launch(args);
    }
    
}
