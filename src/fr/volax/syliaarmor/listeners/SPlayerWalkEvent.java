package fr.volax.syliaarmor.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.PlayerInventory;

import java.util.Random;

public class SPlayerWalkEvent implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();
        int random = new Random().nextInt(100);

        if(inv.getHelmet() == null){ return; }
        if(inv.getChestplate() == null){ return; }
        if(inv.getLeggings() == null){ return; }
        if(inv.getBoots() == null){ return; }

        if(inv.getHelmet().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cHelmet") || inv.getChestplate().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cChestplate") || inv.getLeggings().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cLeggings") || inv.getBoots().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cBoots")){
            if(random == 1){
                inv.getHelmet().setDurability((short) (inv.getHelmet().getDurability() - 1));
                inv.getChestplate().setDurability((short) (inv.getChestplate().getDurability() - 1));
                inv.getLeggings().setDurability((short) (inv.getLeggings().getDurability() - 1));
                inv.getBoots().setDurability((short) (inv.getBoots().getDurability() - 1));
            }
        }
    }
}
