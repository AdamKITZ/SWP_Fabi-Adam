package at.fabiadam.timers;

import at.fabiadam.main.MainBedwars;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;


public class SpawnerTimer {
    //This time activates the spawners
    //It extends the abstract class Timer
    private static final int taskId = 0;
    private static World bedwarsWorld;
    private static double time;
    private MainBedwars plugin;
    private FileConfiguration config;

    public void startSpawnerScheduler() {
        plugin = MainBedwars.getPlugin();
        config = plugin.getConfig();
        bedwarsWorld = Bukkit.getWorld("world_bedwars");
        time = 0;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MainBedwars.getPlugin(), new Runnable() {
            @Override
            public void run() {
                //So any second, a brick is dropped at the spawner
                //Every 8th second, an iron is dropped at the spawner
                //Every 40th second, a gold is dropped at the spawner
                dropBrick();
                if (time / 8 - (int) (time / 8) == 0) {
                    dropIron();
                }
                if (time / 40 - (int) (time / 40) == 0) {
                    dropGold();
                }
                time++;
                plugin.saveConfig();
            }
        }, 0, 20);
    }

    //Method that drops the brick
    public void dropBrick() {
        for (int i = 1; i < 5; i++) {
            if (config.contains("spawner.bronze." + i + ".loc")) {
                bedwarsWorld.dropItem(config.getLocation("spawner.bronze." + i + ".loc"), new ItemStack(Material.BRICK));
            }
        }
    }
    //Method that drops the iron
    public void dropIron() {
        for (int i = 1; i < 5; i++) {
            if (config.contains("spawner.iron." + i + ".loc")) {
                bedwarsWorld.dropItem(config.getLocation("spawner.iron." + i + ".loc"), new ItemStack(Material.IRON_INGOT));
            }
        }
    }
    //Method that drops the gold
    public void dropGold() {
        for (int i = 1; i < 5; i++) {
            if (config.contains("spawner.gold." + i + ".loc")) {
                bedwarsWorld.dropItem(config.getLocation("spawner.gold." + i + ".loc"), new ItemStack(Material.GOLD_INGOT));
            }
        }
    }
}