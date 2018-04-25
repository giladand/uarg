package com.roguedevstudios.uarg.System.Framework.Elements;

import com.roguedevstudios.uarg.System.Core.Elements.Formula;

/**
 * Create and store Formula interface objects
 * @author Caleb Ambrutis
 *
 */
public class FFormula {
	/** Array to store the Formula */
	private Formula formula[];
	
	/**
	 * Method to initialize Formula array
	 * @param size Size of array to initialize
	 * @author Caleb Ambrutis
	 */
	public void InitFormula(
			int size // Size of array
			)
	{
		
		// Creates new Formula array with specific size
		formula = new Formula[size];
		
	}
	
	/**
	 * Method to get Formula object at index number
	 * @param index The index number of the Array element
	 * @return Formula object at index number
	 * @author Caleb Ambrutis
	 */
	public Formula GetFormula(
			int index // Index number of Array element
			)
	{
		
		// Return Formula object at index number
		return formula[index];
		
	}
}
