package at.fabiadam.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class entityDamageByEntityEvent implements Listener {

    @EventHandler
    public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if(player.getWorld().getName().equals("world_bedwars_l")){
                if(player.getGameMode() == GameMode.SURVIVAL){
                    event.setCancelled(true);
                }
            }
        }
    }
}
