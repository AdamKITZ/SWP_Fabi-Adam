package at.fabiadam.listener;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.timers.LobbyCountdown;
import at.fabiadam.timers.SpawnerTimer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class playerRespawnEvent implements Listener {
    private MainBedwars plugin;
    private LobbyCountdown lobbyCountdown;
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if(player.getWorld().getName().equals("world_bedwars_l")) {
            if(lobbyCountdown.timeLeft() > 0) {
                event.setRespawnLocation(player.getWorld().getSpawnLocation());
            }
        }
    }
}
