package com.tribes.cometcraft.main;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.tribes.cometcraft.classes.ClassSelector;
import com.tribes.cometcraft.classes.FireBlaster;
import com.tribes.cometcraft.teams.Teams;

public class Main extends JavaPlugin{
	
	ClassSelector cs = new ClassSelector(this);
	FireBlaster fb = new FireBlaster(this);
	public Teams teams = new Teams(this);
	
	@Override
	    public void onEnable() {
			PluginManager pm = getServer().getPluginManager();
		    getLogger().info("[Tribes] The Tribes Plugins Has Been Enabled!");
			this.getCommand("tribes").setExecutor(new Commands(this));
			pm.registerEvents(cs, this);
			pm.registerEvents(fb, this);
	    }

	 @Override
	    public void onDisable() {
	    	getLogger().info("[Tribes] The Tribes Plugins Has Been Disabled!");
	   
	    }

}