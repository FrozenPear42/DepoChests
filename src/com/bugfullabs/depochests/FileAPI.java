package com.bugfullabs.depochests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.bukkit.Location;


public class FileAPI {
	
	public static void saveLocationList (ArrayList<Location> list, File file){
	
	try {
		final FileOutputStream fos = new FileOutputStream(file);
		
		for(int i = 0; i < list.size(); i++){
		
		fos.write(list.get(i).);
		
		}
		
		fos.flush();
		fos.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	}
	
	
}
