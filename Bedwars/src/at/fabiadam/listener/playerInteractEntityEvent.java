package at.fabiadam.listener;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class playerInteractEntityEvent implements Listener {

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractAtEntityEvent event){
        if(event.getPlayer().getWorld().getName().equals("world_bedwars_l")){
            if(event.getPlayer().getGameMode() == GameMode.SURVIVAL){
                event.setCancelled(true);
            }
        }
    }
}
