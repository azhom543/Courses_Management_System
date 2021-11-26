package GUI;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	
    static	boolean answer;
	public static boolean display(String title,String message)
	{
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		Label confirmlbl = new Label(message);
		confirmlbl.setFont(Font.font("Tahoma", FontWeight.LIGHT,20));
		Button yesButton = new Button("YES");
		Button noButton = new Button("NO");
		yesButton.setOnAction(e->{
			answer = true;
			window.close();
		});
		noButton.setOnAction(e->{
			answer = false;
			window.close();
		});
		VBox layout = new VBox(10);
		layout.getChildren().addAll(confirmlbl,yesButton,noButton);
		layout.setAlignment(Pos.CENTER);
		
		
		Scene scene = new Scene(layout,400,200);
		window.setScene(scene);
		window.showAndWait();//this window should be closed first before going back to the parent window
		return answer;
	}
public static void main(String[] args) {
        launch(args);
    }

}

