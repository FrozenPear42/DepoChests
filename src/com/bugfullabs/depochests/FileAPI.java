package com.bugfullabs.depochests;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import org.bukkit.Location;


public class FileAPI {

	public static final String MAIN_SEPARATOR = "!";
	public static final String SEPARATOR = "|";
	
	public static void saveLocationList (ArrayList<Location> list, File file){
	
	try {
		final FileWriter fw = new FileWriter(file);
		
		fw.write(list.size());
		fw.write(SEPARATOR);
		
		for(int i = 0; i < list.size(); i++){
		
		final Location tmpLoc = list.get(i);	
			
		if(tmpLoc == null)
			continue;

		fw.write(tmpLoc.getWorld().getName());
		fw.write(SEPARATOR);
		fw.write(Double.toString(tmpLoc.getX()));
		fw.write(SEPARATOR);
		fw.write(Double.toString(tmpLoc.getY()));
		fw.write(SEPARATOR);
		fw.write(Double.toString(tmpLoc.getZ()));
		fw.write(SEPARATOR);
		fw.write(Float.toString(tmpLoc.getYaw()));
		fw.write(SEPARATOR);
		fw.write(Float.toString(tmpLoc.getPitch()));
		fw.write(MAIN_SEPARATOR);
		}
		
		fw.flush();
		fw.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}	
	
	
	public static ArrayList<Location> loadLocationList (File file, DepoChests plugin){
		
		ArrayList<Location> list = null;
		
		try {
			final FileReader fr = new FileReader(file);
			
			
			char buff[] = new char[(int) file.length()];

			fr.read(buff);
			
			fr.close();
			
			list = new ArrayList<Location>((int)buff[0]);
			
			
			int start = 2;
			int stop = 2;	
			
			
			for(int i = 0; i < (int)buff[0]; i++){
			
			String tmp = "";
			final Location loc = new Location(null, 0, 0, 0, 0, 0);

				//world
				while(buff[stop] != '|'){
				stop++;
				}
				
				for(int j = start; j < stop; j++){
					tmp = tmp + buff[j];
				}
				
				loc.setWorld(plugin.getServer().getWorld(tmp));
				
				
				
				stop++;
				start = stop;
				tmp = "";
				
				//X
				while(buff[stop] != '|'){
				stop++;
				}
					
				for(int j = start; j < stop; j++){
					tmp = tmp + buff[j];
				}
				
				loc.setX(Double.valueOf(tmp));
				
				
				
				stop++;
				start = stop;
				tmp = "";
				
				//Y
				while(buff[stop] != '|'){
				stop++;
				}
					
				for(int j = start; j < stop; j++){
					tmp = tmp + buff[j];
				}
				
				loc.setY(Double.valueOf(tmp));
				
				
				
				stop++;
				start = stop;
				tmp = "";
				
				//Z
				while(buff[stop] != '|'){
				stop++;
				}
					
				for(int j = start; j < stop; j++){
					tmp = tmp + buff[j];
				}
				
				loc.setZ(Double.valueOf(tmp));
				
				
				
				stop++;
				start = stop;
				tmp = "";
				
				//Yaw
				while(buff[stop] != '|'){
				stop++;
				}
					
				for(int j = start; j < stop; j++){
					tmp = tmp + buff[j];
				}
				
				loc.setYaw(Float.valueOf(tmp));
				
				
				
				stop++;
				start = stop;
				tmp = "";
				
				//Pitch
				while(buff[stop] != '!'){
				stop++;
				}
					
				for(int j = start; j < stop; j++){
					tmp = tmp + buff[j];
				}
				
				loc.setPitch(Float.valueOf(tmp));
				
				
				
				stop++;
				start = stop;
				tmp = "";
				
				list.add(loc);
			
		}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	

}
