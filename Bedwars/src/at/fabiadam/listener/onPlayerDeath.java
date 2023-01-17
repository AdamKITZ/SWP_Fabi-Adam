package at.fabiadam.listener;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.objects.Team;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onPlayerDeath implements Listener {
    private MainBedwars plugin;
    private BedwarsUtil util;

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        Player player = (Player) event.getEntity();
        if (player.getWorld().getName().equals("world_bedwars")) {
            if (util.isBedActiv(player) == 1) {
                player.spigot().respawn();
                Team team = util.getPlayerTeam(player);
                player.teleport(team.getTeamSpawn());
            } else {
                player.spigot().respawn();
                Team team = util.getPlayerTeam(player);
                player.teleport(team.getTeamSpawn());
                player.setGameMode(GameMode.SPECTATOR);
            }

        } else if(player.getWorld().getName().equals("world_bedwars_l")) {
            if (player.getGameMode() == GameMode.SURVIVAL) {
                event.setKeepInventory(true);
                player.spigot().respawn();
            }
        }

    }
}
