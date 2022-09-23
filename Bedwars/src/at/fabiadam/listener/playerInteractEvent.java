package at.fabiadam.listener;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class playerInteractEvent implements Listener {

    @EventHandler
    public void onPlayerInteract (PlayerInteractEvent event){
        if(event.getPlayer().getWorld().getName().equals("world_bedwars_l")){
            if(event.getPlayer().getGameMode() == GameMode.SURVIVAL){
                event.setCancelled(true);
            }
        }
    }
}