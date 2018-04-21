// TODO change package when framework layout chosen
package com.roguedevstudios.uarg.System.Core.Elements;
// TODO will need to include import once framework package chosen
// import com.roguedevstudios.uarg.System.Core.Elements;

// TODO update details of package
/*****************************************
 * 	InterfaceObjects Class               *
 * 	File Name: InterfaceObjectsTest.java *
 * 						                 *
 * 	Used by Framework to create          *
 *  interface objects from Core          *
 *							         	 *
 *							         	 *
 * 	©2018 Rouge Dev Studios, LLC         *
 *****************************************/

import java.util.List;

// TODO complete JavaDoc for class and all methods within class

// TODO formalize class name
/**
 * This class create interface objects.
 * @author Caleb Ambrutis
 * @since 2.0
 *
 */
public class InterfaceObjectsTest {
	
	
	/**
	 * Creates new CascadeEntry interface object
	 * @param InputIdList List of input ID's for vector
	 * @param OutputId Output ID for vector
	 * @param FormulaId Formula ID for vector
	 * @param Description Description for vector
	 * @return CascadeEntry object
	 */
	public static CascadeEntry CreateCascadeEntry(
			List<String> InputIdList, 
			String OutputId, 
			String FormulaId, 
			String Description)
	{
		return new CascadeEntry(InputIdList, OutputId, FormulaId, Description);
	}
	
	/**
	 * Creates new CascadeMap interface object
	 * @return CascadeMap object
	 */
	public static CascadeMap CreateCascadeMap()
	{
		return new CascadeMap();
	}
	
	/**
	 * Creates new Formula interface object
	 * @param FormulaName
	 * @param FormulaDescription
	 * @param FormulaId
	 * @param FormulaEquation
	 * @return Formula object
	 */
	public static Formula CreateFormula(
			String FormulaName,
			String FormulaDescription,
			String FormulaId,
			String FormulaEquation)
	{
		return new Formula(FormulaName, FormulaDescription, FormulaId, FormulaEquation);
	}
	
	/**
	 * Creates new FormulaSet interface object
	 * @param FormulaSetName
	 * @param FormulaSetDescription
	 * @return
	 */
	public static FormulaSet CreateFormulaSet(
			String FormulaSetName,
			String FormulaSetDescription)
	{
		return new FormulaSet(FormulaSetName, FormulaSetDescription);
	}
	
	/**
	 * Creates new Formuli interface object
	 * @return
	 */
	public static Formuli CreateFormuli()
	{
		return new Formuli();
	}
	
	/**
	 * Creates new Meta object
	 * @param Name
	 * @param FormId
	 * @param Version
	 * @param Description
	 * @param Author
	 * @param DateCrt
	 * @param DateEd
	 * @return
	 */
	public static Meta CreateMeta(
			String Name,
			String FormId,
			String Version,
			String Description,
			String Author,
			String DateCrt,
			String DateEd)
	{
		return new Meta(Name, FormId, Version, Description, Author, DateCrt, DateEd);
	}
	
	/**
	 * 
	 * @param PageId
	 * @param Description
	 * @param Variableid
	 * @param Icon
	 * @param Template
	 * @param Colors
	 * @param Logo
	 * @return
	 */
	public static Page CreatePage(
			String PageId,
			String Description,
			String Variableid,
			String Icon,
			String Template,
			Integer Colors,
			String Logo
			)
	{
		return new Page(PageId, Description, Variableid, Icon, Template, Colors, Logo);
	}
	
	public static <V> Variable<V> CreateVariable(
			String Name,
			String Id,
			Boolean RequiresInput,
			String Description)
	{
		return new Variable<>(Name, Id, RequiresInput, Description);
	}
	
	public static <V> Variable<V> CreateVariable(
			String Name,
			String Id,
			Boolean RequiresInput,
			String Description,
			V Value)
	{
		return new Variable<>(Name, Id, RequiresInput, Description, Value);
	}

}
