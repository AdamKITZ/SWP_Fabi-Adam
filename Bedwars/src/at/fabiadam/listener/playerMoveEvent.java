package at.fabiadam.listener;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.objects.Team;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class playerMoveEvent implements Listener {
    private MainBedwars plugin;
    private BedwarsUtil util;

    // !!! Important !!!
    // Please note that this function is executed every time a player moves.
    // This will cause a lot of performance issues if you do not know what you are doing.
    //
    // Use with care

    // useful standard settings

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if(event.getPlayer().getWorld().getName().equals("world_bedwars")) {
            if(event.getPlayer().getLocation().getY() <= 0) {
                if(event.getPlayer().getGameMode() != GameMode.SURVIVAL) return;
                this.plugin = MainBedwars.getPlugin();
                this.util = plugin.getUtil();
                event.getPlayer().setHealth(0);
                //Team team = util.getPlayerTeam(event.getPlayer());
                //event.getPlayer().teleport(team.getTeamSpawn());
                //event.getPlayer().spigot().respawn();
            } else if (event.getPlayer().getLocation().getY() >= 120) {
                event.setCancelled(true);
            }
        } else if(event.getPlayer().getWorld().getName().equals("world_bedwars_l")) {
            if(event.getPlayer().getLocation().getY() < 62) {
                event.getPlayer().teleport(new Location(event.getPlayer().getWorld(), 0.5, 75, 0.5, 180, 0));
                event.getPlayer().setHealth(20);
            }
        }
    }
}
