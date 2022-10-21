package at.fabiadam.listener;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockPlaceEvent implements Listener {
    private MainBedwars plugin;
    private BedwarsUtil util;

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        this.plugin = MainBedwars.getPlugin();
        FileConfiguration config = plugin.getConfig();
        this.util = plugin.getUtil();


        if(event.getPlayer().getWorld().getName().equals("world_bedwars")){
            if(event.getPlayer().getGameMode() == GameMode.SURVIVAL){
                if(util.getSpawnBlocks(config.getLocation("team.red.teamSpawn")).contains(event.getBlock().getLocation())){
                    event.setCancelled(true);
                }
                else if(util.getSpawnBlocks(config.getLocation("team.blue.teamSpawn")).contains(event.getBlock().getLocation())){
                    event.setCancelled(true);
                }
                else if(util.getSpawnBlocks(config.getLocation("team.green.teamSpawn")).contains(event.getBlock().getLocation())){
                    event.setCancelled(true);
                }
                else if(util.getSpawnBlocks(config.getLocation("team.yellow.teamSpawn")).contains(event.getBlock().getLocation())){
                    event.setCancelled(true);
                }
            }
        }
    }
}
