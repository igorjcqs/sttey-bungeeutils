package me.igormgs;

import java.sql.SQLException;

import me.igormgs.db.MySQLManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class staffchatLEAVEBungee extends Command {

	public staffchatLEAVEBungee() {
		super("scsair");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender parametroSender, String[] parametroArgumentos) {
		if(parametroSender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer)parametroSender;
			if(parametroArgumentos.length == 0) {
				try {
					if(MySQLManager.getRank(p) == 15) {
						if(MySQLManager.getStatusStaffChat(p) == 1) {
							p.sendMessage("§b§lSTAFFCHAT §fO seu chat foi definido como §e§lCOMUM§f caso queira entrar no modo §e§n§lSTAFFCHAT§f, digite: /§a§n§lSCENTRAR§f.");
							MySQLManager.updateStaffChat(p, 0);
						}
					} else if(MySQLManager.getRank(p) == 14) {
						if(MySQLManager.getStatusStaffChat(p) == 1) {
							p.sendMessage("§b§lSTAFFCHAT §fO seu chat foi definido como §e§lCOMUM§f caso queira entrar no modo §e§n§lSTAFFCHAT§f, digite: /§a§n§lSCENTRAR§f.");
							MySQLManager.updateStaffChat(p, 0);
						}
					} else  if(MySQLManager.getRank(p) == 13) {
						if(MySQLManager.getStatusStaffChat(p) == 1) {
							p.sendMessage("§b§lSTAFFCHAT §fO seu chat foi definido como §e§lCOMUM§f caso queira entrar no modo §e§n§lSTAFFCHAT§f, digite: /§a§n§lSCENTRAR§f.");
							MySQLManager.updateStaffChat(p, 0);
						}
					} else if(MySQLManager.getRank(p) == 12) {
						if(MySQLManager.getStatusStaffChat(p) == 1) {
							p.sendMessage("§b§lSTAFFCHAT §fO seu chat foi definido como §e§lCOMUM§f caso queira entrar no modo §e§n§lSTAFFCHAT§f, digite: /§a§n§lSCENTRAR§f.");
							MySQLManager.updateStaffChat(p, 0);
						}
					} else if(MySQLManager.getRank(p) == 11) {
						if(MySQLManager.getStatusStaffChat(p) == 1) {
							p.sendMessage("§b§lSTAFFCHAT §fO seu chat foi definido como §e§lCOMUM§f caso queira entrar no modo §e§n§lSTAFFCHAT§f, digite: /§a§n§lSCENTRAR§f.");
							MySQLManager.updateStaffChat(p, 0);
						}
					} else if(MySQLManager.getRank(p) == 10) {
						if(MySQLManager.getStatusStaffChat(p) == 1) {
							p.sendMessage("§b§lSTAFFCHAT §fO seu chat foi definido como §e§lCOMUM§f caso queira entrar no modo §e§n§lSTAFFCHAT§f, digite: /§a§n§lSCENTRAR§f.");
							MySQLManager.updateStaffChat(p, 0);
						}
					}else
					if(MySQLManager.getRank(p) == 9) {
						if(MySQLManager.getStatusStaffChat(p) == 1) {
							p.sendMessage("§b§lSTAFFCHAT §fO seu chat foi definido como §e§lCOMUM§f caso queira entrar no modo §e§n§lSTAFFCHAT§f, digite: /§a§n§lSCENTRAR§f.");
							MySQLManager.updateStaffChat(p, 0);
						}
					}else
					if(MySQLManager.getRank(p) == 8) {
					    p.sendMessage("§6§lCHAT §fComando não encontrado.");
					}else
					if(MySQLManager.getRank(p) == 7) {
					    p.sendMessage("§6§lCHAT §fComando não encontrado.");
					}else
					if(MySQLManager.getRank(p) == 6) {
					    p.sendMessage("§6§lCHAT §fComando não encontrado.");
					}else
					if(MySQLManager.getRank(p) == 5) {
					    p.sendMessage("§6§lCHAT §fComando não encontrado.");
					}else
					if(MySQLManager.getRank(p) == 4) {
					    p.sendMessage("§6§lCHAT §fComando não encontrado.");
					}else
					if(MySQLManager.getRank(p) == 3) {
					    p.sendMessage("§6§lCHAT §fComando não encontrado.");
					}else
					if(MySQLManager.getRank(p) == 2) {
					    p.sendMessage("§6§lCHAT §fComando não encontrado.");
					}else
					if(MySQLManager.getRank(p) == 1) {
					    p.sendMessage("§6§lCHAT §fComando não encontrado.");
					}else
					if(MySQLManager.getRank(p) == 0) {
					    p.sendMessage("§6§lCHAT §fComando não encontrado.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(parametroArgumentos.length >= 1) {
				p.sendMessage("bleh");
			} 
	   }
	}

}
