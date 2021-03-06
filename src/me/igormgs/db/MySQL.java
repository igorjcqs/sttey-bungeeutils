package me.igormgs.db;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;

import com.flyingblock.pcm.PcmMain;

import net.md_5.bungee.api.plugin.Plugin;

public class MySQL extends Database{

	private final String user;
	  private final String database;
	  private final String password;
	  private final String port;
	  private final String hostname;
	  private Connection connection;
	  
	  public MySQL(Plugin plugin, String hostname, String port, String database, String username, String password)
	  {
	    super(PcmMain.plugin);
	    this.hostname = hostname;
	    this.port = port;
	    this.database = database;
	    this.user = username;
	    this.password = password;
	    this.connection = null;
	  }
	  
	  public Connection openConnection()
	  {
	    try
	    {
	      Class.forName("com.mysql.jdbc.Driver");
	      this.connection = DriverManager.getConnection("jdbc:mysql://" + 
          this.hostname + ":" + this.port + "/" + this.database, 
	      this.user, this.password);
	    }
	    catch (SQLException e)
	    {
	      PcmMain.plugin.getLogger().log(Level.SEVERE, "Nao foi possivel conectar-se ao servidor MySQL, motivo: " + 
	        e.getMessage());
	    }
	    catch (ClassNotFoundException e)
	    {
	    	PcmMain.plugin.getLogger().log(Level.SEVERE, "Driver JDBC nao encontrado!");
	    }
	    return this.connection;
	  }
	  
	  public boolean checkConnection()
	  {
	    return this.connection != null;
	  }
	  
	  public Connection getConnection()
	  {
	    return this.connection;
	  }
	  
	  public void closeConnection()
	  {
	    if (this.connection != null) {
	      try
	      {
	        this.connection.close();
	      }
	      catch (SQLException e)
	      {
	    	  PcmMain.plugin.getLogger().log(Level.SEVERE, 
	          "Error closing the MySQL Connection!");
	        e.printStackTrace();
	      }
	    }
	  }
	  
	  public ResultSet querySQL(String query)
	  {
	    Connection c = null;
	    if (checkConnection()) {
	      c = getConnection();
	    } else {
	      c = openConnection();
	    }
	    Statement s = null;
	    try
	    {
	      s = c.createStatement();
	    }
	    catch (SQLException e1)
	    {
	      e1.printStackTrace();
	    }
	    ResultSet ret = null;
	    try
	    {
	      ret = s.executeQuery(query);
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	    }
	    closeConnection();
	    
	    return ret;
	  }
	  
	  public void updateSQL(String update)
	  {
	    Connection c = null;
	    if (checkConnection()) {
	      c = getConnection();
	    } else {
	      c = openConnection();
	    }
	    Statement s = null;
	    try
	    {
	      s = c.createStatement();
	      s.executeUpdate(update);
	    }
	    catch (SQLException e1)
	    {
	      e1.printStackTrace();
	    }
	    closeConnection();
	  }
	}