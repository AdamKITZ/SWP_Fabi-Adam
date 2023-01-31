package at.fabiadam.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class playerDropEvent implements Listener {
    @EventHandler
    public void onPlayerDropEvent(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().getName().equals("world_bedwars_l")) {
            if (player.getGameMode() == GameMode.SURVIVAL) {
                //player can't drop items in the lobby
                event.setCancelled(true);
            }
        }
    }
}
