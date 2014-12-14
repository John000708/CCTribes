package com.tribes.cometcraft.classes;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.tribes.cometcraft.main.Main;

public class FireBlaster implements Listener{

	Main plugin;
	
	ItemStack FireWand;
	ItemStack FireBow;
	ItemStack arrows;
	
	ItemStack RedHelmet;
	
	public FireBlaster(Main p){
		this.plugin = p;
		
		FireWand = new ItemStack(Material.BLAZE_ROD);
		ItemMeta im = FireWand.getItemMeta();
	    im.setDisplayName(ChatColor.RED + "Fire Wand");
	    FireWand.setItemMeta(im);
	    FireWand.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
	    
	    FireBow = new ItemStack(Material.BOW);
		ItemMeta im2 = FireBow.getItemMeta();
	    im2.setDisplayName(ChatColor.RED + "Fire Bow");
	    FireBow.setItemMeta(im);
	    FireBow.addEnchantment(Enchantment.ARROW_FIRE, 1);
	    
	    RedHelmet = new ItemStack(Material.LEATHER_HELMET);
	    LeatherArmorMeta lam = (LeatherArmorMeta)RedHelmet.getItemMeta();
	    lam.setColor(Color.fromRGB(255, 0, 0));
	    RedHelmet.setItemMeta(lam);
	    
	    arrows = new ItemStack(Material.ARROW, 64);
	}
	
	public void classChosen(Player p){
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.getInventory().setHelmet(RedHelmet);
		p.getInventory().addItem(FireWand);
		p.getInventory().addItem(FireBow);
		p.getInventory().addItem(arrows);
		p.getInventory().addItem(arrows);
	}
	
	@EventHandler
	public void onWandClick(PlayerInteractEvent e){
		final Player p = (Player) e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			ItemStack hand = p.getItemInHand();
			if(hand != null && hand.hasItemMeta() && hand.getItemMeta().hasDisplayName()){
				if(p.getInventory().getItemInHand().getItemMeta().getDisplayName().contains("Fire Wand")){
                 Fireball fireball = p.launchProjectile(Fireball.class);
                 fireball.setVelocity(fireball.getVelocity().multiply(2));
				}
			}
		}
	}	
}
