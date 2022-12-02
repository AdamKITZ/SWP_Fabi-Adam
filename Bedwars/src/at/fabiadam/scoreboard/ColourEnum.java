package at.fabiadam.scoreboard;

import org.bukkit.ChatColor;

public enum ColourEnum {
    ENTRY_0(0, ChatColor.YELLOW.toString()),
    ENTRY_1(1, ChatColor.DARK_RED.toString()),
    ENTRY_2(2, ChatColor.RED.toString());

    private final Integer entry;
    private final String entryString;

    ColourEnum(Integer entry, String entryString) {
        this.entry = entry;
        this.entryString = entryString;
    }

    public Integer getEntry() {
        return entry;
    }

    public String getEntryString() {
        return entryString;
    }

}
