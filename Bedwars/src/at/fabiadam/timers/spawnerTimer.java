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
                bedwarsWorld.dropItemNaturally(new Location(bedwarsWorld, 4.5, 76, 0.5), new ItemStack(Material.BRICK));
            }
        }, 0, 20);
    }
}