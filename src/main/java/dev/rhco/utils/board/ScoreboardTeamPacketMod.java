package dev.rhco.utils.board;

import java.lang.reflect.*;
import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import net.minecraft.server.v1_7_R4.*;

public class ScoreboardTeamPacketMod
{
    private PacketPlayOutScoreboardTeam packet;
    private static Field aField;
    private static Field bField;
    private static Field cField;
    private static Field dField;
    private static Field eField;
    private static Field fField;
    private static Field gField;
    
    static {
        try {
            ScoreboardTeamPacketMod.aField = PacketPlayOutScoreboardTeam.class.getDeclaredField("a");
            ScoreboardTeamPacketMod.bField = PacketPlayOutScoreboardTeam.class.getDeclaredField("b");
            ScoreboardTeamPacketMod.cField = PacketPlayOutScoreboardTeam.class.getDeclaredField("c");
            ScoreboardTeamPacketMod.dField = PacketPlayOutScoreboardTeam.class.getDeclaredField("d");
            ScoreboardTeamPacketMod.eField = PacketPlayOutScoreboardTeam.class.getDeclaredField("e");
            ScoreboardTeamPacketMod.fField = PacketPlayOutScoreboardTeam.class.getDeclaredField("f");
            ScoreboardTeamPacketMod.gField = PacketPlayOutScoreboardTeam.class.getDeclaredField("g");
            ScoreboardTeamPacketMod.aField.setAccessible(true);
            ScoreboardTeamPacketMod.bField.setAccessible(true);
            ScoreboardTeamPacketMod.cField.setAccessible(true);
            ScoreboardTeamPacketMod.dField.setAccessible(true);
            ScoreboardTeamPacketMod.eField.setAccessible(true);
            ScoreboardTeamPacketMod.fField.setAccessible(true);
            ScoreboardTeamPacketMod.gField.setAccessible(true);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ScoreboardTeamPacketMod(String name, String prefix, String suffix, @SuppressWarnings("rawtypes") Collection players, int i) {
        this.packet = new PacketPlayOutScoreboardTeam();
        try {
            ScoreboardTeamPacketMod.aField.set(this.packet, name);
            ScoreboardTeamPacketMod.fField.set(this.packet, i);
            if (i == 0 || i == 2) {
                ScoreboardTeamPacketMod.bField.set(this.packet, name);
                ScoreboardTeamPacketMod.cField.set(this.packet, prefix);
                ScoreboardTeamPacketMod.dField.set(this.packet, suffix);
                ScoreboardTeamPacketMod.gField.set(this.packet, 3);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if (i == 0) {
            this.addAll(players);
        }
    }
    
    public ScoreboardTeamPacketMod(String name, @SuppressWarnings("rawtypes") Collection players, int paramInt) {
        this.packet = new PacketPlayOutScoreboardTeam();
        try {
            ScoreboardTeamPacketMod.gField.set(this.packet, 3);
            ScoreboardTeamPacketMod.aField.set(this.packet, name);
            ScoreboardTeamPacketMod.fField.set(this.packet, paramInt);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        this.addAll(players);
    }
    
    public void sendToPlayer(Player bukkitPlayer) {
        ((CraftPlayer)bukkitPlayer).getHandle().playerConnection.sendPacket((Packet)this.packet);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void addAll(Collection collection) {
        if (collection == null) {
            return;
        }
        try {
            ((Collection)ScoreboardTeamPacketMod.eField.get(this.packet)).addAll(collection);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
