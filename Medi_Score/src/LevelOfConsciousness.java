public enum LevelOfConsciousness {

    ALERT(0),
    CVPU(3);

    private int score;

    private LevelOfConsciousness(int score){
        this.score = score;
    }

    public int getScore(int score){
        return this.score;
    }
}
