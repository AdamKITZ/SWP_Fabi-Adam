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
        event.setJoinMessage("§aWelcome to the Bedwars Server!\nYou can click on the sign to join the game lobby!");
    }
}
