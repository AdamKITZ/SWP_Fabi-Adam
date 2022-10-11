package at.fabiadam.commands;

import at.fabiadam.main.MainBedwars;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    public MainBedwars plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin = MainBedwars.getPlugin();
        if(sender instanceof Player) {
            if(command.getName().equalsIgnoreCase("bw")) {
                Player player = (Player) sender;
                switch(args[0].toLowerCase()) {
                    case "setspawner":
                        if(player.hasPermission("bedwars.setspawner")) {
                            if(player.getWorld().getName().equals("world_bedwars")) {
                                if(args[0].equalsIgnoreCase("bronze") || args[0].equalsIgnoreCase("iron") || args[0].equalsIgnoreCase("gold")) {
                                    if (args[1].matches("[1-4]+")) {
                                        FileConfiguration config = plugin.getConfig();
                                        config.set("spawner." + args[0] + "." + args[1] + ".log", player.getLocation());
                                        player.sendMessage("§b" + args[0].toUpperCase() + " spawner set!");
                                        plugin.saveConfig();
                                    }
                                }
                            } else {
                                player.sendMessage("§cYou can not do this on your current world!");
                            }
                        } else {
                            player.sendMessage("§cYou do not have enough permission to perform this action!");
                        }
                        break;
                    case "setbed":
                        if(player.hasPermission("bedwars.setbed")) {

                        }
                        break;
                    default:
                        break;
            }
            }
        } else {
            sender.sendMessage("§cYou can only do this as a player!");
        }
        return true;
    }
}
