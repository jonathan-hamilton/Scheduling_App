package schedulingAppViews;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import schedulingAppMain.MainApp;
import schedulingAppUtils.DBConnection;

public class LoginController implements EventHandler<ActionEvent> {
	@FXML
	private MainApp mainApp;
	@FXML
	private TextField txtUserName;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Button submitButton;
	@FXML
	private Label errorMsg;
	static String currentUser;
	
	@FXML
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;	
	}
	
	@FXML
	public void initialize(){
		submitButton = new Button();
		submitButton.setOnAction(this);
		
		
	}	

	@FXML
	@Override
	public void handle(ActionEvent event){
		currentUser = txtUserName.getText(); 
		String loginUserName = "SELECT `user`.`userName`,`user`.`password` FROM `U03nV2`.`user`WHERE userName = '" + txtUserName.getText() + "';";
		try{
			PreparedStatement pst = DBConnection.getConnection().prepareStatement(loginUserName);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				if(txtUserName.getText().equals(rs.getString(1)) & txtPassword.getText().equals(rs.getString(2))){
					try{
						Parent parent = FXMLLoader.load(getClass().getResource("/schedulingAppViews/OverviewLayout.fxml"));
						Stage stage = new Stage();
						Scene scene = new Scene(parent);
						stage.setScene(scene);
						stage.setTitle("Customer Overview");
						System.out.println("LI/PW correct");
						stage.show();
					}
					catch(Exception e){
						e.printStackTrace();
					}
			}
				else{
					errorMsg.setText("INVALID ENTRY");
					System.out.println("wrong LI/PW");
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(currentUser);
	}
	
	public TextField getTxtUserName() {
		return txtUserName;
	}
}
			
//			try{
//				Parent parent = FXMLLoader.load(getClass().getResource("/schedulingAppViews/OverviewLayout.fxml"));
//				Stage stage = new Stage();
//				Scene scene = new Scene(parent);
//				stage.setScene(scene);
//				stage.setTitle("Customer Overview");
//				System.out.println("LI/PW correct");
//				stage.show();
//			}
//			catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//		else{
//			errorMsg.setText("INVALID ENTRY");
//			System.out.println("wrong LI/PW");
//		}
//	}
//}


