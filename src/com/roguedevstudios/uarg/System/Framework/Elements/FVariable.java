package com.roguedevstudios.uarg.System.Framework.Elements;

import com.roguedevstudios.uarg.System.Core.Elements.Variable;

/**
 * Create and store Variable interface objects
 * @author Caleb Ambrutis
 *
 */
public class FVariable<V> {
	/** Array to store the Variable */
	private Variable<V> variable[];
	
	/**
	 * Method to initialize Variable array
	 * @param size Size of array to initialize
	 * @author Caleb Ambrutis
	 */
	public void InitVariable(
			int size // Size of array
			)
	{
		
		// Creates new Variable array with specific size
		variable = new Variable[size];
		
	}
	
	/**
	 * Method to get Variable object at index number
	 * @param index The index number of the Array element
	 * @return Variable object at index number
	 * @author Caleb Ambrutis
	 */
	public Variable<V> GetVariable(
			int index // Index number of Array element
			)
	{
		
		// Return Variable object at index number
		return variable[index];
		
	}
}
