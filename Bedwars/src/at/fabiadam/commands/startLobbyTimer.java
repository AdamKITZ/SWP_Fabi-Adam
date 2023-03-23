package at.fabiadam.commands;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.timers.LobbyCountdown;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class startLobbyTimer implements CommandExecutor {
    private LobbyCountdown lobbyCountdown;


    //So this is another command we used at the beginning of programming
    //For you its not important because the lobby timer instantly starts whenever a player joins
    //This is because the lobby does not wait for 2 or more players. Important for debugging though
    //So maybe later it will be usable again
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        lobbyCountdown = MainBedwars.getLobbyTimer();
        //lobbyCountdown = LobbyCountdown.getLobbyTImer();
        if (sender instanceof Player player) {
            if (player.hasPermission("bedwars.start")) {
                if (player.getWorld().getName().equals("world_bedwars_l")) {
                    lobbyCountdown.start();
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
