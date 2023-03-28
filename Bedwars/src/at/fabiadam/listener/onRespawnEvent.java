package at.fabiadam.listener;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;


public class onRespawnEvent implements Listener {
    private MainBedwars plugin;
    private BedwarsUtil util;
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        if(event.getPlayer().getWorld().getName().equals("world_bedwars")) {
            event.setRespawnLocation(util.getPlayerTeam(event.getPlayer()).getTeamSpawn());
        }
    }
}
