package com.roguedevstudios.uarg.System.Core.Elements;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.TreeMap;

import com.roguedevstudios.uarg.System.Core.Elements.Interface.ISets;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;


/**
 * This is the FormulaSet class. This class implements ISet and models the sets of rows,
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
	
	/**
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * @param value
	 * @author John Mai
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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * @author John Mai
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
		// TODO Auto-generated constructor stub
	}

	/* Declare empty hash maps to hold the row and column sets */
	private HashMap<String, List<String>> _setMap;
	
	/**
	 * Construct initial state for setMap container
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public Sets() {
		this._buildMap();
	}
	
	/**
	 * Construct setMap container with the given setMap
	 * 
	 * @param setMap
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public Sets(HashMap<String, List<String>> setMap) {
		this._setMap = setMap;
	}
	
	/**
	 * Initialize the hash map that will be used to store row and column sets
	 * 
	 * @author Tristan Falcon
	 * @author John Mai changing build to buildMap since there's already a build in Variable
	 * @return 
	 * @since 1.0
	 */
	private HashMap<String, List<String>> _buildMap() {
		return this._setMap = new HashMap<String, List<String>>();
	}
	
	/**
	 * ISet method used to add a new set to the map
	 * 
	 * @param setID
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public void AddSet(String setID) {
		if(this._setMap.containsKey(setID))
			return;
		this._setMap.put(setID, new ArrayList<String>());
	}
	
	/**
	 * ISet method used to add a new argument to a set
	 * 
	 * @param setID
	 * @param argsID
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public void AddArgsToSet(String setID, String argsID) {
		if(!this._setMap.containsKey(setID))
			this.AddSet(setID);
		if(this._setMap.get(setID).contains(argsID))
			return;
		this._setMap.get(setID).add(argsID);		
	}
	
	/**
	 * ISet method used to return the set of arguments for a set
	 * 
	 * @param setID
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public List<String> GetSet(String setID){
		return this._setMap.get(setID);
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
