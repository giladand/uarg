//TODO: Cleanup #2
package com.roguedevstudios.uarg.System.Core.Elements.Interface;
/********************************
*   ICells Interface        *
*   File Name: ICells.java  *
*                               *
*   Inversion of Control for 	*
*   Cells.java				*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

import java.util.List;

import com.roguedevstudios.uarg.System.Core.Enum.CellType;
//import section 

/**
 * Interface representing Variable container requirements
 * @author Christopher E. Howard
 * @author Terry Roberson
 * @since 1.0
 */
public interface ICells {
	
	/**
	 * Gets the id for _booleanMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	ICell<Boolean> GetBoolean(String key);
	
	/**
	 * 
	 * Gets the id for _booleanArrayMap
	 * @param id	the id associated with the map       
	 * @return id
	 * @since 1.0
	 */
	ICell<Boolean[]> GetBooleanArray(String key);
	
	/**
	 * Gets the id for _doubleMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	ICell<Double> GetDouble(String key);
	
	/**
	 * Gets the id for _doubleArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	ICell<Double[]> GetDoubleArray(String key);
	
	/**
	 * Gets the id for _floatMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	ICell<Float> GetFloat(String key);
	
	/**
	 * Gets the id for _floatArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	ICell<Float[]> GetFloatArray(String key);
	
	/**
	 * Gets the id for _integerMap
	 * @param id	 the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	ICell<Integer> GetInteger(String key);
	
	/**
	 * Gets the id for _integerArrayMap
	 * @param id	 the id associated with the map
	 * @since 1.0
	 */
	ICell<Integer[]> GetIntegerArray(String key);
	
	/**
	 * Gets the id for _longMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	ICell<Long> GetLong(String key);
	
	/**
	 * Gets the id for _longArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	ICell<Long[]> GetLongArray(String key);
	
	/**
	 * Gets the id for _stringMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	ICell<String> GetString(String key);
	
	/**
	 * Gets the id for _stringArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	ICell<String[]> GetStringArray(String key);
	
	/**
	 * Determines the value type for a Variable
	 * @param id
	 * @param variable
	 * @param Type
	 */
	void SetVariable(String key, ICell<?> variable, CellType Type);
	
	/**
	 * updates the value of a boolean variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Boolean value);
	
	/**
	 * updates the value of a boolean variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Boolean[] value);
	
	/**
	 * updates the value of a double variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Double value);
	
	/**
	 * updates the value of a double variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Double[] value);
	
	/**
	 * updates the value of a Float variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Float value);
	
	/**
	 * updates the value of a float variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Float[] value);
	
	/**
	 * updates the value of an integer variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Integer value);
	
	/**
	 * updates the value of an integer variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Integer[] value);
	
	/**
	 * updates the value of a long variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Long value);
	
	/**
	 * updates the value of a long variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, Long[] value);
	
	/**
	 * updates the value of a String variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, String value);
	
	/**
	 * updates the value of a String array variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	void UpdateValue(String key, String[] value);
	
	CellType GetVariableType(String ID);
	int GetIntegerCount();
	ICell<?> GetVariable(String ID);
	List<ICell<?>> GetVariables(List<String> IDSet);
	List<String> GetMasterIDList();
	
}
