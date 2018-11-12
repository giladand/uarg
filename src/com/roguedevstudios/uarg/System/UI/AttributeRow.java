package com.roguedevstudios.uarg.System.UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AttributeRow
{
	private final StringProperty CELL_PROPERTY = new SimpleStringProperty();
	private Map<String, StringProperty> ValueByColumn = new HashMap<>();

	public AttributeRow(List<String> columnValue)
	{
		for (String column : columnValue)
		{
			ValueByColumn.put(column, new SimpleStringProperty());
		}
	}

	public StringProperty SetValueByColumn(String column)
	{
		return ValueByColumn.get(column);
	}

	public final StringProperty GetCellProperty()
	{
		return this.CELL_PROPERTY;
	}

	public String GetCellValue()
	{
		return this.GetCellProperty().get();
	}

	public void SetCellValue(String value)
	{
		this.GetCellProperty().set(value);
	}

}