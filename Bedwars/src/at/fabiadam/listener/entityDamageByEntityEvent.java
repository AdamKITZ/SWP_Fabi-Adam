package at.fabiadam.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class entityDamageByEntityEvent implements Listener {

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (player.getWorld().getName().equals("world_bedwars_l")) {
                if (player.getGameMode() == GameMode.SURVIVAL) {
                    //checks if the player location is > 70, if so cancel the damage
                    //important for lobby with knockbackstick minigame
                    if (player.getLocation().getY() > 70) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
