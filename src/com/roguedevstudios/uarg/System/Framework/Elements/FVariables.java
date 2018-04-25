package com.roguedevstudios.uarg.System.Framework.Elements;

import com.roguedevstudios.uarg.System.Core.Elements.Variables;

/**
 * Create and store Variables interface objects
 * @author Caleb Ambrutis
 *
 */
public class FVariables {
	/** Array to store the Variables */
	private Variables variables[];
	
	/**
	 * Method to initialize Variables array
	 * @param size Size of array to initialize
	 * @author Caleb Ambrutis
	 */
	public void InitVariables(
			int size // Size of array
			)
	{
		
		// Creates new Variables array with specific size
		variables = new Variables[size];
		
	}
	
	/**
	 * Method to get Variables object at index number
	 * @param index The index number of the Array element
	 * @return Variables object at index number
	 * @author Caleb Ambrutis
	 */
	public Variables GetVariables(
			int index // Index number of Array element
			)
	{
		
		// Return Variables object at index number
		return variables[index];
		
	}
}
