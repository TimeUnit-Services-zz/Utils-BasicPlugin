package dev.rhco.utils.nametags;

import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@Getter
public class NametagBoard {

    private Player player;
    private Set<BufferedNametag> currentEntries = new HashSet<>();

    public NametagBoard(Player player) {
        this.player = player;
    }
    
    public Player getPlayer() {
		return player;
	}
    
    public Set<BufferedNametag> getCurrentEntries() {
		return currentEntries;
	}
}
