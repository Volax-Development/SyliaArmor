package fr.volax.syliaarmor.commands;

import fr.volax.syliaarmor.SyliaArmorMain;
import fr.volax.syliaarmor.utils.ItemInit;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SarmorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("sarmor")){
            if(!(sender instanceof Player)){ sender.sendMessage(SyliaArmorMain.prefix + "§cVous devez etre un joueur pour executer cette commande !"); return false; }
            Player player = (Player)sender;
            if(!player.hasPermission(SyliaArmorMain.getInstance().getConfig().getString("permissions.sarmor-use"))){ player.sendMessage(SyliaArmorMain.prefix + "§cVous n'avez pas la permissions d'executer cette  commande !"); return false;}
            if(args.length != 1){ player.sendMessage(SyliaArmorMain.prefix + "§7Commande d'aide : /samor help"); return false; }
            if(args[0].equalsIgnoreCase("help")){
                player.sendMessage(SyliaArmorMain.prefix + "§c/samor help : Commande d'aide");
                player.sendMessage(SyliaArmorMain.prefix + "§c/samor reload : Reload la config");
                player.sendMessage(SyliaArmorMain.prefix + "§c/samor give : Ouvre le menu des armures");
                return false;
            }else if(args[0].equalsIgnoreCase("reload")){
                player.sendMessage(SyliaArmorMain.prefix + "§7La config a bien été reload !");
                SyliaArmorMain.getInstance().reloadConfigs();
                player.playSound(player.getLocation(), Sound.ANVIL_USE, 1.0F, -1.0F);
            }else if(args[0].equalsIgnoreCase("give")){
                Inventory inv = Bukkit.createInventory(null, 6*9, "§4Sylia§cArmor");
                inv.setItem(10, ItemInit.armor_farm_helmet.toItemStack());
                inv.setItem(19, ItemInit.armor_farm_chestplate.toItemStack());
                inv.setItem(28, ItemInit.armor_farm_leggings.toItemStack());
                inv.setItem(37, ItemInit.armor_farm_boots.toItemStack());
                inv.setItem(12, ItemInit.armor_recherche_helmet.toItemStack());
                inv.setItem(21, ItemInit.armor_recherche_chestplate.toItemStack());
                inv.setItem(30, ItemInit.armor_recherche_leggings.toItemStack());
                inv.setItem(39, ItemInit.armor_recherche_boots.toItemStack());
                inv.setItem(14, ItemInit.armor_combat_helmet.toItemStack());
                inv.setItem(23, ItemInit.armor_combat_chestplate.toItemStack());
                inv.setItem(32, ItemInit.armor_combat_leggings.toItemStack());
                inv.setItem(41, ItemInit.armor_combat_boots.toItemStack());
                inv.setItem(16, ItemInit.item_battle_axe.toItemStack());
                player.openInventory(inv);
            }else{
                player.sendMessage(SyliaArmorMain.prefix + "§c/samor help : Commande d'aide");
                player.sendMessage(SyliaArmorMain.prefix + "§c/samor reload : Reload la config");
                player.sendMessage(SyliaArmorMain.prefix + "§c/samor give : Ouvre le menu des armures");
            }
        }
        return false;
    }
}
