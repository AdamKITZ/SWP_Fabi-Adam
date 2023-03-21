package at.fabiadam.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class playerJoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        int maximum = 20;
        Location spawnLocation = new Location(Bukkit.getWorld("world"), 180.5, 68, -48.5);
        event.getPlayer().teleport(spawnLocation);
        if(event.getPlayer().getFoodLevel() < maximum || event.getPlayer().getHealth() < maximum) {
            event.getPlayer().setFoodLevel(maximum);
            event.getPlayer().setHealth(maximum);
        }
        event.setJoinMessage("§aWelcome to the Server!\nYou can click on the sign to join the game lobby!");
    }
}
