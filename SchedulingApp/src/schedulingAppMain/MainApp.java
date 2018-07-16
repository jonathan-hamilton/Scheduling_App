package schedulingAppMain;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import schedulingAppModels.Customer;
import schedulingAppUtils.DBConnection;
import schedulingAppViews.*;

public class MainApp extends Application{
	
	private BorderPane rootLayout;
	private Stage primaryStage;
	private ObservableList<Customer> customerData = FXCollections.observableArrayList();
	
	public MainApp() {
 
    }
	/**
     * Returns ObservableList of Customers. 
     */
    public ObservableList<Customer> getCustomerData() {
        return customerData;
    }
	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Scheduling App");
        initRootLayout();
        showLoginLayout();
//        showCustomerOverview();
//        DBConnection.getConnection();
    }
	/**
     * Initializes the root layout.
     */
	public void initRootLayout() {
        try {
            // Load root layout from fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/schedulingAppViews/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	/**e
     * Shows the LoginLayout inside the root layout.
     */
	public void showLoginLayout(){
		try{
			// load LoginLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(
					"/schedulingAppViews/LoginLayout.fxml"));
			AnchorPane loginLayout = (AnchorPane)loader.load();
			
			//set loginLayout into the center of the root layout
			rootLayout.setCenter(loginLayout);
			
			//give access to the main app
			LoginController controller = loader.getController();
			controller.setMainApp(this);
				
		}	catch (IOException e){
				e.printStackTrace();
			}
		}
	
	
	/**
     * Shows the Customer Overview inside the root layout.
     */
    public void showCustomerOverview() {
        try {
            // Load customer overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
            		"/schedulingAppViews/OverviewLayout.fxml"));
            AnchorPane customerOverview = (AnchorPane) loader.load();

            // Set customer overview into the center of root layout.
            rootLayout.setCenter(customerOverview);
            
         // Give the controller access to the main app.
            OverviewController controller = loader.getController();
            System.out.print(controller);
//            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
//    public boolean showCustomerEditDialog(Customer customer) {
//        try {
//            // Load the fxml file and create a new stage for the popup dialog.
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(MainApp.class.getResource("/schedulingAppViews/EditLayout"));
//            AnchorPane page = (AnchorPane) loader.load();
//
//            // Create the dialog Stage.
//            Stage dialogStage = new Stage();
//            dialogStage.setTitle("Edit Customer");
//            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.initOwner(primaryStage);
//            Scene scene = new Scene(page);
//            dialogStage.setScene(scene);

            // Set the person into the controller.
//            EditController controller = loader.getController();
//            controller.setDialogStage(dialogStage);
//            controller.setCustomer(customer);

            // Show the dialog and wait until the user closes it
//            dialogStage.showAndWait();
//            return controller.isOkClicked();
            
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
