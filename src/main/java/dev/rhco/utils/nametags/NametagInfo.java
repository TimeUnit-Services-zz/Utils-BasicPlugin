package dev.rhco.utils.nametags;


import dev.rhco.utils.board.ScoreboardTeamPacketMod;

import java.util.*;

public class NametagInfo
{
    private String name;
    private String prefix;
    private String suffix;
    private ScoreboardTeamPacketMod teamAddPacket;
    
	public NametagInfo(final String name, final String prefix, final String suffix) {
        this.name = name;
        this.prefix = prefix;
        this.suffix = suffix;
        this.teamAddPacket = new ScoreboardTeamPacketMod(name, prefix, suffix, new ArrayList(), 0);
    }
    
    @Override
    public boolean equals(final Object other) {
        if (other instanceof NametagInfo) {
            final NametagInfo otherNametag = (NametagInfo)other;
            return this.name.equals(otherNametag.name) && this.prefix.equals(otherNametag.prefix) && this.suffix.equals(otherNametag.suffix);
        }
        return false;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPrefix() {
        return this.prefix;
    }
    
    public String getSuffix() {
        return this.suffix;
    }
    
    public ScoreboardTeamPacketMod getTeamAddPacket() {
        return this.teamAddPacket;
    }
}
