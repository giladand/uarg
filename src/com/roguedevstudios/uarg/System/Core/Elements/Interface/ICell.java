package com.roguedevstudios.uarg.System.Core.Elements.Interface;
/********************************
*   ICell Interface		    *
*   File Name: ICell.java   *
*                               *
*   Inversion of Control		*
*   for Cell		 		*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

/**
 * 
 * Interface representing Cell requirements
 * 
 * @author Christopher E. Howard
 * @author Terry Roberson
 * @since 1.0
 */
public interface ICell<V>
{
	
	/**
	 * 
	 * Gets the name of this Cell
	 * 
	 * @return Name
	 * @since 1.0
	 */
	String GetName();
	
	/**
	 * 
	 * Gets the description of this Cell
	 * 
	 * @return Description
	 * @since 1.0
	 */
	String GetDescription();
	
	/**
	 * 
	 * Gets the ID of this Cell
	 * 
	 * @return ID
	 * @since 1.0
	 */
	String GetId();
	
	/**
	 * 
	 * Gets the value of this Cell
	 * 
	 * @return Value
	 * @since 1.0
	 */
	V GetValue();
	
	/**
	 * 
	 * Checks if Cell is independent
	 * 
	 * @return RequiresInput
	 * @since 1.0
	 */
	Boolean IsRequiredInput();
	
	/**
	 * 
	 * Sets the description of this Cell
	 * 
	 * @param description Description of this Cell
	 * @since 1.0
	 */
	void SetDescription( String description );
	
	/**
	 * 
	 * Sets the ID of the Cell
	 * 
	 * @param id String id of this Cell
	 * @since 1.0
	 */
	void SetId( String id );
	
	/**
	 * 
	 * Sets the name of this Cell
	 * 
	 * @param name String name of this Cell
	 * @since 1.0
	 */
	void SetName( String name );
	
	/**
	 * 
	 * Sets whether the Cell is independent
	 * 
	 * @param requiresInput boolean dependency check of this Cell
	 * @since 1.0
	 */
	void SetRequiresInput( Boolean required );
	
	/**
	 * 
	 * Sets the value of this Cell
	 * 
	 * @param value Value of this Cell
	 * @since 1.0
	 */
	void SetValue( V value );
}
