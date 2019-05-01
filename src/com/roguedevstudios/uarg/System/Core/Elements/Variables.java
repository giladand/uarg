//TODO: Cleanup #2 - After modification merge from @Terry
package com.roguedevstudios.uarg.System.Core.Elements;

import java.util.ArrayList;
import java.util.List;

/********************************
*   Variables Class             *
*   File Name: Variables.java   *
*                               *
*   The container for each 		*
*   Variable created in 		*
*   Variable.java				*
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

//Import Section
import java.util.TreeMap;

import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFact;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariables;
import com.roguedevstudios.uarg.System.Core.Enum.VariableType;

/**
 * <p>
 * This class implements IVariables and constructs variables for the class Variable
 * <p>
 * 
 * @author Grant Richards
 * @author Terry Roberson
 * @since 1.0
 */
public class Variables implements IVariables {

	private TreeMap<String, IFact<Integer>> _integerMap;

	private TreeMap<String, IFact<Integer[]>> _integerArrayMap;

	private TreeMap<String, IFact<String>> _stringMap;

	private TreeMap<String, IFact<String[]>> _stringArrayMap;

	private TreeMap<String, IFact<Float>> _floatMap;

	private TreeMap<String, IFact<Float[]>> _floatArrayMap;

	private TreeMap<String, IFact<Long>> _longMap;

	private TreeMap<String, IFact<Long[]>> _longArrayMap;

	private TreeMap<String, IFact<Double>> _doubleMap;

	private TreeMap<String, IFact<Double[]>> _doubleArrayMap;

	private TreeMap<String, IFact<Boolean>> _booleanMap;

	private TreeMap<String, IFact<Boolean[]>> _booleanArrayMap;
	
	private TreeMap<String, VariableType> _variableTypeMap;

	/**Constructs the initial state of the Variables container
	 *
	 * @since 1.0
	 */

	public Variables() {
		
			this._build();
	}
	
	
	/**
	 * Constructs the Variables container with all Variable Sections
	 * 
	 * @since 1.0
	 */
	public Variables(TreeMap<String, IFact<Integer>> _integerMap, TreeMap<String, IFact<Integer[]>> _integerArrayMap, 
					TreeMap<String, IFact<String>> _stringMap, TreeMap<String, IFact<String[]>> _stringArrayMap, 
					TreeMap<String, IFact<Float>> _floatMap, TreeMap<String, IFact<Float[]>> _floatArrayMap, 
					TreeMap<String, IFact<Long>> _longMap, TreeMap<String, IFact<Long[]>> _longArrayMap, 
					TreeMap<String, IFact<Double>> _doubleMap, TreeMap<String, IFact<Double[]>> _doubleArrayMap, 
					TreeMap<String, IFact<Boolean>> _booleanMap, TreeMap<String, IFact<Boolean[]>> _booleanArrayMap) 
					{
	// For each of the twelve lines below. If a null Variable object is passed, a blank TreeMap is created
					this._integerMap = (_integerMap != null)?_integerMap:new TreeMap<String, IFact<Integer>>();
					this._integerArrayMap = (_integerArrayMap != null)?_integerArrayMap:new TreeMap<String, IFact<Integer[]>>();
					this._stringMap = (_stringMap != null)?_stringMap:new TreeMap<String, IFact<String>>();
					this._stringArrayMap = (_stringArrayMap != null)?_stringArrayMap:new TreeMap<String, IFact<String[]>>();
					this._doubleMap = (_doubleMap != null)?_doubleMap:new TreeMap<String, IFact<Double>>();
					this._doubleArrayMap = (_doubleArrayMap != null)?_doubleArrayMap:new TreeMap<String, IFact<Double[]>>();
					this._longMap = (_longMap != null)?_longMap:new TreeMap<String, IFact<Long>>();
					this._longArrayMap = (_longArrayMap != null)?_longArrayMap:new TreeMap<String, IFact<Long[]>>();
					this._floatMap = (_floatMap != null)?_floatMap:new TreeMap<String, IFact<Float>>();
					this._floatArrayMap = (_floatArrayMap != null)?_floatArrayMap:new TreeMap<String, IFact<Float[]>>();
					this._booleanMap = (_booleanMap != null)?_booleanMap:new TreeMap<String, IFact<Boolean>>();
					this._booleanArrayMap = (_booleanArrayMap != null)?_booleanArrayMap:new TreeMap<String, IFact<Boolean[]>>();
					this._variableTypeMap = new TreeMap<>();
					this._populateTypeMap();
				}
			
/**
 * Initializes the TreeMaps for internal variable storage	
 */
	private void _build() {
		this._integerMap = new TreeMap<String, IFact<Integer>>();
		this._integerArrayMap = new TreeMap<String, IFact<Integer[]>>();
		this._stringMap = new TreeMap<String, IFact<String>>();
		this._stringArrayMap = new TreeMap<String, IFact<String[]>>();
		this._floatMap = new TreeMap<String, IFact<Float>>();
		this._floatArrayMap = new TreeMap<String, IFact<Float[]>>();
		this._longMap = new TreeMap<String, IFact<Long>>();
		this._longArrayMap = new TreeMap<String, IFact<Long[]>>();
		this._doubleMap = new TreeMap<String, IFact<Double>>();
		this._doubleArrayMap = new TreeMap<String, IFact<Double[]>>();
		this._booleanMap = new TreeMap<String, IFact<Boolean>>();
		this._booleanArrayMap = new TreeMap<String, IFact<Boolean[]>>();
		this._variableTypeMap = new TreeMap<>();

	}
	
	/**
	 * Takes pre-built containers from the construction process and registers
	 * them in the type map.
	 * @author Christopher Howard
	 */
	private void _populateTypeMap() {
		for(String key: this._booleanArrayMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.BOOLEANARRAY);
		}
		for(String key: this._booleanMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.BOOLEAN);
		}
		for(String key: this._doubleArrayMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.DOUBLEARRAY);
		}
		for(String key: this._doubleMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.DOUBLE);
		}
		for(String key: this._floatArrayMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.FLOATARRAY);
		}
		for(String key: this._floatMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.FLOAT);
		}
		for(String key: this._integerArrayMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.INTEGERARRAY);
		}
		for(String key: this._integerMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.INTEGER);
		}
		for(String key: this._longArrayMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.LONGARRAY);
		}
		for(String key: this._longMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.LONG);
		}
		for(String key: this._stringArrayMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.STRINGARRAY);
		}
		for(String key: this._stringMap.keySet()) {
			this._variableTypeMap.put(key, VariableType.STRING);
		}
	}

	/**
	 * SetbooleanArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	public void _setBooleanArrayMap(String key, IFact<Boolean[]> variable) {
		this._booleanArrayMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.BOOLEANARRAY);
	}

	/**
	 * SetbooleanMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/
	private void _setBooleanMap(String key, IFact<Boolean> variable) {
		this._booleanMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.BOOLEAN);
	}

	/**
	 * SetdoubleArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setDoubleArrayMap(String key, IFact<Double[]> variable) {
		this._doubleArrayMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.DOUBLEARRAY);
	}

	/**
	 * SetdoubleMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/
	private void _setDoubleMap(String key, IFact<Double> variable) {
		this._doubleMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.DOUBLE);
	}

	/**
	 * SetfloatArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setFloatArrayMap(String key, IFact<Float[]> variable) {
		this._floatArrayMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.FLOATARRAY);
	}

	/**
	 * SetfloatMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setFloatMap(String key, IFact<Float> variable) {
		this._floatMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.FLOAT);
	}

	/**
	 * SetIntegerArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/
	private void _setIntegerArrayMap(String key, IFact<Integer[]> variable) {
		this._integerArrayMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.INTEGERARRAY);
	}

	/**
	 * SetInteger method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setIntegerMap(String key, IFact<Integer> variable) {
		this._integerMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.INTEGER);
	}

	/**
	 * SetlongArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setLongArrayMap(String key, IFact<Long[]> variable) {
		this._longArrayMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.LONGARRAY);
	}

	/**
	 * SetlongMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setLongMap(String key, IFact<Long> variable) {
		this._longMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.LONG);
	}

	/**
	 * SetStringArrayMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setStringArrayMap(String key, IFact<String[]> variable) {
		this._stringArrayMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.STRINGARRAY);
	}

	/**
	 * SetStringMap method
	 * puts the specified variable with its specified key in the map
	 * @since 1.0
	 * 
	 **/

	private void _setStringMap(String key, IFact<String> variable) {
		this._stringMap.put(key, variable);
		this._variableTypeMap.put(key, VariableType.STRING);
	}

	/**
	 * Gets the id for _booleanMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IFact<Boolean> GetBoolean(String id) {
		return this._booleanMap.get(id);
	}

	/**
	 * 
	 * Gets the id for _booleanArrayMap
	 * @param id	the id associated with the map       
	 * @return id
	 * @since 1.0
	 */
	public IFact<Boolean[]> GetBooleanArray(String id) {
		return this._booleanArrayMap.get(id);
	}

	/**
	 * Gets the id for _doubleMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IFact<Double> GetDouble(String id) {
		return this._doubleMap.get(id);
	}

	/**
	 * Gets the id for _doubleArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IFact<Double[]> GetDoubleArray(String id) {
		return this._doubleArrayMap.get(id);
	}

	/**
	 * Gets the id for _floatMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IFact<Float> GetFloat(String id) {
		return this._floatMap.get(id);
	}

	/**
	 * Gets the id for _floatArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IFact<Float[]> GetFloatArray(String id) {
		return this._floatArrayMap.get(id);
	}

	/**
	 * Gets the id for _integerMap
	 * @param id	 the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IFact<Integer> GetInteger(String id) {
		return this._integerMap.get(id);

	}

	/**
	 * Gets the id for _integerArrayMap
	 * @param id	 the id associated with the map
	 * @since 1.0
	 */
	public IFact<Integer[]> GetIntegerArray(String id) {
		return this._integerArrayMap.get(id);
	}

	/**
	 * Gets the id for _longMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IFact<Long> GetLong(String id) {
		return this._longMap.get(id);
	}

	/**
	 * Gets the id for _longArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IFact<Long[]> GetLongArray(String id) {
		return this._longArrayMap.get(id);
	}

	/**
	 * Gets the id for _stringMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IFact<String> GetString(String id) {
		return this._stringMap.get(id);
	}

	/**
	 * Gets the id for _stringArrayMap
	 * @param id	the id associated with the map
	 * @return id
	 * @since 1.0
	 */
	public IFact<String[]> GetStringArray(String id) {
		return this._stringArrayMap.get(id);
	}

	/**
	 * Determines the value type for a Variable
	 * 
	 * @param id
	 * @param variable
	 * @param Type
	 */
	public void SetVariable(String key, IFact<?> variable, VariableType Type) {
		switch (Type) {
		case INTEGER:
			this._setIntegerMap(key, (IFact<Integer>) variable);
			break;
		case INTEGERARRAY:
			this._setIntegerArrayMap(key, (IFact<Integer[]>) variable);
			break;
		case STRING:
			this._setStringMap(key, (IFact<String>) variable);
			break;
		case STRINGARRAY:
			this._setStringArrayMap(key, (IFact<String[]>) variable);
			break;
		case FLOAT:
			this._setFloatMap(key, (IFact<Float>) variable);
			break;
		case FLOATARRAY:
			this._setFloatArrayMap(key, (IFact<Float[]>) variable);
			break;
		case LONG:
			this._setLongMap(key, (IFact<Long>) variable);
			break;
		case LONGARRAY:
			this._setLongArrayMap(key, (IFact<Long[]>) variable);
			break;
		case DOUBLE:
			this._setDoubleMap(key, (IFact<Double>) variable);
			break;
		case DOUBLEARRAY:
			this._setDoubleArrayMap(key, (IFact<Double[]>) variable);
			break;
		case BOOLEAN:
			this._setBooleanMap(key, (IFact<Boolean>) variable);
			break;
		case BOOLEANARRAY:
			this._setBooleanArrayMap(key, (IFact<Boolean[]>) variable);
			break;
		default:
			return;
		}

	}
	
	/**
	 * updates the value of a boolean variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Boolean newValue) {
		this._booleanMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a boolean variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Boolean[] newValue) {
		this._booleanArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a double variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Double newValue) {
		this._doubleMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a double variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Double[] newValue) {
		this._doubleArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a Float variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Float newValue) {
		this._floatMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a float variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Float[] newValue) {
		this._floatArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of an integer variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Integer newValue) {

		this._integerMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of an integer variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Integer[] newValue) {
		this._integerArrayMap.get(key).SetValue(newValue);

	}
	
	/**
	 * updates the value of a long variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Long newValue) {
		this._longMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a long variable array
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, Long[] newValue) {
		this._longArrayMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a String variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, String newValue) {
		this._stringMap.get(key).SetValue(newValue);
	}
	
	/**
	 * updates the value of a String array variable
	 * @param key
	 * @param newValue
	 * @since 1.0
	 */
	public void UpdateValue(String key, String[] newValue) {
		this._stringArrayMap.get(key).SetValue(newValue);
	}


	/**
	 * Gets the registered type for a variable ID
	 * @param ID The variable ID
	 * @return VariableType The Type this Variable is registered under
	 * @author Christopher Howard
	 */
	public VariableType GetVariableType(String ID) {
		if(!this._variableTypeMap.containsKey(ID))
			return VariableType.NULL;
		//System.out.println("VarID: "+ID+", Type: "+this._variableTypeMap.get(ID));
		return this._variableTypeMap.get(ID);
	}
	
	public int GetIntegerCount() {
		return this._integerMap.size();
	}
	
	public IFact<?> GetVariable(String ID){
		switch(this.GetVariableType(ID)) {
		case INTEGER:
			return this.GetInteger(ID);
			
		case FLOAT:
			return this.GetFloat(ID);
			
		case DOUBLE:
			return this.GetDouble(ID);
			
		case LONG:
			return this.GetLong(ID);
			
		case INTEGERARRAY:
			return this.GetIntegerArray(ID);
			
		case FLOATARRAY:
			return this.GetFloatArray(ID);
			
		case DOUBLEARRAY:
			return this.GetDoubleArray(ID);
			
		case LONGARRAY:
			return this.GetLongArray(ID);
			
		default:
			return null;
		}
	}
	
	public List<IFact<?>> GetVariables(List<String> IDSet){
		List<IFact<?>> out = new ArrayList<>();
		for(String ID: IDSet) {
			out.add(this.GetVariable(ID));
		}
		return out;
	}
	
	public List<String> GetMasterIDList(){
		ArrayList<String> out = new ArrayList<String>();
		out.addAll(this._variableTypeMap.keySet());
		return out;
	}
	
}
