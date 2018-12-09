package com.gordon.bowling.services;

import com.gordon.bowling.model.Frame;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */

public class GameService {
    private ScoreboardService scoreboardService;
    private ConsoleService consoleService;
    private int inputScores[][];

    public GameService(ConsoleService consoleService,
                       ScoreboardService scoreboardService) {
        this.consoleService = consoleService;
        this.scoreboardService = scoreboardService;
    }

    public void playGame() {
        System.out.println("Let's play!  Getting score inputs... ");
        inputScores = consoleService.getFrameScores();

        if (inputScores.length  < 1) return;

        processScores(inputScores);
    }

    public void inputFrameScores(int pinCount1, int pinCount2, int pinCount3, int frameNumber) {

    }

    public int getGameScore() {
        return 0;
    }

    public void processScores(int[][] frameScores) {

    }


    private Frame assignBonusScores(Frame frame) {
        return null;
    }

}
