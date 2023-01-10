package at.fabiadam.listener;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.timers.LobbyCountdown;
import at.fabiadam.timers.SpawnerTimer;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scoreboard.Objective;

import java.util.Set;

public class playerRespawnEvent implements Listener {
    private MainBedwars plugin;
    private LobbyCountdown lobbyCountdown;
    BedwarsUtil util;

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        Player player = event.getPlayer();
        if(player.getWorld().getName().equals("world_bedwars_l")) {
            if(lobbyCountdown.timeLeft() > 0) {
                event.setRespawnLocation(player.getWorld().getSpawnLocation());
            }
        }
    }
}
