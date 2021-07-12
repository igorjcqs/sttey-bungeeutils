package me.igormgs;

import java.sql.SQLException;

import me.igormgs.db.MySQLManager;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class muteCommand extends Command {
	
	public muteCommand() {
		super("mute");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender parametroSender, String[] parametroArgumentos) {
		ProxiedPlayer parametroJogador = (ProxiedPlayer)parametroSender;
		try {
			if(MySQLManager.getRank(parametroJogador) == 15) {
				if(parametroArgumentos.length <= 1) {
					parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eMUTE §f(§eJOGADOR§f) (§eMOTIVO§f).");
				} else if(parametroArgumentos.length >= 2) {
					  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
					  if(alvo == null) {
						  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
					  } else {
							if(MySQLManager.getMute(alvo) == 0) {
								String Motivo = "";
								for (int i = 1; i < parametroArgumentos.length; i++) {
									Motivo = Motivo + parametroArgumentos[i] + " ";
								}
						        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
						        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi mutado §c§lPERMANENTIMENTE§f na rede §b§lSTTEY§f§lMC§f. ");
						        }
						        MySQLManager.updateMute(alvo, 1);
						        MySQLManager.updateMotivoMute(alvo, Motivo);
						        MySQLManager.updateResponsavelMute(alvo, parametroJogador.getName());
							} else if(MySQLManager.getMute(alvo) == 1) {
								parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está mutado.");
							}
					  }
				}
			} else 	if(MySQLManager.getRank(parametroJogador) == 14) {
				if(parametroArgumentos.length <= 1) {
					parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eMUTE §f(§eJOGADOR§f) (§eMOTIVO§f).");
				} else if(parametroArgumentos.length >= 2) {
					  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
					  if(alvo == null) {
						  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
					  } else {
							if(MySQLManager.getMute(alvo) == 0) {
								String Motivo = "";
								for (int i = 1; i < parametroArgumentos.length; i++) {
									Motivo = Motivo + parametroArgumentos[i] + " ";
								}
						        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
						        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi mutado §c§lPERMANENTIMENTE§f na rede §b§lSTTEY§f§lMC§f. ");
						        }
						        MySQLManager.updateMute(alvo, 1);
						        MySQLManager.updateMotivoMute(alvo, Motivo);
						        MySQLManager.updateResponsavelMute(alvo, parametroJogador.getName());
							} else if(MySQLManager.getMute(alvo) == 1) {
								parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está mutado.");
							}
					  }
				}
			} else if(MySQLManager.getRank(parametroJogador) == 13) {
				if(parametroArgumentos.length <= 1) {
					parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eMUTE §f(§eJOGADOR§f) (§eMOTIVO§f).");
				} else if(parametroArgumentos.length >= 2) {
					  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
					  if(alvo == null) {
						  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
					  } else {
							if(MySQLManager.getMute(alvo) == 0) {
								String Motivo = "";
								for (int i = 1; i < parametroArgumentos.length; i++) {
									Motivo = Motivo + parametroArgumentos[i] + " ";
								}
						        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
						        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi mutado §c§lPERMANENTIMENTE§f na rede §b§lSTTEY§f§lMC§f. ");
						        }
						        MySQLManager.updateMute(alvo, 1);
						        MySQLManager.updateMotivoMute(alvo, Motivo);
						        MySQLManager.updateResponsavelMute(alvo, parametroJogador.getName());
							} else if(MySQLManager.getMute(alvo) == 1) {
								parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está mutado.");
							}
					  }
				}
			} else if(MySQLManager.getRank(parametroJogador) == 12) {
				if(parametroArgumentos.length <= 1) {
					parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eMUTE §f(§eJOGADOR§f) (§eMOTIVO§f).");
				} else if(parametroArgumentos.length >= 2) {
					  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
					  if(alvo == null) {
						  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
					  } else {
							if(MySQLManager.getMute(alvo) == 0) {
								String Motivo = "";
								for (int i = 1; i < parametroArgumentos.length; i++) {
									Motivo = Motivo + parametroArgumentos[i] + " ";
								}
						        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
						        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi mutado §c§lPERMANENTIMENTE§f na rede §b§lSTTEY§f§lMC§f. ");
						        }
						        MySQLManager.updateMute(alvo, 1);
						        MySQLManager.updateMotivoMute(alvo, Motivo);
						        MySQLManager.updateResponsavelMute(alvo, parametroJogador.getName());
							} else if(MySQLManager.getMute(alvo) == 1) {
								parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está mutado.");
							}
					  }
				}
			} else if(MySQLManager.getRank(parametroJogador) == 11) {
				if(parametroArgumentos.length <= 1) {
					parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eMUTE §f(§eJOGADOR§f) (§eMOTIVO§f).");
				} else if(parametroArgumentos.length >= 2) {
					  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
					  if(alvo == null) {
						  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
					  } else {
							if(MySQLManager.getMute(alvo) == 0) {
								String Motivo = "";
								for (int i = 1; i < parametroArgumentos.length; i++) {
									Motivo = Motivo + parametroArgumentos[i] + " ";
								}
						        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
						        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi mutado §c§lPERMANENTIMENTE§f na rede §b§lSTTEY§f§lMC§f. ");
						        }
						        MySQLManager.updateMute(alvo, 1);
						        MySQLManager.updateMotivoMute(alvo, Motivo);
						        MySQLManager.updateResponsavelMute(alvo, parametroJogador.getName());
							} else if(MySQLManager.getMute(alvo) == 1) {
								parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está mutado.");
							}
					  }
				}
			} else if(MySQLManager.getRank(parametroJogador) == 11) {
				if(parametroArgumentos.length <= 1) {
					parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eMUTE §f(§eJOGADOR§f) (§eMOTIVO§f).");
				} else if(parametroArgumentos.length >= 2) {
					  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
					  if(alvo == null) {
						  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
					  } else {
							if(MySQLManager.getMute(alvo) == 0) {
								String Motivo = "";
								for (int i = 1; i < parametroArgumentos.length; i++) {
									Motivo = Motivo + parametroArgumentos[i] + " ";
								}
						        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
						        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi mutado §c§lPERMANENTIMENTE§f na rede §b§lSTTEY§f§lMC§f. ");
						        }
						        MySQLManager.updateMute(alvo, 1);
						        MySQLManager.updateMotivoMute(alvo, Motivo);
						        MySQLManager.updateResponsavelMute(alvo, parametroJogador.getName());
							} else if(MySQLManager.getMute(alvo) == 1) {
								parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está mutado.");
							}
					  }
				}
			} else if(MySQLManager.getRank(parametroJogador) == 10) {
				if(parametroArgumentos.length <= 1) {
					parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eMUTE §f(§eJOGADOR§f) (§eMOTIVO§f).");
				} else if(parametroArgumentos.length >= 2) {
					  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
					  if(alvo == null) {
						  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
					  } else {
							if(MySQLManager.getMute(alvo) == 0) {
								String Motivo = "";
								for (int i = 1; i < parametroArgumentos.length; i++) {
									Motivo = Motivo + parametroArgumentos[i] + " ";
								}
						        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
						        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi mutado §c§lPERMANENTIMENTE§f na rede §b§lSTTEY§f§lMC§f. ");
						        }
						        MySQLManager.updateMute(alvo, 1);
						        MySQLManager.updateMotivoMute(alvo, Motivo);
						        MySQLManager.updateResponsavelMute(alvo, parametroJogador.getName());
							} else if(MySQLManager.getMute(alvo) == 1) {
								parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está mutado.");
							}
					  }
				}
			} else if(MySQLManager.getRank(parametroJogador) == 9) {
				if(parametroArgumentos.length <= 1) {
					parametroJogador.sendMessage("§a§lPUNIÇõES §fUtilize: /§eMUTE §f(§eJOGADOR§f) (§eMOTIVO§f).");
				} else if(parametroArgumentos.length >= 2) {
					  ProxiedPlayer alvo = BungeeCord.getInstance().getPlayer(parametroArgumentos[0]);
					  if(alvo == null) {
						  parametroJogador.sendMessage("§a§lPUNIÇõES §fJogador não encontrado.");
					  } else {
							if(MySQLManager.getMute(alvo) == 0) {
								String Motivo = "";
								for (int i = 1; i < parametroArgumentos.length; i++) {
									Motivo = Motivo + parametroArgumentos[i] + " ";
								}
						        for(ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
						        	p.sendMessage("§a§lALERTA §fO jogador §e" + alvo.getName() + "§f foi mutado §c§lPERMANENTIMENTE§f na rede §b§lSTTEY§f§lMC§f. ");
						        }
						        MySQLManager.updateMute(alvo, 1);
						        MySQLManager.updateMotivoMute(alvo, Motivo);
						        MySQLManager.updateResponsavelMute(alvo, parametroJogador.getName());
							} else if(MySQLManager.getMute(alvo) == 1) {
								parametroJogador.sendMessage("§a§lPUNIÇõES §fEste jogador já está mutado.");
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