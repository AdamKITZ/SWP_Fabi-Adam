package at.fabiadam.listener;

import at.fabiadam.items.BlockEnum;
import at.fabiadam.main.MainBedwars;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import javax.lang.model.element.Element;

public class blockPlaceEvent implements Listener {
    private MainBedwars plugin;
    private BedwarsUtil util;

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        this.plugin = MainBedwars.getPlugin();
        FileConfiguration config = plugin.getConfig();
        this.util = plugin.getUtil();

        //Anti Spawn Trapping

        //player can not place blocks in his and the other teams spawn points
        //the annoying tactic of spawn trapping is prevented

        if (!(event.getPlayer().getWorld().getName().equals("world_bedwars")))  return;
        if (!(event.getPlayer().getGameMode() == GameMode.SURVIVAL)) return;
        if (util.getSpawnBlocks(config.getLocation("team.red.teamSpawn")).contains(event.getBlock().getLocation())) {
                event.setCancelled(true);
        } else if (util.getSpawnBlocks(config.getLocation("team.blue.teamSpawn")).contains(event.getBlock().getLocation())) {
            event.setCancelled(true);
        } else if (util.getSpawnBlocks(config.getLocation("team.green.teamSpawn")).contains(event.getBlock().getLocation())) {
            event.setCancelled(true);
        } else if (util.getSpawnBlocks(config.getLocation("team.yellow.teamSpawn")).contains(event.getBlock().getLocation())) {
            event.setCancelled(true);
        }
    }
}
