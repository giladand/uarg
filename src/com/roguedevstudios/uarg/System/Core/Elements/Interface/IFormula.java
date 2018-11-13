package com.roguedevstudios.uarg.System.Core.Elements.Interface;
/********************************
*   Formula Interface		    *
*   File Name: IFormula.java    *
*                               *
*   Inversion of Control		*
*   for Formula 		 		*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/
import java.util.ArrayList;
/**
 * Interface representing requirements for the Formula class
 * @author Chelsea Hunter
 * @author Christopher E. Howard
 * @author Gabriel Rosales
 *
 */

public interface IFormula {
	/**
	 * Takes in an array of Number based Cells and
	 * processes them through this formula returning an
	 * Integer representation of the resulting answer.
	 * @param vars	An array of Variable objects.
	 * @return
	 */
	Integer CalculateToInteger(ICell<? extends Number>[] vars);
	Integer[] CalculateToInteger(ICell<?>[] vars, boolean ArrayPresent);
	/**
	 * Takes in an array of Number based Cells and
	 * processes them through this formula returning a
	 * Double representation of the resulting answer.
	 * @param vars	An array of Variable objects.
	 * @return
	 */
	Double CalculateToDouble(ICell<? extends Number>[] vars);
	Double[] CalculateToDouble(ICell<?>[] vars, boolean ArrayPresent);
	/**
	 * Takes in an array of Number based Cells and
	 * processes them through this formula returning a
	 * Float representation of the resulting answer.
	 * @param vars	An array of Variable objects.
	 * @return
	 */
	Float CalculateToFloat(ICell<? extends Number>[] vars);
	Float[] CalculateToFloat(ICell<?>[] vars, boolean ArrayPresent);
	/**
	 * Takes in an array of Number based Cells and
	 * processes them through this formula returning a
	 * Long representation of the resulting answer.
	 * @param vars	An array of Variable objects.
	 * @return
	 */
	Long CalculateToLong(ICell<? extends Number>[] vars);
	Long[] CalculateToLong(ICell<?>[] vars, boolean ArrayPresent);
	/**
	 * Gets the array size expected when passing arguments
	 * to be processed by this formula.
	 * @return The input array size.
	 */
	Integer GetFormulaInputArraySize();
	/**
	 * Gets the variable names used in the Formula Expression object.
	 * @return An ArrayList<String> of variable names.
	 */
	ArrayList<String> GetFormulaExpressionVariableNames();
	/**
	 * Gets name of this Formula
	 * @return The formula name (String).
	 * @since 1.0
	 */
	String GetFormulaName();
	/**
	 * Gets the name of this Formula
	 * @return The formula description (String).
	 * @since 1.0
	 */
	String GetFormulaDesc();
	/**
	 * Gets the description of this Formula
	 * @return The formula ID (String).
	 * @since 1.0
	 */
	String GetFormulaId();
	/**
	 * Gets the equation string for this formula.
	 * @return The formula equation (String).
	 * @since 1.0
	 */
	String GetFormulaEquation();
}