package com.tribes.cometcraft.teams;
import java.util.ArrayList;
import java.util.UUID;

import com.tribes.cometcraft.main.Main;

public class Teams  {
	Main plugin;
	
	public ArrayList<UUID> Fire = new ArrayList<UUID>();
	public ArrayList<UUID> Water = new ArrayList<UUID>();
	public ArrayList<UUID> Earth = new ArrayList<UUID>();
	public ArrayList<UUID> Air = new ArrayList<UUID>();
	
	public Teams(Main p){
		this.plugin = p;
	}

}
