package com.gordon.bowling.services;

import com.gordon.bowling.model.Frame;
import org.springframework.stereotype.Service;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */

@Service
public class GameService {
    private ScoreboardService scoreboardService;
    private ConsoleService consoleService;
    private int inputScores[][];

    private int gameScoreResult;


    public GameService(ConsoleService consoleService,
                       ScoreboardService scoreboardService) {
        this.consoleService = consoleService;
        this.scoreboardService = scoreboardService;
    }

    public void playGame() {
        System.out.println("Let's play!  Getting score inputs... ");
        inputScores = consoleService.getFrameScores(getInputScoreTemplate());

        if (inputScores.length < 1) return;
        processScores(inputScores);
    }

    public int getGameScoreResult() {
        gameScoreResult = scoreboardService.getGameScore();
        return gameScoreResult;
    }

    private int[][] getInputScoreTemplate() {
        int[][] scores = {
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0, 0}
        };
        return scores;
    }

    private Frame inputFrameScore(int pinCount1, int pinCount2, int pinCount3, int frameNumber) {
        return scoreboardService.addFrame(pinCount1, pinCount2, pinCount3, frameNumber);
    }

    private void processScores(int[][] frameScores) {
        int numFrames = frameScores.length;
        int lastFrameIdx = numFrames - 1;
        for (int frameCnt = 0; frameCnt < numFrames; frameCnt++) {
            int pinCount1 = frameScores[frameCnt][0];
            int pinCount2 = frameScores[frameCnt][1];
            int pinCount3 = 0;

            if (frameCnt == lastFrameIdx && frameScores[lastFrameIdx].length == 3) {
                pinCount3 = frameScores[lastFrameIdx][2];
            }

            Frame currentFrame = inputFrameScore(frameScores[frameCnt][0], frameScores[frameCnt][1], pinCount3, frameCnt);
            Frame parentFrame = currentFrame.getPrevious();

            if (parentFrame != null && parentFrame.isStrikeFrame()) {
                int bonusCount = 0;
                bonusCount = pinCount1;

                parentFrame.addBonusCount(bonusCount);

                if (frameCnt == lastFrameIdx) {
                    parentFrame.addBonusCount(pinCount2);
                }

                Frame grandParentFrame = parentFrame.getPrevious();
                if (grandParentFrame != null && grandParentFrame.isStrikeFrame()) {
                    grandParentFrame.addBonusCount(bonusCount);
                }
            }

            if (parentFrame != null && parentFrame.isSpareFrame()) {
                int bonusCount = pinCount1;
                parentFrame.addBonusCount(bonusCount);
                parentFrame = currentFrame.getPrevious();
            }
        }
    }

    private Frame assignBonusScore(int frameNumber) {
        return null;
    }

}
