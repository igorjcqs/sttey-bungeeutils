package me.igormgs.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.flyingblock.pcm.PcmMain;

import net.md_5.bungee.api.plugin.Plugin;

public class Query extends Thread{
	
	  private String sql;
	  private Logger log;
	  private Connection con;
	  
	  public Query(String sql, Logger log, Connection con, Plugin plugin){
	    setDaemon(false);
	    
	    this.sql = sql;
	    setLog(log);
	    this.con = con;
	  }
	  
	  public void run(){
	    PcmMain.lock.lock();
	    try
	    {
	      Statement stmt = this.con.createStatement();
	      stmt.executeUpdate(this.sql);
	      stmt.close();
	    }
	    catch (SQLException ex){
	      System.out.println("Error with following query: " + this.sql);
	      
	      System.out.println(ex.getMessage());
	      PcmMain.SQLdisconnect();
	    }
	    catch (NullPointerException ex){
	    	System.out.println("Error while performing a query. (NullPointerException)");
	    }
	    PcmMain.lock.unlock();
	  }
	  
	  public Logger getLog(){
	    return this.log;
	  }
	  
	  public void setLog(Logger log){
	    this.log = log;
	  }
}