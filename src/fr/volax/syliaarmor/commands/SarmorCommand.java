package fr.volax.syliaarmor.commands;

import fr.volax.syliaarmor.SyliaArmorMain;
import fr.volax.syliaarmor.utils.Init;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SarmorCommand implements CommandExecutor {
    Init init = new Init();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("sarmor")){
            if(!(sender instanceof Player)){ sender.sendMessage(SyliaArmorMain.prefix + "§cVous devez etre un joueur pour executer cette commande !"); return false; }
            Player player = (Player)sender;
            if(!player.hasPermission(SyliaArmorMain.getInstance().getConfig().getString("permissions.sarmor-use"))){ player.sendMessage(SyliaArmorMain.prefix + "§cVous n'avez pas la permissions d'executer cette  commande !"); return false;}
            if(args.length != 1){ player.sendMessage(SyliaArmorMain.prefix + "§7Commande d'aide : /samor help"); return false; }
            if(args[0].equalsIgnoreCase("help")){
                init.help(player);
                return false;
            }else if(args[0].equalsIgnoreCase("reload")){
                player.sendMessage(SyliaArmorMain.prefix + "§7La config a bien été reload !");
                SyliaArmorMain.getInstance().reloadConfig();
                player.playSound(player.getLocation(), Sound.ANVIL_USE, 1.0F, -1.0F);
            }else if(args[0].equalsIgnoreCase("give")){
                init.give_inventaire(player);
            }else{
               init.help(player);
            }
        }
        return false;
    }
}
