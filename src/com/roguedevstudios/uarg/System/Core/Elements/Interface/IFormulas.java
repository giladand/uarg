package com.roguedevstudios.uarg.System.Core.Elements.Interface;

import java.util.List;

public interface IFormulas {
	
	/* returns the formula id's of a formula set */
	List<String> GetFormulaSet(String setID);
	
	/* initialized a new set of formula id's in a formula set */
	void SetFormulaSet(String setID);
	
	/* returns the formula object from a given formula id */
	IFormula GetFormula(String formulaID);
	
	/* adds a formula object to a formula map */ 
	void AddFormula(String formulaID, IFormula formula);
}
