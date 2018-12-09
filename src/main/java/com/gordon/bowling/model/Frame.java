package com.gordon.bowling.model;


/**
 * Created by gordonwilkinson on 2018-12-08.
 */
public class Frame {
    private int pinCount1;
    private int pinCount2;
    private int pinCount3;
    private int strikeValue;

    boolean isSpareFrame;
    boolean isStrikeFrame;

    public Frame(int strikeValue) {
        this.strikeValue = strikeValue;
    }

    public boolean isStrikeFrame() {
        return pinCount1 == strikeValue;
    }

}
