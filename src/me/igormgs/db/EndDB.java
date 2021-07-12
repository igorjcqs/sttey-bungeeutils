package me.igormgs.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.flyingblock.pcm.PcmMain;

import net.md_5.bungee.api.plugin.Plugin;


public class EndDB extends Thread{

	private Logger log;
	  private Connection con;
	  
	  public EndDB(Plugin plugin, Logger log, Connection con)
	  {
	    setDaemon(false);
	    this.log = log;
	    this.con = con;
	  }
	  
	  public void run()
	  {
	    PcmMain.lock.lock();
	    try
	    {
	    	PcmMain.plugin.getLogger().warning("Desconetando do MYSQL");
	      this.con.close();
	    }
	    catch (SQLException ex)
	    {
	    	PcmMain.plugin.getLogger().warning("Erro ao fechar sua conexao");
	    	PcmMain.plugin.getLogger().warning(ex.getMessage());
	    }
	    catch (NullPointerException ex)
	    {
	    	PcmMain.plugin.getLogger().warning("Erro ao fechar sua conexao");
	    }
	    if (!PcmMain.SQL_DSC.booleanValue())
	    {
	      this.log.info("Reconectando ao MYSQL...");
	      PcmMain.SQLconnect();
	    }
	    PcmMain.lock.unlock();
	  }
	}