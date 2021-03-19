package dev.rhco.utils.utilities;

import java.io.File;

import dev.rhco.utils.Utils;
import org.bukkit.plugin.Plugin;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigFile extends YamlConfiguration {
    private static ConfigFile config;
    private Plugin plugin;
    private File configFile;
    
    public static ConfigFile getConfig() {
        if (ConfigFile.config == null) {
            ConfigFile.config = new ConfigFile();
        }
        return ConfigFile.config;
    }
    
    private Plugin main() {
        return Utils.getPlugin();
    }
    
    public ConfigFile() {
        this.plugin = this.main();
        this.configFile = new File(this.plugin.getDataFolder(), "config.yml");
        this.saveDefault();
        this.reload();
    }
    
    public void reload() {
        try {
            super.load(this.configFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void save() {
        try {
            super.save(this.configFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void saveDefault() {
        this.plugin.saveResource("config.yml", false);
    }
    
    public static void saveConfig() {
    	ConfigFile.config.save();
    	ConfigFile.config.reload();
    }
}
