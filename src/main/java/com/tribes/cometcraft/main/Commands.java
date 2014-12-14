package com.tribes.cometcraft.main;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tribes.cometcraft.classes.ClassSelector;
import com.tribes.cometcraft.game.VillagerGui;
import com.tribes.cometcraft.teams.Teams;

public class Commands implements CommandExecutor{
	Main main;
	public Teams teams;
	ClassSelector cs;
	VillagerGui vg;
	
	public Commands(Main p){
		this.main = p;
		teams = new Teams(p);
		cs = new ClassSelector(p);
		vg = new VillagerGui(p);
	}

	@Override
	public boolean onCommand(CommandSender sender , Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(args.length == 0){
			sendGreenMessage(p, "Info About tribes");
			return true;
		}
		if(args.length > 0){
			if(args[0].equalsIgnoreCase("join")){
				if(args[1].equalsIgnoreCase("fire")){	
					removeFromTeams(p);
					main.teams.Fire.add(p.getUniqueId());
					sendGreenMessage(p, "You joined the Fire tribe!");
				}
				if(args[1].equalsIgnoreCase("water")){
					removeFromTeams(p);
					main.teams.Water.add(p.getUniqueId());
					sendGreenMessage(p, "You joined the Water tribe!");
				}
				if(args[1].equalsIgnoreCase("earth")){
					removeFromTeams(p);
					main.teams.Earth.add(p.getUniqueId());
					sendGreenMessage(p, "You joined the Earth tribe!");
				}
				if(args[1].equalsIgnoreCase("air")){
					removeFromTeams(p);
					main.teams.Air.add(p.getUniqueId());
					sendGreenMessage(p, "You joined the Air tribe!");
				}
				if(args[1] == null){
					sendRedMessage(p, "Define a tribe!");
				}
				else{
					sendRedMessage(p, "This is not a valid tribe");
				}
		    }
			if(args[0].equalsIgnoreCase("team")){
				if(args[1].equalsIgnoreCase("fire")){
					sendBlueMessage(p, "The Fire Team:");
					for (UUID s : main.teams.Fire)
					{
					   sendGreenMessage(p, Bukkit.getServer().getPlayer(s).getName());
					}
				}
				if(args[1].equalsIgnoreCase("water")){
					sendBlueMessage(p, "The Water Team:");
					for (UUID s : main.teams.Water)
					{
						   sendGreenMessage(p, Bukkit.getServer().getPlayer(s).getName());
					}
				}
				if(args[1].equalsIgnoreCase("earth")){
					sendBlueMessage(p, "The Earth Team:");
					for (UUID s : main.teams.Earth)
					{
						   sendGreenMessage(p, Bukkit.getServer().getPlayer(s).getName());
					}
				}
				if(args[1].equalsIgnoreCase("air")){
					sendBlueMessage(p, "The Air Team:");
					for (UUID s : main.teams.Air)
					{
						   sendGreenMessage(p, Bukkit.getServer().getPlayer(s).getName());
					}
				}
			
			}
			if(args[0].equalsIgnoreCase("spawnfirevillager")){
				vg.spawnFireVillager(p);
			}
			if(args[0].equalsIgnoreCase("spawnwatervillager")){
				vg.spawnWaterVillager(p);
			}
			if(args[0].equalsIgnoreCase("spawnearthvillager")){
				vg.spawnEarthVillager(p);
			}
			if(args[0].equalsIgnoreCase("spawnairvillager")){
				vg.spawnAirVillager(p);
			}
		}
		else{
			sendRedMessage(p, "What are you trying to do?");
		}
	
		return true;
	}
	
	public void sendGreenMessage(Player p, String text){
		p.sendMessage(ChatColor.GREEN + text);
	}
	
	public void sendRedMessage(Player p, String text){
		p.sendMessage(ChatColor.RED + text);
	}
	public void sendBlueMessage(Player p, String text){
		p.sendMessage(ChatColor.BLUE + text);
	}
	
	public void removeFromTeams(Player p){
		main.teams.Fire.remove(p.getUniqueId());
		main.teams.Water.remove(p.getUniqueId());
		main.teams.Earth.remove(p.getUniqueId());
		main.teams.Air.remove(p.getUniqueId());
	}

}
