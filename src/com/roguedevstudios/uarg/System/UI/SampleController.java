package com.roguedevstudios.uarg.System.UI;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * The controller class for SampleFXML.
 * 
 * @author Marko S. Bachynsky
 * @author Dylan Richardson
 * @since 1.0
 */

public class SampleController implements Initializable
{
	@FXML
	public BorderPane Root;
	@FXML
	public MenuItem FileNew;
	@FXML
	public MenuItem FileOpen;
	@FXML
	public MenuItem FileImport;
	@FXML
	public MenuItem FileSave;
	@FXML
	public MenuItem FileSaveAs;
	@FXML
	public MenuItem EditCut;
	@FXML
	public MenuItem EditCopy;
	@FXML
	public MenuItem EditPaste;
	@FXML
	public MenuItem ViewHighContrastWhiteOnBlack;
	@FXML
	public MenuItem ViewHighContrastBlackOnWhite;
	@FXML
	public MenuItem ViewHighContrastYellowOnBlack;
	@FXML
	public TableView<FXPerson> ResidentialServiceLines;
	@FXML
	public TextField LastName;
	@FXML
	public TextField FirstName;
	@FXML
	public DatePicker Date;
	@FXML
	public TextField Cash;
	@FXML
	public TextField City;
	@FXML
	public TextField State;
	@FXML
	public Button AddEntry;

	/**
	 * 
	 * Clears all inputs
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void FileNewAction(ActionEvent event)
	{
		// TODO
	}

	/**
	 * 
	 * Opens a XBRL file, filling inputs with given data
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void FileOpenAction(ActionEvent event)
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Business File", "*.xblr"));
		File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null)
		{
			// TODO
		}
	}

	/**
	 * 
	 * Imports a supported file, filling inputs with given data
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void FileImportAction(ActionEvent event)
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Supported Files", "*.*"));
		File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null)
		{
			// TODO
		}
	}

	/**
	 * 
	 * Saves all data to a .xbrl file to the current file
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void FileSaveAction(ActionEvent event)
	{
		// TODO
	}

	/**
	 * 
	 * Saves all data to a .xbrl file, lets the user select a file to save to
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void FileSaveAsAction(ActionEvent event)
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Business File", "*.xblr"));
		File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null)
		{
			// TODO
		}
	}

	/**
	 * 
	 * Cuts the selected text
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void EditCutAction(ActionEvent event)
	{
		// TODO
		Scene scene = LastName.getScene();
		scene.getStylesheets().add(getClass().getResource("WhiteOnBlack.css").toExternalForm());
		if (scene.focusOwnerProperty().get() instanceof TextField)
		{
			TextField selectedTextField = (TextField) scene.focusOwnerProperty().get();
			selectedTextField.cut();
		}
	}

	/**
	 * 
	 * Copies the selected text
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void EditCopyAction(ActionEvent event)
	{
		Scene scene = LastName.getScene();
		if (scene.focusOwnerProperty().get() instanceof TextField)
		{
			TextField selectedTextField = (TextField) scene.focusOwnerProperty().get();
			selectedTextField.copy();
		}
	}

	/**
	 * 
	 * Pastes into the selected text or position
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void EditPasteAction(ActionEvent event)
	{
		Scene scene = LastName.getScene();
		if (scene.focusOwnerProperty().get() instanceof TextField)
		{
			TextField selectedTextField = (TextField) scene.focusOwnerProperty().get();
			selectedTextField.paste();
		}

	}

	/**
	 * 
	 * Switches to the WhiteonBlack .css file
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void ViewHighContrastWhiteOnBlackAction(ActionEvent event)
	{
		Scene scene = LastName.getScene();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource("WhiteOnBlack.css").toExternalForm());
	}

	/**
	 * 
	 * Switches to the BlackOnWhite .css file
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void ViewHighContrastBlackOnWhiteAction(ActionEvent event)
	{
		Scene scene = LastName.getScene();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource("BlackOnWhite.css").toExternalForm());
	}

	/**
	 * 
	 * Switches to the YellowOnBlack .css file
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void ViewHighContrastYellowOnBlackAction(ActionEvent event)
	{
		Scene scene = LastName.getScene();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource("YellowOnBlack.css").toExternalForm());
	}

	/**
	 * 
	 * Calls the method to add columns to TableView, and a update listener to
	 * TableView
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		AddColumnsToTableView();

		AddEntry.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent evt)
			{

				AddEntryToTableView();
			}
		});

		ResidentialServiceLines.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FXPerson>()
		{
			@Override
			public void changed(ObservableValue<? extends FXPerson> obs, FXPerson oldSelection, FXPerson newSelection)
			{
				if (newSelection != null)
				{
					LastName.setText(newSelection.get_lastName());
					FirstName.setText(newSelection.get_firstName());
					Date.setValue(newSelection.get_date());
					Cash.setText(Double.toString(newSelection.get_cash()));
					City.setText(newSelection.get_city());
					State.setText(newSelection.get_state());

					AddEntry.setText("Update");
					AddEntry.setOnAction(new EventHandler<ActionEvent>()
					{
						@Override
						public void handle(ActionEvent evt)
						{
							UpdateEntryToTableView();
						}
					});
				}
			}
		});

	}

	/**
	 * 
	 * Adds columns to TableView
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void AddColumnsToTableView()
	{
		TableColumn<FXPerson, String> lastNameColumn = new TableColumn<FXPerson, String>("Last Name");
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<FXPerson, String>("_lastName"));

		TableColumn<FXPerson, String> firstNameColumn = new TableColumn<FXPerson, String>("First Name");
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<FXPerson, String>("_firstName"));

		TableColumn<FXPerson, LocalDate> dateColumn = new TableColumn<FXPerson, LocalDate>("Date");
		dateColumn.setCellValueFactory(new PropertyValueFactory<FXPerson, LocalDate>("_date"));

		TableColumn<FXPerson, Double> cashColumn = new TableColumn<FXPerson, Double>("Cash");
		cashColumn.setCellValueFactory(new PropertyValueFactory<FXPerson, Double>("_cash"));

		TableColumn<FXPerson, String> cityColumn = new TableColumn<FXPerson, String>("City");
		cityColumn.setCellValueFactory(new PropertyValueFactory<FXPerson, String>("_city"));

		TableColumn<FXPerson, String> stateColumn = new TableColumn<FXPerson, String>("State");
		stateColumn.setCellValueFactory(new PropertyValueFactory<FXPerson, String>("_state"));

		ResidentialServiceLines.getColumns().addAll(lastNameColumn, firstNameColumn, dateColumn, cashColumn, cityColumn, stateColumn);
	}

	/**
	 * 
	 * Adds a lineitem to the TableView
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void AddEntryToTableView()
	{
		ResidentialServiceLines.getItems().add(
				new FXPerson(LastName.getText(), FirstName.getText(), Date.getValue(), Double.parseDouble(Cash.getText()), City.getText(), State.getText()));
		ResidentialServiceLines.getSelectionModel().clearSelection();
		LastName.clear();
		FirstName.clear();
		Date.setValue(null);
		Cash.clear();
		City.clear();
		State.clear();
	}

	/**
	 * 
	 * Updates a lineitem to the TableView
	 * 
	 * @since 1.0
 	 * @author Marko S. Bachynsky
	 */
	public void UpdateEntryToTableView()
	{
		FXPerson person = ResidentialServiceLines.getSelectionModel().getSelectedItem();

		person.set_firstName(FirstName.getText());
		person.set_lastName(LastName.getText());
		person.set_date(Date.getValue());
		person.set_cash(Double.parseDouble(Cash.getText()));
		person.set_city(City.getText());
		person.set_state(State.getText());

		// Clear Selection
		LastName.clear();
		FirstName.clear();
		Date.setValue(null);
		Cash.clear();
		City.clear();
		State.clear();

		AddEntry.setText("Add");
		AddEntry.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent evt)
			{
				AddEntryToTableView();
			}
		});
		ResidentialServiceLines.refresh();
	}

}
