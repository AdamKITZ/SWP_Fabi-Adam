package at.fabiadam.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class entityDamageByBlockEvent implements Listener {
    @EventHandler
    public void onEntityDamageByBlockEvent(EntityDamageByBlockEvent event){
        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.getWorld().getName().equals("world_bedwars")){
                if (player.getGameMode() == GameMode.SURVIVAL) {
                    //checks if the player gets damage by falling
                    if (event.getCause() == entityDamageEvent.DamageCause.FALL) {
                        //if player is falling from a high place, cancel the damage
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
