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
*  ©2017 Rogue Dev Studios, LLC *
********************************/

/**
 * Interface representing requirements for Set class
 * 
 * 
 * @author John Mai
 * @author Tristan Falcon
 * 
 * @param <V>
 * 
 * @since 1.0
 */

public interface ISets<V> {
	/* add a Sets object to a set of a Sets object */
	void addSets(Sets<V> set);
	
	/* get the set of a Sets object */ 
	Set<Sets<V>> getSet();
	
	/* set the set field of Sets object */
	void setSets(Set<Sets<V>> set);
}
