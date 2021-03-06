package me.igormgs.db;

import java.sql.Connection;

import net.md_5.bungee.api.plugin.Plugin;

public abstract class Database {
	
	  protected Plugin plugin;
	  
	  protected Database(Plugin plugin)
	  {
	    this.plugin = plugin;
	  }
	  
	  public abstract Connection openConnection();
	  
	  public abstract boolean checkConnection();
	  
	  public abstract Connection getConnection();
	  
	  public abstract void closeConnection();
}
