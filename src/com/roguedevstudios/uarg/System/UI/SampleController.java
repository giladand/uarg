package com.roguedevstudios.uarg.System.UI;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;

/**
 * The controller class for GUI.FXML.
 * 
 * @author Marko S. Bachynsky
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
	public TableView<AttributeRow> ResidentialServiceLines;
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
		
		Callback<TableColumn<AttributeRow, String>, TableCell<AttributeRow, String>> cellFactory = new Callback<TableColumn<AttributeRow, String>, TableCell<AttributeRow, String>>()
		{
			public TableCell<AttributeRow, String> call(TableColumn<AttributeRow, String> arg)
			{
				return new EditingCell();
			}
		};
		
		// create columns
		List<String> columnList = Arrays.asList("Actual No. of Monthly Customers", "Service Frequencey Per Month", "Service Frequencey Per Year");
		for (String column : columnList)
		{
			TableColumn<AttributeRow, String> groupColumn = new TableColumn<>(column);
			groupColumn.setCellFactory(cellFactory);
			groupColumn.setCellValueFactory(cellData -> cellData.getValue().SetValueByColumn(column));
			groupColumn.setOnEditCommit((CellEditEvent<AttributeRow, String> cellEditEvent) ->
			{
				TableView<AttributeRow> tableView = cellEditEvent.getTableView();
				TablePosition<AttributeRow, String> tablePostion = cellEditEvent.getTablePosition();
				int rowIndex = tablePostion.getRow();

				ObservableList<AttributeRow> items = tableView.getItems();
				((AttributeRow) items.get(rowIndex)).SetCellValue(cellEditEvent.getNewValue());
			});
			ResidentialServiceLines.getColumns().add(groupColumn);
		}

		// Add rows to the columns
		for (int i = 0; i < 10; i++)
		{
			AttributeRow row = new AttributeRow(columnList);
			ResidentialServiceLines.getItems().add(row);
		}
	}

}
