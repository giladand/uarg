package com.roguedevstudios.uarg.System.Core.Elements.Interface;

import java.util.List;

public interface ICascadeMap {

	List<String> ShakeTree(String UpdatedVariableID, ICells vars, IFormuli formulas);
	List<ICascadeEntry> GetCascadesForVariable(String VariableID);
	void AddEntry(ICascadeEntry Entry);
	
}
