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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class StudentServey extends Application{
    Stage window;
    private String message;
    private int intid;
    
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
        
        Label lblsurv = new Label("Survey");
        grid.add(lblsurv, 0, 0);
        
        TextArea txtsurv = new TextArea();
        txtsurv.setPromptText("Write your Message");
        txtsurv.setPrefSize(300, 200);
        grid.add(txtsurv, 1, 0);
        
        Label lblid = new Label("StudentID");
        grid.add(lblid, 0, 1);
        
        TextField txtid = new TextField();
        txtid.setPromptText("Enter your ID");
        grid.add(txtid, 1, 1);
        
        Button subbtn = new Button("Submit");
        subbtn.setOnAction(e->{
            try{
            intid = Integer.parseInt(txtid.getText());
            message = txtsurv.getText();
            }
            catch(NumberFormatException ex){
                //System.out.println(ex);
            }
            st.updatesurvey(message, intid);
            });
        grid.add(subbtn, 1, 2);
        
        Button backbtn = new Button("BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        grid.add(backbtn, 0, 3);
        Scene scene = new Scene(grid,600,600);
        window.setScene(scene);
        window.show();
    }
    
}
