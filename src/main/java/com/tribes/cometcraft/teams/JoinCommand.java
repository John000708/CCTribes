package com.tribes.cometcraft.teams;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tribes.cometcraft.main.Main;

public class JoinCommand implements CommandExecutor{
	Main plugin;
	Teams teams;
	
	public JoinCommand(Main p){
		this.plugin = p;
		teams = new Teams(p);
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
					teams.Fire.add(p.getUniqueId().toString());
					sendGreenMessage(p, "You joined the Fire tribe!");
				}
				if(args[1].equalsIgnoreCase("water")){
					removeFromTeams(p);
					teams.Water.add(p.getUniqueId().toString());
					sendGreenMessage(p, "You joined the Water tribe!");
				}
				if(args[1].equalsIgnoreCase("earth")){
					removeFromTeams(p);
					teams.Earth.add(p.getUniqueId().toString());
					sendGreenMessage(p, "You joined the Earth tribe!");
				}
				if(args[1].equalsIgnoreCase("air")){
					removeFromTeams(p);
					teams.Air.add(p.getUniqueId().toString());
					sendGreenMessage(p, "You joined the Air tribe!");
				}
				if(args[1] == null){
					sendRedMessage(p, "Define a tribe!");
				}
		    }
			if(args[0].equalsIgnoreCase("team")){
				if(args[1].equalsIgnoreCase("fire")){
					sendBlueMessage(p, "The Fire Team:");
					for (String s : teams.Fire)
					{
					   UUID uid = UUID.fromString(s);
					   sendGreenMessage(p, Bukkit.getServer().getPlayer(uid).getName());
					}
				}
				if(args[1].equalsIgnoreCase("water")){
					sendBlueMessage(p, "The Water Team:");
					for (String s : teams.Water)
					{
						   UUID uid = UUID.fromString(s);
						   sendGreenMessage(p, Bukkit.getServer().getPlayer(uid).getName());
					}
				}
				if(args[1].equalsIgnoreCase("earth")){
					sendBlueMessage(p, "The Earth Team:");
					for (String s : teams.Earth)
					{
						   UUID uid = UUID.fromString(s);
						   sendGreenMessage(p, Bukkit.getServer().getPlayer(uid).getName());
					}
				}
				if(args[1].equalsIgnoreCase("air")){
					sendBlueMessage(p, "The Air Team:");
					for (String s : teams.Air)
					{
						   UUID uid = UUID.fromString(s);
						   sendGreenMessage(p, Bukkit.getServer().getPlayer(uid).getName());
					}
				}
			
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
		teams.Fire.remove(p.getUniqueId().toString());
		teams.Water.remove(p.getUniqueId().toString());
		teams.Earth.remove(p.getUniqueId().toString());
		teams.Air.remove(p.getUniqueId().toString());
	}

}
