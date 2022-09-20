package at.fabiadam.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class playerJoinEvent implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("§aWelcome to the Bedwars Server!\nYou can click on the sign to join the game lobby!");
    }
}
