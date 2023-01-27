package at.fabiadam.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.LinkedList;
import java.util.List;

public class MapReset implements Listener {
    //This class is used to reset the map after a game
    //Currently it is not in use, but it will be used in the future
    //So for now if you build something in the map, it will not be deleted after game
    //My plan is to not regenerate the whole map, but to track what locations a block was placed and then delete them
    //This also means we can not track for example an exploding tnt, I mean we could but will not!
    //Resetting a map is not that easy and Fabis raspberry will not hande millions of blocks :D

    private static List<BlockData> changes = new LinkedList<>();
    private static List<Location> changesLoc = new LinkedList<>();
    private static List<Material> changesMat = new LinkedList<>();

    public static void restore() {
        int blocks = 0;

        /*for(String b : changes) {
            String[] blockdata = b.split(":");

            BlockData data = blockdata[0];
        }*/
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block b = event.getBlock();
        changes.add(b.getBlockData());
        changesLoc.add(b.getLocation());
        changesMat.add(b.getType());
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Block b = event.getBlock();
        String block = b.getType() + ":" + b.getBlockData() + ":" + b.getLocation();
        //changes.add(block);
    }

}
