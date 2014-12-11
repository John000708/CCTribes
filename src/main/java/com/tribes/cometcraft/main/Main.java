package com.tribes.cometcraft.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.tribes.cometcraft.teams.JoinCommand;

public class Main extends JavaPlugin{
	
	@Override
	    public void onEnable() {
			//PluginManager pm = getServer().getPluginManager();
		    getLogger().info("[Tribes] The Tribes Plugins Has Been Enabled!");
			this.getCommand("tribes").setExecutor(new JoinCommand(this));
	    }

	 @Override
	    public void onDisable() {
	    	getLogger().info("[Tribes] The Tribes Plugins Has Been Disabled!");
	   
	    }

}