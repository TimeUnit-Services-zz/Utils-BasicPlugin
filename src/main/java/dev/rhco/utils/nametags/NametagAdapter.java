package dev.rhco.utils.nametags;

import java.util.List;

import org.bukkit.entity.Player;

public interface NametagAdapter {

    List<BufferedNametag> getPlate(Player player);
}
