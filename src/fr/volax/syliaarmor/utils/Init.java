package fr.volax.syliaarmor.utils;

import fr.volax.syliaarmor.SyliaArmorMain;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Init {
    public static ItemAPI armor_farm_helmet = new ItemAPI(Material.LEATHER_HELMET).setName("§7» §aCasque de Farm");
    public static ItemAPI armor_farm_chestplate = new ItemAPI(Material.LEATHER_CHESTPLATE).setName("§7» §aPlastron de Farm");
    public static ItemAPI armor_farm_leggings = new ItemAPI(Material.LEATHER_LEGGINGS).setName("§7» §aJambière de Farm");
    public static ItemAPI armor_farm_boots = new ItemAPI(Material.LEATHER_BOOTS).setName("§7» §aBottes de Farm");

    public static ItemAPI armor_recherche_helmet = new ItemAPI(Material.CHAINMAIL_HELMET).setName("§7» §dCasque de Recherche");
    public static ItemAPI armor_recherche_chestplate = new ItemAPI(Material.CHAINMAIL_CHESTPLATE).setName("§7» §dPlastron de Recherche");
    public static ItemAPI armor_recherche_leggings = new ItemAPI(Material.CHAINMAIL_LEGGINGS).setName("§7» §dJambière de Recherche");
    public static ItemAPI armor_recherche_boots = new ItemAPI(Material.CHAINMAIL_BOOTS).setName("§7» §dBottes de Recherche");

    public static ItemAPI armor_combat_helmet = new ItemAPI(Material.DIAMOND_HELMET).setName("§7» §4Sylia§7'§cHelmet");
    public static ItemAPI armor_combat_chestplate = new ItemAPI(Material.DIAMOND_CHESTPLATE).setName("§7» §4Sylia§7'§cChestplate");
    public static ItemAPI armor_combat_leggings = new ItemAPI(Material.DIAMOND_LEGGINGS).setName("§7» §4Sylia§7'§cLeggings");
    public static ItemAPI armor_combat_boots = new ItemAPI(Material.DIAMOND_BOOTS).setName("§7» §4Sylia§7'§cBoots");

    public static ItemAPI item_battle_axe = new ItemAPI(Material.GOLD_AXE).setName("§7» §4Battle§cAxe");

    public void set(PotionEffectType potionEffectType, Player player, int duration, int amplifier, String reponse){
        if(reponse == "oui"){
            player.removePotionEffect(potionEffectType);
            player.addPotionEffect(new PotionEffect(potionEffectType,duration, amplifier));
        }else if(reponse == "non"){
            player.addPotionEffect(new PotionEffect(potionEffectType,duration, amplifier));
        }
    }

    public void help(Player player){
        player.sendMessage(SyliaArmorMain.prefix + "§c/samor help : Commande d'aide");
        player.sendMessage(SyliaArmorMain.prefix + "§c/samor reload : Reload la config");
        player.sendMessage(SyliaArmorMain.prefix + "§c/samor give : Ouvre le menu des armures");
    }

    public void give_inventaire(Player player){
        Inventory inv = Bukkit.createInventory(null, 6*9, "§4Sylia§cArmor");
        inv.setItem(10, Init.armor_farm_helmet.toItemStack());
        inv.setItem(19, Init.armor_farm_chestplate.toItemStack());
        inv.setItem(28, Init.armor_farm_leggings.toItemStack());
        inv.setItem(37, Init.armor_farm_boots.toItemStack());
        inv.setItem(12, Init.armor_recherche_helmet.toItemStack());
        inv.setItem(21, Init.armor_recherche_chestplate.toItemStack());
        inv.setItem(30, Init.armor_recherche_leggings.toItemStack());
        inv.setItem(39, Init.armor_recherche_boots.toItemStack());
        inv.setItem(14, Init.armor_combat_helmet.toItemStack());
        inv.setItem(23, Init.armor_combat_chestplate.toItemStack());
        inv.setItem(32, Init.armor_combat_leggings.toItemStack());
        inv.setItem(41, Init.armor_combat_boots.toItemStack());
        inv.setItem(16, Init.item_battle_axe.toItemStack());
        player.openInventory(inv);
    }
}
