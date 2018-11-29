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
			implements ISets, IVariable<V>{
	
	Set<String> _set;
	List<String> _args;
	
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
			V value) {
		super(
				name, 
				id, 
				requiresInput, 
				description, 
				value);
		this._buildSet(_args);
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
			String description) {
		super(
				name, 
				id, 
				requiresInput, 
				description, 
				null);
		this._buildSet(_args);
	}
	
	/**
	 * Construct initial hash set for the each set object
	 * 
	 * @param args
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	private void _buildSet(List<String> args) {
		this._set = new HashSet<String>();
		
		for(String arg : args) {
			this._set.add(arg);
		}
	}
	
	public void unionSets(HashSet<String> firstSet, HashSet<String> secondSet) {
		
	}
	
	/**
	 * Method used to return the set of arguments for a set
	 * 
	 * @param setID
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public List<String> getSet(HashSet<String> set) {
		Iterator<String> iterator = set.iterator();
		List<String> args = null;
		
		while(iterator.hasNext()) {
			args.add(iterator.next());
		}
		
		return args;		
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
	public Double GetSetValue(String setID) {
		return null;
	}

}
