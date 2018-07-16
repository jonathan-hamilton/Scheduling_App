package schedulingAppViews;

import javafx.application.Application;  
import javafx.geometry.Insets;  
import javafx.scene.Scene;  
import javafx.scene.control.TableView;  
import javafx.scene.layout.GridPane;  
import javafx.stage.Stage;  
public class FXDatabaseDisplay extends Application{  
  @Override  
  public void start(Stage stage) throws Exception {  
    stage.setFullScreen(true);  
    TableView tableview;  
    //TableView  
    tableview = new TableView();  
    DisplayDatabase.buildData(tableview);  
    //Adding GridPane  
    GridPane gridPane = new GridPane();  
    gridPane.setPadding(new Insets(20,20,20,20));  
    gridPane.setHgap(5);  
    gridPane.setVgap(5);  
    //Main Scene  
    Scene scene = new Scene(tableview);      
    stage.setScene(scene);  
    stage.show();  
  }  
  public static void main(String args[]){  
    launch(null);  
  }  
} 
