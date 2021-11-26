/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class InstructorLogin extends Application{
Stage window;
    
@Override
    
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        AddGrade ag = new AddGrade();
        
        Publish pu = new Publish();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(40);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
        
        Image image = new Image("file:C:\\Users\\DELL\\Desktop\\download (1).jpg");
			try {
				ImageView iv = new ImageView();
				iv.setImage(image);
				iv.setFitWidth(200);
				iv.setFitHeight(200);
				grid.add(iv, 0, 0);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			Button btn1 = new Button("Publish");
                        btn1.setOnAction(e->{
                            try {
                                pu.start(primaryStage);
                            } catch (Exception ex) {
                                //System.out.println(ex);
                            }
                        });
			btn1.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
			grid.add(btn1, 0, 1);
			
			Button btn2 = new Button("Add Grade");
                        btn2.setOnAction(e->{
                            try {
                                ag.start(primaryStage);
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        });
			btn2.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
			grid.add(btn2, 0, 2);
        Scene scene = new Scene(grid,600,600);
        window.setScene(scene);
        window.show();
        
    }
    
}
