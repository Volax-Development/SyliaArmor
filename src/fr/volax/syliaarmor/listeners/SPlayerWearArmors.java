package fr.volax.syliaarmor.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class SPlayerWearArmors implements Listener {
    @EventHandler
    public void onPlayerInteractEvent(PlayerMoveEvent e){
        Player player = e.getPlayer();
        PlayerInventory inv = player.getInventory();
        if(inv.getHelmet() != null) {
            if (inv.getHelmet().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cHelmet")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 200000000, 0));
            }else if(inv.getHelmet().getItemMeta().getDisplayName().equals("§7» §aCasque de Farm") || inv.getHelmet().getItemMeta().getDisplayName().equals("§7» §dCasque de Recherche")){
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 250, 1));
                player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
            }
        }else{
            player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
        }
        if(inv.getChestplate() != null) {
            if (inv.getChestplate().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cChestplate") || inv.getChestplate().getItemMeta().getDisplayName().equals("§7» §aPlastron de Farm")){
                player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 100, 0));
            }else if(inv.getChestplate().getItemMeta().getDisplayName().equals("§7» §dPlastron de Recherche")){
                player.removePotionEffect(PotionEffectType.JUMP);
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 100, 1));
            }
        }
        if(inv.getLeggings() != null){
            if(inv.getLeggings().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cLeggings")){
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 0));
            }else if(inv.getLeggings().getItemMeta().getDisplayName().equals("§7» §aJambière de Farm")){
                player.removePotionEffect(PotionEffectType.INVISIBILITY);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY ,250, 0));
            }else if(inv.getLeggings().getItemMeta().getDisplayName().equals("§7» §dJambière de Recherche")){
                player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE ,100, 0));
            }
        }
        if(inv.getBoots() != null){
            if(inv.getBoots().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cBoots") || inv.getBoots().getItemMeta().getDisplayName().equals("§7» §aBottes de Farm")){
                player.removePotionEffect(PotionEffectType.SPEED);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED ,100, 1));
            }else if(inv.getBoots().getItemMeta().getDisplayName().equals("§7» §dBottes de Recherche")){
                player.removePotionEffect(PotionEffectType.SPEED);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED ,100, 2));
            }
        }
        if(player.getItemInHand() != null){
            if(player.getItemInHand().getType() == Material.GOLD_AXE && player.getItemInHand().getItemMeta().getDisplayName().equals("§7» §4Battle§cAxe")){
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE ,100, 0));
            }
        }
    }

    @EventHandler
    public void onPlayerWalK(PlayerMoveEvent e){
        Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();
        if(inv.getBoots() != null || inv.getHelmet() != null || inv.getChestplate() != null || inv.getLeggings() != null){
            if(inv.getHelmet().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cHelmet") || inv.getChestplate().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cChestplate") || inv.getLeggings().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cLeggings") || inv.getBoots().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cBoots")){
                int random = new Random().nextInt(100);
                if(random == 1){
                    inv.getHelmet().setDurability((short) (inv.getHelmet().getDurability() - 1));
                    inv.getChestplate().setDurability((short) (inv.getChestplate().getDurability() - 1));
                    inv.getLeggings().setDurability((short) (inv.getLeggings().getDurability() - 1));
                    inv.getBoots().setDurability((short) (inv.getBoots().getDurability() - 1));
                }
            }
        }
    }
}
