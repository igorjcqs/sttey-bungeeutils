package me.igormgs;

import java.sql.SQLException;

import com.flyingblock.pcm.PcmMain;

import me.igormgs.db.MySQLManager;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class banCommand extends Command {
	
	public banCommand() {
		super("ban");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender parametroSender, String[] parametroArgumentos) {
		ProxiedPlayer parametroJogador = (ProxiedPlayer)parametroSender;
			try {
				if(MySQLManager.getRank(parametroJogador) == 15) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eBAN §f(§eJOGADOR§f) (§eMOTIVO§f).");
					} else if(parametroArgumentos.length >= 2) {
						  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						  if(alvo == null) {
							  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
						  } else {
								if(MySQLManager.getBan(alvo) == 0) {
									String Motivo = "";
									for (int i = 1; i < parametroArgumentos.length; i++) {
										Motivo = Motivo + parametroArgumentos[i] + " ";
									}
							        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
							        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi banido §c§lPERMANENTIMENTE§f da rede §b§lSTTEY§f§lMC§f. ");
							        }
							        BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lPUNIDO!\n\n§fVocê foi §e§lPERMANENTIMENTE§f banido da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "\n§fData: §3" + PcmMain.getDia() + " de " + PcmMain.getMeses() + " de " + PcmMain.getAno() + " ás " + PcmMain.getHora() + ":" + PcmMain.getMinutos() + "\n\n§fAcha que cometemos um §c§lERRO§f? \n§fSolicite §e§lAPPEAL §fem nosso discord: §awww.stteymc.com/discord\n§fou compre unban em nossa loja, §awww.stteymc.com/loja");
							        MySQLManager.updateBan(alvo, 1);
							        MySQLManager.updateMotivo(alvo, Motivo);
							        MySQLManager.updateResponsavel(alvo, parametroJogador.getName());
							        MySQLManager.updateDataBan(alvo, PcmMain.getDia() + " de " + PcmMain.getMeses() + " de " + PcmMain.getAno() + " ás " + PcmMain.getHora() + ":" + PcmMain.getMinutos());
								} else if(MySQLManager.getBan(alvo) == 1) {
									parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está banido.");
								}
						  }
					}
				} else 	if(MySQLManager.getRank(parametroJogador) == 14) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eBAN §f(§eJOGADOR§f) (§eMOTIVO§f).");
					} else if(parametroArgumentos.length >= 2) {
						  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						  if(alvo == null) {
							  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
						  } else {
								if(MySQLManager.getBan(alvo) == 0) {
									String Motivo = "";
									for (int i = 1; i < parametroArgumentos.length; i++) {
										Motivo = Motivo + parametroArgumentos[i] + " ";
									}
							        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
							        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi banido §c§lPERMANENTIMENTE§f da rede §b§lSTTEY§f§lMC§f. ");
							        }
							        BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lPUNIDO!\n\n§fVocê foi §c§lPERMANENTIMENTE§f banido da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "\n§fData: §319§f/§312§f/§32003\n§fHorário: §312§f:§330\n\n§fAcha que cometemos um §c§lERRO§f? \n§fSolicite §e§lAPPEAL §fem nosso discord: §awww.stteymc.com/discord\n§fou compre unban em nossa loja, §awww.stteymc.com/loja");
							        MySQLManager.updateBan(alvo, 1);
							        MySQLManager.updateMotivo(alvo, Motivo);
							        MySQLManager.updateResponsavel(alvo, parametroJogador.getName());
								} else if(MySQLManager.getBan(alvo) == 1) {
									parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está banido.");
								}
						  }
					}
				} else if(MySQLManager.getRank(parametroJogador) == 13) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eBAN §f(§eJOGADOR§f) (§eMOTIVO§f).");
					} else if(parametroArgumentos.length >= 2) {
						  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						  if(alvo == null) {
							  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
						  } else {
								if(MySQLManager.getBan(alvo) == 0) {
									String Motivo = "";
									for (int i = 1; i < parametroArgumentos.length; i++) {
										Motivo = Motivo + parametroArgumentos[i] + " ";
									}
							        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
							        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi banido §c§lPERMANENTIMENTE§f da rede §b§lSTTEY§f§lMC§f. ");
							        }
							        BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lPUNIDO!\n\n§fVocê foi §c§lPERMANENTIMENTE§f banido da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "\n§fData: §319§f/§312§f/§32003\n§fHorário: §312§f:§330\n\n§fAcha que cometemos um §c§lERRO§f? \n§fSolicite §e§lAPPEAL §fem nosso discord: §awww.stteymc.com/discord\n§fou compre unban em nossa loja, §awww.stteymc.com/loja");
							        MySQLManager.updateBan(alvo, 1);
							        MySQLManager.updateMotivo(alvo, Motivo);
							        MySQLManager.updateResponsavel(alvo, parametroJogador.getName());
								} else if(MySQLManager.getBan(alvo) == 1) {
									parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está banido.");
								}
						  }
					}
				} else if(MySQLManager.getRank(parametroJogador) == 12) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eBAN §f(§eJOGADOR§f) (§eMOTIVO§f).");
					} else if(parametroArgumentos.length >= 2) {
						  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						  if(alvo == null) {
							  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
						  } else {
								if(MySQLManager.getBan(alvo) == 0) {
									String Motivo = "";
									for (int i = 1; i < parametroArgumentos.length; i++) {
										Motivo = Motivo + parametroArgumentos[i] + " ";
									}
							        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
							        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi banido §c§lPERMANENTIMENTE§f da rede §b§lSTTEY§f§lMC§f. ");
							        }
							        BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lPUNIDO!\n\n§fVocê foi §c§lPERMANENTIMENTE§f banido da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "\n§fData: §319§f/§312§f/§32003\n§fHorário: §312§f:§330\n\n§fAcha que cometemos um §c§lERRO§f? \n§fSolicite §e§lAPPEAL §fem nosso discord: §awww.stteymc.com/discord\n§fou compre unban em nossa loja, §awww.stteymc.com/loja");
							        MySQLManager.updateBan(alvo, 1);
							        MySQLManager.updateMotivo(alvo, Motivo);
							        MySQLManager.updateResponsavel(alvo, parametroJogador.getName());
								} else if(MySQLManager.getBan(alvo) == 1) {
									parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está banido.");
								}
						  }
					}
				} else if(MySQLManager.getRank(parametroJogador) == 11) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eBAN §f(§eJOGADOR§f) (§eMOTIVO§f).");
					} else if(parametroArgumentos.length >= 2) {
						  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						  if(alvo == null) {
							  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
						  } else {
								if(MySQLManager.getBan(alvo) == 0) {
									String Motivo = "";
									for (int i = 1; i < parametroArgumentos.length; i++) {
										Motivo = Motivo + parametroArgumentos[i] + " ";
									}
							        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
							        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi banido §c§lPERMANENTIMENTE§f da rede §b§lSTTEY§f§lMC§f. ");
							        }
							        BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lPUNIDO!\n\n§fVocê foi §c§lPERMANENTIMENTE§f banido da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "\n§fData: §319§f/§312§f/§32003\n§fHorário: §312§f:§330\n\n§fAcha que cometemos um §c§lERRO§f? \n§fSolicite §e§lAPPEAL §fem nosso discord: §awww.stteymc.com/discord\n§fou compre unban em nossa loja, §awww.stteymc.com/loja");
							        MySQLManager.updateBan(alvo, 1);
							        MySQLManager.updateMotivo(alvo, Motivo);
							        MySQLManager.updateResponsavel(alvo, parametroJogador.getName());
								} else if(MySQLManager.getBan(alvo) == 1) {
									parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está banido.");
								}
						  }
					}
				} else if(MySQLManager.getRank(parametroJogador) == 11) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eBAN §f(§eJOGADOR§f) (§eMOTIVO§f).");
					} else if(parametroArgumentos.length >= 2) {
						  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						  if(alvo == null) {
							  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
						  } else {
								if(MySQLManager.getBan(alvo) == 0) {
									String Motivo = "";
									for (int i = 1; i < parametroArgumentos.length; i++) {
										Motivo = Motivo + parametroArgumentos[i] + " ";
									}
							        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
							        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi banido §c§lPERMANENTIMENTE§f da rede §b§lSTTEY§f§lMC§f. ");
							        }
							        BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lPUNIDO!\n\n§fVocê foi §c§lPERMANENTIMENTE§f banido da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "\n§fData: §319§f/§312§f/§32003\n§fHorário: §312§f:§330\n\n§fAcha que cometemos um §c§lERRO§f? \n§fSolicite §e§lAPPEAL §fem nosso discord: §awww.stteymc.com/discord\n§fou compre unban em nossa loja, §awww.stteymc.com/loja");
							        MySQLManager.updateBan(alvo, 1);
							        MySQLManager.updateMotivo(alvo, Motivo);
							        MySQLManager.updateResponsavel(alvo, parametroJogador.getName());
								} else if(MySQLManager.getBan(alvo) == 1) {
									parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está banido.");
								}
						  }
					}
				} else if(MySQLManager.getRank(parametroJogador) == 10) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eBAN §f(§eJOGADOR§f) (§eMOTIVO§f).");
					} else if(parametroArgumentos.length >= 2) {
						  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						  if(alvo == null) {
							  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
						  } else {
								if(MySQLManager.getBan(alvo) == 0) {
									String Motivo = "";
									for (int i = 1; i < parametroArgumentos.length; i++) {
										Motivo = Motivo + parametroArgumentos[i] + " ";
									}
							        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
							        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi banido §c§lPERMANENTIMENTE§f da rede §b§lSTTEY§f§lMC§f. ");
							        }
							        BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lPUNIDO!\n\n§fVocê foi §c§lPERMANENTIMENTE§f banido da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "\n§fData: §319§f/§312§f/§32003\n§fHorário: §312§f:§330\n\n§fAcha que cometemos um §c§lERRO§f? \n§fSolicite §e§lAPPEAL §fem nosso discord: §awww.stteymc.com/discord\n§fou compre unban em nossa loja, §awww.stteymc.com/loja");
							        MySQLManager.updateBan(alvo, 1);
							        MySQLManager.updateMotivo(alvo, Motivo);
							        MySQLManager.updateResponsavel(alvo, parametroJogador.getName());
								} else if(MySQLManager.getBan(alvo) == 1) {
									parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está banido.");
								}
						  }
					}
				} else if(MySQLManager.getRank(parametroJogador) == 9) {
					if(parametroArgumentos.length <= 1) {
						parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eBAN §f(§eJOGADOR§f) (§eMOTIVO§f).");
					} else if(parametroArgumentos.length >= 2) {
						  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
						  if(alvo == null) {
							  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
						  } else {
								if(MySQLManager.getBan(alvo) == 0) {
									String Motivo = "";
									for (int i = 1; i < parametroArgumentos.length; i++) {
										Motivo = Motivo + parametroArgumentos[i] + " ";
									}
							        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
							        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi banido §c§lPERMANENTIMENTE§f da rede §b§lSTTEY§f§lMC§f. ");
							        }
							        BungeeCord.getInstance().getPlayer(alvo.getName()).disconnect("§4§n§lPUNIDO!\n\n§fVocê foi §c§lPERMANENTIMENTE§f banido da rede §b§lSTTEY§f§lMC§f.\n\n§fMotivo: §3" + Motivo + " \n§fStaff Responsável: §3" + parametroJogador.getName() + "\n§fData: §319§f/§312§f/§32003\n§fHorário: §312§f:§330\n\n§fAcha que cometemos um §c§lERRO§f? \n§fSolicite §e§lAPPEAL §fem nosso discord: §awww.stteymc.com/discord\n§fou compre unban em nossa loja, §awww.stteymc.com/loja");
							        MySQLManager.updateBan(alvo, 1);
							        MySQLManager.updateMotivo(alvo, Motivo);
							        MySQLManager.updateResponsavel(alvo, parametroJogador.getName());
								} else if(MySQLManager.getBan(alvo) == 1) {
									parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está banido.");
								}
						  }
					}
				} else if(MySQLManager.getRank(parametroJogador) == 9) {
				    parametroJogador.sendMessage("§a§lCHAT §fComando não encontrado.");
				} else if(MySQLManager.getRank(parametroJogador) == 8) {
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