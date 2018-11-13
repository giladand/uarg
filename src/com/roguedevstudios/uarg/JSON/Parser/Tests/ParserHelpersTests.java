//TODO: Cleanup #2 - After primary parsers completed
package com.roguedevstudios.uarg.JSON.Parser.Tests;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import com.google.gson.*;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.ParserHelpers;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICell;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICells;
/**
 * <p>
 * This will test the ParserHelper.java file
 * <p>
 * @author Christopher E. Howard
 * @author Terry Roberson
 * @since 1.0
 */

public class ParserHelpersTests {
	
	//***** Cells Initial Condition Properties *****\\
	private JsonElement _initialCellCond;
	private ArrayList<Integer> _initialCellCondIntVals;
	private ArrayList<Float> _initialCellCondFloatVals;
	private ArrayList<String> _initialCellCondStringVals;
	private ArrayList<Double> _initialCellCondDoubleVals;
	private ArrayList<Long> _initialCellCondLongVals;
	private ArrayList<Boolean> _initialCellCondBoolVals;
	private ArrayList<Integer[]> _initialCellCondIntArrVals;
	private ArrayList<Float[]> _initialCellCondFloatArrVals;
	private ArrayList<Double[]> _initialCellCondDoubleArrVals;
	private ArrayList<String[]> _initialCellCondStringArrVals;
	private ArrayList<Long[]> _initialCellCondLongArrVals;
	private ArrayList<Boolean[]> _initialCellCondBoolArrVals;
	
	//***** INITIAL BUILDERS *****\\
	@Before 
	public void CellsStart() {
		//Populate initial int values
		this._initialCellCondIntVals = new ArrayList<Integer>();
		// 0 slot = 99
		this._initialCellCondIntVals.add(99);
		// 1 slot = 10
		this._initialCellCondIntVals.add(10);
		// 2 slot = 15
		this._initialCellCondIntVals.add(15);
		//Populate initial String values
		this._initialCellCondStringVals = new ArrayList<String>();
		// 0 slot = A
		this._initialCellCondStringVals.add("A");
		// 1 slot = B
		this._initialCellCondStringVals.add("B");
		// 2 slot = C
		this._initialCellCondStringVals.add("C");
		//Populate initial Float values
		this._initialCellCondDoubleVals = new ArrayList<Double>();
		// 0 slot = 990.2
		this._initialCellCondDoubleVals.add(990.2);
		// 1 slot = 10.1
		this._initialCellCondDoubleVals.add(10.1);
		// 2 slot = 15.36
		this._initialCellCondDoubleVals.add(15.36);
		//Populate initial Long values
		this._initialCellCondLongVals = new ArrayList<Long>();
		// 0 slot = 99
		this._initialCellCondLongVals.add(99L);
		// 1 slot = 10
		this._initialCellCondLongVals.add(10L);
		// 2 slot = 15
		this._initialCellCondLongVals.add(15L);
		//Populate initial Float values
		this._initialCellCondFloatVals = new ArrayList<Float>();
		// 0 slot = 99
		this._initialCellCondFloatVals.add(99F);
		// 1 slot = 10
		this._initialCellCondFloatVals.add(10F);
		// 2 slot = 15
		this._initialCellCondFloatVals.add(15F);
		//Populate initial Float values
		this._initialCellCondBoolVals = new ArrayList<Boolean>();
		// 0 slot = true
		this._initialCellCondBoolVals.add(true);
		// 1 slot = false
		this._initialCellCondBoolVals.add(false);
		// 2 slot = false
		this._initialCellCondBoolVals.add(false);
		//Populate initial int[] values
		this._initialCellCondIntArrVals = new ArrayList<Integer[]>();
		// 0 slot = [99,12,3]
		this._initialCellCondIntArrVals.add(new Integer[] {99,12,3});
		// 1 slot = [10,11,12]
		this._initialCellCondIntArrVals.add(new Integer[] {10,11,12});
		// 2 slot = [15,20,25]
		this._initialCellCondIntArrVals.add(new Integer[] {15,20,25});
		//Populate initial String[] values
		this._initialCellCondStringArrVals = new ArrayList<String[]>();
		// 0 slot = [A,B,C]
		this._initialCellCondStringArrVals.add(new String[] {"A","B","C"});
		// 1 slot = [B,C,D]
		this._initialCellCondStringArrVals.add(new String[] {"B","C","D"});
		// 2 slot = [C,D,E]
		this._initialCellCondStringArrVals.add(new String[] {"C","D","E"});
		//Populate initial Float[] values
		this._initialCellCondDoubleArrVals = new ArrayList<Double[]>();
		// 0 slot = [990.2,30.5,.04]
		this._initialCellCondDoubleArrVals.add(new Double[] {990.2,30.5,.04});
		// 1 slot = [10.1,35.5,401.5]
		this._initialCellCondDoubleArrVals.add(new Double[] {10.1,35.5,401.5});
		// 2 slot = [15.36,5.2,4.8]
		this._initialCellCondDoubleArrVals.add(new Double[] {15.36,5.2,4.8});
		//Populate initial Long[] values
		this._initialCellCondLongArrVals = new ArrayList<Long[]>();
		// 0 slot = [99,50,8]
		this._initialCellCondLongArrVals.add(new Long[] {99L,50L,8L});
		// 1 slot = [10,5,8000]
		this._initialCellCondLongArrVals.add(new Long[] {10L,5L,8000L});
		// 2 slot = [15,8,56]
		this._initialCellCondLongArrVals.add(new Long[] {15L,8L,56L});
		//Populate initial Float[] values
		this._initialCellCondFloatArrVals = new ArrayList<Float[]>();
		// 0 slot = [99, 12,5.2]
		this._initialCellCondFloatArrVals.add(new Float[] {99F, 12F,5.2F});
		// 1 slot = [10, 58.2,500.1]
		this._initialCellCondFloatArrVals.add(new Float[] {10F, 58.2F,500.1F});
		// 2 slot = [15, 64.2,69.1]
		this._initialCellCondFloatArrVals.add(new Float[] {15F, 64.2F,69.1F});
		//Populate initial Boolean[] values
		this._initialCellCondBoolArrVals = new ArrayList<Boolean[]>();
		// 0 slot = [true, false, true]
		this._initialCellCondBoolArrVals.add(new Boolean[] {true, false, true});
		// 1 slot = [false, true, false]
		this._initialCellCondBoolArrVals.add(new Boolean[] {false, true, false});
		// 2 slot = [false, true, true]
		this._initialCellCondBoolArrVals.add(new Boolean[] {false, true, true});
		// Let us create 1 large JsonElement using the format that
		// we would actually see in a config file.
		String initVars =
				"{"+
						"\"Integers\":"+
						"{"+
							"\"IntX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondIntVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"IntY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondIntVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"IntZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondIntVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"Strings\":"+
						"{"+
							"\"StringX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondStringVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"StringY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondStringVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"StringZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondStringVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"Doubles\":"+
						"{"+
							"\"DoubleX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondDoubleVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"DoubleY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondDoubleVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"DoubleZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondDoubleVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"Longs\":"+
						"{"+
							"\"LongX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondLongVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"LongY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondLongVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"LongZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondLongVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"Floats\":"+
						"{"+
							"\"FloatX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondFloatVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"FloatY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondFloatVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"FloatZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondFloatVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"Booleans\":"+
						"{"+
							"\"BoolX\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondBoolVals.get(0)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":true"+
								"},"+
							"\"BoolY\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondBoolVals.get(1)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"BoolZ\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":"+this._initialCellCondBoolVals.get(2)+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"IntegerArrays\":"+
						"{"+
							"\"Int[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondIntArrVals.get(0)[0]+","+
									this._initialCellCondIntArrVals.get(0)[1]+","+
									this._initialCellCondIntArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Int[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondIntArrVals.get(1)[0]+","+
									this._initialCellCondIntArrVals.get(1)[1]+","+
									this._initialCellCondIntArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Int[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondIntArrVals.get(2)[0]+","+
									this._initialCellCondIntArrVals.get(2)[1]+","+
									this._initialCellCondIntArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"StringArrays\":"+
							"{"+
						"\"String[]X\":"+
							"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondStringArrVals.get(0)[0]+","+
									this._initialCellCondStringArrVals.get(0)[1]+","+
									this._initialCellCondStringArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
							"},"+
						"\"String[]Y\":"+
							"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondStringArrVals.get(1)[0]+","+
									this._initialCellCondStringArrVals.get(1)[1]+","+
									this._initialCellCondStringArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
							"},"+
						"\"String[]Z\":"+
							"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondStringArrVals.get(2)[0]+","+
									this._initialCellCondStringArrVals.get(2)[1]+","+
									this._initialCellCondStringArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"DoubleArrays\":"+
						"{"+
							"\"Double[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondDoubleArrVals.get(0)[0]+","+
									this._initialCellCondDoubleArrVals.get(0)[1]+","+
									this._initialCellCondDoubleArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Double[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondDoubleArrVals.get(1)[0]+","+
									this._initialCellCondDoubleArrVals.get(1)[1]+","+
									this._initialCellCondDoubleArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Double[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondDoubleArrVals.get(2)[0]+","+
									this._initialCellCondDoubleArrVals.get(2)[1]+","+
									this._initialCellCondDoubleArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"LongArrays\":"+
						"{"+
							"\"Long[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondLongArrVals.get(0)[0]+","+
									this._initialCellCondLongArrVals.get(0)[1]+","+
									this._initialCellCondLongArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Long[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondLongArrVals.get(1)[0]+","+
									this._initialCellCondLongArrVals.get(1)[1]+","+
									this._initialCellCondLongArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Long[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondLongArrVals.get(2)[0]+","+
									this._initialCellCondLongArrVals.get(2)[1]+","+
									this._initialCellCondLongArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"FloatArrays\":"+
						"{"+
							"\"Float[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondFloatArrVals.get(0)[0]+","+
									this._initialCellCondFloatArrVals.get(0)[1]+","+
									this._initialCellCondFloatArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Float[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondFloatArrVals.get(1)[0]+","+
									this._initialCellCondFloatArrVals.get(1)[1]+","+
									this._initialCellCondFloatArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Float[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondFloatArrVals.get(2)[0]+","+
									this._initialCellCondFloatArrVals.get(2)[1]+","+
									this._initialCellCondFloatArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"},"+
						"\"BooleanArrays\":"+
						"{"+
							"\"Bool[]X\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondBoolArrVals.get(0)[0]+","+
									this._initialCellCondBoolArrVals.get(0)[1]+","+
									this._initialCellCondBoolArrVals.get(0)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":true"+
								"},"+
							"\"Bool[]Y\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondBoolArrVals.get(1)[0]+","+
									this._initialCellCondBoolArrVals.get(1)[1]+","+
									this._initialCellCondBoolArrVals.get(1)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"},"+
							"\"Bool[]Z\":"+
								"{"+
									"\"Name\":\"TestName\","+
									"\"Value\":["+
									this._initialCellCondBoolArrVals.get(2)[0]+","+
									this._initialCellCondBoolArrVals.get(1)[1]+","+
									this._initialCellCondBoolArrVals.get(2)[2]+
									"]"+","+
									"\"Description\":\"TestDescription\","+
									"\"Requires Input\":false"+
								"}"+
						"}"+
				"}";
		// System.out.println(initVars);
		// Convert the text to a JsonElement just as we will get
		// in the programs loading stages. This emulates actual
		// initial condition states.
		JsonParser p = new JsonParser();
		this._initialCellCond = p.parse(initVars);
	}
	
	//***** HELPERS *****\\
	/**
	 * Grabs a section from the Cell conditions for use in tests
	 * @param key
	 * @return JsonElement
	 */
	public JsonElement getSectionCondition(String key){
			return this._initialCellCond.getAsJsonObject().get(key);
		}
	/**
	 * Gets a specific Cell from a section in the Cell conditions for use in teset
	 * @param sectionKey
	 * @param CellKey
	 * @return JsonElement
	 */
	public JsonElement getCellCondition(String sectionKey, String CellKey) {
		return this.getSectionCondition(sectionKey).getAsJsonObject().get(CellKey);
	}
	
	//***** INTEGER TESTING SECTION ******\\
	@Test
	public void TestParseIntegerCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse IntX from the Integers section into an ICell<Integer> compliant container
		ICell<Integer> testVar = ParserHelpers.
										ParseIntegerCell(
												this.getCellCondition(
														"Integers", "IntX"), 
														"IntX");
		// Fetch Information about Integer Cell
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"IntX",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialCellCondIntVals.get(0), 
						testVar.GetValue()
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	

	@Test
	public void TestParseIntegerArrayCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse IntX from the Integers section into an ICell<Integer> compliant container
		ICell<Integer[]> testVar = ParserHelpers.
										ParseIntegerArrayCell(
												this.getCellCondition(
														"IntegerArrays", "Int[]X"), 
														"Int[]X");
		
		// Fetch Information about Integer Cell
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"Int[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialCellCondIntArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialCellCondIntArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialCellCondIntArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	
	@Test
	public void TestIntegerSectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse Integer Section into a TreeMap
		TreeMap<String, ICell<Integer>> section = ParserHelpers.
														ParseIntegerCellSection(
																this.getSectionCondition(
																		"Integers"));
		// Fetch key information for Cells
		assertEquals("IntX", section.firstKey());
		assertEquals("IntZ", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}

	@Test
	public void TestIntegerArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse Integer Section into a TreeMap
		TreeMap<String, ICell<Integer[]>> section = ParserHelpers.
														ParseIntegerArrayCellSection(
																this.getSectionCondition(
																		"IntegerArrays"));
		// Fetch key information for Cells
		assertEquals("Int[]X", section.firstKey());
		assertEquals("Int[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}

	//***** STRING TESTING SECTION *****\\
	@Test
	public void TestParseStringCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse StringX, StringY, StringZ from the Strings section into an ICell<String> compliant container
		ICell<String> testVar = ParserHelpers.
										ParseStringCell(
												this.getCellCondition(
														"Strings", "StringX"), 
														"StringX");
		
		// Fetch key information for Cells
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		assertEquals(
						"StringX",
						testVar.GetId()
					);
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		assertEquals(
						this._initialCellCondStringVals.get(0),
						testVar.GetValue()
					);
	
		// Display results
		System.out.println(g.toJson(testVar));
	}
	
	@Test
	public void TestParseStringArrayCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse StringX from the Strings section into an ICell<String> compliant container
		ICell<String[]> testVar = ParserHelpers.
										ParseStringArrayCell(
												this.getCellCondition(
														"StringArrays", "String[]X"), 
														"String[]X");
		
		// Fetch Information about String Cell
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"String[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialCellCondStringArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialCellCondStringArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialCellCondStringArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}

	@Test
	public void TestStringSectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse String Section into a TreeMap
		TreeMap<String, ICell<String>> section = ParserHelpers.
														ParseStringCellSection(
																this.getSectionCondition(
																		"Strings"));
		// Fetch key information for Cells
		assertEquals("StringX", section.firstKey());
		assertEquals("StringZ", section.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
	}
	
	@Test
	public void TestStringArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse String Section into a TreeMap
		TreeMap<String, ICell<String[]>> section = ParserHelpers.
														ParseStringArrayCellSection(
																this.getSectionCondition(
																		"StringArrays"));
		// Fetch key information for Cells
		assertEquals("String[]X", section.firstKey());
		assertEquals("String[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}
	
	//***** DOUBLE TESTING SECTION *****\\
	@Test
	public void TestParseDoubleCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse DoubleX from the Doubles section into an ICell<Double> compliant container
		ICell<Double> testVar = ParserHelpers.
										ParseDoubleCell(
												this.getCellCondition(
														"Doubles", "DoubleX"), 
														"DoubleX");
		// Fetch Information about Integer Cell
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"DoubleX",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialCellCondDoubleVals.get(0), 
						testVar.GetValue()
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	
	@Test
	public void TestParseDoubleArrayCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse IntX from the Doubles section into an ICell<Double> compliant container
		ICell<Double[]> testVar = ParserHelpers.
										ParseDoubleArrayCell(
												this.getCellCondition(
														"DoubleArrays", "Double[]X"), 
														"Double[]X");
		
		// Fetch Information about Double Cell
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"Double[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialCellCondDoubleArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialCellCondDoubleArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialCellCondDoubleArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}

	@Test
	public void TestDoubleSectionMap() {
		
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse Double Section into a TreeMap
		TreeMap<String, ICell<Double>> section = ParserHelpers.
														ParseDoubleCellSection(
																this.getSectionCondition(
																		"Doubles"));
		// Fetch key information for Cells
		assertEquals("DoubleX", section.firstKey());
		assertEquals("DoubleZ", section.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
	}
	
	@Test
	public void TestDoubleArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse Double Section into a TreeMap
		TreeMap<String, ICell<Double[]>> section = ParserHelpers.
														ParseDoubleArrayCellSection(
																this.getSectionCondition(
																		"DoubleArrays"));
		// Fetch key information for Cells
		assertEquals("Double[]X", section.firstKey());
		assertEquals("Double[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}
	
	//***** LONG TESTING SECTION *****\\
	@Test
	public void TestParseLongCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse LongX from the Longs section into an ICell<Long> compliant container
		ICell<Long> testVar = ParserHelpers.
										ParseLongCell(
												this.getCellCondition(
														"Longs", "LongX"), 
														"LongX");
		// Fetch Information about Long Cell
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"LongX",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialCellCondLongVals.get(0), 
						testVar.GetValue()
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	

	@Test
	public void TestParseLongArrayCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse LongX from the Longs section into an ICell<Long> compliant container
		ICell<Long[]> testVar = ParserHelpers.
										ParseLongArrayCell(
												this.getCellCondition(
														"LongArrays", "Long[]X"), 
														"Long[]X");
		
		// Fetch Information about Long Cell
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"Long[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialCellCondLongArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialCellCondLongArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialCellCondLongArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	
	@Test
	public void TestLongSectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse Long Section into a TreeMap
		TreeMap<String, ICell<Long>> section = ParserHelpers.
														ParseLongCellSection(
																this.getSectionCondition(
																		"Longs"));
		// Fetch key information for Cells
		assertEquals("LongX", section.firstKey());
		assertEquals("LongZ", section.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
	}

	@Test
	public void TestLongArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse Long Section into a TreeMap
		TreeMap<String, ICell<Long[]>> section = ParserHelpers.
														ParseLongArrayCellSection(
																this.getSectionCondition(
																		"LongArrays"));
		// Fetch key information for Cells
		assertEquals("Long[]X", section.firstKey());
		assertEquals("Long[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}
	
	//***** FLOAT TESTING SECTION *****\\
	@Test
	public void TestParseFloatCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse FloatX from the Floats section into an ICell<Float> compliant container
		ICell<Float> testVar = ParserHelpers.
										ParseFloatCell(
												this.getCellCondition(
														"Floats", "FloatX"), 
														"FloatX");
		// Fetch Information about Float Cell
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"FloatX",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialCellCondFloatVals.get(0), 
						testVar.GetValue()
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	

	@Test
	public void TestParseFloatArrayCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse Floats section into an ICell<Float> compliant container
		ICell<Float[]> testVar = ParserHelpers.
										ParseFloatArrayCell(
												this.getCellCondition(
														"FloatArrays", "Float[]X"), 
														"Float[]X");
		
		// Fetch Information about Float Cell
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"Float[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialCellCondFloatArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialCellCondFloatArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialCellCondFloatArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	
	@Test
	public void TestFloatSectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse Float Section into a TreeMap
		TreeMap<String, ICell<Float>> section = ParserHelpers.
														ParseFloatCellSection(
																this.getSectionCondition(
																		"Floats"));
		// Fetch key information for Cells
		assertEquals("FloatX", section.firstKey());
		assertEquals("FloatZ", section.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
	}

	@Test
	public void TestFloatArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse Float Section into a TreeMap
		TreeMap<String, ICell<Float[]>> section = ParserHelpers.
														ParseFloatArrayCellSection(
																this.getSectionCondition(
																		"FloatArrays"));
		// Fetch key information for Cells
		assertEquals("Float[]X", section.firstKey());
		assertEquals("Float[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}
	
	//***** BOOLEAN TESTING SECTION *****\\
	@Test
	public void TestParseBooleanCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse BoolX from the Booleans section into an ICell<Boolean> compliant container
		ICell<Boolean> testVar = ParserHelpers.
										ParseBooleanCell(
												this.getCellCondition(
														"Booleans", "BoolX"), 
														"BoolX");
		// Fetch Information about Boolean Cell
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"BoolX",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialCellCondBoolVals.get(0), 
						testVar.GetValue()
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	

	@Test
	public void TestParseBooleanArrayCell() {
		// Convert elements to a JsonTree
		Gson g = new Gson();	
		// Parse BoolX from the Booleans section into an ICell<Boolean> compliant container
		ICell<Boolean[]> testVar = ParserHelpers.
										ParseBooleanArrayCell(
												this.getCellCondition(
														"BooleanArrays", "Bool[]X"), 
														"Bool[]X");
		
		// Fetch Information about Boolean Cell
		assertEquals(
						"TestName",
						testVar.GetName()
					);
		
		assertEquals(
						"Bool[]X",
						testVar.GetId()
					);
		
		assertEquals(
						"TestDescription",
						testVar.GetDescription()
					);
		
		assertEquals(
						this._initialCellCondBoolArrVals.get(0)[0], 
						testVar.GetValue()[0]
					);
		assertEquals(
						this._initialCellCondBoolArrVals.get(0)[1], 
						testVar.GetValue()[1]
					);
		assertEquals(
						this._initialCellCondBoolArrVals.get(0)[2], 
						testVar.GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(testVar));
	}
	
	@Test
	public void TestBooleanSectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse Boolean Section into a TreeMap
		TreeMap<String, ICell<Boolean>> section = ParserHelpers.
														ParseBooleanCellSection(
																this.getSectionCondition(
																		"Booleans"));
		// Fetch key information for Cells
		assertEquals("BoolX", section.firstKey());
		assertEquals("BoolZ", section.lastKey());
		
		// Display results
		System.out.println(g.toJson(section));
	}

	@Test
	public void TestBooleanArraySectionMap() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse Boolean Section into a TreeMap
		TreeMap<String, ICell<Boolean[]>> section = ParserHelpers.
														ParseBooleanArrayCellSection(
																this.getSectionCondition(
																		"BooleanArrays"));
		// Fetch key information for Cells
		assertEquals("Bool[]X", section.firstKey());
		assertEquals("Bool[]Z", section.lastKey());
		// Display results
		System.out.println(g.toJson(section));
	}
	
	//***** CellS TESTING SECTION *****\\
	@Test
	public void TestCells() {
		// Convert elements to a JsonTree
		Gson g = new Gson();
		// Parse JsonElement into a Cells compliant container
		ICells TestElement = ParserHelpers.ParseCells(this._initialCellCond);
		// Fetch information about all Cells inside Json Element
		assertEquals(
				_initialCellCondIntVals.get(0), TestElement.GetInteger("IntX").GetValue()
					);
		assertEquals(
				_initialCellCondIntVals.get(1), TestElement.GetInteger("IntY").GetValue()
					);
		assertEquals(
				_initialCellCondIntVals.get(2), TestElement.GetInteger("IntZ").GetValue()
					);
		assertEquals(
				_initialCellCondStringVals.get(0), TestElement.GetString("StringX").GetValue()
					);
		assertEquals(
				_initialCellCondStringVals.get(1), TestElement.GetString("StringY").GetValue()
					);
		assertEquals(
				_initialCellCondStringVals.get(2), TestElement.GetString("StringZ").GetValue()
					);		
		assertEquals(
				_initialCellCondDoubleVals.get(0), TestElement.GetDouble("DoubleX").GetValue()
					);
		assertEquals(
				_initialCellCondDoubleVals.get(1), TestElement.GetDouble("DoubleY").GetValue()
					);
		assertEquals(
				_initialCellCondDoubleVals.get(2), TestElement.GetDouble("DoubleZ").GetValue()
					);
		assertEquals(
				_initialCellCondFloatVals.get(0), TestElement.GetFloat("FloatX").GetValue()
					);
		assertEquals(
				_initialCellCondFloatVals.get(1), TestElement.GetFloat("FloatY").GetValue()
					);
		assertEquals(
				_initialCellCondFloatVals.get(2), TestElement.GetFloat("FloatZ").GetValue()
					);	
		assertEquals(
				_initialCellCondBoolVals.get(0), TestElement.GetBoolean("BoolX").GetValue()
					);
		assertEquals(
				_initialCellCondBoolVals.get(1), TestElement.GetBoolean("BoolY").GetValue()
					);
		assertEquals(
				_initialCellCondBoolVals.get(2), TestElement.GetBoolean("BoolZ").GetValue()
					);	
		assertEquals(
				_initialCellCondIntArrVals.get(0)[0], TestElement.GetIntegerArray("Int[]X").GetValue()[0]
					);
		assertEquals(
				_initialCellCondIntArrVals.get(0)[1], TestElement.GetIntegerArray("Int[]X").GetValue()[1]
					);
		assertEquals(
				_initialCellCondIntArrVals.get(0)[2], TestElement.GetIntegerArray("Int[]X").GetValue()[2]
					);
		assertEquals(
				_initialCellCondIntArrVals.get(1)[0], TestElement.GetIntegerArray("Int[]Y").GetValue()[0]
					);
		assertEquals(
				_initialCellCondIntArrVals.get(1)[1], TestElement.GetIntegerArray("Int[]Y").GetValue()[1]
					);
		assertEquals(
				_initialCellCondIntArrVals.get(1)[2], TestElement.GetIntegerArray("Int[]Y").GetValue()[2]
					);
		assertEquals(
				_initialCellCondIntArrVals.get(2)[0], TestElement.GetIntegerArray("Int[]Z").GetValue()[0]
					);
		assertEquals(
				_initialCellCondIntArrVals.get(2)[1], TestElement.GetIntegerArray("Int[]Z").GetValue()[1]
					);
		assertEquals(
				_initialCellCondIntArrVals.get(2)[2], TestElement.GetIntegerArray("Int[]Z").GetValue()[2]
					);
		assertEquals(
				_initialCellCondStringArrVals.get(0)[0], TestElement.GetStringArray("String[]X").GetValue()[0]
					);
		assertEquals(
				_initialCellCondStringArrVals.get(0)[1], TestElement.GetStringArray("String[]X").GetValue()[1]
					);
		assertEquals(
				_initialCellCondStringArrVals.get(0)[2], TestElement.GetStringArray("String[]X").GetValue()[2]
					);
		assertEquals(
				_initialCellCondStringArrVals.get(1)[0], TestElement.GetStringArray("String[]Y").GetValue()[0]
					);
		assertEquals(
				_initialCellCondStringArrVals.get(1)[1], TestElement.GetStringArray("String[]Y").GetValue()[1]
					);
		assertEquals(
				_initialCellCondStringArrVals.get(1)[2], TestElement.GetStringArray("String[]Y").GetValue()[2]
					);
		assertEquals(
				_initialCellCondStringArrVals.get(2)[0], TestElement.GetStringArray("String[]Z").GetValue()[0]
					);	
		assertEquals(
				_initialCellCondStringArrVals.get(2)[1], TestElement.GetStringArray("String[]Z").GetValue()[1]
					);		
		assertEquals(
				_initialCellCondStringArrVals.get(2)[2], TestElement.GetStringArray("String[]Z").GetValue()[2]
					);		
		assertEquals(
				_initialCellCondDoubleArrVals.get(0)[0], TestElement.GetDoubleArray("Double[]X").GetValue()[0]
					);
		assertEquals(
				_initialCellCondDoubleArrVals.get(0)[1], TestElement.GetDoubleArray("Double[]X").GetValue()[1]
					);
		assertEquals(
				_initialCellCondDoubleArrVals.get(0)[2], TestElement.GetDoubleArray("Double[]X").GetValue()[2]
					);
		assertEquals(
				_initialCellCondDoubleArrVals.get(1)[0], TestElement.GetDoubleArray("Double[]Y").GetValue()[0]
					);
		assertEquals(
				_initialCellCondDoubleArrVals.get(1)[1], TestElement.GetDoubleArray("Double[]Y").GetValue()[1]
					);
		assertEquals(
				_initialCellCondDoubleArrVals.get(1)[2], TestElement.GetDoubleArray("Double[]Y").GetValue()[2]
					);
		assertEquals(
				_initialCellCondDoubleArrVals.get(2)[0], TestElement.GetDoubleArray("Double[]Z").GetValue()[0]
					);
		assertEquals(
				_initialCellCondDoubleArrVals.get(2)[1], TestElement.GetDoubleArray("Double[]Z").GetValue()[1]
					);
		assertEquals(
				_initialCellCondDoubleArrVals.get(2)[2], TestElement.GetDoubleArray("Double[]Z").GetValue()[2]
					);
		assertEquals(
				_initialCellCondFloatArrVals.get(0)[0], TestElement.GetFloatArray("Float[]X").GetValue()[0]
					);
		assertEquals(
				_initialCellCondFloatArrVals.get(0)[1], TestElement.GetFloatArray("Float[]X").GetValue()[1]
					);
		assertEquals(
				_initialCellCondFloatArrVals.get(0)[2], TestElement.GetFloatArray("Float[]X").GetValue()[2]
					);
		assertEquals(
				_initialCellCondFloatArrVals.get(1)[0], TestElement.GetFloatArray("Float[]Y").GetValue()[0]
					);
		assertEquals(
				_initialCellCondFloatArrVals.get(1)[1], TestElement.GetFloatArray("Float[]Y").GetValue()[1]
					);
		assertEquals(
				_initialCellCondFloatArrVals.get(1)[2], TestElement.GetFloatArray("Float[]Y").GetValue()[2]
					);
		assertEquals(
				_initialCellCondFloatArrVals.get(2)[0], TestElement.GetFloatArray("Float[]Z").GetValue()[0]
					);	
		assertEquals(
				_initialCellCondFloatArrVals.get(2)[1], TestElement.GetFloatArray("Float[]Z").GetValue()[1]
					);	
		assertEquals(
				_initialCellCondFloatArrVals.get(2)[2], TestElement.GetFloatArray("Float[]Z").GetValue()[2]
					);	
		assertEquals(
				_initialCellCondBoolArrVals.get(0)[0], TestElement.GetBooleanArray("Bool[]X").GetValue()[0]
					);
		assertEquals(
				_initialCellCondBoolArrVals.get(0)[1], TestElement.GetBooleanArray("Bool[]X").GetValue()[1]
					);
		assertEquals(
				_initialCellCondBoolArrVals.get(0)[2], TestElement.GetBooleanArray("Bool[]X").GetValue()[2]
					);
		assertEquals(
				_initialCellCondBoolArrVals.get(1)[0], TestElement.GetBooleanArray("Bool[]Y").GetValue()[0]
					);
		assertEquals(
				_initialCellCondBoolArrVals.get(1)[1], TestElement.GetBooleanArray("Bool[]Y").GetValue()[1]
					);
		assertEquals(
				_initialCellCondBoolArrVals.get(1)[2], TestElement.GetBooleanArray("Bool[]Y").GetValue()[2]
					);
		assertEquals(
				_initialCellCondBoolArrVals.get(2)[0], TestElement.GetBooleanArray("Bool[]Z").GetValue()[0]
					);
		assertEquals(
				_initialCellCondBoolArrVals.get(2)[1], TestElement.GetBooleanArray("Bool[]Z").GetValue()[1]
					);
		assertEquals(
				_initialCellCondBoolArrVals.get(2)[2], TestElement.GetBooleanArray("Bool[]Z").GetValue()[2]
					);
		// Display results
		System.out.println(g.toJson(TestElement));
	}
}
