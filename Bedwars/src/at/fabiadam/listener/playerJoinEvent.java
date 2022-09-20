package at.fabiadam.listener;

import org.bukkit.event.EventHandler;

import java.net.http.WebSocket;

public class playerJoinEvent implements WebSocket.Listener {
    @EventHandler
    public void onPlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent event) {

        event.getPlayer().sendMessage("§aWelcome to the Bedwars Server!\nYou can click on the sign to join the game lobby!");
    }
}
