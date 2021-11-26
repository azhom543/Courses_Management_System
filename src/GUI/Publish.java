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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class Publish extends Application{
Stage window;
private String message;
    
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
        
        
        Label lblmessage = new Label("Message :");
        grid.add(lblmessage , 0, 0);
        TextArea txtsurv = new TextArea();
        txtsurv.setPromptText("Write your Message");
        grid.add(txtsurv, 1, 0);
        txtsurv.setPrefSize(300, 200);
        Button subbtn = new Button("Submit");
        subbtn.setOnAction(e->{
            message = txtsurv.getText();
            instruct.publishToStudents(message);
        });
        grid.add(subbtn, 1, 1);
        
        Button backbtn = new Button("BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        grid.add(backbtn, 0, 2);
        Scene scene = new Scene(grid,600,600);
        window.setScene(scene);
        window.show();
    }
    
}
