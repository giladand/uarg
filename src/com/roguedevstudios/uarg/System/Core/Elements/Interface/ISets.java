package com.roguedevstudios.uarg.System.Core.Elements.Interface;

import java.util.List;

/********************************
*   ISet Interface		    *
*   File Name: ISet.java   *
*                               *
*   Inversion of Control		*
*   for Set		 		*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

/**
 * Interface representing requirements for Set class
 * 
 * @author John Mai
 * @since 1.0
 */
public interface ISets {

	void AddSet(String setID);
	void AddArgsToSet(String setID, String argsID);
	List<String> GetSet(String setID);
	Double GetSetValue(String setID);
	
}
