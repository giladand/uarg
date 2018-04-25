package com.roguedevstudios.uarg.System.Framework.Elements;

import com.roguedevstudios.uarg.System.Core.Elements.FormulaSet;

/**
 * Create and store FormulaSet interface objects
 * @author Caleb Ambrutis
 *
 */
public class FFormulaSet {
	/** Array to store the FormulaSet */
	private FormulaSet formulaSet[];
	
	/**
	 * Method to initialize FormulaSet array
	 * @param size Size of array to initialize
	 * @author Caleb Ambrutis
	 */
	public void InitFormulaSet(
			int size // Size of array
			)
	{
		
		// Creates new FormulaSet array with specific size
		formulaSet = new FormulaSet[size];
		
	}
	
	/**
	 * Method to get FormulaSet object at index number
	 * @param index The index number of the Array element
	 * @return FormulaSet object at index number
	 * @author Caleb Ambrutis
	 */
	public FormulaSet GetFormulaSet(
			int index // Index number of Array element
			)
	{
		
		// Return FormulaSet object at index number
		return formulaSet[index];
		
	}
}
