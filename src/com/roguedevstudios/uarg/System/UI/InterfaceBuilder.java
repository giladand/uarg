package com.roguedevstudios.uarg.System.UI;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TableView;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;

public class InterfaceBuilder
{
	List<Service> Container = new ArrayList<Service>();
}


class Service
{
	private TitledPane TitledPane;
	private BorderPane BorderPane;
	private TabPane TabPane;

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

	public BorderPane getBorderPane()
	{
		return BorderPane;
	}

	public TabPane getTabPane()
	{
		return TabPane;
	}


	public void setTitledPane(TitledPane titledPane)
	{
		TitledPane = titledPane;
	}

	public void setBorderPane(BorderPane borderPane)
	{
		BorderPane = borderPane;
	}

	public void setTabPane(TabPane tabPane)
	{
		TabPane = tabPane;
	}

	public TitledPane createService()
	{
		// Test work to programmatically imitate Service made in SceneBuilder 
		
		// Create Titled Pane -TextName -Expanded // Where all content of the service is
		TitledPane newTitledPane = new TitledPane();
		newTitledPane.setText("Residential Service Lines");
		newTitledPane.setAlignment(Pos.TOP_CENTER);
		
		// Create Border Pane
		BorderPane mainBorderPane = new BorderPane(newTitledPane);
		newTitledPane.setContent(mainBorderPane);
		
		// Create Tab Pane -Side -TabClosingPolicy // Tabs for all inputs of the service
		TabPane newTabPane = new TabPane();
		newTabPane.setSide(Side.BOTTOM); // Set the tab pane to the bottom
		newTabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE); // Set closable to false so tabs cannot be closed
		mainBorderPane.setBottom(newTabPane);
		
		// Create Tab ex: Resid. Inputs
		Tab tab1 = new Tab("Resid. Inputs");
		newTabPane.getTabs().add(tab1);
		// Create Tab ex: Resid. Annuals
		Tab tab2 = new Tab("Resid. Annuals");
		newTabPane.getTabs().add(tab2);
		// Create Tab ex: Corp. Inputs
		Tab tab3 = new Tab("Corp. Inputs");
		newTabPane.getTabs().add(tab3);
		// Create Tab ex: Corp. Annuals
		Tab tab4 = new Tab("Corp. Annuals");
		newTabPane.getTabs().add(tab4);
		// Create Tab ex: DropBox Inputs
		Tab tab5 = new Tab("DropBox Inputs");
		newTabPane.getTabs().add(tab5);
		// Create Tab ex: DropBox Annuals
		Tab tab6 = new Tab("DropBox Annuals");
		newTabPane.getTabs().add(tab6);
		// Create Tab ex: DropBox Annuals
		Tab tab7 = new Tab("DropBox Annuals");
		newTabPane.getTabs().add(tab7);
		// Create Tab ex: Mileage
		Tab tab8 = new Tab("Mileage");
		newTabPane.getTabs().add(tab8);
		// Create Tab ex: Mileage
		Tab tab9 = new Tab("New");
		newTabPane.getTabs().add(tab9);
		
		// Create TableView -Editable
		TableView tabV = new TableView();
		tabV.setEditable(true); // Make table editable
		mainBorderPane.setCenter(tabV); // Add TableView to border
		return newTitledPane;
	}

}