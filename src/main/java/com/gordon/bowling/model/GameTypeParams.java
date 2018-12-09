package com.gordon.bowling.model;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */
public enum GameTypeParams {
    TEN_PIN(10, 10, 10, 300),
    FIVE_PIN(10, 5, 15, 450);
    private int numFrames;
    private int numPins;
    private int strikeValue;
    private int perfectScore;

    GameTypeParams(int numFrames, int numPins, int strikeValue, int perfectScore) {
        this.numFrames = numFrames;
        this.numPins = numPins;
        this.strikeValue = strikeValue;
        this.perfectScore = perfectScore;
    }
    public int getNumFrames() {
        return numFrames;
    }

    public int getNumPins() {
        return numPins;
    }

    public int getStrikeValue() {
        return strikeValue;
    }

    public int getPerfectScore() { return perfectScore; }
}
