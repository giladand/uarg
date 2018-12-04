package com.roguedevstudios.uarg.System.UI;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TitledPane;

public class InterfaceBuilder
{
	List<Service> Container = new ArrayList<Service>();


}


class Service
{
	private TitledPane TitledPane;
	private javafx.scene.layout.BorderPane BorderPane;
	private javafx.scene.control.TabPane TabPane;

	public Service()
	{
		this.TitledPane = new TitledPane();
		this.BorderPane = new javafx.scene.layout.BorderPane();
		this.TabPane = new javafx.scene.control.TabPane();
	}

	
	
	
	
	
	
	
	
	public TitledPane getTitledPane()
	{
		return TitledPane;
	}

	public javafx.scene.layout.BorderPane getBorderPane()
	{
		return BorderPane;
	}

	public javafx.scene.control.TabPane getTabPane()
	{
		return TabPane;
	}

	
	public void setTitledPane(TitledPane titledPane)
	{
		TitledPane = titledPane;
	}

	public void setBorderPane(javafx.scene.layout.BorderPane borderPane)
	{
		BorderPane = borderPane;
	}

	public void setTabPane(javafx.scene.control.TabPane tabPane)
	{
		TabPane = tabPane;
	}
}