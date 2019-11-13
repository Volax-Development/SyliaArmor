package fr.volax.syliaarmor.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class SPlayerGetDamage implements Listener {
    @EventHandler
    public void onPlayerGetDamage(EntityDamageEvent e){
        if (!(e.getEntity() instanceof Player)) { return; }
        Player p = (Player) e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            if(p.getInventory().getBoots() == null){ return; }
            if(p.getInventory().getBoots().getItemMeta().getDisplayName().equals("§7» §4Sylia§7'§cBoots")){
                e.setCancelled(true);
                return;
            }
        }
    }
}
