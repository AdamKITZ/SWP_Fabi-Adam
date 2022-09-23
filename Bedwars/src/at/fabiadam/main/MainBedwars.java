package at.fabiadam.main;

import at.fabiadam.commands.startRound;
import at.fabiadam.listener.playerInteractEvent;
import at.fabiadam.listener.playerJoinEvent;
import at.fabiadam.listener.playerWorldChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MainBedwars extends JavaPlugin {
    private static MainBedwars plugin;
    @Override
    public void onEnable() {
        plugin = this;
        System.out.println("Bedwars Plugin enabled!");

        //Register all created commands
        getCommand("start").setExecutor(new startRound());

        //Register all listeners
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new playerWorldChangeEvent(), this);
        pluginManager.registerEvents(new playerJoinEvent(), this);
        pluginManager.registerEvents(new playerInteractEvent(), this);
    }

    public static MainBedwars getPlugin() {
        return plugin;
    }
}
