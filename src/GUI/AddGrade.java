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
/**
 *
 * @author DELL
 */
public class AddGrade extends Application{
    Stage window;
    
    
    private int intStudentID;
    private int intCourseID;
    private double dblGrade;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        Instructor instruct = new Instructor();
        InstructorLogin BK = new InstructorLogin();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(40);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        
        Label lbl1 = new Label("StudentID");
        
        grid.add(lbl1, 0, 0);
        TextField txtStudentID = new TextField();
        txtStudentID.setPromptText("StudentID");
        grid.add(txtStudentID, 1, 0);
        Label lbl2 = new Label("CourseID");
        grid.add(lbl2, 0, 1);
        TextField txtCourseID = new TextField();
        txtCourseID.setPromptText("CourseID");
        grid.add(txtCourseID, 1, 1);
        Label lbl3 = new Label("Grade");
        grid.add(lbl3, 0, 2);
        TextField txtgrade = new TextField();
        txtgrade.setPromptText("Grade");
        grid.add(txtgrade, 1, 2);
        
        
        Button subbtn = new Button("Submit");
        subbtn.setOnAction(e->{
            
            
            try{
                intStudentID = Integer.parseInt(txtStudentID.getText());
                intCourseID = Integer.parseInt(txtCourseID.getText());
                dblGrade = Double.parseDouble(txtgrade.getText());
                     
            }
            catch(NumberFormatException ex){
                //System.out.println(ex);
            }
            instruct.addGradeToStudent(intStudentID, intCourseID, dblGrade);
            
        });
        grid.add(subbtn, 1, 3);
        
        Button backbtn = new Button("BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
			}
		});
		grid.add(backbtn, 0, 4);
        
        Scene scene = new Scene(grid,600,600);
        window.setScene(scene);
        window.show();
        
        
    }
    
}
