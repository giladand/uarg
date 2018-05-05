package com.roguedevstudios.uarg.System.Loader;
/*This class is designed to call a method that searches for a module 
 * and attempts to retrieve it, if any exist.
 * The class also stores the file path as a string
 */

/*
 * @author Joe Rivera
 * @author JD Isaacks
 * 04/27/2018
 */

import java.io.File;

public class ClassLoad {
	public static void ModRun(String[] args) {
		ModCheck(); // Method Runs ModCheck
	}

	public static void ModCheck() {
		File Module = new File("Folder");
		//declares module as File "Folder"
		
		
		if(Module.exists()) {
			try {
				
				Module.getPath();
				//retrieves file path for Module
			    Module.getClass();
				//retrieves class of Module if any
			}
			catch(Exception e) {
				String FilePath = Module.getPath();
				
				System.out.println("Cannot find module in FilePath" + " " +FilePath);
				//Prints error to screen
			}
				 
				
			}
		
		
		
		
	}
	

}



