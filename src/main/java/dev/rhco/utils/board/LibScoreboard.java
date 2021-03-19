package dev.rhco.utils.board;

import org.bukkit.entity.*;
import java.util.function.Supplier;
import org.bukkit.scoreboard.*;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.*;
import net.minecraft.util.com.google.common.base.*;
import java.util.*;
import java.lang.reflect.*;
import net.minecraft.util.com.google.common.collect.*;
import net.minecraft.server.v1_7_R4.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;

public class LibScoreboard 
{
    private Player player;
    private Objective objective;
    private Map<String, Integer> displayedScores;
    private Map<String, String> scorePrefixes;
    private Map<String, String> scoreSuffixes;
    private Set<String> sentTeamCreates;
    private StringBuilder separateScoreBuilder;
    private List<String> separateScores;
    private Set<String> recentlyUpdatedScores;
    private Set<String> usedBaseScores;
    private String[] prefixScoreSuffix;
    private ThreadLocal<LinkedList<String>> localList;
    
    public LibScoreboard(Player player) {
        this.displayedScores = new HashMap<String, Integer>();
        this.scorePrefixes = new HashMap<String, String>();
        this.scoreSuffixes = new HashMap<String, String>();
        this.sentTeamCreates = new HashSet<String>();
        this.separateScoreBuilder = new StringBuilder();
        this.separateScores = new ArrayList<String>();
        this.recentlyUpdatedScores = new HashSet<String>();
        this.usedBaseScores = new HashSet<String>();
        this.prefixScoreSuffix = new String[3];
        this.localList = ThreadLocal.withInitial((Supplier<? extends LinkedList<String>>)LinkedList::new);
        this.player = player;
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        (this.objective = scoreboard.registerNewObjective("HCF", "dummy")).setDisplaySlot(DisplaySlot.SIDEBAR);
        player.setScoreboard(scoreboard);
    }
    
    public void update() {
        String untranslatedTitle = ScoreboardManager.getConfiguration().getTitleGetter().getTitle(this.player);
        String title = ChatColor.translateAlternateColorCodes('&', untranslatedTitle);
        List<String> lines = this.localList.get();
        if (!lines.isEmpty()) {
            lines.clear();
        }
        ScoreboardManager.getConfiguration().getScoreGetter().getScores(this.localList.get(), this.player);
        this.recentlyUpdatedScores.clear();
        this.usedBaseScores.clear();
        int nextValue = lines.size();
        Preconditions.checkArgument(lines.size() < 50, "Too many lines passed!");
        Preconditions.checkArgument(title.length() < 42, "Title is too long!");
        if (!this.objective.getDisplayName().equals(title)) {
            this.objective.setDisplayName(title);
        }
        for (String line : lines) {
            if (48 <= line.length()) {
                throw new IllegalArgumentException("Line is too long! Offending line: " + line);
            }
            String[] separated = this.separate(line, this.usedBaseScores);
            String prefix = separated[0];
            String score = separated[1];
            String suffix = separated[2];
            this.recentlyUpdatedScores.add(score);
            if (!this.sentTeamCreates.contains(score)) {
                this.createAndAddMember(score);
            }
            if (!this.displayedScores.containsKey(score) || this.displayedScores.get(score) != nextValue) {
                this.setScore(score, nextValue);
            }
            if (!this.scorePrefixes.containsKey(score) || !this.scorePrefixes.get(score).equals(prefix) || !this.scoreSuffixes.get(score).equals(suffix)) {
                this.updateScore(score, prefix, suffix);
            }
            --nextValue;
        }
        for (String displayedScore : ImmutableSet.copyOf(this.displayedScores.keySet())) {
            if (this.recentlyUpdatedScores.contains(displayedScore)) {
                continue;
            }
            this.removeScore(displayedScore);
        }
    }
    
    private void setField(Packet packet, String field, Object value) {
        try {
            Field fieldObject = packet.getClass().getDeclaredField(field);
            fieldObject.setAccessible(true);
            fieldObject.set(packet, value);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void createAndAddMember(String scoreTitle) {
        ScoreboardTeamPacketMod scoreboardTeamAdd = new ScoreboardTeamPacketMod(scoreTitle, "_", "_", ImmutableList.of(), 0);
        ScoreboardTeamPacketMod scoreboardTeamAddMember = new ScoreboardTeamPacketMod(scoreTitle, ImmutableList.of(scoreTitle), 3);
        scoreboardTeamAdd.sendToPlayer(this.player);
        scoreboardTeamAddMember.sendToPlayer(this.player);
        this.sentTeamCreates.add(scoreTitle);
    }
    
    private void setScore(String score, int value) {
        PacketPlayOutScoreboardScore scoreboardScorePacket = new PacketPlayOutScoreboardScore();
        this.setField((Packet)scoreboardScorePacket, "a", score);
        this.setField((Packet)scoreboardScorePacket, "b", this.objective.getName());
        this.setField((Packet)scoreboardScorePacket, "c", value);
        this.setField((Packet)scoreboardScorePacket, "d", 0);
        this.displayedScores.put(score, value);
        ((CraftPlayer)this.player).getHandle().playerConnection.sendPacket((Packet)scoreboardScorePacket);
    }
    
    private void removeScore(String score) {
        this.displayedScores.remove(score);
        this.scorePrefixes.remove(score);
        this.scoreSuffixes.remove(score);
        ((CraftPlayer)this.player).getHandle().playerConnection.sendPacket((Packet)new PacketPlayOutScoreboardScore(score));
    }
    
    private void updateScore(String score, String prefix, String suffix) {
        this.scorePrefixes.put(score, prefix);
        this.scoreSuffixes.put(score, suffix);
        new ScoreboardTeamPacketMod(score, prefix, suffix, null, 2).sendToPlayer(this.player);
    }
    
    private String[] separate(String line, Collection<String> usedBaseScores) {
        line = ChatColor.translateAlternateColorCodes('&', line);
        String prefix = "";
        String score = "";
        String suffix = "";
        this.separateScores.clear();
        this.separateScoreBuilder.setLength(0);
        for (int i = 0; i < line.length(); ++i) {
            char c = line.charAt(i);
            if (c == '*' || (this.separateScoreBuilder.length() == 16 && this.separateScores.size() < 3)) {
                this.separateScores.add(this.separateScoreBuilder.toString());
                this.separateScoreBuilder.setLength(0);
                if (c == '*') {
                    continue;
                }
            }
            this.separateScoreBuilder.append(c);
        }
        this.separateScores.add(this.separateScoreBuilder.toString());
        switch (this.separateScores.size()) {
            case 1: {
                score = this.separateScores.get(0);
                break;
            }
            case 2: {
                score = this.separateScores.get(0);
                suffix = this.separateScores.get(1);
                break;
            }
            case 3: {
                prefix = this.separateScores.get(0);
                score = this.separateScores.get(1);
                suffix = this.separateScores.get(2);
                break;
            }
            default: {
                Bukkit.getLogger().warning("Failed to separate scoreboard line. Input: " + line);
                break;
            }
        }
        if (usedBaseScores.contains(score)) {
            if (score.length() <= 14) {
                ChatColor[] values;
                for (int length = (values = ChatColor.values()).length, j = 0; j < length; ++j) {
                    ChatColor chatColor = values[j];
                    String possibleScore = chatColor + score;
                    if (!usedBaseScores.contains(possibleScore)) {
                        score = possibleScore;
                        break;
                    }
                }
                if (usedBaseScores.contains(score)) {
                    Bukkit.getLogger().warning("Failed to find alternate color code for: " + score);
                }
            }
            else {
                Bukkit.getLogger().warning("Found a scoreboard base collision to shift: " + score);
            }
        }
        if (prefix.length() > 16) {
            prefix = String.valueOf(ChatColor.DARK_RED.toString()) + ChatColor.BOLD + ">16";
        }
        if (score.length() > 16) {
            score = String.valueOf(ChatColor.DARK_RED.toString()) + ChatColor.BOLD + ">16";
        }
        if (suffix.length() > 16) {
            suffix = String.valueOf(ChatColor.DARK_RED.toString()) + ChatColor.BOLD + ">16";
        }
        usedBaseScores.add(score);
        this.prefixScoreSuffix[0] = prefix;
        this.prefixScoreSuffix[1] = score;
        this.prefixScoreSuffix[2] = suffix;
        return this.prefixScoreSuffix;
    }
}
