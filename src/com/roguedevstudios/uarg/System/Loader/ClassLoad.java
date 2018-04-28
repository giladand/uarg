package com.roguedevstudios.uarg.System.Loader;

/*
 * @author Joe Rivera
 * @author JD Isaacks
 * 04/27/2018
 */

import java.io.File;

public class ClassLoad {

	public static void ModCheck(String[] args) {
		File Module = new File("Folder");
		//declares module as File "Folder"
		
		if(Module.exists()) {
			try {
				
				Module.getPath();
				//retrieves filepath for Module
				Module.getClass();
				//retrieves class of Module if any
			}
			catch(Exception e) {
				System.out.println("Cannot find module in FilePath" +Module.getPath());
				//Prints error to screen
			}
				 
				
			}
		
		
		
		
	}
	

}

