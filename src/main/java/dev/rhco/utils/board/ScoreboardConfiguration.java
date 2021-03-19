package dev.rhco.utils.board;

public class ScoreboardConfiguration
{
    private TitleGetter titleGetter;
    private ScoreGetter scoreGetter;
    
    public TitleGetter getTitleGetter() {
        return this.titleGetter;
    }
    
    public ScoreGetter getScoreGetter() {
        return this.scoreGetter;
    }
    
    public void setTitleGetter(TitleGetter titleGetter) {
        this.titleGetter = titleGetter;
    }
    
    public void setScoreGetter(ScoreGetter scoreGetter) {
        this.scoreGetter = scoreGetter;
    }
}
