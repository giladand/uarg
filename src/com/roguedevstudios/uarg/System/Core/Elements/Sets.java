package com.roguedevstudios.uarg.System.Core.Elements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.TreeMap;

import com.roguedevstudios.uarg.System.Core.Elements.Interface.ISets;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariables;

/**
 * This is the Sets class. This class implements ISets and models the sets of rows,
 * containing formulas and their respective variables, 
 * and also the sets of columns containing formula sets and their respective formulas. 
 * 
 * Sets extendeds Variable, implements IVariable as well as making Set a generic type of V
 * 
 * @author Tristan Falcon
 * @author John Mai
 * 
 * @since 1.0
 */
public class Sets<V> 
		extends Variable<V> 
			implements ISets<V>, IVariable<V>{
	
	public Set<Sets<V>> _set;
	
	/**
	 * This is the set constructor used to create a Sets object with a value, and a Sets reference
	 * 
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * @param value
	 * 
	 * @author Tristan Falcon
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public Sets(
			String name, 
			String id, 
			Boolean requiresInput, 
			String description, 
			V value) {
		super(
				name, 
				id, 
				requiresInput, 
				description, 
				value);
		this._buildSet();
	}

	/**
	 * This is the set constructor used create a Set object with no value, and not Sets reference 
	 * 
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * 
	 * @author Tristan Falcon
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public Sets(
			String name, 
			String id, 
			Boolean requiresInput, 
			String description) {
		super(
				name, 
				id, 
				requiresInput, 
				description);
		this._buildSet();
	}
	
	/**
	 * This is the set constructor used to create a Sets object with a value, formula reference, and no Sets reference
	 * 
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * @param value
	 * @param formulaID
	 * 
	 * @author Tristan Falcon
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public Sets(
			String name, 
			String id, 
			Boolean requiresInput, 
			String description, 
			V value,
			String formulaID) {
		super(
				name, 
				id, 
				requiresInput, 
				description, 
				value,
				formulaID);
		this._buildSet();
	}
	
	/**
	 * This is the set constructor used create a Set object with no value, a formula reference, and no Sets referene
	 * 
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * @param formulaID
	 * 
	 * @author Tristan Falcon
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public Sets(
			String name, 
			String id, 
			Boolean requiresInput, 
			String description,
			String formulaID) {
		super(
				name, 
				id, 
				requiresInput, 
				description,
				formulaID);
		this._buildSet();
	}
	
	/**
	 * This is the set constructor used to create a Sets object with a value, and Sets reference
	 * 
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * @param value
	 * @param set
	 * 
	 * @author Tristan Falcon
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public Sets(
			String name, 
			String id, 
			Boolean requiresInput, 
			String description, 
			V value,
			Sets<V> set) {
		super(
				name, 
				id, 
				requiresInput, 
				description, 
				value);
		this._buildSet(set);
	}
	
	/**
	 * This is the set constructor used create a Set object with no value, and Sets reference
	 * 
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * @param set
	 * 
	 * @author Tristan Falcon
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public Sets(
			String name, 
			String id, 
			Boolean requiresInput, 
			String description,
			Sets<V> set) {
		super(
				name, 
				id, 
				requiresInput, 
				description);
		this._buildSet(set);
	}
	
	/**
	 * This is the set constructor used to create a Sets object with a value, formula reference, and sets reference
	 * 
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * @param value
	 * @param formulaID
	 * @param set
	 * 
	 * @author Tristan Falcon
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public Sets(
			String name, 
			String id, 
			Boolean requiresInput, 
			String description, 
			V value,
			String formulaID,
			Sets<V> set) {
		super(
				name, 
				id, 
				requiresInput, 
				description, 
				value,
				formulaID);
		this._buildSet(set);
	}
	
	/**
	 * This is the set constructor used to create a Sets object with no value, formula reference, and sets reference
	 * 
	 * @param name
	 * @param id
	 * @param requiresInput
	 * @param description
	 * @param value
	 * @param formulaID
	 * @param set
	 * 
	 * @author Tristan Falcon
	 * @author John Mai
	 * 
	 * @since 1.0
	 */
	public Sets(
			String name, 
			String id, 
			Boolean requiresInput, 
			String description, 
			String formulaID,
			Sets<V> set) {
		super(
				name, 
				id, 
				requiresInput, 
				description, 
				formulaID);
		this._buildSet(set);
	}
	
	/**
	 * Over write to string method to display the meta-data of a Sets object
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	@Override
	public String toString() {
		String _name = this.GetName();
		String _id = this.GetId();
		Boolean _requiresInput = this.IsRequiredInput();
		String _description = this.GetDescription();
		
		String val;
		if(this.GetValue().getClass().isArray()) {
			val = "( Array of "+ this.GetValue().getClass().getComponentType()+" )[ ";
			int i = 0;
			if(((Object[])this.GetValue()).length>0) {
			for(Object o : (Object[])this.GetValue()){
				if(o == null)
					break;
				val = val + o.toString();
				i++;
				if(i != ((Object[])this.GetValue()).length)
					val = val + ", ";
			}
			}
			val = val + " ]";
		}else {
			val = this.GetValue().toString();
		}
		
		return "name= " + _name +
				", id= " + _id + 
				", value= " + val + 
				", requires input= " + _requiresInput +
				", description= " + _description +
				", set= " + _set;
	}
	
	/**
	 * Initialize empty hash set for object 
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	private void _buildSet() {
		this._set = new HashSet<>();	
	}
	
	/**
	 * Initialize hash set from passed set 
	 * 
	 * @param set
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	private void _buildSet(Sets<V> set) {
		this._set = new HashSet<>();
		
		this.addSets(set);
	}
	
	/**
	 * Add a set to a sets object 
	 * 
	 * @param sets
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public void addSets(Sets<V> set) {
		this._set.add(set);
	}
	
	/**
	 * Gets the set of a sets object
	 * 
	 * @return Set<Sets>
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public Set<Sets<V>> getSet() {
		return this._set;
	}
	
	/**
	 * Changes the set of a sets object
	 * 
	 * @param set
	 * 
	 * @author Tristan Falcon
	 * 
	 * @since 1.0
	 */
	public void setSets(Set<Sets<V>> set) {
		this._set = set;
	}
}