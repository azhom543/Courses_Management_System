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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddCourse extends Application{
	Stage window;
        
        private int intCid;
        private String strCname;
        private String strCroom;
        private String strCStartDate;
        private String strCEndDate;
        private String strBranch;
        private String strstatusOfCourse;
        private String strInstructorOfCourse;
        private String strparentCourse;
        private double dblpriceOfCourse;
        private double dblpriceOfParentCourse;
        private int intDays;
	private int intcourseGrade;
        private int numberOfStudents;
        
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
                Admin manager = new Admin();
		Course_Managment BK = new Course_Managment();
                
                
                
                
		GridPane addstdgrid = new GridPane();
		addstdgrid.setAlignment(Pos.CENTER);
		addstdgrid.setVgap(40);
		addstdgrid.setHgap(20);
		addstdgrid.setPadding(new Insets(10));
		//1
		Label lblid = new Label("Course ID");
		lblid.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblid, 0, 0);
		
		TextField txtid = new TextField();
		txtid.setPromptText("Course id");
		addstdgrid.add(txtid, 1, 0);
		//2
		Label lblfname = new Label("Course Name");
		lblfname.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblfname, 3, 0);
		
		TextField txtname = new TextField();
		txtname.setPromptText("Course Name");
		addstdgrid.add(txtname, 4, 0);
		//3
		Label lbllname = new Label("Room Number");
		lbllname.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lbllname, 0, 1);
	
		TextField txtroomnumber = new TextField();
		txtroomnumber.setPromptText("Room Number");
		addstdgrid.add(txtroomnumber, 1, 1);
		//4
		Label lblsdate = new Label("Start Date");
		lblsdate.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblsdate, 3, 1);
	
		TextField txtsdate = new TextField();
		txtsdate.setPromptText("Start Date");
		addstdgrid.add(txtsdate, 4, 1);
		
		//5
		Label lbledate = new Label("End Date");
		lbledate.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lbledate, 0, 2);
	
		TextField txtedate = new TextField();
		txtedate.setPromptText("End Date");
		addstdgrid.add(txtedate, 1, 2);
                //6
                Label lblbranch = new Label("Branch");
		lblbranch.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblbranch, 3, 2);
	
		TextField txtbranch = new TextField();
		txtbranch.setPromptText("Branch");
		addstdgrid.add(txtbranch, 4, 2);
		//7
                Label lblpriceOfCourse = new Label("priceOfCourse");
		lblpriceOfCourse.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblpriceOfCourse, 0, 3);
	
		TextField txtpriceOfCourse = new TextField();
		txtpriceOfCourse.setPromptText("priceOfCourse");
		addstdgrid.add(txtpriceOfCourse, 1, 3);
                //8
                Label lbldays = new Label("Days");
		lbldays.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lbldays, 3, 3);
	
		TextField txtdays = new TextField();
		txtdays.setPromptText("Days");
		addstdgrid.add(txtdays, 4, 3);
                //9
                Label lblstatusOfCourse = new Label("statusOfCourse");
		lblstatusOfCourse.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD,17));
		addstdgrid.add(lblstatusOfCourse, 0, 4);
	
		TextField txtstatusOfCourse = new TextField();
		txtstatusOfCourse.setPromptText("statusOfCourse");
		addstdgrid.add(txtstatusOfCourse, 1, 4);
                //10
                Label lblInstructorOfCourse = new Label("InstructorOfCourse");
		lblInstructorOfCourse.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblInstructorOfCourse, 3, 4);
	
		TextField txtInstructorOfCourse = new TextField();
		txtInstructorOfCourse.setPromptText("InstructorOfCourse");
		addstdgrid.add(txtInstructorOfCourse, 4, 4);
                //11
                Label lblparentCourse = new Label("parentCourse");
		lblparentCourse.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblparentCourse, 0, 5);
	
		TextField txtparentCourse = new TextField();
		txtparentCourse.setPromptText("parentCourse");
		addstdgrid.add(txtparentCourse, 1, 5);
                //12
                Label lblpriceOfParentCourse = new Label("priceOfParentCourse");
		lblpriceOfParentCourse.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblpriceOfParentCourse, 3, 5);
	
		TextField txtpriceOfParentCourse = new TextField();
		txtpriceOfParentCourse.setPromptText("priceOfParentCourse");
		addstdgrid.add(txtpriceOfParentCourse, 4, 5);
                //13
                Label lblcourseGrade = new Label("courseGrade");
		lblcourseGrade.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblcourseGrade, 0, 6);
	
		TextField txtcourseGrade = new TextField();
		txtcourseGrade.setPromptText("courseGrade");
		addstdgrid.add(txtcourseGrade, 1,6);
                //14
                Label lblnumberOfStudents = new Label("numberOfStudents");
		lblnumberOfStudents.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblnumberOfStudents, 3, 6);
	
		TextField txtnumberOfStudents = new TextField();
		txtnumberOfStudents.setPromptText("numberOfStudents");
		addstdgrid.add(txtnumberOfStudents, 4, 6);
                
                
                //proceed button
		Button addbtn = new Button("Proceed");
                addbtn.setOnAction(e->{
                    try{
                              intCid = Integer.parseInt(txtid.getText());
                              strCname = txtname.getText();
                              strBranch = txtbranch.getText();
                              strCroom = txtroomnumber.getText();
                              strCEndDate = txtedate.getText();
                              strInstructorOfCourse = txtInstructorOfCourse.getText();
                              strparentCourse = txtparentCourse.getText();
                              intDays = Integer.parseInt(txtdays.getText());
                              intcourseGrade = Integer.parseInt(txtcourseGrade.getText());
                              numberOfStudents = Integer.parseInt(txtnumberOfStudents.getText());
                              strCStartDate = txtsdate.getText();
                              strstatusOfCourse = txtstatusOfCourse.getText();
                              dblpriceOfCourse = Double.parseDouble(txtpriceOfCourse.getText());
                              dblpriceOfParentCourse = Double.parseDouble(txtpriceOfParentCourse.getText());
                       }
                     catch(NumberFormatException ex){
                             //System.out.println(e);
                     }
                    manager.addNewCourse(strCname, intCid, strCroom, strBranch, dblpriceOfCourse, strCStartDate,
                            intDays, strCEndDate, strstatusOfCourse, strInstructorOfCourse, strparentCourse, 
                            dblpriceOfParentCourse, intcourseGrade, numberOfStudents);
                });
		addbtn.setFont(Font.font("Tahoma", FontWeight.LIGHT,25));
		addstdgrid.add(addbtn, 2, 7);
		
		Button backbtn = new Button("BACK");
                backbtn.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		addstdgrid.add(backbtn, 0, 7);
		
		Scene scene = new Scene(addstdgrid,600,600);
		window.setScene(scene);
		window.show();
		
	}
	
}
