package dev.rhco.utils;

import dev.rhco.utils.board.ScoreboardManager;
import dev.rhco.utils.board.config.ScoreboardProviders;
import dev.rhco.utils.tablist.Azazel;
import dev.rhco.utils.tablist.tab.example.TabProvider;
import dev.rhco.utils.utilities.ConfigFile;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Utils extends JavaPlugin {
    private static Utils plugin;
    @Getter @Setter ConfigFile ConfigFile;


    public void onEnable() {
        plugin = this;
        this.ConfigFile = new ConfigFile();
        new Azazel(this, new TabProvider());
        ScoreboardManager.init();
        ScoreboardManager.setConfiguration(ScoreboardProviders.create());
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&eEnabling Utils..."));
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cDisable Utils..."));
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-all");
    }
    public static Utils getInstance() {
        return plugin;
    }
    public static Utils getPlugin() {
        return plugin;
    }
}
