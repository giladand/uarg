package com.roguedevstudios.uarg.System.Core.Tests;
import com.roguedevstudios.uarg.System.Core.Elements.Formula;
import com.roguedevstudios.uarg.System.Core.Elements.FormulaSet;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormuli;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

public class FormulaSetTest {
	
	/**
	 * This class will test various methods of the FormulaSet.java file
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	
	//***** Initial Variable Conditions *****\\
	private IFormuli container;
	
	//***** Initial Builders *****\\
	@Before 
	public void Setup() {
		
		// Initialize FormulaSet container
		this.container = new FormulaSet(); 
		
		// Create formula objects to put into formula map
		Formula FormulaA = new Formula("A","A","A","_var1_ * _var2_");
		Formula FormulaB = new Formula("B","B","B","_var1_ / _var2_");
		Formula FormulaC = new Formula("C","C","C","_var1_ * _var2_ + _var3_");
		Formula FormulaD = new Formula("D","D","D","_var1_ * _var2_ / _var3_ + _var4_");
		Formula FormulaE = new Formula("E","E","E","_var1_ * _var2_ - _var3_");
	
		// add formulas into formula map
		this.container.AddFormula("FormulaA", FormulaA);
		this.container.AddFormula("FormulaB", FormulaB);
		this.container.AddFormula("FormulaC", FormulaC);
		this.container.AddFormula("FormulaD", FormulaD);
		this.container.AddFormula("FormulaE", FormulaE);	
		
		// add formula sets to the map 
		this.container.SetFormulaSet("FormulaSetX");
		this.container.SetFormulaSet("FormulaSetY");
		this.container.SetFormulaSet("FormulaSetZ");
		
		// add formulas to their formula sets 
		this.container.AddFormulaToSet("FormulaSetX", "FormulaA");
		this.container.AddFormulaToSet("FormulaSetX", "FormulaB");
		this.container.AddFormulaToSet("FormulaSetY", "FormulaC");
		this.container.AddFormulaToSet("FormulaSetY", "FormulaD");
		this.container.AddFormulaToSet("FormulaSetZ", "FormulaE");		
	}
	
	//***** Method Tests *****\\
	
	/**
	 * Test the validity of the maps in the FormulaSet class
	 * Expectation: Success
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */	
	@Test
	public void testFormulaSetMaps() {
		
		// create test formulas to compare to the formulas in the map
		Formula testFormulaA = new Formula("A","A","A","_var1_ * _var2_");
		Formula testFormulaB = new Formula("B","B","B","_var1_ / _var2_");
		Formula testFormulaC = new Formula("C","C","C","_var1_ * _var2_ + _var3_");
		Formula testFormulaD = new Formula("D","D","D","_var1_ * _var2_ / _var3_ + _var4_");
		Formula testFormulaE = new Formula("E","E","E","_var1_ * _var2_ - _var3_");
		
		// create formula sets to compare to formula sets in map
		List<String> testSetX = Arrays.asList(new String[]{"FormulaA", "FormulaB"});
		List<String> testSetY = Arrays.asList(new String[]{"FormulaC", "FormulaD"});
		List<String> testSetZ = Arrays.asList(new String[]{"FormulaE"});
		
		// make sure that test formulas are equal to the formulas stored in the FormulaSet container
		assertTrue(testFormulaA == container.GetFormula("FormulaA"));
		assertTrue(testFormulaB == container.GetFormula("FormulaB"));
		assertTrue(testFormulaC == container.GetFormula("FormulaC"));
		assertTrue(testFormulaD == container.GetFormula("FormulaD"));
		assertTrue(testFormulaE == container.GetFormula("FormulaE"));		
		
		// make sure that test formula sets are equal to the formula sets in the FormulaSet container
		assertTrue(testSetX == container.GetFormulaSet("FormulaSetX"));
		assertTrue(testSetY == container.GetFormulaSet("FormulaSetY"));
		assertTrue(testSetZ == container.GetFormulaSet("FormulaSetZ"));
	}
}
