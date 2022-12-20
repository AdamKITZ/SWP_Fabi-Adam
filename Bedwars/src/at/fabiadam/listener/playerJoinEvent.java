package at.fabiadam.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class playerJoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Location spawn = new Location(Bukkit.getWorld("world"), 180.5, 68, -48.5);
        event.getPlayer().teleport(spawn);
        if(event.getPlayer().getFoodLevel() < 20 || event.getPlayer().getHealth() < 20) {
            event.getPlayer().setFoodLevel(20);
            event.getPlayer().setHealth(20);
        }
        event.setJoinMessage("§aWelcome to the Server!\nYou can click on the sign to join the game lobby!");
    }
}
