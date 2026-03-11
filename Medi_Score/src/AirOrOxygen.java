public enum AirOrOxygen {

    AIR(0),
    OXYGEN(2);

    private int score;

    private AirOrOxygen(int score){
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }
}
