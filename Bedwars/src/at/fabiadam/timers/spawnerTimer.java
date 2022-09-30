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
    private static World bedwarsWorld;
    private static double time;

    public static void startSpawnerScheduler() {
        bedwarsWorld = Bukkit.getWorld("world_bedwars");
        time = 0;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MainBedwars.getPlugin(), new Runnable() {
            @Override
            public void run() {
                dropBrick();
                if(time/8-(int)(time/8) == 0) {
                    dropIron();
                }
                if(time/40-(int)(time/40) == 0) {
                    dropGold();
                }
                time++;
            }
        }, 0, 20);
    }
    public static void dropBrick() {
        bedwarsWorld.dropItem(new Location(bedwarsWorld, 4.5, 76, 50.5), new ItemStack(Material.BRICK));
        bedwarsWorld.dropItem(new Location(bedwarsWorld, -49.5, 76, 4.5), new ItemStack(Material.BRICK));
        bedwarsWorld.dropItem(new Location(bedwarsWorld, 50.5, 76, -3.5), new ItemStack(Material.BRICK));
        bedwarsWorld.dropItem(new Location(bedwarsWorld, -3.5, 76, -49.5), new ItemStack(Material.BRICK));
    }
    public static void dropIron() {
        bedwarsWorld.dropItem(new Location(bedwarsWorld, -3.5, 76, 50.5), new ItemStack(Material.IRON_INGOT));
        bedwarsWorld.dropItem(new Location(bedwarsWorld, -49.5, 76, -3.5), new ItemStack(Material.IRON_INGOT));
        bedwarsWorld.dropItem(new Location(bedwarsWorld, 50.5, 76, 4.5), new ItemStack(Material.IRON_INGOT));
        bedwarsWorld.dropItem(new Location(bedwarsWorld, 4.5, 76, -49.5), new ItemStack(Material.IRON_INGOT));
    }
    public static void dropGold() {

    }
}