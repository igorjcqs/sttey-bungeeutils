package me.igormgs;

import java.sql.SQLException;
import java.util.HashMap;

import me.igormgs.db.MySQLManager;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Eventos implements Listener {
	
	public static HashMap<String, Long> timeout = new HashMap<String, Long>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void falarChat(ChatEvent e) {
		ProxiedPlayer p = (ProxiedPlayer)e.getSender();
		try {
			if(MySQLManager.getStatusStaffChat(p) == 1) {
				for(ProxiedPlayer todos : BungeeCord.getInstance().getPlayers()) {
					if(MySQLManager.getRank(todos) == 9) {
						todos.sendMessage("§b§lSTAFFCHAT§f " + MySQLManager.verificarTag(p) + " §f" + p.getName() + " (§a§l" + p.getServer().getInfo().getName() + "§f) §e» §f"+ e.getMessage());
					}
					if(MySQLManager.getRank(todos) == 10) {
						todos.sendMessage("§b§lSTAFFCHAT§f " + MySQLManager.verificarTag(p) + " §f" + p.getName() + " (§a§l" + p.getServer().getInfo().getName() + "§f) §e» §f"+ e.getMessage());
					}
					if(MySQLManager.getRank(todos) == 11) {
						todos.sendMessage("§b§lSTAFFCHAT§f " + MySQLManager.verificarTag(p) + " §f" + p.getName() + " (§a§l" + p.getServer().getInfo().getName() + "§f) §e» §f"+ e.getMessage());
					}
					if(MySQLManager.getRank(todos) == 12) {
						todos.sendMessage("§b§lSTAFFCHAT§f " + MySQLManager.verificarTag(p) + " §f" + p.getName() + " (§a§l" + p.getServer().getInfo().getName() + "§f) §e» §f"+ e.getMessage());
					}
					if(MySQLManager.getRank(todos) == 13) {
						todos.sendMessage("§b§lSTAFFCHAT§f " + MySQLManager.verificarTag(p) + " §f" + p.getName() + " (§a§l" + p.getServer().getInfo().getName() + "§f) §e» §f"+ e.getMessage());
					}
					if(MySQLManager.getRank(todos) == 14) {
						todos.sendMessage("§b§lSTAFFCHAT§f " + MySQLManager.verificarTag(p) + " §f" + p.getName() + " (§a§l" + p.getServer().getInfo().getName() + "§f) §e» §f"+ e.getMessage());
					}
					if(MySQLManager.getRank(todos) == 15) {
						todos.sendMessage("§b§lSTAFFCHAT§f " + MySQLManager.verificarTag(p) + " §f" + p.getName() + " (§a§l" + p.getServer().getInfo().getName() + "§f) §e» §f"+ e.getMessage());
					}
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}