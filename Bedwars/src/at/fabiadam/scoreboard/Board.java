package at.fabiadam.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Board implements Listener {

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(player.getWorld().getName().equals("world_bedwars_l")){

            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective object = board.registerNewObjective("s1","s2");

            object.setDisplaySlot(DisplaySlot.SIDEBAR);
            object.setDisplayName("§a§Willkommen!");

            object.getScore("§aTest Line 3").setScore(3);
            object.getScore("§c§lTest Line 4").setScore(4);
            object.getScore("§a§hTest Line 5").setScore(5);
        }

    }

}
