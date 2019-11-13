package fr.volax.syliaarmor.listeners;

import fr.volax.syliaarmor.utils.Init;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffectType;

public class SPlayerWearArmors implements Listener {
    @EventHandler
    public void onPlayerInteractEvent(PlayerMoveEvent e){
        Player player = e.getPlayer();
        PlayerInventory inv = player.getInventory();
        Init item = new Init();

        ItemStack helmet = inv.getHelmet();
        ItemStack chestplate = inv.getChestplate();
        ItemStack leggings = inv.getLeggings();
        ItemStack boots = inv.getBoots();

        if(helmet != null){
            String helmetname = helmet.getItemMeta().getDisplayName();
            if (helmetname.equals("§7» §4Sylia§7'§cHelmet")) {
                item.set(PotionEffectType.HEALTH_BOOST, player, 2147483647,0,"non");
            }else if(helmetname.equals("§7» §aCasque de Farm") || helmetname.equals("§7» §dCasque de Recherche")){
                player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                item.set(PotionEffectType.NIGHT_VISION, player, 250, 1, "oui");
            }
        }
        if(chestplate != null){
            String chestplatename = chestplate.getItemMeta().getDisplayName();
            if (chestplatename.equals("§7» §4Sylia§7'§cChestplate") || chestplatename.equals("§7» §aPlastron de Farm")){
                item.set(PotionEffectType.FIRE_RESISTANCE, player, 100,0,"oui");
            }else if(chestplate.getItemMeta().getDisplayName().equals("§7» §dPlastron de Recherche")){
                item.set(PotionEffectType.JUMP, player, 100,1,"oui");
            }
        }
        if(leggings != null){
            String leggingsname = leggings.getItemMeta().getDisplayName();
            switch (leggingsname) {
                case "§7» §4Sylia§7'§cLeggings":
                    item.set(PotionEffectType.REGENERATION, player, 100, 0, "non");
                    break;
                case "§7» §aJambière de Farm":
                    item.set(PotionEffectType.INVISIBILITY, player, 100, 1, "oui");
                    break;
                case "§7» §dJambière de Recherche":
                    item.set(PotionEffectType.DAMAGE_RESISTANCE, player, 100, 0, "oui");
                    break;
            }
        }
        if(boots != null){
            String bootsname = boots.getItemMeta().getDisplayName();
            if(bootsname.equals("§7» §4Sylia§7'§cBoots") || bootsname.equals("§7» §aBottes de Farm")){
                item.set(PotionEffectType.SPEED, player, 100,1, "oui");
            }else if(bootsname.equals("§7» §dBottes de Recherche")){
                item.set(PotionEffectType.SPEED, player, 100,2, "oui");
            }
        }

        if(player.getItemInHand() != null){
            if(player.getItemInHand().getType() == Material.GOLD_AXE && player.getItemInHand().getItemMeta().getDisplayName().equals("§7» §4Battle§cAxe")){
                item.set(PotionEffectType.INCREASE_DAMAGE, player, 100, 0, "oui");
            }
        }
    }
}
