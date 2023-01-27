package at.fabiadam.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class entityDamageEvent implements Listener {
    public static EntityDamageEvent.DamageCause DamageCause;
    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.getWorld().getName().equals("world_bedwars_l") || player.getWorld().getName().equals("world")) {
                //checks if the player gets damage, if so set the health and foodlevel to 20 again
                if (player.getHealth() <= 10) {
                    player.setHealth(20);
                }
                if (player.getFoodLevel() <= 10) {
                    player.setFoodLevel(20);
                }
            }
        }
    }
}
