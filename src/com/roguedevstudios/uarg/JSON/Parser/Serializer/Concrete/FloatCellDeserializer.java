package com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete;
/****************************************
*  Float Cell Deserializer			*
*   File Name: 							*
*   FloatCellDeserializer.java 	*
*                            	   	    *
*   Deserializes JSON					*
*   information and converts			*
*   into Java objects	        		*
*                               		*
*  ©2017 Rogue Dev Studios, LLC 		*
*****************************************/

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.*;
import com.roguedevstudios.uarg.System.Core.Elements.Cell;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICell;

/**
 * 
 * Adapter class to Deserialize Cell objects of subtype Float
 * 
 * @author Terry Roberson
 * @author Christopher E. Howard
 * @author Rasu Neupane
 * @since 1.0
 */
public class FloatCellDeserializer 
	   implements JsonDeserializer<ICell<Float>> 
{

	/**
	 * Deserializes into a Cell<Float> type
	 * from a given JsonElement, Type, and context
	 * @param JsonElement
	 * @param Type
	 * @param JsonDeserializationContext
	 * @return Cell<Float>
	 */
	public ICell<Float> deserialize(
										JsonElement json, 
										Type typeOfT, 
										JsonDeserializationContext context
									  )
									  throws JsonParseException 
	{
		
		/*Temp slot for Cell name*/
		String _name = null;
		
		/*Temp slot for Cell ID*/
		String _id = null;
		
		/*Temp slot for Cell value*/
		Float _value = null;
		
		/*Temp slot for Cell description*/
		String _description = null;
		
		/*Temp slot for Cell format*/
		ArrayList<String> _format = null;
		
		/*Temp slot for Cell requiresInput*/
		boolean _requiresInput = false;
		
		/*Temp output object holder*/
		ICell<Float> v;
		
		// Convert JsonElement into JsonObject
		JsonObject o = json.getAsJsonObject();
		
		//If the object has a name, then we grab it
		if(o.has("Name")) {
			_name = o.get("Name").getAsString();
		}
		
		// If the object has an ID, then we grab it
		if( o.has("ID") ) 
			_id = o.get("ID").getAsString();
		
		//If the object has a value, then we grab it
		if(o.has("Value")) {
			_value = o.get("Value").getAsFloat();
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
		
		// Build the Cell object to return
		v = new Cell<Float>(  _name,
								  _id, 
								  _requiresInput, 
								  _description,
								  _format,
								  _value 
							   );

		// Return the constructed Cell object	
		return v;
	}
}