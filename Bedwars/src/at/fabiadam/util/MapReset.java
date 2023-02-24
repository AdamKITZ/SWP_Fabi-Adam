package at.fabiadam.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
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
    private static final List<Location> locs = new ArrayList<Location>();

    public void restore() {
        int blocks = 0;

        for(Location l : locs) {
            l.getBlock().setType(Material.AIR);
            blocks++;
        }
        locs.clear();
        restoreBeds();
    }

    public void restoreBeds() {
        restoreRedBed();
        restoreGreenBed();
        restoreBlueBed();
        restoreYellowBed();
    }


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if(event.getPlayer().getWorld().getName().equals("world_bedwars")) {
            if(event.isCancelled()) return;
            Block b = event.getBlock();
            locs.add(b.getLocation());
        }
    }
    
    public void restoreRedBed() {
        Block foot = Bukkit.getServer().getWorld("world_bedwars").getBlockAt(-1, 81, 90);
        foot.setType(Material.RED_BED);
        Block head = Bukkit.getServer().getWorld("world_bedwars").getBlockAt(-1, 81, 91);
        head.setType(Material.RED_BED);
        BlockState footState = foot.getState();
        BlockState headState = head.getState();
        footState.setRawData((byte) 0x0);
        headState.setRawData((byte) 0x8);
        footState.update(true, false);
        headState.update(true, true);
    }

    public void restoreGreenBed() {
        BlockData bedData = Bukkit.createBlockData("minecraft:green_bed[facing=west,part=foot]");
        BlockData bedHeadData = Bukkit.createBlockData("minecraft:green_bed[facing=west,part=head]");
        Location bedLoc = new Location(Bukkit.getServer().getWorld("world_bedwars"), -90, 80, -1);
        Location bedHeadLoc = new Location(Bukkit.getServer().getWorld("world_bedwars"), -91, 80, -1);
        bedLoc.getBlock().setBlockData(bedData);
        bedHeadLoc.getBlock().setBlockData(bedHeadData);
    }

    public void restoreBlueBed() {

        BlockData bedData = Bukkit.createBlockData("minecraft:blue_bed[facing=north,part=foot]");
        BlockData bedHeadData = Bukkit.createBlockData("minecraft:blue_bed[facing=north,part=head]");
        Location bedLoc = new Location(Bukkit.getServer().getWorld("world_bedwars"), 1, 80, -90);
        Location bedHeadLoc = new Location(Bukkit.getServer().getWorld("world_bedwars"), 1, 80, -91);
        bedLoc.getBlock().setBlockData(bedData);
        bedHeadLoc.getBlock().setBlockData(bedHeadData);
    }

    public void restoreYellowBed() {
        BlockData bedData = Bukkit.createBlockData("minecraft:yellow_bed[facing=east,part=foot]");
        BlockData bedHeadData = Bukkit.createBlockData("minecraft:yellow_bed[facing=east,part=head]");
        Location bedLoc = new Location(Bukkit.getServer().getWorld("world_bedwars"), 90, 80, 1);
        Location bedHeadLoc = new Location(Bukkit.getServer().getWorld("world_bedwars"), 91, 80, 1);
        bedLoc.getBlock().setBlockData(bedData);
        bedHeadLoc.getBlock().setBlockData(bedHeadData);
    }


}
