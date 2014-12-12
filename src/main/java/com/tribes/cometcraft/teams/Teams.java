package com.tribes.cometcraft.teams;
import java.util.ArrayList;

import com.tribes.cometcraft.main.Main;

public class Teams  {
	Main plugin;
	
	public ArrayList<String> Fire = new ArrayList<String>();
	public ArrayList<String> Water = new ArrayList<String>();
	public ArrayList<String> Earth = new ArrayList<String>();
	public ArrayList<String> Air = new ArrayList<String>();
	
	public Teams(Main p){
		this.plugin = p;
	}

}
