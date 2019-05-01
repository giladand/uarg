//TODO: Cleanup #2
package com.roguedevstudios.uarg.System.Core.Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.roguedevstudios.uarg.System.Core.Elements.Fact;

import java.lang.reflect.*;

import java.util.*;

/**
*<p>
*this will test the Variable.java file
*<p>
*
*@author Christopher E. Howard
*@author Terry Roberson
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
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Fact<Integer> testVarNoValue = new Fact<Integer>(name, id, requiresInput, description);
				Fact<Integer> testVarWithValue = new Fact<Integer>(name, id, requiresInput, description, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
			
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
		boolean requiresInput = false;
		Integer value = 2;
		Integer newValue = 5;
		
		//Set up a valid test variable with a value 
		Fact<Integer> testVarValueUpdate = new Fact<Integer>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
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
		Fact<Integer> testNullValue = new Fact<Integer>("TEST", "TEST", false, "TEST", value);
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
		boolean requiresInput = false;
		Integer value = null;
		
		//Set up a valid test variable with a value 
		Fact<Integer> nullIntegerObjectVariable = new Fact<Integer>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoIntegerObjectType() {
		Fact<Integer> testVarWithPrimitive = new Fact<Integer>("TEST", "TEST", false, "TEST", 5);
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
		boolean requiresInput = false;
		String value = "A";
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Fact<String> testVarNoValue = new Fact<String>(name, id, requiresInput, description);
				Fact<String> testVarWithValue = new Fact<String>(name, id, requiresInput, description, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
			
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
		boolean requiresInput = false;
		String value = "A";
		String newValue = "B";
		
		//Set up a valid test variable with a value 
		Fact<String> testVarValueUpdate = new Fact<String>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
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
		String value = null;
		Fact<String> testNullValue = new Fact<String>("TEST", "TEST", false, "TEST", value);
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
		boolean requiresInput = false;
		String value = null;
		
		//Set up a valid test variable with a value 
		Fact<String> nullIntegerObjectVariable = new Fact<String>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoStringObjectType() {
		Fact<String> testVarWithPrimitive = new Fact<String>("TEST", "TEST", false, "TEST", "A");
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
		boolean requiresInput = false;
		Double value = 5.8;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Fact<Double> testVarNoValue = new Fact<Double>(name, id, requiresInput, description);
				Fact<Double> testVarWithValue = new Fact<Double>(name, id, requiresInput, description, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
			
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
		boolean requiresInput = false;
		Double value = 4.3;
		Double newValue = 5.4;
		
		//Set up a valid test variable with a value 
		Fact<Double> testVarValueUpdate = new Fact<Double>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
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
		Double value = null;
		Fact<Double> testNullValue = new Fact<Double>("TEST", "TEST", false, "TEST", value);
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
		boolean requiresInput = false;
		Double value = null;
		
		//Set up a valid test variable with a value 
		Fact<Double> nullIntegerObjectVariable = new Fact<Double>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoDoubleObjectType() {
		Fact<Double> testVarWithPrimitive = new Fact<Double>("TEST", "TEST", false, "TEST", 1e-15);
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
		boolean requiresInput = false;
		Long value = 50000000L;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Fact<Long> testVarNoValue = new Fact<Long>(name, id, requiresInput, description);
				Fact<Long> testVarWithValue = new Fact<Long>(name, id, requiresInput, description, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
			
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
		boolean requiresInput = false;
		Long value = 53L;
		Long newValue = 68L;
		
		//Set up a valid test variable with a value 
		Fact<Long> testVarValueUpdate = new Fact<Long>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
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
		Long value = null;
		Fact<Long> testNullValue = new Fact<Long>("TEST", "TEST", false, "TEST", value);
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
		boolean requiresInput = false;
		Long value = null;
		
		//Set up a valid test variable with a value 
		Fact<Long> nullIntegerObjectVariable = new Fact<Long>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoLongObjectType() {
		Fact<Long> testVarWithPrimitive = new Fact<Long>("TEST", "TEST", false, "TEST", 300L);
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
		boolean requiresInput = false;
		Float value = 2.50F;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Fact<Float> testVarNoValue = new Fact<Float>(name, id, requiresInput, description);
				Fact<Float> testVarWithValue = new Fact<Float>(name, id, requiresInput, description, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
			
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
		boolean requiresInput = false;
		Float value = 5.3F;
		Float newValue = 6.8F;
		
		//Set up a valid test variable with a value 
		Fact<Float> testVarValueUpdate = new Fact<Float>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
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
		Float value = null;
		Fact<Float> testNullValue = new Fact<Float>("TEST", "TEST", false, "TEST", value);
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
		boolean requiresInput = false;
		Float value = null;
		
		//Set up a valid test variable with a value 
		Fact<Float> nullIntegerObjectVariable = new Fact<Float>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	
	@Test
	public void setPrimitiveIntoFloatObjectType() {
		Fact<Float> testVarWithPrimitive = new Fact<Float>("TEST", "TEST", false, "TEST", 3.28F);
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
		boolean requiresInput = false;
		Boolean value = true;
		
		//Wrap in Try/Catch for exception handling
		try {
				//Setup a valid test variable both with and without a value
				Fact<Boolean> testVarNoValue = new Fact<Boolean>(name, id, requiresInput, description);
				Fact<Boolean> testVarWithValue = new Fact<Boolean>(name, id, requiresInput, description, value);
		
				//Test the name is correct
				assertEquals(name, testVarNoValue.GetName());
				assertEquals(name, testVarWithValue.GetName());
			
				//Test the ID is correct
				assertEquals(id, testVarNoValue.GetId());
				assertEquals(id, testVarWithValue.GetId());
			
				//Test the description is correct
				assertEquals(description, testVarNoValue.GetDescription());
				assertEquals(description, testVarWithValue.GetDescription());
			
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
		boolean requiresInput = false;
		Boolean value = true;
		Boolean newValue = false;
		
		//Set up a valid test variable with a value 
		Fact<Boolean> testVarValueUpdate = new Fact<Boolean>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertEquals(name, testVarValueUpdate.GetName());
		
		//Test the ID is correct
		assertEquals(id, testVarValueUpdate.GetId());
		
		//Test the description is correct
		assertEquals(description, testVarValueUpdate.GetDescription());
		
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
		Boolean value = false;
		Fact<Boolean> testNullValue = new Fact<Boolean>("TEST", "TEST", false, "TEST", value);
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
		boolean requiresInput = false;
		Boolean value = null;
		
		//Set up a valid test variable with a value 
		Fact<Boolean> nullIntegerObjectVariable = new Fact<Boolean>(name, id, requiresInput, description, value);
		
		//Test the name is correct
		assertNull(nullIntegerObjectVariable.GetName());
		
		//Test the ID is correct
		assertNull(nullIntegerObjectVariable.GetId());
		
		//Test the description is correct
		assertNull(nullIntegerObjectVariable.GetDescription());
		
		//Test the value set properly
		assertNull(nullIntegerObjectVariable.GetValue());
		
	}
	
	/**
	 * Test putting a primitive value in an object typed variable
	 * Expectation: Success
	 */
	@Test
	public void setPrimitiveIntoBooleanObjectType() {
		Fact<Boolean> testVarWithPrimitive = new Fact<Boolean>("TEST", "TEST", false, "TEST", false);
		assertEquals(false, (boolean) testVarWithPrimitive.GetValue());
		
	}
	
}