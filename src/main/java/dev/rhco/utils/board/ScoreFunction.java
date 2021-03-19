package dev.rhco.utils.board;

import dev.lazze.hcf.board.utils.TimeUtilsScoreboard;

public interface ScoreFunction<T>
{
    public static final ScoreFunction<Float> TIME_FANCY = value -> {
        if (value >= 60.0f) {
            return TimeUtilsScoreboard.formatIntoMMSS((int)(Object)value);
        }
        else {
            return String.valueOf(Math.round(10.0 * value) / 10.0) + "s";
        }
    };
    public static final ScoreFunction<Float> TIME_SIMPLE = value -> TimeUtilsScoreboard.formatIntoMMSS((int)(Object)value);

    String apply(final T p0);
}
