package com.bugfullabs.depochests;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class DepoChests extends JavaPlugin {
	
	public Logger log;
	public Map<String, Inventory> ChestsInv = new HashMap<String, Inventory>();
	public ArrayList<Location> Chests;
	
	public static final String PLUGIN_NAME = "DepoChests";
	
	public File chestsFile;
	
	
	
	
	public void onEnable(){
	
	log = this.getLogger();
	
	getDataFolder().mkdir();
	
	
	chestsFile = new File(getDataFolder(), "chests.bfl");
	if(chestsFile.exists()){
		Chests = FileAPI.loadLocationList(chestsFile, this);
	}else{
		Chests = new ArrayList<Location>(5);
	}
	
	
	log.info("DepoChests Enabled");
	new PlayerListener(this);
	}
	
	public void onDisable(){
	log.info("DepoChests Disabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("depochests")){
			
			if(args.length > 0){
				
				if(sender instanceof Player){
					
					Player player = (Player) sender;
					
					switch(args[0]){
					
					case "list":
						player.sendMessage(ChatColor.GOLD + "[" + PLUGIN_NAME  + "]" + ChatColor.WHITE + "List: ");
						for(int i = 0; i < Chests.size(); i++){
							if(Chests.get(i) != null)
							player.sendMessage(ChatColor.GOLD + "[" + PLUGIN_NAME  + "]" + ChatColor.WHITE + Integer.toString(i+1) + ". X:" + Integer.toString((int) Chests.get(i).getX()) + " Y:" + Integer.toString((int) Chests.get(i).getY()) + " Z:" + Integer.toString((int) Chests.get(i).getZ()));	
						}
						break;
					
					case "add":	
						if(player.getTargetBlock(null, 10).getType().equals(Material.CHEST)){
						if(!Chests.contains(player.getTargetBlock(null, 10).getLocation())){
						Chests.add(player.getTargetBlock(null, 10).getLocation());
						player.sendMessage(ChatColor.GOLD + "[" + PLUGIN_NAME  + "]" + ChatColor.WHITE + "DepoChest created!");
						
						FileAPI.saveLocationList(Chests, chestsFile);
						player.sendMessage(ChatColor.GOLD + "[" + PLUGIN_NAME  + "]" + ChatColor.WHITE + "Saved!");
						
						}else{
						player.sendMessage(ChatColor.GOLD + "[" + PLUGIN_NAME  + "]" + ChatColor.WHITE + "This is a DepoChest!!");	
						}
						
						}else{
						player.sendMessage(ChatColor.GOLD + "[" + PLUGIN_NAME  + "]" + ChatColor.WHITE + "You have to select a chest!");	
						}
						break;
						
					case "delete":	
						if(Chests.contains(player.getTargetBlock(null, 10).getLocation())){
							Chests.remove(player.getTargetBlock(null, 10).getLocation());
							player.sendMessage(ChatColor.GOLD + "[" + PLUGIN_NAME  + "]" + ChatColor.WHITE + "DepoChest removed!");
							
							FileAPI.saveLocationList(Chests, chestsFile);
							player.sendMessage(ChatColor.GOLD + "[" + PLUGIN_NAME  + "]" + ChatColor.WHITE + "Saved!");
						}
						break;
						
					default:
						player.sendMessage("Wrong usage!");
						break;
					}
				}	
				
			}else{
			sender.sendMessage(ChatColor.GOLD + "[" + PLUGIN_NAME  + "]" + ChatColor.WHITE + "Usage: /depochests [add:delete:list]");	
			}
			return true;
		}else if(cmd.getName().equalsIgnoreCase("depo")){
			
		
			if(sender instanceof Player){
			
				Player player = (Player) sender;
				
				Inventory pInv = ChestsInv.get(player.getName());
			
				player.openInventory(pInv);	
			}
		
		}
		return false;
	}
	
	

}
