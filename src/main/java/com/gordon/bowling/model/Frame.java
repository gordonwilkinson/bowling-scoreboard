package com.gordon.bowling.model;


/**
 * Created by gordonwilkinson on 2018-12-08.
 */
public class Frame {
    private int pinCount1;
    private int pinCount2;
    private int pinCount3;
    private int strikeValue;
    private int bonusCount;
    private Frame previous;

    private boolean isSpareFrame;
    private boolean isStrikeFrame;

    public Frame(int strikeValue) {
        this.strikeValue = strikeValue;
    }

    public boolean isStrikeFrame() {
        return pinCount1 == strikeValue;
    }

    public boolean isFinalFrame(int frameNumber) { return frameNumber == GameTypeParams.TEN_PIN.getNumFrames(); }

    public boolean isSpareFrame() {
        return ((pinCount2 > 0) && ((pinCount1 + pinCount2) == GameTypeParams.TEN_PIN.getStrikeValue()));
    }

    public void setPinCount1(int pinCount1) {
        this.pinCount1 = pinCount1;
    }

    public void setPinCount2(int pinCount2) {
        this.pinCount2 = pinCount2;
    }

    public void setPinCount3(int pinCount3) {
        this.pinCount3 = pinCount3;
    }

    public void addBonusCount(int bonusCount) {
        this.bonusCount += bonusCount;
    }

    public int getFrameScore() {
        return pinCount1 + pinCount2 + pinCount3 + bonusCount;
    }

    public void setPrevious(Frame previous) {
        this.previous = previous;
    }

    public Frame getPrevious() {
        return this.previous;
    }
}
