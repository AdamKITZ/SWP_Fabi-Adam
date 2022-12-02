package at.fabiadam.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Board {


    public void setScoreboard(Player player) {
        if (player.getWorld().getName().equals("world_bedwars")) {
            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective object = board.registerNewObjective("test", "dummy");
            object.setDisplaySlot(DisplaySlot.SIDEBAR);
            object.setDisplayName("§a§lScoreboard");

            object.getScore(Bukkit.getName() + "'s Scoreboard").setScore(6);
            object.getScore(" ").setScore(5);
            object.getScore("§a✓ §cRed").setScore(4);
            object.getScore("§a✓ §aGreen").setScore(3);
            object.getScore("§a✓ §bBlue").setScore(2);
            object.getScore("§a✓ §yYellow").setScore(1);
            player.setScoreboard(board);
        }

    }


    public void updateScoreboard(Player player) {
        //Coming soon test
    }

}
