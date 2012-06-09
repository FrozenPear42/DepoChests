package com.bugfullabs.depochests;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import org.bukkit.Location;


public class FileAPI {

	
	public static void saveLocationList (ArrayList<Location> list, File file){
	
	try {
		final FileWriter fw = new FileWriter(file);
		
		fw.write(list.size());
		
		for(int i = 0; i < list.size(); i++){
		
		if(list.get(i) == null)
			continue;

		}
		
		fw.flush();
		fw.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}	
	
	
	
	
/*	public static void saveLocationList (ArrayList<Location> list, File file){
	
	try {
		final FileOutputStream fos = new FileOutputStream(file);
		
		fos.write(list.size());
		
		for(int i = 0; i < list.size(); i++){
		
		if(list.get(i) == null)
			continue;
			
		fos.write((int) list.get(i).getX());
		fos.write((int) list.get(i).getY());
		fos.write((int) list.get(i).getZ());
		fos.write((int) list.get(i).getYaw());
		fos.write((int) list.get(i).getPitch());
		
		}
		
		fos.flush();
		fos.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	public static void loadLocationList(ArrayList<Location> list, File file){
		
		
		try {
			final FileInputStream fis = new FileInputStream(file);
			
			list = new ArrayList<Location>(fis.read());
		
			for(int i = 0; i < list.size(); i++){
				
				final Location loc = new Location(null, fis.read(),fis.read(),fis.read(),fis.read(),fis.read());
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
*/	
}
