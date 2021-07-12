package me.igormgs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.flyingblock.pcm.PcmMain;

import me.igormgs.db.MySQLManager;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class reportCommand extends Command {
	
	private static ArrayList<ProxiedPlayer> reported = new ArrayList<ProxiedPlayer>();
	
	public reportCommand() {
		super("report");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender parametroSender, String[] parametroArgumentos) {
		ProxiedPlayer parametroJogador = (ProxiedPlayer)parametroSender;
		if(parametroSender instanceof ProxiedPlayer) {
			if(parametroArgumentos.length <= 1) {
				parametroJogador.sendMessage("§a§lREPORT §fUtilize: /§eREPORT §f(§eJOGADOR§f) (§eMOTIVO§f).");
			} else {
				ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
				if(!reported.contains(parametroJogador)) {
					if(alvo == null) {
						parametroJogador.sendMessage("§a§lREPORT §fJogador não encontrado.");
					} else if(alvo.getName() == parametroJogador.getName()) {
						parametroJogador.sendMessage("§a§lREPORT §fVocê não pode reportar a si mesmo.");
					} else {
						String Motivo = "";
						for (int i = 1; i < parametroArgumentos.length; i++) {
							Motivo = Motivo + parametroArgumentos[i] + " ";
						}
						reported.add(parametroJogador);
						parametroJogador.sendMessage("§a§lREPORT §fJogador reportado.");
						for(ProxiedPlayer jogadoresOnline : BungeeCord.getInstance().getPlayers()) {
							try {
								if(MySQLManager.getRank(jogadoresOnline) >= 9) {
									parametroJogador.sendMessage("§f§m------------------§f §c§lREPORT§f§m------------------");
									parametroJogador.sendMessage(" ");
									parametroJogador.sendMessage(" §fInformações Report:");
									parametroJogador.sendMessage(" ");
									parametroJogador.sendMessage(" §a● §fEnviado por: §e" + parametroJogador.getName() + "§f;");
									parametroJogador.sendMessage(" §a● §fUUID(§b" + parametroJogador.getName() + "§f): §e" + parametroJogador.getUUID() + "§f;");
									parametroJogador.sendMessage(" §a● §fServidor de Origem: §a§l" + parametroJogador.getServer().getInfo().getName() + "§f;");
									parametroJogador.sendMessage(" ");
									parametroJogador.sendMessage(" §fInformações Reportado:");
									parametroJogador.sendMessage(" ");
									parametroJogador.sendMessage(" §a● §fReportado: §e" + alvo.getName() + "§f;");
									parametroJogador.sendMessage(" §a● §fMotivo do Report: §e" + Motivo + "§f;");
									parametroJogador.sendMessage(" §a● §fServidor: §a§l" + alvo.getServer().getInfo().getName() + "§f.");
									parametroJogador.sendMessage(" ");
									parametroJogador.sendMessage("§e- Clique §f§lAQUI §f§epara ir até o jogador.");
									parametroJogador.sendMessage(" ");
									parametroJogador.sendMessage("§f§m-----------------------------------------");
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						BungeeCord.getInstance().getScheduler().schedule(PcmMain.plugin, new Runnable() {
							
							@Override
							public void run() {
								reported.remove(parametroJogador);
							}
						}, 1, TimeUnit.MINUTES);
					}
				} else {
					parametroJogador.sendMessage("§a§lREPORT §fVocê já reportou um jogador, espere para reportar outro.");
			  }
			}
		} else {
			System.out.println("Apenas jogadores.");
			return;
		}
	}

}