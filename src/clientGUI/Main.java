
package clientGUI; 
 
import java.io.File;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent; 
 
public class Main extends Application 
{ 
	// Test Code Added - Dylan (11/04/2018) 
	private Stage mainStage; 
	
 
 
	@Override									 
	public void start(Stage primaryStage) 
	{ 
		 try 
		{ 
			// Splash Screen 
			FXSpashScreen.CreateSpashScreen(); 
			// Main Program 
			primaryStage.setTitle("Untitled"); 
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("Sample.fxml")); 
			Scene scene = new Scene(root, 900, 700); 
 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm()); 
			primaryStage.setScene(scene); 
			primaryStage.show(); 
		} catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
		 
		// Test Code Added: Window Close Event - Dylan (11/04/2018) WORKS
		this.mainStage = primaryStage; 
	    mainStage.setOnCloseRequest(confirmCloseEventHandler); 
 
	    Button closeButton = new Button("Save Document"); 
	    closeButton.setOnAction(event -> 
	    mainStage.fireEvent(new WindowEvent(mainStage,WindowEvent.WINDOW_CLOSE_REQUEST))); 
	    }

		private EventHandler<WindowEvent> confirmCloseEventHandler = event ->  
		{ 
        Alert closeConfirmation = new Alert( 
                Alert.AlertType.CONFIRMATION, 
                "Do you want to save this document before exiting?" 
        ); 
        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton( 
                ButtonType.OK 
        ); 
        exitButton.setText("Save"); 
        closeConfirmation.setHeaderText("Save Before exiting"); 
        closeConfirmation.initModality(Modality.APPLICATION_MODAL); 
        closeConfirmation.initOwner(mainStage); 
 
        closeConfirmation.setWidth(300);  
        closeConfirmation.setHeight(300); 
         
 
        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait(); 
        if (!ButtonType.OK.equals(closeResponse.get()))  
        { 
            event.consume(); 
        } 
         
        // Added Code: FileChooser Dialog Box - SAVE FILE - Dylan (11/06/2018) WORKS
        FileChooser fileChooser = new FileChooser(); 
        fileChooser.setTitle("Open Resource File"); 
        fileChooser.getExtensionFilters().addAll( 
                new ExtensionFilter("Text Files", "*.txt"), 
                new ExtensionFilter("Document File", "*.doc"), 
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"), 
                new ExtensionFilter("All Files", "*.*")); 
        File selectedFile = fileChooser.showSaveDialog(mainStage); 
        if (selectedFile != null)  
        { 
           
        } 
        
        };
		
		public static void main(String[] args) 
		{ 
			Application.launch(args); 
		}




	
}


	
	



