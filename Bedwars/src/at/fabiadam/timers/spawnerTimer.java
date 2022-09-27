package at.fabiadam.timers;

import at.fabiadam.main.MainBedwars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class spawnerTimer {
    private static int taskId = 0;

    public static void startSpawnerScheduler() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MainBedwars.getPlugin(), new Runnable() {
            World bedwarsWorld = Bukkit.getWorld("world_bedwars");
            @Override
            public void run() {
                bedwarsWorld.dropItemNaturally(new Location(bedwarsWorld, 4.5, 76, 50.5), new ItemStack(Material.BRICK));
                bedwarsWorld.dropItemNaturally(new Location(bedwarsWorld, -3.5, 76, 50.5), new ItemStack(Material.IRON_INGOT));
                bedwarsWorld.dropItemNaturally(new Location(bedwarsWorld, -49.5, 76, 4.5), new ItemStack(Material.BRICK));
                bedwarsWorld.dropItemNaturally(new Location(bedwarsWorld, -49.5, 76, -3.5), new ItemStack(Material.IRON_INGOT));
                bedwarsWorld.dropItemNaturally(new Location(bedwarsWorld, 50.5, 76, -3.5), new ItemStack(Material.BRICK));
                bedwarsWorld.dropItemNaturally(new Location(bedwarsWorld, 50.5, 76, 4.5), new ItemStack(Material.IRON_INGOT));
                bedwarsWorld.dropItemNaturally(new Location(bedwarsWorld, -3.5, 76, -49.5), new ItemStack(Material.BRICK));
                bedwarsWorld.dropItemNaturally(new Location(bedwarsWorld, 4.5, 76, -49.5), new ItemStack(Material.IRON_INGOT));
            }
        }, 0, 20);
    }
}