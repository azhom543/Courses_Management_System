/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author DELL
 */
public class ShowGrades extends Application{
    Stage window;
    private int intstid;
    private int intcorid;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
        StudentLogin BK = new StudentLogin();
        Student st = new Student();
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(40);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        
        
        
        Label lblsurv = new Label("Student ID");
        grid.add(lblsurv, 0, 0);
        
        TextField txtid = new TextField();
        txtid.setPromptText("Enter your ID");
        grid.add(txtid, 1, 0);
        
        
        Label lblC = new Label("Course ID");
        grid.add(lblC, 0, 1);
        
        TextField txtC = new TextField();
        txtC.setPromptText("Enter Course ID");
        grid.add(txtC, 1, 1);
        
        Button showgrade =new Button("Showgrade");
        grid.add(showgrade, 0, 2);
        Label lblgrade = new Label("Your grade : ");
         lblgrade.setFont(Font.font("Tahoma",FontWeight.LIGHT,20));
        showgrade.setOnAction(e->{
            try{
            intstid = Integer.parseInt(txtid.getText());
            intcorid = Integer.parseInt(txtC.getText());
            
            }
            catch(NumberFormatException ex){
                //System.out.println(ex);
            }
            String strgrade = ""+st.showStudentGrades(intcorid, intstid);
            if(st.showStudentGrades(intcorid, intstid) == -1) strgrade = "NO Grade Added";
            lblgrade.setText(strgrade);
            grid.add(lblgrade, 1, 3);
        });
        Label lblGrade = new Label("Grade");
        grid.add(lblGrade, 0, 3);
        
        
        
        
        Button backbtn = new Button("BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        grid.add(backbtn, 0, 4);
        Scene scene = new Scene(grid,600,600);
        window.setScene(scene);
        window.show();
    }
    
}
