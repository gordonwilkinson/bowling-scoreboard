package com.gordon.bowling.services;

import com.gordon.bowling.model.Frame;
import com.gordon.bowling.model.Scoreboard;
import org.springframework.stereotype.Service;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */
@Service
public class ScoreboardService {
    private Scoreboard scoreboard;

    public ScoreboardService(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    public Frame addFrame(int pinCount1, int pinCount2, int pinCount3, int frameNumber) {
        Frame frame = scoreboard.addFrame(pinCount1, pinCount2, pinCount3, frameNumber);
        return frame;
    }

    public Frame getFrame(int frameNumber) {
        return  scoreboard.getframe(frameNumber);
    }

    public int getGameScore() {
        return scoreboard.getTotalFrameScore();
    }

    public int getFrameScore(int frameNumber) {
        if (frameNumber < 1) return 0;
        Frame frame = scoreboard.getframe(frameNumber);
        return frame.getFrameScore();
    }

}
