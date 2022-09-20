package at.fabiadam.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class playerWorldChangeEvent implements Listener {
    public static int playerCount = 0;
    public static int maxPlayerCount = 4;
    public static int minPlayerCount = 2;


    @EventHandler
    public void onWorldChangeEvent(PlayerChangedWorldEvent event) {
        playerCount = Bukkit.getServer().getWorld("world_bedwars_lobby").getPlayers().size();
        if(event.getPlayer().getWorld().getName().equals("world_bedwars_lobby")) {
            event.getPlayer().sendMessage("§bCurrent Players: " + playerCount + "\n§bPlayers required to start: " + minPlayerCount);
            event.getPlayer().sendMessage("§aWelcome to the Bedwars lobby!\nYou can start a round by typing §6/start§a before the timer stops");
        }
    }
}
