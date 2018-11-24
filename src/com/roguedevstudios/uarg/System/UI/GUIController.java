package com.roguedevstudios.uarg.System.UI;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * The controller class for GUI.FXML.
 * 
 * @author Marko S. Bachynsky
 * @since 1.0
 */

public class GUIController implements Initializable
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
	public TableView<Data> ResidentialServiceLines;

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
		Scene scene = Root.getScene();
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
		Scene scene = Root.getScene();
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
		Scene scene = Root.getScene();
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
		Scene scene = Root.getScene();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource("/com/roguedevstudios/uarg/System/UI/Resources/WhiteOnBlack.css").toExternalForm());
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
		Scene scene = Root.getScene();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource("/com/roguedevstudios/uarg/System/UI/Resources/BlackOnWhite.css").toExternalForm());
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
		Scene scene = Root.getScene();
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource("/com/roguedevstudios/uarg/System/UI/Resources/YellowOnBlack.css").toExternalForm());
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
		// Single Cell Selection Mode
		ResidentialServiceLines.getSelectionModel().setCellSelectionEnabled(true);
		ResidentialServiceLines.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		AddColumnsToTableView();
		AddRowsToTableView(20);
		
		// Event for going into edit mode after key press and commit value on ENTER key
		ResidentialServiceLines.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>()
		{
			@Override
			public void handle(KeyEvent event)
			{
				if (event.getCode() == KeyCode.ENTER)
				{
					// event.consume(); Do not consume the event or else the values won't be updated
					return;
				}
				if (event.getCode().isLetterKey() || event.getCode().isDigitKey())
				{
					TablePosition<Data, String> focusedCellPosition = ResidentialServiceLines.getFocusModel().getFocusedCell();
					ResidentialServiceLines.edit(focusedCellPosition.getRow(), focusedCellPosition.getTableColumn());
					ResidentialServiceLines.getFocusModel().focus(focusedCellPosition);
				}
			}
		});

	}

	/**
	 * Number cell factory which converts strings to numbers and vice versa.
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	private Callback<TableColumn<Data, String>, TableCell<Data, String>> createNumberCellFactory()
	{

		Callback<TableColumn<Data, String>, TableCell<Data, String>> factory = TextFieldTableCell.forTableColumn(new StringConverter<String>()
		{

			@Override
			public String fromString(String string)
			{
				return string;
			}

			@Override
			public String toString(String string)
			{
				return string;
			}
		});
		return factory;
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
		// create columns
		List<String> columnList = Arrays.asList("Actual No. of Monthly Customers", "Service Frequencey Per Month", "Service Frequencey Per Year");
		for (String column : columnList)
		{
			TableColumn<Data, String> groupColumn = new TableColumn<>(column);
			groupColumn.setCellFactory(createNumberCellFactory());
			groupColumn.setCellValueFactory(cellData -> cellData.getValue().SetValueByColumn(column));
			groupColumn.setOnEditCommit((CellEditEvent<Data, String> cellEditEvent) ->
			{
				TableView<Data> tableView = cellEditEvent.getTableView();
				TablePosition<Data, String> tablePostion = cellEditEvent.getTablePosition();
				int rowIndex = tablePostion.getRow();

				ObservableList<Data> items = tableView.getItems();
				((Data) items.get(rowIndex)).SetCellValue(cellEditEvent.getNewValue());
			});
			ResidentialServiceLines.getColumns().add(groupColumn);
		}
	}

	/**
	 * 
	 * Adds rows to TableView
	 * 
	 * @param rowCount	Integer value of the rows to be added  
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void AddRowsToTableView(int rowCount)
	{
		List<String> columnList = Arrays.asList("Actual No. of Monthly Customers", "Service Frequencey Per Month", "Service Frequencey Per Year");

		// Add rows to the columns
		for (int i = 0; i < rowCount; i++)
		{
			Data row = new Data(columnList);
			ResidentialServiceLines.getItems().add(row);
		}
	}

}
