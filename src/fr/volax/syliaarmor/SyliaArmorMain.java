package fr.volax.syliaarmor;

import fr.volax.syliaarmor.commands.SarmorCommand;
import fr.volax.syliaarmor.listeners.SInventoryClickEvent;
import fr.volax.syliaarmor.listeners.SPlayerGetDamage;
import fr.volax.syliaarmor.listeners.SPlayerWearArmors;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SyliaArmorMain extends JavaPlugin {
    private static SyliaArmorMain instance;
    public static String prefix = "§4Sylia§cCraft ";

    @Override
    public void onEnable() {
        saveDefaultConfig();

        instance = this;

        getCommand("sarmor").setExecutor(new SarmorCommand());
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new SInventoryClickEvent(), this);
        pm.registerEvents(new SPlayerWearArmors(), this);
        pm.registerEvents(new SPlayerGetDamage(), this);
    }

    public void reloadConfigs(){
        reloadConfig();
    }

    public static SyliaArmorMain getInstance(){ return instance; }
}
