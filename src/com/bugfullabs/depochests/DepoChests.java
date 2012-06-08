package com.bugfullabs.depochests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class DepoChests extends JavaPlugin {
	
	private Logger log;
	public Map<Player, Inventory> ChestsInv = new HashMap<Player, Inventory>();
	public ArrayList<Location> Chests = new ArrayList<Location>(5);
	
	public void onEnable(){
	log = this.getLogger();
	log.info("PrivateChests Enabled");
	new PlayerListener(this);
	}
	
	public void onDisable(){
	log.info("PrivateChest Disabled");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("depochests")){
			
			if(args.length > 1){
				
				if(sender instanceof Player){
					
					Player player = (Player) sender;
					
					switch(args[0]){
					
					case "list":
						for(int i = 0; i < Chests.size(); i++){
							if(Chests.get(i) != null)
							player.sendMessage(Integer.toString(i) + ". X:" + Integer.toString((int) Chests.get(i).getX()) + " Y:" + Integer.toString((int) Chests.get(i).getY()) + " Z:" + Integer.toString((int) Chests.get(i).getZ()));	
						}
						break;
					
					case "set":	
						Chests.add(player.getTargetBlock(null, 10).getLocation());
						break;
					case "delete":	
						
						break;
					default:
						player.sendMessage("Wrong usage!");
						break;
					}
				}	
				
			}else{
			sender.sendMessage(ChatColor.GOLD + "[DepoChests]" + ChatColor.WHITE + "Usage: /depochest [add:delete:list]");	
			}
			return true;
		}
		return false;
	}
	
	

}
