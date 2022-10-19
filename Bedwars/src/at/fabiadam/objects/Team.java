package at.fabiadam.objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String color;
    private int playerCount;
    private int maxPlayerCount;
    private List<Player> players = new ArrayList<>();
    private boolean bedActive;
    private Location teamSpawn;


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
        if(playerCount < maxPlayerCount) {
            players.add(player);
            playerCount++;
        }
    }
    public void setTeamSpawn(Location teamSpawn) {
        this.teamSpawn = teamSpawn;
    }
    public Location getTeamSpawn() {
        return teamSpawn;
    }
    public boolean isBedActive() {
        return bedActive;
    }
    public void setBedActive(boolean active) {
        bedActive = active;
    }


    public Team(String color, int maxPlayerCount,  Location teamSpawn) {
        this.color = color;
        this.maxPlayerCount = maxPlayerCount;
        this.teamSpawn = teamSpawn;
    }
    public Team(String color, int playerCount, int maxPlayerCount, List<Player> players, boolean bedActive) {
        this.color = color;
        this.playerCount = playerCount;
        this.maxPlayerCount = maxPlayerCount;
        this.players = players;
        this.bedActive = bedActive;
    }

    public String getTeamColor() {
        return color;
    }


}
