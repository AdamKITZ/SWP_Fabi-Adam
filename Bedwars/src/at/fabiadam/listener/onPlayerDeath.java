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
        Player player = event.getEntity();
        if (player.getWorld().getName().equals("world_bedwars")) {
            event.getDrops().clear();
            //checks if bed is activated
            if (util.isBedActiv(player) == 1) {
                //if bed is activated, player is allowed to respawn
                //player.spigot().respawn();
                //Team team = util.getPlayerTeam(player);
                //player.teleport(team.getTeamSpawn());
            } else {
                //if bed is not activated, player will be in spectator mode
                //player.spigot().respawn();
                Team team = util.getPlayerTeam(player);
                player.teleport(team.getTeamSpawn());
                player.setGameMode(GameMode.SPECTATOR);
                team.removePlayer(player);
                if(team.getPlayers().size() == 0) {
                    team.setActive(false);
                }
            }

        } else if(player.getWorld().getName().equals("world_bedwars_l")) {
            if (player.getGameMode() == GameMode.SURVIVAL) {
                //in lobby (because of knockbackstick minigame) player will keep his inventory
                event.setKeepInventory(true);
                player.spigot().respawn();
            }
        }

    }
}
