package com.bugfullabs.privatechests;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.Inventory;


public class PlayerListener implements Listener{
	
	public static PrivateChests plugin;
	
	public PlayerListener(PrivateChests p){
		plugin = p;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void normalLogin(PlayerLoginEvent event){

	}
	

	@EventHandler
	public void onItemUsed(PlayerInteractEvent event){
		if(event.getClickedBlock().getType().equals(Material.CHEST)){
			
			boolean found = false;
			for(int i = 0; i < plugin.Chests.size(); i++){
			
				if(event.getClickedBlock().getLocation().equals(plugin.Chests.get(i))){
					found = true;
					event.getPlayer().sendMessage(Integer.toString(i));
					break;
				}
			}
			if(!found && !event.getItem().getType().equals(Material.PAPER)){
			return;
			}else{
				//event.getPlayer().openInventory((Inventory) plugin.ChestsInv.get(event.getPlayer().getName()));				
			event.getPlayer().sendMessage("asfdgf");
			}

			if( event.getItem().getType().equals(Material.PAPER)){
			if(event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
			event.getPlayer().sendMessage("Deleted PrivateChest mark.");
			event.setCancelled(true);
			}else if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			event.getPlayer().sendMessage("Set as PrivateChest.");
			plugin.Chests.add(event.getClickedBlock().getLocation());
			event.setCancelled(true);
			}
			}
		}
	}
}