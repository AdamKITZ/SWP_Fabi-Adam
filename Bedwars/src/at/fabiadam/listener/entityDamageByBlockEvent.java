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
                    //Lösungsansatz 1 (in Lobby)
                    if (event.getCause() == entityDamageEvent.DamageCause.FALL) {
                        event.setCancelled(true);
                        //Location l = event.getEntity().getLocation().add(0, -1, 0);
                        //Material mat = l.getBlock().getType();
                    }
                }
            }
//            else if (player.getWorld().getName().equals("world_bedwars_l")) {
//                //Lösungsansatz 2 (ingame)
//                if (player.getGameMode() == GameMode.SURVIVAL) {
//                    if (player.getLocation().getY() < 0) {
//                        event.setCancelled(true);
//                    }
//                }
//            }
        }
    }
}
