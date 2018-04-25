package com.roguedevstudios.uarg.System.Framework.Elements;

import com.roguedevstudios.uarg.System.Core.Elements.Meta;

/**
 * Create and store Meta interface objects
 * @author Caleb Ambrutis
 *
 */
public class FMeta {
	/** Array to store the Meta */
	private Meta meta[];
	
	/**
	 * Method to initialize Meta array
	 * @param size Size of array to initialize
	 * @author Caleb Ambrutis
	 */
	public void InitMeta(
			int size // Size of array
			)
	{
		
		// Creates new Meta array with specific size
		meta = new Meta[size];
		
	}
	
	/**
	 * Method to get Meta object at index number
	 * @param index The index number of the Array element
	 * @return Meta object at index number
	 * @author Caleb Ambrutis
	 */
	public Meta GetMeta(
			int index // Index number of Array element
			)
	{
		
		// Return Meta object at index number
		return meta[index];
		
	}
}
