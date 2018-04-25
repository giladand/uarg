package com.roguedevstudios.uarg.System.Framework.Elements;

import com.roguedevstudios.uarg.System.Core.Elements.Formuli;

/**
 * Create and store Formuli interface objects
 * @author Caleb Ambrutis
 *
 */
public class FFormuli {
	/** Array to store the Formuli */
	private Formuli formuli[];
	
	/**
	 * Method to initialize Formuli array
	 * @param size Size of array to initialize
	 * @author Caleb Ambrutis
	 */
	public void InitFormuli(
			int size // Size of array
			)
	{
		
		// Creates new Formuli array with specific size
		formuli = new Formuli[size];
		
	}
	
	/**
	 * Method to get Formuli object at index number
	 * @param index The index number of the Array element
	 * @return Formuli object at index number
	 * @author Caleb Ambrutis
	 */
	public Formuli GetFormuli(
			int index // Index number of Array element
			)
	{
		
		// Return Formuli object at index number
		return formuli[index];
		
	}
}
