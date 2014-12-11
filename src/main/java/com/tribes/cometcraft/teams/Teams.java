package com.tribes.cometcraft.teams;
import java.util.ArrayList;

import org.bukkit.entity.Player;

import com.tribes.cometcraft.main.Main;

public class Teams  {
	Main plugin;
	
	public ArrayList<Player> Fire = new ArrayList<Player>();
	public ArrayList<Player> Water = new ArrayList<Player>();
	public ArrayList<Player> Earth = new ArrayList<Player>();
	public ArrayList<Player> Air = new ArrayList<Player>();
	
	public Teams(Main p){
		this.plugin = p;
	}

}
