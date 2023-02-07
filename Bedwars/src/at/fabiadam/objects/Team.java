package at.fabiadam.objects;

import at.fabiadam.items.BlockEnum;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {
    //My lovely Team object class
    //This class is used to store all information about a team
    //It also includes many useful methods
    //For example it stores the players in a team, some bed information, the spawn location and the team color
    private String color;
    private int playerCount;
    private int maxPlayerCount;
    private List<Player> players = new ArrayList<>();
    private boolean bedActive;
    private Location teamSpawn;


    //Gets how much players are in one team, currently we only allow 1 player per team and 4 Teams
    public int getPlayerCount() {
        return playerCount;
    }

    //Gets the max player count, currently we only allow 1 player per team
    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    //Not in use yet, but it will be used to set the max player count
    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    //Returns all the players in a team
    public List<Player> getPlayers() {
        return players;
    }

    //Adds a player to a team
    public void addPlayer(Player player) {
        if (playerCount < maxPlayerCount) {
            players.add(player);
            playerCount++;
        }
    }
    /// Adam ist ein cooler syphatischer, kluger, Junge mit Käserand an den Eiern....

    //Not in use because we set the team spawn ingame, it will the be saved to the config file
    public void setTeamSpawn(Location teamSpawn) {
        this.teamSpawn = teamSpawn;
    }

    //Gets the teamSpawn
    public Location getTeamSpawn() {
        return teamSpawn;
    }

    //Returns if a bed is active or not, if not, players can't respawn
    public boolean isBedActive() {
        return bedActive;
    }

    //Sets if a bed is active or not
    public void setBedActive(boolean active) {
        bedActive = active;
    }



    //Constructor
    public Team(String color, int maxPlayerCount, Location teamSpawn, boolean bedActive) {
        this.color = color;
        this.maxPlayerCount = maxPlayerCount;
        this.teamSpawn = teamSpawn;
        this.bedActive =  bedActive;
    }
    //2nd Constructor
    public Team(String color, int playerCount, int maxPlayerCount, List<Player> players, boolean bedActive) {
        this.color = color;
        this.playerCount = playerCount;
        this.maxPlayerCount = maxPlayerCount;
        this.players = players;
        this.bedActive = bedActive;
    }
    //Returns the team color
    public String getTeamColor() {
        return color;
    }


}
