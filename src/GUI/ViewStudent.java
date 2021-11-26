package GUI;
import code.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ViewStudent extends Application{
	
    public void start(Stage primaryStage) {
        
                    Admin manager = new Admin();
        
    	StudentDashboard BK = new StudentDashboard();
    	
    	
    	
    	GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10));
                String allStudents = manager.displayStudents();
                
                Label view = new Label();
                view.setText(allStudents);
                view.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
        Button backbtn = new Button("<BACK");
		backbtn.setOnAction(e->{
			try {
				BK.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		      ScrollPane b = new ScrollPane();
                      b.setContent(view);
                      b.setPrefSize(600, 600);
                      b.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                      b.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                      view.setAlignment(Pos.CENTER);
                                   grid.add(view, 0, 0);
                                    grid.add(backbtn, 0, 2);
                                    grid.getChildren().add(b);
                                    Scene scene = new Scene(grid, 600, 600);
                                    primaryStage.setTitle("List Student");
                                    primaryStage.setScene(scene);
                                    //primaryStage.
                                    primaryStage.show();
    }

   public static void main(String[] args) {
        launch(args);
    }
    
}
