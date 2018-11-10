package com.roguedevstudios.uarg.System.Core.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormula;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormuli;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;

/**
 * This is the FormulaSet class. This class implements IFormula and is used to track formula sets and formulas. 
 * 
 * @author Tristan Falcon
 * @author Christopher Howard
 * @author Terry Roberson
 * 
 * @since 1.0
 */
public class FormulaSet implements IFormuli {
	
	/* Declare empty tree maps to hold the formulas and formula sets */
	private TreeMap<String, IFormula> _formulaMap;
	private TreeMap<String, List<String>> _formulaSetMap;
	
	/**
	 * Construct initial state for FormulaSet container
	 * 
	 * @author Tristan Falcon
	 * @author Terry Roberson
	 * @author Christopher Howard
	 * 
	 * @since 1.0
	 */
	public FormulaSet() {
		this._build();
	}
	
	/**
	 * Construct FormulaSet container with formula and formula set maps
	 * 
	 * @param formulaMap
	 * @param formulaSetMap
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public FormulaSet(TreeMap<String, IFormula> formulaMap, TreeMap<String, List<String>> formulaSetMap) {
		this._formulaMap = formulaMap;
		this._formulaSetMap = formulaSetMap;
	}
	
	/**
	 * Initialize the tree maps that will be used to store formulas and formula sets
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	private void _build() {
		this._formulaMap = new TreeMap<String, IFormula>();
		this._formulaSetMap = new TreeMap<String, List<String>>();
	}
	
	/**
	 * IFormuli method used to return the formulas in a given set
	 * 
	 * @param ID
	 * @return List<String>
	 * 
	 * @author Tristan Falcon
	 * @author Christopher Howard
	 * 
	 * @sinc 1.0
	 */
	public List<String> GetFormulaSet(String ID) {
		return this._formulaSetMap.get(ID);
	}
	
	
	/**
	 * IFormuli method used to add a formula set to FormulaSetMap 
	 * 
	 * @param ID
	 * 
	 * @author Tristan Falcon
	 * @author Christopher Howard
	 * 
	 * @since 1.0
	 */
	public void SetFormulaSet(String ID) {
		if(this._formulaSetMap.containsKey(ID))
			return;
		this._formulaSetMap.put(ID, new ArrayList<String>());		
	}
	
	/**
	 * IFormuli method used to return the IFormula object from a given formula id
	 * 
	 * @param ID
	 * @return IFormula
	 * 
	 * @author Tristan Falcon
	 * @author Christopher Howard
	 * 
	 * @since 1.0
	 */
	public IFormula GetFormula(String ID) {
		return this._formulaMap.get(ID);
	}
	
	/**
	 * IFormuli Method used to add a formula to a formula set
	 * 
	 * @param SetID
	 * @param FormulaID
	 * 
	 * @author Tristan Falcon
	 * @author Christopher Howard
	 * 
	 * @since 1.0
	 */
	public void AddFormulaToSet(String SetID, String FormulaID) {
		if(!this._formulaSetMap.containsKey(SetID))
			this.SetFormulaSet(SetID);
		if(this._formulaSetMap.get(SetID).contains(FormulaID))
			return;
		this._formulaSetMap.get(SetID).add(FormulaID);
		
	}
	
	/**
	 * IFormuli interface method used to add a Formula to the formulaMap
	 * 
	 * @param ID
	 * @param formula
	 * 
	 * @author Tristan Falcon
	 * @author Christopher Howard
	 * 
	 * @since 1.0
	 */
	public void AddFormula(String ID, IFormula formula) {
		if(this._formulaMap.containsKey(ID))
			return;
		this._formulaMap.put(ID, formula);
	}
	
	/**
	 * This is the method used to calculate the value of the formula chain 
	 * 
	 * @param ID
	 * @param formula
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public Double GetSetValue(String setID) {
		// Declare variables needed to calculate the set value
		List<String> formulas;
		String formulaID;
		IFormula formula;
		Double value;
	
		// set formulas to the the formula id's  
		formulas = GetFormulaSet(setID);
		// set formulaID to the first formula id in the set
		formulaID = formulas.get(0);
		// set formula to the formula object 
		formula = GetFormula(formulaID);
		// var initialized as a place holder until proper implementation is developed
		IVariable<? extends Number>[] vars = null;
		// set the value by calculating the formula
		value = formula.CalculateToDouble(vars );
		
		return value;
	}

}
