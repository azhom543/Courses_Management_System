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

public class UpdateCourse extends Application{

	Stage window;
        private int searchableID;
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
		
		
		Course_Managment BK = new Course_Managment();
		Admin manager = new Admin();
		
		GridPane addstdgrid = new GridPane();
		addstdgrid.setAlignment(Pos.CENTER);
		addstdgrid.setVgap(40);
		addstdgrid.setHgap(20);
		addstdgrid.setPadding(new Insets(10));
		
                
                
                TextField txtsearch = new TextField();
		txtsearch.setPromptText("OldID");
		addstdgrid.add(txtsearch, 2, 0);
                
                //1
		Label lblid = new Label("Course ID");
		lblid.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblid, 0, 1);
		
		TextField txtid = new TextField();
		txtid.setPromptText("Course id");
		addstdgrid.add(txtid, 1, 1);
		//2
		Label lblfname = new Label("Course Name");
		lblfname.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblfname, 3, 1);
		
		TextField txtname = new TextField();
		txtname.setPromptText("Course Name");
		addstdgrid.add(txtname, 4, 1);
		//3
		Label lbllname = new Label("Room Number");
		lbllname.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lbllname, 0, 2);
	
		TextField txtroomnumber = new TextField();
		txtroomnumber.setPromptText("Room Number");
		addstdgrid.add(txtroomnumber, 1, 2);
		//4
		Label lblsdate = new Label("Start Date");
		lblsdate.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblsdate, 3, 2);
	
		TextField txtsdate = new TextField();
		txtsdate.setPromptText("Start Date");
		addstdgrid.add(txtsdate, 4, 2);
		
		//5
		Label lbledate = new Label("End Date");
		lbledate.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lbledate, 0, 3);
	
		TextField txtedate = new TextField();
		txtedate.setPromptText("End Date");
		addstdgrid.add(txtedate, 1, 3);
                //6
                Label lblbranch = new Label("Branch");
		lblbranch.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblbranch, 3, 3);
	
		TextField txtbranch = new TextField();
		txtbranch.setPromptText("Branch");
		addstdgrid.add(txtbranch, 4, 3);
		//7
                Label lblpriceOfCourse = new Label("priceOfCourse");
		lblpriceOfCourse.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblpriceOfCourse, 0, 4);
	
		TextField txtpriceOfCourse = new TextField();
		txtpriceOfCourse.setPromptText("priceOfCourse");
		addstdgrid.add(txtpriceOfCourse, 1, 4);
                //8
                Label lbldays = new Label("Days");
		lbldays.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lbldays, 3, 4);
	
		TextField txtdays = new TextField();
		txtdays.setPromptText("Days");
		addstdgrid.add(txtdays, 4, 4);
                //9
                Label lblstatusOfCourse = new Label("statusOfCourse");
		lblstatusOfCourse.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD,17));
		addstdgrid.add(lblstatusOfCourse, 0, 5);
	
		TextField txtstatusOfCourse = new TextField();
		txtstatusOfCourse.setPromptText("statusOfCourse");
		addstdgrid.add(txtstatusOfCourse, 1, 5);
                //10
                Label lblInstructorOfCourse = new Label("InstructorOfCourse");
		lblInstructorOfCourse.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblInstructorOfCourse, 3, 5);
	
		TextField txtInstructorOfCourse = new TextField();
		txtInstructorOfCourse.setPromptText("InstructorOfCourse");
		addstdgrid.add(txtInstructorOfCourse, 4, 5);
                //11
                Label lblparentCourse = new Label("parentCourse");
		lblparentCourse.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblparentCourse, 0, 6);
	
		TextField txtparentCourse = new TextField();
		txtparentCourse.setPromptText("parentCourse");
		addstdgrid.add(txtparentCourse, 1, 6);
                //12
                Label lblpriceOfParentCourse = new Label("priceOfParentCourse");
		lblpriceOfParentCourse.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblpriceOfParentCourse, 3, 6);
	
		TextField txtpriceOfParentCourse = new TextField();
		txtpriceOfParentCourse.setPromptText("priceOfParentCourse");
		addstdgrid.add(txtpriceOfParentCourse, 4, 6);
                //13
                Label lblcourseGrade = new Label("courseGrade");
		lblcourseGrade.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblcourseGrade, 0, 7);
	
		TextField txtcourseGrade = new TextField();
		txtcourseGrade.setPromptText("courseGrade");
		addstdgrid.add(txtcourseGrade, 1,7);
                //14
                Label lblnumberOfStudents = new Label("numberOfStudents");
		lblnumberOfStudents.setFont(Font.font("Tahoma", FontWeight.LIGHT,15));
		addstdgrid.add(lblnumberOfStudents, 3, 7);
	
		TextField txtnumberOfStudents = new TextField();
		txtnumberOfStudents.setPromptText("numberOfStudents");
		addstdgrid.add(txtnumberOfStudents, 4, 7);
		//search button
		Button searchbtn = new Button("Search");
                searchbtn.setOnAction(e->{
                    try{
                    searchableID = Integer.parseInt(txtsearch.getText());
                    Course c = manager.searchForCourse(searchableID);
                        intCid = c.getCId();
                        strCname = c.getCName();
                        strBranch = c.getBranch();
                        strCroom = c.getRoom();
                        strCEndDate = c.getEnddate();
                        strInstructorOfCourse = c.getInstructorOfCourse();
                        strparentCourse = c.getParentCourse();
                        intDays = c.getDays();
                        intcourseGrade = c.getCourseGrade();
                        numberOfStudents = c.getNumberOfStudents();
                        strCStartDate = c.getStartdate();
                        strstatusOfCourse = c.getStatusOfCoruse();
                        dblpriceOfCourse = c.getPriceOfCourse();
                        dblpriceOfParentCourse = c.getPriceOfParentCourse();
                    
                        
                        String strCid =""+intCid;
                        txtid.setText(strCid);
                        txtname.setText(strCname);
                        txtbranch.setText(strBranch);
                        txtroomnumber.setText(strCroom);
                        txtedate.setText(strCEndDate);
                        txtInstructorOfCourse.setText(strInstructorOfCourse);
                        txtparentCourse.setText(strparentCourse);
                        String strDays =""+intDays;
                        txtdays.setText(strDays);
                        String strcourseGrade =""+intcourseGrade;
                        txtcourseGrade.setText(strcourseGrade);
                        String strnumberOfStudents =""+numberOfStudents;
                        txtnumberOfStudents.setText(strnumberOfStudents);
                        txtsdate.setText(strCStartDate);
                        txtstatusOfCourse.setText(strstatusOfCourse);
                        String strpriceOfCourse =""+dblpriceOfCourse;
                        txtpriceOfCourse.setText(strpriceOfCourse);
                        String strpriceOfParentCourse =""+dblpriceOfParentCourse;
                        txtpriceOfParentCourse.setText(strpriceOfParentCourse);
                    }
                    catch(NumberFormatException ex){
                        
                    }
                    });
                addstdgrid.add(searchbtn, 3, 0);
		Button updatebtn = new Button("Update");
                updatebtn.setOnAction(e->{
                    try{
                        Course c = new Course();
                        int intid = Integer.parseInt(txtid.getText());
                        c.setCId(intid);
                        c.setCName(txtname.getText());
                        c.setBranch(txtbranch.getText());
                        c.setRoom(txtroomnumber.getText());
                        c.setEnddate(txtedate.getText());
                        c.setInstructorOfCourse(txtInstructorOfCourse.getText());
                        c.setParentCourse(txtparentCourse.getText());
                        int intDays = Integer.parseInt(txtdays.getText());
                        c.setDays(intDays);
                        int intCourseGrade = Integer.parseInt(txtcourseGrade.getText());
                        c.setCourseGrade(intCourseGrade);
                        int intNoOfStudents = Integer.parseInt(txtnumberOfStudents.getText());
                        c.setNumberOfStudents(intNoOfStudents);
                        c.setStartdate(txtsdate.getText());
                        c.setStatusOfCoruse(txtstatusOfCourse.getText());
                        double dblPriceOfCourse = Double.parseDouble(txtpriceOfCourse.getText());
                        c.setPriceOfCourse(dblPriceOfCourse);
                        double dblPriceOfParentCourse = Double.parseDouble(txtpriceOfParentCourse.getText());
                        c.setPriceOfParentCourse(dblPriceOfParentCourse);
                        manager.updateCourse(searchableID, c);
                    }
                    catch(NumberFormatException ex){
                        //System.out.println(ex);
                    }
                });
		addstdgrid.add(updatebtn, 2, 8);
		
		Button deletebtn = new Button("Delete");
                deletebtn.setOnAction(e->{
                    manager.deleteCourse(searchableID);
                });
		addstdgrid.add(deletebtn, 3, 8);
		
		Button backbtn = new Button("BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		addstdgrid.add(backbtn, 0, 8);
		
		
		Scene scene = new Scene(addstdgrid,600,600);
		window.setScene(scene);
		window.show();
		
	}

}

