package at.fabiadam.main;

import at.fabiadam.commands.startLobbyTimer;
import at.fabiadam.gameStates.GameStateManager;
import at.fabiadam.gameStates.gameStates;
import at.fabiadam.listener.entityDamageByEntityEvent;
import at.fabiadam.listener.playerInteractEvent;
import at.fabiadam.listener.playerJoinEvent;
import at.fabiadam.listener.playerWorldChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MainBedwars extends JavaPlugin {
    private static MainBedwars plugin;
    private GameStateManager gameStateManager;
    @Override
    public void onEnable() {
        plugin = this;
        System.out.println("Bedwars Plugin enabled!");

        gameStateManager = new GameStateManager(this);

        gameStateManager.setGameState(gameStates.LOBBY);

        //Register all created commands
        getCommand("start").setExecutor(new startLobbyTimer());

        //Register all listeners
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new playerWorldChangeEvent(), this);
        pluginManager.registerEvents(new playerJoinEvent(), this);
        pluginManager.registerEvents(new playerInteractEvent(), this);
        pluginManager.registerEvents(new entityDamageByEntityEvent(), this);
    }

    public static MainBedwars getPlugin() {
        return plugin;
    }

}
