package fr.volax.syliaarmor.listeners;

import fr.volax.syliaarmor.utils.Init;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SInventoryClickEvent implements Listener {
    @EventHandler
    public void invclickevent(InventoryClickEvent e){
        if(!(e.getWhoClicked() instanceof Player)){ return; }
        Player p = (Player)e.getWhoClicked();
        String inv = e.getInventory().getName();
        ItemStack item = e.getCurrentItem();
        if(inv.equals("§4Sylia§cArmor")){
            e.setCancelled(true);
            if(item.getType() == Material.LEATHER_HELMET && item.getItemMeta().getDisplayName() == "§7» §aCasque de Farm"){
                p.getInventory().addItem(Init.armor_farm_helmet.toItemStack());
                return;
            }else if(item.getType() == Material.LEATHER_CHESTPLATE && item.getItemMeta().getDisplayName() == "§7» §aPlastron de Farm"){
                p.getInventory().addItem(Init.armor_farm_chestplate.toItemStack());
                return;
            }else if(item.getType() == Material.LEATHER_LEGGINGS && item.getItemMeta().getDisplayName() == "§7» §aJambière de Farm"){
                p.getInventory().addItem(Init.armor_farm_leggings.toItemStack());
                return;
            }else if(item.getType() == Material.LEATHER_BOOTS && item.getItemMeta().getDisplayName() == "§7» §aBottes de Farm"){
                p.getInventory().addItem(Init.armor_farm_boots.toItemStack());
                return;
            }else if(item.getType() == Material.CHAINMAIL_HELMET && item.getItemMeta().getDisplayName() == "§7» §dCasque de Recherche"){
                p.getInventory().addItem(Init.armor_recherche_helmet.toItemStack());
                return;
            }else if(item.getType() == Material.CHAINMAIL_CHESTPLATE && item.getItemMeta().getDisplayName() == "§7» §dPlastron de Recherche"){
                p.getInventory().addItem(Init.armor_recherche_chestplate.toItemStack());
                return;
            }else if(item.getType() == Material.CHAINMAIL_LEGGINGS && item.getItemMeta().getDisplayName() == "§7» §dJambière de Recherche"){
                p.getInventory().addItem(Init.armor_recherche_leggings.toItemStack());
                return;
            }else if(item.getType() == Material.CHAINMAIL_BOOTS && item.getItemMeta().getDisplayName() == "§7» §dBottes de Recherche"){
                p.getInventory().addItem(Init.armor_recherche_boots.toItemStack());
                return;
            }else if(item.getType() == Material.DIAMOND_HELMET && item.getItemMeta().getDisplayName() == "§7» §4Sylia§7'§cHelmet"){
                p.getInventory().addItem(Init.armor_combat_helmet.toItemStack());
                return;
            }else if(item.getType() == Material.DIAMOND_CHESTPLATE && item.getItemMeta().getDisplayName() == "§7» §4Sylia§7'§cChestplate") {
                p.getInventory().addItem(Init.armor_combat_chestplate.toItemStack());
                return;
            }else if(item.getType() == Material.DIAMOND_LEGGINGS && item.getItemMeta().getDisplayName() == "§7» §4Sylia§7'§cLeggings") {
                p.getInventory().addItem(Init.armor_combat_leggings.toItemStack());
                return;
            }else if(item.getType() == Material.DIAMOND_BOOTS && item.getItemMeta().getDisplayName() == "§7» §4Sylia§7'§cBoots") {
                p.getInventory().addItem(Init.armor_combat_boots.toItemStack());
                return;
            }else if(item.getType() == Material.GOLD_AXE && item.getItemMeta().getDisplayName() == "§7» §4Battle§cAxe") {
                p.getInventory().addItem(Init.item_battle_axe.toItemStack());
                return;
            }
        }
    }
}
