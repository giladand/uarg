package com.roguedevstudios.uarg.System.UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The class that holds data for the TableView.
 * 
 * @author Marko S. Bachynsky
 * @since 1.0
 */

public class Data
{
	private final StringProperty CELL_PROPERTY = new SimpleStringProperty();
	private Map<String, StringProperty> ValueByColumn = new HashMap<>();

	/**
	 * 
	 * Constructor that uses a list to build the map with column names.
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public Data(List<String> columnValue)
	{
		for (String column : columnValue)
		{
			ValueByColumn.put(column, new SimpleStringProperty());
		}
	}

	/**
	 * 
	 * Sets the value of a cell by column.
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public StringProperty SetValueByColumn(String column)
	{
		return ValueByColumn.get(column);
	}

	/**
	 * 
	 * Sets the property of a cell.
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public final StringProperty GetCellProperty()
	{
		return this.CELL_PROPERTY;
	}

	/**
	 * 
	 * Gets the value of a cell.
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public String GetCellValue()
	{
		return this.GetCellProperty().get();
	}

	/**
	 * 
	 * Sets the value of a cell.
	 * 
	 * @since 1.0
	 * @author Marko S. Bachynsky
	 */
	public void SetCellValue(String value)
	{
		this.GetCellProperty().set(value);
	}

}