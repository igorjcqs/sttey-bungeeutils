package me.igormgs;

import java.sql.SQLException;

import me.igormgs.db.MySQLManager;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class kickCommand extends Command {
	
	public kickCommand() {
		super("kick");
	}
	

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender parametroSender, String[] parametroArgumentos) {
		ProxiedPlayer parametroJogador = (ProxiedPlayer)parametroSender;
			try {
				if(MySQLManager.getRank(parametroJogador) == 15) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length > 2) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length == 2) {
						ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						if(alvo == null) {
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador indisponível.");
						} else {
							String Motivo = "";
							for (int i = 1; i < parametroArgumentos.length; i++) {
								Motivo = Motivo + parametroArgumentos[i] + " ";
							}
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador kicado!");
							BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lKICADO!\n\n§fVocê foi kicado da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "");
						}
					}
				} else 	if(MySQLManager.getRank(parametroJogador) == 14) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length > 2) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length == 2) {
						ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						if(alvo == null) {
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador indisponível.");
						} else {
							String Motivo = "";
							for (int i = 1; i < parametroArgumentos.length; i++) {
								Motivo = Motivo + parametroArgumentos[i] + " ";
							}
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador kicado!");
							BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lKICADO!\n\n§fVocê foi kicado da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "");
						}
					}
				} else if(MySQLManager.getRank(parametroJogador) == 13) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length > 2) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length == 2) {
						ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						if(alvo == null) {
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador indisponível.");
						} else {
							String Motivo = "";
							for (int i = 1; i < parametroArgumentos.length; i++) {
								Motivo = Motivo + parametroArgumentos[i] + " ";
							}
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador kicado!");
							BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lKICADO!\n\n§fVocê foi kicado da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "");
						}
					}
				} else if(MySQLManager.getRank(parametroJogador) == 12) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length > 2) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length == 2) {
						ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						if(alvo == null) {
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador indisponível.");
						} else {
							String Motivo = "";
							for (int i = 1; i < parametroArgumentos.length; i++) {
								Motivo = Motivo + parametroArgumentos[i] + " ";
							}
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador kicado!");
							BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lKICADO!\n\n§fVocê foi kicado da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "");
						}
					}
				} else if(MySQLManager.getRank(parametroJogador) == 11) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length > 2) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length == 2) {
						ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						if(alvo == null) {
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador indisponível.");
						} else {
							String Motivo = "";
							for (int i = 1; i < parametroArgumentos.length; i++) {
								Motivo = Motivo + parametroArgumentos[i] + " ";
							}
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador kicado!");
							BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lKICADO!\n\n§fVocê foi kicado da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "");
						}
					}
				} else if(MySQLManager.getRank(parametroJogador) == 10) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length > 2) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length == 2) {
						ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						if(alvo == null) {
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador indisponível.");
						} else {
							String Motivo = "";
							for (int i = 1; i < parametroArgumentos.length; i++) {
								Motivo = Motivo + parametroArgumentos[i] + " ";
							}
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador kicado!");
							BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lKICADO!\n\n§fVocê foi kicado da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "");
						}
					}
				} else if(MySQLManager.getRank(parametroJogador) == 9) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length > 2) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eKICK §f(§eJOGADOR§f) §f(§eMOTIVO§f).");
					} else if(parametroArgumentos.length == 2) {
						ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						if(alvo == null) {
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador indisponível.");
						} else {
							String Motivo = "";
							for (int i = 1; i < parametroArgumentos.length; i++) {
								Motivo = Motivo + parametroArgumentos[i] + " ";
							}
							parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador kicado!");
							BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lKICADO!\n\n§fVocê foi kicado da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "");
						}
					}
				}else if(MySQLManager.getRank(parametroJogador) == 8) {
				    parametroJogador.sendMessage("§a§lCHAT §fComando não encontrado.");
				} else if(MySQLManager.getRank(parametroJogador) == 7) {
				    parametroJogador.sendMessage("§a§lCHAT §fComando não encontrado.");
				} else if(MySQLManager.getRank(parametroJogador) == 6) {
				    parametroJogador.sendMessage("§a§lCHAT §fComando não encontrado.");
				} else if(MySQLManager.getRank(parametroJogador) == 5) {
				    parametroJogador.sendMessage("§a§lCHAT §fComando não encontrado.");
				} else if(MySQLManager.getRank(parametroJogador) == 4) {
				    parametroJogador.sendMessage("§a§lCHAT §fComando não encontrado.");
				} else if(MySQLManager.getRank(parametroJogador) == 3) {
				    parametroJogador.sendMessage("§a§lCHAT §fComando não encontrado.");
				} else if(MySQLManager.getRank(parametroJogador) == 2) {
				    parametroJogador.sendMessage("§a§lCHAT §fComando não encontrado.");
				} else if(MySQLManager.getRank(parametroJogador) == 1) {
				    parametroJogador.sendMessage("§a§lCHAT §fComando não encontrado.");
				} else if(MySQLManager.getRank(parametroJogador) == 0) {
				    parametroJogador.sendMessage("§a§lCHAT §fComando não encontrado.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}