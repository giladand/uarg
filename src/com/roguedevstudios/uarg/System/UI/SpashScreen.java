package com.roguedevstudios.uarg.System.UI;

import javafx.animation.FadeTransition;
import javafx.collections.*;
import javafx.concurrent.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.Duration;

/**
 * The JavaFX Splash Screen class.
 * 
 * @author Marko Bachynsky
 * @since 1.0
 */

public class SpashScreen
{
	public static final String APPLICATION_ICON = "resources\\Uarg Splash.jpg";
	public static final String SPLASH_IMAGE = "resources\\Uarg Splash.jpg";

	public static Pane splashLayout;
	public static ProgressBar loadProgress;
	public static Label progressText;
	public static Stage mainStage;
	public static final int SPLASH_WIDTH = 256;
	public static final int SPLASH_HEIGHT = 256;


	public static void CreateSpashScreen() throws Exception
	{
		initFX();
		startFX();
	}

	/**
	 * 
	 * Initializes all fields, and sets the style of the splash layout
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public static void initFX()
	{
		ImageView splash = new ImageView(new Image(SPLASH_IMAGE));
		mainStage = new Stage();
		loadProgress = new ProgressBar();
		loadProgress.setPrefWidth(SPLASH_WIDTH - 20);
		progressText = new Label("Loading datasets...");
		splashLayout = new VBox();
		splashLayout.getChildren().addAll(splash, loadProgress, progressText);
		progressText.setAlignment(Pos.CENTER);
		splashLayout.setStyle("-fx-padding: 5; " + "-fx-background-color: cornsilk; " + "-fx-border-width:5; " + "-fx-border-color: " + "linear-gradient("
				+ "to bottom, " + "chocolate, " + "derive(chocolate, 50%)" + ");");
		splashLayout.setEffect(new DropShadow());
	}

	/**
	 * 
	 * Creates the starting message for the splash screen
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public static void startFX() throws Exception
	{
		final Task<ObservableList<String>> datasetTask = new Task<ObservableList<String>>()
		{
			@Override
			protected ObservableList<String> call() throws InterruptedException
			{
				ObservableList<String> datasets = FXCollections.<String>observableArrayList();
				ObservableList<String> availableDatasets = FXCollections.observableArrayList("RESIDENTIAL", "COMMERCIAL", "DROPBOX", "MILEAGE", "MISC",
						"RESIDENTIAL", "COMMERCIAL", "DROPBOX", "MILEAGE", "MISC");

				updateMessage("Finding datasets...");
				for (int i = 0; i < availableDatasets.size(); i++)
				{
					Thread.sleep(400);
					updateProgress(i + 1, availableDatasets.size());
					String nextDataset = availableDatasets.get(i);
					datasets.add(nextDataset);
					updateMessage("Finding datasets... " + nextDataset);
				}
				Thread.sleep(400);
				updateMessage("All datasets found.");

				return datasets;
			}
		};

		showSplash(mainStage, datasetTask);
		new Thread(datasetTask).start();
	}

	/**
	 * 
	 * Reveals the splash screen
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public static void showSplash(final Stage initStage, Task<?> task)
	{
		progressText.textProperty().bind(task.messageProperty());
		loadProgress.progressProperty().bind(task.progressProperty());
		task.stateProperty().addListener((observableValue, oldState, newState) ->
		{
			if (newState == Worker.State.SUCCEEDED)
			{
				loadProgress.progressProperty().unbind();
				loadProgress.setProgress(1);
				initStage.toFront();
				FadeTransition fadeSplash = new FadeTransition(Duration.seconds(1.2), splashLayout);
				fadeSplash.setFromValue(1.0);
				fadeSplash.setToValue(0.0);
				fadeSplash.setOnFinished(actionEvent -> initStage.hide());
				fadeSplash.play();

			}
		});

		Scene splashScene = new Scene(splashLayout, Color.TRANSPARENT);
		final Rectangle2D bounds = Screen.getPrimary().getBounds();
		initStage.setScene(splashScene);
		initStage.setX(bounds.getMinX() + bounds.getWidth() / 2 - SPLASH_WIDTH / 2);
		initStage.setY(bounds.getMinY() + bounds.getHeight() / 2 - SPLASH_HEIGHT / 2);
		initStage.initStyle(StageStyle.TRANSPARENT);
		initStage.setAlwaysOnTop(true);
		initStage.show();
	}

}