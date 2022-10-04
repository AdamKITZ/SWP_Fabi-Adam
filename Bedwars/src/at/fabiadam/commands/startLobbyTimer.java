package at.fabiadam.commands;

import at.fabiadam.timers.lobbyTimer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class startLobbyTimer implements CommandExecutor {
    private lobbyTimer lobbyTimer;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        lobbyTimer = lobbyTimer.getLobbyTimer();
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("bedwars.start")) {
                if(player.getWorld().getName().equals("world_bedwars_l")) {
                    lobbyTimer.startScheduler(true);
                } else {
                    player.sendMessage("§cYou can not do this on your current world!");
                }
            } else {
                player.sendMessage("§cYou do not have enough permission to perform this action!");
            }
        } else {
            sender.sendMessage("§cYou can only do this as a player!");
        }
        return true;
    }
}
