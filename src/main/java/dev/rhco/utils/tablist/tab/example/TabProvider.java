package dev.rhco.utils.tablist.tab.example;

import dev.rhco.utils.Utils;
import dev.rhco.utils.tablist.tab.TabAdapter;
import dev.rhco.utils.tablist.tab.TabTemplate;
import dev.rhco.utils.utilities.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TabProvider implements TabAdapter {
    public TabTemplate getTemplate(Player player) {
        TabTemplate tab = new TabTemplate();

        tab.left(0, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line1") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(1, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line2") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(2, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line3") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(3, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line4") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(4, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line5") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(5, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line6") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(6, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line7") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(7, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line8") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(8, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line9") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(9, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line10") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(10, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line11") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(11, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line12") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(12, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line13") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(13, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line14") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(14, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line15") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(15, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line16") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(16, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line17") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(17, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line18") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(18, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line19") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.left(19, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Left.Line20") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));

        tab.middle(0, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line1") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(1, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line2") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(2, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line3") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(3, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line4") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(4, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line5") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(5, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line6") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(6, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line7") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(7, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line8") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(8, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line9") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(9, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line10") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(10, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line11") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(11, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line12") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(12, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line13") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(13, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line14") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(14, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line15") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(15, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line16") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(16, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line17") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(17, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line18") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(18, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line19") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.middle(19, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Middle.Line20") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));

        tab.right(0, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line1").replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName()) .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(1, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line2") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(2, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line3") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(3, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line4") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(4, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line5") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(5, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line6") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(6, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line7") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(7, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line8") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(8, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line9") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(9, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line10") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(10, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line11") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(11, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line12") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(12, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line13") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(13, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line14") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(14, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line15") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(15, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line16") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(16, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line17") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(17, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line18") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(18, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line19") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        tab.right(19, CC.translate(dev.rhco.utils.Utils.getInstance().getConfig().getString("Tablist.Right.Line20") .replace("%onlinePlayers%", String.valueOf(Bukkit.getOnlinePlayers().size())).replace("%player%", player.getName())));
        return tab;
    }
    private Utils Utils = dev.rhco.utils.Utils.getInstance();
}
