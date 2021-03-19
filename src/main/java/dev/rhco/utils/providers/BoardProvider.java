package dev.rhco.utils.providers;

import java.util.LinkedList;

import dev.rhco.utils.Utils;
import dev.rhco.utils.board.ScoreGetter;
import dev.rhco.utils.utilities.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class BoardProvider implements ScoreGetter {

    private String formatBasicTps(double tps) {
        return "" + Math.min(Math.round(tps * 10.0) / 10.0, 20.0);
    }

    public void getScores(LinkedList<String> scores, Player player) {
            double tps = Bukkit.spigot().getTPS()[1];
            ChatColor colour = (tps >= 18.0) ? ChatColor.GREEN : ((tps >= 13.0) ? ChatColor.YELLOW : ChatColor.RED);
            String.valueOf(Bukkit.getOnlinePlayers().size());

            for (String line : CC.translate(Utils.getInstance().getConfig().getStringList("SCOREBOARD.CONFIG"))) {
                scores.add(CC.translate(line.replace("%playername%", player.getName())
                        .replace("%tps%", formatBasicTps(tps))
                        .replace("%online%", String.valueOf(Bukkit.getOnlinePlayers().size()))
                        .replace("%d_arrow%", "»")
                        .replace("%yes%", "✓")
                        .replace("%no%", "✘")
                        .replace("%star%", "★")
                        .replace("%crown%", "♕")
                        .replace("%sad%", "☹")
                        .replace("%bigarrow%", "➤")
                        .replace("%airplane%", "✈")
                        .replace("%arrowlittle%", "▸")));
        }
    }
}


