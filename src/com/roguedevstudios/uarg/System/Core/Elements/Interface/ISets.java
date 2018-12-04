package com.roguedevstudios.uarg.System.Core.Elements.Interface;

import java.util.List;
import java.util.Set;

import com.roguedevstudios.uarg.System.Core.Elements.Sets;

/********************************
*   ISet Interface		    *
*   File Name: ISet.java   *
*                               *
*   Inversion of Control		*
*   for Set		 		*
*                               *
*  �2017 Rogue Dev Studios, LLC *
********************************/

/**
 * Interface representing requirements for Set class
 * 
 * @author John Mai
 * @since 1.0
 */
public interface ISets {
	void addSet(Sets set);
	Set<Sets> getSet();
	Double getSetValue();
}
