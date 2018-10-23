package clientGUI;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
=======
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
>>>>>>> UARG-241
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
<<<<<<< HEAD
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
=======
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
>>>>>>> UARG-241
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
<<<<<<< HEAD
import javafx.util.Callback;
=======
>>>>>>> UARG-241
import javafx.scene.text.Text; // Added
import javafx.scene.text.Font; // Added

/**
 * A class the User Interface handling.
 * 
 * @author Marko Bachynsky
 * @author Dylan Richardson
<<<<<<< HEAD
 * @param <V>
 * @since 1.0
 */

public class SampleController<V> implements Initializable {
=======
 * @since 1.0
 */

public class SampleController implements Initializable {
>>>>>>> UARG-241
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
<<<<<<< HEAD
    public TableView<VariableTableView<V>> ResidentialServiceLines;
=======
    public TableView<Person> ResidentialServiceLines;
>>>>>>> UARG-241
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

<<<<<<< HEAD
    /*
    * @author Marko Bachynsky
    */
    @FXML
=======
    @FXML

>>>>>>> UARG-241
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
<<<<<<< HEAD
	testAddColumnsToTableView();
	testAddGivenCellsToColumns();
	
	
=======
	AddColumnsToTableView();

>>>>>>> UARG-241
	AddEntry.setOnAction(new EventHandler<ActionEvent>() {
	    @Override
	    public void handle(ActionEvent evt) {

		AddEntryToTableView();
	    }
	});
<<<<<<< HEAD
	
	
	/*
	ResidentialServiceLines.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Variable<V>TableView>() {
	    @Override
	    public void changed(ObservableValue<? extends Variable<V>TableView> obs, Variable<V>TableView oldSelection, Variable<V>TableView newSelection) {
		if (newSelection != null) {
		    LastName.setText(newSelection.getVariable<V>().toString());
		    /*
=======

	ResidentialServiceLines.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
	    @Override
	    public void changed(ObservableValue<? extends Person> obs, Person oldSelection, Person newSelection) {
		if (newSelection != null) {
		    LastName.setText(newSelection.get_lastName());
>>>>>>> UARG-241
		    FirstName.setText(newSelection.get_firstName());
		    Date.setValue(newSelection.get_date());
		    Cash.setText(Double.toString(newSelection.get_cash()));
		    City.setText(newSelection.get_city());
		    State.setText(newSelection.get_state());
<<<<<<< HEAD
		     
=======

>>>>>>> UARG-241
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
<<<<<<< HEAD
	*/
    }

    public void testAddColumnsToTableView() {

	// columns = new Map<?, Object>();

	//Object[] values = columns.values().toArray();


	// Cells for Row Headers
	Variable<String> varRowHeader1  = new Variable<String>(null, null, false, "Row Header", "1-20 gal Mini Can Wkly");
	Variable<String> varRowHeader2  = new Variable<String>(null, null, false, "Row Header", "1-20 gal Mini Can EOW");
	Variable<String> varRowHeader3  = new Variable<String>(null, null, false, "Row Header", "1-32 gal Can Wkly");
	Variable<String> varRowHeader4  = new Variable<String>(null, null, false, "Row Header", "2-32 gal Can Wkly");
	Variable<String> varRowHeader5  = new Variable<String>(null, null, false, "Row Header", "3-32 gal Can Wkly");
	Variable<String> varRowHeader6  = new Variable<String>(null, null, false, "Row Header", "1-32 gal Can EOW");
	Variable<String> varRowHeader7  = new Variable<String>(null, null, false, "Row Header", "2-32 gal Can EOW");
	Variable<String> varRowHeader8  = new Variable<String>(null, null, false, "Row Header", "1-32 gal Can Monthly");
	Variable<String> varRowHeader9  = new Variable<String>(null, null, false, "Row Header", "2-32 gal Can Monthly");
	Variable<String> varRowHeader10 = new Variable<String>(null, null, false, "Row Header", "1-65 gal Toter Wkly");
	Variable<String> varRowHeader11 = new Variable<String>(null, null, false, "Row Header", "1-65 gal toter Monthly");
	Variable<String> varRowHeader12 = new Variable<String>(null, null, false, "Row Header", "Extra Can, Bag, Box etc");
	// Cells for Headers
	Variable<Double> varColumnHeader1 = new Variable<Double>("Actual No. of Monthly Customers", null, false, "Column Header", 0.0);
	Variable<Double> varColumnHeader2 = new Variable<Double>("Service Frequencey per Month", null, false, "Column Header", 0.0);
	Variable<Double> varColumnHeader3 = new Variable<Double>("Service Frequencey Per Year", null, false, "Column Header", 0.0);
	Variable<Double> varColumnHeader4 = new Variable<Double>("Current Monthly Tariff Rate", null, false, "Column Header", 0.0);
	Variable<Double> varColumnHeader5 = new Variable<Double>("Proposed Rate", null, false, "Column Header", 0.0);

	ArrayList<Variable> tempValues = new ArrayList<Variable>();
	tempValues.add(varRowHeader1);
	tempValues.add(varRowHeader2);
	tempValues.add(varRowHeader3);
	tempValues.add(varRowHeader4);
	tempValues.add(varRowHeader5);
	tempValues.add(varRowHeader6);
	tempValues.add(varRowHeader7);
	tempValues.add(varRowHeader8);
	tempValues.add(varRowHeader9);
	tempValues.add(varRowHeader10);
	tempValues.add(varRowHeader11);
	tempValues.add(varRowHeader12);
	tempValues.add(varColumnHeader1);
	tempValues.add(varColumnHeader2);
	tempValues.add(varColumnHeader3);
	tempValues.add(varColumnHeader4);
	tempValues.add(varColumnHeader5);

	// Column with Row Headers
	TableColumn<VariableTableView<V>, String> rowHeaderColumn = new TableColumn<VariableTableView<V>, String>(" ");
	rowHeaderColumn.setCellValueFactory(new PropertyValueFactory<VariableTableView<V>, String>("text"));
	
	// Column 1
	TableColumn<VariableTableView<V>, Double> column1 = new TableColumn<VariableTableView<V>, Double>(varColumnHeader1.GetName());
	column1.setCellValueFactory(new PropertyValueFactory<VariableTableView<V>, Double>("number1"));
	column1.setCellFactory(new Callback<TableColumn<VariableTableView<V>, Double>, TableCell<VariableTableView<V>, Double>>() {
	    @Override
	    public TableCell<VariableTableView<V>, Double> call(TableColumn<VariableTableView<V>, Double> col) {
		return new TextFieldTableCell<VariableTableView<V>, Double>() {
		    @Override 
		    public void updateItem(Double cash, boolean empty) {
		        super.updateItem(cash, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            setText(String.format("%.2f", cash.doubleValue()));
		        }
		    }
		};
	    }
	});
	column1.setOnEditCommit(
	    new EventHandler<CellEditEvent<VariableTableView<V>, Double>>() {
	        @Override
	        public void handle(CellEditEvent<VariableTableView<V>, Double> t) {
	            ((VariableTableView<V>) t.getTableView().getItems().get(
	                t.getTablePosition().getRow())
	                ).setNumber1(t.getNewValue());
	        }
	    }
	);
	
	// Column 2
	TableColumn<VariableTableView<V>, Double> column2 = new TableColumn<VariableTableView<V>, Double>(varColumnHeader2.GetName());
	column2.setCellValueFactory(new PropertyValueFactory<VariableTableView<V>, Double>("number2"));
	column2.setCellFactory(new Callback<TableColumn<VariableTableView<V>, Double>, TableCell<VariableTableView<V>, Double>>() {
	    @Override
	    public TableCell<VariableTableView<V>, Double> call(TableColumn<VariableTableView<V>, Double> col) {
		return new TextFieldTableCell<VariableTableView<V>, Double>() {
		    @Override 
		    public void updateItem(Double cash, boolean empty) {
		        super.updateItem(cash, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            setText(String.format("%.2f", cash.doubleValue()));
		        }
		    }
		};
	    }
	});
	column2.setOnEditCommit(
	    new EventHandler<CellEditEvent<VariableTableView<V>, Double>>() {
	        @Override
	        public void handle(CellEditEvent<VariableTableView<V>, Double> t) {
	            ((VariableTableView<V>) t.getTableView().getItems().get(
	                t.getTablePosition().getRow())
	                ).setNumber2(t.getNewValue());
	        }
	    }
	);
	
	// Column 3
	TableColumn<VariableTableView<V>, Double> column3 = new TableColumn<VariableTableView<V>, Double>(varColumnHeader3.GetName());
	column3.setCellValueFactory(new PropertyValueFactory<VariableTableView<V>, Double>("number3"));
	column3.setCellFactory(new Callback<TableColumn<VariableTableView<V>, Double>, TableCell<VariableTableView<V>, Double>>() {
	    @Override
	    public TableCell<VariableTableView<V>, Double> call(TableColumn<VariableTableView<V>, Double> col) {
		return new TextFieldTableCell<VariableTableView<V>, Double>() {
		    @Override 
		    public void updateItem(Double cash, boolean empty) {
		        super.updateItem(cash, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            setText(String.format("%.2f", cash.doubleValue()));
		        }
		    }
		};
	    }
	});
	column3.setOnEditCommit(
	    new EventHandler<CellEditEvent<VariableTableView<V>, Double>>() {
	        @Override
	        public void handle(CellEditEvent<VariableTableView<V>, Double> t) {
	            ((VariableTableView<V>) t.getTableView().getItems().get(
	                t.getTablePosition().getRow())
	                ).setNumber3(t.getNewValue());
	        }
	    }
	);
	
	// Column 4
	TableColumn<VariableTableView<V>, Double> column4 = new TableColumn<VariableTableView<V>, Double>(varColumnHeader4.GetName());
	column4.setCellValueFactory(new PropertyValueFactory<VariableTableView<V>, Double>("number4"));
	column4.setCellFactory(new Callback<TableColumn<VariableTableView<V>, Double>, TableCell<VariableTableView<V>, Double>>() {
	    @Override
	    public TableCell<VariableTableView<V>, Double> call(TableColumn<VariableTableView<V>, Double> col) {
		return new TextFieldTableCell<VariableTableView<V>, Double>() {
		    @Override 
		    public void updateItem(Double cash, boolean empty) {
		        super.updateItem(cash, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            setText(String.format("%.2f", cash.doubleValue()));
		        }
		    }
		};
	    }
	});
	column4.setOnEditCommit(
	    new EventHandler<CellEditEvent<VariableTableView<V>, Double>>() {
	        @Override
	        public void handle(CellEditEvent<VariableTableView<V>, Double> t) {
	            ((VariableTableView<V>) t.getTableView().getItems().get(
	                t.getTablePosition().getRow())
	                ).setNumber4(t.getNewValue());
	        }
	    }
	);
	
	// Column 5
	TableColumn<VariableTableView<V>, Double> column5 = new TableColumn<VariableTableView<V>, Double>(varColumnHeader5.GetName());
	column5.setCellValueFactory(new PropertyValueFactory<VariableTableView<V>, Double>("number5"));
	column5.setCellFactory(new Callback<TableColumn<VariableTableView<V>, Double>, TableCell<VariableTableView<V>, Double>>() {
	    @Override
	    public TableCell<VariableTableView<V>, Double> call(TableColumn<VariableTableView<V>, Double> col) {
		return new TextFieldTableCell<VariableTableView<V>, Double>() {
		    @Override 
		    public void updateItem(Double cash, boolean empty) {
		        super.updateItem(cash, empty);
		        if (empty) {
		            setText(null);
		        } else {
		            setText(String.format("%.2f", cash.doubleValue()));
		        }
		    }
		};
	    }
	});
	column5.setOnEditCommit(
	    new EventHandler<CellEditEvent<VariableTableView<V>, Double>>() {
	        @Override
	        public void handle(CellEditEvent<VariableTableView<V>, Double> t) {
	            ((VariableTableView<V>) t.getTableView().getItems().get(
	                t.getTablePosition().getRow())
	                ).setNumber5(t.getNewValue());
	        }
	    }
	);
	
	ResidentialServiceLines.getColumns().addAll(rowHeaderColumn, column1, column2, column3, column4, column5);
	
	/*
	for (int i = 0; i < tempValues.size(); i++) {

	    if (tempValues.get(i).GetValue() instanceof String) {
		String text = (String) tempValues.get(i).GetValue();
		System.out.println("\n" + text + " and this value is of type String");

	    } else if (tempValues.get(i).GetValue() instanceof Double) {
		Double number = (Double) tempValues.get(i).GetValue();
		System.out.println("\n" + number + " and this value is of type Double");
	    }

	} */
	
    }
    
    public void testAddGivenCellsToColumns() {
	// Cells for Row Headers
	Variable<String> varRowHeader1  = new Variable<String>(null, null, false, "Row Header", "1-20 gal Mini Can Wkly");
	Variable<String> varRowHeader2  = new Variable<String>(null, null, false, "Row Header", "1-20 gal Mini Can EOW");
	Variable<String> varRowHeader3  = new Variable<String>(null, null, false, "Row Header", "1-32 gal Can Wkly");
	Variable<String> varRowHeader4  = new Variable<String>(null, null, false, "Row Header", "2-32 gal Can Wkly");
	Variable<String> varRowHeader5  = new Variable<String>(null, null, false, "Row Header", "3-32 gal Can Wkly");
	Variable<String> varRowHeader6  = new Variable<String>(null, null, false, "Row Header", "1-32 gal Can EOW");
	Variable<String> varRowHeader7  = new Variable<String>(null, null, false, "Row Header", "2-32 gal Can EOW");
	Variable<String> varRowHeader8  = new Variable<String>(null, null, false, "Row Header", "1-32 gal Can Monthly");
	Variable<String> varRowHeader9  = new Variable<String>(null, null, false, "Row Header", "2-32 gal Can Monthly");
	Variable<String> varRowHeader10 = new Variable<String>(null, null, false, "Row Header", "1-65 gal Toter Wkly");
	Variable<String> varRowHeader11 = new Variable<String>(null, null, false, "Row Header", "1-65 gal toter Monthly");
	Variable<String> varRowHeader12 = new Variable<String>(null, null, false, "Row Header", "Extra Can, Bag, Box etc");

	ArrayList<Variable> tempValues = new ArrayList<Variable>();
	tempValues.add(varRowHeader1);
	tempValues.add(varRowHeader2);
	tempValues.add(varRowHeader3);
	tempValues.add(varRowHeader4);
	tempValues.add(varRowHeader5);
	tempValues.add(varRowHeader6);
	tempValues.add(varRowHeader7);
	tempValues.add(varRowHeader8);
	tempValues.add(varRowHeader9);
	tempValues.add(varRowHeader10);
	tempValues.add(varRowHeader11);
	tempValues.add(varRowHeader12);
	
	ObservableList<VariableTableView<V>> items = FXCollections.observableArrayList();
        for (int i = 0; i < tempValues.size(); i++) {
            Variable varObject = tempValues.get(i);
            VariableTableView newVTVObject = new VariableTableView((String) varObject.GetValue(), 0.0, 0.0, 0.0, 0.0, 0.0);
            items.add(newVTVObject);
        }
	
	ResidentialServiceLines.setItems(items);
	System.out.println("hey 1123124");
	
    }
    
    
    
    public void AddColumnsToTableView() {
	//TableColumn<Variable<V>TableView, String> lastNameColumn = new TableColumn<Variable<V>TableView, String>("Last Name");
	//lastNameColumn.setCellValueFactory(new PropertyValueFactory<Variable<V>TableView, String>("_value"));

	
	TableColumn<VariableTableView<V>, String> lastNameColumn = new TableColumn<VariableTableView<V>, String>("Text");
	lastNameColumn.setCellValueFactory(new PropertyValueFactory<VariableTableView<V>, String>("listArray"));

	
	/*
	TableColumn<Variable<V>, Variable<V>> secondColumn = new TableColumn<Variable<V>, Variable<V>>("Name");
	secondColumn.setCellValueFactory(new PropertyValueFactory<Variable<V>, Variable<V>>("_value"));
	
	TableColumn<Variable<V>, Variable<V>> thirdColumn = new TableColumn<Variable<V>, Variable<V>>("Name");
	thirdColumn.setCellValueFactory(new PropertyValueFactory<Variable<V>, Variable<V>>("_value"));

	*/
	//ResidentialServiceLines.getColumns().addAll(firstColumn, secondColumn, thirdColumn);
	ResidentialServiceLines.getColumns().add(lastNameColumn);
=======

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
>>>>>>> UARG-241
    }

    public void AddEntryToTableView() {

<<<<<<< HEAD
	/*
	Variable<V> varObject = new Variable<V>("", "", false, LastName.getText());
	//VariableTableView<V> cellObject = new VariableTableView<V>(varObject, LastName.getText());
	VariableTableView<V> cellObject = new VariableTableView<V>(new String[]{LastName.getText()});
	
	ResidentialServiceLines.getItems().add(cellObject);
	System.out.println(cellObject.getText() + " added");
	ResidentialServiceLines.getSelectionModel().clearSelection();
	
	AddEntry.setText("Save");
	LastName.clear();

	/*
=======
	// ObservableList<Person> data = FXCollections.observableArrayList();
	// data.add(new Person(LastName.getText(), FirstName.getText(), Date.getValue(),
	// Double.parseDouble(Cash.getText()), City.getText(), State.getText()));
	ResidentialServiceLines.getItems().add(new Person(LastName.getText(), FirstName.getText(), Date.getValue(),
		Double.parseDouble(Cash.getText()), City.getText(), State.getText()));
	// ResidentialServiceLines.setItems(data);
	ResidentialServiceLines.getSelectionModel().clearSelection();
	// AddEntry.setText("Save");
	LastName.clear();
>>>>>>> UARG-241
	FirstName.clear();
	Date.setValue(null);
	Cash.clear();
	City.clear();
<<<<<<< HEAD
	State.clear(); */
=======
	State.clear();
>>>>>>> UARG-241
    }

    public void UpdateEntryToTableView() {
	System.out.println("Wow it worked, good job");
<<<<<<< HEAD
	
	//Person cellObject = ResidentialServiceLines.getSelectionModel().getSelectedItem();
	Variable<V> newVariableObject = new Variable<V>("Last Name", "Last Name", true, "", (V) LastName.getText());
	//cellObject.setVariable<V>(newVariable<V>Object);
	
=======
	Person person = ResidentialServiceLines.getSelectionModel().getSelectedItem();

	person.set_firstName(FirstName.getText());
	person.set_lastName(LastName.getText());
	person.set_date(Date.getValue());
	person.set_cash(Double.parseDouble(Cash.getText()));
	person.set_city(City.getText());
	person.set_state(State.getText());

>>>>>>> UARG-241
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
