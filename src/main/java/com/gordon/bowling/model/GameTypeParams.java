package com.gordon.bowling.model;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */
public enum GameTypeParams {
    TEN_PIN(10, 10, 10),
    FIVE_PIN(10, 5, 15);
    private int numFrames;
    private int numPins;
    private int strikeValue;

    GameTypeParams(int numFrames, int numPins, int strikeValue) {
        this.numFrames = numFrames;
        this.numPins = numPins;
        this.strikeValue = strikeValue;
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
}
