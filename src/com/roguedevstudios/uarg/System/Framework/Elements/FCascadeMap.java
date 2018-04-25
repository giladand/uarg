package com.roguedevstudios.uarg.System.Framework.Elements;

import com.roguedevstudios.uarg.System.Core.Elements.CascadeMap;

/**
 * Create and store CascadeMap interface objects
 * @author Caleb Ambrutis
 *
 */
public class FCascadeMap {
	/** Array to store the CascadeMap */
	private CascadeMap cascadeMap[];
	
	/**
	 * Method to initialize CascadeMap array
	 * @param size Size of array to initialize
	 * @author Caleb Ambrutis
	 */
	public void InitCascadeMap(
			int size // Size of array
			)
	{
		
		// Creates new CascadeMap array with specific size
		cascadeMap = new CascadeMap[size];
		
	}
	
	/**
	 * Method to get CascadeMap object at index number
	 * @param index The index number of the Array element
	 * @return CascadeMap object at index number
	 * @author Caleb Ambrutis
	 */
	public CascadeMap GetCascadeMap(
			int index // Index number of Array element
			)
	{
		
		// Return CascadeMap object at index number
		return cascadeMap[index];
		
	}
}
