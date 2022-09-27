package at.fabiadam.util;

import at.fabiadam.objects.Team;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class BedwarsUtil {
    public List<Team> teamList = new ArrayList<>();
    public Team red;
    public Team blue;
    public Team green;
    public Team yellow;
    public void start() {
        red = new Team("red", 0, 1, null, true);
        blue = new Team("blue", 0, 1, null, true);
        green = new Team("green", 0, 1,null, true);
        yellow = new Team("yellow", 0, 1,null, true);
        teamList.add(red);
        teamList.add(blue);
        teamList.add(green);
        teamList.add(yellow);
        //Each player should be put into a team --> If team is full, try next team
        Bukkit.getWorld("world_bedwars").getPlayers().forEach(player -> {
            for(int i = 0; i<4; i++) {
                if(teamList.get(i).getPlayerCount() < teamList.get(i).getMaxPlayerCount()) {
                    teamList.get(i).addPlayer(player);
                    break;
                }
            }
        });
    }
}
