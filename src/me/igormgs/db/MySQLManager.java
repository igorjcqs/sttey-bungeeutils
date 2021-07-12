package me.igormgs.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.flyingblock.pcm.PcmMain;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class MySQLManager {
	
	  public static PcmMain plugin;
	  
	  @SuppressWarnings("static-access")
	public MySQLManager(PcmMain plugin2) {
		  this.plugin = plugin2;
	  }
	  
	  public static MySQL db = new MySQL(plugin, PcmMain.SQL_HOST, PcmMain.SQL_PORT, PcmMain.SQL_DATA, PcmMain.SQL_USER, PcmMain.SQL_PASS);
	  
	  public static void setupSQL()
	    throws SQLException{
	      db.openConnection();
	      plugin.database = true;
	    }
	  
	  public void closeDB() {
		   db.closeConnection();
	  }
	  
	  public static String getSenha(ProxiedPlayer p) throws SQLException {
		String name = p.getUniqueId().toString();
		 if (!db.checkConnection()) {
		   db.openConnection();
		 }
		 Statement s = db.getConnection().createStatement();
		 ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + name + "';");
		 if (!rs.next()) {
		   return "NAO";
		 }
		 String retorno = rs.getString("senha");
		    
		 return retorno;
	  }
	  
	  public static String getPrimeiroLogin(ProxiedPlayer p) throws SQLException {
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			 ResultSet rs = s.executeQuery("SELECT * FROM loginsfirst WHERE `uuid`='" + p.getUniqueId() + "';");
			 if (!rs.next()) {
			   return "ERROR";
			 }
			 String retorno = rs.getString("dia");
			 
			 String retorno2 = rs.getString("mes");
			 
			 String retorno3 = rs.getString("ano");
			    
			 String retorno4 = rs.getString("hora");
			 
			 String retorno5 = rs.getString("minutos");
			 
			 return retorno + " de " + retorno2 + " de " + retorno3 + " ás " + retorno4 + ":" + retorno5;
		  }
	  
	  public static int getBan(ProxiedPlayer p) throws SQLException {
			String name = p.getUniqueId().toString();
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			 ResultSet rs = s.executeQuery("SELECT * FROM dados_punicoes WHERE `uuid`='" + name + "';");
			 if (!rs.next()) {
			   return 0;
			 }
			 int retorno = rs.getInt("stats_ban");
			    
			 return retorno;
		  }
	  
	  public static String getMotivo(ProxiedPlayer p) throws SQLException {
			String name = p.getUniqueId().toString();
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			 ResultSet rs = s.executeQuery("SELECT * FROM dados_punicoes WHERE `uuid`='" + name + "';");
			 if (!rs.next()) {
			   return "NENHUM";
			 }
			 String retorno = rs.getString("motivo");
			    
			 return retorno;
		  }
	  
	  public static String getResponsavel(ProxiedPlayer p) throws SQLException {
			String name = p.getUniqueId().toString();
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			 ResultSet rs = s.executeQuery("SELECT * FROM dados_punicoes WHERE `uuid`='" + name + "';");
			 if (!rs.next()) {
			   return "NENHUM";
			 }
			 String retorno = rs.getString("responsavel");
			    
			 return retorno;
		  }
	  
	  public static void updateBan(ProxiedPlayer p, int status) throws SQLException {
			String name = p.getUniqueId().toString();
			if (!db.checkConnection()) {
			  db.openConnection();
			}
		    Statement s = db.getConnection().createStatement();
			s.executeUpdate("UPDATE dados_punicoes SET `stats_ban`='" + status + "' WHERE `uuid`='" + name + "';");
		  }
	  
	  public static void updateDataBan(ProxiedPlayer p, String data) throws SQLException {
			String name = p.getUniqueId().toString();
			if (!db.checkConnection()) {
			  db.openConnection();
			}
		    Statement s = db.getConnection().createStatement();
			s.executeUpdate("UPDATE dados_punicoes SET `data_ban`='" + data + "' WHERE `uuid`='" + name + "';");
		  }
	  
	  public static void updateDataMute(ProxiedPlayer p, String data) throws SQLException {
			String name = p.getUniqueId().toString();
			if (!db.checkConnection()) {
			  db.openConnection();
			}
		    Statement s = db.getConnection().createStatement();
			s.executeUpdate("UPDATE dados_punicoes SET `data_mute`='" + data + "' WHERE `uuid`='" + name + "';");
		  }
	  
	  public static void updateMotivo(ProxiedPlayer p, String motivo) throws SQLException {
			String name = p.getUniqueId().toString();
			if (!db.checkConnection()) {
			  db.openConnection();
			}
		    Statement s = db.getConnection().createStatement();
			s.executeUpdate("UPDATE dados_punicoes SET `motivo`='" + motivo + "' WHERE `uuid`='" + name + "';");
		  }
	  
	  public static void updateResponsavel(ProxiedPlayer p, String responsavel) throws SQLException {
			String name = p.getUniqueId().toString();
			if (!db.checkConnection()) {
			  db.openConnection();
			}
		    Statement s = db.getConnection().createStatement();
			s.executeUpdate("UPDATE dados_punicoes SET `responsavel`='" + responsavel + "' WHERE `uuid`='" + name + "';");
		  }
	  
	  public static void updateMute(ProxiedPlayer p, int status) throws SQLException {
			String name = p.getUniqueId().toString();
			if (!db.checkConnection()) {
			  db.openConnection();
			}
		    Statement s = db.getConnection().createStatement();
			s.executeUpdate("UPDATE dados_punicoes SET `stats_mute`='" + status + "' WHERE `uuid`='" + name + "';");
		  }
	  
	  public static void updateMotivoMute(ProxiedPlayer p, String motivo) throws SQLException {
			String name = p.getUniqueId().toString();
			if (!db.checkConnection()) {
			  db.openConnection();
			}
		    Statement s = db.getConnection().createStatement();
			s.executeUpdate("UPDATE dados_punicoes SET `motivo_mute`='" + motivo + "' WHERE `uuid`='" + name + "';");
		  }
	  
	  public static void updateResponsavelMute(ProxiedPlayer p, String responsavel) throws SQLException {
			String name = p.getUniqueId().toString();
			if (!db.checkConnection()) {
			  db.openConnection();
			}
		    Statement s = db.getConnection().createStatement();
			s.executeUpdate("UPDATE dados_punicoes SET `responsavel_mute`='" + responsavel + "' WHERE `uuid`='" + name + "';");
		  }
	  
	  public static int getRank(ProxiedPlayer p) throws SQLException {
			String name = p.getUniqueId().toString();
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			 ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + name + "';");
			 if (!rs.next()) {
			   return 0;
			 }
			 int retorno = rs.getInt("rank");
			    
			 return retorno;
		  }
	  
	  public static String getMotivoMute(ProxiedPlayer p) throws SQLException {
			String name = p.getUniqueId().toString();
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			 ResultSet rs = s.executeQuery("SELECT * FROM dados_punicoes WHERE `uuid`='" + name + "';");
			 if (!rs.next()) {
			   return "NENHUM";
			 }
			 String retorno = rs.getString("motivo_mute");
			    
			 return retorno;
		  }
	  
	  public static String getResponsavelMute(ProxiedPlayer p) throws SQLException {
			String name = p.getUniqueId().toString();
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			 ResultSet rs = s.executeQuery("SELECT * FROM dados_punicoes WHERE `uuid`='" + name + "';");
			 if (!rs.next()) {
			   return "NENHUM";
			 }
			 String retorno = rs.getString("responsavel_mute");
			    
			 return retorno;
		  }
	  
	  public static int getMute(ProxiedPlayer p) throws SQLException {
			String name = p.getUniqueId().toString();
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			 ResultSet rs = s.executeQuery("SELECT * FROM dados_punicoes WHERE `uuid`='" + name + "';");
			 if (!rs.next()) {
			   return 0;
			 }
			 int retorno = rs.getInt("stats_mute");
			    
			 return retorno;
		  }
	  
	  public static String verificarTag(ProxiedPlayer p) {
		  try {
			if(MySQLManager.getRank(p) == 0) {
				return "§7§lMEMBRO";
			}
			if(MySQLManager.getRank(p) == 1) {
				return "§a§lVIP";
			}
			if(MySQLManager.getRank(p) == 2) {
				return "§e§lVIP+";
			}
			if(MySQLManager.getRank(p) == 3) {
				return "§6§lPRO";
			}
			if(MySQLManager.getRank(p) == 4) {
				return "§d§lULTRA";
			}
			if(MySQLManager.getRank(p) == 5) {
				return "§1§lBETA";
			}
			if(MySQLManager.getRank(p) == 6) {
				return "§3§lSTTEY";
			}
			if(MySQLManager.getRank(p) == 7) {
				return "§b§lYOUTUBER";
			}
			if(MySQLManager.getRank(p) == 8) {
				return "§3§lYOUTUBER+";
			}
			if(MySQLManager.getRank(p) == 9) {
				return "§2§lHELPER";
			}
			if(MySQLManager.getRank(p) == 10) {
				return "§d§lBUILDER";
			}
			if(MySQLManager.getRank(p) == 11) {
				return "§d§lTRIAL";
			}
			if(MySQLManager.getRank(p) == 12) {
				return "§5§lMOD";
			}
			if(MySQLManager.getRank(p) == 13) {
				return "§c§lADM";
			}
			if(MySQLManager.getRank(p) == 14) {
				return "§4§lCEO";
			}
			if(MySQLManager.getRank(p) == 15) {
				return "§4§lCTI";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "MEMBRO";
	  }
	  
	  public static int getStatusStaffChat(ProxiedPlayer p) throws SQLException {
		  String uuid = p.getUniqueId().toString();
			 if (!db.checkConnection()) {
			   db.openConnection();
			 }
			 Statement s = db.getConnection().createStatement();
			    ResultSet rs = s.executeQuery("SELECT * FROM dados_lobby WHERE `uuid`='" + uuid + "';");
			 if (!rs.next()) {
			   return 0;
			 }
			 int retorno = rs.getInt("staffchat");
			    
			 return retorno;
		  }
	  
	  public static void updateStaffChat(ProxiedPlayer p, int status) throws SQLException {
		String name = p.getUniqueId().toString();
		if (!db.checkConnection()) {
		  db.openConnection();
		}
	    Statement s = db.getConnection().createStatement();
		s.executeUpdate("UPDATE dados_lobby SET `staffchat`='" + status + "' WHERE `uuid`='" + name + "';");
	  }
}