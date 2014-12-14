package com.tribes.cometcraft.game;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.tribes.cometcraft.teams.Teams;
import com.tribes.cometcraft.classes.ClassSelector;
import com.tribes.cometcraft.main.Main;

public class VillagerGui implements Listener{
	Main plugin;
	Teams teams;
	ClassSelector cs;
	
	public VillagerGui(Main p){
		this.plugin = p;
		cs = new ClassSelector(p);
		Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
	}

	 
	 
	 public void spawnFireVillager(Player p){
          Villager v = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
          v.setCustomName("Fire Tribe");
          v.setCustomNameVisible(true);
          v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999999, 127));
	 }
	 
	 public void spawnWaterVillager(Player p){
         Villager v = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
         v.setCustomName("Air Tribe");
         v.setCustomNameVisible(true);
         v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999999, 127));
	 }
	 
	 public void spawnEarthVillager(Player p){
         Villager v = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
         v.setCustomName("Water Tribe");
         v.setCustomNameVisible(true);
         v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999999, 127));
	 }
	 
	 public void spawnAirVillager(Player p){
         Villager v = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
         v.setCustomName("Earth Tribe");
         v.setCustomNameVisible(true);
         v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999999, 127));
			v.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999999, 127));
	 }
	
	
	@EventHandler
	public void VillagerHurt(EntityDamageByEntityEvent e)
	{
		if(e.getEntity().getType() == EntityType.VILLAGER)
		{
			Villager v = (Villager) e.getEntity();
			
			if(v.getCustomName().contains("Fire Tribe"))
			{
				e.setCancelled(true);
			}
			if(v.getCustomName().contains("Air Tribe"))
			{
				e.setCancelled(true);
			}
			if(v.getCustomName().contains("Water Tribe"))
			{
				e.setCancelled(true);
			}
			if(v.getCustomName().contains("Earth Tribe"))
			{
				e.setCancelled(true);
			}
	}
}
	
	
	@EventHandler
	public void VillagerInventory(PlayerInteractEntityEvent e){
		
		if(e.getRightClicked().getType() == EntityType.VILLAGER);{
			Villager v = (Villager) e.getRightClicked();
			Player p = e.getPlayer();
			if(v.getCustomName().contains("Fire Tribe")){
				e.setCancelled(true);
				p.openInventory(cs.invFire);
			}	
		}
		if(e.getRightClicked().getType() == EntityType.VILLAGER);{
			Villager v = (Villager) e.getRightClicked();
			Player p = e.getPlayer();
			if(v.getCustomName().contains("Air Tribe")){
				e.setCancelled(true);
				p.openInventory(cs.invAir);
			}	
		}
		if(e.getRightClicked().getType() == EntityType.VILLAGER);{
			Villager v = (Villager) e.getRightClicked();
			Player p = e.getPlayer();
			if(v.getCustomName().contains("Water Tribe")){
				e.setCancelled(true);
				p.openInventory(cs.invWater);
			}	
		}
		if(e.getRightClicked().getType() == EntityType.VILLAGER);{
			Villager v = (Villager) e.getRightClicked();
			Player p = e.getPlayer();
			if(v.getCustomName().contains("Earth Tribe")){
				e.setCancelled(true);
				p.openInventory(cs.invEarth);
			}	
		}
		
	}


	}