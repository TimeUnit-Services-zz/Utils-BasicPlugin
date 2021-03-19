package dev.rhco.utils.board.config;


import dev.rhco.utils.Utils;
import dev.rhco.utils.board.ScoreboardConfiguration;
import dev.rhco.utils.board.TitleGetter;
import dev.rhco.utils.providers.BoardProvider;
import dev.rhco.utils.utilities.CC;

public class ScoreboardProviders
{
    public static ScoreboardConfiguration create() {
        ScoreboardConfiguration configuration = new ScoreboardConfiguration();
        configuration.setTitleGetter(new TitleGetter(CC.translate(Utils.getInstance().getConfig().getString("SCOREBOARD.TITLE").replace("|", "┃"))));
        configuration.setScoreGetter(new BoardProvider());
        return configuration;
    }
}
