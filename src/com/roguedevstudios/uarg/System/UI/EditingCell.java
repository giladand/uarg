package com.roguedevstudios.uarg.System.UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

/**
 * Supporting class for AttributeRow. Creates a new kind of EditingCell for direct editing.
 * 
 * @author Marko S. Bachynsky
 * @since 1.0
 */

public class EditingCell extends TableCell<AttributeRow, String>
{
	private TextField textField;

	public EditingCell()
	{

	}

	@Override
	public void startEdit()
	{
		if (!isEmpty())
		{
			super.startEdit();
			createTextField();
			setText(null);
			setGraphic(textField);
			textField.selectAll();
		}
	}

	@Override
	public void cancelEdit()
	{
		super.cancelEdit();

		setText((String) getItem());
		setGraphic(null);
	}

	@Override
	public void updateItem(String item, boolean empty)
	{
		super.updateItem(item, empty);

		if (empty)
		{
			setText(null);
			setGraphic(null);
		} else
		{
			if (isEditing())
			{
				if (textField != null)
				{
					textField.setText(getString());
				}
				setText(null);
				setGraphic(textField);
			} else
			{
				setText(getString());
				setGraphic(null);
			}
		}
	}

	private void createTextField()
	{
		textField = new TextField(getString());
		textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
		textField.focusedProperty().addListener(new ChangeListener<Boolean>()
		{
			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2)
			{
				if (!arg2)
				{
					commitEdit(textField.getText());
				}
			}
		});
	}

	private String getString()
	{
		return getItem() == null ? "" : getItem().toString();
	}
}
