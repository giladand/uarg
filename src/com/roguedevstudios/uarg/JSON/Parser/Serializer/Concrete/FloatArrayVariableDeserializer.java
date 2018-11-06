package com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete;
/********************************************
*  Float[] Variable Deserializer			*
*   File Name: 								*
*   FloatArrayVariableDeserializer.java 	*
*                            	   	    	*
*   Deserializes JSON						*
*   information and converts				*
*   into Java objects	        			*
*                               			*
*  �2017 Rogue Dev Studios, LLC 			*
*********************************************/

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.*;
import com.roguedevstudios.uarg.System.Core.Elements.Variable;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IVariable;

/**
 * <p>
 * converts Variable.json information into Java Objects
 * <p>
 * 
 * @author Terry Roberson
 * @author Rasu Neupane
 * @since 1.0
 */
public class FloatArrayVariableDeserializer implements JsonDeserializer<IVariable<Float[]>> {

	/**
	 * Deserializes into a Variable<Float> type
	 * from a given JsonElement, Type, and context
	 * @param JsonElement
	 * @param Type
	 * @param JsonDeserializationContext
	 * @return Variable<Float>
	 */
	
	public IVariable<Float[]> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		/*Temp slot for variable name*/
		String _name = null;
		/*Temp slot for variable ID*/
		String _id = null;
		/*Temp slot for variable value*/
		Float[] _value = null;
		/*Temp slot for variable description*/
		String _description = null;
		/*Temp slot for variable format*/
		ArrayList<String> _format = null;
		/*Temp slot for variable requiresInput*/
		boolean _requiresInput = false;
		/*Temp output object holder*/
		IVariable<Float[]> v;
		
		/* Convert JsonElement into JsonObject */
		JsonObject o = json.getAsJsonObject();
		
		//If the object has a name, then we grab it
		if(o.has("Name")) {
			_name = o.get("Name").getAsString();
		}
		
		//If the object has an ID, then we grab it
		if(o.has("ID")) {
			_id = o.get("ID").getAsString();
		}
		
		//If the object has a value, then we grab it
		if(o.has("Value")) {
			//Retrieve value as json array
			JsonArray t = o.get("Value").getAsJsonArray();
			//Array contains values of t size
			_value = new Float[t.size()];
			//Iterate through json array
			Iterator <JsonElement> it = t.iterator();
			//Start at first location in array
			int counter = 0;
			//While there exists more values, loop through
			while(it.hasNext()) {
				_value[counter] = it.next().getAsFloat();
				counter++;
			}
		}
		
		//If the object has a description, then we grab it
		if(o.has("Description")) {
			_description = o.get("Description").getAsString();
		}
		//If the object has a format, then we grab it
				if(o.has("Format")) {
					//Retrieve format as json array
					JsonArray t = o.get("Format").getAsJsonArray();
					//Array contains formats of t size
					_format = new ArrayList<String>(t.size());
					//Iterate through json array
					Iterator <JsonElement> it = t.iterator();
					//Start at first location in array
					int counter = 0;
					//While there exists more formats, loop through
					while(it.hasNext()) {
						_format.add(counter, it.next().getAsString());
						counter++;
					}
				}
		//Build the Variable object to return
		v = new Variable<Float[]>(_name, _id, _requiresInput, _description, _format, _value);
			
		return v;
	}
}
