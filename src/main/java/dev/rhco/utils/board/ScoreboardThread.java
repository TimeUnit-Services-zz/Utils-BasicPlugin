package dev.rhco.utils.board;

import org.bukkit.*;
import org.bukkit.entity.*;

public class ScoreboardThread extends Thread
{
    public ScoreboardThread() {
        super("HCF - Scoreboard Thread");
        this.setDaemon(true);
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public void run() {
        while (true) {
            Player[] onlinePlayers;
            for (int length = (onlinePlayers = Bukkit.getOnlinePlayers().toArray(new Player[0])).length, i = 0; i < length; ++i) {
                Player other = onlinePlayers[i];
                try {
                    ScoreboardManager.updateScoreboard(other);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            try {
                Thread.sleep(ScoreboardManager.getUpdateInterval() * 50);
            }
            catch (InterruptedException ex2) {
                ex2.printStackTrace();
            }
        }
    }
}
