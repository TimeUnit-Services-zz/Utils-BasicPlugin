package dev.rhco.utils.board;

import dev.rhco.utils.Utils;
import net.minecraft.util.com.google.common.base.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.plugin.*;
import org.bukkit.entity.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ScoreboardManager
{
    private static Map<String, LibScoreboard> boards;
    private static ScoreboardConfiguration configuration;
    private static boolean initiated;
    private static int updateInterval;
    
    static {
        ScoreboardManager.boards = new ConcurrentHashMap<String, LibScoreboard>();
        ScoreboardManager.configuration = null;
        ScoreboardManager.initiated = false;
        ScoreboardManager.updateInterval = 2;
    }
    
    public static void init() {
        Preconditions.checkState(!ScoreboardManager.initiated);
        ScoreboardManager.initiated = true;
        new ScoreboardThread().start();
        Bukkit.getPluginManager().registerEvents((Listener)new ScoreboardListener(), (Plugin) Utils.getInstance());
    }
    
    protected static void create(Player player) {
        if (ScoreboardManager.configuration != null) {
            ScoreboardManager.boards.put(player.getName(), new LibScoreboard(player));
        }
    }
    
    protected static void updateScoreboard(Player player) {
        LibScoreboard board = ScoreboardManager.boards.get(player.getName());
        if (board != null) {
            board.update();
        }
    }
    
    protected static void remove(Player player) {
        ScoreboardManager.boards.remove(player.getName());
    }
    
    public static ScoreboardConfiguration getConfiguration() {
        return ScoreboardManager.configuration;
    }
    
    public static void setConfiguration(ScoreboardConfiguration configuration) {
        ScoreboardManager.configuration = configuration;
    }
    
    public static int getUpdateInterval() {
        return ScoreboardManager.updateInterval;
    }
    
    public static void setUpdateInterval(int updateInterval) {
        ScoreboardManager.updateInterval = updateInterval;
    }
}
