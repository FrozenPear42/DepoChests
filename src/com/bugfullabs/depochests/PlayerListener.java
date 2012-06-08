package com.bugfullabs.depochests;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.Inventory;


public class PlayerListener implements Listener{
	
	public static DepoChests plugin;
	
	public PlayerListener(DepoChests p){
		plugin = p;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onUserLogin(PlayerLoginEvent event){
		if(!plugin.ChestsInv.containsKey(event.getPlayer())){
			Inventory chInv = plugin.getServer().createInventory(null, InventoryType.CHEST);
			plugin.ChestsInv.put(event.getPlayer(), chInv);
		}
	}
	

	@EventHandler
	public void onItemUsed(PlayerInteractEvent event){
		if(event.getClickedBlock().getType().equals(Material.CHEST)){
			
			if(plugin.Chests.contains(event.getClickedBlock().getLocation())){
			event.setCancelled(true);
			Inventory pInv = plugin.ChestsInv.get(event.getPlayer());
			event.getPlayer().openInventory(pInv);	
			}
		}
	}
	
	
}