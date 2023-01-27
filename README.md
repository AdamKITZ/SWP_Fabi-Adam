# Minecraft Bedwars Plugin

# First Setup

1. Download the provided zip file.
2. In this file is another zipped file called minecraft. You can either use this file, start "00start.bat" and join the server with address "localhost".
3. If you do not want to setup the server on your pc, Fabian has build a server at home, that you can join. The adress is "kitzweb.com".

## After joining the server
1. You are now in the first world. In this world there is nothing but a sign in front of you. You must click on that to get teleportet to the bedwars_lobby in wich you will wait until the needed players joined. IMPORTANT: We set minPlayers to 1, so you can test alone.
2. After joining the lobby, a countdown will start. It may start instantly, because minPlayers is set to 1. In our lobby you can wait, die or kill other players with the provided "Knockback Stick". Note that you must jump down from the "safe plattform" before being able to hit other players.
3. When the countdown is over, you will be teleported to the actuall game world (world_bedwars). You should be teleported to your teams color and also get a message that sais, "You are in team COLOR". Currently, you could gather iron, bricks or gold but there is no shop yet. Destroying another team's bed will also work but how would you get there without blocks from shop.
4. Wait until the plugin is 100% done and have even more fun.




## currently in work by @AdamKITZ & @stampFabian

Together we are developing a plugin for the well-known Java game Minecraft: Java edition. We are rebuilding an existing game mode called “Bedwars” where multiple players or teams are battling against each other. Target is to destroy other players beds because then, they will no longer respawn after their death.

### Trigger

Our plugin starts working as soon as players join the server and then change into the lobby world. Now the plugin changes to “Lobby State” and waits for more players to join. If enough players are available, the plugin changes to “Ingame State” where players can battle. Last state is “Ending State”, which is called when one team won.

### Actors

The actors are only players. When the plugin is done, there is no server administrator needed, to change game states or even reset the lobby. Everything works fine with only players playing.

### Preconditions

Not much is needed before players can start. There must be any bukkit/spigot/paper Minecraft server running on which the plugin works fine. Only the world names are hardcoded, so now you wont be able to just put this plugin on your server and start playing. You must create two worlds called “world_bedwars_l” for the lobby and “world_bedwars” for the battle world. Those can be created with “Multiverse Core” and world changing will be easy with “Multiverse Sign-Portals”.
Spawns of players and spawners can be created by server administrators with special permission.
 
### Steps

First, a player joins the lobby world, then our plugin changes to “Lobby State”. In this state the plugin is idling and waiting for more players to join. If enough players are available the lobby countdown starts. After that, “Ingame State” starts and players will be teleported to their team-spawns in the battle world.
Now players are able to fight and if one team is the winner, ending state will be started. Now the world will be reset and players are teleported to the normal world. Now the server is available for another round and will be set to lobby state.

### Involved classes

So our plugin has many different classes which are able to handle all of the above steps.
Here’s a list of the most important classes and what they do:
•	Commands
This class contains all logic for the commands the server administrator can perform. He is able to create spawns of material and players
•	GameStateManager | LobbyState | IngameState | EndingState
The manager class is able to change the current gamestate. The rest contains all logic for the gamestates
•	Listeners (e.g. blockBreakEvent, onPlayerDeath, playerWorldChangeEvent)
Listeners are classes which contain functions that are started when something happens on the server. For example: When a player breaks a block in Minecraft, a function in the class “blockBreakEvent” is called. We are checking in which world the player is. Then we check the block and decide if the player shall be able to break it, otherwise the event will be cancled
•	Object classes (Team)
This class contains every information about a team. An object Team contains the team color, team players, team spawn many more information
Of course we have many more classes but explaining everything will be to much

## Our Duties Record Book
[Duties Record Book _ Adam & Fabian.docx](https://github.com/AdamKITZ/SWP_Fabi-Adam/files/10488960/Duties.Record.Book._.Adam.Fabian.docx)
