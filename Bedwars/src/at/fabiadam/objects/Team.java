package at.fabiadam.objects;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String color;
    private int playerCount;
    private int maxPlayerCount;
    private List<Player> players;
    private boolean isBedActive;


    public String getColor() {
        return color;
    }
    public int getPlayerCount() {
        return playerCount;
    }
    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }
    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
    public  List<Player> getPlayers() {
        return players;
    }
    public void addPlayer(Player player) {
        players.add(player);
    }
    public boolean isBedActive() {
        return isBedActive;
    }
    public void setBedActive(boolean bedActive) {
        isBedActive = bedActive;
    }

    public Team(String color, int playerCount, int maxPlayerCount, List<Player> players, boolean isBedActive) {
        this.color = color;
        this.playerCount = playerCount;
        this.maxPlayerCount = maxPlayerCount;
        this.players = players;
        this.isBedActive = isBedActive;
    }

    public String getTeamColor() {
        return color;
    }


}
