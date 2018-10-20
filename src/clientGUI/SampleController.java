package clientGUI;

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
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.text.Text; // Added
import javafx.scene.text.Font; // Added

/**
 * A class the User Interface handling.
 * 
 * @author Marko Bachynsky
 * @author Dylan Richardson
 * @since 1.0
 */

public class SampleController implements Initializable {
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
    public MenuItem EditUndo;
    @FXML
    public MenuItem EditRedo;
    @FXML
    public MenuItem EditCut;
    @FXML
    public MenuItem EditCopy;
    @FXML
    public MenuItem EditPaste;
    @FXML
    public TableView<Person> ResidentialServiceLines;
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

    // private Stack<Memento> _savedStates = new Stack<Memento>();

    public Text t = new Text(); // Added

    @FXML

    public void FileNewAction(ActionEvent event) {
	// TODO
    }

    public void FileOpenAction(ActionEvent event) {
	FileChooser fileChooser = new FileChooser();
	fileChooser.setTitle("Open Resource File");
	fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Business File", "*.xblr"));
	File selectedFile = fileChooser.showOpenDialog(null);
	if (selectedFile != null) {
	    // TODO
	}
    }

    public void FileImportAction(ActionEvent event) {
	FileChooser fileChooser = new FileChooser();
	fileChooser.setTitle("Open Resource File");
	fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Supported Files", "*.*"));
	File selectedFile = fileChooser.showOpenDialog(null);
	if (selectedFile != null) {
	    // TODO
	}
    }

    public void FileSaveAction(ActionEvent event) {
	// TODO
    }

    public void FileSaveAsAction(ActionEvent event) {
	FileChooser fileChooser = new FileChooser();
	fileChooser.setTitle("Open Resource File");
	fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Business File", "*.xblr"));
	File selectedFile = fileChooser.showOpenDialog(null);
	if (selectedFile != null) {
	    // TODO
	}
    }

    public void EditUndoAction(ActionEvent event) {
	// try {
	// if (TextFieldTest.getText().equals(_savedStates.peek().getSTRING())) {
	// System.out.println(TextFieldTest.getText() + "Not added");
	// return;
	// }

	// } catch (EmptyStackException error) {
	// System.out.println(error);

	// } finally {
	// if (TextFieldTest.getText().equals("")) {
	// System.out.println(textField_Test.getText() + "Not added");
	// return;
	// }
	// System.out.println(TextFieldTest.getText() + " added");
	// _savedStates.add(new Memento(TextFieldTest, TextFieldTest.getText()));
	// TextFieldTest.clear();
	// }
    }

    public void EditRedoAction(ActionEvent event) {
	/*
	 * try { //TextFieldTest.setText(_savedStates.pop().getSTRING());
	 * //System.out.println("Text Field updated to " + TextFieldTest.getText() +
	 * ", size of Saved States is now " + _savedStates.size()); } catch
	 * (EmptyStackException error) { System.out.println(error); }
	 */
    }

    public void EditCutAction(ActionEvent event) {
	// TODO
	Scene scene = LastName.getScene();
	if (scene.focusOwnerProperty().get() instanceof TextField) {
	    TextField selectedTextField = (TextField) scene.focusOwnerProperty().get();
	    selectedTextField.cut();
	}
    }

    public void EditCopyAction(ActionEvent event) {
	Scene scene = LastName.getScene();
	if (scene.focusOwnerProperty().get() instanceof TextField) {
	    TextField selectedTextField = (TextField) scene.focusOwnerProperty().get();
	    selectedTextField.copy();
	}
    }

    public void EditPasteAction(ActionEvent event) {
	Scene scene = LastName.getScene();
	if (scene.focusOwnerProperty().get() instanceof TextField) {
	    TextField selectedTextField = (TextField) scene.focusOwnerProperty().get();
	    selectedTextField.paste();
	}

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
	AddColumnsToTableView();

	AddEntry.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent evt) {

		AddEntryToTableView();
	    }
	});

	ResidentialServiceLines.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
	    @Override
	    public void changed(ObservableValue<? extends Person> obs, Person oldSelection, Person newSelection) {
		if (newSelection != null) {
		    LastName.setText(newSelection.get_lastName());
		    FirstName.setText(newSelection.get_firstName());
		    Date.setValue(newSelection.get_date());
		    Cash.setText(Double.toString(newSelection.get_cash()));
		    City.setText(newSelection.get_city());
		    State.setText(newSelection.get_state());

		    AddEntry.setText("Update");
		    AddEntry.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent evt) {
			    UpdateEntryToTableView();
			}
		    });
		}
	    }
	});

    }

    public void AddColumnsToTableView() {
	TableColumn<Person, String> lastNameColumn = new TableColumn<Person, String>("Last Name");
	lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("_lastName"));

	TableColumn<Person, String> firstNameColumn = new TableColumn<Person, String>("First Name");
	firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("_firstName"));

	TableColumn<Person, LocalDate> dateColumn = new TableColumn<Person, LocalDate>("Date");
	dateColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("_date"));

	TableColumn<Person, Double> cashColumn = new TableColumn<Person, Double>("Cash");
	cashColumn.setCellValueFactory(new PropertyValueFactory<Person, Double>("_cash"));

	TableColumn<Person, String> cityColumn = new TableColumn<Person, String>("City");
	cityColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("_city"));

	TableColumn<Person, String> stateColumn = new TableColumn<Person, String>("State");
	stateColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("_state"));

	ResidentialServiceLines.getColumns().addAll(lastNameColumn, firstNameColumn, dateColumn, cashColumn, cityColumn,
		stateColumn);
    }

    public void AddEntryToTableView() {

	// ObservableList<Person> data = FXCollections.observableArrayList();
	// data.add(new Person(LastName.getText(), FirstName.getText(), Date.getValue(),
	// Double.parseDouble(Cash.getText()), City.getText(), State.getText()));
	ResidentialServiceLines.getItems().add(new Person(LastName.getText(), FirstName.getText(), Date.getValue(),
		Double.parseDouble(Cash.getText()), City.getText(), State.getText()));
	// ResidentialServiceLines.setItems(data);
	ResidentialServiceLines.getSelectionModel().clearSelection();
	// AddEntry.setText("Save");
	LastName.clear();
	FirstName.clear();
	Date.setValue(null);
	Cash.clear();
	City.clear();
	State.clear();
    }

    public void UpdateEntryToTableView() {
	System.out.println("Wow it worked, good job");
	Person person = ResidentialServiceLines.getSelectionModel().getSelectedItem();

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
	AddEntry.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent evt) {
		AddEntryToTableView();
	    }
	});
	ResidentialServiceLines.refresh();
    }

    public void ChangeFontSize() {
	t.setText("This is a text sample");
	t.setFont(Font.font("Times New Roman", 12));
	t.setFill(Color.RED);
	// TextFieldTest.setFont(t.getFont());

    }

}
