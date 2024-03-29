package at.fabiadam.listener;

import at.fabiadam.items.BlockEnum;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import java.util.ArrayList;
import java.util.List;

public class onFallEvent implements Listener {
    public List<FallingBlock> fireNades = new ArrayList<>();

    @EventHandler
    public void onFall(EntityChangeBlockEvent event) {
        if (event.getEntity().getWorld().getName().equals("world_bedwars")) {
            if (event.getEntity() instanceof FallingBlock) {
                if (event.getEntity().getType().equals(BlockEnum.values())){
                    if (fireNades.contains(event.getEntity())) {
                        event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 25, false, false);
                        event.setCancelled(true);
                        event.getEntity().remove();
                        fireNades.remove(event.getEntity());
                    }
                }
                else {
                    event.setCancelled(true);
                }
            }
        }
    }
}
