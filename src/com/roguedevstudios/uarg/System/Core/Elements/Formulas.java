package com.roguedevstudios.uarg.System.Core.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormula;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormulas;

/**
 * This is the Formulas class, this class creates a formula set map to track formula relationships,
 * and a formula map to hold formula objects. 
 * 
 * @author Tristan Falcon
 * 
 * @since 1.0
 */
public class Formulas implements IFormulas{
	
	/* Tree map fields used for Formulas objects */ 
	private HashMap<String, List<String>> _formulaSetMap;
	private HashMap<String, IFormula> _formulaMap;
	
	/* Temporary tree maps used to initialize empty Formulas objects */
	HashMap<String, IFormula> formulaMap;
	HashMap<String, List<String>> formulaSetMap;

	/**
	 * This is the set constructor used to create an empty formulas object
	 * 
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public Formulas() 
	{
		
		formulaMap = new HashMap<String, IFormula>();
		formulaSetMap = new HashMap<String, List<String>>();
		
		this._build(formulaMap, formulaSetMap);
		
	}
	
	/**
	 * This is the set constructor used to create a formulas object from a given formula map and formula set map
	 * 
	 * @param formulaMap
	 * @param FormulaSetMap
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public Formulas( HashMap<String, IFormula> formulaMap, 
							HashMap<String, List<String>> formulaSetMap )
	{
		
		this._build(formulaMap, formulaSetMap);
		
	}
	
	/**
	 * This is the set constructor used to create a formulas object from a given formulas object
	 * 
	 * @param set
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public Formulas(Formulas set) {
		
		formulaMap = this._formulaMap;
		formulaSetMap = this._formulaSetMap;
		
		this._build(formulaMap, formulaSetMap);
		
	}
	
	/**
	 * Initialize Tree Maps used as containers for formula maps and formula set maps 
	 * 
	 * @param formulaMap
	 * @param formulaSetMap
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	private void _build(HashMap<String, IFormula> formulaMap, 
						HashMap<String, List<String>> formulaSetMap) 
						{
		
		this._formulaMap = formulaMap;
		this._formulaSetMap = formulaSetMap;
		
	}

	/**
	 * Returns the list of formula ids from a given formula set id
	 * 
	 * @param setID
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public List<String> GetFormulaSet(String setID) 
	{
		
		return this._formulaSetMap.get(setID);
		
	}

	/**
	 * Initialize an empty set in formula set map with the given set id
	 * 
	 * @param setID
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public void SetFormulaSet(String setID) {
		
		if(this._formulaSetMap.containsKey(setID))
			return;
		this._formulaSetMap.put(setID, new ArrayList<String>());

	}

	/**
	 * Returns an IFormula object from the given formula id
	 * 
	 * @param formulaID
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public IFormula GetFormula(String formulaID) 
	{
		
		return this._formulaMap.get(formulaID);
		
	}

	/**
	 * Adds a new formula to the formula map witht the given formula id and formula object
	 * 
	 * @param formulaID
	 * @param formula
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public void AddFormula(String formulaID, IFormula formula) 
	{
		
		if(this._formulaMap.containsKey(formulaID))
			return;
		this._formulaMap.put(formulaID, formula);
		
	}
}	

