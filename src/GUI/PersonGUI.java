package GUI;
import code.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class PersonGUI extends Application{
	Stage window;
        private int loginScene;
        
	public static void main(String[] args) {
        launch(args);
    }
	
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Log into System");
                
		//objects
		AdminDashBoard adminScene = new AdminDashBoard();
		InstructorLogin instructorScene = new InstructorLogin();
        StudentLogin studentScene = new StudentLogin();
                
                
                
                
                
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10));
		
		Image image = new Image("file:C:\\Users\\DELL\\Desktop\\login.png");
		try {
			ImageView iv = new ImageView();
			iv.setImage(image);
			iv.setFitWidth(200);
			iv.setFitHeight(200);
			grid.add(iv, 1, 0);
		}catch(Exception e) {
                    System.out.println(e);
		}
		
		Text welcometxt = new Text("welcome");
		welcometxt.setFont(Font.font("Tahoma", FontWeight.LIGHT,25));
		grid.add(welcometxt, 0, 0);
		
		
		Label lbluser = new Label("username");
		grid.add(lbluser, 0, 1);
		
		TextField txtuser = new TextField();
		txtuser.setPromptText("username");
		grid.add(txtuser, 1, 1);
		
		Label lblpassword = new Label("password");
		grid.add(lblpassword, 0, 2);
		
		
		PasswordField pass = new PasswordField();
		pass.setPromptText("password");
		grid.add(pass, 1, 2);
		
		Button loginbtn = new Button("LogIn");
                Label wrong = new Label("Wrong password or username..!");
		
                loginbtn.setOnAction(e -> {
                    try{
                   loginScene = Person.login(txtuser.getText(),pass.getText());
                   if(loginScene == 1) adminScene.start(primaryStage);
                   else if(loginScene == 2)instructorScene.start(primaryStage);
                   else if (loginScene == 3)studentScene.start(primaryStage);
                   else 
                           grid.add(wrong, 1, 5);
                    }
                    catch(Exception ex){
                        //System.out.println(ex);
                    }
                    });
		grid.add(loginbtn, 1, 3);
		
		
		
		Scene scene1=new Scene(grid,600,600);	
		window.setScene(scene1);
		window.show();
}
/*public boolean login(String userName, String Pass) {
        if (userName.equals("Admin@gmail.com") && Pass.equals("12345678")) {
            return true;
        }
        return false;
    }*/
}
