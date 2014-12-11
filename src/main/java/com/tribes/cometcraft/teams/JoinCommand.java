package com.tribes.cometcraft.teams;

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
					teams.Fire.add(p);
					sendGreenMessage(p, "You joined the Fire tribe!");
				}
				if(args[1].equalsIgnoreCase("water")){
					removeFromTeams(p);
					teams.Water.add(p);
					sendGreenMessage(p, "You joined the Water tribe!");
				}
				if(args[1].equalsIgnoreCase("earth")){
					removeFromTeams(p);
					teams.Earth.add(p);
					sendGreenMessage(p, "You joined the Earth tribe!");
				}
				if(args[1].equalsIgnoreCase("air")){
					removeFromTeams(p);
					teams.Air.add(p);
					sendGreenMessage(p, "You joined the Air tribe!");
				}
		    }
			if(args[0].equalsIgnoreCase("team")){
				if(args[1].equalsIgnoreCase("fire")){
					sendBlueMessage(p, "The Fire Team:");
					for (Player s : teams.Fire)
					{
					    
					   sendGreenMessage(p, s.getName().toString());
					}
				}
				if(args[1].equalsIgnoreCase("water")){
					sendBlueMessage(p, "The Water Team:");
					for (Player s : teams.Water)
					{
					    
					    sendGreenMessage(p, s.getName().toString());
					}
				}
				if(args[1].equalsIgnoreCase("earth")){
					sendBlueMessage(p, "The Earth Team:");
					for (Player s : teams.Earth)
					{
					    
					    sendGreenMessage(p, s.getName().toString());
					}
				}
				if(args[1].equalsIgnoreCase("air")){
					sendBlueMessage(p, "The Air Team:");
					for (Player s : teams.Air)
					{
					   
					    sendGreenMessage(p, s.getName().toString());
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
		teams.Fire.remove(p);
		teams.Water.remove(p);
		teams.Earth.remove(p);
		teams.Air.remove(p);
	}

}
