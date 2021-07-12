package me.igormgs;

import java.sql.SQLException;

import me.igormgs.db.MySQLManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class accountCommand extends Command {
	
	public accountCommand() {
		super("account");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender parametroSender, String[] parametroStrings) {
		ProxiedPlayer parametroJogador = (ProxiedPlayer)parametroSender;
		if(parametroSender instanceof ProxiedPlayer) {
			parametroJogador.sendMessage("§f§m------------------§f §6§lACCOUNT§f§m------------------");
			parametroJogador.sendMessage(" ");
			parametroJogador.sendMessage(" §fInformações:");
			parametroJogador.sendMessage(" ");
			parametroJogador.sendMessage(" §a● §fUUID: " + parametroJogador.getUUID());
			parametroJogador.sendMessage(" §a● §fIP: " + parametroJogador.getAddress().getHostString());
			try {
				parametroJogador.sendMessage(" §a● §fPrimeiro Login: " + MySQLManager.getPrimeiroLogin(parametroJogador));
				parametroJogador.sendMessage(" §a● §fSenha: §5§n" + MySQLManager.getSenha(parametroJogador));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(MySQLManager.getMute(parametroJogador) == 1) {
					parametroJogador.sendMessage(" §a● §fPunições Registradas(1): §eMUTE");
				} else if(MySQLManager.getMute(parametroJogador) == 0) {
					parametroJogador.sendMessage(" §a● §fPunições Registradas(0): §eNENHUMA");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			parametroJogador.sendMessage(" ");
			parametroJogador.sendMessage("§f§m--------------------------------------------");
		} else {
			System.out.println("APENAS JOGADORES");
		}
	}

}