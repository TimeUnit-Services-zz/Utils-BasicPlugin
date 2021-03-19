package dev.rhco.utils.providers;

import dev.rhco.utils.Utils;
import dev.rhco.utils.nametags.BufferedNametag;
import dev.rhco.utils.nametags.NametagAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;


public class NametagProvider implements NametagAdapter {

	public List<BufferedNametag> getPlate(Player player) {
		List<BufferedNametag> tags = new ArrayList<BufferedNametag>();
		for(Player players : Bukkit.getOnlinePlayers()) {
			if(players == null) {
				return null;
			}
			
			BufferedNametag nametag = new BufferedNametag(players.getName(), ChatColor.RED.toString(), "", false, false, players);

			if (players.hasPermission(Utils.getInstance().getConfig().getString("NAMETAGS.FAMOUS"))){
				nametag = new BufferedNametag(players.getName(), ChatColor.DARK_PURPLE.toString(), "", false, false, player);
			}
			if (players.hasPermission(Utils.getInstance().getConfig().getString("NAMETAGS.YOUTUBER"))) {
				nametag = new BufferedNametag(players.getName(), ChatColor.DARK_AQUA.toString(), "", false, false, player);
			}
			if (players.hasPermission(Utils.getInstance().getConfig().getString("NAMETAGS.MINIYT"))){
				nametag = new BufferedNametag(players.getName(), ChatColor.DARK_GREEN.toString(), "", false, false, player);
			}
			if (players.hasPermission(Utils.getInstance().getConfig().getString("NAMETAGS.DONATOR"))){
				nametag = new BufferedNametag(players.getName(), ChatColor.DARK_BLUE.toString(), "", false, false, player);
			}
			if (players.isOp()){
				nametag = new BufferedNametag(players.getName(), ChatColor.DARK_RED.toString(), "", false, false, player);
			}
			tags.add(nametag);
		}
		return tags;
	}

}
