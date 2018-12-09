package com.gordon.bowling.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */

public class Scoreboard {
    private List<Frame> frames;

    public Scoreboard() {
        this.frames = new ArrayList<>();
    }

    public Frame addFrame(int pinCount1, int pinCount2, int pinCount3, int frameNumber) {

        Frame frame = new Frame(GameTypeParams.TEN_PIN.getStrikeValue());

        frame.setPinCount1(pinCount1);
        frame.setPinCount2(pinCount2);
        frame.setPinCount3(pinCount3);
        frames.add(frame);

        if (frames.size() > 1)  frame.setPrevious(frames.get(frames.size() - 2));

        return frame;
    }

    public Frame getframe(int frameNumber) {
        if (frames.isEmpty() || frameNumber > frames.size()) return null;
        return frames.get(frameNumber - 1);
    }

    public int getTotalFrameScore() {
        return frames.stream().mapToInt(Frame::getFrameScore).sum();
    }

}


