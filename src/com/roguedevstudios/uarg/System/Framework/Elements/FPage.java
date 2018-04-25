package com.roguedevstudios.uarg.System.Framework.Elements;

import com.roguedevstudios.uarg.System.Core.Elements.Page;

/**
 * Create and store Page interface objects
 * @author Caleb Ambrutis
 *
 */
public class FPage {
	/** Array to store the Page */
	private Page page[];
	
	/**
	 * Method to initialize Page array
	 * @param size Size of array to initialize
	 * @author Caleb Ambrutis
	 */
	public void InitPage(
			int size // Size of array
			)
	{
		
		// Creates new Page array with specific size
		page = new Page[size];
		
	}
	
	/**
	 * Method to get Page object at index number
	 * @param index The index number of the Array element
	 * @return Page object at index number
	 * @author Caleb Ambrutis
	 */
	public Page GetPage(
			int index // Index number of Array element
			)
	{
		
		// Return Page object at index number
		return page[index];
		
	}
}
