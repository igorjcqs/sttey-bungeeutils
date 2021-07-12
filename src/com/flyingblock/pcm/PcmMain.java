/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flyingblock.pcm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import com.flyingblock.pcm.animation.PingAnimationSave;
import com.flyingblock.pcm.save.PingAnimationConfig;
import com.flyingblock.pcm.tags.ServerInfo;
import com.flyingblock.pcm.tags.after.PlayerInfoIP;

import me.igormgs.Eventos;
import me.igormgs.accountCommand;
import me.igormgs.banCommand;
import me.igormgs.staffchatJOINBungee;
import me.igormgs.staffchatLEAVEBungee;
import me.igormgs.kickCommand;
import me.igormgs.muteCommand;
import me.igormgs.reportCommand;
import me.igormgs.db.EndDB;
import me.igormgs.db.MySQLManager;
import net.md_5.bungee.api.plugin.Plugin;

public class PcmMain extends Plugin
{
    private static PingAnimationConfig config;
    private PingAnimationSave saveAnimation;
    private PingThingy thingy;
    
    public static PcmMain plugin;
    
    public static ReentrantLock lock = new ReentrantLock(true);
	public static String SQL_HOST = "localhost";
	public static String SQL_PORT = "3306";
	public static String SQL_USER = "root";
	public static String SQL_PASS = "";
	public static String SQL_DATA = "sttey";
	public static Boolean SQL_DSC = Boolean.valueOf(false);
	private static Connection con;
	public MySQLManager mysql = new MySQLManager(this);
	public boolean database = false;
	  
	  public void onLoad() {
		  plugin = this;
		  try {
			MySQLManager.setupSQL();
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	  
	  public static String getMeses() {
			Calendar cal = Calendar.getInstance();
			  if(cal.get(Calendar.MONTH) == 0) {
				  return "JANEIRO";
			  }
			  
			  if(cal.get(Calendar.MONTH) == 1) {
				  return "FEVEREIRO";
			  }
			  
			  if(cal.get(Calendar.MONTH) == 2) {
				  return "MARÇO";
			  }
			  
			  if(cal.get(Calendar.MONTH) == 3) {
				  return "ABRIL";
			  }
			  
			  if(cal.get(Calendar.MONTH) == 4) {
				  return "MAIO";
			  }
			  
			  if(cal.get(Calendar.MONTH) == 5) {
				  return "JUNHO";
			  }
			  
			  if(cal.get(Calendar.MONTH) == 6) {
				  return "JULHO";
			  }
			  
			  if(cal.get(Calendar.MONTH) == 7) {
				  return "AGOSTO";
			  }
			  
			  if(cal.get(Calendar.MONTH) == 8) {
				  return "SETEMBRO";
			  }
			  
			  if(cal.get(Calendar.MONTH) == 9) {
				  return "OUTUBRO";
			  }
			  
			  if(cal.get(Calendar.MONTH) == 10) {
				  return "NOVEMBRO";
			  }
			  
			  if(cal.get(Calendar.MONTH) == 11) {
				  return "DEZEMBRO";
			  }
			return "NENHUM";
		  }
		  
		  public static int getDia() {
			  Calendar cal = Calendar.getInstance();
			  return cal.get(Calendar.DATE);
		  }
		  
		  
		  public static int getAno() {
			  Calendar cal = Calendar.getInstance();
			  return cal.get(Calendar.YEAR);
		  }
		  
		  public static String getDiaDaSemana() {
			  Calendar cal = Calendar.getInstance();
			  if(cal.get(Calendar.DAY_OF_WEEK) == 1) {
				  return "DOMINGO";
			  }
			  
			  if(cal.get(Calendar.DAY_OF_WEEK) == 2) {
				  return "SEGUNDA-FEIRA";
			  }
			  
			  if(cal.get(Calendar.DAY_OF_WEEK) == 3) {
				  return "TERÇA-FEIRA";
			  }
			  
			  if(cal.get(Calendar.DAY_OF_WEEK) == 4) {
				  return "QUARTA-FEIRA";
			  }
			  
			  if(cal.get(Calendar.DAY_OF_WEEK) == 5) {
				  return "QUINTA-FEIRA";
			  }
			  
			  if(cal.get(Calendar.DAY_OF_WEEK) == 6) {
				  return "SEXTA-FEIRA";
			  }
			  
			  if(cal.get(Calendar.DAY_OF_WEEK) == 7) {
				  return "SÁBADO";
			  }
			  return "NENHUM";
		  }
		  
		  public static int getHora() {
			  Calendar cal = Calendar.getInstance();
			  return cal.get(Calendar.HOUR_OF_DAY);
		  }
		  
		  public static String getMinutos() {
			  Calendar cal = Calendar.getInstance();
			  if(cal.get(Calendar.MINUTE) == 1) {
				  return "0" + cal.get(Calendar.MINUTE);
			  }
			  
			  if(cal.get(Calendar.MINUTE) == 2) {
				  return "0" + cal.get(Calendar.MINUTE);
			  }
			  
			  if(cal.get(Calendar.MINUTE) == 3) {
				  return "0" + cal.get(Calendar.MINUTE);
			  }
			  
			  if(cal.get(Calendar.MINUTE) == 4) {
				  return "0" + cal.get(Calendar.MINUTE);
			  }
			  
			  if(cal.get(Calendar.MINUTE) == 5) {
				  return "0" + cal.get(Calendar.MINUTE);
			  }
			  
			  if(cal.get(Calendar.MINUTE) == 6) {
				  return "0" + cal.get(Calendar.MINUTE);
			  }
			  
			  if(cal.get(Calendar.MINUTE) == 7) {
				  return "0" + cal.get(Calendar.MINUTE);
			  }
			  
			  if(cal.get(Calendar.MINUTE) == 8) {
				  return "0" + cal.get(Calendar.MINUTE);
			  }
			  
			  if(cal.get(Calendar.MINUTE) == 9) {
				  return "0" + cal.get(Calendar.MINUTE);
			  }
			  return "" + cal.get(Calendar.MINUTE);
		  }
  
  public static synchronized void SQLconnect(){
	    try{
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String conn = "jdbc:mysql://" + SQL_HOST + ":" + SQL_PORT + "/" + 
	        SQL_DATA;
	      con = DriverManager.getConnection(conn, SQL_USER, SQL_PASS);
	    }
	    catch (ClassNotFoundException ex){
	      System.out.println("MySQL Driver nao encontrado!");
	    }
	    catch (SQLException ex){
	      System.out.println("Erro ao tentar conectar ao Mysql!");
	    }
	    catch (Exception ex){
	      System.out.println("Erro desconhecido enquanto tentava conectar ao MySQL.");
	    }
	  }
	  
	  public static void SQLdisconnect(){
	    EndDB end = new EndDB(plugin, plugin.getLogger(), con);
	    ExecutorService executor = Executors.newCachedThreadPool();
	    executor.execute(end);
	    executor.shutdown();
	  }
    
    @Override
    public void onEnable()
    {
        config = new PingAnimationConfig(this);
        saveAnimation = config.getPingAnimation();
        PlayerInfoIP.setup(this);
        ServerInfo.setup(this.getProxy());
        thingy = new PingThingy();
        thingy.enable(this, saveAnimation);
        getProxy().getPluginManager().registerCommand(this, new staffchatJOINBungee());
        getProxy().getPluginManager().registerCommand(this, new staffchatLEAVEBungee());
        getProxy().getPluginManager().registerCommand(this, new banCommand());
        getProxy().getPluginManager().registerCommand(this, new reportCommand());
        getProxy().getPluginManager().registerCommand(this, new kickCommand());
        getProxy().getPluginManager().registerCommand(this, new muteCommand());
        getProxy().getPluginManager().registerCommand(this, new accountCommand());
        getProxy().getPluginManager().registerListener(this, new Eventos());
        super.onEnable();
    }
    
    @Override
    public void onDisable()
    {
        PlayerInfoIP.close(this);
        config.saveToConfig();
        config.saveConfig();
        thingy.close();
        
	    if (this.database) {
	        mysql.closeDB();
	    }
    }
    
}
