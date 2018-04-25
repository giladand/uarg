package com.roguedevstudios.uarg.System.Framework.Elements;

import com.roguedevstudios.uarg.System.Core.Elements.CascadeEntry;

/**
 * Create and store CascadeEntry interface objects
 * @author Caleb Ambrutis
 *
 */
public class FCascadeEntry {
	/** Array to store the CascadeEntry */
	private CascadeEntry cascadeEntry[];
	
	/**
	 * Method to initialize CascadeEntry array
	 * @param size Size of array to initialize
	 * @author Caleb Ambrutis
	 */
	public void InitCascadeEntry(
			int size // Size of array
			)
	{
		
		// Creates new CascadeEntry array with specific size
		cascadeEntry = new CascadeEntry[size];
		
	}
	
	/**
	 * Method to get CascadeEntry object at index number
	 * @param index The index number of the Array element
	 * @return CascadeEntry object at index number
	 * @author Caleb Ambrutis
	 */
	public CascadeEntry GetCascadeEntry(
			int index // Index number of Array element
			)
	{
		
		// Return CascadeEntry object at index number
		return cascadeEntry[index];
		
	}
}
