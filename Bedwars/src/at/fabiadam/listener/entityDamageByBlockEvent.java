package at.fabiadam.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class entityDamageByBlockEvent implements Listener {
    @EventHandler
    public void onEntityDamageByBlockEvent(EntityDamageByBlockEvent event){
        if(!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if (!(player.getWorld().getName().equals("world_bedwars_l"))) return;
        //checks if the player gets damage by falling
        if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
            //if player is falling from a high place, cancel the damage
            event.setCancelled(true);
        }
    }
}
