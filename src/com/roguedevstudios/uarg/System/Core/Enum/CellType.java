//TODO: Cleanup #2
package com.roguedevstudios.uarg.System.Core.Enum;
/********************************
*   CellType Class          *
*   File Name: CellType.java*
*                               *
*   CellType will enumerate *
*   the cells needed        *
*                               *
*  ©2017 Rogue Dev Studios, LLC *
********************************/

//

/**
 * <p>
 * this enumerates the cells in the cells.java class file
 * <p>
 * 
 * @author Terry Roberson
 *
 *@since 1.0
 */

public enum CellType{
        INTEGER("Integer"),
        INTEGERARRAY("Integer Array"),
        FLOAT("Float"),
        FLOATARRAY("Float Array"),
        DOUBLE("Double"),
        DOUBLEARRAY("Double Array"),
        STRING("String"),
        STRINGARRAY("String Array"),
        BOOLEAN("Boolean"),
        BOOLEANARRAY("Boolean Array"),
        LONG("Long"),
        LONGARRAY("Long Array"),
        NULL("Invalid");
		
        
        private final String _value;
        
        private CellType(String v){
            this._value = v;
          
       }

}
