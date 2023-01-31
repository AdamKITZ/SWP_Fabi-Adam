package at.fabiadam.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MapReset implements Listener {
    //This class is used to reset the map after a game
    //Currently it is not in use, but it will be used in the future
    //So for now if you build something in the map, it will not be deleted after game
    //My plan is to not regenerate the whole map, but to track what locations a block was placed and then delete them
    //This also means we can not track for example an exploding tnt, I mean we could but will not!
    //Resetting a map is not that easy and Fabis raspberry will not hande millions of blocks :D
    private static List<Location> locs = new ArrayList<Location>();

    public void restore() {
        int blocks = 0;

        for(Location l : locs) {
            l.getBlock().setType(Material.AIR);
            blocks++;
        }
        locs.clear();
    }


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if(event.getPlayer().getWorld().getName().equals("world_bedwars")) {
            if(event.isCancelled()) return;
            Block b = event.getBlock();
            locs.add(b.getLocation());
        }
    }

}
