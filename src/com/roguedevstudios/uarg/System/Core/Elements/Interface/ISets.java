package com.roguedevstudios.uarg.System.Core.Elements.Interface;

import java.util.Set;

import com.roguedevstudios.uarg.System.Core.Elements.Sets;

/********************************
*   ISet Interface		    	*
*   File Name: ISet.java   		*
*                               *
*   Inversion of Control		*
*   for Set		 				*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

/**
 * Interface representing requirements for Set class
 * 
 * @author John Mai
 * @param <V>
 * @since 1.0
 */
public interface ISets<V> {

	void addSets(Sets<V> set);
	Set<Sets<V>> getSet();
	Double getSetValue();
}
