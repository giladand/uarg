//TODO: Cleanup #2 - after primary parsers completed
package com.roguedevstudios.uarg.JSON.Parser.Serializer;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.BooleanArrayCellDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.BooleanCellDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.DoubleArrayCellDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.DoubleCellDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.FloatArrayCellDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.FloatCellDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.IntegerArrayCellDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.LongArrayCellDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.LongCellDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.StringArrayCellDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.Concrete.StringCellDeserializer;
import com.roguedevstudios.uarg.JSON.Parser.Serializer.CascadeEntryDeserializer; //TODO: Alter CascadeEntryDeserializer to concrete?
import com.roguedevstudios.uarg.System.Core.Elements.Formula;
import com.roguedevstudios.uarg.System.Core.Elements.FormulaSet;
import com.roguedevstudios.uarg.System.Core.Elements.Formuli;
import com.roguedevstudios.uarg.System.Core.Elements.Cell;
import com.roguedevstudios.uarg.System.Core.Elements.Cells;
import com.roguedevstudios.uarg.System.Core.Elements.CascadeEntry;
import com.roguedevstudios.uarg.System.Core.Elements.CascadeMap;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormula;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.IFormuli;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICell;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICells;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICascadeEntry;
import com.roguedevstudios.uarg.System.Core.Elements.Interface.ICascadeMap;
import com.roguedevstudios.uarg.System.Core.Enum.CellType;

/**
 * Helper class for static parsing methods
 * @author Terry Roberson
 * @author Christopher E. Howard
 *
 */
public class ParserHelpers {
	
	/**
	 * Parses an Formula JSON representation into an IFormula compliant object
	 * 
	 * @param <T> The specific concrete IFormula return type requested.
	 * @param json The JSON for the IFormula Object to be created
	 * @param IFormulaDeserializer The custom deserializer for the IFormula compatible Concrete Class parsing to
	 * @param IFormulaConcrete The concrete IFormula compliant class to turn this JSON into
	 * 
	 * @return T The specific IFormula object of this formula
	 * 
	 * @throws NullPointerException Exception thrown if any passed parameters are null.
	 * @throws IllegalArgumentException Exception thrown if the arguments do not follow the bounded constraints.
	 * @throws ClassCastException Exception thrown if casting the IFormula to T fails for any reason.
	 * 
	 * @author Terry Roberson
	 * @author Christopher Howard
	 * 
	 * @since 1.0
	 */
	public static 	IFormula
					ParseFormula(
									JsonElement json, 
									JsonDeserializer<? extends IFormula> IFormulaDeserializer, 
									Class<? extends IFormula> IFormulaConcrete, 
									GsonBuilder gsonBuilder
								) 
					throws	NullPointerException,
							IllegalArgumentException,
							ClassCastException
	{
		
		// Check if any arguments were passed as null and throw exception if necessary
		if( json == null || IFormulaDeserializer == null || IFormulaConcrete == null || gsonBuilder == null)
			throw new NullPointerException("Parameters must be instantiated for ParseFormula.");
		
		// Check if IFormulaConcrete is a legal form of IFormula
		if( !IFormulaConcrete.isAssignableFrom(IFormula.class) )
			throw new IllegalArgumentException("IFormulaConcrete must implement IFormula interface.");
		
		// Register the deserializer
		gsonBuilder.registerTypeAdapter(IFormulaConcrete, IFormulaDeserializer);
		
		// Initialize out custom Gson object
		Gson customGson = gsonBuilder.create();
		
		// Deserialize the object to a Formula object
		try {
			IFormula retForm = customGson.fromJson(json, IFormulaConcrete);
			return retForm;
		}
		catch ( ClassCastException eCCE ) {
			throw eCCE;
		}finally {
			customGson = null;
		}
		
	}
	
	/**
	 * Parses a Formula object into a Formula TreeMap
	 * 
	 * @param <T> IFormula compliant class desired as a return
	 * @param json The JSON for the IFormula Object to be created
	 * @param IFormulaDeserializer The custom deserializer for the IFormula compatible Concrete Class parsing to
	 * @param IFormulaConcrete The concrete IFormula compliant class to turn this JSON into
	 * 
	 * @return Map<String,T>	The Formula Set Mapping of IFormula compliant objects
	 * @throws NullPointerException Exception thrown if any passed parameters are null.
	 * @throws IllegalArgumentException Exception thrown if the arguments do not follow the bounded constraints.
	 * @throws ClassCastException Exception thrown if casting the IFormula to T fails for any reason.
	 * @throws UnknownError Unknown Exception has been thrown
	 * @author Terry Roberson
	 * @since 1.0
	 */
	public static 	TreeMap<String, ? extends IFormula> 
					ParseFormulaSet(
									JsonElement json, 
									JsonDeserializer<? extends IFormula> IFormulaDeserializer, 
									Class<? extends IFormula> IFormulaConcrete, 
									GsonBuilder gsonBuilder
								   )
					throws IllegalStateException,
						   NullPointerException,
						   IllegalArgumentException,
						   ClassCastException,
						   UnknownError
			
	{
		try {
			// Take jsonElement and convert to jsonObject
			JsonObject o = json.getAsJsonObject();
			
			// Get the entry set of Formulas to parse
			Set<Map.Entry<String, JsonElement>> JsonForm = o.entrySet();
			
			// Start up the tree map of the formulas
			TreeMap<String, IFormula> map = new TreeMap<>();
			
			// Loop through the formulas
			for(Map.Entry<String, JsonElement> entry: o.entrySet()) {
				
			// Construct the formula and put it in the tree map
				map.put(entry.getKey(), ParserHelpers.<IFormula>ParseFormula( entry.getValue(), IFormulaDeserializer, (Class<? extends IFormula>)IFormulaConcrete, gsonBuilder));
			}
			return map;
		}
		catch (IllegalStateException eISE)		{throw eISE;}
		catch (NullPointerException eNPE)		{throw eNPE;}
		catch (IllegalArgumentException eIAE)	{throw eIAE;}
		catch (ClassCastException eCCE)			{throw eCCE;}
		catch (UnknownError eUE)				{throw eUE;	}
		catch (Exception e)						
			{throw new UnknownError(e.getMessage());}
	}
	
	/**
	 * 
	 */
	public static <E extends IFormuli>
				  void
				  ParseFormuli(
				  JsonElement json, 
				  JsonDeserializer<? extends IFormula> IFormulaDeserializer, 
				  Class<? extends IFormula> IFormulaConcrete,
				  E IFormuliContainer,
				  GsonBuilder gsonBuilder
			) 
			throws IllegalStateException,
			   	   NullPointerException,
			       IllegalArgumentException,
			       ClassCastException,
			       UnknownError
	{

		try {
			
			// Temp maps to use in loading the Formuli parsed
			TreeMap<String, List<String>> SetLinks = new TreeMap<>();
			TreeMap<String,IFormula> FormulaObjects = new TreeMap<>();
			
			// For every section we need the formulas parsed, and the set they link to
			for(Map.Entry<String, JsonElement> section: 
											   json.getAsJsonObject().entrySet()
				) 
			{
				// Container for this sets tracked formula ID's
				List<String> FormulasProcessed = new ArrayList<>();
				
				// Pass the parsing job to our section parser
				TreeMap<String,? extends IFormula> FormulasFromSection =
										ParserHelpers.ParseFormulaSet(
																	section.getValue(),
																	IFormulaDeserializer,
																	IFormulaConcrete,
																	gsonBuilder
																	);
				
				// Add all the formulas created to the master list
				FormulaObjects.putAll(FormulasFromSection);
				
				// Add all the formula ID's to the section link list
				FormulasProcessed.addAll(FormulasFromSection.keySet());
				
				// Enter the formula set record to the set links
				SetLinks.put(section.getKey(), FormulasProcessed);
			}
			
			// Load the formulas into the IFormuli compliant passed object
			IFormuliContainer.LoadFormulas(FormulaObjects);
			
			// Load the set links into the passed IFormuli compliant passed object
			IFormuliContainer.LoadFormulaSets(SetLinks);
			
		}
		catch (IllegalStateException eISE)		{throw eISE;}
		catch (NullPointerException eNPE)		{throw eNPE;}
		catch (IllegalArgumentException eIAE)	{throw eIAE;}
		catch (ClassCastException eCCE)			{throw eCCE;}
		catch (UnknownError eUE)				{throw eUE;	}
		catch (Exception e)						
			{throw new UnknownError(e.getMessage());}
	}
	
	/**
	 * Parses a CascadeEntry JSON representation into
	 * an ICascadeEntry-compliant object.
	 * @param json	The JSON for the ICascadeEntry object to be created
	 * @param ICascadeEntryDeserializer	The custom deserializer for the ICascadeEntry compatible concrete class being parsed to
	 * @param ICascadeEntryConcrete	The concrete ICascadeEntry compliant class to turn this JSON into
	 * @param gsonBuilder
	 * @throws NullPointerException	If parameters given are not initialized properly.
	 * @throws IllegalArgumentException	If the concrete ICascadeEntry class given does not properly implement the ICascadeEntry interface.
	 * @throws ClassCastException	If casting of the concrete class fails.
	 * @return ICascadeEntry	An object that implements the ICascadeEntry interface.
	 * @author Chelsea Hunter
	 */
	//TODO: Review ParseCascadeEntry method
	public static ICascadeEntry ParseCascadeEntry(JsonElement json, JsonDeserializer<? extends ICascadeEntry> ICascadeEntryDeserializer, Class<? extends ICascadeEntry> ICascadeEntryConcrete, GsonBuilder gsonBuilder) throws NullPointerException, IllegalArgumentException, ClassCastException {
		// Check if any arguments were parsed as null and throw exception if so
		if (json == null || ICascadeEntryDeserializer == null || ICascadeEntryConcrete == null || gsonBuilder == null) {
			throw new NullPointerException("All parameters given to the ParseCascadeEntry() method must be initialized.");
		}
		// Check if ICascadeEntryConcrete is assignable to the ICascadeEntry interface
		if (!ICascadeEntryConcrete.isAssignableFrom(ICascadeEntry.class)) {
			throw new IllegalArgumentException("ICascadeEntryConcrete must implement the ICascadeEntry interface.");
		}
		// Register deserializer
		gsonBuilder.registerTypeAdapter(ICascadeEntryConcrete, ICascadeEntryDeserializer);
		// Initialize custom Gson object
		Gson customGson = gsonBuilder.create();
		// Deserialize object to ICascadeEntry-compliant object
		try {
			ICascadeEntry retCasEnt = customGson.fromJson(json, ICascadeEntryConcrete);
			return retCasEnt;
		} catch(ClassCastException eCCE) {
			throw eCCE;
		} finally {
			//cleanup
			customGson = null;
		}
	}
	
	/**
	 * Parses a CascadeMap JSON representation into
	 * an ICascadeMap-compliant object.
	 * @param json	The JSON for the ICascadeMap object to be created
	 * @param ICascadeEntryDeserializer	The custom deserializer for the ICascadeEntry compatible concrete class being parsed to
	 * @param ICascadeMapConcrete	The concrete ICascadeMap complaint class to turn this JSON into
	 * @param ICascadeEntryConcrete The concrete ICascadeEntry compliant class to add to our ICascadeMap-complaint object
	 * @param gsonBuilder
	 * @throws NullPointerException	If parameters given to the method are null.
	 * @throws IllegalArgumentException	If the concrete class given does not properly implement the ICascadeMap interface.
	 * @throws ClassCastException
	 * @throws Exception
	 * @return ICascadeMap	An object that implements the ICascadeMap interface.
	 * @author Chelsea Hunter
	 */
	//TODO: Review ParseCascadeMap method
	public static ICascadeMap ParseCascadeMap(JsonElement json, JsonDeserializer<? extends ICascadeEntry> ICascadeEntryDeserializer, Class<? extends ICascadeMap> ICascadeMapConcrete, Class<? extends ICascadeEntry> ICascadeEntryConcrete, GsonBuilder gsonBuilder) throws NullPointerException, IllegalArgumentException, ClassCastException, Exception {
		
		// Check if any arguments were parsed as null and throw exception if so
		if (json == null || ICascadeEntryDeserializer == null ||  ICascadeMapConcrete == null || gsonBuilder == null) {
			throw new NullPointerException("All parameters given to the ParseCascadeMap() method must be initialized.");
		}
		// Check if ICascadeMapConcrete is assignable to the ICascadeEntry interface
		if (!ICascadeMapConcrete.isAssignableFrom(ICascadeMap.class)) {
			throw new IllegalArgumentException("ICascadeMapConcrete must implement the ICascadeMap interface.");
		}
		try {
			// Set up ICascadeMap
			ICascadeMap retCasMap = new CascadeMap();	
			// For each entry in the JSON object, whose elements should be CascadeEntries
			for (Map.Entry<String,JsonElement> entry : json.getAsJsonObject().entrySet()) {
				// Construct CMEntries and put in CascadeMap
				retCasMap.AddEntry(ParserHelpers.ParseCascadeEntry(entry.getValue(), ICascadeEntryDeserializer, ICascadeEntryConcrete, gsonBuilder));
			}
			return retCasMap;
		}
		catch (NullPointerException eNPE) { throw eNPE; }
		catch (IllegalArgumentException eIAE) { throw eIAE; }
		catch (ClassCastException eCCE) { throw eCCE; }
		catch (Exception e) { throw new UnknownError(e.getMessage()); }	
	}
	
	//***** INTEGER SECTION ******\\

	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<Integer>
				  ParseIntegerCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<Integer> > ICellDeserializer,
						  				Class<? extends ICell<Integer>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<Integer> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
				  TreeMap<String, ICell<Integer> > 
			      ParseIntegerCellsection(
			    		  JsonElement json,
			    		  JsonDeserializer<? extends ICell<Integer> > ICellDeserializer,
			    		  Class<? extends ICell<Integer>> ICellConcrete,
			    		  GsonBuilder gsonBuilder			    		  
			    		  )
			      throws NullPointerException,
			      		 IllegalArgumentException,
			      		 ClassCastException,
			      		 UnknownError
	{
		try {
			
			// Start up the tree map for these Cells
			TreeMap<String, ICell<Integer> > map = new TreeMap<>();
			
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
					ParserHelpers.
						ParseIntegerCell( entry.getValue(),
												 entry.getKey(),
												 ICellDeserializer,
												 ICellConcrete,
												 gsonBuilder
												 )
					);
			
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<Integer[]>
				  ParseIntegerArrayCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<Integer[]> > ICellDeserializer,
						  				Class<? extends ICell<Integer[]>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<Integer[]> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
	  			TreeMap<String, ICell<Integer[]> > 
				ParseIntegerArrayCellsection(
						JsonElement json,
						JsonDeserializer<? extends ICell<Integer[]> > ICellDeserializer,
						Class<? extends ICell<Integer[]>> ICellConcrete,
						GsonBuilder gsonBuilder			    		  
						)
				throws NullPointerException,
					   IllegalArgumentException,
					   ClassCastException,
					   UnknownError
	{
		try {
							
			// Start up the tree map for these Cells
			TreeMap<String, ICell<Integer[]> > map = new TreeMap<>();
					
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
						ParserHelpers.
							ParseIntegerArrayCell( entry.getValue(),
													 entry.getKey(),
													 ICellDeserializer,
													 ICellConcrete,
													 gsonBuilder
													 )
				);
							
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
					
	
	//***** STRING SECTION *****\\
	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<String>
				  ParseStringCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<String> > ICellDeserializer,
						  				Class<? extends ICell<String>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<String> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
	  			TreeMap<String, ICell<String> > 
				ParseStringCellsection(
						JsonElement json,
						JsonDeserializer<? extends ICell<String> > ICellDeserializer,
						Class<? extends ICell<String>> ICellConcrete,
						GsonBuilder gsonBuilder			    		  
						)
				throws NullPointerException,
					   IllegalArgumentException,
					   ClassCastException,
					   UnknownError
	{
		try {
							
			// Start up the tree map for these Cells
			TreeMap<String, ICell<String> > map = new TreeMap<>();
					
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
						ParserHelpers.
							ParseStringCell( entry.getValue(),
													 entry.getKey(),
													 ICellDeserializer,
													 ICellConcrete,
													 gsonBuilder
													 )
				);
							
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
					
	
	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<String[]>
				  ParseStringArrayCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<String[]> > ICellDeserializer,
						  				Class<? extends ICell<String[]>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<String[]> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
				  TreeMap<String, ICell<String[]> > 
			      ParseStringArrayCellsection(
			    		  JsonElement json,
			    		  JsonDeserializer<? extends ICell<String[]> > ICellDeserializer,
			    		  Class<? extends ICell<String[]>> ICellConcrete,
			    		  GsonBuilder gsonBuilder			    		  
			    		  )
			      throws NullPointerException,
			      		 IllegalArgumentException,
			      		 ClassCastException,
			      		 UnknownError
	{
		try {
			
			// Start up the tree map for these Cells
			TreeMap<String, ICell<String[]> > map = new TreeMap<>();
			
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
					ParserHelpers.
						ParseStringArrayCell( entry.getValue(),
												 entry.getKey(),
												 ICellDeserializer,
												 ICellConcrete,
												 gsonBuilder
												 )
					);
			
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	//***** DOUBLE SECTION *****\\

	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<Double>
				  ParseDoubleCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<Double> > ICellDeserializer,
						  				Class<? extends ICell<Double>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<Double> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
				  TreeMap<String, ICell<Double> > 
			      ParseDoubleCellsection(
			    		  JsonElement json,
			    		  JsonDeserializer<? extends ICell<Double> > ICellDeserializer,
			    		  Class<? extends ICell<Double>> ICellConcrete,
			    		  GsonBuilder gsonBuilder			    		  
			    		  )
			      throws NullPointerException,
			      		 IllegalArgumentException,
			      		 ClassCastException,
			      		 UnknownError
	{
		try {
			
			// Start up the tree map for these Cells
			TreeMap<String, ICell<Double> > map = new TreeMap<>();
			
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
					ParserHelpers.
						ParseDoubleCell( entry.getValue(),
												 entry.getKey(),
												 ICellDeserializer,
												 ICellConcrete,
												 gsonBuilder
												 )
					);
			
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<Double[]>
				  ParseDoubleArrayCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<Double[]> > ICellDeserializer,
						  				Class<? extends ICell<Double[]>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<Double[]> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
	  			TreeMap<String, ICell<Double[]> > 
				ParseDoubleArrayCellsection(
						JsonElement json,
						JsonDeserializer<? extends ICell<Double[]> > ICellDeserializer,
						Class<? extends ICell<Double[]>> ICellConcrete,
						GsonBuilder gsonBuilder			    		  
						)
				throws NullPointerException,
					   IllegalArgumentException,
					   ClassCastException,
					   UnknownError
	{
		try {
							
			// Start up the tree map for these Cells
			TreeMap<String, ICell<Double[]> > map = new TreeMap<>();
					
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
						ParserHelpers.
							ParseDoubleArrayCell( entry.getValue(),
													 entry.getKey(),
													 ICellDeserializer,
													 ICellConcrete,
													 gsonBuilder
													 )
				);
							
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	//***** LONG SECTION *****\\
	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<Long>
				  ParseLongCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<Long> > ICellDeserializer,
						  				Class<? extends ICell<Long>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<Long> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
				  TreeMap<String, ICell<Long> > 
			      ParseLongCellsection(
			    		  JsonElement json,
			    		  JsonDeserializer<? extends ICell<Long> > ICellDeserializer,
			    		  Class<? extends ICell<Long>> ICellConcrete,
			    		  GsonBuilder gsonBuilder			    		  
			    		  )
			      throws NullPointerException,
			      		 IllegalArgumentException,
			      		 ClassCastException,
			      		 UnknownError
	{
		try {
			
			// Start up the tree map for these Cells
			TreeMap<String, ICell<Long> > map = new TreeMap<>();
			
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
					ParserHelpers.
						ParseLongCell( entry.getValue(),
												 entry.getKey(),
												 ICellDeserializer,
												 ICellConcrete,
												 gsonBuilder
												 )
					);
			
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<Long[]>
				  ParseLongArrayCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<Long[]> > ICellDeserializer,
						  				Class<? extends ICell<Long[]>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<Long[]> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
	  			TreeMap<String, ICell<Long[]> > 
				ParseLongArrayCellsection(
						JsonElement json,
						JsonDeserializer<? extends ICell<Long[]> > ICellDeserializer,
						Class<? extends ICell<Long[]>> ICellConcrete,
						GsonBuilder gsonBuilder			    		  
						)
				throws NullPointerException,
					   IllegalArgumentException,
					   ClassCastException,
					   UnknownError
	{
		try {
							
			// Start up the tree map for these Cells
			TreeMap<String, ICell<Long[]> > map = new TreeMap<>();
					
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
						ParserHelpers.
							ParseLongArrayCell( entry.getValue(),
													 entry.getKey(),
													 ICellDeserializer,
													 ICellConcrete,
													 gsonBuilder
													 )
				);
							
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	//***** FLOAT SECTION *****\\
	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<Float>
				  ParseFloatCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<Float> > ICellDeserializer,
						  				Class<? extends ICell<Float>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<Float> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
				  TreeMap<String, ICell<Float> > 
			      ParseFloatCellsection(
			    		  JsonElement json,
			    		  JsonDeserializer<? extends ICell<Float> > ICellDeserializer,
			    		  Class<? extends ICell<Float>> ICellConcrete,
			    		  GsonBuilder gsonBuilder			    		  
			    		  )
			      throws NullPointerException,
			      		 IllegalArgumentException,
			      		 ClassCastException,
			      		 UnknownError
	{
		try {
			
			// Start up the tree map for these Cells
			TreeMap<String, ICell<Float> > map = new TreeMap<>();
			
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
					ParserHelpers.
						ParseFloatCell( entry.getValue(),
												 entry.getKey(),
												 ICellDeserializer,
												 ICellConcrete,
												 gsonBuilder
												 )
					);
			
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<Float[]>
				  ParseFloatArrayCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<Float[]> > ICellDeserializer,
						  				Class<? extends ICell<Float[]>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<Float[]> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
	  			TreeMap<String, ICell<Float[]> > 
				ParseFloatArrayCellsection(
						JsonElement json,
						JsonDeserializer<? extends ICell<Float[]> > ICellDeserializer,
						Class<? extends ICell<Float[]>> ICellConcrete,
						GsonBuilder gsonBuilder			    		  
						)
				throws NullPointerException,
					   IllegalArgumentException,
					   ClassCastException,
					   UnknownError
	{
		try {
							
			// Start up the tree map for these Cells
			TreeMap<String, ICell<Float[]> > map = new TreeMap<>();
					
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
						ParserHelpers.
							ParseFloatArrayCell( entry.getValue(),
													 entry.getKey(),
													 ICellDeserializer,
													 ICellConcrete,
													 gsonBuilder
													 )
				);
							
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	//***** BOOLEAN SECTION *****\\
	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<Boolean>
				  ParseBooleanCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<Boolean> > ICellDeserializer,
						  				Class<? extends ICell<Boolean>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<Boolean> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
				  TreeMap<String, ICell<Boolean> > 
			      ParseBooleanCellsection(
			    		  JsonElement json,
			    		  JsonDeserializer<? extends ICell<Boolean> > ICellDeserializer,
			    		  Class<? extends ICell<Boolean>> ICellConcrete,
			    		  GsonBuilder gsonBuilder			    		  
			    		  )
			      throws NullPointerException,
			      		 IllegalArgumentException,
			      		 ClassCastException,
			      		 UnknownError
	{
		try {
			
			// Start up the tree map for these Cells
			TreeMap<String, ICell<Boolean> > map = new TreeMap<>();
			
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
					ParserHelpers.
						ParseBooleanCell( entry.getValue(),
												 entry.getKey(),
												 ICellDeserializer,
												 ICellConcrete,
												 gsonBuilder
												 )
					);
			
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**
	 * Parses a Cell into a Cell<> object
	 * @param JsonElement JsonElement Representation of this Cell
	 * @param ID String ID of this Cell
	 * @param Type CellType of this Cell
	 * @return Cell<> The non-type specific Cell object of this Cell
	 * @author Terry Roberson
	 * @author Christopher E. Howard
	 * @since 1.0
	 */
	public static ICell<Boolean[]>
				  ParseBooleanArrayCell(
						  				JsonElement json, 
						  				String ID,
						  				JsonDeserializer<? extends ICell<Boolean[]> > ICellDeserializer,
						  				Class<? extends ICell<Boolean[]>> ICellConcrete,
						  				GsonBuilder gsonBuilder
						  			   )
				  throws NullPointerException,
				  		 IllegalArgumentException,
				  		 ClassCastException,
				  		 UnknownError
	{
		// Check for null values in params
		if(	json == null || 
			ID == null || 
			ICellDeserializer == null || 
			ICellConcrete == null || 
			gsonBuilder == null )
			throw new NullPointerException( "All parameters given must be initialized.");

		try {
			// Register the deserializer
			gsonBuilder.registerTypeAdapter( ICellConcrete, ICellDeserializer );
			
			//Initialize our custom Gson object
			Gson customGson = gsonBuilder.create();
			
			// Deserialize the object to a Cell<String> object
			ICell<Boolean[]> retVar = customGson.fromJson( json, ICellConcrete );
			
			// Manually set the ID as deserializer can not do so normally
			retVar.SetId(ID);
	
			customGson = null;
			
			// Return the constructed object to the caller
			return retVar;
		}
		catch ( NullPointerException eNPE )				{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )			{ throw eIAE; }
		catch ( ClassCastException eCCE )				{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}
	
	/**		
	 * Parses a Cell<> Object into a Cell TreeMap
	 * @return map
	 * @author Terry Roberson 
	 * 
	 * @since 1.0
	 */
	public static 
	  			TreeMap<String, ICell<Boolean[]> > 
				ParseBooleanArrayCellsection(
						JsonElement json,
						JsonDeserializer<? extends ICell<Boolean[]> > ICellDeserializer,
						Class<? extends ICell<Boolean[]>> ICellConcrete,
						GsonBuilder gsonBuilder			    		  
						)
				throws NullPointerException,
					   IllegalArgumentException,
					   ClassCastException,
					   UnknownError
	{
		try {
							
			// Start up the tree map for these Cells
			TreeMap<String, ICell<Boolean[]> > map = new TreeMap<>();
					
			// Loop through the Cells
			for( Map.Entry<String,JsonElement> entry: 
											   json.getAsJsonObject().entrySet())
			{
			// Construct the Cell and put it in the tree map
			map.put( entry.getKey(), 
						ParserHelpers.
							ParseBooleanArrayCell( entry.getValue(),
													 entry.getKey(),
													 ICellDeserializer,
													 ICellConcrete,
													 gsonBuilder
													 )
				);
							
			}
			return map;
		}
		catch ( NullPointerException eNPE )			{ throw eNPE; }
		catch ( IllegalArgumentException eIAE )		{ throw eIAE; }
		catch ( ClassCastException eCCE )			{ throw eCCE; }
		catch ( Exception e )
					{ throw new UnknownError(); }
	}

	/**		
	 * Parses a Cell sections into the Cells container
	 * @return map
	 * @author Terry Roberson 
	 * @author Christopher Howard
	 * @since 1.0
	 */
	public static <T extends ICells>
				   T
				   ParseCells(
											JsonElement JSON,
											Map<CellType, JsonDeserializer<? extends ICell<?>>> ICellDeserializersConcretes,
											Map<CellType, Class<? extends ICell<?>>> ICellConcretes,
											T ICellsContainer,
											GsonBuilder gsonBuilder
										  )
	{
		
		// Initialize 12 temp treemaps to match req treemaps for Cells.java constructor
		TreeMap<String, ICell< Integer   > > 	intMap 			= new TreeMap<>();
		TreeMap<String, ICell< Integer[] > > 	intArrayMap 	= new TreeMap<>();
		TreeMap<String, ICell< String    > >	stringMap 		= new TreeMap<>();
		TreeMap<String, ICell< String[]  > > 	stringArrayMap 	= new TreeMap<>();
		TreeMap<String, ICell< Float     > >	floatMap 		= new TreeMap<>();
		TreeMap<String, ICell< Float[]   > > 	floatArrayMap 	= new TreeMap<>();
		TreeMap<String, ICell< Long      > >	longMap 		= new TreeMap<>();
		TreeMap<String, ICell< Long[]    > >	longArrayMap 	= new TreeMap<>();
		TreeMap<String, ICell< Double    > >	doubleMap 		= new TreeMap<>();
		TreeMap<String, ICell< Double[]  > > 	doubleArrayMap 	= new TreeMap<>();
		TreeMap<String, ICell< Boolean   > > 	boolMap 		= new TreeMap<>();
		TreeMap<String, ICell< Boolean[] > > 	boolArrayMap 	= new TreeMap<>();
		
		// Loop over entries in the jsonobjects entry sets 
		for(Map.Entry<String, JsonElement> sectionEntry: JSON.getAsJsonObject().entrySet()) 
		{
			
		// switch based on key of this entry
			switch(sectionEntry.
								getKey().
								toUpperCase()
				  ) 
			{
			// Case Integer for all possible variations of input
			case "INTEGER":
			case "INTEGERS":
				Class<? extends ICell<Integer>> IVi = 
					(Class<? extends ICell<Integer>>) 
					ICellConcretes.
						get(
								CellType.INTEGER
							);
				
				JsonDeserializer<? extends ICell<Integer>> IVDi = 
					(JsonDeserializer<? extends ICell<Integer>>)
					ICellDeserializersConcretes.
						get(
								CellType.INTEGER
							);
				
				// Take the previous temp map created from previous section parser and loop over its entries
				for(Map.Entry<String, ICell<Integer>> CellEntry: 
														  ParserHelpers.
														  ParseIntegerCellsection(
																  					  sectionEntry.getValue(),
																  					  IVDi,
																  					  IVi,
																  					  gsonBuilder
																  					 ).entrySet()
					) 
				{
					// Call the first temp integer map from top and put key and value as this entries value
					intMap.put(CellEntry.getKey(), CellEntry.getValue());
				}
				break;
				
			// Case IntegerArray for all possible variations of input
			case "INTEGERARRAY":
			case "INTEGERSARRAY":
			case "INTEGERARRAYS":
			case "INTEGERSARRAYS":
			case "INTEGER ARRAY":
			case "INTEGERS ARRAY":
			case "INTEGER ARRAYS":
			case "INTEGERS ARRAYS":
				// Take the previous temp map created from previous section parser and loop over its entries
				Class<? extends ICell<Integer[]>> IVsa = 
				(Class<? extends ICell<Integer[]>>) 
				ICellConcretes.
					get(
							CellType.INTEGERARRAY
						);
			
				JsonDeserializer<? extends ICell<Integer[]>> IVDsa = 
				(JsonDeserializer<? extends ICell<Integer[]>>)
				ICellDeserializersConcretes.
					get(
							CellType.INTEGERARRAY
						);
				// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, ICell<Integer[]>> CellEntry: 
					  ParserHelpers.
					  ParseIntegerArrayCellsection(
							  					  sectionEntry.getValue(),
							  					  IVDsa,
							  					  IVsa,
							  					  gsonBuilder
							  					 ).entrySet()
						)
				{
					// Call the first temp String[] map from top and put key and value as this entries value
					intArrayMap.put(CellEntry.getKey(), CellEntry.getValue());
				}
				break;
				
				// Case String for all possible variations of input
			case "STRING":
			case "STRINGS":
				// Take the previous temp map created from previous section parser and loop over its entries
				Class<? extends ICell<String>> IVs = 
				(Class<? extends ICell<String>>) 
				ICellConcretes.
					get(
							CellType.STRING
						);
			
				JsonDeserializer<? extends ICell<String>> IVDs = 
				(JsonDeserializer<? extends ICell<String>>)
				ICellDeserializersConcretes.
					get(
							CellType.STRING
						);
				// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, ICell<String>> CellEntry: 
					  ParserHelpers.
					  ParseStringCellsection(
							  					  sectionEntry.getValue(),
							  					  IVDs,
							  					  IVs,
							  					  gsonBuilder
							  					 ).entrySet()
						)				
				{
					// Call the first temp String map from the top and put key and value as this entries value
					stringMap.put(CellEntry.getKey(), CellEntry.getValue());
				}
				break;
				
			// Case String[] for all possible variations of input
			case "STRINGARRAY":
			case "STRINGSARRAY":
			case "STRINGARRAYS":
			case "STRINGSARRAYS":
			case "STRING ARRAY":
			case "STRINGS ARRAY":
			case "STRING ARRAYS":
			case "STRINGS ARRAYS":
				// Take the previous temp map created from previous section parser and loop over its entries
				Class<? extends ICell<String[]>> SVsa = 
				(Class<? extends ICell<String[]>>) 
				ICellConcretes.
					get(
							CellType.STRINGARRAY
						);
			
				JsonDeserializer<? extends ICell<String[]>> SVDsa = 
				(JsonDeserializer<? extends ICell<String[]>>)
				ICellDeserializersConcretes.
					get(
							CellType.STRINGARRAY
						);
				// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, ICell<String[]>> CellEntry: 
					  ParserHelpers.
					  ParseStringArrayCellsection(
							  					  sectionEntry.getValue(),
							  					  SVDsa,
							  					  SVsa,
							  					  gsonBuilder
							  					 ).entrySet()
						)
				{
					// Call the first temp String[] map from top and put key and value as this entries value
					stringArrayMap.put(CellEntry.getKey(), CellEntry.getValue());
				}
				break;
			
			// Case Float for all possible variations of input
			case "FLOAT":
			case "FLOATS":
				// Take the previous temp map created from previous section parser and loop over its entries
				// Take the previous temp map created from previous section parser and loop over its entries
				Class<? extends ICell<Float>> IVf = 
				(Class<? extends ICell<Float>>) 
				ICellConcretes.
					get(
							CellType.FLOAT
						);
			
				JsonDeserializer<? extends ICell<Float>> IVDf = 
				(JsonDeserializer<? extends ICell<Float>>)
				ICellDeserializersConcretes.
					get(
							CellType.FLOAT
						);
				// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, ICell<Float>> CellEntry: 
					  ParserHelpers.
					  ParseFloatCellsection(
							  					  sectionEntry.getValue(),
							  					  IVDf,
							  					  IVf,
							  					  gsonBuilder
							  					 ).entrySet()
						) 
				{
					// Call the first temp Float map from the tope and put key and value as this entries value
					floatMap.put(CellEntry.getKey(), CellEntry.getValue());
				}
				break;
				
			// Case Long[] for all possible variations of input
			case "FLOATARRAY":
			case "FLOATSARRAY":
			case "FLOATARRAYS":
			case "FLOATSARRAYS":
			case "FLOAT ARRAY":
			case "FLOATS ARRAY":
			case "FLOAT ARRAYS":
			case "FLOATS ARRAYS":
				Class<? extends ICell<Float[]>> IVfa = 
				(Class<? extends ICell<Float[]>>) 
				ICellConcretes.
					get(
							CellType.FLOATARRAY
						);
			
				JsonDeserializer<? extends ICell<Float[]>> IVDfa = 
				(JsonDeserializer<? extends ICell<Float[]>>)
				ICellDeserializersConcretes.
					get(
							CellType.FLOATARRAY
						);
				// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, ICell<Float[]>> CellEntry: 
					  ParserHelpers.
					  ParseFloatArrayCellsection(
							  					  sectionEntry.getValue(),
							  					  IVDfa,
							  					  IVfa,
							  					  gsonBuilder
							  					 ).entrySet()
						) 
				{
				// Call the first temp Float[] map from top and put key and value as this entries value
					floatArrayMap.put(CellEntry.getKey(), CellEntry.getValue());
				}
				break;
				
			// Case Long for all possible variations of input
			case "LONG":
			case "LONGS":
				// Take the previous temp map created from previous section parser and loop over its entries
				Class<? extends ICell<Long>> IVl = 
				(Class<? extends ICell<Long>>) 
				ICellConcretes.
					get(
							CellType.LONG
						);
			
				JsonDeserializer<? extends ICell<Long>> IVDl = 
				(JsonDeserializer<? extends ICell<Long>>)
				ICellDeserializersConcretes.
					get(
							CellType.LONG
						);
				// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, ICell<Long>> CellEntry: 
					  ParserHelpers.
					  ParseLongCellsection(
							  					  sectionEntry.getValue(),
							  					  IVDl,
							  					  IVl,
							  					  gsonBuilder
							  					 ).entrySet()
						) 
				{
					// call the first temp long map from top and put key and value as this entries value
					longMap.put(CellEntry.getKey(), CellEntry.getValue());
				}
				break;
				
			// Case Long[] for all possible variations of input
			case "LONGARRAY":
			case "LONGSARRAY":
			case "LONGARRAYS":
			case "LONGSARRAYS":
			case "LONG ARRAY":
			case "LONGS ARRAY":
			case "LONG ARRAYS":
			case "LONGS ARRAYS":
				Class<? extends ICell<Long[]>> IVla = 
				(Class<? extends ICell<Long[]>>) 
				ICellConcretes.
					get(
							CellType.LONGARRAY
						);
			
				JsonDeserializer<? extends ICell<Long[]>> IVDla = 
				(JsonDeserializer<? extends ICell<Long[]>>)
				ICellDeserializersConcretes.
					get(
							CellType.LONGARRAY
						);
				// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, ICell<Long[]>> CellEntry: 
					  ParserHelpers.
					  ParseLongArrayCellsection(
							  					  sectionEntry.getValue(),
							  					  IVDla,
							  					  IVla,
							  					  gsonBuilder
							  					 ).entrySet()
						) 
				{						// Call the first temp Integer[] map from top and put key and value as this entries value
						longArrayMap.put(CellEntry.getKey(), CellEntry.getValue());
				}
				break;
				
			// Case Double for all possible variations of input
			case "DOUBLE":
			case "DOUBLES":
			// Take the previous temp map created from previous section parser and loop over its entries
				Class<? extends ICell<Double>> DVl = 
				(Class<? extends ICell<Double>>) 
				ICellConcretes.
					get(
							CellType.DOUBLE
						);
							
				JsonDeserializer<? extends ICell<Double>> DVDl = 
				(JsonDeserializer<? extends ICell<Double>>)
				ICellDeserializersConcretes.
					get(
							CellType.DOUBLE
						);
			// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, ICell<Double>> CellEntry: 
					  ParserHelpers.
					  ParseDoubleCellsection(
							  					  sectionEntry.getValue(),
							  					  DVDl,
							  					  DVl,
							  					  gsonBuilder
							  					 ).entrySet()
						) 
				{
			// call the first temp long map from top and put key and value as this entries value
					doubleMap.put(CellEntry.getKey(), CellEntry.getValue());
								}
								break;

				
			// Case Double[] for all possible variations of input
			case "DOUBLEARRAY":
			case "DOUBLESARRAY":
			case "DOUBLEARRAYS":
			case "DOUBLESARRAYS":
			case "DOUBLE ARRAY":
			case "DOUBLES ARRAY":
			case "DOUBLE ARRAYS":
			case "DOUBLES ARRAYS":
				// Take the previous temp map created from previous section parser and loop over its entries
				Class<? extends ICell<Double[]>> DVda = 
				(Class<? extends ICell<Double[]>>) 
				ICellConcretes.
					get(
							CellType.DOUBLEARRAY
						);
			
				JsonDeserializer<? extends ICell<Double[]>> DVDda = 
				(JsonDeserializer<? extends ICell<Double[]>>)
				ICellDeserializersConcretes.
					get(
							CellType.DOUBLEARRAY
						);
				// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, ICell<Double[]>> CellEntry: 
					  ParserHelpers.
					  ParseDoubleArrayCellsection(
							  					  sectionEntry.getValue(),
							  					  DVDda,
							  					  DVda,
							  					  gsonBuilder
							  					 ).entrySet()
						) 
				{
					// Call the first temp double[] map from top and put key and value as this entries value
					doubleArrayMap.put(CellEntry.getKey(), CellEntry.getValue());
				}
				break;
				
			// Case Boolean for all possible variations of input
			case "BOOLEAN":
			case "BOOLEANS":
				// Take the previous temp map created from previous section parser and loop over its entries
				Class<? extends ICell<Boolean>> BVb = 
				(Class<? extends ICell<Boolean>>) 
				ICellConcretes.
					get(
							CellType.BOOLEAN
						);
			
				JsonDeserializer<? extends ICell<Boolean>> BVDb = 
				(JsonDeserializer<? extends ICell<Boolean>>)
				ICellDeserializersConcretes.
					get(
							CellType.BOOLEAN
						);
				// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, ICell<Boolean>> CellEntry: 
					  ParserHelpers.
					  ParseBooleanCellsection(
							  					  sectionEntry.getValue(),
							  					  BVDb,
							  					  BVb,
							  					  gsonBuilder
							  					 ).entrySet()
						) 
				{
					// Call the first temp Boolean map from top and put key and value as this entries value		
					boolMap.put(CellEntry.getKey(), CellEntry.getValue());
				}
				break;
			
			// Case Long[] for all possible variations of input
			case "BOOLEANARRAY":
			case "BOOLEANSARRAY":
			case "BOOLEANARRAYS":
			case "BOOLEANSARRAYS":
			case "BOOLEAN ARRAY":
			case "BOOLEANS ARRAY":
			case "BOOLEAN ARRAYS":
			case "BOOLEANS ARRAYS":
				Class<? extends ICell<Boolean[]>> BVba = 
				(Class<? extends ICell<Boolean[]>>) 
				ICellConcretes.
					get(
							CellType.BOOLEANARRAY
						);
			
				JsonDeserializer<? extends ICell<Boolean[]>> BVDba = 
				(JsonDeserializer<? extends ICell<Boolean[]>>)
				ICellDeserializersConcretes.
					get(
							CellType.BOOLEANARRAY
						);
				// Take the previous temp map created from previous section parser and loop over its entries 
				for(Map.Entry<String, ICell<Boolean[]>> CellEntry: 
					  ParserHelpers.
					  ParseBooleanArrayCellsection(
							  					  sectionEntry.getValue(),
							  					  BVDba,
							  					  BVba,
							  					  gsonBuilder
							  					 ).entrySet()
						) 
				{
				// Call the first temp Boolean[] map from top and put key and value as this entries value				
					boolArrayMap.put(CellEntry.getKey(), CellEntry.getValue());
				}
				break;
				
			// Break from the switch statement
			default:
				break;
			}
		
		}
		// Build the Cells Object 
				ICellsContainer.SetMaps(intMap,intArrayMap,stringMap,stringArrayMap,
											floatMap, floatArrayMap, longMap, longArrayMap,
											doubleMap, doubleArrayMap, boolMap, boolArrayMap
											);
				
				return ICellsContainer;
				
	}
}

