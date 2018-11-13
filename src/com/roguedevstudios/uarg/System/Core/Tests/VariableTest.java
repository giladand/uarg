//TODO: Cleanup #2
package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.roguedevstudios.uarg.System.Core.Elements.Cell;

import java.lang.reflect.*;

import java.util.*;

/**
*<p>
*this will test the Variable.java file
*<p>
*
*@author Christopher E. Howard
*@author Terry Roberson
*@author Rasu Neupane
*@since 1.0
*/
public class VariableTest{
	
	//***** INTEGER TESTING SECTION *****\\
	
	 /**
	  * Test creation of Integer Variable
	  * Expectation: Success
	  */
	@Test
	public void createIntegerObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		boolean requiresInput = false;
		Integer value = 10;
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Cell<Integer> testVarNoValue = new Cell<Integer>(name, id, requiresInput, description, format);
				Cell<Integer> testVarWithValue = new Cell<Integer>(name, id, requiresInput, description, format, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
				
				//Test the format is correct
				assertEquals(format, testVarNoValue.GetFormat());
				assertEquals(format, testVarWithValue.GetFormat());
			
				//Test the value set properly or is properly null
				assertEquals(value, testVarWithValue.GetValue());
				assertNull(testVarNoValue.GetValue());
			
		} catch (Exception e) {
			
				// If this tosses an Exception we failed
				assertFalse(true);
				
		}
		
	}
	
	/**
	 * Test re-setting the value of an Integer Variable
	 * Expectation: Success
	 */
	@Test
	public void resetValueOfIntegerObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		boolean requiresInput = false;
		Integer value = 2;
		Integer newValue = 5;
		
		
		//Set up a valid test variable with a value 
		Cell<Integer> testVarValueUpdate = new Cell<Integer>(name, id, requiresInput, description, format, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
		//Test the format is correct
		assertEquals(format, testVarValueUpdate.GetFormat());
		
		//Test the value set properly
		assertEquals(value, testVarValueUpdate.GetValue());
		
		//Test the value updates properly
		testVarValueUpdate.SetValue(newValue); 
		
		//Test the updated value displays properly
		assertEquals(newValue, testVarValueUpdate.GetValue());
		System.out.println(testVarValueUpdate.GetValue());
		
	}
	
	/**
	 * Test nullifying the value of an Integer Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfIntegerObjectVariable() {
		
		//Set value of variable to null
		Integer value = null;
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		Cell<Integer> testNullValue = new Cell<Integer>("TEST", "TEST", false, "TEST", format,value);
		assertNull(testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullIntegerObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		ArrayList<String> format = null;
		boolean requiresInput = false;
		Integer value = null;
		
		
		//Set up a valid test variable with a value 
		Cell<Integer> nullIntegerObjectVariable = new Cell<Integer>(name, id, requiresInput, description, format, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the format is correct
		assertNull(nullIntegerObjectVariable.GetFormat());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoIntegerObjectType() {
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		Cell<Integer> testVarWithPrimitive = new Cell<Integer>("TEST", "TEST", false, "TEST", format, 5);
		assertEquals(5, (int) testVarWithPrimitive.GetValue());
		
	}
	
	//***** STRING TESTING SECTION *****\\
	
	 /**
	  * Test creation of String Variable
	  * Expectation: Success
	  */
	@Test
	public void createStringObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		boolean requiresInput = false;
		String value = "A";
		
		
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Cell<String> testVarNoValue = new Cell<String>(name, id, requiresInput, description, format);
				Cell<String> testVarWithValue = new Cell<String>(name, id, requiresInput, description, format, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
				
				//Test the format is correct
				assertEquals(format, testVarNoValue.GetFormat());
				assertEquals(format, testVarWithValue.GetFormat());
			
				//Test the value set properly or is properly null
				assertEquals(value, testVarWithValue.GetValue());
				assertNull(testVarNoValue.GetValue());
			
		} catch (Exception e) {
			
				// If this tosses an Exception we failed
				assertFalse(true);
				
		}
		
	}
	
	/**
	 * Test re-setting the value of a String Variable
	 * Expectation: Success
	 */
	@Test
	public void resetValueOfStringObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		boolean requiresInput = false;
		String value = "A";
		String newValue = "B";
		
		
		//Set up a valid test variable with a value 
		Cell<String> testVarValueUpdate = new Cell<String>(name, id, requiresInput, description, format, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
		//Test the format is correct
		assertEquals(format, testVarValueUpdate.GetFormat());
		
		//Test the value set properly
		assertEquals(value, testVarValueUpdate.GetValue());
		
		//Test the value updates properly
		testVarValueUpdate.SetValue(newValue); 
		
		//Test the updated value displays properly
		assertEquals(newValue, testVarValueUpdate.GetValue());
		System.out.println(testVarValueUpdate.GetValue());
	}
	
	/**
	 * Test nullifying the value of a String Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfStringObjectVariable() {
		
		//Set value of variable to null
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		String value = null;
		Cell<String> testNullValue = new Cell<String>("TEST", "TEST", false, "TEST", format, value);
		assertNull(testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullStringObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		ArrayList<String> format = null;
		boolean requiresInput = false;
		String value = null;
		
		
		
		//Set up a valid test variable with a value 
		Cell<String> nullIntegerObjectVariable = new Cell<String>(name, id, requiresInput, description, format, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the format is correct
		assertNull(nullIntegerObjectVariable.GetFormat());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoStringObjectType() {
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		Cell<String> testVarWithPrimitive = new Cell<String>("TEST", "TEST", false, "TEST", format, "A");
		assertEquals("A", (String) testVarWithPrimitive.GetValue());
		
	}
	
	//***** DOUBLE TESTING SECTION *****\\
	
	 /**
	  * Test creation of Double Variable
	  * Expectation: Success
	  */
	@Test
	public void createDoubleObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		boolean requiresInput = false;
		Double value = 5.8;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Cell<Double> testVarNoValue = new Cell<Double>(name, id, requiresInput, description, format );
				Cell<Double> testVarWithValue = new Cell<Double>(name, id, requiresInput, description, format, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
				
				//Test the format is correct
				assertEquals(format, testVarNoValue.GetFormat());
				assertEquals(format, testVarWithValue.GetFormat());
			
				//Test the value set properly or is properly null
				assertEquals(value, testVarWithValue.GetValue());
				assertNull(testVarNoValue.GetValue());
			
		} catch (Exception e) {
			
				// If this tosses an Exception we failed
				assertFalse(true);
				
		}
		
	}
	
	/**
	 * Test re-setting the value of a Double Variable
	 * Expectation: Success
	 */
	@Test
	public void resetValueOfDoubleObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		boolean requiresInput = false;
		Double value = 4.3;
		Double newValue = 5.4;
		
		//Set up a valid test variable with a value 
		Cell<Double> testVarValueUpdate = new Cell<Double>(name, id, requiresInput, description, format, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
		//Test the format is correct
		assertEquals(format, testVarValueUpdate.GetFormat());
		
		//Test the value set properly
		assertEquals(value, testVarValueUpdate.GetValue());
		
		//Test the value updates properly
		testVarValueUpdate.SetValue(newValue); 
		
		//Test the updated value displays properly
		assertEquals(newValue, testVarValueUpdate.GetValue());
		System.out.println(testVarValueUpdate.GetValue());
	}
	
	/**
	 * Test nullifying the value of a Double Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfDoubleObjectVariable() {
		
		//Set value of variable to null
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		Double value = null;
		Cell<Double> testNullValue = new Cell<Double>("TEST", "TEST", false, "TEST", format, value);
		assertNull(testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullDoubleObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		ArrayList<String> format = null;
		boolean requiresInput = false;
		Double value = null;
		
		//Set up a valid test variable with a value 
		Cell<Double> nullIntegerObjectVariable = new Cell<Double>(name, id, requiresInput, description, format, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the format is correct
		assertNull(nullIntegerObjectVariable.GetFormat());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoDoubleObjectType() {
		
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		Cell<Double> testVarWithPrimitive = new Cell<Double>("TEST", "TEST", false, "TEST", format, 1e-15);
		assertEquals(1e-15, (double) testVarWithPrimitive.GetValue(), 0);
		
	}
	
	//***** LONG TESTING SECTION *****\\
	
	 /**
	  * Test creation of Long Variable
	  * Expectation: Success
	  */
	@Test
	public void createLongObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		boolean requiresInput = false;
		Long value = 50000000L;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Cell<Long> testVarNoValue = new Cell<Long>(name, id, requiresInput, description, format);
				Cell<Long> testVarWithValue = new Cell<Long>(name, id, requiresInput, description, format, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
				
				//Test the format is correct
				assertEquals(format, testVarNoValue.GetFormat());
				assertEquals(format, testVarWithValue.GetFormat());
			
				//Test the value set properly or is properly null
				assertEquals(value, testVarWithValue.GetValue());
				assertNull(testVarNoValue.GetValue());
			
		} catch (Exception e) {
			
				// If this tosses an Exception we failed
				assertFalse(true);
				
		}
		
	}
	
	/**
	 * Test re-setting the value of a Long Variable
	 * Expectation: Success
	 */
	@Test
	public void resetValueOfLongObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		boolean requiresInput = false;
		Long value = 53L;
		Long newValue = 68L;
		
		//Set up a valid test variable with a value 
		Cell<Long> testVarValueUpdate = new Cell<Long>(name, id, requiresInput, description, format, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
		//Test the format is correct
		assertEquals(format, testVarValueUpdate.GetFormat());
				
		//Test the value set properly
		assertEquals(value, testVarValueUpdate.GetValue());
		
		//Test the value updates properly
		testVarValueUpdate.SetValue(newValue); 
		
		//Test the updated value displays properly
		assertEquals(newValue, testVarValueUpdate.GetValue());
		System.out.println(testVarValueUpdate.GetValue());
	}
	
	/**
	 * Test nullifying the value of a Long Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfLongObjectVariable() {
		
		//Set value of variable to null
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		Long value = null;
		Cell<Long> testNullValue = new Cell<Long>("TEST", "TEST", false, "TEST", format, value);
		assertNull(testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullLongObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		ArrayList<String> format =null;
		boolean requiresInput = false;
		Long value = null;
		
		//Set up a valid test variable with a value 
		Cell<Long> nullIntegerObjectVariable = new Cell<Long>(name, id, requiresInput, description,format, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the format is correct
		assertNull(nullIntegerObjectVariable.GetFormat());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoLongObjectType() {
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		Cell<Long> testVarWithPrimitive = new Cell<Long>("TEST", "TEST", false, "TEST", format, 300L);
		assertEquals(300L, (long) testVarWithPrimitive.GetValue());
		
	}
	
	//***** FLOAT TESTING SECTION *****\\
	
	 /**
	  * Test creation of Float Variable
	  * Expectation: Success
	  */
	@Test
	public void createFloatObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		boolean requiresInput = false;
		Float value = 2.50F;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Cell<Float> testVarNoValue = new Cell<Float>(name, id, requiresInput, description, format);
				Cell<Float> testVarWithValue = new Cell<Float>(name, id, requiresInput, description, format, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
				
				//Test the format is correct
				assertEquals(format, testVarNoValue.GetFormat());
				assertEquals(format, testVarWithValue.GetFormat());
			
				//Test the value set properly or is properly null
				assertEquals(value, testVarWithValue.GetValue());
				assertNull(testVarNoValue.GetValue());
			
		} catch (Exception e) {
			
				// If this tosses an Exception we failed
				assertFalse(true);
				
		}
		
	}
	
	/**
	 * Test re-setting the value of a Float Variable
	 * Expectation: Success
	 */
	@Test
	public void resetValueOfFloatObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		boolean requiresInput = false;
		Float value = 5.3F;
		Float newValue = 6.8F;
		
		//Set up a valid test variable with a value 
		Cell<Float> testVarValueUpdate = new Cell<Float>(name, id, requiresInput, description, format, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
		//Test the format is correct
		assertEquals(format, testVarValueUpdate.GetFormat());
		
		//Test the value set properly
		assertEquals(value, testVarValueUpdate.GetValue());
		
		//Test the value updates properly
		testVarValueUpdate.SetValue(newValue); 
		
		//Test the updated value displays properly
		assertEquals(newValue, testVarValueUpdate.GetValue());
		System.out.println(testVarValueUpdate.GetValue());
	}
	
	/**
	 * Test nullifying the value of a Float Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfFloatObjectVariable() {
		
		//Set value of variable to null
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		Float value = null;
		Cell<Float> testNullValue = new Cell<Float>("TEST", "TEST", false, "TEST", format, value);
		assertNull(testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullFloatObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		ArrayList<String> format = null;
		boolean requiresInput = false;
		Float value = null;
		
		//Set up a valid test variable with a value 
		Cell<Float> nullIntegerObjectVariable = new Cell<Float>(name, id, requiresInput, description, format, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the format is correct
		assertNull(nullIntegerObjectVariable.GetFormat());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	
	@Test
	public void setPrimitiveIntoFloatObjectType() {
		
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		Cell<Float> testVarWithPrimitive = new Cell<Float>("TEST", "TEST", false, "TEST", format, 3.28F);
		assertEquals(3.28F, (float) testVarWithPrimitive.GetValue(), 0);
		
	}
	
	//***** BOOLEAN TESTING SECTION *****\\
	
	 /**
	  * Test creation of Boolean Variable
	  * Expectation: Success
	  */
	@Test
	public void createBooleanObjectVariable() {
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		boolean requiresInput = false;
		Boolean value = true;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Cell<Boolean> testVarNoValue = new Cell<Boolean>(name, id, requiresInput, description, format);
				Cell<Boolean> testVarWithValue = new Cell<Boolean>(name, id, requiresInput, description, format, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
				
				//Test the format is correct
				assertEquals(format, testVarNoValue.GetFormat());
				assertEquals(format, testVarWithValue.GetFormat());
			
				//Test the value set properly or is properly null
				assertEquals(value, testVarWithValue.GetValue());
				assertNull(testVarNoValue.GetValue());
			
		} catch (Exception e) {
			
				// If this tosses an Exception we failed
				assertFalse(true);
				
		}
		
	}
	
	/**
	 * Test re-setting the value of a Boolean Variable
	 * Expectation: Success
	 */
	@Test
	public void resetValueOfBooleanObjectVariable(){
		
		//Set up initial conditions
		String name = "TestVar";
		String id = "TestID";
		String description = "A Test Variable";
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("dd/MM/yyyy", "hh:mm:ss"));
		boolean requiresInput = false;
		Boolean value = true;
		Boolean newValue = false;
		
		//Set up a valid test variable with a value 
		Cell<Boolean> testVarValueUpdate = new Cell<Boolean>(name, id, requiresInput, description,format, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
		//Test the format is correct
		assertEquals(format, testVarValueUpdate.GetFormat());
		
		//Test the value set properly
		assertEquals(value, testVarValueUpdate.GetValue());
		
		//Test the value updates properly
		testVarValueUpdate.SetValue(newValue); 
		
		//Test the updated value displays properly
		assertEquals(newValue, testVarValueUpdate.GetValue());
		System.out.println(testVarValueUpdate.GetValue());
	}
	
	/**
	 * Test nullifying the value of a Boolean Variable
	 * Expectation: Success
	 */
	@Test
	public void nullValueOfBooleanObjectVariable() {
		
		//Set value of variable to null
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		Boolean value = false;
		Cell<Boolean> testNullValue = new Cell<Boolean>("TEST", "TEST", false, "TEST", format, value);
		assertEquals(value, testNullValue.GetValue());

	}
		
	/**
	 * Test creating a variable with all possible nullables as null
	 * Expectation: Success
	 */
	@Test
	public void nullBooleanObjectVariable() {
		
		//Set up initial conditions
		String name = null;
		String id = null;
		String description = null;
		ArrayList<String> format = null;
		boolean requiresInput = false;
		Boolean value = null;
		
		//Set up a valid test variable with a value 
		Cell<Boolean> nullIntegerObjectVariable = new Cell<Boolean>(name, id, requiresInput, description, format, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the format is correct
		assertNull(nullIntegerObjectVariable.GetFormat());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoBooleanObjectType() {
		ArrayList<String> format = new ArrayList <String> (Arrays.asList("TEST"));
		Cell<Boolean> testVarWithPrimitive = new Cell<Boolean>("TEST", "TEST", false, "TEST", format, false);
		assertEquals(false, (boolean) testVarWithPrimitive.GetValue());
		
	}
}