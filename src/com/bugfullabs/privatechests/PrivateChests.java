package com.bugfullabs.privatechests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class PrivateChests extends JavaPlugin {
	
	private Logger log;
	public Map<Player, DoubleChestInventory> ChestsInv = new HashMap<Player, DoubleChestInventory>();
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
		if(cmd.getName().equalsIgnoreCase("pccreate")){
		
			if(sender instanceof Player){
				Player player = (Player) sender;
				Location loc = player.getLocation();
				World world = player.getWorld();
				Block block = world.getBlockAt(loc);
				block.setType(Material.CHEST);

			}
			
		sender.sendMessage(ChatColor.AQUA + "Chest created.");
		return true;
		}
		return false;
	}
	
	

}
