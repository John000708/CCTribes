package com.tribes.cometcraft.classes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.tribes.cometcraft.main.Main;
import com.tribes.cometcraft.teams.Teams;

public class ClassSelector implements Listener{
	Main plugin;
	FireBlaster fireb;
	Teams teams;
	
	public Inventory invFire;
	public Inventory invWater;
	public Inventory invEarth;
	public Inventory invAir;
	
	ItemStack FireBlaster;

	public ClassSelector(Main p){
		this.plugin = p;
		teams = new Teams(p);
		fireb = new FireBlaster(p);
		invFire = Bukkit.getServer().createInventory(null, 9, "Fire Classes");
		invWater = Bukkit.getServer().createInventory(null, 9, "Water Classe");
		invEarth = Bukkit.getServer().createInventory(null,9, "Earth Classes");
		invAir = Bukkit.getServer().createInventory(null, 9, "Air Classes");
		
		FireBlaster = new ItemStack(Material.FIREBALL);
		ItemMeta im = FireBlaster.getItemMeta();
	    im.setDisplayName(ChatColor.RED + "Fire Blaster");
	    FireBlaster.setItemMeta(im);
	    
	    invFire.setItem(0, FireBlaster);
	}
	
	
	@EventHandler
    public void onFireInventoryClick(InventoryClickEvent e) {
            if (!e.getInventory().getName().equalsIgnoreCase(invFire.getName())) return;
            if (e.getCurrentItem() == null) return;
            if (e.getCurrentItem().getItemMeta() == null) return;     
            Player p = (Player)e.getWhoClicked();
            if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Fire Blaster")) {
            	e.setCancelled(true);
            	fireb.classChosen(p);
            }
   
    }
}
