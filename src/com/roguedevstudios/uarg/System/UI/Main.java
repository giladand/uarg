package com.roguedevstudios.uarg.System.UI;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * The main class, where it all starts
 * 
 * @author Marko S. Bachynsky
 * @since 1.0
 */
public class Main extends Application
{

	/**
	 * 
	 * Creates the splash screen, and main program with a untitled window
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			// Splash Screen
			SpashScreen.CreateSpashScreen();
			// Main Program
			primaryStage.setTitle("Untitled");
			// Set Icon
			primaryStage.getIcons().add(new Image("/com/roguedevstudios/uarg/System/UI/Resources/Uarg Icon.jpg"));
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/com/roguedevstudios/uarg/System/UI/Resources/Sample.fxml"));
			Scene scene = new Scene(root, 900, 700);
			scene.getStylesheets().add(getClass().getResource("/com/roguedevstudios/uarg/System/UI/Resources/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception error)
		{
			error.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
