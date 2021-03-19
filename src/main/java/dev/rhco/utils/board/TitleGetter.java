package dev.rhco.utils.board;

import org.bukkit.*;
import net.minecraft.util.com.google.common.base.*;
import org.bukkit.entity.*;

public class TitleGetter
{
    private String defaultTitle;
    
    public TitleGetter(String defaultTitle) {
        this.defaultTitle = ChatColor.translateAlternateColorCodes('&', defaultTitle);
    }
    
    public TitleGetter() {
    }
    
    public static TitleGetter forStaticString(String string) {
        Preconditions.checkNotNull(string);
        return new TitleGetter() {
            @Override
            public String getTitle(Player player) {
                return string;
            }
        };
    }
    
    public String getTitle(Player player) {
        return this.defaultTitle;
    }
}
