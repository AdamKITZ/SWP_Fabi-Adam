package at.fabiadam.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Board implements Listener {

    @EventHandler
    public void handlePlayerJoin(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();

        if(player.getWorld().getName().equals("world_bedwars")){
            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective object = board.registerNewObjective("test", "dummy");

            object.setDisplaySlot(DisplaySlot.SIDEBAR);
            object.setDisplayName("§a§lWelcome!");

            object.getScore(" ").setScore(6);
            object.getScore("§aKills ").setScore(5);
            object.getScore("§a✓ §cRed").setScore(4);
            object.getScore("§a✓ §aGreen").setScore(3);
            object.getScore("§a✓ §bBlue").setScore(2);
            object.getScore("§a✓ §Yellow").setScore(1);
            player.setScoreboard(board);
        }

    }

}
