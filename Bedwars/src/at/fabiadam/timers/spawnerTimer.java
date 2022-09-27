package at.fabiadam.timers;

import at.fabiadam.main.MainBedwars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class spawnerTimer {
    private static int taskId = 0;

    public static void startSpawnerScheduler() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MainBedwars.getPlugin(), new Runnable() {
            int i = 0;

            @Override
            public void run() {
                Location spawnerB1 = new Location(Bukkit.getWorld("world_bedwars"), 4.5, 76, 50.5);
                Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
                    spawnerB1.getWorld().dropItemNaturally(spawnerB1, new ItemStack(Material.BRICK));
                });
            }
        }, 0, 20);
    }
}
