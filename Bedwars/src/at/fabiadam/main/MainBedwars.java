package at.fabiadam.main;

import at.fabiadam.commands.startRound;
import at.fabiadam.listener.playerJoinEvent;
import at.fabiadam.listener.playerWorldChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MainBedwars extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Bedwars Plugin enabled!");

        //Register all created commands
        getCommand("start").setExecutor(new startRound());

        //Register all listeners
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new playerWorldChangeEvent(), this);
    }
}
