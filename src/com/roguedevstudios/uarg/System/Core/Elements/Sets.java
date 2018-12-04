package com.roguedevstudios.uarg.System.Core.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.TreeMap;

import com.roguedevstudios.uarg.System.Core.Elements.Interface.ISets;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;


/**
 * This is the Sets class. This class implements ISets and models the sets of rows,
 * containing formulas and their respective variables, 
 * and also the sets of columns containing formula sets and their respective formulas. 
 * 
 * Extended Variable and the Interface as well as making Set a generic type of V
 * 
 * @author Tristan Falcon
 * @author John Mai
 * 
 * @since 1.0
 */
public class Sets<V> 
		extends Variable<V> 
			implements ISets<V>, IVariable<V>{
	
	Set<Sets<V>> _set;
	
	/**
	 * This is the set constructor used to create a set with a value argument
	 * 
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * @param value
	 * 
	 * @author Tristan Falcon
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public Sets(
			String name, 
			String id, 
			Boolean requiresInput, 
			String description, 
			V value,
			Set<String> set) {
		super(
				name, 
				id, 
				requiresInput, 
				description, 
				value);
		this._buildSet();
	}

	/**
	 * This is the set constructor used create a set with no value argument 
	 * 
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * 
	 * @author Tristan Falcon
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public Sets(
			String name, 
			String id, 
			Boolean requiresInput, 
			String description,
			Set<String> set) {
		super(
				name, 
				id, 
				requiresInput, 
				description, 
				null);
		this._buildSet();
	}
	
	/**
	 * Initialize empty hash set for object 
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	private void _buildSet() {
		this._set = new HashSet<>();	
	}
	
	/**
	 * Add a set to a sets object 
	 * 
	 * @param sets
	 * 
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	
	public void addSets(Sets<V> set) {
		this._set.add(set);
	}
	
	/**
	 * @return the _set
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public Set<Sets<V>> get_set() {
		return this._set;
	}

	/**
	 * @param _set the _set to set
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public void set_set(Set<Sets<V>> _set) {
		this._set = _set;
	}

	/**
	 * 
	 * @return Set<Sets>
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public Set<Sets<V>> getSet() {
		return this._set;
	}
	
	/**
	 * ISet method used to get final value of a set
	 * 
	 * @param setID
	 * @return Double
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public Double getSetValue() {
		return null;
	}

}